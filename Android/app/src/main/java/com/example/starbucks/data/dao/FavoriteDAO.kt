package com.example.starbucks.data.dao

import androidx.room.*
import com.example.starbucks.data.vo.FavoriteMenu

@Dao
interface FavoriteDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: FavoriteMenu)

    @Query("SELECT * FROM favoritemenu")
    fun getFavorite(): List<FavoriteMenu>

    @Delete
    fun delete(item: FavoriteMenu)

    @Query("SELECT EXISTS(SELECT * FROM favoritemenu WHERE id = :id)")
    fun isChecked(id: Int): Boolean

}