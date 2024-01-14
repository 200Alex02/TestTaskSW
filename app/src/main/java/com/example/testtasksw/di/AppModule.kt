package com.example.testtasksw.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.testtasksw.common.Constant
import com.example.testtasksw.common.DataStoreManager
import com.example.testtasksw.data.local.db.CoffeeDatabase
import com.example.testtasksw.data.remote.api.ApiService
import com.example.testtasksw.data.repository.CoffeeMenuItemRepositoryImpl
import com.example.testtasksw.data.repository.CoffeeMenuRepositoryImpl
import com.example.testtasksw.data.repository.CoffeeShopsRepositoryImpl
import com.example.testtasksw.data.repository.LoginRepositoryImpl
import com.example.testtasksw.data.repository.RegisterRepositoryImpl
import com.example.testtasksw.domain.repository.CoffeeMenuItemRepository
import com.example.testtasksw.domain.repository.CoffeeMenuRepository
import com.example.testtasksw.domain.repository.CoffeeShopsRepository
import com.example.testtasksw.domain.repository.LoginRepository
import com.example.testtasksw.domain.repository.RegisterRepository
import com.example.testtasksw.domain.use_case.GetCoffeeMenuItemByIdUseCase
import com.example.testtasksw.domain.use_case.GetCoffeeMenuUseCase
import com.example.testtasksw.domain.use_case.GetCoffeeShopsUseCase
import com.example.testtasksw.domain.use_case.GetUserTokenLoginUseCase
import com.example.testtasksw.domain.use_case.GetUserTokenRegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun dataStoreManager(@ApplicationContext appContext: Context): DataStoreManager =
        DataStoreManager(appContext)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(okHttpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCoffeeDataBase(app: Application): CoffeeDatabase {
        return Room.databaseBuilder(
            app, CoffeeDatabase::class.java, Constant.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRegisterRepository(api: ApiService): RegisterRepository {
        return RegisterRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetUserTokenRegisterUseCase(repository: RegisterRepository): GetUserTokenRegisterUseCase {
        return GetUserTokenRegisterUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideLoginRepository(api: ApiService): LoginRepository {
        return LoginRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetUserTokenLoginUseCase(repository: LoginRepository): GetUserTokenLoginUseCase {
        return GetUserTokenLoginUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCoffeeShopsRepository(
        db: CoffeeDatabase,
        api: ApiService
    ): CoffeeShopsRepository {
        return CoffeeShopsRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideGetCoffeeShopsUseCase(repository: CoffeeShopsRepository): GetCoffeeShopsUseCase {
        return GetCoffeeShopsUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCoffeeMenuRepository(
        db: CoffeeDatabase,
        api: ApiService
    ): CoffeeMenuRepository {
        return CoffeeMenuRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideGetCoffeeMenuUseCase(repository: CoffeeMenuRepository): GetCoffeeMenuUseCase {
        return GetCoffeeMenuUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideCoffeeMenuItemRepository(
        db: CoffeeDatabase
    ): CoffeeMenuItemRepository {
        return CoffeeMenuItemRepositoryImpl(db.dao)
    }

    @Provides
    @Singleton
    fun provideGetCoffeeMenuItemByIdUseCase(repository: CoffeeMenuItemRepository): GetCoffeeMenuItemByIdUseCase {
        return GetCoffeeMenuItemByIdUseCase(repository)
    }
}