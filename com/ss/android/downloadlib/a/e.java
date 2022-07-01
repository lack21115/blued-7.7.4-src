package com.ss.android.downloadlib.a;

import android.text.TextUtils;
import com.ss.android.downloadlib.e.g;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.i.h;
import java.util.ArrayList;
import org.json.JSONObject;

public class e {
  private static b a;
  
  public static h a(JSONObject paramJSONObject) {
    return (paramJSONObject != null && paramJSONObject.has("download_chunk_config") && !com.ss.android.socialbase.downloader.k.a.f("download_chunk_config")) ? c(paramJSONObject) : null;
  }
  
  public static i a(String paramString) {
    if (a == null)
      a = new b(j.i()); 
    return new a(a, paramString);
  }
  
  public static i a(String paramString, JSONObject paramJSONObject) {
    return (paramJSONObject != null && paramJSONObject.has("download_chunk_config") && !com.ss.android.socialbase.downloader.k.a.f("download_chunk_config")) ? b(paramJSONObject) : a(paramString);
  }
  
  public static i b(JSONObject paramJSONObject) {
    return new b(paramJSONObject);
  }
  
  public static h c(JSONObject paramJSONObject) {
    return new c(paramJSONObject);
  }
  
  static class a implements i {
    private final String a;
    
    private e.b b;
    
    public a(e.b param1b, String param1String) {
      this.b = param1b;
      this.a = param1String;
    }
    
    public int a(long param1Long) {
      if (g.c(this.a)) {
        e.b b1 = this.b;
        if (b1 != null)
          return b1.a(param1Long); 
      } 
      return 1;
    }
  }
  
  static class b implements i {
    private int a;
    
    private ArrayList<int[]> b = (ArrayList)new ArrayList<int>();
    
    public b(JSONObject param1JSONObject) {
      a(param1JSONObject);
    }
    
    private int a(int param1Int) {
      for (int j = 0; j < this.b.size(); j++) {
        int[] arrayOfInt = this.b.get(j);
        if (param1Int >= arrayOfInt[1] && param1Int < arrayOfInt[2])
          return arrayOfInt[0]; 
      } 
      return 1;
    }
    
    private void a(JSONObject param1JSONObject) {
      this.a = param1JSONObject.optInt("is_open_exp", 0);
      b(param1JSONObject);
    }
    
    private void b(JSONObject param1JSONObject) {
      if (param1JSONObject != null) {
        if (!param1JSONObject.has("download_chunk_config"))
          return; 
        String str = param1JSONObject.opt("download_chunk_config").toString();
        if (TextUtils.isEmpty(str))
          return; 
        param1JSONObject = null;
        try {
          JSONObject jSONObject = new JSONObject(str);
          param1JSONObject = jSONObject;
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        if (param1JSONObject == null)
          return; 
        String[] arrayOfString = new String[5];
        String[][] arrayOfString1 = new String[5][];
        arrayOfString[1] = param1JSONObject.optString("download_chunk_1");
        arrayOfString[2] = param1JSONObject.optString("download_chunk_2");
        arrayOfString[3] = param1JSONObject.optString("download_chunk_3");
        arrayOfString[4] = param1JSONObject.optString("download_chunk_4");
        for (int j = 1; j < 5; j++) {
          if (!TextUtils.isEmpty(arrayOfString[j])) {
            arrayOfString1[j] = arrayOfString[j].split(",");
            for (int k = 0; k < (arrayOfString1[j]).length - 1; k += 2) {
              this.b.add(new int[] { j, Integer.parseInt(arrayOfString1[j][k]), Integer.parseInt(arrayOfString1[j][k + 1]) });
            } 
          } 
        } 
      } 
    }
    
    public int a(long param1Long) {
      return (a() && b(param1Long)) ? a((int)(param1Long / 1048576L)) : 1;
    }
    
    public boolean a() {
      int j = this.a;
      boolean bool = true;
      if (j != 1) {
        if (j == 3)
          return true; 
        bool = false;
      } 
      return bool;
    }
    
    protected boolean b(long param1Long) {
      return true;
    }
  }
  
  static class c implements h {
    private int a;
    
    private ArrayList<int[]> b = (ArrayList)new ArrayList<int>();
    
    public c(JSONObject param1JSONObject) {
      a(param1JSONObject);
    }
    
    private void a(JSONObject param1JSONObject) {
      this.a = param1JSONObject.optInt("is_open_exp", 0);
      b(param1JSONObject);
    }
    
    private int b(int param1Int, h param1h) {
      int[] arrayOfInt;
      if (this.b.size() < 5)
        return param1Int; 
      h h1 = null;
      int i = e.null.a[param1h.ordinal()];
      if (i != 1) {
        if (i != 2) {
          if (i != 3) {
            if (i != 4) {
              if (i != 5) {
                param1h = h1;
              } else {
                arrayOfInt = this.b.get(4);
              } 
            } else {
              arrayOfInt = this.b.get(3);
            } 
          } else {
            arrayOfInt = this.b.get(2);
          } 
        } else {
          arrayOfInt = this.b.get(1);
        } 
      } else {
        arrayOfInt = this.b.get(0);
      } 
      i = param1Int;
      if (arrayOfInt != null) {
        if (arrayOfInt.length < 2)
          return param1Int; 
        i = arrayOfInt[0];
        if (i != 1) {
          if (i != 2) {
            if (i == 3)
              param1Int = arrayOfInt[1]; 
          } else {
            param1Int -= arrayOfInt[1];
          } 
        } else {
          param1Int += arrayOfInt[1];
        } 
        if (param1Int > 1)
          return param1Int; 
        i = 1;
      } 
      return i;
    }
    
    private void b(JSONObject param1JSONObject) {
      if (param1JSONObject != null) {
        if (!param1JSONObject.has("download_chunk_config"))
          return; 
        String str2 = param1JSONObject.opt("download_chunk_config").toString();
        if (TextUtils.isEmpty(str2))
          return; 
        param1JSONObject = null;
        try {
          JSONObject jSONObject = new JSONObject(str2);
          param1JSONObject = jSONObject;
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        if (param1JSONObject == null)
          return; 
        str2 = param1JSONObject.optString("network_quality_operation");
        String str1 = param1JSONObject.optString("network_quality_operand");
        if (!TextUtils.isEmpty(str2)) {
          if (TextUtils.isEmpty(str1))
            return; 
          String[] arrayOfString2 = str2.split(",");
          String[] arrayOfString1 = str1.split(",");
          if (arrayOfString2.length >= 5) {
            if (arrayOfString1.length < 5)
              return; 
            for (int i = 0; i < 5; i++) {
              this.b.add(new int[] { Integer.parseInt(arrayOfString2[i]), Integer.parseInt(arrayOfString1[i]) });
            } 
          } 
        } 
      } 
    }
    
    public int a(int param1Int, h param1h) {
      int i = param1Int;
      if (a())
        i = b(param1Int, param1h); 
      return i;
    }
    
    boolean a() {
      int i = this.a;
      return (i == 2 || i == 3);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */