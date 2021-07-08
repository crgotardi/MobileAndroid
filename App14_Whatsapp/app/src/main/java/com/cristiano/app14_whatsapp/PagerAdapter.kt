package com.cristiano.app14_whatsapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(gerenciador: FragmentManager):
    FragmentPagerAdapter(gerenciador) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return if (position == 0)
            FragmentChat()
        else if (position == 1)
            FragmentStatus()
        else
            FragmentCalls()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (position == 0)
            "Conversas"
        else if (position == 1)
            "Status"
        else
            "Chamadas"
    }
}