package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Criação da variável binding para manipulação dos elementos da tela.
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // Inicialização do binding antes da chamada a super.onCreate
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        // Definindo o conteúdo da view com o root do binding
        setContentView(binding.root)

        // Recuperando o nome de usuário passado pela LoginActivity
        val username = intent.extras?.getString("username")

        // Se o nome de usuário não for nulo ou vazio, atualiza o texto de boas-vindas
        if(!username.isNullOrEmpty()){
            binding.textOla.setText("Olá $username")
        }

        // Configura o listener para o botão Fechar, que encerra todas as atividades do app
        binding.buttonFechar.setOnClickListener {
            finishAffinity()
        }

        // Configura o listener para o botão Pedir, que inicia a SplashActivity
        binding.buttonPedir.setOnClickListener {
            val i = Intent(this, SplashActivity::class.java)
            // Passa os valores dos pedidos como extras no intent
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())
            startActivity(i)
            finish()
        }

        // Configura o listener para o checkbox da Pizza
        binding.checkPizza.setOnClickListener {
            if(binding.checkPizza.isChecked()){
                // Se selecionado, define a quantidade de pizza como 1 e mostra o preço
                binding.editQuantidadePizza.setText("1")
                binding.textPrecoPizza.visibility = View.VISIBLE
            }else{
                // Se não selecionado, define a quantidade de pizza como 0 e esconde o preço
                binding.editQuantidadePizza.setText("0")
                binding.textPrecoPizza.visibility = View.GONE
            }
        }

        // Configura o listener para o checkbox da Salada
        binding.checkSalada.setOnClickListener {
            if(binding.checkSalada.isChecked()){
                // Se selecionado, define a quantidade de salada como 1 e mostra o preço
                binding.editQuantidadeSalada.setText("1")
                binding.textPrecoSalada.visibility = View.VISIBLE
            }else{
                // Se não selecionado, define a quantidade de salada como 0 e esconde o preço
                binding.editQuantidadeSalada.setText("0")
                binding.textPrecoSalada.visibility = View.GONE
            }
        }

        // Configura o listener para o checkbox do Hambúrguer
        binding.checkHamburger.setOnClickListener {
            if(binding.checkHamburger.isChecked()){
                // Se selecionado, define a quantidade de hambúrguer como 1 e mostra o preço
                binding.editQuantidadeHamburguer.setText("1")
                binding.textPrecoHamburguer.visibility = View.VISIBLE
            }else{
                // Se não selecionado, define a quantidade de hambúrguer como 0 e esconde o preço
                binding.editQuantidadeHamburguer.setText("0")
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }
    }
}
