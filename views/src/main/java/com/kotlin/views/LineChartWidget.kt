package com.kotlin.views

import android.content.Context
import android.graphics.Color
import android.graphics.DashPathEffect
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IFillFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.Utils
import com.kotlin.views.models.LineChartViewModel
import kotlinx.android.synthetic.main.line_chart_widget.view.*

class LineChartWidget : FrameLayout {


    constructor(context: Context) : super(context) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context)
    }

    private fun initView(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.line_chart_widget, this)
        lineChart.setBackgroundColor(Color.WHITE)
        val l = lineChart.legend
        l.form = Legend.LegendForm.LINE
    }


    fun setData(model: LineChartViewModel) {

        val values = ArrayList<Entry>()

//        for (i in model.values)
//            values.add(
//                Entry(
//                    i.x, i.y,
//                    resources.getDrawable(R.drawable.star)
//                )
//            )

        /*for (x in 0 until 10) {
            values.add(Entry(
                x.toFloat(), (Math.random() * 10).toFloat() - 30,
                resources.getDrawable(R.drawable.star))
            )
        }*/

        for (i in 0 until 10)
            values.add(
                Entry(
                    x, (Math.random() * 100).toFloat() - 30,
                    resources.getDrawable(R.drawable.star)
                )
            )



        /*values.add(
            Entry(
                1F, 5F,
                resources.getDrawable(R.drawable.star)
            )
        )
        values.add(
            Entry(
                5F, 10F,
                resources.getDrawable(R.drawable.star)
            )
        )*/


        val set1: LineDataSet

        if (lineChart.data != null && lineChart.data.dataSetCount > 0) {
            set1 = lineChart.data.getDataSetByIndex(0) as LineDataSet
            set1.values = values
            set1.notifyDataSetChanged()
            lineChart.data.notifyDataChanged()
            lineChart.notifyDataSetChanged()
        } else {
            // create a dataset and give it a type
            set1 = LineDataSet(values, "DataSet 1")

            set1.setDrawIcons(false)

            // draw dashed line
            set1.enableDashedLine(10f, 5f, 0f)

            // black lines and points
            set1.color = Color.BLACK
            set1.setCircleColor(Color.BLACK)

            // line thickness and point size
            set1.lineWidth = 1f
            set1.circleRadius = 3f

            // draw points as solid circles
            set1.setDrawCircleHole(false)

            // customize legend entry
            set1.formLineWidth = 1f
            set1.formLineDashEffect = DashPathEffect(floatArrayOf(10f, 5f), 0f)
            set1.formSize = 15f

            // text size of values
            set1.valueTextSize = 9f

            // draw selection line as dashed
            set1.enableDashedHighlightLine(10f, 5f, 0f)

            // set the filled area
            set1.setDrawFilled(true)
            set1.fillFormatter =
                IFillFormatter { dataSet, dataProvider -> lineChart.axisLeft.axisMinimum }

            // set color of filled area
            if (Utils.getSDKInt() >= 18) {
                // drawables only supported on api level 18 and above
                val drawable = ContextCompat.getDrawable(context, R.drawable.fade_red)
                set1.fillDrawable = drawable
            } else {
                set1.fillColor = Color.BLACK
            }

            val dataSets = ArrayList<ILineDataSet>()
            dataSets.add(set1) // add the data sets

            // create a data object with the data sets
            val data = LineData(dataSets)

            // set data
            lineChart.data = data
        }


    }

}