package com.example.materna.navigation

/**
 * Rotas de navegação do app. Mantidas em um único lugar para facilitar
 * a manutenção e evitar strings soltas espalhadas pelas telas.
 */
sealed class Screen(val route: String) {
    object Home : Screen("home")
    object DoadorasList : Screen("doadoras")
    object DoadoraDetail : Screen("doadoras/{doadoraId}") {
        fun createRoute(doadoraId: Int) = "doadoras/$doadoraId"
    }
    object CadastroDoadora : Screen("doadoras/cadastro")
    object BancosList : Screen("bancos")
    object BancoDetail : Screen("bancos/{bancoId}") {
        fun createRoute(bancoId: Int) = "bancos/$bancoId"
    }
    object Chatbot : Screen("chatbot")
}
