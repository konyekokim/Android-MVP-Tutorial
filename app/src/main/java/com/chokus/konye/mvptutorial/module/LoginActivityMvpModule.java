package com.chokus.konye.mvptutorial.module;

import com.chokus.konye.mvptutorial.ApiService;
import com.chokus.konye.mvptutorial.LoginActivityContract;
import com.chokus.konye.mvptutorial.LoginPresenterImpl;
import com.chokus.konye.mvptutorial.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginActivityMvpModule {

    private LoginActivityContract.View mView;

    public LoginActivityMvpModule(LoginActivityContract.View mView){
        this.mView = mView;
    }

    @Provides
    @ActivityScope
    LoginActivityContract.View provideView(){
        return mView;
    }

    @Provides
    @ActivityScope
    LoginPresenterImpl providePresenter(ApiService apiService, LoginActivityContract.View mView){
        return new LoginPresenterImpl(apiService, mView);
    }

}
