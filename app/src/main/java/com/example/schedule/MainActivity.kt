package com.example.schedule

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.schedule.databinding.ActivityMainBinding
import com.example.schedule.presenter.MainFragment

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentRootLayout.id, MainFragment.newInstance())
            .commit()
    }
}