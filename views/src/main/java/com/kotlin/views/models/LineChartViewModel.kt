package com.kotlin.views.models

import androidx.lifecycle.ViewModel

class LineChartViewModel(
    var valuesList: ArrayList<Value> = ArrayList(),
    var name: String = ""
) :
    ViewModel() {


    fun isEmpty(): Boolean {
        return valuesList.isEmpty() && name.isBlank()
    }
}
