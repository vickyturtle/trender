package com.vikashyap.trender.logic

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by vikas on 26/02/18.
 */
class SchedulerProvider @Inject constructor() {

	fun getUiScheduler(): Scheduler {
		return AndroidSchedulers.mainThread()
	}

	fun getIoScheduler(): Scheduler {
		return Schedulers.io()
	}

	fun getComputationScheduler(): Scheduler {
		return Schedulers.computation()
	}
}