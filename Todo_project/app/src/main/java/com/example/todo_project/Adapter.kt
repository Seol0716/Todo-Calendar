package com.example.todo_project

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_project.databinding.ItemBinding

 class Adapter(private val data: ArrayList<Data>): RecyclerView.Adapter<Adapter.ViewHoler>() {


     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHoler {
         val binding = ItemBinding.inflate(
             LayoutInflater.from(parent.context),
             parent, false
         )

         //체크박스 기능
         return ViewHoler(binding).also {holder ->
             binding.checkBtn.setOnCheckedChangeListener(
                 CompoundButton.OnCheckedChangeListener { _, isChecked ->
                     data.getOrNull(holder.adapterPosition)?.complete = isChecked

                     if (binding.checkBtn.isChecked) {
                         binding.checkBtn.setBackgroundResource(R.drawable.item_checked_button)
                     }
                     else {
                         binding.checkBtn.setBackgroundResource(R.drawable.item_button_custom)
                     }
                 })
         }
     }

     override fun onBindViewHolder(holder: Adapter.ViewHoler, position: Int) {
         holder.bind(data[position])
     }

     override fun getItemCount(): Int = data.size

     class ViewHoler(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
         fun bind(data: Data) {
             binding.checkBtn.isChecked = data.complete
             binding.edit.setText(data.title)
             binding.deleteBtn
         }
     }


 }



