package com.example.reactapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val service: Service,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    val persons = MutableLiveData<List<PersonApp>>()

    fun getPersons() {
        viewModelScope.launch(dispatcher) {
            persons.value = service.getPerson()
        }
    }
}