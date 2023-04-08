package com.example.marvel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvel.databinding.FilmItemBinding
import java.util.Collections.list

class Film_Adapter(val onclick:(film:Film)->Unit): RecyclerView.Adapter<Film_Adapter.FilmHolder>() {
    private val list=ArrayList<Film>()
    inner class FilmHolder(item: View):RecyclerView.ViewHolder(item){
        val binding=FilmItemBinding.bind(item)
        fun bind(film:Film)=with(binding){
            tvName.text=film.name
            tvYear.text=film.year
            Glide.with(binding.root)
                .load(film.image)
                .centerCrop()
                .into(imageFilm)
            cvItem.setOnClickListener{
                onclick(list[adapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.film_item,parent,false)
        return FilmHolder(view)
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: FilmHolder, position: Int) {

        holder.bind(list[position])

    }
    fun addFilm(newList:List<Film>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}