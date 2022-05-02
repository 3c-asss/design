package com.example.design;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.design.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class MySQLiteOpenHelper  extends SQLiteOpenHelper {
    private static final String DB_NAME = "MySQLite.db";
    private static final String TABLE_NAME_STUDENT = "student";
    private static final String CREATE_TABLE_SQL_STUDENT = "create table " + TABLE_NAME_STUDENT
            + " (_id integer primary key autoincrement, name text, number text, gender text, score text)";

    public MySQLiteOpenHelper(Context context){
        super(context, DB_NAME, null, 1);
    }

    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name,
                              @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL_STUDENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertData(Student student){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("name", student.getName());
        contentValues.put("number", student.getNumber());
        contentValues.put("gender", student.getGender());
        contentValues.put("score", student.getScore());

        return db.insert(TABLE_NAME_STUDENT, null, contentValues);
    }

    public int deleteDataFromDbByName(String name){

        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_NAME_STUDENT, "name like ?", new String[]{name});
    }

    public int updateData(Student student) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", student.getName());
        values.put("number", student.getNumber());
        values.put("gender", student.getGender());
        values.put("score", student.getScore());

        return db.update(TABLE_NAME_STUDENT, values, "name like ?", new String[]{student.getName()});
    }

    public List<Student> queryFromDbByName(String name){

        SQLiteDatabase db = getReadableDatabase();

        List<Student> studentList = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME_STUDENT, null, "name like ?",
                new String[]{name},null, null, null);

        if (cursor != null){
            while (cursor.moveToNext()){
                String student_name = cursor.getString(cursor.getColumnIndex("name"));
                String student_number = cursor.getString(cursor.getColumnIndex("number"));
                String student_gender = cursor.getString(cursor.getColumnIndex("gender"));
                String student_score = cursor.getString(cursor.getColumnIndex("score"));

                Student student =  new Student();
                student.setName(student_name);
                student.setNumber(student_number);
                student.setGender(student_gender);
                student.setScore(student_score);

                studentList.add(student);
            }
            cursor.close();
        }

        return studentList;
    }

    public List<Student> queryAllFromDb(){

        SQLiteDatabase db = getReadableDatabase();

        List<Student> studentList = new ArrayList<>();

        Cursor cursor = db.query(TABLE_NAME_STUDENT, null, null,
                null,null, null, null);

        if (cursor != null){
            while (cursor.moveToNext()){
                String student_name = cursor.getString(cursor.getColumnIndex("name"));
                String student_number = cursor.getString(cursor.getColumnIndex("number"));
                String student_gender = cursor.getString(cursor.getColumnIndex("gender"));
                String student_score = cursor.getString(cursor.getColumnIndex("score"));

                Student student =  new Student();
                student.setName(student_name);
                student.setNumber(student_number);
                student.setGender(student_gender);
                student.setScore(student_score);

                studentList.add(student);
            }
            cursor.close();
        }

        return studentList;
    }
}
