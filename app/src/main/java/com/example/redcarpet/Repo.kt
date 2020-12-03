package com.example.redcarpet


import com.example.redcarpet.model.News
import com.example.redcarpet.network.APIRequest
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repo @Inject constructor(private val newsService : APIRequest){
    fun getTopHeadlines():Single<News>{
        return newsService.getTopHeadlines()
            .subscribeOn(Schedulers.io())

    }

    
}
