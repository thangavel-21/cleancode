package com.thangavel.cleancodearch.data.remote

import com.thangavel.cleancodearch.data.remote.dto.CoinDetailsDto
import com.thangavel.cleancodearch.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetail(@Path("coinId") coinId: String): CoinDetailsDto

}