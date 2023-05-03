package com.example.todo_project

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.todo_project.databinding.ScheduleAddItemBinding

class Schedule_add : AppCompatActivity() {
    private lateinit var binding: ScheduleAddItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ScheduleAddItemBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //타이틀바 숨기기
        var actionBar: ActionBar? = supportActionBar
        actionBar?.hide()
    }

}