package com.example.room_persistance_librar_shoppinglist.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.room_persistance_librar_shoppinglist.R
import com.example.room_persistance_librar_shoppinglist.database.NoteAdapter
import com.example.room_persistance_librar_shoppinglist.databinding.ActivityNewNoteBinding
import com.example.room_persistance_librar_shoppinglist.entities.NoteItem
import com.example.room_persistance_librar_shoppinglist.fragments.NoteFragment
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class NewNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewNoteBinding
    private lateinit var editLauncher: ActivityResultLauncher<Intent>

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
        if (item.itemId == R.id.id_save) {
            setMainResult()
        } else if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setMainResult() {
        val i = Intent().apply {
            putExtra(NoteFragment.NEW_NOTE_KEY, createsNewNotes())
        }
    }

    private fun createsNewNotes(): NoteItem {
        return NoteItem(
            null,
            binding.edTitle.text.toString(),
            binding.edDescription.text.toString(),
            getCurrentTime(),
            ""
        )
    }

    private fun getCurrentTime(): String {
        val formatter = SimpleDateFormat("hh:mm:ss - yyyy/MM/dd", Locale.getDefault())
        return formatter.format(Calendar.getInstance().time)
    }

    private fun actionBarSettings() {
        val backButton = supportActionBar
        backButton?.setDisplayHomeAsUpEnabled(true)
    }
}