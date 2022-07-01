package com.ss.android.socialbase.downloader.i.a;

import com.ss.android.socialbase.downloader.g.e;
import com.ss.android.socialbase.downloader.m.f;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class a {
  protected int a = 3;
  
  private final Map<String, c> b = new HashMap<String, c>();
  
  private final Map<String, d> c = new LinkedHashMap<String, d>(3);
  
  private a() {}
  
  public static a a() {
    return a.a();
  }
  
  public c a(String paramString, List<e> paramList) {
    synchronized (this.b) {
      c c = this.b.remove(paramString);
      if (c != null) {
        if (f.a(c.f(), paramList)) {
          try {
            c.a();
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
          } 
          if (c.e() && c.d())
            return c; 
        } 
        try {
          c.c();
        } finally {}
      } 
      return null;
    } 
  }
  
  void a(int paramInt) {
    this.a = paramInt;
  }
  
  public d b(String paramString, List<e> paramList) {
    synchronized (this.c) {
      d d = this.c.remove(paramString);
      if (d != null) {
        if (f.a(d.f(), paramList)) {
          try {
            d.e();
          } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
          } 
          if (d.h() && d.g())
            return d; 
        } 
        try {
          d.d();
        } finally {}
      } 
      return null;
    } 
  }
  
  static final class a {
    private static final a a = new a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\i\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */