package com.akshay_apps.tic_tac_toe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun start(view: View) {
        val firstPlayer = findViewById<EditText>(R.id.player1)
        val name1 = firstPlayer.text.toString()

        val secondPlayer = findViewById<EditText>(R.id.player2)
        val name2 = secondPlayer.text.toString()
        val intent = Intent(this, GameActivity::class.java).apply {
            putExtra("player1", name1)
            putExtra("player2", name2)
        }
        startActivity(intent)

    }
}

