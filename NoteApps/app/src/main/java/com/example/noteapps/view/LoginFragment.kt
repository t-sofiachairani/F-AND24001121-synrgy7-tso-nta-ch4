package com.example.noteapps.view

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isNotEmpty
import androidx.navigation.fragment.findNavController
import com.example.noteapps.R
import com.example.noteapps.databinding.FragmentLoginBinding
import com.example.noteapps.db.LoginPreference
import com.example.noteapps.helper.Constant

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    lateinit var sharedPref: LoginPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        sharedPref = LoginPreference(inflater.context)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvToRegister.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
        }

        binding.btnLogin.setOnClickListener {
            val username = binding.inputUsername.editText?.text.toString()
            val password = binding.inputPassword.editText?.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                sharedPref.put(Constant.PREF_USERNAME, username)
                sharedPref.put(Constant.PREF_PASSWORD, password)
                sharedPref.put(Constant.PREF_IS_LOGIN, true)
                Toast.makeText(requireContext(), "berhasil login", Toast.LENGTH_SHORT).show()
                moveFragment()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (sharedPref.getBoolean(Constant.PREF_IS_LOGIN)){
            moveFragment()
        }
    }

    private fun moveFragment() {
        findNavController().navigate(R.id.homeFragment)
    }
}