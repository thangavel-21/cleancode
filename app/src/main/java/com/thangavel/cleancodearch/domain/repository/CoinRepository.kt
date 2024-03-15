package com.thangavel.cleancodearch.domain.repository

import com.thangavel.cleancodearch.data.remote.dto.CoinDetailsDto
import com.thangavel.cleancodearch.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinsDetail(coinId: String): CoinDetailsDto
}