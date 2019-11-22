package com.mohammad.githubrepos.domain


interface ILogger {

    fun d(t: Throwable)
    fun d(msg: String)
    fun e(t: Throwable)
    fun e(msg: String)
}