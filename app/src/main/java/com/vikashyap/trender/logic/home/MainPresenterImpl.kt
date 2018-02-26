package com.vikashyap.trender.logic.home

import com.vikashyap.trender.core.home.MainPresenter
import com.vikashyap.trender.core.home.MainScene
import com.vikashyap.trender.logic.BasePresenterImpl
import com.vikashyap.trender.logic.RepositoryManager
import com.vikashyap.trender.logic.SchedulerProvider
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by vikas on 26/02/18.
 */
class MainPresenterImpl @Inject public constructor(private val repositoryManager: RepositoryManager,
                                                   private val schedulerProvider: SchedulerProvider) :
		BasePresenterImpl<MainScene>(), MainPresenter {

	override fun onSceneAdded(scene: MainScene) {
		super.onSceneAdded(scene)
		repositoryManager.getRepositories(false)
				.subscribeOn(schedulerProvider.getIoScheduler())
				.observeOn(schedulerProvider.getUiScheduler())
				.subscribe({ t ->

				}, { throwable ->
					Timber.w(throwable)
				})
	}
}