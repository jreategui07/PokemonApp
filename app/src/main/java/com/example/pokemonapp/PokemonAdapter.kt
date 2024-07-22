package com.example.pokemonapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokemonapp.databinding.PokemonRowLayoutBinding

class PokemonAdapter(
    private val context: Context,
    private val pokemonList: MutableList<Pokemon>
): RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: PokemonRowLayoutBinding) : RecyclerView.ViewHolder (binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PokemonRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val pokemon: Pokemon = this.pokemonList[position]
        holder.binding.tvPokemonName.text = pokemon.name
        holder.binding.tvPokemonType.text = pokemon.type
        Glide.with(context)
            .load(pokemon.imageUrl)
            .placeholder(R.drawable.ic_question_mark)
            .error(R.drawable.ic_question_mark)
            .into(holder.binding.ivPokemonImg)
    }
}
