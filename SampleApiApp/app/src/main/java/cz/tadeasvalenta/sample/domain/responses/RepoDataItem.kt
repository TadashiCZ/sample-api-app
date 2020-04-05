package cz.tadeasvalenta.sample.domain.responses

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class RepoDataItem(
    val id: Int,
    // val nodeId: String,
    val name: String,
    @Json(name = "full_name") val fullName: String,
    val owner: OwnerDataItem,
    val private: Boolean,
    @Json(name = "html_url") val htmlUrl: String,
    @Json(name = "created_at") val createdAt: String, // TODO: convert into time object
    val description: String?,
    val fork: Boolean,
    @Json(name = "stargazers_count") val stargazersCount: Int,
    val score: Double
) : Parcelable
