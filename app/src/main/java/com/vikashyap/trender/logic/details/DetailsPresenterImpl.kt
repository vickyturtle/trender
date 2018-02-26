package com.vikashyap.trender.logic.details

import android.os.Bundle
import com.vikashyap.trender.core.details.DetailsPresenter
import com.vikashyap.trender.core.details.DetailsScene
import com.vikashyap.trender.logic.BasePresenterImpl
import com.vikashyap.trender.logic.RepositoryManager
import com.vikashyap.trender.logic.SchedulerProvider
import io.reactivex.disposables.Disposable
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by vikas on 27/02/18.
 */

const val EXTRA_ID = "EXTRA_ID"

fun getDetailsExtras(id: Long): Bundle {
	val bundle = Bundle()
	bundle.putLong(EXTRA_ID, id)
	return bundle
}

class DetailsPresenterImpl @Inject public constructor(private val repositoryManager: RepositoryManager,
                                                      private val schedulerProvider: SchedulerProvider) :
		BasePresenterImpl<DetailsScene>(), DetailsPresenter {

	var id: Long = 0
	var repoDisposable: Disposable? = null
	override fun initWithExtras(bundle: Bundle) {
		id = bundle.getLong(EXTRA_ID)
	}

	override fun onSceneAdded(s: DetailsScene) {
		super.onSceneAdded(s)
		repoDisposable = repositoryManager.findRepoById(id)
				.subscribeOn(schedulerProvider.getIoScheduler())
				.observeOn(schedulerProvider.getUiScheduler())
				.subscribe({ scene?.showRepository(it) }, Timber::w)
	}

	override fun onSceneRemoved() {
		super.onSceneRemoved()
		repoDisposable?.dispose()
	}


}