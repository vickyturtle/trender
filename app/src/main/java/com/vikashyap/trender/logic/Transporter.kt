package com.vikashyap.trender.logic

import com.vikashyap.trender.core.models.Repository
import com.vikashyap.trender.core.models.User
import com.vikashyap.trender.logic.entity.TOwner
import com.vikashyap.trender.logic.entity.TRepository

/**
 * Created by vikas on 26/02/18.
 */
fun toUser(owner: TOwner): User {
	val type = if (owner.type.contentEquals("user")) User.TYPE_USER else User.TYPE_ORGANIZATION
	val user = User(owner.login, owner.avatarUrl, type, owner.id)
	return user
}

public fun toRepository(tRepository: TRepository): Repository = Repository(tRepository.id,
		tRepository.name,
		tRepository.fullName,
		toUser(tRepository.owner),
		tRepository.url,
		tRepository.description,
		tRepository.size,
		tRepository.stargazersCount,
		tRepository.watchersCount,
		tRepository.watchersCount,
		tRepository.forksCount,
		tRepository.language,
		tRepository.score)
