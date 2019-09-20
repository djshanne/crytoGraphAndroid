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
                var value = 0
                for (x in it.values) {
                    values.add(Value(x.x, x.y))
//                    if (value == 4)
//                        break
//                    value += 1
                }
                ChartDataModel(values)
            }
    }
}