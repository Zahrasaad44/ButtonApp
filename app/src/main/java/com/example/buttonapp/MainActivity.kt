package com.example.buttonapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var numberTV: TextView
    lateinit var minusBtn: Button
    lateinit var addBtn: Button
    lateinit var mainLayout: ConstraintLayout
    var num = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainLayout = findViewById(R.id.clMainId)
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {     // "menu" related function
        //return super.onCreateOptionsMenu(menu)   // this method came with the "onCreateOptionsMenu" function
        menuInflater.inflate(R.menu.button_app_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {   // "menu" related function
        when(item.itemId) {
            R.id.item1 -> {

               // NOTE: You will have to initialize your main Constraint Layout in order to use it as a view for the Snackbar.

                Snackbar.make(mainLayout,"You tapped 'Math is fun' option", Snackbar.LENGTH_SHORT).show()
                return true
            }
            R.id.item2 -> {
                Snackbar.make(mainLayout, "You tapped 'I like Math' option", Snackbar.LENGTH_LONG).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}