package com.vikashyap.trender

import android.app.Activity
import com.vikashyap.trender.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by vikas on 26/02/18.
 */
class TrenderApp : DaggerApplication() {

	@Inject
	lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

	override fun onCreate() {
		super.onCreate()
		if (BuildConfig.DEBUG) {
			Timber.plant(Timber.DebugTree())
		} else {
			//TODO(vikas) : Plant custom tree which sends caught error and warnings to the reporting api
			Timber.plant(Timber.DebugTree())
		}
	}

	override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
		return DaggerAppComponent.builder().application(this).build()
	}
}