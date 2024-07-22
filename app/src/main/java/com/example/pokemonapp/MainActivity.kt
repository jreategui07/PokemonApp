package com.example.pokemonapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonapp.databinding.ActivityMainBinding
import com.example.pokemonapp.utils.SnackbarHelper

class MainActivity : AppCompatActivity(), ClickDetectorInterface {
    private lateinit var binding: ActivityMainBinding
    private var pokemonList:MutableList<Pokemon> = mutableListOf()
    private lateinit var adapter: PokemonAdapter
    private lateinit var snackbarHelper: SnackbarHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        // init custom snackbar helper
        this.snackbarHelper = SnackbarHelper(this.binding.root)

        // getting mock data
        this.pokemonList = Mock.POKEMON_LIST.toMutableList()

        // create an instance of the custom adapter
        this.adapter = PokemonAdapter(this, this.pokemonList, this)
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

        this.binding.btnReset.setOnClickListener {
            resetPokemonList()
        }
    }

    private fun searchPokemonType(pokemonType: String) {
        if (pokemonType == "") {
            this.snackbarHelper.showSnackbar("Enter a Pokemon type")
            return
        }
        val searchResults: MutableList<Pokemon> = mutableListOf()
        for (pokemon: Pokemon in Mock.POKEMON_LIST.toMutableList()) {
            if (pokemonType == pokemon.type) {
                searchResults.add(pokemon)
            }
        }
        displayList(searchResults)
        this.snackbarHelper.showSnackbar("Displaying $pokemonType-type Pokemon")
    }

    private fun resetPokemonList() {
        binding.etPokemonType.setText("")
        displayList()
        this.snackbarHelper.showSnackbar("Displaying all Pokemon")
    }

    private fun displayList(pokemonList: MutableList<Pokemon> = Mock.POKEMON_LIST.toMutableList()) {
        this.pokemonList.clear()
        this.pokemonList.addAll(pokemonList)
        adapter.notifyDataSetChanged()
    }

    override fun onRowClicked(position: Int) {
        val intent: Intent = Intent(this@MainActivity, PokemonDetail::class.java)
        intent.putExtra("EXTRA_POKEMON", this.pokemonList[position])
        startActivity(intent)
    }
}