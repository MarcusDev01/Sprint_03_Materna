package com.example.materna.model

/**
 * Representa uma nutriz cadastrada como doadora de leite materno.
 */
data class Doadora(
    val id: Int,
    val nome: String,
    val idade: Int,
    val cidade: String,
    val bancoDeLeiteVinculado: String,
    val litrosDoados: Double,
    val status: StatusDoadora
)

enum class StatusDoadora(val label: String) {
    ATIVA("Ativa"),
    EM_AVALIACAO("Em avaliação"),
    INATIVA("Inativa")
}
