package com.lembrol.ana.Config;


import android.util.Base64;

public class Base64Custom {

    public static String code64Base(String text){
        return Base64.encodeToString(text.getBytes(), Base64.DEFAULT).replaceAll("(\\n|\\r)","");
    }

    public static String decode64Base(String decodeText){
        return new String( Base64.decode(decodeText, Base64.DEFAULT));
    }

}
