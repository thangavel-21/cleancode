package com.thangavel.cleancodearch.domain.use_case.get_coin

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.thangavel.cleancodearch.common.Resource
import com.thangavel.cleancodearch.data.remote.dto.CoinDto
import com.thangavel.cleancodearch.data.remote.dto.toCoin
import com.thangavel.cleancodearch.domain.model.Coin
import com.thangavel.cleancodearch.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class CoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "unexpexted"))
        } catch (e: IOException) {
            emit(Resource.Error("not react6 serbvier"))
        }
    }
}