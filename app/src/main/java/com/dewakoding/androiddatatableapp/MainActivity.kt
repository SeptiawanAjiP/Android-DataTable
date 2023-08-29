package com.dewakoding.androiddatatableapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dewakoding.androiddatatable.data.Column
import com.dewakoding.androiddatatable.listener.OnWebViewComponentClickListener
import com.dewakoding.androiddatatableapp.data.User
import com.dewakoding.androiddatatableapp.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity: AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val columns = ArrayList<Column>()
        columns.add(Column("name", "Name"))
        columns.add(Column("age", "Age"))
        columns.add(Column("address", "Adress"))
        columns.add(Column("email", "Email"))

        val listData = ArrayList<User>()
        listData.add(User("John", 30, "123 Main St", "john@example.com"))
        listData.add(User("Doe", 28, "456 Elm St", "jane@example.com"))
        listData.add(User("Michael", 35, "789 Oak Ave", "michael@example.com"))
        listData.add(User("Emily", 22, "234 Maple Rd", "emily@example.com"))
        listData.add(User("William", 40, "567 Pine Lane", "william@example.com"))
        listData.add(User("Olivia", 29, "890 Cedar Blvd", "olivia@example.com"))
        listData.add(User("James", 31, "345 Birch Court", "james@example.com"))
        listData.add(User("Sophia", 26, "678 Walnut Drive", "sophia@example.com"))
        listData.add(User("Robert", 37, "901 Willow Street", "robert@example.com"))
        listData.add(User("Ava", 24, "123 Cherry Lane", "ava@example.com"))

        binding.dtvTable.setTable(columns, listData, true)

        binding.dtvTable.setOnClickListener(object : OnWebViewComponentClickListener {
            override fun onRowClicked(dataStr: String) {
                // convert dataStr to your entity
                val userClicked = Gson().fromJson(dataStr, User::class.java)

                // now, you can get an entity that user clicked, replace this with your function.
                Toast.makeText(applicationContext, userClicked.name, Toast.LENGTH_SHORT).show()
            }
        })


    }
}