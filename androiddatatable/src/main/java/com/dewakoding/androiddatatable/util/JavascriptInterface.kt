package com.dewakoding.androiddatatable.util

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast


/**

Created by
name : Septiawan Aji Pradana
email : septiawanajipradana@gmail.com
website : dewakoding.com

 **/
class JavascriptInterface(
    context: Context,
    column: String,
    data: String
) {
    companion object {
        const val TAG_HANDLER = "Android"
    }
    private var mContext: Context = context
    private var mColumn: String = column
    private var mData: String = data

    @JavascriptInterface
    fun getColumn(): String {
        return mColumn
    }

    @JavascriptInterface
    fun getData(): String {
        return mData
    }

    @JavascriptInterface
    fun showToast() {
        Toast.makeText(mContext, "ini Toas", Toast.LENGTH_SHORT).show()
    }
}