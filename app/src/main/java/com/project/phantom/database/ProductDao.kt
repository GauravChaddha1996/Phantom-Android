package com.project.phantom.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dbModel: ProductDbModel)

    @Query("Delete from products where id like :id")
    fun delete(id: Int)

    @Query("Select * from products")
    fun getAll(): List<ProductDbModel>

    @Query("Select sum(count) from products")
    fun getCount(): Int

    @Query("Select * from products where id like :id")
    fun getForId(id: Int): ProductDbModel?

    @Query("Delete from products")
    fun clearAll()
}
