package com.chokus.konye.mvptutorial;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @POST("login")
    Observable<LoginResponseModel> getLoginResponse(
            @Query("email") String email,
            @Query("password") String password);

}
