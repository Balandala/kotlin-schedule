package com.example.schedule.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.example.schedule.R
import com.example.schedule.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.bottomNavigation?.setOnItemSelectedListener {
            changeTab(it.itemId)
            true
        }

    }

    private fun changeTab(@IdRes id: Int) {
        val navHostId = binding?.navHost?.id
        navHostId ?: return
        val transaction = childFragmentManager.beginTransaction()
        when (id) {
            R.id.navigation_today ->
                transaction.replace(navHostId, TodayFragment.newInstance())

            R.id.navigation_schedule ->
                transaction.replace(navHostId, ScheduleFragment.newInstance())
        }
        transaction.commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MainFragment().apply {
            }
    }
}