package com.example.irctcclone.di

import android.content.Context
import androidx.room.Room
import com.example.irctcclone.data.local.AppDatabase
import com.example.irctcclone.data.local.dao.BookingDao
import com.example.irctcclone.data.local.dao.TrainDao
import com.example.irctcclone.data.local.dao.UserDao
import com.example.irctcclone.data.remote.api.TrainApiService
import com.example.irctcclone.data.repository.AuthRepositoryImpl
import com.example.irctcclone.data.repository.TrainRepositoryImpl
import com.example.irctcclone.domain.repository.AuthRepository
import com.example.irctcclone.domain.repository.TrainRepository
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceLocator {
    private const val BASE_URL = "https://api.irctc.co.in/" // Replace with actual base URL

    @Volatile
    private var appDatabase: AppDatabase? = null
    @Volatile
    private var authRepository: AuthRepository? = null
    @Volatile
    private var trainRepository: TrainRepository? = null
    @Volatile
    private var okHttpClient: OkHttpClient? = null
    @Volatile
    private var retrofit: Retrofit? = null
    @Volatile
    private var trainApiService: TrainApiService? = null

    @Synchronized
    private fun provideOkHttpClient(): OkHttpClient {
        return okHttpClient ?: OkHttpClient.Builder()
            .build()
            .also { okHttpClient = it }
    }

    @Synchronized
    private fun provideRetrofit(): Retrofit {
        return retrofit ?: Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .also { retrofit = it }
    }

    @Synchronized
    fun provideDatabase(context: Context): AppDatabase {
        return appDatabase ?: Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "irctc_database"
        ).build().also {
            appDatabase = it
        }
    }

    @Synchronized
    fun provideTrainDao(context: Context): TrainDao {
        return provideDatabase(context).trainDao()
    }

    @Synchronized
    fun provideBookingDao(context: Context): BookingDao {
        return provideDatabase(context).bookingDao()
    }

    @Synchronized
    fun provideUserDao(context: Context): UserDao {
        return provideDatabase(context).userDao()
    }

    @Synchronized
    fun provideAuthRepository(): AuthRepository {
        return authRepository ?: AuthRepositoryImpl().also {
            authRepository = it
        }
    }

    @Synchronized
    fun provideTrainRepository(): TrainRepository {
        return trainRepository ?: TrainRepositoryImpl().also {
            trainRepository = it
        }
    }

    @Synchronized
    fun provideTrainApiService(): TrainApiService {
        return trainApiService ?: provideRetrofit()
            .create(TrainApiService::class.java)
            .also { trainApiService = it }
    }

    fun reset() {
        synchronized(this) {
            appDatabase?.close()
            appDatabase = null
            authRepository = null
            trainRepository = null
            okHttpClient = null
            retrofit = null
            trainApiService = null
        }
    }
}
