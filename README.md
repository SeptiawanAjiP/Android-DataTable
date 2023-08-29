# Android DataTable
![image](https://raw.githubusercontent.com/SeptiawanAjiP/Android-DataTable/master/demo-image.jpeg)

Facing trouble displaying data in Android? Tired of the list format (recyclerview) and looking for a table layout? Look no further, because this is the library you've been searching for. Simply prepare your data, and watch the dynamic table effortlessly come to life. **Android DataTable library** is designed to simplify the process of creating dynamic tables in Android applications. It leverages the power of the [DataTable](https://datatables.net/) library in JavaScript, using jQuery, to provide an efficient and flexible solution for displaying tabular data in your Android app's WebView.

## Features

- Create dynamic tables in Android applications using a WebView.
- Utilize the popular DataTable library in JavaScript, powered by jQuery.
- Effortlessly display, sort, and filter tabular data.
- Easily bind data from Android to JavaScript for interactive tables.

## Installation

Use Gradle. Add it in your settings.gradle at the end of repositories:

```bash
dependencyResolutionManagement {
    repositories {
        ....
        maven { url 'https://jitpack.io' }
    }
}
```
then, add the dependecy in your build.gradle file (Module)
```bash
dependencies {
    implementation 'com.github.SeptiawanAjiP:Android-DataTable:Tag'
    
    // convert json string to entity
    implementation 'com.google.code.gson:gson:2.10.1'
}
```
replace Tag with the latest version.

## Usage
To use this library, just extend the DataTAblectivity class in your activity class. Prepare your data and observe the format from the example below. There are three vital parameters: columns (array of column), listData (array of data), and isActionButtonShow (option to enable or disable action button in every row). **The number of array columns must match the count of variables in your entities.**

### XML Layout
```bash
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    <TextView
        android:id="@+id/tv_title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Android DataTable"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:layout_marginTop="30dp"
        android:textSize="24sp"
        android:textStyle="bold"/>
    <com.dewakoding.androiddatatable.DataTableView
        android:id="@+id/dtv_table"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toBottomOf="@id/tv_title"
        app:layout_constraintBottom_toBottomOf="parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```
### Activity
```bash
package com.dewakoding.androiddatatableapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dewakoding.androiddatatable.data.Column
import com.dewakoding.androiddatatable.listener.OnWebViewComponentClickListener
import com.dewakoding.androiddatatableapp.data.User
import com.dewakoding.androiddatatableapp.databinding.ActivityMainBinding

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
```
### Column Data Class
This is an column entity (data class), and this form cannot be altered as this data class is within the library.
```bash
data class Column(

	@field:SerializedName("data")
	val data: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)
```
The data refers to the name of variables in your entities, and that title will become the name/title of column.
####  REMEMBER : The number of array columns must match the count of variables in your entities.

## ToDo
- [x] Offline mode, access css and js from assets folder
- [x] Show button on Table and get response when button is clicked
- [x] Export as XML widget