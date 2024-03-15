package com.thangavel.cleancodearch.presentation.coin_list.components

import com.thangavel.cleancodearch.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val list: List<Coin> = emptyList(),
    val error: String = "",
)
