package cz.tadeasvalenta.sample.domain

import cz.tadeasvalenta.sample.domain.responses.RepoSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface IApi {
    @GET
    fun searchRepositories(@Query("q") q: String = ""): ApiResponse<RepoSearchResponse>
}