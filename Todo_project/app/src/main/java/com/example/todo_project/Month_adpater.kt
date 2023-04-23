package com.example.todo_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.todo_project.databinding.MonthItemBinding
import java.util.*

class Month_adpater: RecyclerView.Adapter<Month_adpater.ViewHolder>() {
    val center : Int = Int.MAX_VALUE / 2
    var calendar: Calendar = Calendar.getInstance()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Month_adpater.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.month_item,parent,false)
        return ViewHolder(view)
        }


    override fun onBindViewHolder(holder: MonthItemBinding, position: Int) {

        //달 구하기
        calendar.time = Date()

        //현재 날짜, 포지션 1로 설정
        calendar.set(Calendar.DAY_OF_MONTH,1)

        //캘린더의 포지션만큼 포지션 이동
        calendar.add(Calendar.MONTH,position - center)

        holder.title.text = "${calendar.get(Calendar.YEAR)}년 ${calendar.get(Calendar.MONTH) + 1}월"
        val tempMonth = calendar.get(Calendar.MONTH)

        //일 구하기

        //6주 7일로 날짜를 표시
        var dayList: MutableList<Date> = MutableList(6 * 7 ) { Date() }

        for(i in 0..5) {
            for (k in 0..6) {
                calendar.add(Calendar.DAY_OF_MONTH, (1 - calendar.get(Calendar.DAY_OF_WEEK)) + k)
                dayList[i * 7 + k] = calendar.time
            }
            calendar.add(Calendar.WEEK_OF_MONTH, 1)
        }

    }


    override fun getItemCount(): Int = Int.MAX_VALUE

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
    }






