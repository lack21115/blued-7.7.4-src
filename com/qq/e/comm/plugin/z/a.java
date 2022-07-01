package com.qq.e.comm.plugin.z;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class a {
  private Map<String, List<String>> a = new HashMap<String, List<String>>();
  
  public a(String paramString) {
    if (!TextUtils.isEmpty(paramString))
      try {
        JSONObject jSONObject = new JSONObject(paramString);
        Iterator<String> iterator = jSONObject.keys();
        while (iterator.hasNext()) {
          String str = iterator.next();
          JSONArray jSONArray = jSONObject.optJSONArray(str);
          if (jSONArray != null) {
            ArrayList<String> arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++)
              arrayList.add(jSONArray.getString(i)); 
            this.a.put(str, arrayList);
          } 
        } 
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      }  
  }
  
  public List<String> a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   12: checkcast java/util/List
    //   15: astore_2
    //   16: aload_2
    //   17: astore_1
    //   18: aload_2
    //   19: ifnonnull -> 30
    //   22: new java/util/ArrayList
    //   25: dup
    //   26: invokespecial <init> : ()V
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: areturn
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	34	finally
    //   22	30	34	finally
  }
  
  public boolean a(String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual a : (Ljava/lang/String;)Ljava/util/List;
    //   7: astore #5
    //   9: aload #5
    //   11: astore #4
    //   13: aload #5
    //   15: ifnonnull -> 27
    //   18: new java/util/ArrayList
    //   21: dup
    //   22: invokespecial <init> : ()V
    //   25: astore #4
    //   27: aload #4
    //   29: aload_2
    //   30: invokeinterface contains : (Ljava/lang/Object;)Z
    //   35: ifne -> 74
    //   38: aload #4
    //   40: aload_2
    //   41: invokeinterface add : (Ljava/lang/Object;)Z
    //   46: pop
    //   47: iconst_1
    //   48: istore_3
    //   49: goto -> 52
    //   52: aload_0
    //   53: getfield a : Ljava/util/Map;
    //   56: aload_1
    //   57: aload #4
    //   59: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   64: pop
    //   65: aload_0
    //   66: monitorexit
    //   67: iload_3
    //   68: ireturn
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    //   74: iconst_0
    //   75: istore_3
    //   76: goto -> 52
    // Exception table:
    //   from	to	target	type
    //   2	9	69	finally
    //   18	27	69	finally
    //   27	47	69	finally
    //   52	65	69	finally
  }
  
  public String toString() {
    return (new JSONObject(this.a)).toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\z\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */