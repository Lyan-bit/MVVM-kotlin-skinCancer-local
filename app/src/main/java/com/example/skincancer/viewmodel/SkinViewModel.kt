package com.example.skincancer.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.skincancer.SkinCancer
import com.example.skincancer.SkinCancerVO
import com.example.skincancer.database.DataBaseManger
import java.util.ArrayList

class SkinViewModel constructor(context: Context): ViewModel() {

    private var dbm: DataBaseManger = DataBaseManger (context)
    private var currentSkin: SkinCancerVO? = null
    private var currentSkins: ArrayList<SkinCancerVO> = ArrayList()

    companion object {
        private var instance: SkinViewModel? = null
        fun getInstance(context: Context): SkinViewModel {
            return instance ?: SkinViewModel(context)
        }
    }

    init {
        dbm = DataBaseManger (context)
    }

    fun stringListSkin(): ArrayList<String> {
        currentSkins = dbm.listSkin()
        val res: ArrayList<String> = ArrayList()
        for (x in currentSkins.indices) {
            res.add(currentSkins[x].toString())
        }
        return res
    }

    fun getSkinByPK(_val: String): SkinCancer? {
        val res: List<SkinCancerVO> = dbm.searchBySkinid(_val)
        return if (res.isEmpty()) {
            null
        } else {
            val vo: SkinCancerVO = res[0]
            val itemx = SkinCancer.createByPKSkinCancer(_val)
            itemx.id = vo.getId()
            itemx.dates = vo.getDates()
            itemx.images = vo.getImages()
            itemx.outcome = vo.getOutcome()
            itemx
        }
    }

    fun retrieveSkin(_val: String): SkinCancer? {
        return getSkinByPK(_val)
    }

    fun allSkinids(): ArrayList<String> {
        currentSkins = dbm.listSkin()
        val res: ArrayList<String> = ArrayList()
        for (skin in currentSkins.indices) {
            res.add(currentSkins[skin].getId())
        }
        return res
    }

    fun allSkinoutcomes(): ArrayList<String> {
        currentSkins = dbm.listSkin()
        val res: ArrayList<String> = ArrayList()
        for (skin in currentSkins.indices) {
            res.add(currentSkins[skin].getOutcome())
        }
        return res
    }

    fun allSkinimages(): ArrayList<String> {
        currentSkins = dbm.listSkin()
        val res: ArrayList<String> = ArrayList()
        for (skin in currentSkins.indices) {
            res.add(currentSkins[skin].getImages())
        }
        return res
    }

    fun allSkindates(): ArrayList<String> {
        currentSkins = dbm.listSkin()
        val res: ArrayList<String> = ArrayList()
        for (skin in currentSkins.indices) {
            res.add(currentSkins[skin].getDates())
        }
        return res
    }

    fun setSelectedSkin(x: SkinCancerVO) {
        currentSkin = x
    }

    fun setSelectedSkin(i: Int) {
        if (i < currentSkins.size) {
            currentSkin = currentSkins[i]
        }
    }

    fun getSelectedSkin(): SkinCancerVO? {
        return currentSkin
    }

    fun persistSkin(_x: SkinCancer) {
        val vo = SkinCancerVO(_x)
        dbm.editSkin(vo)
        currentSkin = vo
    }

    fun listSkin(): ArrayList<SkinCancerVO> {
        currentSkins = dbm.listSkin()
        return currentSkins
    }

    fun editSkin(_x: SkinCancerVO) {
        dbm.editSkin(_x)
        currentSkin = _x
    }

    fun createSkin(_x: SkinCancerVO) {
        dbm.createSkin(_x)
        currentSkin = _x
    }

    fun deleteSkin(_id: String) {
        dbm.deleteSkin(_id)
        currentSkin = null
    }

    fun searchBySkinid(idx: String): List<SkinCancerVO> {
        currentSkins = dbm.searchBySkinid(idx)
        return currentSkins
    }

    fun searchBySkindate(datex: String): List<SkinCancerVO> {
        currentSkins = dbm.searchBySkindate(datex)
        return currentSkins
    }

    fun searchBySkinimage(imagex: String): List<SkinCancerVO> {
        currentSkins = dbm.searchBySkinimage(imagex)
        return currentSkins
    }

    fun searchBySkinoutcome(outcomex: String): List<SkinCancerVO> {
        currentSkins = dbm.searchBySkinoutcome(outcomex)
        return currentSkins
    }

}