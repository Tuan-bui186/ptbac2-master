package com.example.edittext

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etA: EditText = findViewById(R.id.etA)
        val etB: EditText = findViewById(R.id.etB)
        val etC: EditText = findViewById(R.id.etC)
        val btnSolve: Button = findViewById(R.id.btnSolve)
        val tvResult: TextView = findViewById(R.id.tvResult)

        btnSolve.setOnClickListener {
            try {
                val a = etA.text.toString().toDouble()
                val b = etB.text.toString().toDouble()
                val c = etC.text.toString().toDouble()

                if (a == 0.0) {
                    if (b == 0.0) {
                        if (c == 0.0) {
                            tvResult.text = "Phương trình có vô số nghiệm"
                        } else {
                            tvResult.text = "Phương trình vô nghiệm"
                        }
                    } else {
                        val x = -c / b
                        tvResult.text = "Phương trình có nghiệm x = ${String.format("%.2f", x)}"
                    }
                } else {
                    val delta = b * b - 4 * a * c
                    when {
                        delta < 0 -> tvResult.text = "Phương trình vô nghiệm"
                        delta == 0.0 -> {
                            val x = -b / (2 * a)
                            tvResult.text = "Phương trình có nghiệm kép x = ${String.format("%.2f", x)}"
                        }
                        else -> {
                            val x1 = (-b + sqrt(delta)) / (2 * a)
                            val x2 = (-b - sqrt(delta)) / (2 * a)
                            tvResult.text = "Phương trình có 2 nghiệm:\nx1 = ${String.format("%.2f", x1)}\nx2 = ${String.format("%.2f", x2)}"
                        }
                    }
                }
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Vui lòng nhập hệ số hợp lệ", Toast.LENGTH_SHORT).show()
            }
        }
    }
}