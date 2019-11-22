package com.mohammad.githubrepos.presentation.main.trending

import com.mohammad.githubrepos.domain.ILogger

class TrendingPresenterImp(val view: TrendingContract.View, val interactor: TrendingContract.Interactor, val logger: ILogger): TrendingContract.Presentor {
}