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

        create_data()

        initView(_binding!!)
        return view
    }

    private fun initView(binding: CalendarBinding) {
        title = binding.title
        recyclerView = binding.recycler
        position -= (Int.MAX_VALUE / 2)

        val date = Calendar.getInstance().run {
            add(Calendar.MONTH,position)
            time
        }

        Date = date

        var date_time: String = SimpleDateFormat("yyyyMM")
            .format(Date.time)

        text.add(Data_cal(date_time,position))
        title.setText(date_time)

        binding?.recycler?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
       

    }


    private fun create_data() {
        binding?.recycler?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    }
