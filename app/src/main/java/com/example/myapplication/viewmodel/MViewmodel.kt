package com.example.myapplication.viewmodel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.bean.Story
import com.example.myapplication.repository.NetRepository
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable


class MViewmodel : ViewModel() {
    private val _mRvList = MutableLiveData<List<String>>()
    init {
        getRvList()
    }
    val mRvList: MutableLiveData<List<String>>
        get() = _mRvList


    fun getRvList() {
        NetRepository.getSearchData().subscribe(object : Observer<List<String>>{
            override fun onSubscribe(d: Disposable) {
            }

            override fun onError(e: Throwable) {
                Log.d("Error", "${e.message}")

            }

            override fun onComplete(){
            }

            override fun onNext(t: List<String>) {
                _mRvList.postValue(t)
                Log.d("MViewmodel","$t")
            }

        })
    }
}