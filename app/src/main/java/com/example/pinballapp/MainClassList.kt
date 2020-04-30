package com.example.pinballapp

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main_class_list.*
import java.util.*

class MainClassList : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_class_list)

        val spnCompany = findViewById<Spinner>(R.id.spnCompany)
        val txtMachineName = findViewById<EditText>(R.id.txtMachine)
        val datePickerbtn = findViewById<TextView>(R.id.spnDatePlayed)
        var selectedDate = ""
        spnCompany.requestFocus()

        datePickerbtn.setOnClickListener {
            val cal = Calendar.getInstance()
            val year  = cal.get(Calendar.YEAR)
            val month = cal.get(Calendar.MONTH)
            val day = cal.get(Calendar.DAY_OF_MONTH)

            val dateOfPlay = DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, myear, mMonth, mday ->
                datePickerbtn.text = "$myear / ${mMonth+1} / $mday"
                selectedDate = "$myear / ${mMonth+1} / $mday"
            },year,month,day)

            dateOfPlay.show()


        }

        val txtScore = findViewById<EditText>(R.id.txtScore)
        val btnRateMachines = findViewById<Button>(R.id.btnRateMachines)


        btnRateMachines.setOnClickListener {
            if (checkData()) {

                val nextScreen = Intent(this@MainClassList, ChooseClass::class.java)
                nextScreen.putExtra("Company", spnCompany.selectedItem.toString())
                nextScreen.putExtra("MachineName", txtMachineName.text.toString())
                nextScreen.putExtra("DateOfPlay",selectedDate)
                nextScreen.putExtra("Score", txtScore.text.toString())


                //Start Activity
                startActivity(nextScreen)
            }
        }






    }
    private fun checkData():Boolean{
        val txtMachineName = findViewById<EditText>(R.id.txtMachine)
        val txtScore = findViewById<EditText>(R.id.txtScore)

        if(txtMachineName.text.toString().isEmpty()){
            txtMachineName.error = "Invalid Machine Name"
            txtMachineName.requestFocus()
            return false
        }

        if(txtScore.text.toString().isEmpty()){
            txtScore.error = "Invalid Score"
            txtScore.requestFocus()
            return false
        }

        return true
    }
}
