package com.project.renthouseapp.data

import com.google.firebase.firestore.PropertyName
import java.net.URL

data class Property (
    val id: String = "",

    @get:PropertyName("owner_id")
    @set:PropertyName("owner_id")
    var ownerId: String = "",

    val title: String = "",
    val description: String = "",
    val address: Map<String, String> = mapOf(
        "street" to "",
        "city" to "",
        "state" to ""
    ),
    val price: Double = 0.0,

    @get:PropertyName("image_urls")
    @set:PropertyName("image_urls")
    var imageURLs: List<String> = emptyList(),

    val bedrooms: Int = 0,
    val bathrooms: Int = 0,

    @get:PropertyName("garage_spaces")
    @set:PropertyName("garage_spaces")
    var garageSpaces: Int = 0,

    @get:PropertyName("pets_allowed")
    @set:PropertyName("pets_allowed")
    var petsAllowed: Boolean = false,

    @get:PropertyName("rating_sum")
    @set:PropertyName("rating_sum")
    var ratingSum: Double = 0.0,

    @get:PropertyName("rating_count")
    @set:PropertyName("rating_count")
    var ratingCount: Int = 0,
) {
    //função para calcular a média de forma segura
    fun getAverageRating(): Float {
        if (ratingCount == 0) return 0f
        return (ratingSum / ratingCount).toFloat()
    }
}