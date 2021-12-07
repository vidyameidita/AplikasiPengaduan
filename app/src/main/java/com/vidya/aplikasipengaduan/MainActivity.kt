package com.vidya.aplikasipengaduan


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val menuTeks = arrayOf("Jenis Laporan", "Tulis", "Status")
    val menuIcon = arrayOf(R.drawable.ic_report_svgrepo_com, R.drawable.ic_writer_warehouse_svgrepo_com, R.drawable.ic_lifeline_hand_drawn_status_line_svgrepo_com)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ViewPagerAdapter (this)
        view_pager.setAdapter(adapter);
        TabLayoutMediator(tab_layout, view_pager, TabLayoutMediator.TabConfigurationStrategy{tab, position ->
            tab.text = menuTeks [position]
            tab.icon= ResourcesCompat.getDrawable(resources, menuIcon[position], null)
        }).attach()

    }
}
