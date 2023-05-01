package com.example.todo_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.collection.LLRBNode
import java.util.*

class Day_adapter(val tempMonth:Int, val dayList: MutableList<Date>) : RecyclerView.Adapter<Day_adapter.DayView>() {
    val ROW =6
    class DayView(val layout: View): RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayView {
       var view = LayoutInflater.from(parent.context).inflate(R.layout.day_item,parent,false)

        return DayView(view)
    }

    override fun onBindViewHolder(holder: DayView, position: Int) {
        var day_text: TextView = holder.layout.findViewById<TextView>(R.id.item_day_text)
        var recycler = holder.layout.findViewById<RecyclerView>(R.id.recycler)

        //날짜 표시
        day_text.text = dayList[position].date.toString()
        if(tempMonth != dayList[position].month) {
            day_text.alpha=0.4f
        }

        if((position + 1) % 7 == 0) {
            day_text.setTextColor(ContextCompat.getColor(holder.layout.context,R.color.blue))
        } else if (position == 0 || position % 7 == 0) {
            day_text.setTextColor(ContextCompat.getColor(holder.layout.context,R.color.red))
        }
    }


    override fun getItemCount(): Int {
        return ROW*7
    }
}