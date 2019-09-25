package com.kotlin.views

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

abstract class BaseWidget<DATA> : FrameLayout {
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
    abstract fun setData(data: DATA)
}