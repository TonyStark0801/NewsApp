package com.jio.newsapp.di

import android.app.Application
import com.jio.newsapp.data.manager.LocalUserManagerImpl
import com.jio.newsapp.domain.manager.LocalUserManager
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
  fun provideLocalUserManager(
    application: Application
  ): LocalUserManager = LocalUserManagerImpl(application)
}