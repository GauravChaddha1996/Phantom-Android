package com.project.phantom.screens.category.models

import com.project.phantom.theme.PhantomFontStyle.TitleMedium
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.TextData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class FilterSheetData(
    @Json(name = "property_ui_sections")
    val propertyUiSections: List<FilterPropertyUiSection>? = null
) : SnippetData() {

    override fun setDefaults() {
        propertyUiSections?.forEach { it.setDefaults() }
    }
}

fun FilterSheetData?.getSelectedPropertyValueIds(): Set<Int> {
    val set = hashSetOf<Int>()
    this?.propertyUiSections?.forEach { propertyUiSection ->
        propertyUiSection.propertyValues?.forEach { propertyValueData ->
            if (propertyValueData.selected == true && propertyValueData.id != null) {
                set.add(propertyValueData.id)
            }
        }
    }
    return set
}

@JsonClass(generateAdapter = true)
class FilterPropertyUiSection(
    @Json(name = "name")
    val name: TextData? = null,

    @Json(name = "property_values")
    val propertyValues: List<FilterPropertyValueData>? = null
) : SnippetData() {
    override fun setDefaults() {
        name?.setDefaults(fontStyle = TitleMedium)
        propertyValues?.forEach { it.setDefaults() }
    }
}

@JsonClass(generateAdapter = true)
class FilterPropertyValueData(
    @Json(name = "id")
    val id: Int? = null,

    @Json(name = "name")
    val name: TextData? = null,

    @Json(name = "selected")
    var selected: Boolean? = null
) : SnippetData() {

    override fun setDefaults() {
        name?.setDefaults(fontStyle = TitleMedium)
    }
}
