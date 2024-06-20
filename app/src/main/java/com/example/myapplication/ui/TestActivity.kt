package com.example.myapplication.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.adapter.ViewpagerAdapter
import com.example.myapplication.databinding.ActivityTestBinding
import com.example.myapplication.fragment.FirstFragment
import com.example.myapplication.fragment.SecondFragment
import com.example.myapplication.fragment.ThirdFragment

class TestActivity : AppCompatActivity() {
    private val mBinding: ActivityTestBinding by lazy{
        ActivityTestBinding.inflate(layoutInflater)
    }
    private val vpadapter:ViewpagerAdapter by lazy { ViewpagerAdapter(this) }
    private val fragmentList: MutableList<Fragment> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addFragment()
        initViewpager()

    }

    private fun addFragment() {

            fragmentList.apply {
                add(FirstFragment())
                add(SecondFragment())
                add(ThirdFragment())
            }
    }


    private fun initViewpager() {
        mBinding.vpTest.apply {
            adapter=vpadapter
            registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }
    }
}