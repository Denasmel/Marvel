package com.example.marvel

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.marvel.databinding.FragmentMainBinding
import com.example.marvel.databinding.FragmentSecondBinding

class SecondFragment:Fragment(R.layout.fragment_second) {
    private lateinit var binding: FragmentSecondBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSecondBinding.bind(view)
        val film = requireArguments().getParcelable<Film>(FILM)
        binding.apply {
            tvDesc.text=film?.desc
            Glide.with(binding.root)
                .load(film?.image)
                .into(imageFilm)
            bExit.setOnClickListener{findNavController().popBackStack()}
        }
    }
    companion object {
        const val FILM ="film"

    }

}
