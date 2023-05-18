package com.example.pertemuan7

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pertemuan7.databinding.ActivityLoginBinding
import com.example.pertemuan7.databinding.ActivityMainBinding

<<<<<<< HEAD
class MainActivity(private val context: Context,) {
    class ViewHolder(val binding : ActivityMainBinding)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=ActivityMainBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
=======

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var dbHelper: UserDbHelper
    lateinit var sharedPrefs: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs = getSharedPreferences("DataUser", Context.MODE_PRIVATE)

        dbHelper = UserDbHelper(this)
        binding.btnLogin.setOnClickListener {
            val email = binding.inputEmail.text.toString()
            val password = binding.inputPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                val user = dbHelper.getUser(email, password)

                if (user != null) {
                    val intent = Intent(this, DetailActivity::class.java)
                    with(sharedPrefs.edit()) {
                        putInt("user_id", user.id)
                        putString("user_email", user.email)
                        putString("user_password", user.password)
                        apply()
                    }
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Email atau Password Salah!!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Data tidak boleh kosong!!", Toast.LENGTH_SHORT).show()
            }

        }
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

>>>>>>> b3090c6f26d9fd02f7b6209cec63c77d5c0e4922
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