package com.example.mobileapplications22

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMessages : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_messages, container, false)

        val chatRecyclerView: RecyclerView = view.findViewById(R.id.chats)
        val chatMessages = listOf(
            ChatMessage("random1", "Hello there!", "10:33 AM"),
            ChatMessage("random2", "How are you?", "9:11 AM"),
            ChatMessage("random3", "See you soon.", "8:49 AM"),
            ChatMessage("random4", "Let's catch up!", "Yesterday"),
        )

        chatRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        chatRecyclerView.adapter = ChatAdapter(chatMessages)

        return view
    }
}
