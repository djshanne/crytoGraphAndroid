package com.kotlin.domain

import com.kotlin.domain.models.ChartDataModel
import com.kotlin.domain.models.Value
import com.kotlin.repository.RepositoryImpl
import io.reactivex.Observable

class ChartDataHandler {
    private val repository = RepositoryImpl()
    fun fetchData(): Observable<ChartDataModel> {
        return repository.getGraph().map {
            val values = ArrayList<Value>()
            for (x in it.values) {
                values.add(Value(x.x, x.y))
            }
            ChartDataModel(values, it.name)
        }
    }
}