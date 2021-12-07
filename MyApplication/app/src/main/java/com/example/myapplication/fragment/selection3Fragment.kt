package com.example.myapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.myapplication.E_count
import com.example.myapplication.I_count
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentSelection3Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Selection3Fragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var navController : NavController

    // id가져오려면 추가해야할 것 들
    private var mBinding: FragmentSelection3Binding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentSelection3Binding.inflate(inflater, container, false)  // binding위해 추가할 것

        return binding.root // 또한 마찬가지
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController= Navigation.findNavController(view)

        binding.option3E.setOnClickListener(this)
        binding.option3I.setOnClickListener(this)
    }

    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SelectionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    // 다른 selectionFragment들과 동일한 기능을 하는 함수
    override fun onClick(v: View?) {

        when(v?.id){
            R.id.option3_e -> {navigateWithIndex('e')}
            R.id.option3_i -> {navigateWithIndex('i')}

        }
    }
}

    fun Selection3Fragment.navigateWithIndex(count: Char){
        val buf : Char = count
        if (buf == 'e'){
            E_count++
        }
        else{
            I_count++
        }
        navController.navigate(R.id.action_selection3Fragment2_to_selection4Fragment)
    }