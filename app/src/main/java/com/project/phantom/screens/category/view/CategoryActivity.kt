package com.project.phantom.screens.category.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.project.phantom.screens.base.BaseActivity
import com.project.phantom.screens.category.domain.CategoryViewModel
import com.project.phantom.theme.PhantomTheme
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class CategoryActivity : BaseActivity() {

    companion object {
        private const val INIT_MODEL = "init_model"

        fun start(activity: BaseActivity, initModel: CategoryPageInitModel) {
            val intent = Intent(activity, CategoryActivity::class.java)
            intent.putExtra(INIT_MODEL, initModel)
            activity.startActivity(intent)
        }
    }

    private lateinit var initModel: CategoryPageInitModel
    private val viewModel: CategoryViewModel by viewModel(parameters = {
        parametersOf(initModel)
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initModel = intent.getSerializableExtra(INIT_MODEL) as CategoryPageInitModel
        setContent {
            PhantomTheme {
                Surface {
                    CategoryScreen().Get(
                        activity = this,
                        viewModel = viewModel,
                        initModel = initModel
                    )
                }
            }
        }
        viewModel.loadPage()
    }
}
