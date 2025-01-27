package com.example.irctcclone.di.modules

import android.content.Context
import androidx.room.Room
import com.example.irctcclone.data.local.AppDatabase
import com.example.irctcclone.data.local.dao.BookingDao
import com.example.irctcclone.data.local.dao.TrainDao
import com.example.irctcclone.data.local.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "irctc_database"
        ).build()
    }

    @Provides
    fun provideTrainDao(database: AppDatabase): TrainDao = database.trainDao()

    @Provides
    fun provideBookingDao(database: AppDatabase): BookingDao = database.bookingDao()

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao = database.userDao()
}