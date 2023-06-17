package com.example.room_persistance_librar_shoppinglist.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.room_persistance_librar_shoppinglist.R
import com.example.room_persistance_librar_shoppinglist.databinding.ActivityNewNoteBinding

class NewNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBarSettings()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.new_note_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.id_save){

        } else if (item.itemId == android.R.id.home){

        }
        return super.onOptionsItemSelected(item)
    }

    private fun actionBarSettings(){
        val backButton = supportActionBar
        backButton?.setDisplayHomeAsUpEnabled(true)
    }
}