package com.chokus.konye.mvptutorial.module;

import android.content.Context;

import com.chokus.konye.mvptutorial.LoginActivity;
import com.chokus.konye.mvptutorial.qualifier.ActivityContext;
import com.chokus.konye.mvptutorial.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityContextModule {
    private LoginActivity loginActivity;
    private Context context;

    public LoginActivityContextModule(LoginActivity loginActivity){
        this.loginActivity = loginActivity;
        context = loginActivity;
    }

    @Provides
    @ActivityScope
    public LoginActivity providesLoginActivity(){
        return loginActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context providesContext(){
        return context;
    }

}
