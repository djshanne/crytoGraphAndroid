package com.kotlin.views.widgets

import android.content.Context
import android.graphics.Color
import android.graphics.DashPathEffect
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IFillFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.Utils
import com.kotlin.views.R
import com.kotlin.views.models.LineChartViewModel
import kotlinx.android.synthetic.main.line_chart_widget.view.*

class LineChartWidget : BaseWidget<LineChartViewModel> {


    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun initView(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.line_chart_widget, this)
        lineChartWidgetLineChart.setBackgroundColor(Color.WHITE)
        val l = lineChartWidgetLineChart.legend
        l.form = Legend.LegendForm.LINE
    }

    override fun setData(data: LineChartViewModel) {
        val values = ArrayList<Entry>()
        for (i in data.valuesList)
            values.add(
                Entry(
                    i.x, i.y,
                    null
                )
            )
        val set1: LineDataSet

        if (lineChartWidgetLineChart.data != null && lineChartWidgetLineChart.data.dataSetCount > 0) {
            set1 = lineChartWidgetLineChart.data.getDataSetByIndex(0) as LineDataSet
            set1.values = values
            set1.notifyDataSetChanged()
            lineChartWidgetLineChart.data.notifyDataChanged()
            lineChartWidgetLineChart.notifyDataSetChanged()
        } else {
            // create a dataset and give it a type
            set1 = LineDataSet(values, data.name)

            set1.setDrawIcons(false)

            // black lines and points
            set1.color = Color.BLACK
            set1.setCircleColor(Color.TRANSPARENT)

            // line thickness and point size
            set1.lineWidth = 0.5f
            set1.circleRadius = 0.0f

            // draw points as solid circles
            set1.setDrawCircleHole(false)

            // customize legend entry
            set1.formLineWidth = 1f
            set1.formLineDashEffect = DashPathEffect(floatArrayOf(10f, 5f), 0f)
            set1.formSize = 15f

            // text size of valuesList
            set1.valueTextSize = 9f

            // set the filled area
            set1.setDrawFilled(true)
            set1.fillFormatter =
                IFillFormatter { _, _ -> lineChartWidgetLineChart.axisLeft.axisMinimum }


            // set color of filled area
            if (Utils.getSDKInt() >= 18) {
                // drawables only supported on api level 18 and above
                val drawable = ContextCompat.getDrawable(context, R.drawable.fade)
                set1.fillDrawable = drawable
            } else {
                set1.fillColor = Color.BLACK
            }

            val dataSets = ArrayList<ILineDataSet>()
            dataSets.add(set1) // add the data sets

            // create a data object with the data sets
            val data = LineData(dataSets)

            // set data
            lineChartWidgetLineChart.data = data
        }

        lineChartWidgetLineChart.invalidate()

    }


}