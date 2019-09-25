package com.kotlin.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import kotlinx.android.synthetic.main.error_generic_widget.view.*

class GenericErrorWidget : BaseWidget<String> {


    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun initView(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.error_generic_widget, this)
    }


    override fun setData(data: String) {
        errorGenericWidgetMsg.text = data
    }
}