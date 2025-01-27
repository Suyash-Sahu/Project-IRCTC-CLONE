package com.example.irctcclone.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.irctcclone.data.local.dao.BookingDao
import com.example.irctcclone.data.local.dao.TrainDao
import com.example.irctcclone.data.local.dao.UserDao
import com.example.irctcclone.data.local.entity.BookingEntity
import com.example.irctcclone.data.local.entity.TrainEntity
import com.example.irctcclone.data.local.entity.UserEntity

@Database(entities = [TrainEntity::class, BookingEntity::class, UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun trainDao(): TrainDao
    abstract fun bookingDao(): BookingDao
    abstract fun userDao(): UserDao
}