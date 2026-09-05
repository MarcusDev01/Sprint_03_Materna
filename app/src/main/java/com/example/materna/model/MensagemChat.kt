package com.example.materna.model

/**
 * Representa uma mensagem trocada no chatbot de apoio às nutrizes.
 */
data class MensagemChat(
    val texto: String,
    val deUsuario: Boolean
)
