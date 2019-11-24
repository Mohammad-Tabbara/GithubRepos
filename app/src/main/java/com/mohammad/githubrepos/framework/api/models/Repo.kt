package com.mohammad.githubrepos.framework.api.models

import com.google.gson.annotations.SerializedName

data class Repo(val name: String?,
                val description: String?,
                val owner: Owner,
                @SerializedName("stargazers_count")
                val stars: Int)