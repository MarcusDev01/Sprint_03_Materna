package com.example.materna.mock

import com.example.materna.model.BancoDeLeite

object MockBancos {

    val lista = listOf(
        BancoDeLeite(
            id = 1,
            nome = "Banco de Leite Hospital Pérola Byington",
            endereco = "Av. Brig. Luís Antônio, 683 - Bela Vista",
            cidade = "São Paulo",
            horarioFuncionamento = "Seg. a Sex., 7h às 17h",
            telefone = "(11) 2361-9000",
            aceitaExames = true
        ),
        BancoDeLeite(
            id = 2,
            nome = "Banco de Leite Hospital Municipal de Osasco",
            endereco = "Rua Adjuto Ferreira, 105 - Centro",
            cidade = "Osasco",
            horarioFuncionamento = "Seg. a Sáb., 8h às 16h",
            telefone = "(11) 3699-2200",
            aceitaExames = true
        ),
        BancoDeLeite(
            id = 3,
            nome = "Banco de Leite Hospital Maternidade de Guarulhos",
            endereco = "Rua Barão de Jundiaí, 400 - Centro",
            cidade = "Guarulhos",
            horarioFuncionamento = "Seg. a Sex., 7h às 15h",
            telefone = "(11) 2408-4500",
            aceitaExames = false
        )
    )
}