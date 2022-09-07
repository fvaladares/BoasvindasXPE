package br.com.xpeducacao.boasxpe.telaresultado

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

        configurarBtnRetornar()
        receberDadosEnviados()
    }

    private fun configurarBtnRetornar() {

        binding.btnRetornar.setOnClickListener {
            val retorno = binding.etRetorno.text.toString()
            Intent().apply {
                putExtra(MainActivity.TAG_RETORNO, retorno)
                setResult(RESULT_OK, this)
            }
            finish()
        }
    }

    private fun receberDadosEnviados() {
        val nome = intent.getStringExtra(MainActivity.TAG_NOME)
        Log.d("XPE::Debug", nome.toString())
        binding.apply {
            tvBoasVindaslbl.text = getString(R.string.lbl_boas_vindas_nome, nome)
        }
    }
}