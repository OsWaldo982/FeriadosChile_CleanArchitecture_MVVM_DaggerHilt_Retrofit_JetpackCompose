package com.example.testmvvmcomposable.Feriados.model.api

import com.example.testmvvmcomposable.Feriados.model.data.Feriados
import retrofit2.http.GET

interface GetFeriadosService{
    @GET("holidays.json")
    suspend fun getFeriados(): Feriados

}