package com.project.phantom.screens.cart.view

import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.snippets.stepper.StepperSnippetData
import com.project.phantom.ui.text.TextData

data class CartScreenState(
    val pageTitle: TextData? = null,
    val items: List<SnippetData> = emptyList(),
    val stepperSnippetData: StepperSnippetData? = null,
    val closeBottomSheet: Boolean = false
)
