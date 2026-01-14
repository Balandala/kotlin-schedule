package com.example.schedule.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.schedule.data.DayItem
import com.example.schedule.data.MyItem
import com.example.schedule.data.SubjectItem
import com.example.schedule.databinding.DayLabelBinding
import com.example.schedule.databinding.SubjectEntryBinding

class DaySubjectAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val HEADER_VIEW: Int = 1
        const val ITEM_VIEW: Int = 2
    }
    private val flatList: MutableList<MyItem> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        when (viewType) {
            HEADER_VIEW -> {
                val binding = DayLabelBinding.inflate(inflater, parent, false)
                return DayViewHolder(binding)
            }

            ITEM_VIEW -> {
                val binding = SubjectEntryBinding.inflate(inflater, parent, false)
                return SubjectViewHolder(binding)
            }
        }
        throw IllegalArgumentException("Invalid viewType: $viewType")
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        try{
            when(holder){
                is DayViewHolder -> {
                    holder.bind(flatList[position] as DayItem)
                }
                is SubjectViewHolder -> {
                    holder.bind(flatList[position] as SubjectItem)
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = flatList[position]
        when(item){
            is DayItem -> {
                return HEADER_VIEW
            }
        }
        when(item){
            is SubjectItem -> {
                return ITEM_VIEW
            }
        }
        throw IllegalStateException("Invalid item in flatData: $item")
    }

    override fun getItemCount(): Int {
        return flatList.size
    }

    fun submitList(list: List<DayItem>) {
        for (day in list){
            flatList.add(day)
            for (subject in day.subjectList){
                flatList.add(subject)
            }
        }
    }


    class SubjectViewHolder(
        private val binding: SubjectEntryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SubjectItem){
            with(binding){
                subjectNum.text = item.subjectNum.toString()
                subjectStartTime.text = item.startTime
                subjectEndTime.text = item.endTime
                subjectName.text = item.name
                subjectClassroom.text = item.name
                subjectTeacher.text = item.teacher
            }
        }
    }

    class DayViewHolder(
        private val binding: DayLabelBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind (item: DayItem){
            with(binding){
                dayOfWeek.text = item.dayOfWeek.toString()
                weekLabel.text = item.week.toString()
            }
        }
    }
}

