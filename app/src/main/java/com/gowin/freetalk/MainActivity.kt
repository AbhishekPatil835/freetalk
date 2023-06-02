package com.gowin.freetalk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.viewbinding.ViewBinding
import com.bookmyshow.multiverseofmovies.utils.viewBinding
import com.gowin.freetalk.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val viewModel by viewModels<MainViewModel>()
    private val binding by viewBinding(ActivityMainBinding::inflate)
    private fun <T : ViewBinding> initBinding(binding: T): View {
        return with(binding) {
            root
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initBinding(binding))
        setupView()

    }

    private fun setupView() {
        val url = viewModel.getImage()
    }
}