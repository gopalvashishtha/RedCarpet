package com.example.redcarpet.ViewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redcarpet.Repo
import com.example.redcarpet.model.Article1
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import timber.log.Timber

class viewmodel @ViewModelInject constructor(repo: Repo) : ViewModel() {
    private val _topHeadlines = MutableLiveData<List<Article1>>()
    val topHeadlines: LiveData<List<Article1>>
        get() = _topHeadlines
    init {
        repo.getTopHeadlines()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({news -> _topHeadlines.value = news.article},{t -> Timber.e(t)})
    }
}
