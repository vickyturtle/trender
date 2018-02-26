package com.vikashyap.trender.app

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import com.vikashyap.trender.core.Presenter
import com.vikashyap.trender.core.Scene
import dagger.android.AndroidInjection
import javax.inject.Inject

/**
 * Created by vikas on 26/02/18.
 */
abstract class BaseActivity<in S : Scene, T : Presenter<S>> : AppCompatActivity(), Scene {

	@Inject
	protected lateinit var presenter: T

	companion object {
		init {
			AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
		}
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		AndroidInjection.inject(this)
		super.onCreate(savedInstanceState)
	}
}