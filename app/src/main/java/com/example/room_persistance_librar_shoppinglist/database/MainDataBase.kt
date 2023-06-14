package com.example.room_persistance_librar_shoppinglist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room_persistance_librar_shoppinglist.entities.LibraryItem
import com.example.room_persistance_librar_shoppinglist.entities.NoteItem
import com.example.room_persistance_librar_shoppinglist.entities.ShoppingListItem
import com.example.room_persistance_librar_shoppinglist.entities.ShoppingListNames

@Database(entities = [LibraryItem::class, NoteItem::class, ShoppingListItem::class,
        ShoppingListNames::class], version = 1)

abstract class MainDataBase : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: MainDataBase? = null
        fun getDataBase(context: Context): MainDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDataBase::class.java,
                    "sopping_list.db"
                ).build()
                instance
            }
        }
    }
}