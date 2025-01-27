package com.example.irctcclone.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.irctcclone.data.local.entity.TrainEntity

@Dao
interface TrainDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrain(train: TrainEntity)

    @Query("SELECT * FROM trains WHERE trainNumber = :trainNumber")
    suspend fun getTrain(trainNumber: String): TrainEntity?
}