package com.chokus.konye.mvptutorial;

import android.app.Activity;
import android.app.Application;

import com.chokus.konye.mvptutorial.component.ApplicationComponent;
import com.chokus.konye.mvptutorial.component.DaggerApplicationComponent;
import com.chokus.konye.mvptutorial.module.ContextModule;

public class MyApplication extends Application {
    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        dependencyInjection();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public static MyApplication get(Activity activity){
        return (MyApplication) activity.getApplication();
    }

    private void dependencyInjection(){
        applicationComponent = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this)).build();

        applicationComponent.injectApplication(this);
    }
}
