package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PagerRecyclerAdapter(private val questions: ArrayList<String>, private val option1 : ArrayList<String>, private val option2 :ArrayList<String>)
    : RecyclerView.Adapter<PagerRecyclerAdapter.PagerViewHolder>() {


    // id가져와서 연결하고 내용 변경
    inner class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val question_number: TextView = itemView.findViewById(R.id.question_number)
        private val question_text: TextView = itemView.findViewById(R.id.question_text)
        private val option_1: TextView = itemView.findViewById(R.id.option_1)
        private val option_2: TextView = itemView.findViewById(R.id.option_2)

        fun bind(position: Int) {
            question_number.text = "Q${position + 1}"
            question_text.text = questions[position]
            option_1.text = option1[position]
            option_2.text = option2[position]
        }
    }
    // (1) 아이템 레이아웃과 결합
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerRecyclerAdapter.PagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.items,
            parent,
            false
        )
        return PagerViewHolder(view)
    }
    // (2) View에 내용 입력
    override fun onBindViewHolder(holder: PagerRecyclerAdapter.PagerViewHolder, position: Int) {
        holder.bind(position)
    }

    // (3) 아이템 개수
    override fun getItemCount(): Int = questions.size
}


