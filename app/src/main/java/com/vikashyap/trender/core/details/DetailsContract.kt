package com.vikashyap.trender.core.details

import android.os.Bundle
import com.vikashyap.trender.core.Presenter
import com.vikashyap.trender.core.Scene
import com.vikashyap.trender.core.models.Repository

/**
 * Created by vikas on 27/02/18.
 */
interface DetailsPresenter : Presenter<DetailsScene> {

	fun initWithExtras(bundle: Bundle)

}

interface DetailsScene : Scene {

	fun showRepository(repository: Repository)

}