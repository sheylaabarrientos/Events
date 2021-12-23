package com.example.events

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.events.databinding.SecondActivityBinding
import com.example.events.domain.User
import kotlinx.android.synthetic.main.second_activity.*

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: SecondActivityBinding
    private lateinit var viewModel: MainAcitivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        second_check_in_button.setOnClickListener {
            createUser()
        }

        initViewModel()
    }

    private fun createUser() {
        val user = User("", email_editText.text.toString(), name_editText.text.toString())
        viewModel.creatNewUser(user)
    }

    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(MainAcitivityViewModel::class.java)
        viewModel.getCreateNewUserObserver().observe(
            this,
            androidx.lifecycle.Observer {
                if (it == null) {
                    Toast.makeText(this, "Failed Create User", Toast.LENGTH_LONG)
                        .show()
                } else {
                    Toast.makeText(this, "Sucess Create User", Toast.LENGTH_LONG)
                        .show()
                }
            }
        )
    }
}
