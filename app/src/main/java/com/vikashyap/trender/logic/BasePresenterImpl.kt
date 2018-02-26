package com.vikashyap.trender.logic

import com.vikashyap.trender.core.Presenter
import com.vikashyap.trender.core.Scene

/**
 * Created by vikas on 26/02/18.
 */
abstract class BasePresenterImpl<T : Scene> : Presenter<T> {

	protected var scene: T? = null

	override fun onSceneAdded(scene: T) {
		this.scene = scene
	}

	override fun onSceneRemoved() {
		this.scene = null
	}
}