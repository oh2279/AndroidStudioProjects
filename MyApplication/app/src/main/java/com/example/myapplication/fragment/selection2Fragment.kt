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
import com.example.myapplication.databinding.FragmentSelection2Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



/**
 * A simple [Fragment] subclass.
 * Use the [SelectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class Selection2Fragment : Fragment(), View.OnClickListener {


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var navController : NavController

    // id가져오려면 추가해야할 것 들
    private var mBinding: FragmentSelection2Binding? = null
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
        mBinding = FragmentSelection2Binding.inflate(inflater, container, false)  // binding위해 추가할 것

        return binding.root // 또한 마찬가지
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController= Navigation.findNavController(view)

        binding.option2E.setOnClickListener(this)
        binding.option2I.setOnClickListener(this)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SelectionFragment.
         */
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
    // 어떤 view가 클릭 됐을 때 실행되는 함수
    override fun onClick(v: View?) {
        // 클릭된 것들(view)의 id가 null이 아니면
        // navigateWithIndex함수 실행(파라미터도 같이 넘겨주면서)
        when(v?.id){
            R.id.option2_e -> {navigateWithIndex('e')}
            R.id.option2_i -> {navigateWithIndex('i')}
        }
    }
}
    // selection2의 navigateWithIndex함수
    fun Selection2Fragment.navigateWithIndex(count: Char){
            val buf : Char = count
            if (buf == 'e'){
                E_count++
            }
            else {
                I_count++
            }
            navController.navigate(R.id.action_selection2Fragment2_to_selection3Fragment2)
    }