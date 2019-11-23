package com.example.decocioapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceManager {
    public static final String SP_USER = "spUser";
    public static final String SP_EMAIL = "emailUser";
    public static final String SP_SIGNED = "signed";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor spEditor;

    public SharedPreferenceManager(Context context) {
        sharedPreferences = context.getSharedPreferences(SP_USER, Context.MODE_PRIVATE);
        spEditor = sharedPreferences.edit();
    }

    public void saveBoolean(String keySp, Boolean valueSp) {
        spEditor.putBoolean(keySp, valueSp);
        spEditor.commit();
    }

    public Boolean getSpSigned() {
        return sharedPreferences.getBoolean(SP_SIGNED, false);
    }

}

