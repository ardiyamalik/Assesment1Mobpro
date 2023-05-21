package org.d3if4505.assesment1mobpro.ui.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "assesment2") data class Assesment2Entity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var tanggal: Long = System.currentTimeMillis(),
    var nama : Long = System.currentTimeMillis(),
    var makanan : Long = System.currentTimeMillis(),
    var minuman : Long = System.currentTimeMillis()
)