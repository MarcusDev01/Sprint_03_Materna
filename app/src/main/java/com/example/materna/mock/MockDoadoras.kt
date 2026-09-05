package com.example.materna.mock

import com.example.materna.model.Doadora
import com.example.materna.model.StatusDoadora

/**
 * Lista de doadoras utilizada para simular o funcionamento do app,
 * já que nesta Sprint não há integração com backend ou banco de dados.
 */
object MockDoadoras {

    val lista = listOf(
        Doadora(
            id = 1,
            nome = "Camila Ferreira",
            idade = 28,
            cidade = "São Paulo",
            bancoDeLeiteVinculado = "Banco de Leite Hospital Pérola Byington",
            litrosDoados = 4.5,
            status = StatusDoadora.ATIVA
        ),
        Doadora(
            id = 2,
            nome = "Juliana Alves",
            idade = 32,
            cidade = "Osasco",
            bancoDeLeiteVinculado = "Banco de Leite Hospital Municipal de Osasco",
            litrosDoados = 1.2,
            status = StatusDoadora.EM_AVALIACAO
        ),
        Doadora(
            id = 3,
            nome = "Renata Souza",
            idade = 25,
            cidade = "Guarulhos",
            bancoDeLeiteVinculado = "Banco de Leite Hospital Maternidade de Guarulhos",
            litrosDoados = 7.8,
            status = StatusDoadora.ATIVA
        ),
        Doadora(
            id = 4,
            nome = "Patrícia Lima",
            idade = 35,
            cidade = "São Paulo",
            bancoDeLeiteVinculado = "Banco de Leite Hospital Pérola Byington",
            litrosDoados = 0.0,
            status = StatusDoadora.INATIVA
        )
    )
}
