package com.example.materna.model

/**
 * Representa um Banco de Leite Humano onde a nutriz pode doar ou fazer exames.
 */
data class BancoDeLeite(
    val id: Int,
    val nome: String,
    val endereco: String,
    val cidade: String,
    val horarioFuncionamento: String,
    val telefone: String,
    val aceitaExames: Boolean
)
