package Adapter

import Fragment.FragmentPeralatan
import Fragment.FragmentTips
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FragmentPeralatan()
            1 -> fragment = FragmentTips()
        }
        return fragment!!
    }
}