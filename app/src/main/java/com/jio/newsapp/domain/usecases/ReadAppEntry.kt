package com.jio.newsapp.domain.usecases

import com.jio.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
  private val localUserManager: LocalUserManager
) {
  suspend operator fun invoke(): Flow<Boolean> {
    return  localUserManager.readAppEntry()
  }
}