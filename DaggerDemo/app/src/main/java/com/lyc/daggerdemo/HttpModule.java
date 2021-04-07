package com.lyc.daggerdemo;

import com.lyc.daggerdemo.object.HttpObject;

import dagger.Module;
import dagger.Provides;

/**
 * @author ：LYC
 * @date ：Created in 2021/4/7
 * @version:
 * @description：用于提供对象
 */
// 单独抽离出来
@Module
public class HttpModule {

    @Provides
    public HttpObject provideHttpObject(){
        return new HttpObject();
    }
}
