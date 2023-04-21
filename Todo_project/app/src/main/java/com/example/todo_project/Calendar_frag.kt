package com.example.todo_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_project.databinding.CalendarBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class Calendar_frag : Fragment(R.layout.calendar) {

    //fragment
    private var _binding: CalendarBinding ?= null

    private lateinit var recyclerView: RecyclerView
    private lateinit var title: TextView
    private lateinit var adapter: Cal_Adapter
    private lateinit var Date : Date
    var position: Int = 0

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

        val view = binding?.root

        initView(_binding!!)

        create_data()
        return view
    }

    private fun initView(binding: CalendarBinding) {
        title = binding.title
        recyclerView = binding.calRecycler
        position -= (Int.MAX_VALUE / 2)

        var calendar  = Calendar.getInstance()

        calendar.time = Date()
        calendar.set(Calendar.DAY_OF_MONTH,1) //현재 날짜로 초기화



        title.text = "${calendar.get(Calendar.YEAR)}년 ${calendar.get(Calendar.MONTH) + 1}월"
        binding?.calRecycler?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding?.calRecycler?.adapter = Cal_Adapter(text)

    }


    private fun create_data() {
        binding?.calRecycler?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    }


