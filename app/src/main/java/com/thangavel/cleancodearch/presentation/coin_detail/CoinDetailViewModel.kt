package com.thangavel.cleancodearch.presentation.coin_detail.components

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thangavel.cleancodearch.common.Constants
import com.thangavel.cleancodearch.common.Resource
import com.thangavel.cleancodearch.domain.use_case.get_coin.CoinUseCase
import com.thangavel.cleancodearch.domain.use_case.get_coin_details.CoinDetailUseCase
import com.thangavel.cleancodearch.presentation.coin_list.components.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val coinDetailUseCase: CoinDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.COIN_ID)?.let {
            getCoin(coinId = it)
        }
    }

    private fun getCoin(coinId: String) {
        coinDetailUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = CoinDetailState(list = result.data)
                }

                is Resource.Error -> {
                    _state.value = CoinDetailState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }
}