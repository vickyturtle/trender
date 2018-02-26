package com.vikashyap.trender.app.home

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.vikashyap.trender.R
import com.vikashyap.trender.app.BaseActivity
import com.vikashyap.trender.app.details.DetailsActivity
import com.vikashyap.trender.core.home.MainPresenter
import com.vikashyap.trender.core.home.MainScene
import com.vikashyap.trender.core.models.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainScene, MainPresenter>(), MainScene {


	private val adapter = MainAdapter(object : MainAdapter.ClickListener {
		override fun onItemClicked(view: View, position: Int) {
			presenter.onItemClicked(repositories?.get(position))
		}
	})

	private var repositories: List<Repository>? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setSupportActionBar(toolbar)
		setLoadingState()

		setUpRecyclerView()
		refreshImage.setOnClickListener({
			presenter.onRefreshClicked()
			adapter.repositories = null
			adapter.notifyDataSetChanged()
			setLoadingState()
		})

	}

	private fun setLoadingState() {
		refreshImage.isEnabled = false
		messagePrompt.setText(R.string.fetching_repository)
		messagePrompt.visibility = View.VISIBLE
		errorIcon.visibility = View.GONE
		progressBar.visibility = View.VISIBLE
	}

	private fun setUpRecyclerView() {
		repositoryRecyclerView.layoutManager = LinearLayoutManager(this)
		repositoryRecyclerView.adapter = adapter
		repositoryRecyclerView.addItemDecoration(object : RecyclerView.ItemDecoration() {
			override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?,
			                            state: RecyclerView.State?) {
				outRect?.top = resources.getDimensionPixelSize(R.dimen.spacing_normal)
			}
		})
	}

	override fun getScene(): MainScene {
		return this
	}

	override fun showRepositories(repositories: List<Repository>) {
		this.repositories = repositories
		messagePrompt.visibility = View.GONE
		errorIcon.visibility = View.GONE
		progressBar.visibility = View.GONE
		refreshImage.isEnabled = true
		adapter.repositories = repositories
		adapter.notifyDataSetChanged()
	}

	override fun showDetails(detailsExtras: Bundle) {
		val intent = Intent(this, DetailsActivity::class.java)
		intent.putExtras(detailsExtras)
		startActivity(intent)
	}

	override fun showErrorMessage(errorMessage: String) {
		messagePrompt.text = errorMessage
		messagePrompt.visibility = View.VISIBLE
		errorIcon.visibility = View.VISIBLE
		progressBar.visibility = View.GONE
		refreshImage.isEnabled = true
	}
}
