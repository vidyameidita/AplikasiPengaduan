package com.vidya.aplikasipengaduan

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter (fragmentActivity: FragmentActivity) :
        FragmentStateAdapter(fragmentActivity) {
        private val JUMLAH_MENU = 3

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {return LaporanFragment()}
            1 -> {return TulisFragment()}
            2 -> (return StatusFragment())
            else -> {return LaporanFragment ()}
        }
    }

    override fun getItemCount(): Int {
        return JUMLAH_MENU
    }
}
