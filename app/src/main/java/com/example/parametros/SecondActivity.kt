package com.example.parametros

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var buttonBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textView = findViewById(R.id.textView)
        buttonBack = findViewById(R.id.buttonBack)

        // Recibir los parámetros enviados desde MainActivity
        val nombre = intent.getStringExtra("nombre") ?: "Invitado"
        val edad = intent.getIntExtra("edad", 0)

        textView.text = "Hola, $nombre. Tienes $edad años."

        // Devolver un parámetro a MainActivity
        buttonBack.setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("resultado", "Saludos desde SecondActivity")
            setResult(RESULT_OK, resultIntent)
            finish() // Cerrar la actividad y volver a MainActivity
        }
    }
}

