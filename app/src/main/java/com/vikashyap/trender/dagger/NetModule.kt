package com.vikashyap.trender.dagger

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.vikashyap.trender.BuildConfig
import com.vikashyap.trender.logic.GithubInterceptor
import com.vikashyap.trender.logic.TrenderApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by vikas on 26/02/18.
 */
@Module
@Singleton
abstract class NetModule {

	@Module
	companion object {

		@Singleton
		@JvmStatic
		@Provides
		fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, githubInterceptor: GithubInterceptor):
				OkHttpClient {
			return OkHttpClient.Builder()
					.addInterceptor(httpLoggingInterceptor)
					.addInterceptor(githubInterceptor)
					.connectTimeout(30, TimeUnit.SECONDS)
					.readTimeout(30, TimeUnit.SECONDS)
					.writeTimeout(30, TimeUnit.SECONDS)
					.build()
		}

		@Provides
		@JvmStatic
		fun provideHttpLogger(): HttpLoggingInterceptor {
			return HttpLoggingInterceptor().setLevel(
					if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
		}

		@Provides
		@JvmStatic
		fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
			return Retrofit.Builder()
					.baseUrl(BuildConfig.BASE_URL)
					.client(okHttpClient)
					.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
					.addConverterFactory(GsonConverterFactory.create(gson))
					.build()
		}

		@Provides
		@JvmStatic
		fun provideGson(): Gson = GsonBuilder().setFieldNamingPolicy(
				FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()


		@Singleton
		@Provides
		@JvmStatic
		fun provideTrenderApi(retrofit: Retrofit): TrenderApi = retrofit.create(TrenderApi::class.java)
	}
}
