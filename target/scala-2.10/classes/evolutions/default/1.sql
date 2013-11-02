# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table game (
  game_type                 varchar(31) not null,
  id                        integer auto_increment not null,
  game_title                varchar(255),
  game_status               varchar(255),
  open_balance              double,
  virtual_start_date        datetime,
  virtual_current_date      datetime,
  max_players               integer,
  game_length               integer,
  virtual_days_skipped      integer,
  added_on                  datetime,
  real_start_time           datetime,
  owner_id                  integer,
  winning_amount            integer,
  constraint pk_game primary key (id))
;

create table game_player (
  id                        integer auto_increment not null,
  current_balance           double,
  joined_at                 datetime,
  game_id                   integer,
  user_id                   integer,
  constraint pk_game_player primary key (id))
;

create table GAME_TXN_HISTORY (
  id                        integer auto_increment not null,
  transaction_type          varchar(255),
  stock_ticker              varchar(255),
  volume                    integer,
  amount_paid               double,
  virtual_date              datetime,
  real_date                 datetime,
  player_id                 integer,
  game_id                   integer,
  constraint pk_GAME_TXN_HISTORY primary key (id))
;

create table PORTFOLIO_STOCK (
  id                        integer auto_increment not null,
  user_id                   integer,
  game_id                   integer,
  quantity                  integer,
  virtual_added_on          datetime,
  real_added_on             datetime,
  player_id                 integer,
  stock_id                  integer,
  constraint pk_PORTFOLIO_STOCK primary key (id))
;

create table STOCK (
  id                        integer auto_increment not null,
  company_name              varchar(255),
  ticker                    varchar(255),
  added_on                  datetime,
  last_updated              datetime,
  is_enabled                integer,
  constraint pk_STOCK primary key (id))
;

create table STOCK_PRICE (
  id                        integer auto_increment not null,
  date                      datetime,
  open                      double,
  high                      double,
  low                       double,
  close                     double,
  stock_id                  integer,
  constraint pk_STOCK_PRICE primary key (id))
;

create table user (
  account_type              varchar(31) not null,
  id                        integer auto_increment not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  is_enabled                integer,
  constraint pk_user primary key (id))
;

alter table game add constraint fk_game_owner_1 foreign key (owner_id) references user (id) on delete restrict on update restrict;
create index ix_game_owner_1 on game (owner_id);
alter table game_player add constraint fk_game_player_game_2 foreign key (game_id) references game (id) on delete restrict on update restrict;
create index ix_game_player_game_2 on game_player (game_id);
alter table game_player add constraint fk_game_player_user_3 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_game_player_user_3 on game_player (user_id);
alter table GAME_TXN_HISTORY add constraint fk_GAME_TXN_HISTORY_player_4 foreign key (player_id) references game_player (id) on delete restrict on update restrict;
create index ix_GAME_TXN_HISTORY_player_4 on GAME_TXN_HISTORY (player_id);
alter table GAME_TXN_HISTORY add constraint fk_GAME_TXN_HISTORY_game_5 foreign key (game_id) references game (id) on delete restrict on update restrict;
create index ix_GAME_TXN_HISTORY_game_5 on GAME_TXN_HISTORY (game_id);
alter table PORTFOLIO_STOCK add constraint fk_PORTFOLIO_STOCK_player_6 foreign key (player_id) references game_player (id) on delete restrict on update restrict;
create index ix_PORTFOLIO_STOCK_player_6 on PORTFOLIO_STOCK (player_id);
alter table PORTFOLIO_STOCK add constraint fk_PORTFOLIO_STOCK_stock_7 foreign key (stock_id) references STOCK (id) on delete restrict on update restrict;
create index ix_PORTFOLIO_STOCK_stock_7 on PORTFOLIO_STOCK (stock_id);
alter table STOCK_PRICE add constraint fk_STOCK_PRICE_stock_8 foreign key (stock_id) references STOCK (id) on delete restrict on update restrict;
create index ix_STOCK_PRICE_stock_8 on STOCK_PRICE (stock_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table game;

drop table game_player;

drop table GAME_TXN_HISTORY;

drop table PORTFOLIO_STOCK;

drop table STOCK;

drop table STOCK_PRICE;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

