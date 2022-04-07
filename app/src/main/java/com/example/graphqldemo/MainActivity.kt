package com.example.graphqldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apollographql.apollo3.exception.ApolloException
import com.example.GetLocQuery

class MainActivity : AppCompatActivity() {
    var adapter: Adapter? = null
    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)

        lifecycleScope.launchWhenResumed {

            val response2 = apolloClient.query(GetLocQuery()).execute()

            Log.d("LaunchList", "Success ${response2.data}")



            val response = try {
                apolloClient.query(GetLocQuery()).execute()
            } catch (e: ApolloException) {
                Log.d("LaunchList", "Failure", e)
                null
            }


            val launches = response?.data?.locations?.results
            if (launches != null && !response.hasErrors()) {
                Log.d("LaunchList @::::", "Success ${response.data?.locations?.results}")
                 adapter = Adapter(this@MainActivity, launches as ArrayList<GetLocQuery.Result>)
//
                recyclerView?.adapter = adapter
            }


        }

    }
}