package com.example.materna.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.materna.ui.screens.BancoDetailScreen
import com.example.materna.ui.screens.BancosListScreen
import com.example.materna.ui.screens.CadastroDoadoraScreen
import com.example.materna.ui.screens.ChatbotScreen
import com.example.materna.ui.screens.DoadoraDetailScreen
import com.example.materna.ui.screens.DoadorasListScreen
import com.example.materna.ui.screens.HomeScreen

@Composable
fun MaternaNavGraph(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(Screen.Home.route) {
            HomeScreen(navController)
        }

        composable(Screen.DoadorasList.route) {
            DoadorasListScreen(navController)
        }

        composable(
            route = Screen.DoadoraDetail.route,
            arguments = listOf(navArgument("doadoraId") { type = NavType.IntType })
        ) { backStackEntry ->
            val doadoraId = backStackEntry.arguments?.getInt("doadoraId") ?: -1
            DoadoraDetailScreen(navController, doadoraId)
        }

        composable(Screen.CadastroDoadora.route) {
            CadastroDoadoraScreen(navController)
        }

        composable(Screen.BancosList.route) {
            BancosListScreen(navController)
        }

        composable(
            route = Screen.BancoDetail.route,
            arguments = listOf(navArgument("bancoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val bancoId = backStackEntry.arguments?.getInt("bancoId") ?: -1
            BancoDetailScreen(navController, bancoId)
        }

        composable(Screen.Chatbot.route) {
            ChatbotScreen(navController)
        }
    }
}
