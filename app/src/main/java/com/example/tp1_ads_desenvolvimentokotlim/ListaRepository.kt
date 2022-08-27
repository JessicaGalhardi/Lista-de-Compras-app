package com.example.tp1_ads_desenvolvimentokotlim

import kotlinx.coroutines.flow.Flow

class ListaRepository(private val listaDao: ListaDao) {


    //Executando as queries pelo Room
    val listaProdutos: Flow<List<Lista>> = listaDao.ordemAlfabetica()

    // inserindo os dados que foram declarados na classe Contato no repositório
    suspend fun insert(produto: Lista) {

        listaDao.insert(produto)
    }
}

