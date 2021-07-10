package com.cristiano.app16_listacomprasdb

import android.content.Context
import androidx.room.Room

object DatabaseBuilder {
    private var instancia: AppDatabase?=null

    fun getAppDatabase(context: Context): AppDatabase?{
        if (instancia==null){
            synchronized(AppDatabase::class){
                instancia = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "AppDb").build()
            }
        }
        return instancia
    }
}
