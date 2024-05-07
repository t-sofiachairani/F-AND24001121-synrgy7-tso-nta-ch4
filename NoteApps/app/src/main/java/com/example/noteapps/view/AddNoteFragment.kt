package com.example.noteapps.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.noteapps.R
import com.example.noteapps.ViewModelFactory
import com.example.noteapps.databinding.FragmentAddNoteBinding
import com.example.noteapps.databinding.FragmentHomeBinding
import com.example.noteapps.db.Note
import com.example.noteapps.viewmodel.NoteViewModel

class AddNoteFragment : Fragment() {
    private var _binding: FragmentAddNoteBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NoteViewModel by activityViewModels {
        ViewModelFactory.getInstance(requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAddNotes.setOnClickListener {
            val title = binding.addTitle.editText?.text.toString()
            val noteText = binding.addNote.editText?.text.toString()

            val note = Note(title = title, note = noteText)
            viewModel.addNote(note)

            findNavController().navigate(R.id.homeFragment)
        }
    }
}