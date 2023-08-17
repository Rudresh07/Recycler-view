package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview.databinding.ActivityNewsDetailsBinding

class News_Details : AppCompatActivity() {

    var binding:ActivityNewsDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewsDetailsBinding.inflate(layoutInflater)
        val view = binding?.root

        setContentView(view)


        var Image = intent.getIntExtra("image",R.drawable.error)
        var Heading = intent.getStringExtra("heading")
        var Content = intent.getStringExtra("content")


        binding?.ImageNews?.setImageResource(Image)
        binding?.Heading?.text = Heading
        binding?.newsDetails?.text = Content

    }
}