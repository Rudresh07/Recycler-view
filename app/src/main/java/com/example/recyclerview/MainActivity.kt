package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding

class  MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private lateinit var myRecyclerView : RecyclerView
    private lateinit var newsArrayList : ArrayList<news>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)

        supportActionBar?.hide()

        myRecyclerView = binding?.recyclerview!!

        val newsImageArray = arrayOf(
            R.drawable.america,
            R.drawable.landslide,
            R.drawable.sports,
            R.drawable.exhibition,
            R.drawable.itpo,
            R.drawable.independenceday,
            R.drawable.burjkhalifa

        )

        val newsHeadingArray = arrayOf(
            "Cycles of a ‘Forever War’",
            "Himachal Pradesh: 330 roads closed due to landslides, flashfloods",
            "Indian Cricket Team Captain Hardik Pandya Work In Progress, Batter Pandya 'Needs Runs': Ex-Star Raises Concerns",
            "Akhil Bhartiya Shiksha Samagam: PM Modi visits exhibition ahead of inauguration",
            "PM Modi to inaugurate redeveloped ITPO complex at Delhi's Pragati Maidan on Wednesday",
            "Happy Independence Day 2023 Wishes: Spread the Spirit of Patriotism with 77 Quotes, Images, Gif, Messages, Slogans, and Greetings",
            "Burj Khalifa Tiranga Display on Independence Day 2023 Time: World's Tallest Building To Be Illuminated in Colours of Indian Flag at 7:50 PM and 8:50 PM on 15th August"
        )

        val newsContent = arrayOf(getString(R.string.NewsDetailsAmerica),
            getString(R.string.newsDetailsLandslide),
            getString(R.string.newsDetailsSports),
            getString(R.string.newsDetailsExhibition),
            getString( R.string.newsDetailsItpo),
            getString(R.string.newsDetailsIndependenceDay),
            getString(R.string.newsDetailsBurj))


        // now we need to set the scrolling features of the recycler view
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        //initialising the the lateinit variables or describing the variables
        newsArrayList = arrayListOf<news>()

        //inserting the data into the recycler view

        for (index in newsImageArray.indices)
        {
            val News = news(newsHeadingArray[index],newsImageArray[index],newsContent[index])
            newsArrayList.add(News)
        }

        val MyAdapter = myAdapter(newsArrayList,this)
        myRecyclerView.adapter = MyAdapter
        MyAdapter.setOnItemClickListener(object :myAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                // on clicking each item action performed accordingly
                //yaha par this kehne se context nhi mil pa raha tha toh activity ka context pass karna hoga
                val intent = Intent(applicationContext,News_Details::class.java)
                intent.putExtra("heading",newsArrayList[position].newsHeading)
                intent.putExtra("image",newsArrayList[position].newsImage)
                intent.putExtra("content",newsArrayList[position].newsContent)
                startActivity(intent)
            }
        })


        // the error is while upgrading the sdk file for that go  to settings and than download 3 options last option of 33 version

    }
}