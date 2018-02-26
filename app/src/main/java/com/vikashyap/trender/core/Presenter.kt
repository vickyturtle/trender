package com.vikashyap.trender.core

/**
 * Created by vikas on 26/02/18.
 */
interface Presenter<in T : Scene> {
	fun onSceneAdded(scene: T)
	fun onSceneRemoved()
}