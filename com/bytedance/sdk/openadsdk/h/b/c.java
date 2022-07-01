package com.bytedance.sdk.openadsdk.h.b;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c {
  private static volatile c b;
  
  private final SparseArray<Map<String, a>> a = new SparseArray(2);
  
  private final d c;
  
  private final Executor d = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
  
  private volatile SQLiteStatement e;
  
  private c(Context paramContext) {
    this.c = new d(paramContext.getApplicationContext());
    this.a.put(0, new ConcurrentHashMap<Object, Object>());
    this.a.put(1, new ConcurrentHashMap<Object, Object>());
  }
  
  public static c a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/bytedance/sdk/openadsdk/h/b/c.b : Lcom/bytedance/sdk/openadsdk/h/b/c;
    //   3: ifnonnull -> 38
    //   6: ldc com/bytedance/sdk/openadsdk/h/b/c
    //   8: monitorenter
    //   9: getstatic com/bytedance/sdk/openadsdk/h/b/c.b : Lcom/bytedance/sdk/openadsdk/h/b/c;
    //   12: ifnonnull -> 26
    //   15: new com/bytedance/sdk/openadsdk/h/b/c
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/bytedance/sdk/openadsdk/h/b/c.b : Lcom/bytedance/sdk/openadsdk/h/b/c;
    //   26: ldc com/bytedance/sdk/openadsdk/h/b/c
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/bytedance/sdk/openadsdk/h/b/c
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/bytedance/sdk/openadsdk/h/b/c.b : Lcom/bytedance/sdk/openadsdk/h/b/c;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private String b(int paramInt) {
    if (paramInt <= 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder(paramInt << 1);
    stringBuilder.append("?");
    for (int i = 1; i < paramInt; i++)
      stringBuilder.append(",?"); 
    return stringBuilder.toString();
  }
  
  public a a(String paramString, int paramInt) {
    a a;
    if (TextUtils.isEmpty(paramString))
      return null; 
    Map<String, a> map = (Map)this.a.get(paramInt);
    if (map == null) {
      a = null;
    } else {
      a = (a)map.get(paramString);
    } 
    if (a != null)
      return a; 
    try {
      Cursor cursor = this.c.getReadableDatabase().query("video_http_header_t", null, "key=? AND flag=?", new String[] { paramString, String.valueOf(paramInt) }, null, null, null, "1");
      a a1 = a;
      if (cursor != null) {
        a1 = a;
        if (cursor.getCount() > 0) {
          a1 = a;
          if (cursor.moveToNext())
            a1 = new a(cursor.getString(cursor.getColumnIndex("key")), cursor.getString(cursor.getColumnIndex("mime")), cursor.getInt(cursor.getColumnIndex("contentLength")), paramInt, cursor.getString(cursor.getColumnIndex("extra"))); 
        } 
        cursor.close();
      } 
      return a1;
    } finally {
      paramString = null;
    } 
  }
  
  public void a(int paramInt) {
    Map map = (Map)this.a.get(paramInt);
    if (map != null)
      map.clear(); 
    this.d.execute(new Runnable(this, paramInt) {
          public void run() {
            try {
              return;
            } finally {
              Exception exception = null;
            } 
          }
        });
  }
  
  public void a(a parama) {
    if (parama != null) {
      Map<String, a> map = (Map)this.a.get(parama.d);
      if (map != null)
        map.put(parama.a, parama); 
      this.d.execute(new Runnable(this, parama) {
            public void run() {
              try {
                if (c.a(this.b) == null) {
                  c.a(this.b, c.b(this.b).getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)"));
                } else {
                  c.a(this.b).clearBindings();
                } 
                c.a(this.b).bindString(1, this.a.a);
                c.a(this.b).bindString(2, this.a.b);
                c.a(this.b).bindLong(3, this.a.c);
                c.a(this.b).bindLong(4, this.a.d);
                c.a(this.b).bindString(5, this.a.e);
                return;
              } finally {
                Exception exception = null;
              } 
            }
          });
    } 
  }
  
  public void a(Collection<String> paramCollection, int paramInt) {
    if (paramCollection != null && !paramCollection.isEmpty()) {
      String[] arrayOfString = new String[paramCollection.size() + 1];
      int i = -1;
      Map map = (Map)this.a.get(paramInt);
      for (String str : paramCollection) {
        if (map != null)
          map.remove(str); 
        arrayOfString[++i] = str;
      } 
      arrayOfString[i + 1] = String.valueOf(paramInt);
      try {
        SQLiteDatabase sQLiteDatabase = this.c.getWritableDatabase();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("key IN(");
        stringBuilder.append(b(arrayOfString.length));
        stringBuilder.append(") AND ");
        stringBuilder.append("flag");
        stringBuilder.append("=?");
        return;
      } finally {
        paramCollection = null;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */