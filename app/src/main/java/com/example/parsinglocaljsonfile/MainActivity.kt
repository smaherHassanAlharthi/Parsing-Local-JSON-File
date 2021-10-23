package com.example.parsinglocaljsonfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parsinglocaljsonfile.databinding.ActivityMainBinding
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rvAdapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadImages()
    }

    fun loadImages(){

        val bufferReader = application.assets.open("data.json").bufferedReader()
        val imagesFromFile = bufferReader.use {
            it.readText()
        }

            val images = JSONArray(imagesFromFile)
            val list=ArrayList<Image>()
            for(i in 0 until images.length())
            {
                var image=Image()
                image.title= images.getJSONObject(i).getString("title")
                image.url=images.getJSONObject(i).getString("url")
                list.add(image)
            }

            setRV(list)

    }

    fun setRV(images: ArrayList<Image>) {
        val myRv = binding.rvPhotos

            rvAdapter =RVAdapter(images, this)
            myRv.adapter = rvAdapter
            myRv.layoutManager = LinearLayoutManager(applicationContext)
    }


}