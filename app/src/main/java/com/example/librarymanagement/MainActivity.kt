package com.example.librarymanagement

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var listViewBooks: ListView
    private lateinit var buttonAddBook: Button
    private lateinit var buttonBorrowBook: Button
    private lateinit var buttonChangeStaff: Button
    private lateinit var textViewStaff: TextView

    private val bookList = mutableListOf("Sách 01", "Sách 02", "Sách 03")
    private val borrowedBooks = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ các thành phần giao diện
        listViewBooks = findViewById(R.id.listViewBooks)
        buttonAddBook = findViewById(R.id.buttonAddBook)
        buttonBorrowBook = findViewById(R.id.buttonBorrowBook)
        buttonChangeStaff = findViewById(R.id.buttonChangeStaff)
        textViewStaff = findViewById(R.id.textViewStaff)

        // Hiển thị danh sách sách
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, bookList)
        listViewBooks.adapter = adapter

        // Thêm chức năng cho nút đổi nhân viên
        buttonChangeStaff.setOnClickListener {
            textViewStaff.setText(R.string.staff_changed)
        }

        // Thêm chức năng cho nút mượn sách
        buttonBorrowBook.setOnClickListener {
            val selectedBook = listViewBooks.selectedItem as String?
            if (selectedBook != null && !borrowedBooks.contains(selectedBook)) {
                borrowedBooks.add(selectedBook)
                bookList.remove(selectedBook)
                adapter.notifyDataSetChanged()  // Cập nhật lại giao diện
            }
        }

        // Thêm chức năng cho nút thêm sácha
        buttonAddBook.setOnClickListener {
            val newBook = "Sách ${bookList.size + 10}"
            bookList.add(newBook)
            adapter.notifyDataSetChanged()  // Cập nhật lại giao diện
        }
        
    }
}