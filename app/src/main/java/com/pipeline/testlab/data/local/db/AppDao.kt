package com.pipeline.testlab.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pipeline.testlab.data.models.PostsResponseItem

@Dao
interface AppDao {

    @Query("SELECT * FROM posts")
    suspend fun getAllMovies(): List<PostsResponseItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<PostsResponseItem>)
}