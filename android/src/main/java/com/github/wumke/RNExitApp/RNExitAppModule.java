package com.github.wumke.RNExitApp;

import android.app.AlarmManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Objects;


public class RNExitAppModule extends ReactContextBaseJavaModule {

    ReactApplicationContext reactContext;
    AlarmManager alarmManager;

    public RNExitAppModule(ReactApplicationContext reactContext) {
        super(reactContext);

        this.reactContext = reactContext;
        alarmManager = (AlarmManager) reactContext.getSystemService(Context.ALARM_SERVICE);
    }

    @Override
    public String getName() {
        return "RNExitApp";
    }

    @ReactMethod
    public void exitApp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                Objects.requireNonNull(getCurrentActivity()).finishAndRemoveTask();
                getCurrentActivity().getIntent().setType("used");

        } else {
            Objects.requireNonNull(getCurrentActivity()).finishAffinity();
        }


    }
}
