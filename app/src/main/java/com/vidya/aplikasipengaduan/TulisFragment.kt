package com.vidya.aplikasipengaduan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_tulis.*

class TulisFragment : Fragment() {
    lateinit var listTiket:ArrayList<MyTulis>

    var TAG = "TulisFragment"

    private fun simulasiDataTiket(){
        listTiket = ArrayList()
        listTiket.add(
            MyTulis("ID :Vidya Meidita", "JENIS : Pelanggaran", "KATEGORI : Ketertiban Umum",
            "ISI LAPORAN : Terjadi pelanggaran lampu lalulintas di daerah logowaru", "STATUS : Belum DiPeriksa", "KETERANGAN : Laporan diTerima")
        )
        listTiket.add(
            MyTulis("ID : Surya hanggara", "JENIS : Saran", "KATEGORI : Pelayanan Umum", "ISI LAPORAN : Saran saya administator di kantor keluran daerah cemorokandang, diganti",
            "STATUS : Sedang Proses", "KETERANGAN : Pengaduan akan diProses")
        )
        listTiket.add(MyTulis("ID : Surya hanggara", "JENIS : Saran", "KATEGORI : Pelayanan Umum", "ISI LAPORAN : Saran saya administator di kantor keluran daerah cemorokandang, diganti",
            "STATUS : Sedang Proses", "KETERANGAN : Pengaduan akan diProses")
        )
        listTiket.add(MyTulis("ID : Surya hanggara", "JENIS : Saran", "KATEGORI : Pelayanan Umum", "ISI LAPORAN : Saran saya administator di kantor keluran daerah cemorokandang, diganti",
            "STATUS : Sedang Proses", "KETERANGAN : Pengaduan akan diProses")
        )


    }

    private fun tampilTiket(){
        rv_listTiket.layoutManager=LinearLayoutManager(activity)
        rv_listTiket.adapter=MyTulisAdapter(activity!!, listTiket)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tulis, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        simulasiDataTiket()
        tampilTiket()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}