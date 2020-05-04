package com.example.mvp

import com.example.networklibrary.HomeDatasource
import com.example.networklibrary.HomeResponse
import com.example.networklibrary.NetworkProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(private val view: HomeView) { // view Sebagai constructor

    fun discoverMovie(){
        view.onShowLoading()

        val datasource = NetworkProvider.provideHttpAdapter().create(HomeDatasource::class.java) // memanggil api
        datasource.discoverMovie().enqueue(object : Callback<HomeResponse> { // Callback Retrovit // memanggil interface homeresponse
            override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                view.onHideLoading()
                view.onFailure(t)
            }

            override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {
                view.onHideLoading()
                view.onResponse(response.body()?.result ?: emptyList())
            }

        })
    }
}