package org.d3if4505.assesment1mobpro.ui.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Assesment2Dao { @Insert
fun insert(asses: Assesment2Entity)
    @Query("SELECT * FROM assesment2 ORDER BY id DESC LIMIT 1")
    fun getLastasses(): LiveData<Assesment2Entity?>
}