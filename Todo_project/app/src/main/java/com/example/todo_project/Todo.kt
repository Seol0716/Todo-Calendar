package com.example.todo_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo_project.databinding.TodoBinding

class Todo: Fragment(R.layout.todo) {

    //fragment
    private var _binding: TodoBinding?= null

    //view
    private val binding get() = _binding



    //데이터셋팅
    private val data = listOf(
        Data(false,"할 일", false),
        Data(false,"게으름", false),
        Data(false,"섹스", false)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = TodoBinding.inflate(inflater,container, false)
        val view = binding?.root

        create_data()

        return view
    }

    private fun create_data() {
        binding?.recycler?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding?.recycler?.adapter = Adapter(data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}