package br.com.raphael.punkapp.di

import br.com.raphael.punkapp.data.repository.BeersRepository
import br.com.raphael.punkapp.data.repository.BeersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindBeersRepository(repository: BeersRepositoryImpl): BeersRepository
}