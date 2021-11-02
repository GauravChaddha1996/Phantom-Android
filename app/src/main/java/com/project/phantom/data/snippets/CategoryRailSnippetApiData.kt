package com.project.phantom.data.snippets

import com.project.phantom.data.atoms.PhantomTextData
import com.project.phantom.data.atoms.TextData
import com.project.phantom.data.atoms.click.OpenCategoryClickData
import com.project.phantom.data.atoms.click.PhantomClickData
import com.project.phantom.data.snippets.base.SnippetApiData
import com.project.phantom.data.snippets.base.SnippetData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class CategoryRailSnippetApiData(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: TextData? = null
) : SnippetApiData()

class CategoryRailSnippetData(
    val name: PhantomTextData,
    val phantomClickData: PhantomClickData
) : SnippetData() {
    companion object {
        fun create(data: CategoryRailSnippetApiData): CategoryRailSnippetData {
            return CategoryRailSnippetData(
                name = PhantomTextData.create(data.name),
                phantomClickData = PhantomClickData(OpenCategoryClickData(data.id))
            )
        }
    }
}