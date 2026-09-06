package com.example.materna.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.materna.navigation.Screen
import com.example.materna.ui.components.MaternaTopBar

/**
 * Tela de apresentação do app: explica o propósito do Materna+ e
 * direciona o usuário para os principais fluxos.
 */
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = { MaternaTopBar(title = "Materna+") }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Doação de leite materno, mais simples para a nutriz",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center
            )

            Text(
                text = "O Materna+ ajuda nutrizes a encontrar bancos de leite, se cadastrarem como doadoras e tirarem dúvidas sobre o processo de doação.",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 12.dp, bottom = 32.dp)
            )

            Button(
                onClick = { navController.navigate(Screen.DoadorasList.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ver doadoras cadastradas")
            }

            OutlinedButton(
                onClick = { navController.navigate(Screen.BancosList.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Encontrar banco de leite")
            }

            OutlinedButton(
                onClick = { navController.navigate(Screen.Chatbot.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            ) {
                Text("Falar com o chatbot")
            }
        }
    }
}
