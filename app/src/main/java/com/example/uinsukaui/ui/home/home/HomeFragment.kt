package com.example.uinsukaui.ui.home.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.uinsukaui.R
import com.example.uinsukaui.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        _binding?.apply {
            Glide.with(this@HomeFragment)
                .load("https://rimage.gnst.jp/livejapan.com/public/article/detail/a/00/03/a0003572/img/basic/a0003572_main.jpg?20200427164901&q=80&rw=750&rh=536")
                .into(imgProfile)

            rvNews.apply {
                adapter = NewsAdapter(context, homeViewModel.get())
                layoutManager = LinearLayoutManager(context)
                val dividerItemDecoration =
                    DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
                ContextCompat.getDrawable(context, R.drawable.divider_transparent_10)?.let {
                    dividerItemDecoration.setDrawable(it)
                }
                if (this.itemDecorationCount == 0)
                    addItemDecoration(dividerItemDecoration)
            }
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}