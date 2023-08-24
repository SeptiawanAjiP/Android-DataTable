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
}
```
replace Tag with the latest version.

## Usage
To use this library, just extend the DataTAblectivity class in your activity class. Prepare your data and observe the format from the example below. There are two vital parameters: columns (array of column) and listData (array of data). The number of array columns must match the count of variables in your entities.
```bash
class MainActivity: DataTableActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

        initData(columns, listData)
    }
}
```
### Column Data Class
This is an column entity (data class), and this form cannot be altered as this data class is within the library. 'data' is refers to name
```bash
data class Column(

	@field:SerializedName("data")
	val data: String? = null,

	@field:SerializedName("title")
	val title: String? = null
)
```
The data refers to the name of variables in your entities, and that title will become the column name
### Dynamic Data Class
While this is an example entity (data class), it can be modified according to the entities you possess.
```bash
data class User(
    val name: String,
    val age: Int,
    val address: String,
    val email: String
)
```