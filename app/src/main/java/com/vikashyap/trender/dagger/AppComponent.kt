package com.vikashyap.trender.dagger

import android.app.Application
import com.vikashyap.trender.TrenderApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by vikas on 26/02/18.
 */
@Singleton
@Component(modules = [AppModule::class, ActivityBindingModule::class, AndroidSupportInjectionModule::class])
interface AppComponent : AndroidInjector<TrenderApp> {

	@Component.Builder
	interface Builder {

		@BindsInstance
		fun application(application: Application): AppComponent.Builder

		fun appModule(appModule: AppModule): AppComponent.Builder


		fun build(): AppComponent
	}
}