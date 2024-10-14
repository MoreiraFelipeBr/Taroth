package com.felipe.taroth

import android.os.Bundle
import android.util.TypedValue
import android.view.WindowInsetsController
import android.view.WindowManager
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.felipe.taroth.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Declarando a variável de binding
    private lateinit var binding: ActivityMainBinding
    private lateinit var containerLayout: ConstraintLayout // Referência ao container pai
    val deck = Deck()
    var num: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Remover a barra de status e a barra de navegação para tela cheia
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Garantir que o controller de insets não é nulo
        ViewCompat.getWindowInsetsController(window.decorView)?.apply {
            hide(WindowInsetsCompat.Type.statusBars() or WindowInsetsCompat.Type.navigationBars())
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }

        // Inicializando o binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        containerLayout = binding.constraintLayout // Obter referência do container

        var i = 72

        binding.imgCardDeckTouch.setOnClickListener {

            if (i >= 1) {
                createAndAddImageView()
                if (num % 3 == 0) {
                    num = num - 130
                } else {
                    num = num + 65
                }
                i--
            } else {
                recreate()
            }
        }

        // Utilizando o binding em vez de findViewById
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun createAndAddImageView() {
        var result = deck.jogar()
        val newImageViewCartaJogada = ImageView(this)
        newImageViewCartaJogada.setImageResource(result.second)
        var carta = ("cartaselecionada" + result.first)
        newImageViewCartaJogada.contentDescription = carta
        var margin = num.dp

        val layoutParams = ConstraintLayout.LayoutParams(
            60.dp,
            103.dp
        ).apply {
            bottomToBottom = R.id.guidelineH
            bottomMargin = 0.dp
            marginStart = margin
            startToStart = R.id.guideline_vertical_center
        }

        newImageViewCartaJogada.setOnTouchListener(MyTouchListener())
        containerLayout.addView(newImageViewCartaJogada)
        newImageViewCartaJogada.layoutParams = layoutParams
    }

    // converter dp para pixel
    private val Int.dp: Int
        get() = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), resources.displayMetrics).toInt()
}
