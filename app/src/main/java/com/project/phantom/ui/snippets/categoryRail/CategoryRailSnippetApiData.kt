package com.project.phantom.ui.snippets.categoryRail

import com.project.phantom.ui.click.ClickData
import com.project.phantom.ui.click.PhantomClickData
import com.project.phantom.ui.snippets.commons.SnippetApiData
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.PhantomTextData
import com.project.phantom.ui.text.TextData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CategoryRailSnippetApiData(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: TextData? = null,
    @Json(name = "click") val clickData: ClickData? = null,
) : SnippetApiData()

class CategoryRailSnippetData(
    val name: PhantomTextData,
    val phantomClickData: PhantomClickData
) : SnippetData() {
    companion object {
        fun create(data: CategoryRailSnippetApiData): CategoryRailSnippetData {
            return CategoryRailSnippetData(
                name = PhantomTextData.create(data.name),
                phantomClickData = PhantomClickData(data.clickData)
            )
        }
    }
}