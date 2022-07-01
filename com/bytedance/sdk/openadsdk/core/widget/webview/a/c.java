package com.bytedance.sdk.openadsdk.core.widget.webview.a;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.openadsdk.core.d.p;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.a.a;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.multipro.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class c {
  private static volatile c a;
  
  private Set<String> b = Collections.synchronizedSet(new HashSet<String>());
  
  private LruCache<String, p> c = new LruCache<String, p>(this, 524288) {
      protected int a(String param1String, p param1p) {
        int i = 0;
        byte b = 0;
        if (param1p != null) {
          int j = b;
          if (!TextUtils.isEmpty(param1p.b()))
            try {
              j = (param1p.b().getBytes()).length;
            } finally {
              Exception exception = null;
            }  
          i = j;
          if (!TextUtils.isEmpty(param1p.c()))
            try {
              i = (param1p.c().getBytes()).length;
            } finally {
              Exception exception = null;
            }  
          j = i;
          if (!TextUtils.isEmpty(param1p.a()))
            try {
              j = (param1p.a().getBytes()).length;
            } finally {
              Exception exception = null;
            }  
          i = j;
          if (!TextUtils.isEmpty(param1p.d()))
            try {
              i = (param1p.d().getBytes()).length;
            } finally {
              Exception exception = null;
            }  
          j = i;
          if (!TextUtils.isEmpty(param1p.f()))
            try {
              j = (param1p.f().getBytes()).length;
            } finally {
              Exception exception = null;
            }  
          i = j;
          if (!TextUtils.isEmpty(param1p.e()))
            try {
              i = (param1p.e().getBytes()).length;
            } finally {
              Exception exception = null;
            }  
        } 
        return (i > 0) ? i : super.sizeOf(param1String, param1p);
      }
    };
  
  public static c a() {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/core/widget/webview/a/c.a : Lcom/bytedance/sdk/openadsdk/core/widget/webview/a/c;
    //   3: ifnonnull -> 37
    //   6: ldc com/bytedance/sdk/openadsdk/core/widget/webview/a/c
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/core/widget/webview/a/c.a : Lcom/bytedance/sdk/openadsdk/core/widget/webview/a/c;
    //   12: ifnonnull -> 25
    //   15: new com/bytedance/sdk/openadsdk/core/widget/webview/a/c
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/bytedance/sdk/openadsdk/core/widget/webview/a/c.a : Lcom/bytedance/sdk/openadsdk/core/widget/webview/a/c;
    //   25: ldc com/bytedance/sdk/openadsdk/core/widget/webview/a/c
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/bytedance/sdk/openadsdk/core/widget/webview/a/c
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/bytedance/sdk/openadsdk/core/widget/webview/a/c.a : Lcom/bytedance/sdk/openadsdk/core/widget/webview/a/c;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static String c() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("CREATE TABLE IF NOT EXISTS ");
    stringBuilder.append("template_diff");
    stringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT,");
    stringBuilder.append("rit");
    stringBuilder.append(" TEXT ,");
    stringBuilder.append("id");
    stringBuilder.append(" TEXT UNIQUE,");
    stringBuilder.append("md5");
    stringBuilder.append(" TEXT ,");
    stringBuilder.append("url");
    stringBuilder.append(" TEXT , ");
    stringBuilder.append("data");
    stringBuilder.append(" TEXT , ");
    stringBuilder.append("version");
    stringBuilder.append(" TEXT");
    stringBuilder.append(")");
    return stringBuilder.toString();
  }
  
  private boolean d() {
    Long long_;
    if (b.b()) {
      long_ = Long.valueOf(a.a("sp_template_delete", "delete_time", 0L));
    } else {
      long_ = Long.valueOf(e().getLong("delete_time", 0L));
    } 
    long l = System.currentTimeMillis();
    if (l - long_.longValue() < 604800000L)
      return false; 
    if (b.b()) {
      a.a("sp_template_delete", "delete_time", Long.valueOf(l));
    } else {
      e().edit().putLong("delete_time", l);
    } 
    return true;
  }
  
  private SharedPreferences e() {
    return o.a().getSharedPreferences("sp_template_delete", 0);
  }
  
  p a(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return null; 
    p p = (p)this.c.get(String.valueOf(paramString));
    if (p != null)
      return p; 
    Cursor cursor = a.a(o.a(), "template_diff", null, "id=?", new String[] { paramString }, null, null, null);
    if (cursor != null)
      try {
        if (cursor.moveToNext()) {
          String str2 = cursor.getString(cursor.getColumnIndex("rit"));
          String str1 = cursor.getString(cursor.getColumnIndex("id"));
          String str3 = cursor.getString(cursor.getColumnIndex("md5"));
          String str4 = cursor.getString(cursor.getColumnIndex("url"));
          String str5 = cursor.getString(cursor.getColumnIndex("data"));
          String str6 = cursor.getString(cursor.getColumnIndex("version"));
          p p1 = (new p()).a(str2).b(str1).c(str3).d(str4).e(str5).f(str6);
          this.c.put(str1, p1);
          this.b.add(str1);
          return p1;
        } 
      } finally {
        if (cursor != null)
          cursor.close(); 
      }  
    return null;
  }
  
  void a(p paramp) {
    boolean bool;
    if (TextUtils.isEmpty(paramp.b()))
      return; 
    Cursor cursor = a.a(o.a(), "template_diff", null, "id=?", new String[] { paramp.b() }, null, null, null);
    if (cursor != null && cursor.getCount() > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    if (cursor != null)
      try {
        cursor.close();
      } finally {} 
    ContentValues contentValues = new ContentValues();
    contentValues.put("rit", paramp.a());
    contentValues.put("id", paramp.b());
    contentValues.put("md5", paramp.c());
    contentValues.put("url", paramp.d());
    contentValues.put("data", paramp.e());
    contentValues.put("version", paramp.f());
    if (bool) {
      a.a(o.a(), "template_diff", contentValues, "id=?", new String[] { paramp.b() });
    } else {
      a.a(o.a(), "template_diff", contentValues);
    } 
    this.c.put(paramp.b(), paramp);
    this.b.add(paramp.b());
  }
  
  void a(Set<String> paramSet) {
    if (paramSet != null && !paramSet.isEmpty()) {
      if (!d())
        return; 
      ArrayList<String> arrayList = new ArrayList();
      for (String str : this.b) {
        if (!paramSet.contains(str))
          arrayList.add(str); 
      } 
      if (arrayList.size() > 0)
        a.a(o.a(), "template_diff", "id=?", arrayList.<String>toArray(new String[0])); 
    } 
  }
  
  List<p> b() {
    ArrayList<p> arrayList = new ArrayList();
    Cursor cursor = a.a(o.a(), "template_diff", null, null, null, null, null, null);
    if (cursor != null)
      try {
        while (cursor.moveToNext()) {
          String str1 = cursor.getString(cursor.getColumnIndex("rit"));
          String str2 = cursor.getString(cursor.getColumnIndex("id"));
          String str3 = cursor.getString(cursor.getColumnIndex("md5"));
          String str4 = cursor.getString(cursor.getColumnIndex("url"));
          String str5 = cursor.getString(cursor.getColumnIndex("data"));
          String str6 = cursor.getString(cursor.getColumnIndex("version"));
          arrayList.add((new p()).a(str1).b(str2).c(str3).d(str4).e(str5).f(str6));
          this.c.put(str2, arrayList.get(arrayList.size() - 1));
          this.b.add(str2);
        } 
      } finally {
        if (cursor != null)
          cursor.close(); 
      }  
    return arrayList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\widget\webview\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */