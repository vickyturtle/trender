package com.vikashyap.trender.dagger

import com.vikashyap.trender.app.details.DetailsActivity
import com.vikashyap.trender.app.home.MainActivity
import com.vikashyap.trender.logic.details.DetailsModule
import com.vikashyap.trender.logic.home.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by vikas on 26/02/18.
 */
@Module
abstract class ActivityBindingModule {
	@PerActivity
	@ContributesAndroidInjector(modules = [(MainModule::class)])
	abstract fun contributeMainActivityInjector(): MainActivity


	@PerActivity
	@ContributesAndroidInjector(modules = [(DetailsModule::class)])
	abstract fun contributeDetails8ActivityInjector(): DetailsActivity
}