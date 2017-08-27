package com.nohimys.mynotes.helpers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Nohim Sandeepa on 8/23/2017.
 */

public class SharedPreferencesHelper {
    private static  SharedPreferencesHelper myInstance;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private final String PREFERENCE_NAME = "default_date";
    private final String DEFAULT_VALUE_STRING = "default_value";
    private final int DEFAULT_VALUE_INT = -1;
    private final boolean DEFAULT_VALUE_BOOLEAN = false;
    private final float DEFAULT_VALUE_FLOAT = 0.0f;
    private final double DEFAULT_VALUE_DOUBLE = 0.0;
    private final long DEFAULT_VALUE_LONG = 0L;

    private SharedPreferencesHelper(){}

    public synchronized static SharedPreferencesHelper getInstance(){
        if(myInstance == null){
            myInstance = new SharedPreferencesHelper();
        }
        return myInstance;
    }

    private void createObjectEditor(Context context){
        this.editor = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
    }

    private void createObjectReader(Context context){
        this.sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    private  void doneReading(){
        this.sharedPreferences = null;
    }

    private void commit(){
        this.editor.commit();
        this.editor = null;
    }

    //region Put Methods

    public void put(Keys key, String val,Context context) {
        createObjectEditor(context);
        editor.putString(key.name(), val);
        commit();
    }

    public void put(Keys key, int val,Context context) {
        createObjectEditor(context);
        editor.putInt(key.name(), val);
        commit();
    }

    public void put(Keys key, boolean val,Context context) {
        createObjectEditor(context);
        editor.putBoolean(key.name(), val);
        commit();
    }

    public void put(Keys key, float val,Context context) {
        createObjectEditor(context);
        editor.putFloat(key.name(), val);
        commit();
    }

    public void put(Keys key, long val,Context context) {
        createObjectEditor(context);
        editor.putLong(key.name(), val);
        commit();
    }

    public void put(Keys key, double val,Context context) {
        createObjectEditor(context);
        editor.putString(key.name(), String.valueOf(val));
        commit();
    }

    //endregion

    //region Get Methods

    public String getString(Keys key,Context context) {
        createObjectReader(context);
        String result = this.sharedPreferences.getString(key.name(), DEFAULT_VALUE_STRING);
        doneReading();
        return result;
    }

    public int getInt(Keys key,Context context) {
        createObjectReader(context);
        int result = this.sharedPreferences.getInt(key.name(), DEFAULT_VALUE_INT);
        doneReading();
        return result;
    }

    public boolean getBoolean(Keys key,Context context) {
        createObjectReader(context);
        boolean result = this.sharedPreferences.getBoolean(key.name(), DEFAULT_VALUE_BOOLEAN);
        doneReading();
        return result;
    }

    public float getFloat(Keys key,Context context) {
        createObjectReader(context);
        float result = this.sharedPreferences.getFloat(key.name(), DEFAULT_VALUE_FLOAT);
        doneReading();
        return result;
    }

    public long getLong(Keys key,Context context) {
        createObjectReader(context);
        long result = this.sharedPreferences.getLong(key.name(), DEFAULT_VALUE_LONG);
        doneReading();
        return result;
    }

    public double getDouble(Keys key,Context context) {
        createObjectReader(context);
        double result = DEFAULT_VALUE_DOUBLE;
        try {
            result = Double.valueOf(sharedPreferences.getString(key.name(), String.valueOf(DEFAULT_VALUE_DOUBLE)));
        } catch (NumberFormatException nfe) {
            result = DEFAULT_VALUE_DOUBLE;
        }
        finally {
            doneReading();
        }
        return result;
    }

    //endregion


    public enum Keys{
        USER_ID,
        LAST_DATA_UPLOADED_TIME,
        LAST_LOCATION_GATHERED_TIME,
        TICKER_TICK,
        UPDATING_DURATION
    }
}
