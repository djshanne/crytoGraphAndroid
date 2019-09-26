package com.catalog.playground

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.views.models.LineChartViewModel
import com.kotlin.views.models.Value
import com.kotlin.views.widgets.LineChartWidget
import com.kotlin.views.widgets.RefreshButtonWidget
import kotlinx.android.synthetic.main.playground_activity_main.*

class PlaygroundActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.playground_activity_main)
        activityMainContainer.addView(getView())
        activityMainContainer.addView(getSeparator())
        activityMainContainer.addView(RefreshButtonWidget(this).apply {
            setOnButtonClickListener(View.OnClickListener {
                Toast.makeText(
                    context,
                    "onClick",
                    Toast.LENGTH_SHORT
                ).show()
            })
        })
        activityMainContainer.addView(getSeparator())
    }

    private fun getView(): View {
        val view = LineChartWidget(this)
        val v = arrayListOf(Value(0F, 0F), Value(10F, 10F))
        view.setData(LineChartViewModel(valuesList = v, name = "mockData"))
        return view
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun getSeparator(): View {
        val view = View(this)
        view.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            4
        )
        view.setBackgroundColor(getColor(android.R.color.holo_blue_light))
        return view
    }
}
