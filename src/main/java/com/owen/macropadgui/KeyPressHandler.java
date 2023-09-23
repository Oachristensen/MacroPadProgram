package com.owen.macropadgui;

import commands.MediaKeys;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.awt.event.KeyEvent.*;

public class KeyPressHandler {
    public static Map<Pair<Integer, Integer>, Integer> convertStringToKeyCode(ArrayList<String> inputList) {
        Map<Pair<Integer, Integer>, Integer> keyCodeMap = new HashMap<>();
        for (int i=0; i<inputList.size(); i++) {
            switch (inputList.get(i)) {
                case "a": keyCodeMap.put(new Pair<>(VK_A, null) ,i); break;
                case "b": keyCodeMap.put(new Pair<>(VK_B, null) ,i); break;
                case "c": keyCodeMap.put(new Pair<>(VK_C, null) ,i); break;
                case "d": keyCodeMap.put(new Pair<>(VK_D, null) ,i); break;
                case "e": keyCodeMap.put(new Pair<>(VK_E, null) ,i); break;
                case "f": keyCodeMap.put(new Pair<>(VK_F, null) ,i); break;
                case "g": keyCodeMap.put(new Pair<>(VK_G, null) ,i); break;
                case "h": keyCodeMap.put(new Pair<>(VK_H, null) ,i); break;
                case "i": keyCodeMap.put(new Pair<>(VK_I, null) ,i); break;
                case "j": keyCodeMap.put(new Pair<>(VK_J, null) ,i); break;
                case "k": keyCodeMap.put(new Pair<>(VK_K, null) ,i); break;
                case "l": keyCodeMap.put(new Pair<>(VK_L, null) ,i); break;
                case "m": keyCodeMap.put(new Pair<>(VK_M, null) ,i); break;
                case "n": keyCodeMap.put(new Pair<>(VK_N, null) ,i); break;
                case "o": keyCodeMap.put(new Pair<>(VK_O, null) ,i); break;
                case "p": keyCodeMap.put(new Pair<>(VK_P, null) ,i); break;
                case "q": keyCodeMap.put(new Pair<>(VK_Q, null) ,i); break;
                case "r": keyCodeMap.put(new Pair<>(VK_R, null) ,i); break;
                case "s": keyCodeMap.put(new Pair<>(VK_S, null) ,i); break;
                case "t": keyCodeMap.put(new Pair<>(VK_T, null) ,i); break;
                case "u": keyCodeMap.put(new Pair<>(VK_U, null) ,i); break;
                case "v": keyCodeMap.put(new Pair<>(VK_V, null) ,i); break;
                case "w": keyCodeMap.put(new Pair<>(VK_W, null) ,i); break;
                case "x": keyCodeMap.put(new Pair<>(VK_X, null) ,i); break;
                case "y": keyCodeMap.put(new Pair<>(VK_X, null) ,i); break;
                case "z": keyCodeMap.put(new Pair<>(VK_Z, null) ,i); break;
                case "BACK_QUOTE": keyCodeMap.put(new Pair<>(VK_BACK_QUOTE, null) ,i); break;
                case "0": keyCodeMap.put(new Pair<>(VK_0, null) ,i); break;
                case "1": keyCodeMap.put(new Pair<>(VK_1, null) ,i); break;
                case "2": keyCodeMap.put(new Pair<>(VK_2, null) ,i); break;
                case "3": keyCodeMap.put(new Pair<>(VK_3, null) ,i); break;
                case "4": keyCodeMap.put(new Pair<>(VK_4, null) ,i); break;
                case "5": keyCodeMap.put(new Pair<>(VK_5, null) ,i); break;
                case "6": keyCodeMap.put(new Pair<>(VK_6, null) ,i); break;
                case "7": keyCodeMap.put(new Pair<>(VK_7, null) ,i); break;
                case "8": keyCodeMap.put(new Pair<>(VK_8, null) ,i); break;
                case "9": keyCodeMap.put(new Pair<>(VK_9, null) ,i); break;
                case "MINUS": keyCodeMap.put(new Pair<>(VK_MINUS, null) ,i); break;
                case "EQUALS": keyCodeMap.put(new Pair<>(VK_EQUALS, null) ,i); break;
                case "APOSTROPHE": keyCodeMap.put(new Pair<>(VK_BACK_QUOTE, VK_SHIFT) ,i); break;
                case "EXCLAMATION_MARK": keyCodeMap.put(new Pair<>(VK_EXCLAMATION_MARK, null) ,i); break;
                case "AT": keyCodeMap.put(new Pair<>(VK_AT, null) ,i); break;
                case "NUMBER_SIGN": keyCodeMap.put(new Pair<>(VK_NUMBER_SIGN, null) ,i); break;
                case "DOLLAR": keyCodeMap.put(new Pair<>(VK_DOLLAR, null) ,i); break;
                case "PERCENT": keyCodeMap.put(new Pair<>(VK_5, VK_SHIFT) ,i); break;
                case "CIRCUMFLEX": keyCodeMap.put(new Pair<>(VK_CIRCUMFLEX, null) ,i); break;
                case "AMPERSAND": keyCodeMap.put(new Pair<>(VK_AMPERSAND, null) ,i); break;
                case "ASTERISK": keyCodeMap.put(new Pair<>(VK_ASTERISK, null) ,i); break;
                case "LEFT_PARENTHESIS": keyCodeMap.put(new Pair<>(VK_LEFT_PARENTHESIS, null) ,i); break;
                case "RIGHT_PARENTHESIS": keyCodeMap.put(new Pair<>(VK_RIGHT_PARENTHESIS, null) ,i); break;
                case "UNDERSCORE": keyCodeMap.put(new Pair<>(VK_UNDERSCORE, null) ,i); break;
                case "PLUS": keyCodeMap.put(new Pair<>(VK_PLUS, null) ,i); break;
                case "TAB": keyCodeMap.put(new Pair<>(VK_TAB, null) ,i); break;
                case "ENTER": keyCodeMap.put(new Pair<>(VK_ENTER, null) ,i); break;
                case "OPEN_BRACKET": keyCodeMap.put(new Pair<>(VK_OPEN_BRACKET, null) ,i); break;
                case "CLOSE_BRACKET": keyCodeMap.put(new Pair<>(VK_CLOSE_BRACKET, null) ,i); break;
                case "BACK_SLASH": keyCodeMap.put(new Pair<>(VK_BACK_SLASH, null) ,i); break;
                case "OPEN_BRACE": keyCodeMap.put(new Pair<>(VK_OPEN_BRACKET, VK_SHIFT) ,i); break;
                case "CLOSE_BRACE": keyCodeMap.put(new Pair<>(VK_CLOSE_BRACKET, VK_SHIFT) ,i); break;
                case "LINE": keyCodeMap.put(new Pair<>(VK_BACK_SLASH, VK_SHIFT) ,i); break;
                case "SEMICOLON": keyCodeMap.put(new Pair<>(VK_SEMICOLON, null) ,i); break;
                case "COLON": keyCodeMap.put(new Pair<>(VK_COLON, null) ,i); break;
                case "QUOTE": keyCodeMap.put(new Pair<>(VK_QUOTE, null) ,i); break;
                case "QUOTEDBL": keyCodeMap.put(new Pair<>(VK_QUOTEDBL, null) ,i); break;
                case "COMMA": keyCodeMap.put(new Pair<>(VK_COMMA, null) ,i); break;
                case "LEFT_ANGLE_BRACKET": keyCodeMap.put(new Pair<>(VK_COMMA, VK_SHIFT) ,i); break;
                case "PERIOD": keyCodeMap.put(new Pair<>(VK_PERIOD, null) ,i); break;
                case "RIGHT_ANGLE_BRACKET": keyCodeMap.put(new Pair<>(VK_PERIOD, VK_SHIFT) ,i); break;
                case "SLASH": keyCodeMap.put(new Pair<>(VK_SLASH, null) ,i); break;
                case "QUESTION": keyCodeMap.put(new Pair<>(VK_SLASH, VK_SHIFT) ,i); break;
                case "SPACE": keyCodeMap.put(new Pair<>(VK_SPACE, null) ,i); break;
                case "VOL_UP": keyCodeMap.put(new Pair<>(MediaKeys.VOL_UP, MediaKeys.MEDIAKEY) ,i); break;
                case "VOL_DOWN": keyCodeMap.put(new Pair<>(MediaKeys.VOL_DOWN, MediaKeys.MEDIAKEY) ,i); break;
                case "PLAY": keyCodeMap.put(new Pair<>(MediaKeys.PLAY, MediaKeys.MEDIAKEY) ,i); break;
                case "NEXT": keyCodeMap.put(new Pair<>(MediaKeys.NEXT, MediaKeys.MEDIAKEY) ,i); break;
                case "PREV": keyCodeMap.put(new Pair<>(MediaKeys.PREV, MediaKeys.MEDIAKEY) ,i); break;
                case "MUTE": keyCodeMap.put(new Pair<>(MediaKeys.MUTE, MediaKeys.MEDIAKEY) ,i); break;
                case "STOP": keyCodeMap.put(new Pair<>(MediaKeys.STOP, MediaKeys.MEDIAKEY) ,i); break;


                default:
                    System.out.println("Invalid Character sent: " + inputList.get(i));
            }
        }


        return keyCodeMap;
    }

}












