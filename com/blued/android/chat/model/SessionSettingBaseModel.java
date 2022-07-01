package com.blued.android.chat.model;

import android.text.TextUtils;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.core.utils.Log;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

public abstract class SessionSettingBaseModel {
  private static final String TAG = "Chat_SessionSetting";
  
  private boolean setField(Object paramObject1, String paramString, Object paramObject2) {
    try {
      Field field = paramObject1.getClass().getDeclaredField(paramString);
    } catch (NoSuchFieldException noSuchFieldException) {
      noSuchFieldException = null;
    } 
    Class<?> clazz = paramObject1.getClass().getSuperclass();
    while (true) {
      Field field;
      if (noSuchFieldException == null && clazz != null) {
        try {
          Field field1 = clazz.getDeclaredField(paramString);
          field = field1;
        } catch (NoSuchFieldException noSuchFieldException1) {
          clazz = clazz.getSuperclass();
        } 
        continue;
      } 
      if (field == null)
        return false; 
      field.setAccessible(true);
      try {
        field.set(paramObject1, paramObject2);
        return true;
      } catch (IllegalAccessException illegalAccessException) {
        return false;
      } 
    } 
  }
  
  public abstract void copyValue(SessionSettingBaseModel paramSessionSettingBaseModel);
  
  public abstract int getDBId();
  
  public abstract void setDBId(int paramInt);
  
  public void updateValues(Map<String, Object> paramMap) {
    if (paramMap != null)
      try {
        Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
        while (true) {
          if (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            String str = (String)entry.getKey();
            if (!TextUtils.isEmpty(str)) {
              boolean bool = setField(this, str, entry.getValue());
              if (ChatManager.debug) {
                String str1;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("updateValues() | 更新");
                if (bool) {
                  str1 = "成功";
                } else {
                  str1 = "失败！！！";
                } 
                stringBuilder.append(str1);
                stringBuilder.append(" | ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(entry.getValue());
                Log.v("Chat_SessionSetting", stringBuilder.toString());
              } 
            } 
            continue;
          } 
          return;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\model\SessionSettingBaseModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */