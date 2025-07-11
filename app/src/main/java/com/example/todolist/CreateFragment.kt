package com.example.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.todolist.databinding.FragmentCreateBinding

class CreateFragment : Fragment() {
    private var _binding: FragmentCreateBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateBinding.inflate(inflater, container, false)

        binding.btnSimpan.setOnClickListener {
            val todo = binding.etTodo.text.toString()
            if (todo.isNotEmpty()) {
                Toast.makeText(requireContext(), "To-do saved", Toast.LENGTH_SHORT).show()
                binding.etTodo.text?.clear()
            } else {
                Toast.makeText(requireContext(), "Fill in the to-do first", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
