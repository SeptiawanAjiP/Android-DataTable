package com.dewakoding.androiddatatable

import android.content.Context
import android.widget.LinearLayout


/**

Created by
name : Septiawan Aji Pradana
email : septiawanajipradana@gmail.com
website : dewakoding.com

 **/
import android.util.AttributeSet
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import com.dewakoding.androiddatatable.data.Column
import com.dewakoding.androiddatatable.data.OrderBy
import com.dewakoding.androiddatatable.listener.OnWebViewComponentClickListener
import com.dewakoding.androiddatatable.util.JavascriptInterface
import com.google.gson.Gson


open class DataTableView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : LinearLayout(context, attrs, defStyle) {
    private val webView: WebView
    internal var jsi: JavascriptInterface? = null
    private var clickListener: OnWebViewComponentClickListener? = null

    init {
        orientation = VERTICAL
        webView = WebView(context)
    }

    fun setTable(columns: ArrayList<Column>, listData: List<Any>, isActionButtonShow: Boolean = false, orderBy: OrderBy? = null) {
        jsi = JavascriptInterface(getContext(), Gson().toJson(columns), Gson().toJson(listData), isActionButtonShow, orderBy, object: com.dewakoding.androiddatatable.listener.OnClickListener {
            override fun onClick(str: String) {
                onRowButtonClicked(str)
            }
        })
        val webSettings: WebSettings = webView.getSettings()
        webSettings.javaScriptEnabled = true
        webView.addJavascriptInterface(jsi!!, JavascriptInterface.TAG_HANDLER)
        webView.setWebChromeClient(WebChromeClient())
        webView.loadUrl("file:///android_asset/index.html")
        addView(webView)
    }

    fun setOnClickListener(listener: OnWebViewComponentClickListener) {
        clickListener = listener
    }

    fun onRowButtonClicked(dataStr: String) {
        clickListener?.onRowClicked(dataStr)
    }
}
