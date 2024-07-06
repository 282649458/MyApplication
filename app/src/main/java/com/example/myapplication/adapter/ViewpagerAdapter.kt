package com.example.myapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.fragment.FirstFragment
import com.example.myapplication.fragment.SecondFragment
import com.example.myapplication.fragment.ThirdFragment

class ViewpagerAdapter(fa:FragmentActivity,val l: List<Int>) : FragmentStateAdapter(fa) {



    override fun getItemCount(): Int =3

    override fun createFragment(position: Int):Fragment {
        return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            2 -> ThirdFragment()
            else -> error("Fragment error")
        }
    }

}