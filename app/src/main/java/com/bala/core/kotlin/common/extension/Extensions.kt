package com.bala.core.kotlin.common.extension

import java.text.DecimalFormat

/**
 * Define all extensions function here
 * One example is given below
 */

fun Int?.numberFormat(): String {
    return DecimalFormat("#,###,###").format(this)
}