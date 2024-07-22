package com.example.pokemonapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var pokemonList:MutableList<Pokemon> = mutableListOf()
    private lateinit var adapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        // getting mock data
        this.pokemonList = Mock.POKEMON_LIST.toMutableList()

        // create an instance of the custom adapter
        this.adapter = PokemonAdapter(this, this.pokemonList)
        this.binding.rvContainer.adapter = this.adapter

        // configuring the RecyclerView with a LinearLayoutManager
        this.binding.rvContainer.layoutManager = LinearLayoutManager(this)

        // adding a line between each item in the list of the
        this.binding.rvContainer.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        // click handlers
        this.binding.btnSearch.setOnClickListener {
            searchPokemonType(this.binding.etPokemonType.text.toString())
        }
    }

    private fun searchPokemonType(pokemonType: String) {
        Log.d("", "Search Pokemon: $pokemonType")
    }
}