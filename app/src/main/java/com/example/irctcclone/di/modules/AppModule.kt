package com.example.irctcclone.di.modules

import com.example.irctcclone.data.repository.AuthRepositoryImpl
import com.example.irctcclone.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideAuthRepository(): AuthRepository = AuthRepositoryImpl()
}