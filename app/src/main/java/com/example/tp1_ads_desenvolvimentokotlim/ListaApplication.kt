package com.example.tp1_ads_desenvolvimentokotlim

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

//Criando o banco de dados e o repositório como membros de Application,
// assim sempre que necessário eles poderão ser caessados pelo app, usando lazy para isso.

class ListaApplication : Application(){

    val applicationScope = CoroutineScope(SupervisorJob())


    private val database by lazy { ListaComprasRoomDatabase.getDatabase(this) }
    val repository by lazy { ListaRepository(database.listaDao()) }


}