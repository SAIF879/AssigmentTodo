package com.example.assigmenttodo.di

import com.example.assigmenttodo.data.source.remote.ApiService
import com.example.assigmenttodo.data.util.OkHttpClientHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object AppModule {

    @Singleton
    @Provides
    fun provideTodoApi(): ApiService {
        return Retrofit.Builder()
            .baseUrl("BASE_URL") // TODO: CHANGE TO ACTUAL BASE URL!
            .client(OkHttpClientHelper().getOkHttpClient())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }



//    @Singleton
//    @Provides
//    fun providesGetBlogRepository(apiServices: ApiService): HomeRepository {
//        return HomeRepositoryImpl(apiServices)
//    }


}
