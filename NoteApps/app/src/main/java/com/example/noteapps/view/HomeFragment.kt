package com.example.noteapps.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapps.R
import com.example.noteapps.ViewModelFactory
import com.example.noteapps.adapter.NoteAdapter
import com.example.noteapps.databinding.FragmentHomeBinding
import com.example.noteapps.databinding.FragmentLoginBinding
import com.example.noteapps.db.LoginPreference
import com.example.noteapps.db.Note
import com.example.noteapps.viewmodel.NoteViewModel

class HomeFragment : Fragment(), NoteAdapter.OnItemClickListener {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var noteData: RecyclerView
    private val listStudent = ArrayList<Note>()

    private val viewModel: NoteViewModel by activityViewModels {
        ViewModelFactory.getInstance(requireActivity())
    }

    val listNoteDataObserver = Observer<List<Note>>{
        val adapter = NoteAdapter(it, this)
        noteData.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButtonHome.setOnClickListener {
            findNavController().navigate(R.id.addNoteFragment)
        }

        noteData = binding.rvNotes // asumsikan rvNotes adalah id RecyclerView Anda di XML
        noteData.layoutManager = LinearLayoutManager(context)

        viewModel.getNotes().observe(viewLifecycleOwner, listNoteDataObserver)

    }
    override fun onEditClick(note: Note) {
        val bundle = bundleOf("idNote" to note.id)
        findNavController().navigate(R.id.editNoteFragment, bundle)
    }

    override fun onDeleteClick(note: Note) {
        val bundle = bundleOf("idNote" to note.id)
        findNavController().navigate(R.id.deleteNoteFragment, bundle)
    }
}
