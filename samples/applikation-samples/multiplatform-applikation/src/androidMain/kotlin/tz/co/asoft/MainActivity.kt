package tz.co.asoft

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import tz.co.asoft.konfig.sample.R

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        val text = findViewById<TextView>(R.id.text)
        try {
            val kfg = konfig()
            val json = Mapper { prettyPrint = true }.encodeToString(kfg)
            println("Works")
            val name: String by kfg
            text.text = "${name.capitalize()} Konfig $name\n\n\n$json"
        } catch (e: Throwable) {
            text.text = "${e.message}\n\n${e.cause?.message}\n\n${e.stackTraceToString()}"
        }
    }
}