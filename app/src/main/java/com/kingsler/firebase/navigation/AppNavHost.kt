package com.kingsler.firebase.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kingsler.firebase.ui.theme.screens.homescreen.HomeScreen
import com.kingsler.firebase.ui.theme.screens.loginscreen.LoginScreen
import com.kingsler.firebase.ui.theme.screens.productscreen.AddProductsScreen
import com.kingsler.firebase.ui.theme.screens.productscreen.UpdateProductsScreen
import com.kingsler.firebase.ui.theme.screens.productscreen.ViewProductsScreen
import com.kingsler.firebase.ui.theme.screens.productscreen.ViewUploadsScreen
import com.kingsler.firebase.ui.theme.screens.registerscreen.RegisterScreen


@Composable
fun AppNavHost(modifier: Modifier=Modifier,navController:NavHostController= rememberNavController(),startDestination:String= ROUTE_LOGIN) {

    NavHost(navController = navController, modifier=modifier, startDestination = startDestination ){
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }

        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_ADD_PRODUCT) {
            AddProductsScreen(navController)
        }
        composable(ROUTE_VIEW_PRODUCT){
            ViewProductsScreen(navController)
        }
        composable(ROUTE_UPDATE_PRODUCT+ "/{id}"){passedData ->
            UpdateProductsScreen(navController,passedData.arguments?.getString("id")!!)
        }
        composable(ROUTE_VIEW_UPLOAD){
            ViewUploadsScreen(navController)
        }
    }

}