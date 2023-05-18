package com.example.pertemuan7

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.pertemuan7.databinding.ActivityDetailBinding

class Utama : AppCompatActivity() {
lateinit var binding : ActivityDetailBinding
lateinit var sharedPrefs : SharedPreferences
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityDetailBinding.inflate(layoutInflater)
    setContentView(binding.root)

    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    sharedPrefs = getSharedPreferences("DataUser", Context.MODE_PRIVATE)

    val userEmail = sharedPrefs.getString("user_email", "")
    val userPassword = sharedPrefs.getString("user_password", "")

    binding.txtEmail.text ="Email : ${userEmail.toString()}"
    binding.textPassword.text = "Password : ${userPassword.toString()}"

    binding.btnLogout.setOnClickListener{
        with(sharedPrefs.edit()) {
            clear()
            apply()
        }
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
override fun onOptionsItemSelected(item: MenuItem) : Boolean{
    return when(item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }else ->super.onOptionsItemSelected(item)
    }
}
}