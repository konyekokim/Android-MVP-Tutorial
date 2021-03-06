package com.chokus.konye.mvptutorial;

import com.chokus.konye.mvptutorial.model.LoginResponseModel;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @POST("login")
    Observable<LoginResponseModel> getLoginResponse(
            @Query("username") String username,
            @Query("password") String password);

}
