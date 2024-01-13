package com.example.testtasksw.di

import android.content.Context
import com.example.testtasksw.common.Constant
import com.example.testtasksw.common.DataStoreManager
import com.example.testtasksw.data.remote.api.ApiService
import com.example.testtasksw.data.repository.LoginRepositoryImpl
import com.example.testtasksw.data.repository.RegisterRepositoryImpl
import com.example.testtasksw.domain.repository.LoginRepository
import com.example.testtasksw.domain.repository.RegisterRepository
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
            level = HttpLoggingInterceptor.Level.BODY // Уровень подробного логирования
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
}