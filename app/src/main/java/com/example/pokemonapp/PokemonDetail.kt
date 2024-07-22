package com.example.pokemonapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemonapp.databinding.ActivityPokemonDetailBinding

class PokemonDetail : AppCompatActivity() {
    private lateinit var binding: ActivityPokemonDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityPokemonDetailBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        if (intent != null) {
            val pokemon:Pokemon = intent.getSerializableExtra("EXTRA_POKEMON") as Pokemon
            showPokemon(pokemon)
        }

        binding.btnGoBack.setOnClickListener {
            finish()
        }
    }

    private fun showPokemon(pokemon:Pokemon) {
        binding.tvPokemonName.setText(pokemon.name)
    }
}