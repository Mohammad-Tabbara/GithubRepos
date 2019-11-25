package com.mohammad.githubrepos.framework.api.models

import com.google.gson.annotations.SerializedName

data class RepoWrapper(@SerializedName("items") val repos: List<Repo>)