package com.vikashyap.trender.core.models

/**
 * Created by vikas on 26/02/18.
 */
data class Repository(val id: Long,
                      val name: String,
                      val fullName: String,
                      val user: User,
                      val url: String,
                      val description: String?,
                      val size: Long,
                      val stars: Long,
                      val watchers: Long,
                      val forks: Long,
                      val issues: Long,
                      val language: String?,
                      val score: Float)