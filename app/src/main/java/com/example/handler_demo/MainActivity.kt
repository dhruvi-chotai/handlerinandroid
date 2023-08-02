package com.example.handler_demo

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var handler: Handler
    private lateinit var tv: TextView
    private lateinit var updateButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateButton = findViewById(R.id.updateButton)

        handler = Handler(Looper.getMainLooper())
        tv = findViewById(R.id.tv1)

        updateButton.setOnClickListener {
            // Perform background task on a separate thread
            Thread {
                // Simulate a background task

                Log.d("abc", "executing thread")
                Thread.sleep(3000)

                // Update the UI using the Handler
                handler.post {
                    updateUI()
                }
            }.start()
        }
    }

    private fun updateUI() {
        // Update the UI elements here
        tv.text = "hello"
        Toast.makeText(this, "UI updated using handler", Toast.LENGTH_SHORT).show()
    }
}

