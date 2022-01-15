package com.project.phantom.screens.category.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import com.project.phantom.screens.base.BaseActivity
import com.project.phantom.screens.category.domain.CategoryViewModel
import com.project.phantom.theme.PhantomColorName
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
                val categoryScreenColors = remember {
                    CategoryScreenColors.get(initModel.categoryColor?.name ?: PhantomColorName.RED_300)
                }
                CompositionLocalProvider(
                    values = arrayOf(LocalCategoryScreenColors provides categoryScreenColors),
                    content = {
                        Surface {
                            CategoryScreen().Get(
                                activity = this,
                                viewModel = viewModel
                            )
                        }
                    }
                )
            }
        }
        viewModel.loadPage()
    }
}
