package br.com.raphael.punkapp.data.model.response

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class BeerResponse(
    val id: Long,
    val name: String,
    val tagline: String,
    @Json(name = "first_brewed")
    val firstBrewed: String,
    val description: String,
    @Json(name = "image_url")
    val imageUrl: String,
    @Json(name = "food_pairing")
    val foodPairing: List<String>,
    @Json(name = "brewers_tips")
    val brewersTips: String,
) : Parcelable