package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    // Criação da variável binding que será usada para manipular os elementos da tela.
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflando o layout usando o binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurando um ouvinte de clique para o botão "Entrar"
        binding.buttonEntrar.setOnClickListener {
            val username = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()

            // Verificando se o nome de usuário e senha inseridos correspondem aos valores esperados
            if (username == "Carlos Daniel Santos da Silva" && password == "2") {
                // Se válido, cria uma intenção para iniciar a MainActivity
                val i = Intent(this, MainActivity::class.java)
                i.putExtra("username", username)
                startActivity(i)
                finish()
            } else {
                // Se inválido, mostra uma mensagem de erro
                Toast.makeText(applicationContext, "Errou", Toast.LENGTH_LONG).show()
            }
        }
    }
}
