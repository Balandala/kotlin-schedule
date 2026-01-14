package com.example.schedule.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schedule.data.ScheduleProvider
import com.example.schedule.databinding.FragmentScheduleBinding
import com.example.schedule.databinding.FragmentTodayBinding
import com.example.schedule.presenter.adapter.DaySubjectAdapter

class TodayFragment : Fragment() {

    private var binding: FragmentTodayBinding? = null
    private var adapter: DaySubjectAdapter = DaySubjectAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding?.todayRecycler) {
            this ?: return
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@TodayFragment.adapter
        }
        adapter.submitList(ScheduleProvider.getTodaySchedule(ScheduleProvider.firstWeekSchedule))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodayBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            TodayFragment().apply {

            }
    }
}