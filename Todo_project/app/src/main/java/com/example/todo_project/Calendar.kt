package com.example.todo_project

import android.bluetooth.BluetoothA2dp
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.Fragment
import com.example.todo_project.databinding.CalendarBinding

class Calendar: Fragment(R.layout.calendar) {

    //fragment
    private var _binding: CalendarBinding ?= null
    private lateinit var calendar: CalendarView
    private lateinit var cal_data: TextView
    private lateinit var btn: Button
    private lateinit var edit: EditText
    //view
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CalendarBinding.inflate(inflater,container,false)

        //뷰 연결
        calendar = _binding!!.calendar
        cal_data = _binding!!.calData
        edit = _binding!!.edit
        btn = _binding!!.calBtn


        //캘린더뷰
        calendar.setOnDateChangeListener(CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
            cal_data.setText(String.format("%d  /  %d   %d",year,month+1, dayOfMonth))
        })

        
        val view = binding?.root

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    }
