package com.leanplum.myapplication;

import android.app.Application;
import android.content.res.Resources;
import android.util.Log;
import android.widget.ImageView;

import com.leanplum.Leanplum;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.LeanplumApplication;
import com.leanplum.LeanplumPushService;
import com.leanplum.LeanplumResources;
import com.leanplum.annotations.Parser;
import com.leanplum.callbacks.StartCallback;
import com.leanplum.callbacks.VariablesChangedCallback;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fede on 4/4/16.
 */
public class MainApplication extends LeanplumApplication {

//    private static final List<String> drawableResources = Arrays.asList(".*/logo_welcome.png");
//
//    ImageView mLogo;


    @Override
    public void onCreate(){
        super.onCreate();

        Leanplum.setApplicationContext(this);
        Parser.parseVariables(this);
        LeanplumActivityHelper.enableLifecycleCallbacks(this);

        if (BuildConfig.DEBUG) {
            Leanplum.setAppIdForDevelopmentMode("app_GUsRxbbm5Yvkvbbp3hh7EuoFhVZgiDh8vNohpqR3qRU", "dev_UTg1lSxq1nmmjRVrUk3gofBrkzoCke1JZ75hLXSH7Bc");
        } else {
            Leanplum.setAppIdForProductionMode("app_GUsRxbbm5Yvkvbbp3hh7EuoFhVZgiDh8vNohpqR3qRU", "prod_zFRTmAl512b5NyQjj4wbVtbR66ytZigaQHWBc4ElA0Q");
        }


        Leanplum.enableVerboseLoggingInDevelopmentMode();

        Leanplum.syncResourcesAsync(Arrays.asList("drawable/l.*"), null);

//        Leanplum.syncResourcesAsync();

        Leanplum.start(this);
    }

}
