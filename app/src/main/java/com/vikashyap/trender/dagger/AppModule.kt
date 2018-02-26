package com.vikashyap.trender.dagger

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

/**
 * Created by vikas on 26/02/18.
 */
@Module
@Singleton
class AppModule(val application: Application) {

	@Provides
	@Reusable
	fun provideSharedPreferences(application: Application): SharedPreferences {
		return PreferenceManager.getDefaultSharedPreferences(application)
	}
}