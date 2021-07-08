package com.cristiano.app14_whatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    lateinit var menu: TabLayout
    lateinit var viewer: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menu = findViewById(R.id.tblMenu)
        viewer = findViewById(R.id.vpgVisualizador)

        viewer.adapter = PagerAdapter(supportFragmentManager)
        menu.setupWithViewPager(viewer)
    }
}