package com.example.pinballapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_summary.*
import java.lang.StringBuilder

class Summary : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        val extras = intent.extras
        if(extras!=null){
            var company = extras.getString("Company")
            var machineName = extras.getString("MachineName")
            var dateOfPlay = extras.getString("DateOfPlay")
            var score = extras.getString("Score")
            var machine1 = extras.getString("Machine1")
            var rating1 = extras.getString("Rating1")
            var machine2 = extras.getString("Machine2")
            var rating2 = extras.getString("Rating2")
            var machine3 = extras.getString("Machine3")
            var rating3 = extras.getString("Rating3")
            var machine4 = extras.getString("Machine4")
            var rating4 = extras.getString("Rating4")

            val tvCompany = findViewById<TextView>(R.id.tvCompany)
            val tvMachine = findViewById<TextView>(R.id.tvMachineName)
            val tvDateOfPlay = findViewById<TextView>(R.id.tvDatePlay)
            val tvScore = findViewById<TextView>(R.id.tvScore)
            val txtRatedMachines = findViewById<TextView>(R.id.txtRatedMachines)

            tvCompany.text = company
            tvMachine.text = machineName
            tvDateOfPlay.text = dateOfPlay
            tvScore.text= score

            val ratedMachines = StringBuilder(250)
            if(machine1!=""){
                ratedMachines.append(machine1+"\t"+rating1+" Stars\n")
            }
            if(machine2!=""){
                ratedMachines.append(machine2+"\t"+rating2+" Stars\n")
            }
            if(machine3!=""){
                ratedMachines.append(machine3+"\t"+rating3+" Stars\n")
            }
            if(machine4!=""){
                ratedMachines.append(machine4+"\t"+rating4+" Stars\n")
            }
            txtRatedMachines.text = ratedMachines
            txtRatedMachines.isEnabled = false
        }




    }
}
