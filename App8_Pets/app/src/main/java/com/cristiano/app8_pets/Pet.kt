package com.cristiano.app8_pets

import android.graphics.drawable.Drawable

data class Pet(
    var foto: Drawable?=null,
    var especie: String,
    var nome: String,
)
