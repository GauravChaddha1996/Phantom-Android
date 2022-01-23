package com.project.phantom.screens.cart.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.project.phantom.PhantomApplication.Companion.INSTANCE
import com.project.phantom.R
import com.project.phantom.database.ProductDatabase
import com.project.phantom.logger.PhantomLogger
import com.project.phantom.network.PhantomCEH
import com.project.phantom.screens.cart.view.CartScreenState
import com.project.phantom.theme.font.PhantomTextStyle
import com.project.phantom.ui.snippets.cartItem.CartItemData
import com.project.phantom.ui.snippets.stepper.StepperSnippetData
import com.project.phantom.ui.text.TextData
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CartViewModelImpl : CartViewModel() {

    override val defaultPhantomCEH: CoroutineExceptionHandler = PhantomCEH {
        PhantomLogger.logException(it)
    }
    override var state: CartScreenState by mutableStateOf(CartScreenState())

    private val db: ProductDatabase = ProductDatabase.getInstance()

    init {
        launch {
            db.getCountBus().collect { loadCart() }
        }
    }

    override fun loadCart() {
        launch {
            val allAddedProducts = db.getAll()
            var totalCost = 0
            val cartItemDataList = allAddedProducts
                .map {
                    val cartItemData = CartItemData.create(it)
                    cartItemData.setDefaults()
                    totalCost += it.cost.times(it.count)
                    cartItemData
                }
            val snippetData = StepperSnippetData(
                title = TextData(INSTANCE.getString(R.string.place_order, totalCost))
            )
            state = state.copy(
                pageTitle = TextData().setDefaults(
                    text = INSTANCE.getString(R.string.cart),
                    textStyle = PhantomTextStyle.HeadlineMediumBold
                ),
                items = cartItemDataList,
                stepperSnippetData = snippetData,
                closeBottomSheet = cartItemDataList.isEmpty()
            )
        }
    }

    override fun addItem(productId: Int) {
        db.modifyProductCount(productId = productId, modifyNumber = 1)
    }

    override fun removeItem(productId: Int) {
        db.modifyProductCount(productId = productId, modifyNumber = -1)
    }
}
