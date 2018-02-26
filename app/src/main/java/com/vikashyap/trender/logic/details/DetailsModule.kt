package com.vikashyap.trender.logic.details

import com.vikashyap.trender.core.details.DetailsPresenter
import com.vikashyap.trender.dagger.PerActivity
import dagger.Binds
import dagger.Module

/**
 * Created by vikas on 27/02/18.
 */
@Module
abstract class DetailsModule {

	@PerActivity
	@Binds
	abstract fun detailsPresenter(presenter: DetailsPresenterImpl): DetailsPresenter
}