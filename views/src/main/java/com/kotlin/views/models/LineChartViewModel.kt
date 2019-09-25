package com.kotlin.views.models

import androidx.lifecycle.ViewModel

class LineChartViewModel(
    var values: ArrayList<Value> = ArrayList(),
    var name: String = ""
) :
    ViewModel() {


    fun isEmpty(): Boolean {
        return values.isEmpty() && name.isBlank()
    }
}
