package com.ian.android.chriminalintent

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment

class CrimeFragment : Fragment() {

    private lateinit var crime: Crime
    private lateinit var titleField: EditText
    private lateinit var dateButton: Button
    private lateinit var solvedCheckBox: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) { // 注意:與Activity不同的是onCreate在fragment中是public函數
        super.onCreate(savedInstanceState)
        crime = Crime()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.fragment_crime,
            container,
            false
        ) //container是父視圖，false表示是否立即將生成的視圖傳給父視圖

        titleField = view.findViewById(R.id.crime_title) as EditText
        dateButton = view.findViewById(R.id.crime_date) as Button
        solvedCheckBox = view.findViewById(R.id.crime_solved) as CheckBox
        dateButton.apply {
            text = crime.date.toString()
            isEnabled = false
        }

        return view
    }

    override fun onStart() {
        super.onStart()

        val titleWatcher = object : TextWatcher { // 匿名內部類
            override fun beforeTextChanged(
                sequence: CharSequence?, // 用戶輸入
                start: Int,
                count: Int,
                after: Int
            ) {
                // This space intentionally left blank
            }

            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                crime.title = sequence.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
                TODO("Not yet implemented")
            }
        }


        titleField.addTextChangedListener(titleWatcher)
        solvedCheckBox.setOnCheckedChangeListener{ _, isChecked ->
            crime.isSolved = isChecked
        }
    }


}