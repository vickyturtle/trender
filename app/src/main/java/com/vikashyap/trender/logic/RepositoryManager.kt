package com.vikashyap.trender.logic

import com.vikashyap.trender.logic.entity.TResponse
import io.reactivex.Single
import io.reactivex.processors.BehaviorProcessor
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by vikas on 26/02/18.
 */
@Singleton
class RepositoryManager @Inject public constructor(private val trenderApi: TrenderApi) {

	private val repositoryProcessor: BehaviorProcessor<TResponse> = BehaviorProcessor.create()

	public fun getRepositories(shouldRefresh: Boolean): Single<TResponse> {
		return if (shouldRefresh || !repositoryProcessor.hasValue()) {
			val query = "topic:android"
			trenderApi.getRepositories(query, "stars", "desc")
					.doOnSuccess(repositoryProcessor::onNext)
		} else {
			repositoryProcessor.singleOrError()
		}
	}
}