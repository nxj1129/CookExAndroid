package com.example.jugovac_finalproject.extensions

import android.app.Activity
import android.content.Intent
import android.os.Parcelable
import kotlin.reflect.KClass

fun Activity.start(activityClass: KClass<out Activity>, extras: Map<String, Any?>? = null) {
    val intent = Intent(this, activityClass.java)
    extras?.forEach { intent.setExtra(it.key, it.value) }
    startActivity(intent)
}

fun Intent.setExtra(key: String, value: Any?) {
    when (value) {
        is String -> putExtra(key, value)
        is Double -> putExtra(key, value)
        is Int -> putExtra(key, value)
        is Boolean -> putExtra(key, value)
        is Parcelable -> putExtra(key, value)
    }
}