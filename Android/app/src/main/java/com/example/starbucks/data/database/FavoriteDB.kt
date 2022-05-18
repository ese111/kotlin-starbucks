package com.example.starbucks.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.starbucks.data.dao.FavoriteDAO
import com.example.starbucks.data.vo.FavoriteMenu

@Database(entities = [FavoriteMenu::class], version = 1)
abstract class FavoriteDB: RoomDatabase(){

    abstract fun favoriteDAO(): FavoriteDAO

}
