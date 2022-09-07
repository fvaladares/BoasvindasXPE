package br.com.xpeducacao.boasxpe

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import br.com.xpeducacao.boasxpe.databinding.ActivityMainBinding
import br.com.xpeducacao.boasxpe.telaresultado.BoasVindasActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val retorno = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { activityResult ->
        activityResult.data?.let { intent ->
            if (intent.hasExtra(TAG_RETORNO)) {
                val retorno = intent.getStringExtra(TAG_RETORNO)
                binding.etNome.setText(retorno)
            } else {
                Log.d(
                    "XPE::Info",
                    "Não foram retorandos dados da activity chamada"
                )
            }
        }
    }

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
        binding.btnEnviar.setOnClickListener {
            enviarDados()
        }
    }

    private fun enviarDados() {
        val nome = binding.etNome.text
        if (nome.isNullOrBlank()) {
            binding.tilNome.error = "Este campo deve ser obrigatoriamente preenchido."
        } else {
            binding.tilNome.error = null
            val intent = Intent(this, BoasVindasActivity::class.java)
            intent.putExtra(TAG_NOME, nome.toString())
            retorno.launch(intent)
        }
    }

    companion object {
        const val TAG_NOME = "tag_nome"
        const val TAG_RETORNO = "tag_retorno"
    }
}