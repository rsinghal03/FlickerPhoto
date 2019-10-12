package com.example.flickerphotos.ui

import androidx.fragment.app.Fragment
import com.example.flickerphotos.extension.gone
import com.example.flickerphotos.extension.visible
import kotlinx.android.synthetic.main.progress_bar.*

abstract class BaseFragment : Fragment(), BaseContract.BaseView{

    override fun showLoading() {
        progress_bar_id.visible()
    }

    override fun hideLoading() {
        progress_bar_id.gone()
    }
}