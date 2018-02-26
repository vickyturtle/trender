package com.vikashyap.trender.logic.home

import android.app.Application
import com.vikashyap.trender.R
import com.vikashyap.trender.core.home.MainPresenter
import com.vikashyap.trender.core.home.MainScene
import com.vikashyap.trender.logic.BasePresenterImpl
import com.vikashyap.trender.logic.RepositoryManager
import com.vikashyap.trender.logic.SchedulerProvider
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import javax.inject.Inject

/**
 * Created by vikas on 26/02/18.
 */
class MainPresenterImpl @Inject public constructor(private val repositoryManager: RepositoryManager,
                                                   private val schedulerProvider: SchedulerProvider,
                                                   private val application: Application) :
		BasePresenterImpl<MainScene>(), MainPresenter {

	override fun onSceneAdded(s: MainScene) {
		super.onSceneAdded(s)
		repositoryManager.getRepositories(false)
				.subscribeOn(schedulerProvider.getIoScheduler())
				.observeOn(schedulerProvider.getUiScheduler())
				.subscribe({ t ->
					scene?.showRepositories(t)
				}, { throwable ->
					scene?.showErrorMessage(getErrorMessage(throwable))
					Timber.w(throwable)
				})
	}

	private fun getErrorMessage(throwable: Throwable?): String {
		return when (throwable) {
			is HttpException -> application.getString(R.string.error_server_error)
			is IOException -> application.getString(R.string.error_internet)
			else -> application.getString(R.string.error_unknown)

		}
	}
}