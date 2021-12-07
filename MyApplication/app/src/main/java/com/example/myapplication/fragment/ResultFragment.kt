package com.example.myapplication.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.example.myapplication.*
import com.example.myapplication.databinding.FragmentResultBinding
import com.sothree.slidinguppanel.SlidingUpPanelLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ResultFragment : Fragment() {
    private lateinit var mbinding: FragmentResultBinding  // 뷰 바인딩
    // non-null type
    var option = -1
    lateinit var navController: NavController

    // id가져오려면 추가해야할 것 들
    private var mBinding: FragmentResultBinding? = null
    private val nbinding get() = mBinding!!


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        mbinding = FragmentResultBinding.inflate(layoutInflater)
        val view = mbinding.root

        val slidePanel = mbinding.mainFrame               // SlidingUpPanel

        // 패널 열고 닫기
        mbinding.btnToggle.setOnClickListener {
            val state = slidePanel.panelState
            // 닫힌 상태일 경우 열기
            if (state == SlidingUpPanelLayout.PanelState.COLLAPSED) {
                slidePanel.panelState = SlidingUpPanelLayout.PanelState.ANCHORED
            }
            // 열린 상태일 경우 닫기
            else if (state == SlidingUpPanelLayout.PanelState.EXPANDED) {
                slidePanel.panelState = SlidingUpPanelLayout.PanelState.COLLAPSED
            }
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        // arguments가 null이 아니면 getInt 실행하고
        // 앨비스 연산자를 이용하여 getInt마저도 null이면 -1값을 줌
        option = arguments?.getInt("index")?:-1
        mBinding = FragmentResultBinding.inflate(inflater, container, false)  // binding위해 추가할 것

        return nbinding.root // 또한 마찬가지
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setResult()

        // 종료버튼 클릭시 CustomDialog를 show
        nbinding.ending.setOnClickListener{
            val dialog = CustomDialog()
            activity?.supportFragmentManager?.let{
                fragmentManager ->
                dialog.show(fragmentManager,"CustomDialog")
            }
        }
    }
    
    // 각 count 개수 비교하여 mbti 출력
    @SuppressLint("SetTextI18n")
    fun setResult(){
        var mbtiResult = ""
        if(E_count > I_count){
            mbtiResult += "E"
        }
        else if(E_count < I_count){
            mbtiResult += "I"
        }
        if(S_count > N_count){
            mbtiResult += "S"
        }
        else if(S_count < N_count){
            mbtiResult += "N"
        }
        if(T_count > F_count){
            mbtiResult += "T"
        }
        else if(T_count < F_count){
            mbtiResult += "F"
        }
        if(J_count > P_count){
            mbtiResult += "J"
        }
        else if(J_count < P_count){
            mbtiResult += "P"
        }

        nbinding.testResult.text = mbtiResult

        if(mbtiResult == "ESTJ"){
            nbinding.subResult.text = getString(R.string.estj)
        }
        if(mbtiResult == "ESTP"){
            nbinding.subResult.text = getString(R.string.estp)
        }
        if(mbtiResult == "ESFJ"){
            nbinding.subResult.text = getString(R.string.esfj)
        }
        if(mbtiResult == "ESFP"){
            nbinding.subResult.text = getString(R.string.esfp)
        }
        if(mbtiResult == "ENTJ"){
            nbinding.subResult.text = getString(R.string.entj)
        }
        if(mbtiResult == "ENTP"){
            nbinding.subResult.text = getString(R.string.entp)
        }
        if(mbtiResult == "ENFJ"){
            nbinding.subResult.text = getString(R.string.enfj)
        }
        if(mbtiResult == "ENFP"){
            nbinding.subResult.text = getString(R.string.enfp)
        }
        if(mbtiResult == "ISFP"){
            nbinding.subResult.text = getString(R.string.isfp)
        }
        if(mbtiResult == "ISFJ"){
            nbinding.subResult.text = getString(R.string.isfj)
        }
        if(mbtiResult == "ISTJ"){
            nbinding.subResult.text = getString(R.string.istj)
        }
        if(mbtiResult == "ISTP"){
            nbinding.subResult.text = getString(R.string.istp)
        }
        if(mbtiResult == "INFJ"){
            nbinding.subResult.text = getString(R.string.infj)
        }
        if(mbtiResult == "INFP"){
            nbinding.subResult.text = getString(R.string.infp)
        }
        if(mbtiResult == "INTJ"){
            nbinding.subResult.text = getString(R.string.intj)
        }
        if(mbtiResult == "INTP"){
            nbinding.subResult.text = getString(R.string.intp)
        }

    }


    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}