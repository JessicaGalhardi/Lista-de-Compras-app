package com.example.tp1_ads_desenvolvimentokotlim

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val novoProdutoRequesCode = 1

    //Criando o ViewModel dentro da Activity
    private val listaViewNodel: ListaViewModel by viewModels {

        ListaViewModelFactory((application as ListaApplication).repository)

    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = ListAdapterCompras()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //Adicionando o observador liveData
        listaViewNodel.listaProduto.observe(this) { produto ->
            produto.let { adapter.submitList(it) }
        }

        val btnAdd = findViewById<FloatingActionButton>(R.id.btn_add)
        btnAdd.setOnClickListener {

            val intent = Intent(this@MainActivity,NovoProdutoActivity::class.java)
            startActivityForResult(intent, novoProdutoRequesCode)
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        intentData: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, intentData)

        if (requestCode == novoProdutoRequesCode && resultCode == Activity.RESULT_OK) {
            intentData?.getStringExtra(NovoProdutoActivity.EXTRA_REPLY)?.let {

                val produto= Lista(produto = it)


                listaViewNodel.insert(produto)

            }

        } else {
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()

        }
    }
}



