package com.example.skincancer.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.skincancer.fragments.*

class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object {
        private val TABTITLES = arrayOf("+SkinCancer", "ListSkinCancer", "EditSkinCancer", "DeleteSkinCancer", "SearchSkinCancerdates", "ImageRecognition")
    }

    override fun getItem(position: Int): Fragment {
        // instantiate a fragment for the page.
            return when (position) {
                 0 -> { 
                    CreateSkinCancerFragment.newInstance(mContext) 
                }
                 1 -> { 
                    ListSkinFragment.newInstance(mContext)
                }
                 2 -> { 
                    EditSkinCancerFragment.newInstance(mContext) 
                }
                 3 -> { 
                    DeleteSkinFragment.newInstance(mContext)
                }
                 4 -> { 
                    SearchSkinCancerdatesFragment.newInstance(mContext) 
                }
                 5 -> { 
                    ImageRecognitionFragment.newInstance(mContext) 
                }
                else -> CreateSkinCancerFragment.newInstance(mContext) 
             }
    }
    
    override fun getPageTitle(position: Int): CharSequence {
        return TABTITLES[position]
    }

    override fun getCount(): Int {
        return 6
    }
}
