package com.vidya.aplikasipengaduan


import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    val menuTeks = arrayOf("TIKET", "TIKET ANDA", "PROFILE")
    val menuIcon = arrayOf(R.drawable.ic_report_svgrepo_com, R.drawable.ic_writer_warehouse_svgrepo_com, R.drawable.ic_2062002861579680337)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ViewPagerAdapter (this)
        view_pager.setAdapter(adapter)
        TabLayoutMediator(tab_layout, view_pager,
            TabLayoutMediator.TabConfigurationStrategy {tab, position ->
            tab.text = menuTeks [position]
            tab.icon= ResourcesCompat.getDrawable(resources, menuIcon[position], null)
        }).attach()



//        val search = findViewById<SearchView>(R.id.searchview)
//        val listView = findViewById<ListView>(R.id.listView)

//        val names = arrayOf("Kejaksaan", "Pengaduan Hukum", "Ketertiban", "Administrasi Publik", "Perizinan", "Infrastruktur", "Fasilitas Umum", "Pelayanan Umum")
//        val adapter: ArrayAdapter<String> = ArrayAdapter(
//            this, android.R.layout.simple_list_item_1
//            , names
//        )

//        listView.adapter = adapter
//        search.setOnQueryTextListener(object :SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(p0: String?): Boolean {
//                search.clearFocus()
//                if (names.contains(p0))
//                {
//                    adapter.filter.filter(p0)
//                }else {
//                    Toast.makeText(applicationContext, "Item not found", Toast.LENGTH_SHORT).show()
//                }
//                return false
//            }
//
//            override fun onQueryTextChange(p0: String?): Boolean {
//                adapter.filter.filter(p0)
//                return false
//            }
//
//        })


    }
}
