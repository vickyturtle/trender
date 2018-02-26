package com.vikashyap.trender.dagger

import com.vikashyap.trender.app.home.MainActivity
import com.vikashyap.trender.logic.home.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by vikas on 26/02/18.
 */
@Module
abstract class ActivityBindingModule {
	@PerActivity
	@ContributesAndroidInjector(modules = [(MainActivityModule::class)])
	abstract fun contributeMainActivityInjector(): MainActivity
}