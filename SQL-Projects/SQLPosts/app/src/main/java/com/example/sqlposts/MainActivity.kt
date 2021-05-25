package com.example.sqlposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.addButton
import kotlinx.android.synthetic.main.add_dialog.*
import kotlinx.android.synthetic.main.add_dialog.view.*
import kotlinx.android.synthetic.main.delete_dialog.*
import kotlinx.android.synthetic.main.delete_dialog.view.*
import kotlinx.android.synthetic.main.post_item.view.*
import kotlinx.android.synthetic.main.search_dialog.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        val myDatabase = MyDatabase(this);
        var posts: ArrayList<PostModel> = myDatabase.getPosts();
        var myAdapter = CustomAdapter(this, posts);
        postsList.adapter = myAdapter;

        addButton.setOnClickListener {
            val layoutInflater = LayoutInflater.from(this);
            val view = layoutInflater.inflate(R.layout.add_dialog, null);
            val dialogBuilder = AlertDialog.Builder(this);
            dialogBuilder.setView(view);
            val dialog = dialogBuilder.create();
            dialog.show();

            view.addPositiveButton.setOnClickListener {
                if (
                    view.addTitleInput.text.toString() == "" ||
                    view.addDescriptionInput.text.toString() == ""
                ) return@setOnClickListener;

                val postTitle = view.addTitleInput.text.toString();
                val postDescription = view.addDescriptionInput.text.toString();
                myDatabase.addPost(PostModel(0, postTitle, postDescription));
                posts.add(PostModel(0, postTitle, postDescription));
                myAdapter = CustomAdapter(this, posts);
                postsList.adapter = myAdapter;

                view.addTitleInput.setText("");
                view.addDescriptionInput.setText("");

                dialog.cancel();
            }

            view.addPositiveButton.setOnClickListener {
                dialog.cancel();
            }
        }
//
//        searchButton.setOnClickListener {
//            val layoutInflater = LayoutInflater.from(this);
//            val view = layoutInflater.inflate(R.layout.search_dialog, null);
//            val dialogBuilder = AlertDialog.Builder(this);
//            dialogBuilder.setView(view);
//            val dialog = dialogBuilder.create();
//            dialog.show();
//
//            view.searchPositiveButton.setOnClickListener {
//                if (view.searchTitleInput.text.toString() == null) return@setOnClickListener;
//
//                val postTitle = view.searchTitleInput.text.toString();
//                posts = myDatabase.searchPosts(postTitle);
//                myAdapter = CustomAdapter(this, posts);
//                postsList.adapter = myAdapter;
//            }
//
//            view.searchCancelButton.setOnClickListener {
//                dialog.cancel();
//            }
//        }

        /*
        val deleteDialog = DialogBuilder(this, R.layout.delete_dialog);
        deleteDialog.dialogView().deletePositiveButton.setOnClickListener {
            posts = myDatabase.getPosts();
            myAdapter = CustomAdapter(this, posts);
            postsList.adapter = myAdapter;
        }
        */
    }
}

