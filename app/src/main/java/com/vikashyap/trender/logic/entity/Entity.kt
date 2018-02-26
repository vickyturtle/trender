package com.vikashyap.trender.logic.entity

/**
 * Created by vikas on 26/02/18.
 */
data class TOwner(val login: String,
                  val avatarUrl: String,
                  val type: String,
                  val id: Long)

data class TRepository(val name: String,
                       val fullName: String,
                       val owner: TOwner,
                       val url: String,
                       val description: String?,
                       val size: Long,
                       val stargazersCount: Long,
                       val watchersCount: Long,
                       val score: Float)

data class TResponse(val totalCount: Int,
                     val items: List<TRepository>,
                     val incompleteResults: Boolean)