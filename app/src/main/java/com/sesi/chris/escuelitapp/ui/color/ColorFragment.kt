package com.sesi.chris.escuelitapp.ui.color

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import android.speech.tts.TextToSpeech
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sesi.chris.escuelitapp.R
import com.sesi.chris.escuelitapp.model.Color
import com.sesi.chris.escuelitapp.ui.adapter.ColorAdapter
import java.util.*

class ColorFragment : Fragment() {

    private lateinit var galleryViewModel: ColorViewModel
    private var recyclerView : RecyclerView? = null
    private var textToSpeech: TextToSpeech? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel =
            ViewModelProviders.of(this).get(ColorViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_color, container, false)

        recyclerView = root.findViewById(R.id.recyclerViewColors)
        textToSpeech = TextToSpeech(context,TextToSpeech.OnInitListener {status: Int ->
            if(status != TextToSpeech.ERROR){
                textToSpeech?.language = Locale("spa","MEX")
            }})

        setupRecyclerView()
        renderColors()
        return root
    }

    private fun setupRecyclerView() {
        var colorAdapter = ColorAdapter()
        colorAdapter.setItemClickListener{color:Color -> speechColor(color)}
        recyclerView?.setHasFixedSize(true)
        recyclerView?.adapter = colorAdapter
    }

    fun renderColors() {
        var adapter = recyclerView?.adapter as ColorAdapter
        galleryViewModel.lstColors.observe(this, Observer {
            adapter.setLstColor(it)
        })
        adapter.notifyDataSetChanged()
    }

    fun speechColor(color : Color){
        textToSpeech?.speak(color.nombre, TextToSpeech.QUEUE_FLUSH, null)
    }
}