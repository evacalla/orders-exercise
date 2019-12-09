package com.order.utils;

/**
 * Created by evacalla on 8/12/2019
 **/
public class Validate {

    public static boolean isNumeric(String s) {
        return s.matches("[-+]?\\d*\\.?\\d+");
    }

}
