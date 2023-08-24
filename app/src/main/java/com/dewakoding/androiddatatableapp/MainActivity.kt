package com.dewakoding.androiddatatableapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dewakoding.androiddatatable.DataTableActivity
import com.dewakoding.androiddatatable.data.Column
import com.dewakoding.androiddatatableapp.data.User

class MainActivity: DataTableActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val columns = ArrayList<Column>()
        columns.add(Column("name", "Name"))
        columns.add(Column("age", "Age"))
        columns.add(Column("address", "Adress"))
        columns.add(Column("email", "Email"))

        val users = ArrayList<User>()
        users.add(User("John", 30, "123 Main St", "john@example.com"))
        users.add(User("Doe", 28, "456 Elm St", "jane@example.com"))
        users.add(User("Michael", 35, "789 Oak Ave", "michael@example.com"))
        users.add(User("Emily", 22, "234 Maple Rd", "emily@example.com"))
        users.add(User("William", 40, "567 Pine Lane", "william@example.com"))
        users.add(User("Olivia", 29, "890 Cedar Blvd", "olivia@example.com"))
        users.add(User("James", 31, "345 Birch Court", "james@example.com"))
        users.add(User("Sophia", 26, "678 Walnut Drive", "sophia@example.com"))
        users.add(User("Robert", 37, "901 Willow Street", "robert@example.com"))
        users.add(User("Ava", 24, "123 Cherry Lane", "ava@example.com"))

        initData(columns, users, User::class.java)
    }
}