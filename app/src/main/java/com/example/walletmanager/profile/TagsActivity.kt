package com.example.walletmanager.profile

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.walletmanager.R
import com.example.walletmanager.dao.WalletManagerDatabase
import com.example.walletmanager.pojos.Tag
import kotlinx.android.synthetic.main.activity_tags.*

class TagsActivity : AppCompatActivity(), TagsAdapter.OnClicked {

    private var profileRepo = ProfileRepo(WalletManagerDatabase.invoke())
    private var profileModelFactory = ProfileViewModelFactory(profileRepo)

    private val tagsAdapter by lazy { TagsAdapter(emptyList(), this) }

    private val profileViewModel by viewModels<ProfileViewModel> { profileModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tags)

        init()
    }

    private fun init() {
        fetchData()
        setViews()
        setListeners()
        setObservers()
    }

    private fun fetchData() {
        profileViewModel.getAllTags()
    }

    private fun setViews() {
        tags_recycler_view.layoutManager = LinearLayoutManager(this)
        tags_recycler_view.adapter = tagsAdapter
    }

    private fun setListeners() {

        add_tag_button.setOnClickListener {
            val tag = Tag(id = System.currentTimeMillis(), tagName = "My New Tag")
            Log.e("TAG", "tag button clicked")
            profileViewModel.insertTag(tag)
        }

    }

    private fun setObservers() {

        profileViewModel.getAllTags().observe(this, {
            Log.e("TAG", "changes observed: $it")
            tagsAdapter.addData(it)
        })

    }

    override fun onItemClicked(tag: Tag) {
        TODO("Not yet implemented")
    }

    override fun onDeleteClicked(tag: Tag) {
        Log.e("TAG", "delete observed")
        profileViewModel.deleteTag(tag)
    }

    companion object {
        fun newInstance(context: Context): Intent {
            return Intent(context, TagsActivity::class.java)
        }
    }
}