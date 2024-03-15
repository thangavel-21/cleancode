package com.thangavel.cleancodearch.di

import com.thangavel.cleancodearch.common.Constants
import com.thangavel.cleancodearch.data.remote.ApiInterface
import com.thangavel.cleancodearch.data.repository.CoinRepositoryImpl
import com.thangavel.cleancodearch.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiInterface(): ApiInterface {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun provideApiRepository(api: ApiInterface): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}