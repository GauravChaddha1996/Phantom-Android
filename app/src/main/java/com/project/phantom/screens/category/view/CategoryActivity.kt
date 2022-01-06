package com.project.phantom.screens.category.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.project.phantom.screens.base.BaseActivity
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.screens.category.domain.CategoryViewModel
import com.project.phantom.theme.PhantomTheme
import com.project.phantom.ui.lce.PhantomLCE
import com.project.phantom.ui.lce.PhantomLceInteraction
import com.project.phantom.ui.list.VerticalList
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
            CategoryScreen(interactions = SnippetInteractions(this), viewModel = viewModel)
        }
        viewModel.loadPage()
    }

    @Composable
    private fun CategoryScreen(interactions: SnippetInteractions, viewModel: CategoryViewModel) {
        PhantomTheme {
            Surface {
                val state = viewModel.state
                VerticalList(
                    rvDataState = state.rvDataState,
                    interaction = interactions
                )
                PhantomLCE(
                    data = state.lceState,
                    interaction = object : PhantomLceInteraction {
                        override fun onRetryClicked() {
                            viewModel.loadPage()
                        }
                    }
                )
            }
        }
    }
}
