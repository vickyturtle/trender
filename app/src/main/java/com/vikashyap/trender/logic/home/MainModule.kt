package com.vikashyap.trender.logic.home

import com.vikashyap.trender.core.home.MainPresenter
import com.vikashyap.trender.dagger.PerActivity
import dagger.Binds
import dagger.Module

/**
 * Created by vikas on 26/02/18.
 */
@Module
abstract class MainModule {

	@PerActivity
	@Binds
	abstract fun mainPresenter(mainPresenter: MainPresenterImpl): MainPresenter
}