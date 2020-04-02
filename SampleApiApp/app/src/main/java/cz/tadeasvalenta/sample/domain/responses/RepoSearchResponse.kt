package cz.tadeasvalenta.sample.domain.responses

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class RepoSearchResponse(
    @Json(name = "total_count") val totalCount: Int,
    @Json(name = "incomplete_results")val incompleteResults: Boolean,
    val items: List<RepoDataItem>
)
