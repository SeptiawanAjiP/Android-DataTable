package com.dewakoding.androiddatatable

import android.R
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import androidx.appcompat.app.AppCompatActivity
import com.dewakoding.androiddatatable.databinding.ActivityDataTableBinding


/**

Created by
name : Septiawan Aji Pradana
email : septiawanajipradana@gmail.com
website : dewakoding.com

 **/
open class DataTableActivity: AppCompatActivity() {

    private val binding by lazy { ActivityDataTableBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val webSettings: WebSettings = binding.webView.getSettings()
        webSettings.javaScriptEnabled = true

        binding.webView.setWebChromeClient(WebChromeClient())
        binding.webView.loadUrl("file:///android_asset/index.html")
    }

}