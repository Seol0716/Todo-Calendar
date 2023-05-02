package com.example.todo_project

import android.view.LayoutInflater
import android.view.View
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


         return ViewHoler(binding).also {holder ->
             //체크박스 기능
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

             //삭제기능
             binding.deleteBtn.setOnClickListener(View.OnClickListener { v: View? ->
                 if(data.get(holder.adapterPosition)?.complete == true){
                     data.removeAt(holder.adapterPosition)
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



