package com.example.tp1_ads_desenvolvimentokotlim

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class NovoProdutoActivity : AppCompatActivity() {

    private lateinit var editProdutoView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_produto)

        editProdutoView = findViewById(R.id.edit_produto)

        val button = findViewById<Button>(R.id.btnSalvar)
        button.setOnClickListener {

            val replyIntent = Intent()

            if (TextUtils.isEmpty(editProdutoView.text)) {


                val produto = (editProdutoView.text.toString())
                replyIntent.putExtra(EXTRA_REPLY, produto)

            } else {

                val produto = editProdutoView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, produto)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.tp1_ads_desenvolvimentokotlim.REPLY"
    }
}
