package com.example.pokemonapp.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

class SnackbarHelper {
    private val rootView: View
    constructor(rootView: View) {
        this.rootView = rootView
    }

    fun showSnackbar(message: String, duration: Int = Snackbar.LENGTH_SHORT) {
        Snackbar.make(this.rootView, message, duration).show()
    }
}