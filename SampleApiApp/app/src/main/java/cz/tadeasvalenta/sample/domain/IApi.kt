package cz.tadeasvalenta.sample.domain

import androidx.lifecycle.LiveData
import cz.tadeasvalenta.sample.domain.responses.RepoSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IApi {
    @GET("/search/repositories") fun searchRepositories(@Query("q") q: String): LiveData<ApiResponse<RepoSearchResponse>>
}