package com.thangavel.cleancodearch.domain.model

import com.thangavel.cleancodearch.data.remote.dto.Tag
import com.thangavel.cleancodearch.data.remote.dto.TeamMember
import com.thangavel.cleancodearch.data.remote.dto.Whitepaper

data class CoinDetails(
    val coinId: String,
    val is_active: Boolean,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val tags: List<String>,
    val team: List<TeamMember>,
)
