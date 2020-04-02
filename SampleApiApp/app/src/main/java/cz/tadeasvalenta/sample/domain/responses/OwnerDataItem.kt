package cz.tadeasvalenta.sample.domain.responses

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class OwnerDataItem (
    val login: String,
    val id: Int,
 // val nodeId: String,
    @Json(name = "avatar_url") val avatarUrl: String,
    val url: String,
    val type: String
)
