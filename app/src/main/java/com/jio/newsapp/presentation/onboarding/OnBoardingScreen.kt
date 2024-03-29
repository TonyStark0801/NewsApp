package com.jio.newsapp.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jio.newsapp.presentation.common.NewsButton
import com.jio.newsapp.presentation.common.NewsTextButton
import com.jio.newsapp.presentation.onboarding.components.Dimens
import com.jio.newsapp.presentation.onboarding.components.OnboardingPage
import com.jio.newsapp.presentation.onboarding.components.PageIndicator
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
  event: (OnBoardingEvent)-> Unit
) {
  Column(modifier = Modifier.fillMaxSize()
  ) {
    
    //On WhichPage I am?
    val pagerState = rememberPagerState(initialPage = 0) {
      pages.size
    }
    //What should my button state.. remember holds the data and derived state stops recomposition every time
    val buttonState = remember {
      derivedStateOf {
        when (pagerState.currentPage) {
          0 -> listOf("", "Next")
          1 -> listOf("Back", "Next")
          2 -> listOf("Back", "Get Started")
          else -> listOf("", "")
        }
      }
    }
    
    HorizontalPager(state = pagerState) { index ->
      OnboardingPage(page = pages[index])
    }
    Spacer(
      modifier = Modifier
        .weight(1f)
    )
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = Dimens.MediumPadding2)
        .navigationBarsPadding(),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      PageIndicator(
        modifier = Modifier.width(Dimens.PageIndicatorWidth),
        pageSize = pages.size,
        selectedPage = pagerState.currentPage
      )
      
      Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.navigationBarsPadding()
      ) {
        val scope = rememberCoroutineScope()
        if (buttonState.value[0].isNotEmpty()) {
          NewsTextButton(
            text = buttonState.value[0],
            onClick = {
              scope.launch {
                pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
              }
            }
          )
        }
        NewsButton(
          text = buttonState.value[1],
          onClick = {
            scope.launch {
              if (pagerState.currentPage == 2) {
                event(OnBoardingEvent.SaveAppEntry)
              } else {
                pagerState.animateScrollToPage(
                  page = pagerState.currentPage + 1
                )
              }
            }
          }
        )
      }
    }
    Spacer(modifier = Modifier.weight(0.1f))
  }
  
}

//@Preview
//@Composable
//fun Test() {
//
//  NewsAppTheme {
//
//    OnBoardingScreen()
//  }
//}