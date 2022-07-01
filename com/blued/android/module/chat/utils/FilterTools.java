package com.blued.android.module.chat.utils;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.chat.model.SessionSetting;

public class FilterTools {
  private static String TAG = "@@@ module_chat_FilterTools";
  
  public static boolean checkCondition(SessionSetting paramSessionSetting, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramSessionSetting != null) {
      boolean bool3;
      boolean bool4;
      boolean bool5;
      if (AppInfo.m())
        Logger.b(TAG, new Object[] { paramSessionSetting.toString() }); 
      if (!paramBoolean1 || paramSessionSetting.getInitiator() == 1) {
        bool3 = true;
      } else {
        bool3 = false;
      } 
      if (!paramBoolean2 || paramSessionSetting.getFollower() == 1) {
        bool4 = true;
      } else {
        bool4 = false;
      } 
      if (!paramBoolean3 || paramSessionSetting.getNearby() == 1) {
        bool5 = true;
      } else {
        bool5 = false;
      } 
      bool1 = bool2;
      if (bool3) {
        bool1 = bool2;
        if (bool4) {
          bool1 = bool2;
          if (bool5)
            bool1 = true; 
        } 
      } 
    } 
    return bool1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\cha\\utils\FilterTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */