package com.example.myapplication.fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavController
import com.example.myapplication.databinding.FragmentDialogBinding
import kotlin.system.exitProcess

class DialogFragment : DialogFragment() {
    private var _binding: FragmentDialogBinding? = null
    private val binding get() = _binding!!
    lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDialogBinding.inflate(inflater, container, false)
        val view = binding.root
        // 레이아웃 배경을 투명하게 해줌
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        binding.dialBtn1.setOnClickListener {
            activity?.finish()
            System.runFinalization()
            exitProcess(0)// 종료
        }
        binding.dialBtn2.setOnClickListener {
            dismiss() // 대화상자를 닫는 함수
        }
        return view
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}