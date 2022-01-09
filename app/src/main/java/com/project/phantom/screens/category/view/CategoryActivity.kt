package com.project.phantom.screens.category.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue.Concealed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.project.phantom.R
import com.project.phantom.screens.base.BaseActivity
import com.project.phantom.screens.base.SnippetInteractions
import com.project.phantom.screens.category.domain.CategoryViewModel
import com.project.phantom.theme.PhantomColorName
import com.project.phantom.theme.PhantomFontStyle
import com.project.phantom.theme.PhantomTheme
import com.project.phantom.ui.commons.getResolvedColor
import com.project.phantom.ui.lce.PhantomLCE
import com.project.phantom.ui.lce.PhantomLceData
import com.project.phantom.ui.lce.PhantomLceInteraction
import com.project.phantom.ui.list.VerticalList
import com.project.phantom.ui.text.PhantomText
import com.project.phantom.ui.text.TextData
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

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    private fun CategoryScreen(interactions: SnippetInteractions, viewModel: CategoryViewModel) {
        PhantomTheme {
            Surface {
                val state = viewModel.state
                val scaffoldState = rememberBackdropScaffoldState(initialValue = Concealed)
                BackdropScaffold(
                    scaffoldState = scaffoldState,
                    appBar = { GetTopAppBar(state.lceState) },
                    backLayerContent = {},
                    frontLayerContent = { GetFrontLayer(state, interactions, viewModel) },
                    gesturesEnabled = false,
                    peekHeight = 56.dp,
                    headerHeight = 56.dp,
                    backLayerBackgroundColor = initModel.categoryColor.getResolvedColor()
                )
            }
        }
    }

    @Composable
    private fun GetTopAppBar(lceState: PhantomLceData) {
        TopAppBar(
            title = { },
            navigationIcon = {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(CircleShape)
                        .clickable { onBackPressed() }
                ) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier
                            .size(28.dp)
                            .align(Alignment.Center)
                    )
                }
            },
            actions = {
                AnimatedVisibility(visible = lceState.showSuccess) {
                    Row {
                        Row(
                            modifier = Modifier
                                .padding(end = 12.dp)
                                .align(Alignment.CenterVertically)
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_filter_list),
                                contentDescription = "Filter",
                                modifier = Modifier
                                    .size(24.dp)
                                    .padding(end = 2.dp)
                            )
                            PhantomText(
                                data = TextData().setDefaults(
                                    "Filter",
                                    PhantomFontStyle.MEDIUM_400,
                                    PhantomColorName.GREY_700
                                ),
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(end = 12.dp)
                                .align(Alignment.CenterVertically)
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_sort),
                                contentDescription = "Sort",
                                modifier = Modifier
                                    .padding(end = 2.dp)
                                    .size(24.dp)
                            )
                            PhantomText(
                                data = TextData().setDefaults(
                                    "Sort",
                                    PhantomFontStyle.MEDIUM_400,
                                    PhantomColorName.GREY_700
                                ),
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        }
                    }
                }
            },
            elevation = 0.dp,
            backgroundColor = Color.Transparent
        )
    }

    @Composable
    private fun GetFrontLayer(
        state: CategoryScreenState,
        interactions: SnippetInteractions,
        viewModel: CategoryViewModel
    ) {
        VerticalList(
            rvDataState = state.rvDataState,
            interaction = interactions,
            contentPadding = PaddingValues()
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
