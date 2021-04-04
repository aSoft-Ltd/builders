package applikation

import kotlinx.serialization.mapper.Mapper
import kotlinx.serialization.mapper.WrappedMap

fun konfig(): WrappedMap {
    val error = Throwable("Can't locate $KONFIG_JSON_FILE")
    val classLoader = ClassLoader.getSystemClassLoader()
    val stream = classLoader.getResourceAsStream(KONFIG_JSON_FILE) ?: throw error
    return Mapper.decodeFromString(stream.bufferedReader().readText())
}