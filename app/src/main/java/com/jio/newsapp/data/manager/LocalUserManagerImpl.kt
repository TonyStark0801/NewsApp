package com.jio.newsapp.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import com.jio.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.jio.newsapp.util.Constants
import com.jio.newsapp.util.Constants.APP_ENTRY
import com.jio.newsapp.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.map

class LocalUserManagerImpl(
  private val context:Context
) : LocalUserManager{
  override suspend fun saveAppEntry() {
    context.datastore.edit {
      settings -> settings[PreferenceKeys.APP_ENTRY] = true
    }
  }
  
  override fun readAppEntry(): Flow<Boolean> {
    return  context.datastore.data.map { preferences ->
      preferences[PreferenceKeys.APP_ENTRY]?:false
    }
  }
}

private val Context.datastore: DataStore<Preferences> by preferencesDataStore(name= USER_SETTINGS)

private object PreferenceKeys{
  val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}