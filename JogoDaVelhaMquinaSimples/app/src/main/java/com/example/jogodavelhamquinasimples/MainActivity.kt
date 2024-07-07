package com.example.jogodavelhamquinasimples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import com.example.jogodavelhamquinasimples.databinding.ActivityMainBinding
package com.example.jogodavelhamquinasimples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import com.example.jogodavelhamquinasimples.databinding.ActivityMainBinding

import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    // Declaração da variável de ligação com as views
    private lateinit var binding: ActivityMainBinding

    // Matriz bidimensional que representa o tabuleiro de jogo
    val tabuleiro = arrayOf(
        arrayOf("A", "B", "C"),
        arrayOf("D", "E", "F"),
        arrayOf("G", "H", "I")
    )

    // Método onCreate chamado quando a Activity é criada
    // Entrada: savedInstanceState - estado salvo da Activity
    // Saída: Nenhuma
    override fun onCreate(savedInstanceState: Bundle?) {
        // Infla o layout usando o binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Ativa as bordas da tela
        setContentView(binding.root) // Define o layout da Activity como a raiz do binding
    }

    // Função chamada quando um botão é clicado
    // Entrada: view - a view que foi clicada
    // Saída: Nenhuma
    fun buttonClick(view: View){
        // Converte a view recebida para um botão
        val buttonSelecionado = view as Button

        // Define o texto do botão clicado como "X"
        buttonSelecionado.text = "X"

        // Desativa o botão para que não possa ser clicado novamente
        buttonSelecionado.isEnabled = false

        // Atualiza o tabuleiro com "X" na posição correspondente ao botão clicado
        when(buttonSelecionado.id){
            binding.buttonZero.id -> tabuleiro[0][0] = "X"
            binding.buttonUm.id -> tabuleiro[0][1] = "X"
            binding.buttonDois.id -> tabuleiro[0][2] = "X"
            // ... (repetir para outras posições)
        }

        // Lógica para escolher a posição do "O" (oponente)
        var rX = Random.nextInt(0, 3)
        var rY = Random.nextInt(0, 3)

        var i = 0
        while (i < 9) {
            rX = Random.nextInt(0, 3)
            rY = Random.nextInt(0, 3)

            if (tabuleiro[rX][rY] != "X" && tabuleiro[rX][rY] != "O") {
                break 
            }

            i++
        }
  
        val posicao = rX * 3 + rY

        // Atualiza o tabuleiro com "O" na posição escolhida
        when(posicao){
            0 -> {
                binding.buttonZero.text = "O"
                binding.buttonZero.isEnabled = false
            }
            // ... (repetir para outras posições)
        }
    }
}

