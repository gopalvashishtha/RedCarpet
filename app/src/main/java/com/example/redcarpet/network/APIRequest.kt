package com.example.redcarpet.network

import com.example.redcarpet.model.News
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET


interface APIRequest {
    @GET("top-headlines?country=in&apiKey=c7dccd29587f4635840658a96c6236fc")
    fun getTopHeadlines():Single<News>
}
