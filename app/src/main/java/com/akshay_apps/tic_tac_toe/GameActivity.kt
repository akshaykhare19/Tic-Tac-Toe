package com.akshay_apps.tic_tac_toe

import android.content.DialogInterface
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class GameActivity : AppCompatActivity() {

    lateinit var pos1: ImageView
    lateinit var pos2: ImageView
    lateinit var pos3: ImageView
    lateinit var pos4: ImageView
    lateinit var pos5: ImageView
    lateinit var pos6: ImageView
    lateinit var pos7: ImageView
    lateinit var pos8: ImageView
    lateinit var pos9: ImageView

    private var startGame: String = "leaf"
    lateinit var reset: Button
    var i = 0
    lateinit var turn: TextView
    lateinit var name1: String
    lateinit var name2: String
    private val apostrophe = "\'s turn"

    var b1: Int = 2
    var b2: Int = 2
    var b3: Int = 2
    var b4: Int = 2
    var b5: Int = 2
    var b6: Int = 2
    var b7: Int = 2
    var b8: Int = 2
    var b9: Int = 2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        pos1 = findViewById(R.id.pos1)
        pos2 = findViewById(R.id.pos2)
        pos3 = findViewById(R.id.pos3)
        pos4 = findViewById(R.id.pos4)
        pos5 = findViewById(R.id.pos5)
        pos6 = findViewById(R.id.pos6)
        pos7 = findViewById(R.id.pos7)
        pos8 = findViewById(R.id.pos8)
        pos9 = findViewById(R.id.pos9)
        reset = findViewById(R.id.reset)
        turn = findViewById(R.id.turnBoard)

        // Get the Intent that started this activity and extract the string
        name1 = intent.getStringExtra("player1").toString()
        name2 = intent.getStringExtra("player2").toString()
        showPlayerTurn()


        reset.setOnClickListener {
            pos1.setImageResource(0)
            pos2.setImageResource(0)
            pos3.setImageResource(0)
            pos4.setImageResource(0)
            pos5.setImageResource(0)
            pos6.setImageResource(0)
            pos7.setImageResource(0)
            pos8.setImageResource(0)
            pos9.setImageResource(0)
            resetValues()
            startGame = "leaf"
            boardTap()
            showPlayerTurn()

        }

        pos1.setOnClickListener {
            if(startGame.equals("leaf")) {
                pos1.setImageResource(R.drawable.leaf)
                b1 = 1
                i+=1
            }
            else{
                pos1.setImageResource(R.drawable.axe)
                b1 = 0
                i+=1
            }
            choosePlayer()
            winningGame()
            boardTap()
        }

        pos2.setOnClickListener {
            if(startGame.equals("leaf")) {
                pos2.setImageResource(R.drawable.leaf)
                b2 = 1
                i+=1
            }
            else{
                pos2.setImageResource(R.drawable.axe)
                b2 = 0
                i+=1
            }
            choosePlayer()
            winningGame()
            boardTap()
        }

        pos3.setOnClickListener {
            if(startGame.equals("leaf")) {
                pos3.setImageResource(R.drawable.leaf)
                b3 = 1
                i+=1
            }
            else{
                pos3.setImageResource(R.drawable.axe)
                b3 = 0
                i+=1
            }
            choosePlayer()
            winningGame()
            boardTap()
        }

        pos4.setOnClickListener {
            if(startGame.equals("leaf")) {
                pos4.setImageResource(R.drawable.leaf)
                b4 = 1
                i+=1
            }
            else{
                pos4.setImageResource(R.drawable.axe)
                b4 = 0
                i+=1
            }
            choosePlayer()
            winningGame()
            boardTap()
        }

        pos5.setOnClickListener {
            if(startGame.equals("leaf")) {
                pos5.setImageResource(R.drawable.leaf)
                b5 = 1
                i+=1
            }
            else{
                pos5.setImageResource(R.drawable.axe)
                b5 = 0
                i+=1
            }
            choosePlayer()
            winningGame()
            boardTap()
        }

        pos6.setOnClickListener {
            if(startGame.equals("leaf")) {
                pos6.setImageResource(R.drawable.leaf)
                b6 = 1
                i+=1
            }
            else{
                pos6.setImageResource(R.drawable.axe)
                b6 = 0
                i+=1
            }
            choosePlayer()
            winningGame()
            boardTap()
        }

        pos7.setOnClickListener {
            if(startGame.equals("leaf")) {
                pos7.setImageResource(R.drawable.leaf)
                b7 = 1
                i+=1
            }
            else{
                pos7.setImageResource(R.drawable.axe)
                b7 = 0
                i+=1
            }
            choosePlayer()
            winningGame()
            boardTap()
        }

        pos8.setOnClickListener {
            if(startGame.equals("leaf")) {
                pos8.setImageResource(R.drawable.leaf)
                b8 = 1
                i+=1
            }
            else{
                pos8.setImageResource(R.drawable.axe)
                b8 = 0
                i+=1
            }
            choosePlayer()
            winningGame()
            boardTap()
        }

        pos9.setOnClickListener {
            if(startGame.equals("leaf")) {
                pos9.setImageResource(R.drawable.leaf)
                b9 = 1
                i+=1
            }
            else{
                pos9.setImageResource(R.drawable.axe)
                b9 = 0
                i+=1
            }
            choosePlayer()
            winningGame()
            boardTap()
        }

    }

    private fun winningGame() {

        if( ((b1 == 1) && (b2 == 1) && (b3 == 1)) ||
            ((b4 == 1) && (b5 == 1) && (b6 == 1)) ||
            ((b7 == 1) && (b8 == 1) && (b9 == 1)) ||
            ((b1 == 1) && (b4 == 1) && (b7 == 1)) ||
            ((b2 == 1) && (b5 == 1) && (b8 == 1)) ||
            ((b3 == 1) && (b6 == 1) && (b9 == 1)) ||
            ((b1 == 1) && (b5 == 1) && (b9 == 1)) ||
            ((b3 == 1) && (b5 == 1) && (b7 == 1))) {

//            Toast.makeText(this, "$name1 wins!!!", Toast.LENGTH_SHORT).show()
            val builder = AlertDialog.Builder(this)
            builder.setMessage("$name1 wins!!!").setCancelable(false).setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                pos1.setImageResource(0)
                pos2.setImageResource(0)
                pos3.setImageResource(0)
                pos4.setImageResource(0)
                pos5.setImageResource(0)
                pos6.setImageResource(0)
                pos7.setImageResource(0)
                pos8.setImageResource(0)
                pos9.setImageResource(0)
                resetValues()
                startGame = "leaf"
                boardTap()
                showPlayerTurn()
            })

            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()

        }

        else if( ((b1 == 0) && (b2 == 0) && (b3 == 0)) ||
                 ((b4 == 0) && (b5 == 0) && (b6 == 0)) ||
                 ((b7 == 0) && (b8 == 0) && (b9 == 0)) ||
                 ((b1 == 0) && (b4 == 0) && (b7 == 0)) ||
                 ((b2 == 0) && (b5 == 0) && (b8 == 0)) ||
                 ((b3 == 0) && (b6 == 0) && (b9 == 0)) ||
                 ((b1 == 0) && (b5 == 0) && (b9 == 0)) ||
                 ((b3 == 0) && (b5 == 0) && (b7 == 0))) {

            val builder = AlertDialog.Builder(this)
            builder.setMessage("$name2 wins!!!").setCancelable(false).setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, perform ->
                pos1.setImageResource(0)
                pos2.setImageResource(0)
                pos3.setImageResource(0)
                pos4.setImageResource(0)
                pos5.setImageResource(0)
                pos6.setImageResource(0)
                pos7.setImageResource(0)
                pos8.setImageResource(0)
                pos9.setImageResource(0)
                resetValues()
                startGame = "leaf"
                boardTap()
                showPlayerTurn()
            })

            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }

        else {
            if (i != 9) return
            val builder = AlertDialog.Builder(this)
            builder.setMessage("No one wins!!!").setCancelable(false).setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, perform ->
                pos1.setImageResource(0)
                pos2.setImageResource(0)
                pos3.setImageResource(0)
                pos4.setImageResource(0)
                pos5.setImageResource(0)
                pos6.setImageResource(0)
                pos7.setImageResource(0)
                pos8.setImageResource(0)
                pos9.setImageResource(0)
                resetValues()
                startGame = "leaf"
                boardTap()
                showPlayerTurn()
            })

            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()

        }


    }

    private fun showPlayerTurn() {
        turn.text = "Let\'s Begin"
        Handler().postDelayed({
            turn.text = name1 + apostrophe
        }, 1000)
    }

    private fun boardTap() {
        pos1.isEnabled = !((b1 == 1) || (b1 == 0))
        pos2.isEnabled = !((b2 == 1) || (b2 == 0))
        pos3.isEnabled = !((b3 == 1) || (b3 == 0))
        pos4.isEnabled = !((b4 == 1) || (b4 == 0))
        pos5.isEnabled = !((b5 == 1) || (b5 == 0))
        pos6.isEnabled = !((b6 == 1) || (b6 == 0))
        pos7.isEnabled = !((b7 == 1) || (b7 == 0))
        pos8.isEnabled = !((b8 == 1) || (b8 == 0))
        pos9.isEnabled = !((b9 == 1) || (b9 == 0))

    }

    private fun resetValues() {
        b1 = 2
        b2 = 2
        b3 = 2
        b4 = 2
        b5 = 2
        b6 = 2
        b7 = 2
        b8 = 2
        b9 = 2
        i = 0
    }

    private fun choosePlayer() {
        if(startGame.equals("leaf")) {
            startGame = "axe"
            turn.text = name2 + apostrophe
        }

        else {
            startGame = "leaf"
            turn.text = name1 + apostrophe
        }
    }
}
