package tz.co.asoft

import kotlinx.browser.document
import kotlinx.html.dom.append
import kotlinx.html.js.pre

fun main() {
    console.log("Works")
    val konfig = konfig()
    document.getElementById("root")?.append {
        pre { +Mapper { prettyPrint = true }.encodeToString(konfig) }
    }
}