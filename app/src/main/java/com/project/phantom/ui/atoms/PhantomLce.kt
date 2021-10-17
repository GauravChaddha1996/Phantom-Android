package com.project.phantom.ui.atoms

import androidx.compose.runtime.Composable
import com.project.phantom.data.uiModels.atoms.PhantomLceData

@Composable
fun PhantomLCE(data: PhantomLceData, interaction: PhantomLceInteraction) {

}

interface PhantomLceInteraction {
    fun onRetryClicked()
}