package com.example.todo_project

import android.content.Intent
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
    private var selectedItemPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayView {
       var view = LayoutInflater.from(parent.context).inflate(R.layout.day_item,parent,false)

        return DayView(view)
    }

    override fun onBindViewHolder(holder: DayView, position: Int) {

        //초기화
        var day_text: TextView = holder.layout.findViewById<TextView>(R.id.item_day_text)


        //날짜 표시
        day_text.text = dayList[position].date.toString()
        if(tempMonth != dayList[position].month) {
            day_text.alpha=0.4f
        }

        //토요일이면 파란색 || 일요일이면 빨간색으로 색상표시
        if((position + 1) % 7 == 0) {
            day_text.setTextColor(ContextCompat.getColor(holder.layout.context,R.color.blue))
        } else if (position == 0 || position % 7 == 0) {
            day_text.setTextColor(ContextCompat.getColor(holder.layout.context,R.color.red))
        }

        //단일선택 기능
        holder.layout.setOnClickListener {
            View.OnClickListener { v: View? ->

                val currentPosition = holder.adapterPosition

                if (selectedItemPosition == currentPosition) {
                    day_text.setBackgroundColor(ContextCompat.getColor(holder.layout.context,R.color.white))
                } else {

                    if(selectedItemPosition >= 0 || selectedItemPosition != null){
                        day_text.setBackgroundColor(ContextCompat.getColor(holder.layout.context,R.color.white))
                    }

                    selectedItemPosition = currentPosition
                    day_text.setBackgroundResource(R.drawable.item_click_custom)
                }
            }

        }
        //텍스트 클릭시 아이템 추가 레이아웃 이동
        day_text.setOnClickListener(View.OnClickListener { v: View? ->

            var check_boolean: Boolean = false
            var click_count: Int = 0
            var sum: Int = 0


            //뷰 클릭시 카운터 증가
            click_count += 1

            sum += click_count

            day_text.setBackgroundResource(R.drawable.item_click_custom)
            check_boolean = true

            if (click_count == 1 || check_boolean == true) {
                val intent = Intent(holder.layout.context, Schedule_add::class.java)
                ContextCompat.startActivity(holder.layout.context, intent, null)
            }
        })
    }


    override fun getItemCount(): Int {
        return ROW*7
    }
}