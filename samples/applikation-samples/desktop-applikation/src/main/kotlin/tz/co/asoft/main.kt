package tz.co.asoft

import applikation.konfig
import kotlinx.serialization.mapper.Mapper

fun main() {
    val kfg = konfig()
    val json = Mapper { prettyPrint = true }.encodeToString(kfg)
    println("works: $json")
    val link: String by kfg
    println("It works: Link found was $link")
}