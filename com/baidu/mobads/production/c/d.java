package com.baidu.mobads.production.c;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobad.feeds.ArticleInfo;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.vo.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class d extends d {
  private HashMap<String, String> a;
  
  public d(Context paramContext, Activity paramActivity, IXAdConstants4PDK.SlotType paramSlotType) {
    super(paramContext, paramActivity, paramSlotType);
    a("androidfeed");
  }
  
  private String e(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      String[] arrayOfString = ArticleInfo.PREDEFINED_KEYS;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j) {
        if (!arrayOfString[i].equals(paramString)) {
          if ("mpt".equals(paramString))
            return paramString; 
          i++;
          continue;
        } 
        return paramString;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("c_");
    stringBuilder.append(paramString);
    return stringBuilder.toString();
  }
  
  public HashMap<String, String> a() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (this.j) {
      hashMap.put("fet", "ANTI,MSSP,VIDEO,NMON,HTML");
    } else {
      hashMap.put("fet", "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
    } 
    HashMap<String, String> hashMap1 = this.a;
    if (hashMap1 != null && !hashMap1.isEmpty())
      hashMap.putAll(this.a); 
    return (HashMap)hashMap;
  }
  
  protected void a(Map<String, String> paramMap) {
    HashMap<String, String> hashMap = this.a;
    if (hashMap == null) {
      this.a = new HashMap<String, String>();
    } else {
      hashMap.clear();
    } 
    if (paramMap != null && !paramMap.isEmpty()) {
      Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
      while (true) {
        if (iterator.hasNext()) {
          Map.Entry entry = iterator.next();
          try {
            String str1 = e(((String)entry.getKey()).trim());
            String str2 = ((String)entry.getValue()).trim();
            this.a.put(str1, str2);
          } finally {}
          continue;
        } 
        return;
      } 
    } 
  }
  
  public String b() {
    return super.b();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */