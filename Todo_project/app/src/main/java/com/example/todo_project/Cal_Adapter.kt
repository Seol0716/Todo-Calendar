package com.example.todo_project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_project.databinding.CalCustomBinding
import java.util.*
import kotlin.collections.ArrayList

class Cal_Adapter(private val data: ArrayList<Data_cal>): RecyclerView.Adapter<Cal_Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Cal_Adapter.ViewHolder {
        val binding = CalCustomBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )


        return ViewHolder(binding)
        }


    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(data[position])


    }

    class ViewHolder(private val binding: CalCustomBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: Data_cal) {
            binding.date.text =   "${data.year}년 ${data.month} + 1}월"
        }
    }

    }






