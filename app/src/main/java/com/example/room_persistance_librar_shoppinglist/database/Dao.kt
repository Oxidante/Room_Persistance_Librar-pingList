package com.example.room_persistance_librar_shoppinglist.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.room_persistance_librar_shoppinglist.entities.NoteItem
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Query("SELECT * FROM note_list")
    fun gerAllNotes(): Flow<List<NoteItem>>

    @Insert
    suspend fun insertNote(note: NoteItem)
}