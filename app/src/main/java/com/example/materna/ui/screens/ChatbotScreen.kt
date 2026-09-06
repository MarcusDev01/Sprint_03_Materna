package com.example.materna.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.materna.model.MensagemChat
import com.example.materna.ui.components.MaternaTopBar

/**
 * Chatbot de apoio simulado com respostas mockadas por palavra-chave,
 * conforme previsto na proposta do Materna+ (atendimento quando necessário).
 */
@Composable
fun ChatbotScreen(navController: NavHostController) {
    val mensagens = remember {
        mutableStateListOf(
            MensagemChat("Olá! Eu sou a assistente do Materna+. Posso te ajudar com dúvidas sobre doação de leite materno.", deUsuario = false)
        )
    }
    var textoAtual by remember { mutableStateOf("") }
    val listState = rememberLazyListState()

    LaunchedEffect(mensagens.size) {
        if (mensagens.isNotEmpty()) listState.animateScrollToItem(mensagens.size - 1)
    }

    Scaffold(
        topBar = { MaternaTopBar(title = "Assistente Materna+", onBack = { navController.popBackStack() }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(mensagens) { mensagem ->
                    BolhaMensagem(mensagem)
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = textoAtual,
                    onValueChange = { textoAtual = it },
                    modifier = Modifier.weight(1f),
                    label = { Text("Digite sua dúvida") }
                )
                IconButton(onClick = {
                    if (textoAtual.isNotBlank()) {
                        mensagens.add(MensagemChat(textoAtual, deUsuario = true))
                        mensagens.add(MensagemChat(gerarResposta(textoAtual), deUsuario = false))
                        textoAtual = ""
                    }
                }) {
                    Icon(Icons.AutoMirrored.Filled.Send, contentDescription = "Enviar")
                }
            }
        }
    }
}

@Composable
private fun BolhaMensagem(mensagem: MensagemChat) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .wrapContentWidth()
                .align(if (mensagem.deUsuario) Alignment.CenterEnd else Alignment.CenterStart),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (mensagem.deUsuario)
                    MaterialTheme.colorScheme.primary
                else
                    MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Text(
                text = mensagem.texto,
                modifier = Modifier.padding(12.dp),
                color = if (mensagem.deUsuario) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

/**
 * Gera uma resposta mockada com base em palavras-chave da pergunta do usuário.
 * Simula o comportamento de um chatbot sem depender de integração externa.
 */
private fun gerarResposta(pergunta: String): String {
    val texto = pergunta.lowercase()
    return when {
        "doar" in texto || "doação" in texto -> "Para doar, procure o banco de leite mais próximo pela tela 'Encontrar banco de leite' e faça seu cadastro."
        "exame" in texto -> "Alguns bancos de leite realizam exames no local. Você pode conferir na tela de detalhes de cada banco."
        "cadastro" in texto || "cadastrar" in texto -> "Você pode se cadastrar como doadora na lista de doadoras, tocando no botão de adicionar."
        "litro" in texto || "quanto" in texto -> "Cada litro de leite doado pode alimentar vários bebês prematuros em UTIs neonatais."
        else -> "Ainda estou aprendendo sobre esse assunto. Consulte um banco de leite próximo para mais informações."
    }
}
