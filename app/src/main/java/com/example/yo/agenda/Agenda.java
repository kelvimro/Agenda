package com.example.yo.agenda;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by yo on 03/03/2016.
 */
public class Agenda extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
    }
}
