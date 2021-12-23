package com.example.events

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.events.data.base.ApiInterface
import com.example.events.databinding.ActivityMainBinding
import com.example.events.domain.EventsItem
import com.example.events.ui.adapter.EventAdapter
import com.example.events.ui.utils.AutoScroll
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_events_details_list.*
import kotlinx.android.synthetic.main.item_events_details_list.view.*
import kotlinx.android.synthetic.main.item_events_list.*
import kotlinx.android.synthetic.main.splash_screen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

const val BASE_URL = "https://5f5a8f24d44d640016169133.mockapi.io/api/"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var myAdapter: EventAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    private var currentPosition: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getMyData()

        check_in_button.setOnClickListener {
            irParaSecondActivity()
        }

        binding.recyclerViewContainer.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerViewContainer.layoutManager = linearLayoutManager
    }

    private fun irParaSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    private fun scrollToNextItem() {
        if (currentPosition != (myAdapter?.itemCount?.minus(1))) {
            binding.recyclerViewContainer.smoothScrollToPosition(currentPosition + 1)
            currentPosition++
        } else {
            currentPosition = 0
            binding.recyclerViewContainer.smoothScrollToPosition(currentPosition)
        }
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<EventsItem>?> {

            override fun onResponse(
                call: Call<List<EventsItem>?>,
                response: Response<List<EventsItem>?>
            ) {
                val responseBody = response.body()!!

                myAdapter = EventAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                val linearLayout =
                    LinearLayoutManager(baseContext, LinearLayoutManager.HORIZONTAL, false)
                binding.recyclerViewContainer.layoutManager = linearLayout
                binding.recyclerViewContainer.adapter = myAdapter
                autoScrollRecyclerView()
            }

            override fun onFailure(call: Call<List<EventsItem>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: " + t.message)
            }

            fun autoScrollRecyclerView() {
                binding.recyclerViewContainer.post {
                    val timer = Timer()
                    timer.schedule(AutoScroll { scrollToNextItem() }, 5000, 3000)
                }
            }
        })
    }
}
