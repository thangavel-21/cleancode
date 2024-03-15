package com.thangavel.cleancodearch.presentation.coin_list.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thangavel.cleancodearch.common.Resource
import com.thangavel.cleancodearch.domain.use_case.get_coin.CoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinUseCase: CoinUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoin()
    }

    private fun getCoin() {
        getCoinUseCase().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = CoinListState(list = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value = CoinListState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }
}