package com.owen.macropadgui.handlers;

import commands.MediaKeys;
import javafx.util.Pair;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.awt.event.KeyEvent.*;

public class KeyPressHandler {
    public static ArrayList<Pair<Integer, Integer>> convertStringToKeyCode(ArrayList<String> inputList) {
        ArrayList<Pair<Integer, Integer>> keyCodeList = new ArrayList<>();
        for (int i=0; i<inputList.size(); i++) {
            switch (inputList.get(i)) {
                case "A": keyCodeList.add(new Pair<>(VK_A, null)); break;
                case "B": keyCodeList.add(new Pair<>(VK_B, null)); break;
                case "C": keyCodeList.add(new Pair<>(VK_C, null) ); break;
                case "D": keyCodeList.add(new Pair<>(VK_D, null) ); break;
                case "E": keyCodeList.add(new Pair<>(VK_E, null) ); break;
                case "F": keyCodeList.add(new Pair<>(VK_F, null) ); break;
                case "G": keyCodeList.add(new Pair<>(VK_G, null) ); break;
                case "H": keyCodeList.add(new Pair<>(VK_H, null) ); break;
                case "I": keyCodeList.add(new Pair<>(VK_I, null) ); break;
                case "J": keyCodeList.add(new Pair<>(VK_J, null) ); break;
                case "K": keyCodeList.add(new Pair<>(VK_K, null) ); break;
                case "L": keyCodeList.add(new Pair<>(VK_L, null) ); break;
                case "M": keyCodeList.add(new Pair<>(VK_M, null) ); break;
                case "N": keyCodeList.add(new Pair<>(VK_N, null) ); break;
                case "O": keyCodeList.add(new Pair<>(VK_O, null) ); break;
                case "P": keyCodeList.add(new Pair<>(VK_P, null)); break;
                case "Q": keyCodeList.add(new Pair<>(VK_Q, null) ); break;
                case "R": keyCodeList.add(new Pair<>(VK_R, null) ); break;
                case "S": keyCodeList.add(new Pair<>(VK_S, null) ); break;
                case "T": keyCodeList.add(new Pair<>(VK_T, null) ); break;
                case "U": keyCodeList.add(new Pair<>(VK_U, null) ); break;
                case "V": keyCodeList.add(new Pair<>(VK_V, null) ); break;
                case "W": keyCodeList.add(new Pair<>(VK_W, null) ); break;
                case "X": keyCodeList.add(new Pair<>(VK_X, null) ); break;
                case "Y": keyCodeList.add(new Pair<>(VK_Y, null) ); break;
                case "Z": keyCodeList.add(new Pair<>(VK_Z, null) ); break;
                case "BACK_QUOTE": keyCodeList.add(new Pair<>(VK_BACK_QUOTE, null) ); break;
                case "0": keyCodeList.add(new Pair<>(VK_0, null)); break;
                case "1": keyCodeList.add(new Pair<>(VK_1, null)); break;
                case "2": keyCodeList.add(new Pair<>(VK_2, null)); break;
                case "3": keyCodeList.add(new Pair<>(VK_3, null)); break;
                case "4": keyCodeList.add(new Pair<>(VK_4, null)); break;
                case "5": keyCodeList.add(new Pair<>(VK_5, null)); break;
                case "6": keyCodeList.add(new Pair<>(VK_6, null)); break;
                case "7": keyCodeList.add(new Pair<>(VK_7, null)); break;
                case "8": keyCodeList.add(new Pair<>(VK_8, null)); break;
                case "9": keyCodeList.add(new Pair<>(VK_9, null)); break;
                case "MINUS": keyCodeList.add(new Pair<>(VK_MINUS, null) ); break;
                case "EQUALS": keyCodeList.add(new Pair<>(VK_EQUALS, null) ); break;
                case "APOSTROPHE": keyCodeList.add(new Pair<>(VK_BACK_QUOTE, VK_SHIFT) ); break;
                case "EXCLAMATION_MARK": keyCodeList.add(new Pair<>(VK_EXCLAMATION_MARK, null) ); break;
                case "AT": keyCodeList.add(new Pair<>(VK_AT, null) ); break;
                case "NUMBER_SIGN": keyCodeList.add(new Pair<>(VK_NUMBER_SIGN, null) ); break;
                case "DOLLAR": keyCodeList.add(new Pair<>(VK_DOLLAR, null) ); break;
                case "PERCENT": keyCodeList.add(new Pair<>(VK_5, VK_SHIFT) ); break;
                case "CIRCUMFLEX": keyCodeList.add(new Pair<>(VK_CIRCUMFLEX, null) ); break;
                case "AMPERSAND": keyCodeList.add(new Pair<>(VK_AMPERSAND, null) ); break;
                case "ASTERISK": keyCodeList.add(new Pair<>(VK_ASTERISK, null) ); break;
                case "LEFT_PARENTHESIS": keyCodeList.add(new Pair<>(VK_9, VK_SHIFT) ); break;
                case "RIGHT_PARENTHESIS": keyCodeList.add(new Pair<>(VK_RIGHT_PARENTHESIS, null) ); break;
                case "UNDERSCORE": keyCodeList.add(new Pair<>(VK_UNDERSCORE, null) ); break;
                case "PLUS": keyCodeList.add(new Pair<>(VK_PLUS, null) ); break;
                case "TAB": keyCodeList.add(new Pair<>(VK_TAB, null) ); break;
                case "ENTER": keyCodeList.add(new Pair<>(VK_ENTER, null) ); break;
                case "OPEN_BRACKET": keyCodeList.add(new Pair<>(VK_OPEN_BRACKET, null) ); break;
                case "CLOSE_BRACKET": keyCodeList.add(new Pair<>(VK_CLOSE_BRACKET, null) ); break;
                case "BACK_SLASH": keyCodeList.add(new Pair<>(VK_BACK_SLASH, null) ); break;
                case "OPEN_BRACE": keyCodeList.add(new Pair<>(VK_OPEN_BRACKET, VK_SHIFT) ); break;
                case "CLOSE_BRACE": keyCodeList.add(new Pair<>(VK_CLOSE_BRACKET, VK_SHIFT) ); break;
                case "LINE": keyCodeList.add(new Pair<>(VK_BACK_SLASH, VK_SHIFT) ); break;
                case "SEMICOLON": keyCodeList.add(new Pair<>(VK_SEMICOLON, null) ); break;
                case ":": keyCodeList.add(new Pair<>(VK_COLON, null) ); break;
                case "QUOTE": keyCodeList.add(new Pair<>(VK_QUOTE, null) ); break;
                case "QUOTEDBL": keyCodeList.add(new Pair<>(VK_QUOTEDBL, null) ); break;
                case "COMMA": keyCodeList.add(new Pair<>(VK_COMMA, null)); break;
                case "LEFT_ANGLE_BRACKET": keyCodeList.add(new Pair<>(VK_COMMA, VK_SHIFT) ); break;
                case "PERIOD": keyCodeList.add(new Pair<>(VK_PERIOD, null) ); break;
                case "RIGHT_ANGLE_BRACKET": keyCodeList.add(new Pair<>(VK_PERIOD, VK_SHIFT) ); break;
                case "SLASH": keyCodeList.add(new Pair<>(VK_SLASH, null) ); break;
                case "QUESTION": keyCodeList.add(new Pair<>(VK_SLASH, VK_SHIFT) ); break;
                case "SPACE": keyCodeList.add(new Pair<>(VK_SPACE, null) ); break;
                case "VOL_UP": keyCodeList.add(new Pair<>(MediaKeys.VOL_UP, MediaKeys.MEDIAKEY) ); break;
                case "VOL_DOWN": keyCodeList.add(new Pair<>(MediaKeys.VOL_DOWN, MediaKeys.MEDIAKEY) ); break;
                case "PLAY": keyCodeList.add(new Pair<>(MediaKeys.PLAY, MediaKeys.MEDIAKEY) ); break;
                case "NEXT": keyCodeList.add(new Pair<>(MediaKeys.NEXT, MediaKeys.MEDIAKEY) ); break;
                case "PREV": keyCodeList.add(new Pair<>(MediaKeys.PREV, MediaKeys.MEDIAKEY) ); break;
                case "MUTE": keyCodeList.add(new Pair<>(MediaKeys.MUTE, MediaKeys.MEDIAKEY) ); break;
                case "STOP": keyCodeList.add(new Pair<>(MediaKeys.STOP, MediaKeys.MEDIAKEY)); break;


                default:
                    System.out.println("Invalid Character sent: " + inputList.get(i));
            }
        }


        return keyCodeList;
    }

}












