package com.example.room_persistance_librar_shoppinglist.activities

import android.app.Application
import com.example.room_persistance_librar_shoppinglist.database.MainDataBase

class MainApp : Application() {
    val database by lazy { MainDataBase.getDataBase(this) }
}