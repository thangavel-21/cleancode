package com.thangavel.cleancodearch.data.repository

import com.thangavel.cleancodearch.data.remote.ApiInterface
import com.thangavel.cleancodearch.data.remote.dto.CoinDetailsDto
import com.thangavel.cleancodearch.data.remote.dto.CoinDto
import com.thangavel.cleancodearch.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: ApiInterface
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinsDetail(coinId: String): CoinDetailsDto {
        return api.getCoinDetail(coinId)
    }
}