package com.example.myapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.*
import com.example.myapplication.databinding.FragmentViewPagerBinding
import com.example.myapplication.MainActivity.Companion.E_count
import com.example.myapplication.MainActivity.Companion.F_count
import com.example.myapplication.MainActivity.Companion.I_count
import com.example.myapplication.MainActivity.Companion.J_count
import com.example.myapplication.MainActivity.Companion.N_count
import com.example.myapplication.MainActivity.Companion.P_count
import com.example.myapplication.MainActivity.Companion.S_count
import com.example.myapplication.MainActivity.Companion.T_count


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ViewPagerFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    lateinit var navController: NavController

    private var mBinding: FragmentViewPagerBinding? = null
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
    ): View? {
        mBinding = FragmentViewPagerBinding.inflate(inflater, container, false)  // binding위해 추가할 것

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Adapter를 생성하면서 넘길 색상이 담긴 ArrayList 생성
        var texts = arrayListOf<String>(
            "나는 남들과 대화할 때",
            "나는 직장이나 단체에서",
            "나는 스트레스를 받았을 때",
            "4", "5", "6", "7", "8", "9", "10", "11", "12"
        )
        var option1 = arrayListOf<String>(
            "화제를 이것저것 바꾸며 말한다",
            "대화를 주도한다",
            "친한 사람들과 만나 떠들며 놀고 싶어한다",
            "4", "5", "6", "7", "8", "9", "10", "11", "12"
        )
        var option2 = arrayListOf<String>(
            "한 번에 한 가지 주제로 말한다",
            "남이 먼저 말하기를 기다린다",
            "혼자서 좋아하는 것에 몰입한다",
            "4", "5", "6", "7", "8", "9", "10", "11", "12"
        )
        /*binding.viewPager.run { isUserInputEnabled = false } // 슬라이드 방지*/
        // RecyclerView.Adapter<ViewHolder>()
        binding.viewPager.adapter = PagerRecyclerAdapter(texts, option1, option2)
        // ViewPager의 Paging 방향은 Horizontal
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.option1.setOnClickListener {
                    firstBtn(position)
                }
                binding.option2.setOnClickListener {
                    secondBtn(position)
                }
            }
        })
    }

    private fun firstBtn(index: Int) {
        if (index <= 2) {
            E_count++
        }
        else if(index<=5){
            S_count++
        }
        else if(index<=8){
            T_count++
        }
        else if(index<=11){
            J_count++
            if(index == 11){
                navController.navigate(R.id.action_viewPagerFragment_to_resultFragment)
            }
        }
        binding.viewPager.setCurrentItem(index + 1, true)
    }

    private fun secondBtn(index2: Int) {
        if (index2 <= 2) {
            I_count++
        }
        else if(index2<=5){
            N_count++
        }
        else if(index2<=8){
           F_count++
        }
        else if(index2<=11){
            P_count++
            if(index2 == 11){
                navController.navigate(R.id.action_viewPagerFragment_to_resultFragment)
            }
        }
        binding.viewPager.setCurrentItem(index2 + 1, true)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ViewPagerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ViewPagerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
