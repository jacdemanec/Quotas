package com.tonietorres.formenteraquotas.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tonietorres.formenteraquotas.data.QuotaContact.DaysTable;
import com.tonietorres.formenteraquotas.data.QuotaContact.RegistroTable;

public class QuotaDbHelper extends SQLiteOpenHelper {

    // The database name
    private static final String DATABASE_NAME = "quotaformentera.db";

    // If you change the database schema, you must increment the database version
    private static final int DATABASE_VERSION = 7;

    // Constructor
    public QuotaDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // Create a table to hold the places data
        final String SQL_CREATE_DAYS_TABLE = "CREATE TABLE " + DaysTable.TABLE_NAME + " (" +
                DaysTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                DaysTable.DATE_COLUMN + " TEXT NOT NULL, " +
                DaysTable.QUOTA_HALF_NINE_COLUMN + " INTEGER NOT NULL, " +
                DaysTable.QUOTA_HALF_TEN_COLUMN + " INTEGER NOT NULL, " +
                DaysTable.QUOTA_QUARTER_FIVE_COLUMN + " INTEGER NOT NULL, " +
                DaysTable.QUOTA_HALF_SIX_COLUMN + " INTEGER NOT NULL, " +
                DaysTable.PAX_HALF_NINE_COLUMN + " INTEGER NOT NULL, " +
                DaysTable.PAX_HALF_TEN_COLUMN + " INTEGER NOT NULL, " +
                DaysTable.PAX_QUARTER_FIVE_COLUMN + " INTEGER NOT NULL, " +
                DaysTable.PAX_HALF_SIX_COLUMN + " INTEGER NOT NULL, " +
                "UNIQUE (" + DaysTable.DATE_COLUMN + ") ON CONFLICT REPLACE" +
                "); ";

        final String SQL_CREATE_REGISTRO_TABLE = "CREATE TABLE " + RegistroTable.TABLE_NAME + " (" +
                RegistroTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                RegistroTable.LOGIN_COLUMN + " TEXT NOT NULL, " +
                RegistroTable.DATE_COLUMN + " TEXT NOT NULL, " +
                RegistroTable.PAX_HALF_NINE_COLUMN + " INTEGER DEFAULT '0', " +
                RegistroTable.PAX_HALF_TEN_COLUMN + " INTEGER DEFAULT '0', " +
                RegistroTable.PAX_QUARTER_FIVE_COLUMN + " INTEGER DEFAULT '0', " +
                RegistroTable.PAX_HALF_SIX_COLUMN + " INTEGER DEFAULT '0', " +
                RegistroTable.FECHA_RES_COLUMN + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                RegistroTable.HORA_RES_COLUMN + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
                RegistroTable.ACTIVE_COLUMN + " INTEGER DEFAULT '1' " +
                "); ";

        sqLiteDatabase.execSQL(SQL_CREATE_DAYS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_REGISTRO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // For now simply drop the table and create a new one.
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DaysTable.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + RegistroTable.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
