package com.example.tp1_ads_desenvolvimentokotlim

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class ListaViewModel(private val repository: ListaRepository) : ViewModel() {

    //pegando a lista que <List<Contato>> retorna.
    //LiveData: variável publica que armazena a lista de contatos em cachê
    val listaProduto: LiveData<List<Lista>> = repository.listaProdutos.asLiveData()

    fun insert(produto:Lista) =
        viewModelScope.launch {
            repository.insert(produto)



        }
}

class ListaViewModelFactory(private val repository: ListaRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {


        if (modelClass.isAssignableFrom(ListaViewModel::class.java)) {

            return ListaViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

