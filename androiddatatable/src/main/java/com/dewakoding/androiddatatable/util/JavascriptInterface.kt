package com.dewakoding.androiddatatable.util

import android.content.Context
import android.util.Log
import android.webkit.JavascriptInterface
import android.widget.Toast
import com.dewakoding.androiddatatable.data.OrderBy
import com.dewakoding.androiddatatable.listener.OnClickListener
import com.google.gson.Gson


/**

Created by
name : Septiawan Aji Pradana
email : septiawanajipradana@gmail.com
website : dewakoding.com

 **/
class JavascriptInterface(
    context: Context,
    column: String,
    data: String,
    isActionButtonShow: Boolean,
    orderBy: OrderBy?,
    onClickListener: OnClickListener
) {
    companion object {
        const val TAG_HANDLER = "Android"
    }
    private var mContext: Context = context
    private var mColumn: String = column
    private var mData: String = data
    private var mIsActionButtonShow: Boolean = isActionButtonShow
    private var mOrderBy: OrderBy? = orderBy
    private var mOnClickListener: OnClickListener = onClickListener

    @JavascriptInterface
    fun getColumn(): String {
        return mColumn
    }

    @JavascriptInterface
    fun getData(): String {
        return mData
    }

    @JavascriptInterface
    fun action(dataStr: String) {
        mOnClickListener.onClick(dataStr)
    }

    @JavascriptInterface
    fun isActionButtonShow(): Boolean {
        return mIsActionButtonShow
    }

    @JavascriptInterface
    fun getOrderBy(): String? {
        var orderByArray = arrayListOf<Any>()
        if (mOrderBy != null) {
            orderByArray.add(mOrderBy!!.columnId)
            orderByArray.add(mOrderBy!!.type)
        }
        val gson = Gson()
        val orderByJson = gson.toJson(orderByArray)
        return orderByJson
    }
}