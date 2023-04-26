package com.example.todo_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.ui.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.collection.LLRBNode
import java.util.*

class Day_adapter(val tempMonth:Int, val dayList: MutableList<Date>) : RecyclerView.Adapter<Day_adapter.DayView>() {
    val ROW =6
    class DayView(val layout: View): RecyclerView.ViewHolder(layout)
    var date: Date = Date()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayView {
       var view = LayoutInflater.from(parent.context).inflate(R.layout.day_item,parent,false)

        return DayView(view)
    }

    override fun onBindViewHolder(holder: DayView, position: Int) {
        var day_text: TextView = holder.layout.findViewById<TextView>(R.id.item_day_text)

        day_text.text = dayList[position].date.toString()
        if(tempMonth != dayList[position].month) {
            day_text.alpha=0.4f
        }
        //날짜 표시



    }


    override fun getItemCount(): Int {
        return ROW*7
    }
}