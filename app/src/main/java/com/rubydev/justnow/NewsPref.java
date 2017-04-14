package com.rubydev.justnow;

import android.content.Context;

/**
 * Created by yogiwisesa on 15/04/17.
 */

public class NewsPref {
    public static final String PREFS_NAME = "News_prefs";
    public static final String PREFS_VAL = "News_value";

    public static void save(ListNews data, Context ctx) {
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(ctx, PREFS_NAME, 0);
        complexPreferences.putObject(PREFS_VAL, data);
        complexPreferences.commit();
    }

    public static ListNews load(Context ctx) {
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(ctx, PREFS_NAME, 0);
        return complexPreferences.getObject(PREFS_VAL, ListNews.class);
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
