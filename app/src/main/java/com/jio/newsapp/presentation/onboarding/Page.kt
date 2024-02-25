package com.jio.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import  com.jio.newsapp.R
data class Page(
  val title :String,
  val description:String,
  @DrawableRes val image:Int
)


val pages = listOf(
  Page(
    title = "Lorem Ipsum ",
    description = " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.   recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
    image =  R.drawable.onboarding1
  ),
  Page(
    title = "Lorem Ipsum ",
    description = " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.   recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
    image =  R.drawable.onboarding2
  ),
  Page(
    title = "Lorem Ipsum ",
    description = " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.   recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
    image =  R.drawable.onboarding3
  )
)
