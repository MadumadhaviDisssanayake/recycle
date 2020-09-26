package com.example.lockbot;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "lock_bot.db";
    public static final String FILE_TABLE_NAME = "locked_files";
    public static final String FILE_COLUMN_ID = "id";
    public static final String FILE_COLUMN_FILE_NAME = "fileName";
    public static final String FILE_COLUMN_DATE = "date";
    public static final String FILE_COLUMN_FILE_TYPE = "fileType";
    public static final String FILE_COLUMN_VISIBILITY = "visibility";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String createTableStatement = "CREATE TABLE " + FILE_TABLE_NAME + "(" + FILE_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ FILE_COLUMN_FILE_NAME +" TEXT, "+ FILE_COLUMN_DATE +" TEXT, "+ FILE_COLUMN_FILE_TYPE +" TEXT, "+ FILE_COLUMN_VISIBILITY +" BOOL)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }

    public boolean insertFile (FileModel fileModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

//        contentValues.put(FILE_COLUMN_ID, fileModel.getId());
        contentValues.put(FILE_COLUMN_FILE_NAME, fileModel.getFileName());
        contentValues.put(FILE_COLUMN_DATE, fileModel.getDate());
        contentValues.put(FILE_COLUMN_FILE_TYPE, fileModel.getFileType());
        contentValues.put(FILE_COLUMN_VISIBILITY, fileModel.getVisibility());

        long insert = db.insert(FILE_TABLE_NAME, null, contentValues);

        db.close();

        return insert != -1;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts where id="+id+"", null );
        return res;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, FILE_TABLE_NAME);
        return numRows;
    }

    public Integer deleteFiles (Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(FILE_TABLE_NAME,
                "id = ? ",
                new String[] { Integer.toString(id) });
    }

    public Integer restoreFiles (Integer id){
        ContentValues cv = new ContentValues();
        cv.put(FILE_COLUMN_VISIBILITY,1);
        SQLiteDatabase db = this.getWritableDatabase();
        return db.update(FILE_TABLE_NAME,cv,"id = "+id,null);
    }

    public ArrayList<FileModel> getAllFiles() {
        ArrayList<FileModel> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM "+ FILE_TABLE_NAME +" WHERE "+ FILE_COLUMN_VISIBILITY +"=0";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result =  db.rawQuery(queryString,null);

        if(result.moveToFirst()){
            do{
                int fileID = result.getInt(0);
                String fileName = result.getString(1);
                String fileDate = result.getString(2);
                String fileType = result.getString(3);
                boolean fileVisibility = result.getInt(4) == 1;

                FileModel fileModel = new FileModel(fileID, fileName, fileDate, fileType, fileVisibility);
                returnList.add(fileModel);

            }while(result.moveToNext());
        }
        else {
            //define what should appear if the list is empty
        };

        result.close();
        db.close();
        return returnList;
    }

    public ArrayList<FileModel> getDocFiles() {
        ArrayList<FileModel> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM "+ FILE_TABLE_NAME +" WHERE "+ FILE_COLUMN_FILE_TYPE + "=\"document\" AND "+ FILE_COLUMN_VISIBILITY +"=0";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result =  db.rawQuery(queryString,null);

        if(result.moveToFirst()){
            do{
                int fileID = result.getInt(0);
                String fileName = result.getString(1);
                String fileDate = result.getString(2);
                String fileType = result.getString(3);
                boolean fileVisibility = result.getInt(4) == 1;

                FileModel fileModel = new FileModel(fileID, fileName, fileDate, fileType, fileVisibility);
                returnList.add(fileModel);

            }while(result.moveToNext());
        }
        else {
            //define what should appear if the list is empty
        };

        result.close();
        db.close();

        return returnList;
    }

    public ArrayList<FileModel> getImageFiles() {
        ArrayList<FileModel> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM "+ FILE_TABLE_NAME +" WHERE "+ FILE_COLUMN_FILE_TYPE + "=\"image\" AND "+ FILE_COLUMN_VISIBILITY +"=0";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result =  db.rawQuery(queryString,null);

        if(result.moveToFirst()){
            do{
                int fileID = result.getInt(0);
                String fileName = result.getString(1);
                String fileDate = result.getString(2);
                String fileType = result.getString(3);
                boolean fileVisibility = result.getInt(4) == 1;

                FileModel fileModel = new FileModel(fileID, fileName, fileDate, fileType, fileVisibility);
                returnList.add(fileModel);

            }while(result.moveToNext());
        }
        else {
            //define what should appear if the list is empty
        };

        result.close();
        db.close();

        return returnList;
    }

    public ArrayList<FileModel> getVideoFiles() {
        ArrayList<FileModel> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM "+ FILE_TABLE_NAME +" WHERE "+ FILE_COLUMN_FILE_TYPE + "=\"video\" AND "+ FILE_COLUMN_VISIBILITY +"=0";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result =  db.rawQuery(queryString,null);

        if(result.moveToFirst()){
            do{
                int fileID = result.getInt(0);
                String fileName = result.getString(1);
                String fileDate = result.getString(2);
                String fileType = result.getString(3);
                boolean fileVisibility = result.getInt(4) == 1;

                FileModel fileModel = new FileModel(fileID, fileName, fileDate, fileType, fileVisibility);
                returnList.add(fileModel);

            }while(result.moveToNext());
        }
        else {
            //define what should appear if the list is empty
        };

        result.close();
        db.close();

        return returnList;
    }
}
