package tz.co.asoft

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import tz.co.asoft.konfig.sample.R
import applikation.konfig
import kotlinx.serialization.mapper.Mapper

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        val text = findViewById<TextView>(R.id.text)
        val kfg = konfig()
        val json = Mapper { prettyPrint = true }.encodeToString(kfg)

        val change: Int by kfg
        text.text = "$json\n\nChange: $change"
    }
}