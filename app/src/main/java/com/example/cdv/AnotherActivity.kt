package com.example.cdv

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AnotherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)
        Log.v(getString(R.string.app_name), "OnCreate-A: iniciando ciclo completo")
    }

    override fun onStart() {
        super.onStart()
        Log.v(getString(R.string.app_name), "OnStart-A: iniciando ciclo visivel")
    }

    override fun onResume() {
        super.onResume()
        Log.v(getString(R.string.app_name), "OnResumo-A: iniciando ciclo foreground")
    }

    override fun onPause() {
        super.onPause()
        Log.v(getString(R.string.app_name), "OnPause-A: Finalizando cilco foreground")
    }

    override fun onStop() {
        super.onStop()
        Log.v(getString(R.string.app_name), "OnStop-A: finalizando ciclo visivel")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(getString(R.string.app_name), "OnDestroy-A: Finalizando Ciclo completo")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(getString(R.string.app_name), "onRestart-A: Preparando onStart")
    }
}