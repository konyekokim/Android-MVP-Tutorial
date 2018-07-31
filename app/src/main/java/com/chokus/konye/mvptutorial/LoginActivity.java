package com.chokus.konye.mvptutorial;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chokus.konye.mvptutorial.component.ApplicationComponent;
import com.chokus.konye.mvptutorial.component.DaggerLoginActivityComponent;
import com.chokus.konye.mvptutorial.component.LoginActivityComponent;
import com.chokus.konye.mvptutorial.module.LoginActivityContextModule;
import com.chokus.konye.mvptutorial.module.LoginActivityMvpModule;
import com.chokus.konye.mvptutorial.qualifier.ActivityContext;
import com.chokus.konye.mvptutorial.qualifier.ApplicationContext;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements  LoginActivityContract.View{
    LoginActivityComponent loginActivityComponent;

    @Inject
    @ApplicationContext
    public Context context;

    @Inject
    @ActivityContext
    public Context activityContext;

    @Inject
    LoginPresenterImpl loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ApplicationComponent applicationComponent = MyApplication.get(this).applicationComponent;
        loginActivityComponent = DaggerLoginActivityComponent.builder()
                .loginActivityContextModule(new LoginActivityContextModule(this))
                .loginActivityMvpModule(new LoginActivityMvpModule(this))
                .applicationComponent(applicationComponent)
                .build();
        loginActivityComponent.injectLoginActivity(this);
    }

    @Override
    public void successfulLogin(LoginResponseModel loginResponseModel) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showComplete() {

    }
}
