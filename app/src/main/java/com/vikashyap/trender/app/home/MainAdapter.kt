package com.vikashyap.trender.app.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.vikashyap.trender.R
import com.vikashyap.trender.core.models.Repository
import kotlinx.android.synthetic.main.item_repository.view.*

/**
 * Created by vikas on 27/02/18.
 */
class MainAdapter(var clickListener: ClickListener) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

	var repositories: List<Repository>? = null

	override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
		val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_repository, parent, false)
		return ViewHolder(view, clickListener)
	}

	override fun getItemCount(): Int {
		return if (repositories != null) repositories!!.size else 0
	}

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		holder.authorView.text = repositories!![position].user.name
		holder.descriptionView.text = repositories!![position].description
		holder.nameView.text = repositories!![position].name
		Glide.with(holder.itemView)
				.load(repositories!![position].user.avatarUrl)
				.apply(RequestOptions().centerCrop().placeholder(R.drawable.ic_code))
				.into(holder.repoImageView)

	}

	class ViewHolder(itemView: View, val clickListener: ClickListener) : RecyclerView.ViewHolder(itemView) {
		val nameView: TextView = itemView.repoName
		val descriptionView: TextView = itemView.repoDescription
		val authorView: TextView = itemView.repoAccount
		val repoImageView: ImageView = itemView.repoImage


		init {
			itemView.setOnClickListener {
				clickListener.onItemClicked(it, adapterPosition)
			}
		}
	}

	interface ClickListener {
		fun onItemClicked(view: View, position: Int)
	}
}