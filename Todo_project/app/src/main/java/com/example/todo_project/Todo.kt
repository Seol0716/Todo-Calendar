package com.example.todo_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo_project.databinding.TodoBinding

class Todo: Fragment(R.layout.todo) {

    //fragment
    private var _binding: TodoBinding?= null
    lateinit var editText: EditText
    lateinit var add_btn: Button

    //view
    private val binding get() = _binding

    //데이터 셋팅
    private val data : ArrayList<Data> = arrayListOf(
        Data(false,"게으른",false),
        Data(false,"습관",false),
        Data(false,"고치기",false)
    )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = TodoBinding.inflate(inflater,container, false)

        //연결
        editText = _binding!!.Edit
        add_btn = _binding!!.addBtn


        //추가기능
        add_btn.setOnClickListener(View.OnClickListener {
            //
            var edit_data = editText.text.toString()
            var complete_data = false
            var delete_data = false

            if(edit_data.isBlank()){
                Toast.makeText(context, "할 일을 입력해주세요", Toast.LENGTH_SHORT).show()
            }
            else{
                data.add(Data(complete_data,edit_data,delete_data))
                editText.setText(" ")

                binding?.recycler?.adapter = Adapter(data)

            }

        })
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