package com.thedomain.benboyceassessment

import CountryAdapter
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //default code on Empty Views Activity
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //call for the online data
        CountryViewModel.getCountries().enqueue(object: Callback<List<Country>> {
            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                //display the data
                Log.d("BenTag", "${response.body()}")
                val countryAdapter = response.body()?.let {
                    CountryAdapter(it, this@MainActivity)
                }
                val countryRecycler: RecyclerView = findViewById(R.id.country_rv)
                countryRecycler.layoutManager = LinearLayoutManager(this@MainActivity)
                countryRecycler.adapter = countryAdapter

            }

            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                //display an error
                Log.e("BenTag", t.message.toString())
            }

        })
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    BenBoyceAssessmentTheme {
//        Greeting("Android")
//    }
//}