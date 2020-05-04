package com.example.mvp

import com.example.networklibrary.Result

interface HomeView {

    fun onShowLoading()
    fun onHideLoading()
    fun onResponse(result: List<Result>)
    fun onFailure(error:Throwable)
}