package ncedu.steam.dummyGame;

import ncedu.steam.steamLib.Steam;

/**
 * DummyGame
 * User: aielemental
 * Date: 29.03.13
 * Time: 13:14
 */
//todo add description
public class DummyGame {
    public static final String TITLE = "DummyGame";

    public static void main(String[] args) {
        boolean owns = Steam.checkOwnage(TITLE);
        if (owns) {
            System.out.println("verified!");
        } else {
            System.out.println("No license found. Buy this game to play.");
        }
    }
}
