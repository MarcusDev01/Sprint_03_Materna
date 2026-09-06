package com.example.materna.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.materna.mock.MockDoadoras

import com.example.materna.navigation.Screen
import com.example.materna.ui.components.DoadoraCard
import com.example.materna.ui.components.MaternaTopBar

/**
 * Lista as doadoras mockadas. Ao tocar em um item, o app navega
 * para a tela de detalhes passando o id da doadora como parâmetro.
 */
@Composable
fun DoadorasListScreen(navController: NavHostController) {
    Scaffold(
        topBar = { MaternaTopBar(title = "Doadoras cadastradas", onBack = { navController.popBackStack() }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(Screen.CadastroDoadora.route) }) {
                Icon(Icons.Filled.Add, contentDescription = "Cadastrar nova doadora")
            }
        }
    ) { padding ->
        if (MockDoadoras.lista.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                Text("Nenhuma doadora cadastrada ainda.")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(MockDoadoras.lista) { doadora ->
                    DoadoraCard(doadora = doadora) {
                        navController.navigate(Screen.DoadoraDetail.createRoute(doadora.id))
                    }
                }
            }
        }
    }
}
