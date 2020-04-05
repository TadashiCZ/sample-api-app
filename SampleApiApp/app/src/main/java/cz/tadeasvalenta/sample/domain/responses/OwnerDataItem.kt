package cz.tadeasvalenta.sample.domain.responses

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class OwnerDataItem (
    val login: String,
    val id: Int,
 // val nodeId: String,
    @Json(name = "avatar_url") val avatarUrl: String,
    val url: String,
    val type: String
) : Parcelable
