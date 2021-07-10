package com.cristiano.app16_listacomprasdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CompraDAO {
    @Query("SELECT * FROM TB_COMPRA")
    suspend fun getCompras(): List<Compra>

    @Insert
    suspend fun addCompras(t: Compra)

    @Delete
    suspend fun deleteCompra(t: Compra)
}