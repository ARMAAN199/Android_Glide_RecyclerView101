package com.example.wallpaperapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallpaperapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val rvAdapter = RVAdapter()

    @Inject
    lateinit var apiInterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDependencies()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val rfBuilder = apiInterface

        val imageApiPromise = rfBuilder.getDataRandom()

        binding.recyclerView.apply {
            adapter = rvAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }

        imageApiPromise.enqueue(object : Callback<ImagesResponse?> {
            override fun onResponse(
                call: Call<ImagesResponse?>,
                response: Response<ImagesResponse?>
            ) {
                if (response.isSuccessful) {
                    val res = response.body()
                    if (res != null) {
                        rvAdapter.udpateImageList(res.hits)
                    } else {
                        Log.d("abcdd", "Response is null")
                    }
                } else {
                    Log.d("abcdd", response.toString())
                }
            }

            override fun onFailure(call: Call<ImagesResponse?>, t: Throwable) {
                Log.d("abcddd", t.toString())
            }

        })

    }

    private fun initDependencies() {
        DaggerMainComponent.builder().build().inject(this@MainActivity)
    }
}