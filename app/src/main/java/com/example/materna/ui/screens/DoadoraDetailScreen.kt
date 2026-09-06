package com.example.materna.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.materna.mock.MockDoadoras
import com.example.materna.ui.components.MaternaTopBar

/**
 * Exibe os detalhes de uma doadora específica, recebida por parâmetro
 * de navegação (doadoraId).
 */
@Composable
fun DoadoraDetailScreen(navController: NavHostController, doadoraId: Int) {
    val doadora = MockDoadoras.lista.find { it.id == doadoraId }

    Scaffold(
        topBar = { MaternaTopBar(title = doadora?.nome ?: "Doadora", onBack = { navController.popBackStack() }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp)
        ) {
            if (doadora == null) {
                Text("Doadora não encontrada.")
                return@Column
            }

            InfoLinha(label = "Idade", valor = "${doadora.idade} anos")
            InfoLinha(label = "Cidade", valor = doadora.cidade)
            InfoLinha(label = "Banco de leite vinculado", valor = doadora.bancoDeLeiteVinculado)
            InfoLinha(label = "Litros doados", valor = "${doadora.litrosDoados} L")
            InfoLinha(label = "Status", valor = doadora.status.label)
        }
    }
}

@Composable
private fun InfoLinha(label: String, valor: String) {
    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        Text(text = label, style = MaterialTheme.typography.labelLarge)
        Text(text = valor, style = MaterialTheme.typography.bodyLarge)
    }
}
