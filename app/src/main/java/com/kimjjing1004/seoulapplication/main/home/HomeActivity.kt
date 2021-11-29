package com.kimjjing1004.seoulapplication.main.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kimjjing1004.seoulapplication.R
import com.kimjjing1004.seoulapplication.databinding.ActivityHomeBinding


private lateinit var binding: ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    lateinit var imageAdapter: ImageAdapter
    private val imageList = mutableListOf<Image>()
    var english=""
    var korea=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        if (intent.hasExtra("EnglishKey")) {
            english = intent.getStringExtra("EnglishKey").toString()
            korea = ""

        } else if (intent.hasExtra("KoreaKey")) {
            korea = intent.getStringExtra("KoreaKey").toString()
            english = ""

        } else {
            Toast.makeText(this, "there isn't transferred name", Toast.LENGTH_SHORT).show()
        }

        imageAdapter = ImageAdapter(this)
        binding.imagesRecycler.adapter = imageAdapter

        imageList.apply {
            add(Image("63building",  R.drawable.building63, "서울특별시 영등포구 63로 50 한화금융센터_63"))
            add(Image("Coex", R.drawable.coex, "서울특별시 강남구 영동대로 513"))
            add(Image("Gyeongbokgung", R.drawable.gyeongbokgungpalace, "서울특별시 종로구 사직로 161 경복궁"))
            add(Image("Independence Door", R.drawable.independentdoor, "서울특별시 서대문구 현저동 941"))
            add(Image("Myeongdong Church", R.drawable.myeongdongcathedral, "서울특별시 중구 명동길 74"))
            add(Image("Namsan Tower", R.drawable.namsantower, "서울특별시 용산구 남산공원길 105"))
            add(Image("Seodaemoon", R.drawable.seodaemunprison, "서울특별시 서대문구 통일로 251 서대문형무소역사관"))
            add(Image("General Lee", R.drawable.statue1, "서울특별시 종로구 세종대로 172"))
            add(Image("Lotte Tower", R.drawable.tower, "서울특별시 송파구 올림픽로 300"))
            add(Image("Seoul Station", R.drawable.seoulstation, "서울특별시 중구 통일로 1 문화역서울 284"))
            add(Image("Tapgol", R.drawable.tapgolpark, "서울특별시 종로구 종로2가"))


            imageAdapter.images = imageList
            imageAdapter.notifyDataSetChanged()

        }

    }
}