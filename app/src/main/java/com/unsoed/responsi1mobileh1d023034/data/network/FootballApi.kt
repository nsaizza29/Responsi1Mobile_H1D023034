package com.unsoed.responsi1mobileh1d023034.data.network

import com.unsoed.responsi1mobileh1d023034.data.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface FootballApi {
    @GET("teams/{id}")
    suspend fun getTeamById(
        @Header("X-Auth-Token") token: String,
        @Path("id") teamId: String
    ): Response<SearchResponse>
}
