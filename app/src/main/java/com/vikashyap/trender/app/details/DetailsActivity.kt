package com.vikashyap.trender.app.details

import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.vikashyap.trender.R
import com.vikashyap.trender.app.BaseActivity
import com.vikashyap.trender.core.details.DetailsPresenter
import com.vikashyap.trender.core.details.DetailsScene
import com.vikashyap.trender.core.models.Repository
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : BaseActivity<DetailsScene, DetailsPresenter>(), DetailsScene {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_details)
		presenter.initWithExtras(intent.extras)
	}

	override fun getScene(): DetailsScene {
		return this
	}

	override fun showRepository(repository: Repository) {
		repoName.text = repository.name
		repoAccount.text = repository.user.name
		repoDescription.text = repository.description
		repoDetails.text = getString(R.string.details_text, repository.stars, repository.watchers, repository.forks,
				repository.issues, repository.language)

		Glide.with(this)
				.load(repository.user.avatarUrl)
				.apply(RequestOptions().centerCrop().placeholder(R.drawable.ic_code))
				.into(repoImage)
	}
}
