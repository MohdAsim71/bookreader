package com.example.bookreader.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bookreader.screens.ReaderSplashScreen
import com.example.bookreader.screens.details.ReaderBookDetailsScreen
import com.example.bookreader.screens.home.Home
import com.example.bookreader.screens.home.HomeScreenViewModel
import com.example.bookreader.screens.login.ReaderLoginScreen
import com.example.bookreader.screens.search.BooksSearchViewModel
import com.example.bookreader.screens.search.ReaderBookSearchScreen
import com.example.bookreader.screens.stats.ReaderStatsScreen
import com.example.bookreader.screens.update.ReaderBookUpdateScreen

@Composable
fun ReaderNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ReaderScreens.SplashScreen.name ){
        composable(ReaderScreens.SplashScreen.name){
            ReaderSplashScreen(navController = navController)
        }

        composable(ReaderScreens.LoginScreen.name) {
            ReaderLoginScreen(navController = navController)
        }

        composable(ReaderScreens.ReaderStatesScreen.name) {
            val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()

            ReaderStatsScreen(navController = navController,homeScreenViewModel)
        }

        composable(ReaderScreens.ReaderHomeScreen.name) {
            val homeScreenViewModel = hiltViewModel<HomeScreenViewModel>()
            Home(navController = navController,homeScreenViewModel)
        }

        composable(ReaderScreens.SearchScreen.name) {
            val searchViewModel = hiltViewModel<BooksSearchViewModel>()
            ReaderBookSearchScreen(navController = navController, viewModel = searchViewModel)
        }

        composable(ReaderScreens.DetailsScreen.name) {
            ReaderBookDetailsScreen(navController = navController, bookId = "")
        }

        val detailName = ReaderScreens.DetailsScreen.name
        composable("$detailName/{bookId}", arguments = listOf(navArgument("bookId"){
            type = NavType.StringType
        })) { backStackEntry ->
            backStackEntry.arguments?.getString("bookId").let {
                ReaderBookDetailsScreen(navController = navController, bookId = it.toString())

            }
        }

        val updateName = ReaderScreens.UpdateScreen.name
        composable("$updateName/{bookItemId}",
            arguments = listOf(navArgument("bookItemId") {
                type = NavType.StringType
            })) { navBackStackEntry ->

            navBackStackEntry.arguments?.getString("bookItemId").let {
                ReaderBookUpdateScreen(navController = navController, bookItemId = it.toString())
            }

        }
    }
}