package com.vikashyap.trender.core.models

/**
 * Created by vikas on 26/02/18.
 */
data class Repository(val name: String,
                      val fullName: String,
                      val user: User,
                      val url: String,
                      val description: String?,
                      val size: Long,
                      val starts: Long,
                      val watchers: Long,
                      val score: Float)