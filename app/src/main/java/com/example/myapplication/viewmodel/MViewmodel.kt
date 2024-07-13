package com.example.myapplication.viewmodel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.bean.Story
import com.example.myapplication.repository.GetAnswerData
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable


class MViewmodel : ViewModel() {
    private val mRvList = MutableLiveData<List<String>>()

    val _mRvList: LiveData<List<String>>
        get() = mRvList

    init {
        getRvList()
    }
    fun getRvList() {
        GetAnswerData.NetRepository.getSearchData().subscribe(object : Observer<List<String>>{
            override fun onSubscribe(d: Disposable) {
            }

            override fun onError(e: Throwable) {
                Log.d("Error", "${e.message}")

            }

            override fun onComplete(){
            }

            override fun onNext(t: List<String>) {
                mRvList.postValue(t)
                Log.d("MViewmodel","$t")
            }

        })
    }
}