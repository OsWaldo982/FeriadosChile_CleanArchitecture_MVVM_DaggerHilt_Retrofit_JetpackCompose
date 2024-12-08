package com.example.testmvvmcomposable.Feriados.di

import com.example.testmvvmcomposable.Feriados.model.api.GetFeriadosService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://api.boostr.cl/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideGetFeriadosService(retrofit: Retrofit): GetFeriadosService {
        return retrofit.create(GetFeriadosService::class.java)
    }
}