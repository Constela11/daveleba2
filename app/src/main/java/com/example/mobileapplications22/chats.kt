package com.example.mobileapplications22

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class ChatMessage(val sender: String, val message: String, val timestamp: String)

class ChatAdapter(private val messages: List<ChatMessage>) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chats, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val message = messages[position]
        holder.chat_name.text = message.sender
        holder.chat_message.text = message.message
        holder.chat_time.text = message.timestamp
    }

    override fun getItemCount(): Int = messages.size

    inner class ChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val chat_name: TextView = itemView.findViewById(R.id.chat_name)
        val chat_message: TextView = itemView.findViewById(R.id.chat_message)
        val chat_time: TextView = itemView.findViewById(R.id.chat_time)
    }
}
