package com.chokus.konye.mvptutorial.component;

import android.content.Context;

import com.chokus.konye.mvptutorial.LoginActivity;
import com.chokus.konye.mvptutorial.module.LoginActivityContextModule;
import com.chokus.konye.mvptutorial.module.LoginActivityMvpModule;
import com.chokus.konye.mvptutorial.qualifier.ActivityContext;
import com.chokus.konye.mvptutorial.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = {LoginActivityContextModule.class, LoginActivityMvpModule.class},
        dependencies = ApplicationComponent.class)
public interface LoginActivityComponent {

    @ActivityContext
    Context getContext();
    void injectLoginActivity(LoginActivity loginActivity);

}
