package com.mohammad.githubrepos.presentation._common.rxjava

import io.reactivex.observers.DisposableSingleObserver

abstract class ApiListener<T: Any>: DisposableSingleObserver<T>()