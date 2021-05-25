package com.example.sqlblog

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.blog.view.*
import kotlinx.android.synthetic.main.delete_dialog.view.*
import kotlinx.android.synthetic.main.update_dialog.view.*

class CustomAdapter (context: Context, private val blog: ArrayList<BlogTemplate>)
    : ArrayAdapter<BlogTemplate>(context, R.layout.blog, blog) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(context);
        val view: View = layoutInflater.inflate(R.layout.blog, parent, false);

        view.blogID.text = blog[position].id.toString();
        view.blogTitle.text = blog[position].title;
        view.blogDescription.text = blog[position].description;

        view.updateBlogButton.setOnClickListener {
            val layoutInflater = LayoutInflater.from(context);
            val view = layoutInflater.inflate(R.layout.update_dialog, null);

            val dialogBuilder = AlertDialog.Builder(context);
            dialogBuilder.setView(view);

            val dialog = dialogBuilder.create();
            dialog.show();

            view.updateIDInput.setText(blog[position].id.toString());
            view.updateTitleInput.setText(blog[position].title);
            view.updateDescriptionInput.setText(blog[position].description);

            view.updateOkayButton.setOnClickListener {
                if (view.updateTitleInput.text.toString() == "" || view.updateDescriptionInput.text.toString() == "")
                    return@setOnClickListener;

                var myDatabase = MyDatabase(context);
                myDatabase.updateBlog(BlogTemplate(
                    blog[position].id,
                    view.updateTitleInput.text.toString(),
                    view.updateDescriptionInput.text.toString()));
                updateBlog(context as MainActivity);

                dialog.cancel();
            }

            view.updateCancelButton.setOnClickListener {
                dialog.cancel();
            }
        }

        view.deleteBlogButton.setOnClickListener {
            val layoutInflater = LayoutInflater.from(context);
            val view = layoutInflater.inflate(R.layout.delete_dialog, null);

            val dialogBuilder = AlertDialog.Builder(context);
            dialogBuilder.setView(view);

            val dialog = dialogBuilder.create();
            dialog.show();

            view.deleteOkayButton.setOnClickListener {
                var myDatabase = MyDatabase(context);
                myDatabase.deleteBlog(blog[position].id);
                deleteBlog(context as MainActivity);

                dialog.cancel();
            }

            view.deleteCancelButton.setOnClickListener {
                dialog.cancel();
            }
        }

        return view;
    }
}