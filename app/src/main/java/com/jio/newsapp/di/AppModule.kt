package com.jio.newsapp.di

import android.app.Application
import com.jio.newsapp.data.manager.LocalUserManagerImpl
import com.jio.newsapp.domain.manager.LocalUserManager
import com.jio.newsapp.domain.usecases.AppEntryUseCases
import com.jio.newsapp.domain.usecases.ReadAppEntry
import com.jio.newsapp.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
  
  @Provides
  @Singleton
  fun provideLocalUserManager(
    application: Application
  ): LocalUserManager = LocalUserManagerImpl(application)

  @Provides
  @Singleton
  fun provideAppEntryUseCases(localUserManager: LocalUserManager) = AppEntryUseCases(
    readAppEntry = ReadAppEntry(localUserManager),
    saveAppEntry = SaveAppEntry(localUserManager)
  )



}
