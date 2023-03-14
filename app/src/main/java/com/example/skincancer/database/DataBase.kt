package com.example.skincancer.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.skincancer.SkinCancerVO

class DataBase (context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASENAME, factory, DATABASEVERSION) {

    companion object{
        lateinit var database: SQLiteDatabase

        private val DATABASENAME = "skincancerApp.db"
        private val DATABASEVERSION = 1

        const val SkinCancerTABLENAME = "SkinCancer"
        const val SkinCancerCOLIDTable = 0
        const val SkinCancerCOLID = 1
        const val SkinCancerCOLDATES = 2
        const val SkinCancerCOLIMAGES = 3
        const val SkinCancerCOLOUTCOME = 4

        val SkinCancerCOLS: Array<String> = arrayOf<String>("idTable", "id", "dates", "images", "outcome")
        const val SkinCancerNUMBERCOLS = 4

    }
    private val SkinCancerCREATESCHEMA =
        "create table SkinCancer (idTable integer primary key autoincrement" +
                ", id VARCHAR(50) not null"+
                ", dates VARCHAR(50) not null"+
                ", images VARCHAR(50) not null"+
                ", outcome VARCHAR(50) not null"+
                ")"

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SkinCancerCREATESCHEMA)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + SkinCancerCREATESCHEMA)
        onCreate(db)
    }

    fun onDestroy() {
        database.close()
    }

    fun listSkinCancer(): ArrayList<SkinCancerVO> {
        val res = ArrayList<SkinCancerVO>()
        database = readableDatabase
        val cursor: Cursor =
            database.query(SkinCancerTABLENAME, SkinCancerCOLS, null, null, null, null, null)
        cursor.moveToFirst()
        while (!cursor.isAfterLast()) {
            res.add(setData(cursor))
            cursor.moveToNext()
        }
        cursor.close()
        return res
    }

    fun createSkinCancer(skincancervo: SkinCancerVO) {
        database = writableDatabase
        database.insert(SkinCancerTABLENAME, SkinCancerCOLS[1], putData(skincancervo))
    }

    fun searchBySkinCancerid(value: String): ArrayList<SkinCancerVO> {
        val res = ArrayList<SkinCancerVO>()
        database = readableDatabase
        val args = arrayOf(value)
        val cursor: Cursor = database.rawQuery(
            "select idTable, id, dates, images, outcome from SkinCancer where id = ?",
            args
        )
        cursor.moveToFirst()
        while (!cursor.isAfterLast()) {
            res.add(setData(cursor))
            cursor.moveToNext()
        }
        cursor.close()
        return res
    }

    fun searchBySkinCancerdates(value: String): ArrayList<SkinCancerVO> {
        val res = ArrayList<SkinCancerVO>()
        database = readableDatabase
        val args = arrayOf(value)
        val cursor: Cursor = database.rawQuery(
            "select idTable, id, dates, images, outcome from SkinCancer where dates = ?",
            args
        )
        cursor.moveToFirst()
        while (!cursor.isAfterLast()) {
            res.add(setData(cursor))
            cursor.moveToNext()
        }
        cursor.close()
        return res
    }

    fun searchBySkinCancerimages(value: String): ArrayList<SkinCancerVO> {
        val res = ArrayList<SkinCancerVO>()
        database = readableDatabase
        val args = arrayOf(value)
        val cursor: Cursor = database.rawQuery(
            "select idTable, id, dates, images, outcome from SkinCancer where images = ?",
            args
        )
        cursor.moveToFirst()
        while (!cursor.isAfterLast()) {
            res.add(setData(cursor))
            cursor.moveToNext()
        }
        cursor.close()
        return res
    }

    fun searchBySkinCanceroutcome(value: String): ArrayList<SkinCancerVO> {
        val res = ArrayList<SkinCancerVO>()
        database = readableDatabase
        val args = arrayOf(value)
        val cursor: Cursor = database.rawQuery(
            "select idTable, id, dates, images, outcome from SkinCancer where outcome = ?",
            args
        )
        cursor.moveToFirst()
        while (!cursor.isAfterLast()) {
            res.add(setData(cursor))
            cursor.moveToNext()
        }
        cursor.close()
        return res
    }


    fun editSkinCancer(skincancervo: SkinCancerVO) {
        database = writableDatabase

        val args = arrayOf(skincancervo.getId())
        database.update(SkinCancerTABLENAME, putData(skincancervo), "id =?", args)
    }

    fun deleteSkinCancer(value: String) {
        database = writableDatabase
        val args = arrayOf(value)
        database.delete(SkinCancerTABLENAME, "id = ?", args)
    }

    private fun setData(cursor: Cursor): SkinCancerVO {
        val skincancervo = SkinCancerVO()
        skincancervo.setId(cursor.getString(SkinCancerCOLID))
        skincancervo.setDates(cursor.getString(SkinCancerCOLDATES))
        skincancervo.setImages(cursor.getString(SkinCancerCOLIMAGES))
        skincancervo.setOutcome(cursor.getString(SkinCancerCOLOUTCOME))

        return skincancervo
    }

    private fun putData(skincancervo: SkinCancerVO): ContentValues {
        val wr = ContentValues(SkinCancerNUMBERCOLS)
        wr.put(SkinCancerCOLS[SkinCancerCOLID], skincancervo.getId())
        wr.put(SkinCancerCOLS[SkinCancerCOLDATES], skincancervo.getDates())
        wr.put(SkinCancerCOLS[SkinCancerCOLIMAGES], skincancervo.getImages())
        wr.put(SkinCancerCOLS[SkinCancerCOLOUTCOME], skincancervo.getOutcome())

        return wr
    }

}
