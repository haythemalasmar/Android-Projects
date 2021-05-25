package com.example.sqlposts

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import java.util.*
import kotlin.collections.ArrayList

class MyDatabase (context: Context) : SQLiteOpenHelper (
    context,
    MyDatabase.DATABASE_NAME,
    null, MyDatabase.DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(DATABASE_CREATE);
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $DATABASE_NAME");
    }

    companion object {
        val KEY_ID = "ID";
        val POST_TITLE = "TITLE";
        val POST_DESCRIPTION = "DESCRIPTION";
        val DATABASE_TABLE_NAME = "Posts";
        private val DATABASE_NAME = "data.db";
        private val DATABASE_VERSION = 1;
        private val DATABASE_CREATE =
            "CREATE TABLE IF NOT EXISTS $DATABASE_TABLE_NAME " +
            "($KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "$POST_TITLE TEXT NOT NULL, " +
            "$POST_DESCRIPTION TEXT NOT NULL)";
    }

    fun addPost (postModel: PostModel) {
        val db = this.writableDatabase;
        val values = ContentValues();
        values.put(POST_TITLE, postModel.postTitle);
        values.put(POST_DESCRIPTION, postModel.postDescription);

        db.insert(DATABASE_TABLE_NAME, null, values);
        db.close();
    }

    fun getPosts () : ArrayList<PostModel> {
        var postsList: ArrayList<PostModel> = ArrayList<PostModel>();
        val db = this.writableDatabase;
        val query = "SELECT * FROM $DATABASE_TABLE_NAME";
        var cursor: Cursor? = null;

        try {
            cursor = db.rawQuery(query, null);
        } catch (error: SQLiteException) {
            db.execSQL(query);
            return ArrayList();
        }



        if (cursor.moveToFirst()) {
            do {
                val postID = cursor.getInt(cursor.getColumnIndex(KEY_ID));
                val postTitle = cursor.getString(cursor.getColumnIndex(POST_TITLE));
                val postDescription = cursor.getString(cursor.getColumnIndex(POST_DESCRIPTION));
                val post = PostModel(postID, postTitle, postDescription);
                postsList.add(post);
            } while (cursor.moveToNext());
        }

        return postsList;
    }

    fun searchPosts (postTitle: String) : ArrayList<PostModel> {
        var postsList: ArrayList<PostModel> = ArrayList();
        val query = "SELECT * FROM $DATABASE_TABLE_NAME WHERE $POST_TITLE = \"$postTitle\";";
        val db = this.writableDatabase;
        var cursor: Cursor? = null;

        try {
            cursor = db.rawQuery(query, null);
        } catch (error: SQLiteException) {
            db.execSQL(query);
            return ArrayList();
        }

        if (cursor.moveToFirst()) {
            do {
                val postID = cursor.getInt(cursor.getColumnIndex(KEY_ID));
                val postTitle = cursor.getString(cursor.getColumnIndex(POST_TITLE));
                val postDescription = cursor.getString(cursor.getColumnIndex(POST_DESCRIPTION));
                val post = PostModel(postID, postTitle, postDescription);
                postsList.add(post);
            } while (cursor.moveToNext());
        }

        return postsList;
    }

    fun deletePost (postID: Int) {
        val db = this.writableDatabase;
        db.execSQL("DELETE FROM $DATABASE_TABLE_NAME WHERE $KEY_ID = \"$postID\";");
    }


}