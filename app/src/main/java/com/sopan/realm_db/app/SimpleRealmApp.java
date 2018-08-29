package com.sopan.realm_db.app;

import android.app.Application;

import com.sopan.realm_db.realm.module.SimpleRealmModule;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class SimpleRealmApp extends Application {

    private static SimpleRealmApp instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        RealmConfiguration config = new RealmConfiguration.Builder(getApplicationContext()).setModules(new SimpleRealmModule()).build();
        Realm.setDefaultConfiguration(config);
    }

    public static SimpleRealmApp getInstance() {
        return instance;
    }
}
