package com.cristiano.app9_listatarefas

import android.graphics.drawable.Drawable

data class Tarefa(
    var foto: Drawable?=null,
    var titulo: String,
    var descricao: String,
)