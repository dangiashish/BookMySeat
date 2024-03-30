package com.codebyashish.bookmyseat

import android.content.res.ColorStateList
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {

    var numColumns = 20
    var numRows = 15
    lateinit var alphaGridLayout: GridLayout
    lateinit var numGridLayout: GridLayout
    lateinit var seatsGridLayout: GridLayout
    private val labelList = mutableListOf<String>()
    private val numList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridLayout = GridLayout(this)
        val gridLayout2 = GridLayout(this)
        val gridLayout3 = GridLayout(this)
        alphaGridLayout = findViewById(R.id.alphaGrid)
        numGridLayout = findViewById(R.id.numGrid)
        seatsGridLayout = findViewById(R.id.seatsGrid)

        initializeLabelList()
        initializeNumList()

        for (i in 0 until 1) {
            for (j in 0 until numColumns) {
                val seat: TextView = alphaRowText()
                val rowSpec = GridLayout.spec(i, 1f)
                val colSpec = GridLayout.spec(j, 1f)
                val params = GridLayout.LayoutParams(rowSpec, colSpec)
                params.width = 90
                params.height = 90
                params.setMargins(5, 5, 5, 5)
                seat.layoutParams = params

                seat.text = numList[j]
                gridLayout3.addView(seat)
            }
        }
        numGridLayout.addView(gridLayout3)

        for (i in 0 until numRows) {
            for (j in 0 until 1) {
                val seat: TextView = alphaRowText()
                val rowSpec = GridLayout.spec(i, 1f)
                val colSpec = GridLayout.spec(j, 1f)
                val params = GridLayout.LayoutParams(rowSpec, colSpec)
                params.width = 90
                params.height = 90
                params.setMargins(5, 5, 5, 5)
                seat.layoutParams = params

                seat.text = labelList[i]
                gridLayout2.addView(seat)
            }
        }
        alphaGridLayout.addView(gridLayout2)




        for (i in 0 until numRows) {
            for (j in 0 until numColumns) {
                val seat: TextView = createSeatView()
                val rowSpec = GridLayout.spec(i, 1f)
                val colSpec = GridLayout.spec(j, 1f)
                val params = GridLayout.LayoutParams(rowSpec, colSpec)
                params.width = 90
                params.height = 90
                params.setMargins(5, 5, 5, 5)
                seat.layoutParams = params

                seat.text = labelList[i] + numList[j]

                seat.setOnClickListener { v: View? ->
                    (v as TextView?)?.let {
                        handleSeatSelection(it)
                    }
                }
                gridLayout.addView(seat)

            }
        }
        seatsGridLayout.addView(gridLayout)
    }

    private fun alphaRowText(): TextView {
        val seat = TextView(this)
        seat.textSize = 12f
        seat.textAlignment = View.TEXT_ALIGNMENT_CENTER
        seat.gravity = Gravity.CENTER
        seat.setBackgroundColor(resources.getColor(android.R.color.transparent, null))
        seat.setTextColor(resources.getColor(R.color.lg2, null))
        seat.typeface = Typeface.DEFAULT_BOLD
        return seat
    }


    private fun handleSeatSelection(seat: TextView) {
        if (seat.isSelected) {
            seat.isSelected = false
            seat.background =
                ResourcesCompat.getDrawable(resources, R.drawable.tab_background, null)
            seat.backgroundTintList = ColorStateList.valueOf(
                resources.getColor(
                    R.color.lg
                )
            )
            seat.setTextColor(resources.getColor(R.color.black))
        } else {
            seat.isSelected = true
            seat.background =
                ResourcesCompat.getDrawable(resources, R.drawable.tab_background, null)
            seat.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.lg2))
            seat.setTextColor(resources.getColor(R.color.white))
        }
    }

    private fun createSeatView(): TextView {
        val seat = TextView(this)
        seat.textSize = 12f
        seat.textAlignment = View.TEXT_ALIGNMENT_CENTER
        seat.gravity = Gravity.CENTER
        seat.background = ResourcesCompat.getDrawable(resources, R.drawable.tab_background, null)
        seat.setTextColor(resources.getColor(R.color.black, null))
        seat.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.lg, null))
        return seat
    }

    private fun initializeLabelList() {
        for (i in 0 until numRows) {
            labelList.add(('A' + i).toString())
        }
        labelList.add(0, " ")
        labelList.reverse()
    }

    private fun initializeNumList() {
        for (i in 1..numColumns) {
            numList.add(i.toString())
        }
    }

}

