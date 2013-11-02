package models.data;

import com.avaje.ebean.Ebean;
import enums.GameStatusEnum;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import play.data.validation.Constraints;
import play.db.ebean.Model;

/**
 * Game entity bean.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "game_type", discriminatorType = DiscriminatorType.STRING)
public class Game extends Model {

    private static final long serialVersionUID = 1L;

    @Id
    @Constraints.Required
    private Integer id;

    @Constraints.Required
    private String gameTitle;

    @Constraints.Required
    private String gameStatus;
    private Double openBalance;

    private Timestamp virtualStartDate;
    private Timestamp virtualCurrentDate;

    private Integer maxPlayers;

    private Integer gameLength;
    private Integer virtualDaysSkipped = 0;

    @Constraints.Required
    private Timestamp addedOn;

    private Timestamp realStartTime;

    @ManyToOne
    private Player owner;

    @OneToMany
    private List<GameTxnHistory> historys;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "game_id")
    private List<GamePlayer> players;

    /**
     * Return id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set id.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Return game title.
     */
    public String getGameTitle() {
        return gameTitle;
    }

    /**
     * Set game title.
     */
    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    /**
     * Return game status.
     */
    public String getGameStatus() {
        return gameStatus;
    }

    /**
     * Set game status.
     */
    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }


    /**
     * Return virtual start date.
     */
    public Timestamp getVirtualStartDate() {
        return virtualStartDate;
    }

    /**
     * Set virtual start date.
     */
    public void setVirtualStartDate(Timestamp virtualStartDate) {
        this.virtualStartDate = virtualStartDate;
    }

    /**
     * Return max players.
     */
    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public Integer getVirtualDaysSkipped() {
        return virtualDaysSkipped;
    }

    public void setVirtualDaysSkipped(Integer virtualDaysSkipped) {
        this.virtualDaysSkipped = virtualDaysSkipped;
    }

    /**
     * Set max players.
     */
    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    /**
     * Return added on.
     */
    public Timestamp getAddedOn() {
        return addedOn;
    }

    /**
     * Set added on.
     */
    public void setAddedOn(Timestamp addedOn) {
        this.addedOn = addedOn;
    }

    /**
     * Return real start time.
     */
    public Timestamp getRealStartTime() {
        return realStartTime;
    }

    /**
     * Set real start time.
     */
    public void setRealStartTime(Timestamp realStartTime) {
        this.realStartTime = realStartTime;
    }

    /**
     * Return owner.
     */
    public User getOwner() {
        return owner;
    }

    /**
     * Set owner.
     */
    public void setOwner(Player owner) {
        this.owner = owner;
    }

    /**
     * Return historys.
     */
    public List<GameTxnHistory> getHistorys() {
        return historys;
    }

    /**
     * Set historys.
     */
    public void setHistorys(List<GameTxnHistory> historys) {
        this.historys = historys;
    }

    /**
     * Return players.
     */
    public List<GamePlayer> getPlayers() {
        return players;
    }

    /**
     * Set players.
     */
    public void setPlayers(List<GamePlayer> players) {
        this.players = players;
    }

    public Timestamp getVirtualCurrentDate() {
        return virtualCurrentDate;
    }

    public void setVirtualCurrentDate(Timestamp virtualCurrentDate) {
        this.virtualCurrentDate = virtualCurrentDate;
    }

    /**
     * Return game length.
     */
    public Integer getGameLength() {
        return gameLength;
    }

    /**
     * Set game length.
     */
    public void setGameLength(Integer gameLength) {
        this.gameLength = gameLength;
    }

    public static Finder<String, Game> find = new Finder<String, Game>(String.class, Game.class);

    /**
     * Retrieve a User from email.
     */
    public static Game findById(int id) {
        return find.where().eq("id", id).findUnique();
    }

    /**
     * Check if a player can still join a game
     *
     * @param player
     * @return
     */
    public boolean canJoinGame(User player) {
        if (gameStatus.equals(enums.GameStatusEnum.CREATED.toString())) {
            return true;
        }

        return (gameStatus.equals(enums.GameStatusEnum.STARTED.toString()) || gameStatus.equals(enums.GameStatusEnum.END.toString())) && playerInGame(player);
    }

    /**
     * A player can still join a game
     *
     * @param player
     * @return
     */
    public GamePlayer joinGame(User player) {
        if (playerInGame(player)) {
            return null;
        }

        if (players.size() >= maxPlayers) {
            return null;
        }
        GamePlayer gamePlayer = new GamePlayer();
        gamePlayer.setCurrentBalance(openBalance);
        gamePlayer.setGame(this);
        gamePlayer.setJoinedAt(new Timestamp(System.currentTimeMillis()));
        gamePlayer.setUser((Player) player);
        players.add(gamePlayer);
        Ebean.save(players);
        return gamePlayer;
    }

    /**
     * This is used when a player wishes to leave a game. It will return false
     * if a player has already exited the game and tries to exit again. It will
     * return true when a player successfully exits a game.
     *
     * @param player
     * @return
     */
    public boolean leaveGame(User player) {
        if (playerInGame(player)) {
            GamePlayer gamePlayer = getPlayerInGame(player);
            Ebean.delete(GamePlayer.class, gamePlayer.getId());
                //play.Logger.info("Player in Game: "+gamePlayer);
            //players.remove(gamePlayer);
            //Ebean.save(players);
            Ebean.refreshMany(this, "players");
            return true;
        }
        return false;

    }

    /**
     * This method checks if a player is in the game
     *
     * @param player
     * @return
     */
    public boolean playerInGame(User player) {
        for (GamePlayer gamePlayer : players) {
            if (gamePlayer.getUser().equals(player)) {
                return true;
            }
        }

        return false;
    }

    /**
     * This method returns the player in the game
     *
     * @param player
     * @return
     */
    public GamePlayer getPlayerInGame(User player) {
        for (GamePlayer gamePlayer : players) {
            if (gamePlayer.getUser().equals(player)) {
                return gamePlayer;
            }
        }
        return null;
    }

    public boolean isStarted() {
        return gameStatus.equals(enums.GameStatusEnum.STARTED.toString());
    }

    public boolean isEnded() {
        return gameStatus.equals(enums.GameStatusEnum.END.toString());
    }

    public Double getOpenBalance() {
        return openBalance;
    }

    public void setOpenBalance(Double openBalance) {
        this.openBalance = openBalance;
    }

    
    public boolean cancelGame(){
        if(gameStatus.equals(GameStatusEnum.CREATED.toString())){
            setGameStatus(GameStatusEnum.CANCELED.toString());
            save();
            return true;
        }else{
            return false;
        }
    }
}
