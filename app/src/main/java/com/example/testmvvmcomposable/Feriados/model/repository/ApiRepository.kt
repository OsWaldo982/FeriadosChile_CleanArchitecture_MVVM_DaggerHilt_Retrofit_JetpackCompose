package com.example.testmvvmcomposable.Feriados.model.repository

import com.example.testmvvmcomposable.Feriados.model.api.GetFeriadosService
import com.example.testmvvmcomposable.Feriados.model.data.Feriados
import javax.inject.Inject


class ApiRepository @Inject constructor(
    private val feriadosService: GetFeriadosService
) {

    suspend fun  getFeriados() : Feriados {
        return feriadosService.getFeriados()

    }
}