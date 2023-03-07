package com.example.skincancer

import java.util.HashMap
import java.util.HashSet

class SkinCancer {

    init {
        SkinCancer_allInstances.add(this)
    }

    companion object {
        var SkinCancer_allInstances = ArrayList<SkinCancer>()
        fun createSkinCancer(): SkinCancer {
            return SkinCancer()
        }
        
        var SkinCancer_index: HashMap<String, SkinCancer> = HashMap<String, SkinCancer>()
        
        fun createByPKSkinCancer(idx: String): SkinCancer {
            var result: SkinCancer? = SkinCancer_index[idx]
            if (result != null) { return result }
                  result = SkinCancer()
                  SkinCancer_index.put(idx,result)
                  result.id = idx
                  return result
        }
        
		fun killSkinCancer(idx: String?) {
            val rem = SkinCancer_index[idx] ?: return
            val remd = ArrayList<SkinCancer>()
            remd.add(rem)
            SkinCancer_index.remove(idx)
            SkinCancer_allInstances.removeAll(remd)
        }        
    }

    var id = ""  /* identity */
    var dates = "" 
    var images = "" 
    var outcome = ""  /* derived */

}
