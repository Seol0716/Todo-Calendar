package com.example.todo_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.todo_project.databinding.MonthItemBinding
import java.util.*

class Month_adpater: RecyclerView.Adapter<Month_adpater.Month>() {
    var calendar: Calendar = Calendar.getInstance()


    override fun onBindViewHolder(holder: Month, position: Int) {


        //리사이클러뷰 초기화
        var list_layout: RecyclerView = holder.view.findViewById(R.id.month_recycler)


        //달 구하기
        calendar.time = Date()

        calendar.add(Calendar.MONTH , position)


        //title 텍스트 초기화
        var title_text: TextView =  holder.view.findViewById<TextView>(R.id.title)
        title_text.setText("${calendar.get(Calendar.YEAR)}년 ${calendar.get(Calendar.MONTH) + 1}월")
        val tempMonth = calendar.get(Calendar.MONTH)

        //일 구하기

        //6주 7일로 날짜를 표시
        var dayList: MutableList<Date> = MutableList(6 * 7 ) { Date() }

        for(i in 0..5) {
            for (k in 0..6) {
                calendar.add(Calendar.DAY_OF_MONTH, (1 - calendar.get(Calendar.DAY_OF_WEEK)) + k)
                dayList[i * 7 + k] = calendar.time
            }
            calendar.add(Calendar.DAY_OF_MONTH, 1)
        }


        val dayListManager = GridLayoutManager(holder.view.context,7)
        val dayAdapter = Day_adapter(tempMonth,dayList)
        list_layout.layoutManager = dayListManager
        list_layout.adapter = dayAdapter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Month {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.month_item,parent,false)
        return Month(view)
        }




    override fun getItemCount(): Int {
        return Int.MAX_VALUE / 2
    }

    class Month(val view: View) : RecyclerView.ViewHolder(view)
    }






