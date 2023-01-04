package com.example.todo
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_data_thning.*

class DataThning : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_thning)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        MySharedPrefarance.init(this)
        val name = intent.getStringExtra("name")
        println(name)
        val planArray = MySharedPrefarance.catchList
        var plan1 = TodoPlan()
        var index = -1
        for (plan in planArray) {
            if (plan.name == name){
                plan1 = plan
                index = planArray.indexOf(plan)
                supportActionBar!!.title = plan.description
                description.text ="Description: "+ plan.name
                txt_create_data.text = plan.createData
                txt_dedline_data.text = plan.dedline
                txt_degree.text = plan.degree?.name
                img_plan.setImageResource(plan.degree!!.img)
                when(plan.level){
                    "Open" -> rad_open.isChecked = true
                    "Development" -> rad_dev.isChecked = true
                    "Uploading" -> rad_uploading.isChecked = true
                    "Reject" -> rad_reject.isChecked = true
                    "Close" -> rad_closed.isChecked = true
                }
                break
            }
        }
        btn_ok.setOnClickListener {
            var rad = ""
            if (rad_open.isChecked) rad = "Open"
            if (rad_closed.isChecked) rad = "Close"
            if (rad_dev.isChecked) rad = "Development"
            if (rad_reject.isChecked) rad = "Reject"
            if (rad_uploading.isChecked) rad = "Uploading"

            plan1.level = rad
            planArray[index] = plan1
            MySharedPrefarance.catchList = planArray
            Toast.makeText(this, "Changed", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}