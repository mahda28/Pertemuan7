package com.example.pertemuan7

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pertemuan7.databinding.ActivityLoginBinding
import com.example.pertemuan7.databinding.ActivityMainBinding

class MainActivity(private val context: Context,) {
    class ViewHolder(val binding : ActivityMainBinding)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=ActivityMainBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return listStudent.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtNama.text=listStudent[position].nama
        Glide.with(holder.itemView.context).load(listStudent[position].foto).into(holder.binding.images)
        holder.binding.cardView.setOnClickListener {
            val intent= Intent(context,DetailActivity::class.java)
            intent.putExtra("nim",listStudent[position].nim)
            intent.putExtra("nama",listStudent[position].nama)
            intent.putExtra("telepon",listStudent[position].nomorTelepon)
            intent.putExtra("foto",listStudent[position].foto)
            context.startActivity(intent)

}