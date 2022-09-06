package br.com.xpeducacao.boasxpe.telaresultado

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.xpeducacao.boasxpe.MainActivity
import br.com.xpeducacao.boasxpe.R
import br.com.xpeducacao.boasxpe.databinding.ActivityBoasVindasBinding

class BoasVindasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBoasVindasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoasVindasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        receberDadosEnviados()
    }

    private fun receberDadosEnviados() {
        val nome = intent.getStringExtra(MainActivity.TAG_NOME)
        binding.apply {
            tvNome.text = getString(R.string.lbl_boas_vindas_nome, nome)
        }
    }
}