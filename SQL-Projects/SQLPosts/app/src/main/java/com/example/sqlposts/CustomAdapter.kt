package com.example.sqlposts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.delete_dialog.view.*
import kotlinx.android.synthetic.main.post_item.view.*

class CustomAdapter (context: Context,
                     private val posts : ArrayList<PostModel>)
    : ArrayAdapter<PostModel> (context, R.layout.post_item, posts) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater = LayoutInflater.from(context)
        val customView = layoutInflater.inflate(R.layout.post_item, parent, false)

        customView.postID.text = posts[position].postID.toString();
        customView.postTitle.text = posts[position].postTitle
        customView.postDescription.text = posts[position].postDescription

        customView.deleteButton.setOnClickListener {
            val layoutInflater = LayoutInflater.from(context);
            val view = layoutInflater.inflate(R.layout.delete_dialog, null);
            val dialogBuilder = AlertDialog.Builder(context);
            dialogBuilder.setView(view);

            val dialog = dialogBuilder.create();
            dialog.show();

            view.deleteMessage.text =
                "Do you want to delete the post with the: \n" +
                "\n" +
                "ID : ${posts[position].postID} \n" +
                "Title : ${posts[position].postTitle}"
        }

        return customView;
    }
}