package com.project.phantom.screens.product.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import com.project.phantom.screens.base.BaseActivity
import com.project.phantom.screens.product.domain.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ProductActivity : BaseActivity() {
    companion object {
        private const val INIT_MODEL = "init_model"

        fun start(activity: BaseActivity, initModel: ProductPageInitModel) {
            val intent = Intent(activity, ProductActivity::class.java)
            intent.putExtra(INIT_MODEL, initModel)
            activity.startActivity(intent)
        }
    }

    private lateinit var initModel: ProductPageInitModel
    private val viewModel: ProductViewModel by viewModel(parameters = {
        parametersOf(initModel)
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initModel = intent.getSerializableExtra(INIT_MODEL) as ProductPageInitModel
        setContent {
            ProductScreen().Get(viewModel = viewModel)
        }
        viewModel.loadPage()
    }
}
