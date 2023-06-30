package com.example.uinsukaui.ui.home.home

import androidx.lifecycle.ViewModel
import com.example.uinsukaui.data.model.News

class HomeViewModel : ViewModel() {
    private val news = News(
        date = "24 October 2021 16:15",
        headline = "Punya Rumah Sendiri Sebelum Usia 30 Tahun, Bisa Nggak Ya?",
        "https://akcdn.detik.net.id/visual/2018/01/04/b44f9510-6905-42d9-8193-cf1e6b9532f1_169.jpeg?w=715&q=90"
    );

    private val listNews = arrayListOf(news, news, news, news)

    fun get() = listNews
}