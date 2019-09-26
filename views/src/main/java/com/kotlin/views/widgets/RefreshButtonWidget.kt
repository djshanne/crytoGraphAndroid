package com.kotlin.views.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.kotlin.views.R
import kotlinx.android.synthetic.main.refresh_widget.view.*

class RefreshButtonWidget : BaseWidget<Void> {


    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun initView(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.refresh_widget, this)
    }


    override fun setData(data: Void) {

    }

    fun setOnButtonClickListener(onClickListener: OnClickListener) {
        refreshWidgetButton.setOnClickListener(onClickListener)
    }
}