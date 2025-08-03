package com.yosry.dev.taskone.di

import android.content.Context
import androidx.room.Room
import com.yosry.dev.taskone.data.local.AppDatabase
import com.yosry.dev.taskone.data.local.dao.AreaDao
import com.yosry.dev.taskone.data.local.dao.CategoryDao
import com.yosry.dev.taskone.data.local.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration(false) // Consider a proper migration strategy for production
            .build()
    }


    @Provides
    @Singleton // DAOs are typically singletons as well, tied to the database instance
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }

    @Provides
    @Singleton
    fun provideCategoryDao(appDatabase: AppDatabase): CategoryDao {
        return appDatabase.categoryDao()
    }

    @Provides
    @Singleton
    fun provideAreaDao(appDatabase: AppDatabase): AreaDao {
        return appDatabase.areaDao()
    }
}
