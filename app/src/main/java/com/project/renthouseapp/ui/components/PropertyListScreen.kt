package com.project.renthouseapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.project.renthouseapp.data.mock.mockProperties

@Composable
fun PropertyListScreen() {
    // Usamos um Box para sobrepor a lista sobre a imagem e o gradiente
    Box(modifier = Modifier.fillMaxSize()) {

        // Camada de Fundo (Imagem de Topo)
        // TODO: Substitua 'R.drawable.top_image' por uma imagem sua
        // Por enquanto, usaremos um Box roxo como placeholder da imagem
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f) // Ocupa 30% da altura da tela
                .background(Color(0xFFD1C4E9)) // Placeholder roxo claro
        )

        // Camada do Meio (Efeito "Fog" / Gradiente)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colorScheme.background
                        ),
                        startY = 400f // Começa o gradiente um pouco abaixo do topo
                    )
                )
        )

        // Camada da Frente (Lista de Imóveis)
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = 100.dp) // Espaço no topo para ver a imagem
        ) {
            items(mockProperties) { property ->
                PropertyCard(property = property)
            }
        }
    }
}