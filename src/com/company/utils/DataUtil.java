package com.company.utils;

public class DataUtil {
    public static boolean isNullOrEmpty(Object obj){
        return obj == null;
    }

    public static boolean isNullOrEmptyArray(Object [] objs){
        return objs == null && objs.length == 0;
    }
}
