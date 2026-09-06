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
import com.example.materna.mock.MockBancos
import com.example.materna.ui.components.MaternaTopBar

/**
 * Exibe os detalhes de um banco de leite específico, recebido por
 * parâmetro de navegação (bancoId).
 */
@Composable
fun BancoDetailScreen(navController: NavHostController, bancoId: Int) {
    val banco = MockBancos.lista.find { it.id == bancoId }

    Scaffold(
        topBar = { MaternaTopBar(title = banco?.nome ?: "Banco de leite", onBack = { navController.popBackStack() }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp)
        ) {
            if (banco == null) {
                Text("Banco de leite não encontrado.")
                return@Column
            }

            InfoLinhaBanco(label = "Endereço", valor = banco.endereco)
            InfoLinhaBanco(label = "Cidade", valor = banco.cidade)
            InfoLinhaBanco(label = "Horário de funcionamento", valor = banco.horarioFuncionamento)
            InfoLinhaBanco(label = "Telefone", valor = banco.telefone)
            InfoLinhaBanco(label = "Realiza exames de doadoras", valor = if (banco.aceitaExames) "Sim" else "Não")
        }
    }
}

@Composable
private fun InfoLinhaBanco(label: String, valor: String) {
    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        Text(text = label, style = MaterialTheme.typography.labelLarge)
        Text(text = valor, style = MaterialTheme.typography.bodyLarge)
    }
}
