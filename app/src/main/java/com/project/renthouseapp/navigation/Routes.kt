package com.project.renthouseapp.navigation

//usamos uma constante para evitar erros
const val PROPERTY_ID_ARG = "propertyId"

sealed class Routes(val route: String) {
    //Telas de autenticação
    data object Login : Routes("login")
    data object SignUp : Routes("signUp")

    //Telas principais

    //Tela com lista de todos os imóveis
    data object PropertyList : Routes("propertyList")

    //tela onde o usuário vê seus anuncios
    data object MyListings : Routes("myListings")

    //Tela de detalhes de um imóvel especifico
    data object PropertyDetail : Routes("propertyDetail/{$PROPERTY_ID_ARG}") {
        fun createRoute(propertyId: String?) = "add_edit_property/${propertyId ?: "new"}"
    }
}