package cn.qiiyue.autotextgroup

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.ViewGroup

/**
 * @Created by qiiyue
 * @Time 2018/5/28 18:08
 *
 * 自定义的group，可以添加TextView并自动换行
 */
class MyTextViewGroup(context: Context, attributeSet: AttributeSet) : ViewGroup(context, attributeSet) {

    val marginWidth = 20//textview外边距
    val marginHeight = 10//textview外边距
    val paddingSide = 50
    var paddingHo = 10
    var paddingVer = 5

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        var childCount = childCount
        var x = 0//x坐标，初始值为第一个textview左边距
        var y: Int//y坐标，初始值为0
        var rowIndex = 1//第几行
        var autualWidth = r - l//真实宽度，右边-左边

        for (i in 0 until childCount) {
            var view = getChildAt(i)
            var width = view.measuredWidth
            var height = view.measuredHeight

            x += width + marginWidth
            if (x > autualWidth) {
                x = width + paddingSide
                rowIndex++
            }

            y = rowIndex * (height + marginHeight)
            Log.d("test", "onLayout: $y")

            if (i == 0) {
                view.layout(x - width - marginWidth + paddingSide, y - height, x - marginWidth + paddingSide, y)
            } else {
                view.layout(x - width, y - height, x, y)
            }

        }


    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var childCount = childCount
        var autualWidth = MeasureSpec.getSize(widthMeasureSpec) - paddingSide * 2
        var x = 0
        var y = 0
        var rows = 1
        for (i in 0 until childCount) {
            var view = getChildAt(i)
            view.setPadding(paddingHo, paddingVer, paddingHo, paddingVer)
            view.setBackgroundColor(Color.BLUE)
            view.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED)

            var width = view.measuredWidth
            var height = view.measuredHeight
            x += width + marginWidth

            if (x > autualWidth) {
                x = width + paddingSide
                rows++
            }

            y = rows * (height + marginHeight)
        }

        Log.d("test", "onMeasure: $autualWidth, $y")

        setMeasuredDimension(autualWidth, y)
    }

}
