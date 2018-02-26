package com.vikashyap.trender.core.home

import android.os.Bundle
import com.vikashyap.trender.core.Presenter
import com.vikashyap.trender.core.Scene
import com.vikashyap.trender.core.models.Repository

/**
 * Created by vikas on 26/02/18.
 */
interface MainScene : Scene {
	fun showRepositories(repositories: List<Repository>)
	fun showErrorMessage(errorMessage: String)
	fun showDetails(detailsExtras: Bundle)
}

interface MainPresenter : Presenter<MainScene> {
	fun onRefreshClicked()
	fun onItemClicked(get: Repository?)
}