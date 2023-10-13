package pt.ipt.dam2023.dicesapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            lasVegasButton()
        }
    }

    /**
     * gera um número aleatório e associa-o à imagem do dado
     */
    private fun lasVegasButton() {
        // 'ponteiros' para os objetos da interface gráfica
        val txt = findViewById<TextView>(R.id.textView)
        val imagem = findViewById<ImageView>(R.id.imageView)

        // gerar num. aleatório entre 1 e 6
        val novoNumeroDado = Random().nextInt(6) + 1

        // determinar se há aviso, ou não, ao utilizador
        // pelo facto do num gerado ser igual ao que lá estava representado
        if(txt.text==novoNumeroDado.toString())
            Toast.makeText(this,
                getString(R.string.toastText),
                Toast.LENGTH_LONG).show()

        // associar o num. à TextView
        txt.text = novoNumeroDado.toString()

        // associar a imagem do dado do num. à ImageView
        val nomeDaImagem = when (novoNumeroDado) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        imagem.setImageResource(nomeDaImagem)
    }
}