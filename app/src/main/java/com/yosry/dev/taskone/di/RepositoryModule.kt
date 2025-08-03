package com.yosry.dev.taskone.di

import com.yosry.dev.taskone.data.repository.UserRepositoryImpl
import com.yosry.dev.taskone.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class) // Or an appropriate component like ViewModelComponent if scoped differently
abstract class RepositoryModule {

    @Binds
    @Singleton // Ensure the repository is a singleton if UserRepositoryImpl is annotated with @Singleton
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository
}