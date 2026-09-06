package com.example.materna.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.materna.ui.components.MaternaTopBar

/**
 * Formulário simples de cadastro de nutriz doadora.
 * Como não há backend nesta Sprint, o cadastro apenas confirma
 * o preenchimento e retorna para a lista de doadoras.
 */
@Composable
fun CadastroDoadoraScreen(navController: NavHostController) {
    var nome by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }
    var cidade by remember { mutableStateOf("") }
    var mensagem by remember { mutableStateOf("") }

    Scaffold(
        topBar = { MaternaTopBar(title = "Cadastro de doadora", onBack = { navController.popBackStack() }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp)
        ) {
            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome completo") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = idade,
                onValueChange = { idade = it.filter { c -> c.isDigit() } },
                label = { Text("Idade") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            )

            OutlinedTextField(
                value = cidade,
                onValueChange = { cidade = it },
                label = { Text("Cidade") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
            )

            Button(
                onClick = {
                    mensagem = if (nome.isBlank() || idade.isBlank() || cidade.isBlank()) {
                        "Preencha todos os campos para concluir o cadastro."
                    } else {
                        "Cadastro de $nome registrado com sucesso! Em breve nossa equipe entrará em contato."
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                Text("Concluir cadastro")
            }

            if (mensagem.isNotBlank()) {
                Text(text = mensagem, modifier = Modifier.padding(top = 16.dp))
            }
        }
    }
}
