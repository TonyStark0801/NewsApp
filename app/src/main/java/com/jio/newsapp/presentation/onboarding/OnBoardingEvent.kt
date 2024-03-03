package com.jio.newsapp.presentation.onboarding

sealed class OnBoardingEvent {
  data object  SaveAppEntry: OnBoardingEvent()
}