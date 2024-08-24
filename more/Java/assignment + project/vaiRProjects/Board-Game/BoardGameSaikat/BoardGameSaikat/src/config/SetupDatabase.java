/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.JDBC.JDBCManager;

/**
 *
 * @author FURIOUS
 */
public class SetupDatabase {

    public SetupDatabase() {
        JDBCManager manager = new JDBCManager();
        manager.initSqliteConnection("bg.db");
        String sql = "DROP TABLE if EXISTS Player;";
        manager.dropTable(sql);
        sql = "DROP TABLE IF EXISTS game;";
        manager.dropTable(sql);
        sql = "DROP TABLE IF EXISTS GameCatagory;";
        manager.dropTable(sql);
        sql = "DROP TABLE IF EXISTS GameDesigner;";
        manager.dropTable(sql);
        sql = "DROP TABLE IF EXISTS PlayerPrefferedCatagory;";
        manager.dropTable(sql);
        sql = "DROP TABLE IF EXISTS PlayerPrefferedDesigner;";
        manager.dropTable(sql);
        sql = "DROP TABLE IF EXISTS PlayerPrefferedGame;";
        manager.dropTable(sql);
        sql = "DROP TABLE IF EXISTS bookmark;";
        manager.dropTable(sql);

        sql = "CREATE TABLE if not exists \"Game\" (\n"
                + "\"gameId\"  INTEGER NOT NULL,\n"
                + "\"gameName\"  varchar,\n"
                + "\"minPlayer\"  INTEGER,\n"
                + "\"maxPlayer\"  INTEGER,\n"
                + "\"optimalPlayer\"  INTEGER,\n"
                + "\"gameDesigner\"  INTEGER,\n"
                + "\"gameCatagory\"  INTEGER,\n"
                + "PRIMARY KEY (\"gameId\" ASC)\n"
                + ");";

        boolean flag = manager.createTable(sql);
        if (flag == true) {
            System.err.println("Table 'Game' created successfully.");
        }
        sql = "CREATE TABLE if not exists \"GameDesigner\" (\n"
                + "\"designerId\"  INTEGER NOT NULL,\n"
                + "\"designerName\"  varchar,\n"
                + "PRIMARY KEY (\"designerId\")\n"
                + ");";
        flag = manager.createTable(sql);
        if (flag == true) {
            System.err.println("Table 'GameDesigner' created successfully.");
        }
        sql = "CREATE TABLE if not exists \"GameCatagory\" (\n"
                + "\"catagoryId\"  INTEGER,\n"
                + "\"catagoryName\"  varchar,\n"
                + "PRIMARY KEY (\"catagoryId\")\n"
                + ");";
        flag = manager.createTable(sql);
        if (flag == true) {
            System.err.println("Table 'GameCatagory' created successfully.");
        }

        sql = "CREATE TABLE if not exists \"Player\" (\n"
                + "\"playerId\"  INTEGER NOT NULL,\n"
                + "\"playerName\"  varchar NOT NULL,\n"
                + "\"email\"  varchar NOT NULL,\n"
                + "\"location\"  varchar NOT NULL,\n"
                + "\"fromTime\"  varchar NOT NULL,\n"
                + "\"optimalNumber\"  Boolean NOT NULL,\n"
                + "\"toTime\"  varchar NOT NULL,\n"
                + "\"password\"  varchar NOT NULL,\n"
                + "PRIMARY KEY (\"playerId\")\n"
                + ");";
        flag = manager.createTable(sql);
        if (flag == true) {
            System.err.println("Table 'Player' created successfully.");
        }

        sql = "CREATE TABLE if not exists \"PlayerPrefferedCatagory\" (\n"
                + "\"playerId\"  INTEGER NOT NULL,\n"
                + "\"catagoryId\"  INTEGER NOT NULL,\n"
                + "PRIMARY KEY (\"playerId\", \"catagoryId\"),\n"
                + "CONSTRAINT \"fk_player_catagory_1\" FOREIGN KEY (\"playerId\") REFERENCES \"Player\" (\"playerId\"),\n"
                + "CONSTRAINT \"fk_user_catagory_2\" FOREIGN KEY (\"catagoryId\") REFERENCES \"GameCatagory\" (\"catagoryId\")\n"
                + ");";
        flag = manager.createTable(sql);
        if (flag == true) {
            System.err.println("Table 'PlayerPrefferedCatagory' created successfully.");
        }

        sql = "CREATE TABLE if not exists \"PlayerPrefferedGame\" (\n"
                + "\"playerId\"  INTEGER NOT NULL,\n"
                + "\"gameId\"  INTEGER NOT NULL,\n"
                + "PRIMARY KEY (\"playerId\", \"gameId\"),\n"
                + "CONSTRAINT \"fkid_player_game_1\" FOREIGN KEY (\"playerId\") REFERENCES \"Player\" (\"playerId\"),\n"
                + "CONSTRAINT \"fkid_player_game_2\" FOREIGN KEY (\"gameId\") REFERENCES \"game\" (\"gameId\")\n"
                + ");";
        flag = manager.createTable(sql);
        if (flag == true) {
            System.err.println("Table 'PlayerPrefferedGame' created successfully.");
        }

        sql = "CREATE TABLE if not exists \"PlayerPrefferedDesigner\" (\n"
                + "\"playerId\"  INTEGER NOT NULL,\n"
                + "\"designerId\"  INTEGER NOT NULL,\n"
                + "PRIMARY KEY (\"playerId\", \"designerId\"),\n"
                + "CONSTRAINT \"fk_player_preffered_designer_1\" FOREIGN KEY (\"playerId\") REFERENCES \"Player\" (\"playerId\"),\n"
                + "CONSTRAINT \"fk_player_preffered_designer_2\" FOREIGN KEY (\"designerId\") REFERENCES \"GameDesigner\" (\"designerId\")\n"
                + ");";
        flag = manager.createTable(sql);
        if (flag == true) {
            System.err.println("Table 'PlayerPrefferedDesigner' created successfully.");
        }

        sql = "CREATE TABLE if not exists \"bookmark\" (\n"
                + "\"bookmarkId\"  INTEGER NOT NULL,\n"
                + "\"bookmarkTitle\"  varchar NOT NULL,\n"
                + "\"bookmarkSql\"  varchar NOT NULL,\n"
                + "\"playerId\"  INTEGER NOT NULL,\n"
                + "PRIMARY KEY (\"bookmarkId\")\n"
                + ");";
        flag = manager.createTable(sql);
        if (flag == true) {
            System.err.println("Table 'PlayerPrefferedDesigner' created successfully.");
        }
    }
}
