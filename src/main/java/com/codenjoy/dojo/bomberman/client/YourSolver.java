package com.codenjoy.dojo.bomberman.client;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2016 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import com.codenjoy.dojo.client.Direction;
import com.codenjoy.dojo.client.Solver;
import com.codenjoy.dojo.client.WebSocketRunner;
import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.RandomDice;

import java.util.*;

/**
 * User: your name
 */
public class YourSolver implements Solver<Board> {

    private static final String USER_NAME = "melalex490@gmail.com";
    private static String UP = "up";
    private static String DOWN = "down";
    private static String RIGHT = "right";
    private static String LEFT = "left";

    private Dice dice;
    private Board board;

    public YourSolver(Dice dice) {
        this.dice = dice;
    }

    @Override
    public String get(Board board) {
        this.board = board;

        if (board.isGameOver()) {
            return "";
        }


        return "up";
    }

    private Map<String, Integer> getPriority(Board board) {
        Map<String, Integer> priority = new HashMap<>();

        Point me = board.getBomberman();
        List<Point> able = new ArrayList<>();


//        able.add();

        Collection<Point> bombs = board.getBombs();



    }

//    private Map<String, Point> ablePoints(Point me) {
//        Map<String, Point> result = new HashMap<>();
//
//        result.put("left", me.copy().move(me.getX() - 1, me.getY()));
//        result.put("left", me.copy().move(me.getX() - 1, me.getY()));
//        result.put("left", me.copy().move(me.getX() - 1, me.getY()));
//        result.put("left", me.copy().move(me.getX() - 1, me.getY()));
//
//        return result;
//    }



    private Point moveLeft(Point point) {
        Point result = point.copy();
        result.move(point.getX() - 1, point.getY());
        return result;
    }

    private Point moveRight(Point point) {
        Point result = point.copy();
        result.move(point.getX() + 1, point.getY());
        return result;
    }

    private Point moveUp(Point point) {
        Point result = point.copy();
        result.move(point.getX(), point.getY() + 1);
        return result;
    }

    private Point moveDown(Point point) {
        Point result = point.copy();
        result.move(point.getX(), point.getY() - 1);
        return result;
    }

    public static void main(String[] args) {
        WebSocketRunner.runOnServer("10.17.166.91:8080", // to use for local server
//        WebSocketRunner.run(WebSocketRunner.Host.REMOTE,  // to use for codenjoy.com server
                USER_NAME,
                new YourSolver(new RandomDice()),
                new Board());
    }

}
