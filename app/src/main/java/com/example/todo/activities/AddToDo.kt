package com.example.todo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.widget.Toast
import com.example.todo.collections.User
import dev.abdujabbor.app.adapter.spinnerAdapter.SpinerAdapter1
import kotlinx.android.synthetic.main.activity_add_to_do.*



class AddToDo : AppCompatActivity() {
    lateinit var userArray:ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_to_do)
        loadData()

        MySharedPrefarance.init(this)

        val spinnerAdapter = SpinerAdapter1(userArray)
        spiner_add_to_do.adapter = spinnerAdapter

        btn_save_add_to_do.setOnClickListener {
            val toDoName = edt_to_do_name.text.toString().trim()
            val toDoDescription = edt_to_do_description.text.toString().trim()
            val toDoCreateData = edt_to_do_create_data.text.toString().trim()
            val toDoDedline = edt_dedline.text.toString().trim()

            val degree = userArray[spiner_add_to_do.selectedItemPosition]

            if (toDoName!="" && toDoCreateData!="" && toDoDedline!="" && toDoDescription!=""&&degree != userArray[0]){
                val myList = MySharedPrefarance.catchList
                myList.add(TodoPlan(toDoName, toDoDescription, degree, toDoCreateData, toDoDedline, "Open"))
                println(myList)
                MySharedPrefarance.catchList = myList
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                finish()
            }else{
                val vibratorService = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                vibratorService.vibrate(200)
                Toast.makeText(this, "Complete your data", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun loadData() {
        userArray = ArrayList()
        userArray.add(User(-1, "To do degree"))
        userArray.add(User(R.drawable.ic_qizil_bayrog, "Urgent"))
        userArray.add(User(R.drawable.ic_kok_bayrog, "High"))
        userArray.add(User(R.drawable.ic_sarig_bayrog, "Normal"))
        userArray.add(User(R.drawable.ic_low_bayrog, "Low"))
    }
}