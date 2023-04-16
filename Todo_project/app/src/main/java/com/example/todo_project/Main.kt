package com.example.todo_project

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.todo_project.databinding.MainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class Main : AppCompatActivity() {

    private lateinit var binding: MainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = MainBinding.inflate(layoutInflater)
        setTheme(R.style.Theme_Todo_project)
        setContentView(binding.root)


        //타이틀바 숨기기
        var actionBar: ActionBar? = supportActionBar
        actionBar?.hide()


        var todo_btn: BottomNavigationView = binding.bottomNavigationView

        todo_btn.itemIconTintList = null
        todo_btn
        var todo: Todo = Todo()
        var calendar: Calendar = Calendar()

        //Calendar fragment


        supportFragmentManager.beginTransaction().replace(R.id.main_frag, todo).commit()

        todo_btn.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.todo_tab -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_frag, todo).commit()
                    return@setOnItemSelectedListener true
                }

                R.id.cal_tab -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_frag, calendar)
                        .commit()
                    return@setOnItemSelectedListener true
                }

                else -> return@setOnItemSelectedListener false

            }
        }


    }



}





