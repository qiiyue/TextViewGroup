package cn.qiiyue.autotextgroup

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewGroup = findViewById<MyTextViewGroup>(R.id.content)

        var titles = arrayOf("科比历史第一人", "哇喔，五枚总冠军戒指", "两座FMVP", "一日紫金", "终身湖人", "征战20载", "to be no.1", "mamba out")

        for (i in titles) {
            var textView = TextView(this)
            textView.text = i
            viewGroup.addView(textView)
            Log.d("test", "i---: ${titles.indexOf(i)}, --$i")
        }

    }
}
