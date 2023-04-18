package com.example.todo_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo_project.databinding.CalendarBinding
import java.util.*
import kotlin.collections.ArrayList

class Calendar() : Fragment(R.layout.calendar) {

    //fragment
    private var _binding: CalendarBinding ?= null
    private lateinit var calendarview: CalendarView
    private lateinit var cal_data: TextView
    private lateinit var btn: Button
    private lateinit var edit: EditText
    private lateinit var calendar: Calendar
    private lateinit var date: Date
    //view
    private val binding get() = _binding


    //데이터 셋팅
    private val text : ArrayList<Data_cal> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CalendarBinding.inflate(inflater,container,false)

        //뷰 연결
        calendarview = _binding!!.calendar
        cal_data = _binding!!.calData
        edit = _binding!!.edit
        btn = _binding!!.calBtn



        //캘린더뷰
        calendarview.setOnDateChangeListener(CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->


            btn.setOnClickListener(View.OnClickListener {

                var text_data = edit.text.toString()
                cal_data.setText(String.format("%d / %d / %d",year, month+1, dayOfMonth)).toString()
                text.add(Data_cal(text_data,year,month,dayOfMonth,view.id))
                binding?.recycler?.adapter = Cal_Adapter(text)

            })

        })
        val view = binding?.root

        create_data()

        return view
    }


    private fun create_data() {
        binding?.recycler?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    }
