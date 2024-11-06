package com.dewakoding.androiddatatable

import android.content.Context
import android.net.Uri
import android.widget.LinearLayout


/**

Created by
name : Septiawan Aji Pradana
email : septiawanajipradana@gmail.com
website : dewakoding.com

 **/
import android.util.AttributeSet
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.dewakoding.androiddatatable.data.Column
import com.dewakoding.androiddatatable.data.OrderBy
import com.dewakoding.androiddatatable.listener.OnWebViewComponentClickListener
import com.dewakoding.androiddatatable.util.JavascriptInterface
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader


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

    fun setTable(columns: ArrayList<Column>, listData: List<Any>, isActionButtonShow: Boolean = false, orderBy: OrderBy? = null, pageLength: Int? = 10, isSearchingEnable: Boolean? = true, isLengthChange: Boolean? = true) {
        jsi = JavascriptInterface(getContext(), Gson().toJson(columns), Gson().toJson(listData), isActionButtonShow, orderBy, pageLength, isSearchingEnable, isLengthChange, object: com.dewakoding.androiddatatable.listener.OnClickListener {
            override fun onClick(str: String) {
                onRowButtonClicked(str)
            }
        })
        webView.addJavascriptInterface(jsi!!, JavascriptInterface.TAG_HANDLER)
        webView.setWebChromeClient(WebChromeClient())
        webView.settings.javaScriptEnabled = true

        val rawResourceId = R.raw.datatable2023
        val inputStream = resources.openRawResource(rawResourceId)
        val htmlData = convertStreamToString(inputStream)
        val baseUrl = "file:///android_res/raw/"
        val dataUri = Uri.parse(baseUrl + rawResourceId)

        webView.loadDataWithBaseURL(baseUrl, htmlData, "text/html", "UTF-8", null)

        addView(webView)
    }

    private fun convertStreamToString(inputStream: InputStream): String {
        val reader = BufferedReader(InputStreamReader(inputStream))
        val stringBuilder = StringBuilder()
        var line: String?
        try {
            while (reader.readLine().also { line = it } != null) {
                stringBuilder.append(line).append("\n")
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                inputStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return stringBuilder.toString()
    }

    fun setOnClickListener(listener: OnWebViewComponentClickListener) {
        clickListener = listener
    }

    fun onRowButtonClicked(dataStr: String) {
        clickListener?.onRowClicked(dataStr)
    }
}
