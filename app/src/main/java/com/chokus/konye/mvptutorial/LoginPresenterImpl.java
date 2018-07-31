package com.chokus.konye.mvptutorial;

import javax.inject.Inject;

public class LoginPresenterImpl implements LoginActivityContract.Presenter {

    private ApiService apiService;
    private LoginActivityContract.View mView;

    @Inject
    public LoginPresenterImpl(ApiService apiService, LoginActivityContract.View mView){
        this.apiService = apiService;
        this.mView = mView;
    }

    @Override
    public void loadLoginData(String email, String password) {

    }
}
