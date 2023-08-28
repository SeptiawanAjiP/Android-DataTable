package com.dewakoding.androiddatatable

import android.os.Bundle
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import androidx.appcompat.app.AppCompatActivity
import com.dewakoding.androiddatatable.data.Column
import com.dewakoding.androiddatatable.databinding.ActivityDataTableBinding
import com.dewakoding.androiddatatable.listener.OnClickListener
import com.dewakoding.androiddatatable.util.JavascriptInterface
import com.google.gson.Gson


/**

Created by
name : Septiawan Aji Pradana
email : septiawanajipradana@gmail.com
website : dewakoding.com

 **/
open class DataTableActivity: AppCompatActivity() {

    private val binding by lazy { ActivityDataTableBinding.inflate(layoutInflater) }
    internal var jsi: JavascriptInterface? = null
    private lateinit var mListColumns: List<Column>
    private lateinit var mListData: List<Any>
    private var mIsActionButtonShow: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun initData(
        listColumns: List<Column>,
        listData: List<Any>,
        isActionButtonShow: Boolean
    ) {
        this.mListColumns = listColumns
        this.mListData = listData
        this.mIsActionButtonShow = isActionButtonShow
        initView()
    }

    private fun initView() {
        jsi = JavascriptInterface(applicationContext, Gson().toJson(mListColumns), Gson().toJson(mListData), mIsActionButtonShow, object: OnClickListener {
            override fun onClick(str: String) {

                onRowClicked(str)
            }

        })
        val webSettings: WebSettings = binding.webView.getSettings()
        webSettings.javaScriptEnabled = true
        binding.webView.addJavascriptInterface(jsi!!, JavascriptInterface.TAG_HANDLER)

        binding.webView.setWebChromeClient(WebChromeClient())
        binding.webView.loadUrl("file:///android_asset/index.html")
    }

    open fun onRowClicked(dataStr: String) {

    }

}