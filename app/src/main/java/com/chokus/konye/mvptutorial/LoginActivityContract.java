package com.chokus.konye.mvptutorial;

public interface LoginActivityContract {

    interface View{
        void successfulLogin(LoginResponseModel loginResponseModel);
        void showError();
        void showProgress();
        void hideProgress();
        void showComplete();
    }

    interface Presenter{
        void loadLoginData(String email, String password);
    }

}
