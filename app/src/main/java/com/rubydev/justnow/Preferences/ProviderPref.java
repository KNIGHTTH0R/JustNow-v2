package com.rubydev.justnow.Preferences;

import android.content.Context;

import com.rubydev.justnow.Class.Provider;

/**
 * Created by yogiwisesa on 14/04/17.
 */

public class ProviderPref {
    public static final String PREFS_NAME = "Provider_prefs";
    public static final String PREFS_VAL = "Provider_value";

    public static void save(Provider data, Context ctx) {
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(ctx, PREFS_NAME, 0);
        complexPreferences.putObject(PREFS_VAL, data);
        complexPreferences.commit();
    }

    public static Provider load(Context ctx) {
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(ctx, PREFS_NAME, 0);
        return complexPreferences.getObject(PREFS_VAL, Provider.class);
    }

    public static String getJSON(Context ctx) {
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(ctx, PREFS_NAME, 0);
        return complexPreferences.getJSON(PREFS_VAL);
    }

    public static void clearAll(Context ctx) {
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(ctx, PREFS_NAME, 0);
        complexPreferences.clearObject();
        complexPreferences.commit();
    }
}
