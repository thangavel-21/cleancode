package com.thangavel.cleancodearch.presentation.coin_detail.components

import com.thangavel.cleancodearch.domain.model.Coin
import com.thangavel.cleancodearch.domain.model.CoinDetails

data class CoinDetailState(
    val isLoading: Boolean = false,
    val list: CoinDetails? = null,
    val error: String = "",
)
