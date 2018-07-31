package com.chokus.konye.mvptutorial;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.chokus.konye.mvptutorial.component.ApplicationComponent;
import com.chokus.konye.mvptutorial.component.DaggerLoginActivityComponent;
import com.chokus.konye.mvptutorial.component.LoginActivityComponent;
import com.chokus.konye.mvptutorial.module.LoginActivityContextModule;
import com.chokus.konye.mvptutorial.module.LoginActivityMvpModule;
import com.chokus.konye.mvptutorial.qualifier.ActivityContext;
import com.chokus.konye.mvptutorial.qualifier.ApplicationContext;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements  LoginActivityContract.View{
    @BindView(R.id.username_textInput)
    TextInputEditText usernameEditText;

    @BindView(R.id.password_textInput)
    TextInputEditText passwordEditText;

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
        ButterKnife.bind(this);
        ApplicationComponent applicationComponent = MyApplication.get(this).applicationComponent;
        loginActivityComponent = DaggerLoginActivityComponent.builder()
                .loginActivityContextModule(new LoginActivityContextModule(this))
                .loginActivityMvpModule(new LoginActivityMvpModule(this))
                .applicationComponent(applicationComponent)
                .build();
        loginActivityComponent.injectLoginActivity(this);
    }

    @OnClick(R.id.login_button)
    public void login(){
        checkPassword(usernameEditText.getText().toString(), passwordEditText.getText().toString());
    }

    public void checkPassword(String username, String password){
        if(TextUtils.isEmpty(username)){
            util.showToast(getApplicationContext(), "Enter valid username");
        }else if(password.length() <= 5){
            util.showToast(getApplicationContext(), "Please enter password longer than 5 characters");
        }else{
            loginPresenter.loadLoginData(username, password);
        }
    }

    @Override
    public void successfulLogin(LoginResponseModel loginResponseModel) {
        // TODO: show UI or navigate to other activity from here e.g.
        util.showToast(getApplicationContext(), loginResponseModel.statusMsg);
    }

    @Override
    public void showError(String call, String message) {
        /** show UI element informing the user of Error
         * depending on the call assigned in the Presenter
         * e.g. for network error. see implementation below
         * This will show the error messages attached to the call.
         */
        if(call.equals("network error")) util.showToast(getApplicationContext(), message);
    }

    @Override
    public void showProgress() {
        // TODO: show UI element displaying progress
    }

    @Override
    public void hideProgress() {
        // TODO: hide UI element displaying progress
    }

    @Override
    public void showComplete() {
        // TODO: show UI for completion of progress
    }
}
