package com.chokus.konye.mvptutorial.module;

import android.content.Context;

import com.chokus.konye.mvptutorial.qualifier.ApplicationContext;
import com.chokus.konye.mvptutorial.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context providesContext(){
        return context;
    }
}
