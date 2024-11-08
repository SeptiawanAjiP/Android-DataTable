package com.dewakoding.androiddatatable.util

import android.content.Context
import android.util.Log
import android.webkit.JavascriptInterface
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
    pageLength: Int?,
    isSearchingEnable: Boolean?,
    isLengthChange: Boolean?,
    onClickListener: OnClickListener
) {
    companion object {
        const val TAG_HANDLER = "Android"
    }
    private var mColumn: String = column
    private var mData: String = data
    private var mIsActionButtonShow: Boolean = isActionButtonShow
    private var mOrderBy: OrderBy? = orderBy
    private var mPageLength: Int? = pageLength
    private var mIsSearchingEnable: Boolean? = isSearchingEnable
    private var mIsLengthChange: Boolean? = isLengthChange
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
        return gson.toJson(orderByArray)
    }

   @JavascriptInterface
    fun getPageLength(): String? {
        return mPageLength.toString()
    }

    @JavascriptInterface
    fun isSearchingEnable(): String? {
        return mIsSearchingEnable.toString()
    }

    @JavascriptInterface
    fun isLengthChange(): String? {
        return mIsLengthChange.toString()
    }
}