package com.cristiano.app10_cadastrodevs

import android.graphics.Bitmap

data class User(
    var foto: Bitmap?=null,
    var nome: String,
    var email: String,
    var stack: Stack,
    var nivel: Nivel,
    var empregado: Boolean
)
