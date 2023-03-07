package com.example.skincancer.database

import android.content.Context
import com.example.skincancer.SkinCancerVO
import java.util.ArrayList

class DataBaseManger constructor(context: Context) : SkinDao {
    private var db: DataBase = DataBase(context, null)

    override fun listSkin(): ArrayList<SkinCancerVO> {
        return db.listSkinCancer()
    }

    override fun editSkin(x: SkinCancerVO) {
        db.editSkinCancer(x)
    }

    override fun createSkin(x: SkinCancerVO) {
        db.createSkinCancer(x)
    }

    override fun deleteSkin(id: String) {
        db.deleteSkinCancer(id)
    }

    override fun searchBySkinid(idx: String): ArrayList<SkinCancerVO> {
        return db.searchBySkinCancerid(idx)
    }

    override fun searchBySkinimage(imagex: String): ArrayList<SkinCancerVO> {
        return db.searchBySkinCancerimages(imagex)
    }

    override fun searchBySkindate(datex: String): ArrayList<SkinCancerVO> {
        return db.searchBySkinCancerdates(datex)
    }

    override fun searchBySkinoutcome(outcomex: String): ArrayList<SkinCancerVO> {
        return db.searchBySkinCanceroutcome(outcomex)
    }
}