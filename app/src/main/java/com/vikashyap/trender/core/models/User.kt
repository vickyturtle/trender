package com.vikashyap.trender.core.models

/**
 * Created by vikas on 26/02/18.
 */

data class User(val name: String,
                val avatarUrl: String,
                val type: Int,
                val id: Long) {
	companion object {
		const val TYPE_USER = 0x1
		const val TYPE_ORGANIZATION = 0x2
	}
}