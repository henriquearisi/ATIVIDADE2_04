package com.example.a04

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.a04.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referências para os elementos da interface
        val amountInput = findViewById<EditText>(R.id.amountInput)
        val conversionRateInput = findViewById<EditText>(R.id.conversionRateInput)
        val convertButton = findViewById<Button>(R.id.convertButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        convertButton.setOnClickListener {
            // Obter valores inseridos pelo usuário
            val amountText = amountInput.text.toString()
            val conversionRateText = conversionRateInput.text.toString()

            if (amountText.isNotEmpty() && conversionRateText.isNotEmpty()) {
                // Converter textos para números
                val amount = amountText.toDoubleOrNull()
                val conversionRate = conversionRateText.toDoubleOrNull()

                if (amount != null && conversionRate != null) {
                    // Calcular valor convertido
                    val convertedValue = amount * conversionRate
                    // Exibir resultado
                    resultText.text = "Valor convertido: $convertedValue"
                } else {
                    resultText.text = "Por favor, insira valores válidos."
                }
            } else {
                resultText.text = "Por favor, preencha todos os campos."
            }
        }
    }
}
