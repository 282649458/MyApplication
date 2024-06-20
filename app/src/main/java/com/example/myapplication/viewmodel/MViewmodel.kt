package com.example.myapplication.viewmodel

import android.app.admin.DevicePolicyManager.OnClearApplicationUserDataListener
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.bean.Story

class MViewmodel : ViewModel() {
  private val mutableList = mutableListOf<Story>()


  private val _rvList: MutableLiveData<List<Story>> = MutableLiveData<List<Story>>()
  val rvList: LiveData<List<Story>>
   get() = _rvList
 private var num = 21

 init {
  initList()
 }


 private fun initList() {
  for (i in 1..20) {
   mutableList.add((Story((i))))
  }
  _rvList.postValue(mutableList)
 }




 fun addNum() {
  for (i in 1..5) {
   mutableList.add(Story(num))
   num++
  }
  Log.d("LogTest", "测试数据${mutableList}")

  _rvList.postValue(mutableList)
  Log.d("wefweafweafwefweaf", "测试数据${System.identityHashCode(mutableList)}")


 }
}