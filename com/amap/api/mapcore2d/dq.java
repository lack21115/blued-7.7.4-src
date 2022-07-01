package com.amap.api.mapcore2d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dq {
  public static byte[] a;
  
  public static byte[] b;
  
  public static String c;
  
  private static HashSet<String> d = new HashSet<String>();
  
  private static final String f;
  
  private File[] e;
  
  static {
    a = "FDF1F436161AEF5B".getBytes();
    b = "0102030405060708".getBytes();
    c = "SOCRASH";
    f = c;
  }
  
  private static String a() {
    return cx.b("SO_DYNAMIC_FILE_KEY");
  }
  
  private static void a(Context paramContext, a parama) throws JSONException {
    if (!TextUtils.isEmpty(parama.b()) && !TextUtils.isEmpty(parama.c()) && !TextUtils.isEmpty(parama.d())) {
      String str = a();
      int i = 0;
      SharedPreferences sharedPreferences = paramContext.getSharedPreferences(str, 0);
      JSONArray jSONArray = new JSONArray(db.a(co.b(db.e(sharedPreferences.getString("SO_ERROR_KEY", "")))));
      while (i < jSONArray.length()) {
        JSONObject jSONObject1 = jSONArray.getJSONObject(i);
        if (jSONObject1.opt("mk").equals(parama.a()) && jSONObject1.opt("ak").equals(parama.b()) && jSONObject1.opt("bk").equals(parama.c()) && jSONObject1.opt("ik").equals(parama.d()) && jSONObject1.opt("nk").equals(parama.e()))
          return; 
        i++;
      } 
      JSONObject jSONObject = new JSONObject();
      jSONObject.putOpt("mk", parama.a());
      jSONObject.putOpt("ak", parama.b());
      jSONObject.putOpt("bk", parama.c());
      jSONObject.putOpt("ik", parama.d());
      jSONObject.putOpt("nk", parama.e());
      jSONArray.put(jSONObject);
      SharedPreferences.Editor editor = sharedPreferences.edit();
      editor.putString("SO_ERROR_KEY", db.g(co.a(db.a(jSONArray.toString()))));
      editor.commit();
    } 
  }
  
  private void a(Context paramContext, byte[] paramArrayOfbyte) {
    String str2;
    boolean bool;
    if (paramContext == null)
      return; 
    try {
      str2 = new String(paramArrayOfbyte, "ISO-8859-1");
      i = str2.indexOf("{\"");
    } finally {
      paramContext = null;
      paramContext.printStackTrace();
    } 
    if (i == 0)
      return; 
    JSONObject jSONObject = new JSONObject(str2.substring(str2.indexOf("{\""), str2.lastIndexOf("\"}") + 2));
    String str3 = jSONObject.optString("ik");
    String str1 = jSONObject.optString("jk");
    if (TextUtils.isEmpty(str1))
      return; 
    List<a> list = a.b(str3);
    int i = bool;
    if (list == null)
      return; 
    while (i < list.size()) {
      a a = list.get(i);
      if (str1.contains(a.e()))
        a(paramContext, a); 
      i++;
    } 
  }
  
  private void a(File paramFile) {
    if (paramFile == null)
      return; 
    try {
      paramFile.delete();
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private boolean a(List<b> paramList, String paramString) {
    if (paramList == null)
      return false; 
    for (b b : paramList) {
      if (b.a(b).equals(paramString)) {
        b.a(b, b.b(b) + 1);
        return true;
      } 
    } 
    return false;
  }
  
  private boolean a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
    if (paramArrayOfbyte1 != null) {
      if (paramArrayOfbyte1.length == 0)
        return false; 
      if (paramArrayOfbyte2 != null) {
        if (paramArrayOfbyte2.length == 0)
          return false; 
        if (paramArrayOfbyte1.length != paramArrayOfbyte2.length)
          return false; 
        for (int i = 0; i < paramArrayOfbyte1.length; i++) {
          if (paramArrayOfbyte1[i] != paramArrayOfbyte2[i])
            return false; 
        } 
        return true;
      } 
    } 
    return false;
  }
  
  private byte[] b(File paramFile) {
    try {
      FileInputStream fileInputStream = new FileInputStream(paramFile);
      byte[] arrayOfByte2 = new byte[fileInputStream.available()];
      fileInputStream.read(arrayOfByte2);
      fileInputStream.close();
      byte[] arrayOfByte1 = cv.a("a1f5886b7153004c5c99559f5261676f".getBytes(), arrayOfByte2, "nFy1THrhajaZzz8U".getBytes());
      arrayOfByte2 = new byte[16];
      byte[] arrayOfByte3 = new byte[arrayOfByte1.length - 16];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, 16);
      return !a(cx.a(arrayOfByte3, "MD5"), arrayOfByte2) ? new byte[0] : arrayOfByte3;
    } finally {
      paramFile = null;
    } 
  }
  
  private File[] b(Context paramContext) {
    File file = new File(dm.a(paramContext));
    return !file.isDirectory() ? null : file.listFiles();
  }
  
  void a(Context paramContext) {
    try {
      File[] arrayOfFile = b(paramContext);
      if (arrayOfFile == null)
        return; 
      this.e = arrayOfFile;
      da da = null;
      int i = 0;
      try {
        da da1 = (new da.a(f, "1.0", "")).a(new String[0]).a();
        da = da1;
      } finally {
        Exception exception;
      } 
      ArrayList<b> arrayList = new ArrayList();
      return;
    } finally {
      paramContext = null;
    } 
  }
  
  static class a {
    private String a;
    
    private String b;
    
    private String c;
    
    private String d;
    
    private String e;
    
    public a() {}
    
    public a(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5) {
      this.a = param1String1;
      this.b = param1String2;
      this.c = param1String3;
      this.d = param1String4;
      this.e = param1String5;
    }
    
    public static a a(String param1String) {
      if (TextUtils.isEmpty(param1String))
        return new a(); 
      try {
        return new a(jSONObject.optString("mk", ""), jSONObject.optString("ak", ""), jSONObject.optString("bk", ""), jSONObject.optString("ik", ""), jSONObject.optString("nk", ""));
      } finally {
        param1String = null;
      } 
    }
    
    public static List<a> b(String param1String) {
      if (TextUtils.isEmpty(param1String))
        return new ArrayList<a>(); 
      ArrayList<a> arrayList = new ArrayList();
      try {
        int i;
        JSONArray jSONArray = new JSONArray(param1String);
      } finally {
        param1String = null;
      } 
      return arrayList;
    }
    
    public String a() {
      return this.a;
    }
    
    public String b() {
      return this.b;
    }
    
    public String c() {
      return this.c;
    }
    
    public String d() {
      return this.d;
    }
    
    public String e() {
      return this.e;
    }
  }
  
  static class b {
    private int a;
    
    private String b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\dq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */