package com.example.pinballapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckedTextView
import android.widget.RatingBar
import androidx.core.view.isVisible

class ChooseClass : AppCompatActivity() {

    private var company:String? = ""
    private var machineName:String? =""
    private var dateOfPlay:String?=""
    private var score:String?=""
    private var ctv1:CheckedTextView?=null
    private var ctv2:CheckedTextView?=null
    private var ctv3:CheckedTextView?=null
    private var ctv4:CheckedTextView?=null
    private var rb1:RatingBar?=null
    private var rb2:RatingBar?=null
    private var rb3:RatingBar?=null
    private var rb4:RatingBar?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_class)

        ctv1 = findViewById(R.id.ctv1)
        ctv2 = findViewById(R.id.ctv2)
        ctv3 = findViewById(R.id.ctv3)
        ctv4 = findViewById(R.id.ctv4)
        rb1 = findViewById(R.id.rb1)
        rb2 = findViewById(R.id.rb2)
        rb3 = findViewById(R.id.rb3)
        rb4 = findViewById(R.id.rb4)

        val btnSummary = findViewById<Button>(R.id.btnSummary)

        val extras = intent.extras
        if(extras != null){
            company = extras.getString("Company")
            machineName = extras.getString("MachineName")
            dateOfPlay = extras.getString("DateOfPlay")
            score = extras.getString("Score")
        }

        btnSummary.setOnClickListener{

            var ctv1Text=""
            var ctv2Text=""
            var ctv3Text=""
            var ctv4Text=""
            var rb1Value= 0.0
            var rb2Value= 0.0
            var rb3Value= 0.0
            var rb4Value= 0.0


            if(ctv1!!.isChecked){
                ctv1Text = ctv1!!.text.toString()
                rb1Value = rb1!!.rating.toDouble()
            }
            if(ctv2!!.isChecked){
                ctv2Text = ctv2!!.text.toString()
                rb2Value = rb2!!.rating.toDouble()
            }
            if(ctv3!!.isChecked){
                ctv3Text = ctv3!!.text.toString()
                rb3Value = rb3!!.rating.toDouble()
            }
            if(ctv4!!.isChecked){
                ctv4Text = ctv4!!.text.toString()
                rb4Value = rb4!!.rating.toDouble()
            }


            val summaryScreen = Intent(this@ChooseClass,Summary::class.java).apply{
                putExtra("Company",company)
                putExtra("MachineName",machineName)
                putExtra("DateOfPlay",dateOfPlay)
                putExtra("Score",score)
                putExtra("Machine1",ctv1Text)
                putExtra("Rating1",rb1Value.toString())
                putExtra("Machine2",ctv2Text)
                putExtra("Rating2",rb2Value.toString())
                putExtra("Machine3",ctv3Text)
                putExtra("Rating3",rb3Value.toString())
                putExtra("Machine4",ctv4Text)
                putExtra("Rating4",rb4Value.toString())

            }
            startActivity(summaryScreen)

        }

        ctv1!!.setOnClickListener{
            if(ctv1!!.isChecked)
                enableDisable(ctv1,rb1, Color.WHITE,false)
            else
                enableDisable(ctv1,rb1,Color.GRAY,true)
        }
        ctv2!!.setOnClickListener{
            if(ctv2!!.isChecked)
                enableDisable(ctv2,rb2, Color.WHITE,false)
            else
                enableDisable(ctv2,rb2,Color.GRAY,true)
        }
        ctv3!!.setOnClickListener{
            if(ctv3!!.isChecked)
                enableDisable(ctv3,rb3, Color.WHITE,false)
            else
                enableDisable(ctv3,rb3,Color.GRAY,true)
        }
        ctv4!!.setOnClickListener{
            if(ctv4!!.isChecked)
                enableDisable(ctv4,rb4, Color.WHITE,false)
            else
                enableDisable(ctv4,rb4,Color.GRAY,true)
        }

    }
    private fun enableDisable(ctv:CheckedTextView?, rb:RatingBar?,bgColor:Int?, state:Boolean){

        ctv!!.isChecked = state
        ctv.setBackgroundColor(bgColor!!)
        rb!!.isEnabled = state
        if(state)
        rb.visibility = View.VISIBLE
        else
            rb.visibility = View.INVISIBLE
        rb.isEnabled = state




    }
}
