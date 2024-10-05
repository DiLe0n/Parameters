package com.example.parametros

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val button: Button by lazy {
        findViewById<Button>(R.id.button)
    }

    private val textViewResult: TextView by lazy {
        findViewById<TextView>(R.id.textViewResult)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            // Pasar varios parámetros al SecondActivity
            intent.putExtra("nombre", "Diego")
            intent.putExtra("edad", 20)
            startActivityForResult(intent, 1)  // Usamos startActivityForResult para recibir respuesta
        }
    }

    // Método para recibir el resultado desde SecondActivity
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK) {
            val resultado = data?.getStringExtra("resultado") ?: "Sin respuesta"
            textViewResult.text = "Resultado recibido: $resultado"
        }
    }
}