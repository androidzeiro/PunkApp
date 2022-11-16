package br.com.raphael.punkapp.di

import br.com.raphael.punkapp.data.remote.BeersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideAccessApi(retrofit: Retrofit): BeersApi {
        return retrofit.create(BeersApi::class.java)
    }
}