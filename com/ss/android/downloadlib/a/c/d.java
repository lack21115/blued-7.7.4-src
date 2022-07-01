package com.ss.android.downloadlib.a.c;

import android.text.TextUtils;
import android.util.LongSparseArray;
import com.ss.android.downloadad.a.b.a;
import com.ss.android.downloadlib.a.j;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.k.a;
import java.io.File;
import java.util.HashMap;

public class d {
  private static volatile d a;
  
  private long b = 0L;
  
  private LongSparseArray<String> c = new LongSparseArray();
  
  private HashMap<String, Integer> d = new HashMap<String, Integer>();
  
  public static d a() {
    // Byte code:
    //   0: getstatic com/ss/android/downloadlib/a/c/d.a : Lcom/ss/android/downloadlib/a/c/d;
    //   3: ifnonnull -> 37
    //   6: ldc com/ss/android/downloadlib/a/c/d
    //   8: monitorenter
    //   9: getstatic com/ss/android/downloadlib/a/c/d.a : Lcom/ss/android/downloadlib/a/c/d;
    //   12: ifnonnull -> 25
    //   15: new com/ss/android/downloadlib/a/c/d
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ss/android/downloadlib/a/c/d.a : Lcom/ss/android/downloadlib/a/c/d;
    //   25: ldc com/ss/android/downloadlib/a/c/d
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ss/android/downloadlib/a/c/d
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ss/android/downloadlib/a/c/d.a : Lcom/ss/android/downloadlib/a/c/d;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public static void a(a parama) {
    if (parama != null) {
      if (parama.a() <= 0L)
        return; 
      c c = f.a(j.a()).h(parama.k());
      if (c == null)
        return; 
      a(c);
    } 
  }
  
  public static void a(c paramc) {
    if (paramc == null)
      return; 
    if (a.a(paramc.g()).a("delete_file_after_install", 0) == 0)
      return; 
    try {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramc.k());
      stringBuilder.append(File.separator);
      stringBuilder.append(paramc.h());
      String str = stringBuilder.toString();
      if (TextUtils.isEmpty(str))
        return; 
      File file = new File(str);
      if (file.isFile() && file.exists()) {
        file.delete();
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public void a(String paramString) {
    int i = b(paramString);
    this.d.put(paramString, Integer.valueOf(i + 1));
  }
  
  public int b(String paramString) {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 0;
    if (bool)
      return 0; 
    if (this.d == null)
      this.d = new HashMap<String, Integer>(); 
    if (this.d.containsKey(paramString))
      i = ((Integer)this.d.get(paramString)).intValue(); 
    return i;
  }
  
  public LongSparseArray<String> b() {
    return this.c;
  }
  
  long c() {
    return this.b;
  }
  
  public boolean c(String paramString) {
    HashMap<String, Integer> hashMap = this.d;
    boolean bool = false;
    if (hashMap != null) {
      byte b;
      if (TextUtils.isEmpty(paramString))
        return false; 
      if (this.d.containsKey(paramString)) {
        b = ((Integer)this.d.get(paramString)).intValue();
      } else {
        b = 0;
      } 
      if (b > 2)
        return false; 
      bool = true;
    } 
    return bool;
  }
  
  void d() {
    this.b = System.currentTimeMillis();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */