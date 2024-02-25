package com.jio.newsapp.domain.usecases

import com.jio.newsapp.domain.manager.LocalUserManager

class SaveAppEntry(
  private val localUserManager: LocalUserManager
) {
  suspend operator fun invoke(){
    localUserManager.saveAppEntry()
  }
}