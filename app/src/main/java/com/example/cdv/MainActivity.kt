package com.example.cdv

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.cdv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val amb: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private companion object {
        const val VALOR_TELEFONE_UM = "VALOR TELEFONE UM"
        const val VALOR_TELEFONE_DOIS = "VALOR TELEFONE DOIS"
    }

    private val telefone2Et: EditText by lazy {
        EditText(this).apply {
            hint = "Segundo Telefone"
            layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(amb.root)
        amb.root.addView(telefone2Et)

        Log.v(getString(R.string.app_name), "OnCreate: iniciando ciclo completo")
        amb.abraBt.setOnClickListener {
            val anotherIntent: Intent = Intent(this, AnotherActivity::class.java)
            startActivity(anotherIntent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(VALOR_TELEFONE_UM, amb.telaSecundariaEt.text.toString())
        outState.putString(VALOR_TELEFONE_DOIS, telefone2Et.text.toString()) // Salvando corretamente o valor do segundo telefone
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.apply {
            getString(VALOR_TELEFONE_UM)?.let {
                amb.telaSecundariaEt.setText(it)
            }
        }
        savedInstanceState.apply {
            getString(VALOR_TELEFONE_DOIS)?.let {
                telefone2Et.setText(it)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.v(getString(R.string.app_name), "OnStart: iniciando ciclo visível")
    }

    override fun onResume() {
        super.onResume()
        Log.v(getString(R.string.app_name), "OnResume: iniciando ciclo foreground")
    }

    override fun onPause() {
        super.onPause()
        Log.v(getString(R.string.app_name), "OnPause: Finalizando ciclo foreground")
    }

    override fun onStop() {
        super.onStop()
        Log.v(getString(R.string.app_name), "OnStop: finalizando ciclo visível")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(getString(R.string.app_name), "OnDestroy: Finalizando ciclo completo")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(getString(R.string.app_name), "OnRestart: Preparando onStart")
    }
}
