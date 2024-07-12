package com.example.myapplication.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.adapter.ViewpagerAdapter
import com.example.myapplication.databinding.ActivityTestBinding
import com.example.myapplication.fragment.FirstFragment
import com.example.myapplication.fragment.SecondFragment
import com.example.myapplication.fragment.ThirdFragment
import com.google.android.material.tabs.TabLayoutMediator

class TestActivity : AppCompatActivity() {
    private val mBinding: ActivityTestBinding by lazy{
        ActivityTestBinding.inflate(layoutInflater)
    }
    val l= listOf<Int>(1,2,3)
    private val vpadapter:ViewpagerAdapter by lazy { ViewpagerAdapter(this,l) }
    private val fragmentList: MutableList<Fragment> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(mBinding.root)
        mBinding.vpTest.adapter=vpadapter
        mBinding.tabLayout
        mBinding.vpTest.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })
        TabLayoutMediator(mBinding.tabLayout, mBinding.vpTest) { tab, position ->
            when(position){
                0-> tab.text = "主页"
                1->tab.text="其他"
                2->tab.text="我"
            }
        }.attach()
    }
}