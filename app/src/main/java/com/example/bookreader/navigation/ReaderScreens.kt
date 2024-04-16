package com.example.bookreader.navigation

enum class ReaderScreens {
    SplashScreen,
    LoginScreen,
    CreateAccountScreen,
    ReaderHomeScreen,
    SearchScreen,
    DetailsScreen,
    UpdateScreen,
    ReaderStatesScreen;
    companion object{
        fun fromRoute(rounte:String):ReaderScreens
        = when (rounte?.substringBefore("/")){
            SplashScreen.name ->SplashScreen
            LoginScreen.name ->LoginScreen
            CreateAccountScreen.name ->CreateAccountScreen
            DetailsScreen.name ->DetailsScreen
            UpdateScreen.name ->UpdateScreen
            ReaderStatesScreen.name ->ReaderStatesScreen
            null ->ReaderHomeScreen
            else ->throw IllegalArgumentException("Route $rounte is not recognized")
    }
}
}