package com.catalog.playground

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.views.models.LineChartViewModel
import com.kotlin.views.models.Value
import com.kotlin.views.widgets.LineChartWidget
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityMainContainer.addView(getView())
    }

    private fun getView(): View {
        val view = LineChartWidget(this)
        val v = arrayListOf(Value(0F, 0F), Value(10F, 10F))
        view.setData(LineChartViewModel(values = v, name = "mockData"))
        return view
    }
}
