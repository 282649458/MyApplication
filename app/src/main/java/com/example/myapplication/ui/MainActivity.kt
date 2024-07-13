package com.example.myapplication.ui

import android.content.Intent
import com.example.myapplication.adapter.mAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.bean.Story
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewmodel.MViewmodel

class MainActivity : AppCompatActivity() {
    private val mBinding:ActivityMainBinding by lazy{
    ActivityMainBinding.inflate(layoutInflater)
    }
    private val mViewmodel: MViewmodel by lazy { ViewModelProvider(this)[MViewmodel::class.java] }
    private val madapter: mAdapter by lazy { mAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
        inRv()
       mBinding.turnTo.setOnClickListener(){
           val intent=Intent(this,TestActivity::class.java)
           startActivity(intent)
       }

    }

    private fun inRv() {
        mBinding.rvMain.apply {
        layoutManager=LinearLayoutManager(this@MainActivity)
        adapter= madapter
        }
        mViewmodel.mRvList.observe(this@MainActivity){
            val mList=(it as MutableList<String>).toMutableList()
            madapter.submitList(mList)
        }
    }
}