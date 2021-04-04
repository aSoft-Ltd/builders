package tz.co.asoft

import kotlinx.browser.document
import react.RBuilder
import react.dom.h3
import react.dom.render
import styled.styledH1
import tz.co.asoft.ticker.JsView
import tz.co.asoft.ticker.Ticker
import kotlin.js.json
import applikation.konfig
import kotlinx.serialization.mapper.Mapper

fun main() {
    console.log("Works")
    val kfg = konfig()
    console.log(json(*kfg.map { (k, v) -> k to v }.toTypedArray()))
    try {
        val authors: Map<String, String> by kfg
        console.log(json(*authors.map { (k, v) -> k to v }.toTypedArray()))
    } catch (e: Throwable) {
        console.log("No architectures")
    }
    val link: String by kfg
    println("It works with reload: Link found was ${link.capitalize()}")

    render(document.getElementById("root")) {
        val json = Mapper { prettyPrint = true }.encodeToString(kfg)
        styledH1 { +json }
        User("Juma")
        User("Peter")
        User("Andrew")
        Counter(startAt = 5)
        Ticker(1, 0)
        Ticker(-1, 10)
    }
}

@JsView
private fun RBuilder.User(name: String) = h3 { +"User: $name" }