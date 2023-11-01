package com.owen.macropadgui.handlers;

import commands.MediaKeys;
import javafx.util.Pair;

import java.util.ArrayList;

import static java.awt.event.KeyEvent.*;

public class KeyPressHandler {
    public static ArrayList<Pair<Integer, Integer>> convertStringToKeyCode(ArrayList<String> inputList) {
        ArrayList<Pair<Integer, Integer>> keyCodeList = new ArrayList<>();
        for (String s : inputList) {
            s = s.toUpperCase();
            switch (s) {
                case "A" -> keyCodeList.add(new Pair<>(VK_A, null));
                case "B" -> keyCodeList.add(new Pair<>(VK_B, null));
                case "C" -> keyCodeList.add(new Pair<>(VK_C, null));
                case "D" -> keyCodeList.add(new Pair<>(VK_D, null));
                case "E" -> keyCodeList.add(new Pair<>(VK_E, null));
                case "F" -> keyCodeList.add(new Pair<>(VK_F, null));
                case "G" -> keyCodeList.add(new Pair<>(VK_G, null));
                case "H" -> keyCodeList.add(new Pair<>(VK_H, null));
                case "I" -> keyCodeList.add(new Pair<>(VK_I, null));
                case "J" -> keyCodeList.add(new Pair<>(VK_J, null));
                case "K" -> keyCodeList.add(new Pair<>(VK_K, null));
                case "L" -> keyCodeList.add(new Pair<>(VK_L, null));
                case "M" -> keyCodeList.add(new Pair<>(VK_M, null));
                case "N" -> keyCodeList.add(new Pair<>(VK_N, null));
                case "O" -> keyCodeList.add(new Pair<>(VK_O, null));
                case "P" -> keyCodeList.add(new Pair<>(VK_P, null));
                case "Q" -> keyCodeList.add(new Pair<>(VK_Q, null));
                case "R" -> keyCodeList.add(new Pair<>(VK_R, null));
                case "S" -> keyCodeList.add(new Pair<>(VK_S, null));
                case "T" -> keyCodeList.add(new Pair<>(VK_T, null));
                case "U" -> keyCodeList.add(new Pair<>(VK_U, null));
                case "V" -> keyCodeList.add(new Pair<>(VK_V, null));
                case "W" -> keyCodeList.add(new Pair<>(VK_W, null));
                case "X" -> keyCodeList.add(new Pair<>(VK_X, null));
                case "Y" -> keyCodeList.add(new Pair<>(VK_Y, null));
                case "Z" -> keyCodeList.add(new Pair<>(VK_Z, null));
                case "`" -> keyCodeList.add(new Pair<>(VK_BACK_QUOTE, null));
                case "0" -> keyCodeList.add(new Pair<>(VK_0, null));
                case "1" -> keyCodeList.add(new Pair<>(VK_1, null));
                case "2" -> keyCodeList.add(new Pair<>(VK_2, null));
                case "3" -> keyCodeList.add(new Pair<>(VK_3, null));
                case "4" -> keyCodeList.add(new Pair<>(VK_4, null));
                case "5" -> keyCodeList.add(new Pair<>(VK_5, null));
                case "6" -> keyCodeList.add(new Pair<>(VK_6, null));
                case "7" -> keyCodeList.add(new Pair<>(VK_7, null));
                case "8" -> keyCodeList.add(new Pair<>(VK_8, null));
                case "9" -> keyCodeList.add(new Pair<>(VK_9, null));
                case "-" -> keyCodeList.add(new Pair<>(VK_MINUS, null));
                case "=" -> keyCodeList.add(new Pair<>(VK_EQUALS, null));
                case "~" -> keyCodeList.add(new Pair<>(VK_BACK_QUOTE, VK_SHIFT));
                case "!" -> keyCodeList.add(new Pair<>(VK_EXCLAMATION_MARK, null));
                case "@" -> keyCodeList.add(new Pair<>(VK_2, VK_SHIFT));
                case "#" -> keyCodeList.add(new Pair<>(VK_3, VK_SHIFT));
                case "$" -> keyCodeList.add(new Pair<>(VK_4, VK_SHIFT));
                case "%" -> keyCodeList.add(new Pair<>(VK_5, VK_SHIFT));
                case "^" -> keyCodeList.add(new Pair<>(VK_6, VK_SHIFT));
                case "&" -> keyCodeList.add(new Pair<>(VK_7, VK_SHIFT));
                case "*" -> keyCodeList.add(new Pair<>(VK_8, VK_SHIFT));
                case "(" -> keyCodeList.add(new Pair<>(VK_9, VK_SHIFT));
                case ")" -> keyCodeList.add(new Pair<>(VK_0, VK_SHIFT));
                case "_" -> keyCodeList.add(new Pair<>(VK_MINUS, VK_SHIFT));
                case "+" -> keyCodeList.add(new Pair<>(VK_EQUALS, VK_SHIFT));
                case "TAB" -> keyCodeList.add(new Pair<>(VK_TAB, null));
                case "ENTER" -> keyCodeList.add(new Pair<>(VK_ENTER, null));
                case "[" -> keyCodeList.add(new Pair<>(VK_OPEN_BRACKET, null));
                case "]" -> keyCodeList.add(new Pair<>(VK_CLOSE_BRACKET, null));
                case "\\" -> keyCodeList.add(new Pair<>(VK_BACK_SLASH, null));
                case "{" -> keyCodeList.add(new Pair<>(VK_OPEN_BRACKET, VK_SHIFT));
                case "}" -> keyCodeList.add(new Pair<>(VK_CLOSE_BRACKET, VK_SHIFT));
                case "|" -> keyCodeList.add(new Pair<>(VK_BACK_SLASH, VK_SHIFT));
                case ":" -> keyCodeList.add(new Pair<>(VK_SEMICOLON, VK_SHIFT));
                case ";" -> keyCodeList.add(new Pair<>(VK_SEMICOLON, null));
                case "'" -> keyCodeList.add(new Pair<>(VK_QUOTE, null));
                case "\"" -> keyCodeList.add(new Pair<>(VK_QUOTE, VK_SHIFT));
                case "," -> keyCodeList.add(new Pair<>(VK_COMMA, null));
                case "<" -> keyCodeList.add(new Pair<>(VK_COMMA, VK_SHIFT));
                case "." -> keyCodeList.add(new Pair<>(VK_PERIOD, null));
                case ">" -> keyCodeList.add(new Pair<>(VK_PERIOD, VK_SHIFT));
                case "/" -> keyCodeList.add(new Pair<>(VK_SLASH, null));
                case "?" -> keyCodeList.add(new Pair<>(VK_SLASH, VK_SHIFT));
                case "SPACE" -> keyCodeList.add(new Pair<>(VK_SPACE, null));
                case "UP" -> keyCodeList.add(new Pair<>(VK_UP, null));
                case "DOWN" -> keyCodeList.add(new Pair<>(VK_DOWN, null));
                case "LEFT" -> keyCodeList.add(new Pair<>(VK_LEFT, null));
                case "RIGHT" -> keyCodeList.add(new Pair<>(VK_RIGHT, null));
                case "VOL_UP" -> keyCodeList.add(new Pair<>(MediaKeys.VOL_UP, MediaKeys.MEDIAKEY));
                case "VOL_DOWN" -> keyCodeList.add(new Pair<>(MediaKeys.VOL_DOWN, MediaKeys.MEDIAKEY));
                case "PLAY/PAUSE" -> keyCodeList.add(new Pair<>(MediaKeys.PLAY, MediaKeys.MEDIAKEY));
                case "NEXT" -> keyCodeList.add(new Pair<>(MediaKeys.NEXT, MediaKeys.MEDIAKEY));
                case "PREV" -> keyCodeList.add(new Pair<>(MediaKeys.PREV, MediaKeys.MEDIAKEY));
                case "MUTE" -> keyCodeList.add(new Pair<>(MediaKeys.MUTE, MediaKeys.MEDIAKEY));
                case "STOP" -> keyCodeList.add(new Pair<>(MediaKeys.STOP, MediaKeys.MEDIAKEY));
                default -> System.out.println("Invalid Character sent: " + s);
            }
        }


        return keyCodeList;
    }

}












