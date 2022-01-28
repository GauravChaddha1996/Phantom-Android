package com.project.phantom.screens.category.models

import com.project.phantom.theme.color.PhantomColor
import com.project.phantom.theme.font.PhantomTextStyle
import com.project.phantom.ui.snippets.commons.SnippetData
import com.project.phantom.ui.text.TextData
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class FilterSheetData(
    @Json(name = "property_ui_sections")
    val propertySections: List<FilterPropertySection>? = null
) : SnippetData() {

    override fun setDefaults() {
        propertySections?.forEach { it.setDefaults() }
    }
}

fun FilterSheetData?.getSelectedFilters(): Set<Int> {
    val set = hashSetOf<Int>()
    this?.propertySections?.forEach { propertyUiSection ->
        propertyUiSection.pills?.forEach { propertyValueData ->
            if (propertyValueData.selected == true && propertyValueData.id != null) {
                set.add(propertyValueData.id)
            }
        }
    }
    return set
}

@JsonClass(generateAdapter = true)
class FilterPropertySection(
    @Json(name = "name")
    val name: TextData? = null,

    @Json(name = "property_values")
    val pills: List<FilterPillData>? = null
) : SnippetData() {
    override fun setDefaults() {
        name?.setDefaults(
            textStyle = PhantomTextStyle.TitleMedium,
            color = PhantomColor.OnPrimaryContainer
        )
        pills?.forEach { it.setDefaults() }
    }
}

@JsonClass(generateAdapter = true)
class FilterPillData(
    @Json(name = "id")
    val id: Int? = null,

    @Json(name = "name")
    val name: TextData? = null,

    @Json(name = "selected")
    var selected: Boolean? = null
) : SnippetData() {

    override fun setDefaults() {
        name?.setDefaults(textStyle = PhantomTextStyle.TitleMedium)
    }
}
