package com.ss.android.downloadlib.a.a;

import android.text.TextUtils;
import com.ss.android.downloadlib.a.b.a;
import com.ss.android.downloadlib.a.j;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

class b {
  CopyOnWriteArrayList<a> a(String paramString1, String paramString2) {
    CopyOnWriteArrayList<a> copyOnWriteArrayList = new CopyOnWriteArrayList();
    try {
      paramString1 = j.a().getSharedPreferences(paramString1, 0).getString(paramString2, "");
      if (!TextUtils.isEmpty(paramString1)) {
        JSONObject jSONObject = new JSONObject(paramString1);
        Iterator<String> iterator = jSONObject.keys();
        while (iterator.hasNext()) {
          a a = a.a(jSONObject.optJSONObject(iterator.next()));
          if (a != null)
            copyOnWriteArrayList.add(a); 
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    return copyOnWriteArrayList;
  }
  
  void a(String paramString1, String paramString2, CopyOnWriteArrayList<a> paramCopyOnWriteArrayList) {
    if (paramCopyOnWriteArrayList == null)
      return; 
    JSONObject jSONObject = new JSONObject();
    try {
      for (a a : paramCopyOnWriteArrayList) {
        if (a != null)
          jSONObject.put(String.valueOf(a.b), a.b()); 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    j.a().getSharedPreferences(paramString1, 0).edit().putString(paramString2, jSONObject.toString()).apply();
  }
  
  void b(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2))
        return; 
      j.a().getSharedPreferences(paramString1, 0).edit().putString(paramString2, "").apply();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */