package com.vidya.aplikasipengaduan

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

//class MainActivity : AppCompatActivity() {

class LaporanFragment : Fragment() {
//    val types = arrayOf("simple User", "Admin");
    val REQUEST_CODE = 200
    val REQUEST_IMAGE_CAPTURE = 1
    lateinit var iv_add_img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        hasil = view.findViewById(R.id.result_spinner) as TextView

//        val jenis_pengaduan = resources.getStringArray(R.array.jenis_pengaduan)
//        spiner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener

//        setContentView(R.layout.fragment_laporan)
//
//        val spiner : Spinner = view.findViewById(R.id.spinner)
//         val jenis = listOf<String>("Klik Untuk Pilih", "Kritik", "Saran", "Pelanggaran", "Perizinan", "Pertanyaan",
//             "Pengaduan")
//        val arraYAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, jenis)
//        arraYAdapter.setDropDownViewResources(android.R.layout.simple_spinner_dropdown_item)
//        spiner.adapter = arraYAdapter

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_laporan, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spiner:Spinner = view.findViewById(R.id.spinner_option);
        ArrayAdapter.createFromResource(
            view.context,
            R.array.jenis_pengaduan,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spiner.adapter = adapter
        }

//        spiner = view.findViewById(R.id.spinner_option) as Spinner

                // use arrayadapter and define an array
        val arrayAdapter: ArrayAdapter<*>
        val users = arrayOf(
            "Kerusakan Fasilitas", "Perudungan", "Penyediaan Fasilitas",
            "Ketertiban Umum", "Pengaduan Hukum", "Perizinan", "Infrastuktur", "Pelayanan Umum", "Administrasi Publik",
            "Kejaksaan"
        )

        // access the listView from xml file
        var mListView = view.findViewById<ListView>(R.id.listView)
        arrayAdapter = ArrayAdapter(view.context,
            android.R.layout.simple_list_item_1, users)
        mListView.adapter = arrayAdapter

        var etSearch: EditText;
        etSearch = view.findViewById(R.id.searchView)

//        var searchView = view.findViewById(R.id.searchView)
//        view.findViewById(R.id.searchView)
//        searchView.listener
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                arrayAdapter.filter.filter(s)
            }
            override fun afterTextChanged(s: Editable) {}
        })

//        ImageView
        iv_add_img = view.findViewById(R.id.iv_add_img);
        iv_add_img.setOnClickListener { view ->
            Log.e("iv_add_img", "iv_add_img")
//            capturePhoto()
            dispatchTakePictureIntent()
        }


//        text_dial_number
        val callIntent: Intent = Uri.parse("tel:083848711039").let { number ->
            Intent(Intent.ACTION_DIAL, number)
        }
        var text_dial_number:TextView = view.findViewById(R.id.text_dial_number)
        text_dial_number.setOnClickListener { view ->
            callIntent
            startActivity(callIntent)
        }
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } catch (e: ActivityNotFoundException) {
            // display error state to the user
            Log.e("TAG", "error: "+e)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data!!.extras!!.get("data") as Bitmap
            iv_add_img.setImageBitmap(imageBitmap)
        }
    }
}