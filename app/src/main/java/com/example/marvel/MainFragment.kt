package com.example.marvel

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.marvel.databinding.FragmentMainBinding

class MainFragment: Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: Film_Adapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentMainBinding.bind(view)
        adapter= Film_Adapter{
            findNavController().navigate(R.id.action_mainFragment_to_secondFragment, bundleOf(SecondFragment.FILM to it))
        }
        adapter.addFilm(createfilm())
        binding.rsFilm.adapter=adapter
    }
    fun createfilm():List<Film>{
        return listOf(Film(getString(R.string.A1Name), getString(R.string.A1Year),getString(R.string.A1Desc),getString(R.string.A1Image)),
            Film(getString(R.string.A2Name), getString(R.string.A2Year),getString(R.string.A2Desc),getString(R.string.A2Image)),
            Film(getString(R.string.FAName), getString(R.string.FAYear),getString(R.string.FADesc),getString(R.string.FAImage)),
            Film(getString(R.string.A3Name), getString(R.string.A3Year),getString(R.string.A3Desc),getString(R.string.A3Image)),
            Film(getString(R.string.A4Name), getString(R.string.A4Year),getString(R.string.A4Desc),getString(R.string.A4Image)),
            Film(getString(R.string.SMName), getString(R.string.SMYear),getString(R.string.SMDesc),getString(R.string.SMImage)))
    }
}