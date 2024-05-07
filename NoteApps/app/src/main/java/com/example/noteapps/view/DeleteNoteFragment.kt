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
import com.example.noteapps.databinding.FragmentDeleteNoteBinding
import com.example.noteapps.db.Note
import com.example.noteapps.viewmodel.NoteViewModel

class DeleteNoteFragment : Fragment() {
    private var _binding: FragmentDeleteNoteBinding? = null
    private val binding get() = _binding!!
    private val viewModel: NoteViewModel by activityViewModels {
        ViewModelFactory.getInstance(requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDeleteNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val idNote = arguments?.getLong("idNote")
        val note = idNote?.let { viewModel.getNoteByID(it) }

        if (note != null) {
            binding.editTitle.editText?.setText(note.title)
            binding.editNote.editText?.setText(note.note)
        }


        binding.btnDeleteNotes.setOnClickListener {
            if (note != null) {
                viewModel.deleteNote(note)
            }
            findNavController().navigate(R.id.homeFragment)
        }



    }
}