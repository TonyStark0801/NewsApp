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
        title = "Iron man",
        description = "I am Iron Man",
        image =  R.drawable.onboarding
    ),
    Page(
        title = "Iron man",
        description = "I am Iron Man",
        image =  R.drawable.onboarding
    ),
    Page(
        title = "Iron man",
        description = "I am Iron Man",
        image =  R.drawable.onboarding
    )
)
