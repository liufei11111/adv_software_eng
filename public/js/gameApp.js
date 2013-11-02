var gameApp = angular.module('gameApp', ['ngRoute']);
var statuses = {
    wait: "CREATED"
    , start: "STARTED"
    , end: "END"
    , canceled: "CANCELED"
};

var STATUS_REFRESH = 2000;
var STOCK_REFRESH = 15000;
gameApp.config(function($routeProvider) {
    $routeProvider.
            when('/start', {controller: StartCtrl, template: $('#startScreen').html()})
            .when('/play', {controller: PlayCtrl, template: $('#playScreen').html()})
            .when('/end', {controller: EndCtrl, template: $('#endScreen').html()})
            .when('/canceled', {controller: CanceledCtrl, template: $('#cancelScreen').html()})
            .when('/left', {controller: LeaveCtrl, template: $('#leaveScreen').html()})
            //when('/new', {controller: CreateCtrl, template: $('#ItemForm').html()}).
            .otherwise({redirectTo: '/start'});
}).factory('gameService', function() {
    var myGameState = gameState;
    var redirect = function(status, $location) {
        if (status === statuses.wait) {
            $location.path("/start");
        } else if (status === statuses.start) {
            $location.path("/play");
        } else if (status === statuses.end) {
            $location.path("/end");
        } else if (status === statuses.canceled) {
            $location.path("/canceled");
        }
    };

    var gameStateUpdated = function(oldGameState, newGameState, $scope, $location) {
        var oldStatus = oldGameState.gameStatus;
        var oldPlayerList = oldGameState.players;
        //check changes in players 
        //who left game
        for (var playerId in oldPlayerList) {
            if (oldPlayerList.hasOwnProperty(playerId) && !newGameState.players.hasOwnProperty(playerId)) {
                var oldPlayer = oldPlayerList[playerId];
                createToast("<b>" + oldPlayer.firstName + "</b> left game!", 'danger', false);
            }
        }

        //who joined game
        for (var playerId in newGameState.players) {
            if (newGameState.players.hasOwnProperty(playerId) && !oldPlayerList.hasOwnProperty(playerId)) {
                var newPlayer = newGameState.players[playerId];
                createToast("<b>" + newPlayer.firstName + "</b> has joined game!", 'success', false);
            }
        }

        //check change in old status
        if (newGameState.gameStatus !== oldStatus) {
            //if game state changed then set $scope refres to false.
            $scope.refresh = false;
            redirect(newGameState.gameStatus, $location);
        }

        var myPlayerId = newGameState.currentPlayer.id;
        var oldRank = oldGameState.players[myPlayerId].rank;
        var newRank = newGameState.players[myPlayerId].rank;
        if (newRank !== oldRank) {
            createToast("You have moved to " + numAsPosition(newRank) + " position", 'info', false);
        }

        if ($scope.stockToSell !== undefined && $scope.stockToSell.hasOwnProperty('ticker')) {
            for (var i = 0; i < newGameState.myPortfolio.length; i++) {
                console.log("checkinnnnnn");
                if (newGameState.myPortfolio[i].ticker === $scope.stockToSell.ticker) {
                    $scope.stockToSell.currentPrice = newGameState.myPortfolio[i].currentPrice;
                    break;
                }
            }
        }

        $scope.$apply();
    };

    var hasLeftGame = false;
    var sysAppName = appName;


    return {
        getGameState: function() {
            return myGameState;
        },
        objCount: function(obj) {
            return Object.keys(obj).length;
        },
        formatMoney: function(amt) {
            return currencyFormat(amt);
        },
        startGame: function($scope, $location) {
            $('#gamePanel').mask("Initializing, please wait...");
            $.post(gameRoutes.start, function(newState) {
                myGameState = newState;
                $scope.gameState = newState;
                console.log("New state has been gotten!" + newState.gameStatus);
                //redirect(newState.gameStatus, $location);
                $location.path("/play");
                $scope.$apply();
            });

            $(document).ajaxComplete(function() {
                $('#gamePanel').unmask();
            });
        },
        leaveGame: function($scope, $location) {
            $('#gamePanel').mask("Sending request...");
            $scope.refresh = false;
            $.post(gameRoutes.leave, function(newState) {
                myGameState = newState;
                $scope.gameState = newState;
                hasLeftGame = true;
                $location.path("/left");
                $scope.$apply();
            });
            $(document).ajaxComplete(function() {
                $('#gamePanel').unmask();
            });
        },
        cancelGame: function($scope, $location) {
            $('#gamePanel').mask("Canceling...");
            $.post(gameRoutes.cancel, function(newState) {
                myGameState = newState;
                $location.href("/canceled");
                $scope.refresh = false;
                $scope.$apply();
            });
            $(document).ajaxComplete(function() {
                $('#gamePanel').unmask();
            });
        },
        redirectByStatus: redirect,
        getHasLeftGame: function() {
            return hasLeftGame;
        },
        gameStateReload: function($scope, $location) {
            $.post(gameRoutes.refresh, function(state) {
                //console.log("Status reloaded...");
                $scope.gameState = state;
                var oldState = angular.copy(myGameState);
                myGameState = state;
                gameStateUpdated(oldState, state, $scope, $location);
                //$scope.$apply();
            });
        },
        getAppName: function() {
            return sysAppName;
        },
        setGameState: function(newState, $scope) {
            var oldGs = angular.copy(myGameState);
            myGameState = newState;
            gameStateUpdated(oldGs, newState, $scope);
        },
        playersAsArray: function() {
            var players = [];
            for (var id in myGameState.players) {
                players.push(myGameState.players[id]);
            }
            return players;
        }

    };
}).factory('stockService', function() {
    var stockList = availableStocks;
    var pricesCache = {};

    var findStockByTicker = function(ticker) {
        for (var i in stockList) {
            if (stockList.hasOwnProperty(i) && stockList[i].ticker === ticker) {
                return stockList[i];
            }
        }
    };

    var displayChart = function(ticker, data, $scope) {
        var stock = findStockByTicker(ticker);
        if (stock !== undefined) {
            $scope.stockHistoryTitle = stock.company + " Price List";
        } else {
            $scope.stockHistoryTitle = "Pricing History";
        }

        $('#chartModal').modal('show');
        $scope.$apply();
        createChart($scope.stockHistoryTitle, $('#chartContainer'), data);
    };

    return {
        getAvailableStockList: function() {
            return stockList;
        },
        pricesReload: function($scope) {
            $.getJSON(gameRoutes.stockList, function(newStocks) {
                stockList = newStocks;
                $scope.stockList = newStocks;
                if ($scope.selectedStock !== undefined && $scope.selectedStock.hasOwnProperty('ticker')) {
                    stock = findStockByTicker($scope.selectedStock.ticker);
                    $scope.selectedStock.price = stock.price;
                }
                $scope.$apply();
            });
        },
        buyStock: function($scope, gameService, $location) {
            var selectedStock = $scope.selectedStock;
            $('#buyStockModal').mask("Purchase in progress...");
            $.post(gameRoutes.buyStock, selectedStock, function(newState) {
                $scope.gameState = newState;
                gameService.setGameState(newState, $scope, $location);
                $('#buyStockModal').modal('hide');
                //$scope.$apply();
            });

            $(document).ajaxComplete(function(event, xhr, settings) {
                if (xhr.status !== 200 && settings.url === gameRoutes.buyStock) {
                    alert("Could not make purchase, an error occured.");
                }
                $('#buyStockModal').unmask();
            });
        }

        , sellStock: function($scope, gameService, $location) {
            var selectedStock = angular.copy($scope.stockToSell);
            selectedStock.quantity = selectedStock.quantityToSell;
            selectedStock.price = selectedStock.currentPrice;
            $('#sellStockModal').mask("Transaction in progress...");
            $.post(gameRoutes.sellStock, selectedStock, function(newState) {
                $scope.gameState = newState;
                gameService.setGameState(newState, $scope, $location);
                $('#sellStockModal').modal('hide');
                //$scope.$apply();
            });

            $(document).ajaxComplete(function(event, xhr, settings) {
                if (xhr.status !== 200 && settings.url === gameRoutes.sellStock) {
                    alert("Could not complete transaction");
                }
                $('#sellStockModal').unmask();
            });
        }
        , showHistory: function(ticker, $scope) {
            var cacheKey = $scope.gameState.currentGameDay + "_" + ticker;
            if (pricesCache.hasOwnProperty(cacheKey)) {
                displayChart(ticker, pricesCache[cacheKey], $scope);
                return;
            }
            $('#gamePanel .stockList').mask("Loading prices, please wait...");
            var path = gameRoutes.priceList.replace("_TICKER_", ticker);
            $.getJSON(path, function(data) {
                pricesCache[cacheKey] = data;
                displayChart(ticker, data, $scope);
            });

            $(document).ajaxComplete(function() {
                $('#gamePanel .stockList').unmask();
            });
        }
    };
});

function StartCtrl($scope, $location, gameService, $timeout) {
    $scope.gameState = gameService.getGameState();
    $scope.refresh = true;
    $scope.appName = gameService.getAppName();
    if ($scope.gameState.gameStatus !== statuses.wait) {
        gameService.redirectByStatus($scope.gameState.gameStatus, $location);
        return;
    }

    $('#sharePanel').show();
    $scope.start = function() {
        if ($scope.iAmOwner()) {
            gameService.startGame($scope, $location);
        }
    };

    $scope.cancel = function() {
        if ($scope.iAmOwner()) {
            gameService.cancelGame($scope, $location);
        }
    };
    $scope.iAmOwner = function() {
        if ($scope.gameState.currentPlayer !== undefined)
            return $scope.gameState.owner.id === $scope.gameState.currentPlayer.id;
    };

    $scope.format = function(amt) {
        return gameService.formatMoney(amt);
    };


    $scope.reloadGameStatus = function() {
        gameService.gameStateReload($scope, $location);
        if ($scope.refresh) {
            $timeout($scope.reloadGameStatus, STATUS_REFRESH, false);
        }
    };

    $scope.count = function(obj) {
        return gameService.objCount(obj);
    };

    $scope.leave = function() {
        return gameService.leaveGame($scope, $location);
    };


    $scope.reloadGameStatus();
}


function LeaveCtrl($scope, $location, gameService) {
    $scope.gameState = gameService.getGameState();
    $scope.appName = gameService.getAppName();
    console.log("Current State: " + $scope.gameState);
    if (!gameService.getHasLeftGame()) {
        gameService.redirectByStatus($scope.gameState.gameStatus, $location);
    }


}


function EndCtrl($scope, $location, gameService) {
    $scope.appName = gameService.getAppName();
    $scope.gameState = gameService.getGameState();
    if ($scope.gameState.gameStatus !== statuses.end) {
        gameService.redirectByStatus($scope.gameState.gameStatus, $location);
        return;
    }

    $scope.playersArray = function() {
        return gameService.playersAsArray();
    };
    $scope.pos = function(rank) {
        return numAsPosition(rank);
    };
}

function PlayCtrl($scope, $location, $timeout, gameService, stockService) {
    $scope.appName = gameService.getAppName();
    $scope.gameState = gameService.getGameState();
    $scope.showChart = false;
    $scope.refresh = true;
    $scope.selectedStock = {};
    $scope.stockToSell = {};
    if ($scope.gameState.gameStatus !== statuses.start) {
        gameService.redirectByStatus($scope.gameState.gameStatus, $location);
        return;
    }
    $('#sharePanel').hide();
    $scope.reloadGameStatus = function() {
        gameService.gameStateReload($scope, $location);
        if ($scope.refresh) {
            $timeout($scope.reloadGameStatus, STATUS_REFRESH, false);
        }
    };

    $scope.stockReload = function() {
        stockService.pricesReload($scope);
        if ($scope.refresh) {
            $timeout($scope.stockReload, STOCK_REFRESH, false);
        }
    };

    $scope.stockList = stockService.getAvailableStockList();
    $scope.showHistory = function(ticker) {
        $scope.showChart = true;
        stockService.showHistory(ticker, $scope);
    };

    $scope.format = function(amt) {
        return gameService.formatMoney(amt);
    };

    $scope.pos = function(rank) {
        return numAsPosition(rank);
    };

    $scope.buy = function(stock) {
        $scope.selectedStock = stock;
        $scope.selectedStock.quantity = 1;
        $timeout(function() {
            $('#buyStockModal').modal('show');
        }, 200);
    };

    $scope.sell = function(stock) {
        $scope.stockToSell = stock;
        $scope.stockToSell.quantityToSell = 1;
        $timeout(function() {
            $('#sellStockModal').modal('show');
        }, 200);
    };

    $scope.buyStock = function() {
        stockService.buyStock($scope, gameService, $location);
    };

    $scope.sellStock = function() {
        stockService.sellStock($scope, gameService, $location);
    };

    $scope.computeNetWorth = function() {
        var val = $scope.gameState.myAccount.currentBalance;
        for (var i = 0; i < $scope.gameState.myPortfolio.length; i++) {
            val += $scope.gameState.myPortfolio[i].currentPrice * $scope.gameState.myPortfolio[i].quantity;
        }
        return val;
    };

    $scope.playersArray = function() {
        return gameService.playersAsArray();
    };
    $scope.reloadGameStatus();
    $scope.stockReload();
}


function CanceledCtrl($scope, $location, gameService) {
    $scope.gameState = gameService.getGameState();
    $scope.appName = gameService.getAppName();
    if ($scope.gameState.gameStatus !== statuses.canceled) {
        gameService.redirectByStatus($scope.gameState.gameStatus, $location);
    }

}
function createToast(message, t, stick) {
    $.toast.config.align = 'right';
    var options = {
        duration: 5000,
        sticky: stick,
        type: t
    };

    $.toast(message, options);
}


function numAsPosition(num) {
    var determiner = num > 20 ? num % 10 : num;
    if (determiner === 1) {
        return num + "st";
    } else if (determiner === 2) {
        return num + "nd";
    } else if (determiner === 3) {
        return num + "rd";
    } else {
        return num + "th";
    }
}
function createChart(stockName, container, data) {
    container.highcharts('StockChart', {
        rangeSelector: {
            selected: 1
        },
        title: {
            text: stockName
        },
        series: [{
                type: 'candlestick',
                name: stockName,
                data: data,
                dataGrouping: {
                    units: [
                        ['week', // unit name
                            [1] // allowed multiples
                        ], [
                            'month',
                            [1, 2, 3, 4, 6]]
                    ]
                }
            }]
    });
}