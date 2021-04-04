package applikation

import android.content.Context
import kotlinx.serialization.mapper.Mapper
import kotlinx.serialization.mapper.WrappedMap

fun Context.konfig(): WrappedMap = Mapper.decodeFromString(
    assets.open(KONFIG_JSON_FILE).bufferedReader().readText()
)