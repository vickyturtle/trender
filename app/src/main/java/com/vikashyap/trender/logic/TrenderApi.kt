package com.vikashyap.trender.logic

import com.vikashyap.trender.logic.entity.TResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by vikas on 26/02/18.
 */
interface TrenderApi {

	@GET("/search/repositories")
	fun getRepositories(@Query("q") query: String,
	                    @Query("sort") sortingField: String,
	                    @Query("order") sortingOrder: String): Single<TResponse>
}