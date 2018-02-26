package com.vikashyap.trender.logic

import com.vikashyap.trender.core.models.Repository
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.processors.BehaviorProcessor
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vikas on 26/02/18.
 */
@Singleton
class RepositoryManager @Inject public constructor(private val trenderApi: TrenderApi) {

	private val repositoryProcessor: BehaviorProcessor<List<Repository>> = BehaviorProcessor.create()

	public fun getRepositories(shouldRefresh: Boolean): Single<List<Repository>> {
		return if (shouldRefresh || !repositoryProcessor.hasValue()) {
			val query = "topic:android"
			trenderApi.getRepositories(query, "stars", "desc")
					.map { response ->
						val responseList: MutableList<Repository> = ArrayList<Repository>()
						response.items.mapTo(responseList) { toRepository(it) }
						return@map responseList.toList()
					}
					.doOnSuccess(repositoryProcessor::onNext)
		} else {
			repositoryProcessor.take(1).singleOrError()
		}
	}

	public fun findRepoById(id: Long): Single<Repository> {
		return repositoryProcessor.take(1)
				.flatMap { Flowable.fromIterable(it) }
				.filter { it.id == id }
				.firstOrError()
	}
}