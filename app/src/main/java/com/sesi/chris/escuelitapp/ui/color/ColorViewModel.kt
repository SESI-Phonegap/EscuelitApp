package com.sesi.chris.escuelitapp.ui.color

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sesi.chris.escuelitapp.R
import com.sesi.chris.escuelitapp.model.Color

class ColorViewModel : ViewModel() {

    val lstColors = MutableLiveData<List<Color>>().apply {
        value = loadColors()
    }

    private fun loadColors() : List<Color>{
        val rojo = Color()
        rojo.nombre = "Rojo"
        rojo.color = R.color.rojo
        val verde = Color()
        verde.nombre = "Verde"
        verde.color = R.color.verde
        val amarillo = Color()
        amarillo.nombre = "Amarillo"
        amarillo.color = R.color.amarillo
        val azul = Color()
        azul.nombre = "Azul"
        azul.color = R.color.azul
        val negro = Color()
        negro.nombre = "Negro"
        negro.color = R.color.negro
        val morado = Color()
        morado.nombre = "Morado"
        morado.color = R.color.morado
        val lstColor = mutableListOf(rojo,verde,amarillo,azul,negro,morado)
        return lstColor
    }
}