package br.com.xpeducacao.boasxpe

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.xpeducacao.boasxpe.databinding.ActivityMainBinding
import br.com.xpeducacao.boasxpe.telaresultado.BoasVindasActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        prepararListeners()
    }

    private fun prepararListeners() {
        configurarBtnEnviarListener()
    }

    private fun configurarBtnEnviarListener() {
        binding.button.setOnClickListener {
            val intent = Intent(this, BoasVindasActivity::class.java)
            val nome = binding.etNome.text.toString()
            intent.putExtra(TAG_NOME, nome)
            startActivity(intent)
        }
    }

    companion object {
        const val TAG_NOME = "tag_nome"
    }
}