package com.example.buttonapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var numberTV: TextView
    lateinit var minusBtn: Button
    lateinit var addBtn: Button
    var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        minusBtn = findViewById(R.id.minusBtn)
        addBtn = findViewById(R.id.addBtn)
        numberTV = findViewById(R.id.numTV)
        addBtn.setOnClickListener { changeNum(true); changeColor() }
        minusBtn.setOnClickListener { changeNum(false); changeColor() }

        //addBtn.setOnClickListener { modifyText() }
    }
/*
    fun modifyText() {
        numberTV = findViewById(R.id.numTV)
        numberTV.text = "Working on connecting and modifying text with Kotlin"
        numberTV.setTextColor(setColor())
    }
    fun setColor(): Int {
        val colors = arrayOf(Color.BLACK, Color.RED, Color.BLUE, Color.GREEN, Color.GRAY)
        return colors.random()
    }
*/
    fun changeColor() {
       return when {
           num > 0 -> {
               numberTV.setTextColor(Color.GREEN)
           }
           num == 0 -> {
               numberTV.setTextColor(Color.BLACK)
           }
           else -> {
               numberTV.setTextColor(Color.RED)
           }
       }
    }

    fun changeNum(add: Boolean) {
        if (add) {
            num++
        } else {
            num--
        }
      numberTV.text = num.toString()
    }

}