package com.example.skincancer.database

import com.example.skincancer.SkinCancerVO
import java.util.ArrayList

interface SkinDao {
    fun listSkin(): ArrayList<SkinCancerVO>
    fun editSkin(x: SkinCancerVO)
    fun createSkin(x: SkinCancerVO)
    fun deleteSkin(id: String)
    fun searchBySkinid(idx: String): ArrayList<SkinCancerVO>
    fun searchBySkindate(datex: String): ArrayList<SkinCancerVO>
    fun searchBySkinimage(imagex: String): ArrayList<SkinCancerVO>
    fun searchBySkinoutcome(outcomex: String): ArrayList<SkinCancerVO>
}