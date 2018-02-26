package com.vikashyap.trender.logic

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

/**
 * Created by vikas on 26/02/18.
 */
class GithubInterceptor public @Inject constructor() : Interceptor {

	override fun intercept(chain: Interceptor.Chain?): Response {
		val builder = chain!!.request().newBuilder()
		builder.addHeader("Accept", "application/vnd.github.v3+json")
		return chain.proceed(builder.build())
	}
}