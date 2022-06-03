package com.company.utils;

public class StringUtil {
        public static boolean isNullOrEmpty(String str){
            return str.trim().isEmpty() && DataUtil.isNullOrEmpty(str);
        }
}
