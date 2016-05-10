package com.leanplum.myapplication;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.leanplum.Leanplum;
import com.leanplum.LeanplumActivityHelper;
import com.leanplum.LeanplumPushService;
import com.leanplum.LeanplumResources;
import com.leanplum.Var;
import com.leanplum.activities.LeanplumActivity;
import com.leanplum.annotations.Parser;
import com.leanplum.callbacks.StartCallback;
import com.leanplum.callbacks.VariablesChangedCallback;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends LeanplumActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
