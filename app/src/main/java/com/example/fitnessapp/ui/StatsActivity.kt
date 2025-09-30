

package com.example.fitnessapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessapp.R
import com.example.fitnessapp.data.database.RunDatabase
import com.example.fitnessapp.data.repositories.RunRepository

class StatsActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val db = RunDatabase.getDatabase(this)
        val repository = RunRepository(db.runDao())
        repository.getAllRuns().observe(this) { runs ->
            recyclerView.adapter = RunAdapter(runs)
        }
    }
}