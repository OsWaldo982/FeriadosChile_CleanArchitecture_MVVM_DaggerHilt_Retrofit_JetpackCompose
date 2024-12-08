package com.example.testmvvmcomposable.Feriados.viewmodel


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testmvvmcomposable.Feriados.model.data.Feriados
import com.example.testmvvmcomposable.Feriados.model.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FeriadosViewModel @Inject constructor(
    private val repository: ApiRepository
): ViewModel(){

    private val _feriados = MutableLiveData<Feriados>()
    val feriados: MutableLiveData<Feriados> = _feriados

    fun  fetchFeriados(){
        viewModelScope.launch {
            try {
                val feria = repository.getFeriados()
                _feriados.value = feria
            } catch (e: Exception){
                Log.d("error", e.message.toString())
            }
        }
    }



}