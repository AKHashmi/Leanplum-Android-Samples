package com.leanplum.variablessample;

import android.app.Application;
import android.util.Log;

import com.leanplum.Leanplum;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.LeanplumPushService;
import com.leanplum.annotations.Parser;
import com.leanplum.annotations.Variable;
import com.leanplum.callbacks.VariablesChangedCallback;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by fede on 4/15/16.
 */
public class ApplicationClass extends Application{

    // variables can be defined
    @Variable
    public static String String_applicationClass = "welcome!";

    @Variable public static Map<String, Object> powerup = new HashMap<String, Object>() {
        {
            put("name", "Turbo Boost");
            put("price", 150);
            put("speedMultiplier", 1.5);
            put("timeout", 15);
            put("slots", Arrays.asList(1, 2, 3));
        }
    };


    @Override
    public void onCreate() {

        Leanplum.setApplicationContext(this);

        Parser.parseVariables(this);
        Parser.parseVariablesForClasses(AnotherActivity.class, AnotherLPactivity.class);

        LeanplumActivityHelper.enableLifecycleCallbacks(this);

        super.onCreate();

        if (!BuildConfig.DEBUG) {
            Leanplum.setAppIdForDevelopmentMode("APP_KEY", "DEV_KEY");
        } else {
            Leanplum.setAppIdForProductionMode("APP_KEY", "PROD_KEY");
        }

        Leanplum.addVariablesChangedHandler(new VariablesChangedCallback() {
            @Override
            public void variablesChanged() {
                Log.i("#### " , "Application class " + String_applicationClass);

                for (Map.Entry<String, Object> entry : powerup.entrySet()) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    Log.i("#### ", "Application class var : " + key + " " + value.toString());
                }
            }
        });

        Leanplum.start(this);
    }
}
