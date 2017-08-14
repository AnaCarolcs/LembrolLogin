package com.lembrol.ana.Config;

import android.content.Context;
import android.content.SharedPreferences;

public class Preference {

    private Context context;
    private SharedPreferences preferences;
    private final String FILE_NAME = "lembrol.preferences";
    private final int MODE = 0;
    private SharedPreferences.Editor editor;

    private final String IDENTIFIER_KEY = "userLogIdentifier";

    public Preference(Context contextParameter){

        context = contextParameter;
        preferences = context.getSharedPreferences(FILE_NAME, MODE);
        editor = preferences.edit();
    }

    public void dataSave(String userIdentifier){

        editor.putString(IDENTIFIER_KEY, userIdentifier);
        editor.commit();
    }

    public String getIdentifier(){
        return preferences.getString(IDENTIFIER_KEY, null);
    }
}
