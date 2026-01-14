package com.example.schedule.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schedule.data.ScheduleProvider
import com.example.schedule.databinding.FragmentScheduleBinding
import com.example.schedule.presenter.adapter.DaySubjectAdapter

class ScheduleFragment : Fragment() {

    private var binding: FragmentScheduleBinding? = null
    private var adapter: DaySubjectAdapter = DaySubjectAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding?.scheduleRecycler) {
            this ?: return
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ScheduleFragment.adapter
        }
        adapter.submitList(ScheduleProvider.firstWeekSchedule)
        adapter.notifyDataSetChanged()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScheduleBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ScheduleFragment().apply {

            }
    }
}