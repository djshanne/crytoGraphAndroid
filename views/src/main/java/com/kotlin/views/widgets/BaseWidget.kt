package com.kotlin.views.widgets

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.kotlin.views.widgets.interfaces.BaseWidgetI


abstract class BaseWidget<DATA> : FrameLayout, BaseWidgetI<DATA> {
    constructor(context: Context) : super(context) {
        this.initView(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        this.initView(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        this.initView(context)
    }

    abstract fun initView(context: Context)

}