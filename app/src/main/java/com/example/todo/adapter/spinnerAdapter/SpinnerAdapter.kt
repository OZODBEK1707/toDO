package dev.abdujabbor.app.adapter.spinnerAdapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.todo.R
import com.example.todo.collections.User

import kotlinx.android.synthetic.main.item_view_spinner.view.*

class SpinerAdapter1(var list: List<User>):BaseAdapter(){
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("SuspiciousIndentation")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView:View
        if (convertView == null){
            itemView = LayoutInflater.from(parent?.context).inflate(R.layout.item_view_spinner,parent, false)
        }else{
            itemView = convertView
        }


        itemView.txt_spiner_item.text = list[position].name
        if (list[position].img != -1)
            itemView.image.setImageResource(list[position].img)

        return itemView
    }


}