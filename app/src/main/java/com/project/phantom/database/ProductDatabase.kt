package com.project.phantom.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.phantom.PhantomApplication
import com.project.phantom.logger.PhantomLogger
import com.project.phantom.network.PhantomCEH
import com.project.phantom.ui.click.AddProductClickData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

@OptIn(DelicateCoroutinesApi::class)
@Database(entities = [ProductDbModel::class], version = 1)
abstract class ProductDatabase : RoomDatabase(), CoroutineScope {
    override val coroutineContext: CoroutineContext =
        GlobalScope.coroutineContext + Dispatchers.IO + PhantomCEH { PhantomLogger.logException(it) }

    abstract fun getProductDao(): ProductDao

    companion object {
        private lateinit var instance: ProductDatabase
        private const val DB_NAME = "product_database"

        fun getInstance(): ProductDatabase {
            if (::instance.isInitialized.not()) {
                instance = Room.databaseBuilder(
                    PhantomApplication.INSTANCE.applicationContext,
                    ProductDatabase::class.java,
                    DB_NAME
                ).build()
            }
            return instance
        }
    }

    private val countBus = MutableSharedFlow<Int>()

    fun getCountBus(): SharedFlow<Int> = countBus

    fun setup() = launch {
        val productDao = getProductDao()
        countBus.emit(productDao.getCount())
    }

    suspend fun getAll() = withContext(coroutineContext) {
        val productDao = getProductDao()
        return@withContext productDao.getAll()
    }

    fun addProductToDb(clickData: AddProductClickData) {
        clickData.productId ?: return
        launch {
            val productDao = getProductDao()
            val existingProductModel = productDao.getForId(clickData.productId)
            val newProductModel = ProductDbModel.create(
                clickData = clickData,
                existingCount = existingProductModel?.count ?: 0
            )
            newProductModel ?: return@launch
            productDao.insert(newProductModel)
            val totalCount = productDao.getCount()
            countBus.emit(totalCount)
        }
    }

    fun modifyProductCount(productId: Int, modifyNumber: Int) =
        launch {
            val productDao = getProductDao()
            val existingProductModel = productDao.getForId(productId)
            existingProductModel ?: return@launch
            val newProductModel = existingProductModel
                .copy(count = existingProductModel.count + modifyNumber)
            if (newProductModel.count == 0) {
                productDao.delete(newProductModel.id)
            } else {
                productDao.insert(newProductModel)
            }
            val totalCount = productDao.getCount()
            countBus.emit(totalCount)
        }

    fun clearProducts() {
        launch {
            val productDao = getProductDao()
            productDao.clearAll()
            val totalCount = productDao.getCount()
            countBus.emit(totalCount)
        }
    }
}
