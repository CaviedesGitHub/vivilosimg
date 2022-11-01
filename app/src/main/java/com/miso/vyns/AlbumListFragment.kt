package com.miso.vyns

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miso.vyns.adapters.AlbumItemAdapter
import com.miso.vyns.data.DataSource
import com.miso.vyns.databinding.FragmentAlbumListBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AlbumListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AlbumListFragment : Fragment() {
    private lateinit var binding: FragmentAlbumListBinding
    private lateinit var recyclerView: RecyclerView
    private val viewModel: VynsViewModel by viewModels()

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_album_list, container, false)
        binding.viewModel = viewModel
        recyclerView = binding.recyclervyns
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = AlbumItemAdapter()
        recyclerView.setHasFixedSize(true)
        //binding.recyclervyns.adapter = AlbumItemAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myDataset = DataSource().loadAlbums()
        binding.lifecycleOwner = viewLifecycleOwner
        //recyclerView = binding.recyclervyns
        //recyclerView.layoutManager = LinearLayoutManager(context)
        //recyclerView.adapter = AlbumItemAdapter(mutableListOf())
        //recyclerView.setHasFixedSize(true)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AlbumListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AlbumListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}