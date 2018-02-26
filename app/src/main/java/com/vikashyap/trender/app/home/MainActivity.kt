package com.vikashyap.trender.app.home

import android.os.Bundle
import com.vikashyap.trender.R
import com.vikashyap.trender.app.BaseActivity
import com.vikashyap.trender.core.home.MainPresenter
import com.vikashyap.trender.core.home.MainScene

class MainActivity : BaseActivity<MainScene, MainPresenter>(), MainScene {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	override fun getScene(): MainScene {
		return this
	}
}
