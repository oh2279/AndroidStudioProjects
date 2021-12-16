package com.example.myapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.MainActivity.Companion.E_count
import com.example.myapplication.MainActivity.Companion.F_count
import com.example.myapplication.MainActivity.Companion.I_count
import com.example.myapplication.MainActivity.Companion.J_count
import com.example.myapplication.MainActivity.Companion.N_count
import com.example.myapplication.MainActivity.Companion.P_count
import com.example.myapplication.MainActivity.Companion.S_count
import com.example.myapplication.MainActivity.Companion.T_count
import com.example.myapplication.PagerRecyclerAdapter
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentViewPagerBinding


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
        val texts = arrayListOf<String>(
            "새로운 곳에서 새로운 사람을 만날 때",
            "모임같은 곳을 가는 걸",
            "나는 스트레스를 받았을 때",
            "내가 좋아하는 사람은?", "나는 일상적인 일을 할 때", "나 자신이 가치 있다고 느낄 때는",
            "불편한 진실과 착한 거짓말 중 선호하는 것은", "어떤 결정을 내릴 때 대게 나는", "나는 일벌레처럼 일할 때가", "정리가 안 된 방을 보면", "나는 과제나 일 등을 할 때", "전통과 관습은"
        )
        val option1 = arrayListOf<String>(
            "먼저 다가간다",
            "좋아한다",
            "친한 사람들과 만나 떠들며 놀고 싶어한다",
            "분별력 있는 사람", "일반적인 상식을 따른다", "판단력이 뛰어난 것을 확인할 때",
            "불편한 진실", "정해진 기준에 따른다", "자주 있다", "짜증날 때가 많다", "미리미리 한다", "중요하다"
        )
        val option2 = arrayListOf<String>(
            "다가와주길 바란다",
            "썩 달갑지는 않다",
            "혼자서 좋아하는 것에 몰입한다",
            "상상력이 풍부한 사람", "내 방식대로 한다", "상상력이 뛰어난 것을 확인할 때",
            "착한 거짓말", "나의 느낌과 판단에 따른다", "거의 없다", "아무 생각 안든다", "미루었다 마감 전에 한다", "벗어나야 한다"
        )
        binding.viewPager.run { isUserInputEnabled = false } // 슬라이드 방지
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
