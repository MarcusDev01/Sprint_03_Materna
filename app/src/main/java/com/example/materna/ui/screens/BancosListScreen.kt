package com.example.materna.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.materna.mock.MockBancos
import com.example.materna.navigation.Screen
import com.example.materna.ui.components.BancoCard
import com.example.materna.ui.components.MaternaTopBar

/**
 * Lista os bancos de leite humano mockados, simulando o mapa
 * interativo previsto na proposta original do projeto.
 */
@Composable
fun BancosListScreen(navController: NavHostController) {
    Scaffold(
        topBar = { MaternaTopBar(title = "Bancos de leite", onBack = { navController.popBackStack() }) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(MockBancos.lista) { banco ->
                BancoCard(banco = banco) {
                    navController.navigate(Screen.BancoDetail.createRoute(banco.id))
                }
            }
        }
    }
}
