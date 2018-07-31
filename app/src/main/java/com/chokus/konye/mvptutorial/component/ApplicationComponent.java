package com.chokus.konye.mvptutorial.component;

import android.content.Context;

import com.chokus.konye.mvptutorial.ApiService;
import com.chokus.konye.mvptutorial.MyApplication;
import com.chokus.konye.mvptutorial.module.ContextModule;
import com.chokus.konye.mvptutorial.module.RetrofitModule;
import com.chokus.konye.mvptutorial.qualifier.ApplicationContext;
import com.chokus.konye.mvptutorial.scope.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    ApiService getApiService();

    @ApplicationContext
    Context getContext();

    void injectApplication(MyApplication application);

}
