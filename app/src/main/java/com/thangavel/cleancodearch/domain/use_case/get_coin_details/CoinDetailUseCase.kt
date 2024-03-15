package com.thangavel.cleancodearch.domain.use_case.get_coin_details

import android.net.http.HttpException
import com.thangavel.cleancodearch.common.Resource
import com.thangavel.cleancodearch.data.remote.dto.toCoinDetail
import com.thangavel.cleancodearch.domain.model.CoinDetails
import com.thangavel.cleancodearch.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class CoinDetailUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinID: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoinsDetail(coinID).toCoinDetail()
            emit(Resource.Success(coins))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "unexpexted"))
        } catch (e: IOException) {
            emit(Resource.Error("not react6 serbvier"))
        }
    }
}