package com.kotlin.domain

import com.kotlin.domain.components.DaggerDomainComponent
import com.kotlin.domain.models.ChartDataModel
import com.kotlin.domain.models.Value
import com.kotlin.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject

class ChartDataHandler {
    @Inject
    lateinit var repository: Repository

    init {
        DaggerDomainComponent.create().inject(this)
    }

    fun fetchData(): Observable<ChartDataModel> {
        return repository.getGraph()!!.map {
            val values = ArrayList<Value>()
            for (x in it.values)
                values.add(Value(x.x, x.y))
            ChartDataModel(values, it.name)
        }
    }
}