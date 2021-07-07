package com.cristiano.app10_cadastrotarefas

import android.graphics.Bitmap
import android.graphics.drawable.Drawable

data class Tarefa(
    var foto: Bitmap?=null,
    var titulo: String,
    var descricao: String,
    var finalizado: Boolean
)