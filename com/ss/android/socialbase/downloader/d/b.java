package com.ss.android.socialbase.downloader.d;

import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.f.a;
import com.ss.android.socialbase.downloader.g.c;

public abstract class b implements w {
  private static final String a = b.class.getSimpleName();
  
  public void a(c paramc) {
    if (a.a() && paramc != null) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" onPrepare -- ");
      stringBuilder.append(paramc.h());
      a.b(str, stringBuilder.toString());
    } 
  }
  
  public void a(c paramc, a parama) {
    if (a.a() && paramc != null) {
      String str1;
      String str2 = a;
      String str3 = paramc.h();
      if (parama != null) {
        str1 = parama.b();
      } else {
        str1 = "unkown";
      } 
      a.b(str2, String.format("onFailed on %s because of : %s", new Object[] { str3, str1 }));
    } 
  }
  
  public void b(c paramc) {
    if (a.a() && paramc != null) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" onStart -- ");
      stringBuilder.append(paramc.h());
      a.b(str, stringBuilder.toString());
    } 
  }
  
  public void b(c paramc, a parama) {
    if (a.a() && paramc != null) {
      String str1;
      String str2 = a;
      String str3 = paramc.h();
      if (parama != null) {
        str1 = parama.b();
      } else {
        str1 = "unkown";
      } 
      a.b(str2, String.format("onRetry on %s because of : %s", new Object[] { str3, str1 }));
    } 
  }
  
  public void c(c paramc) {
    if (a.a() && paramc != null && paramc.ab() != 0L) {
      int i = (int)((float)paramc.Z() / (float)paramc.ab() * 100.0F);
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramc.h());
      stringBuilder.append(" onProgress -- %");
      stringBuilder.append(i);
      a.b(str, stringBuilder.toString());
    } 
  }
  
  public void c(c paramc, a parama) {
    if (a.a() && paramc != null) {
      String str1;
      String str2 = a;
      String str3 = paramc.h();
      if (parama != null) {
        str1 = parama.b();
      } else {
        str1 = "unkown";
      } 
      a.b(str2, String.format("onRetryDelay on %s because of : %s", new Object[] { str3, str1 }));
    } 
  }
  
  public void d(c paramc) {
    if (a.a() && paramc != null) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" onPause -- ");
      stringBuilder.append(paramc.h());
      a.b(str, stringBuilder.toString());
    } 
  }
  
  public void e(c paramc) {
    if (a.a() && paramc != null) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" onSuccessed -- ");
      stringBuilder.append(paramc.h());
      a.b(str, stringBuilder.toString());
    } 
  }
  
  public void f(c paramc) {
    if (a.a() && paramc != null) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" onCanceled -- ");
      stringBuilder.append(paramc.h());
      a.b(str, stringBuilder.toString());
    } 
  }
  
  public void g(c paramc) {
    if (a.a() && paramc != null) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" onFirstStart -- ");
      stringBuilder.append(paramc.h());
      a.b(str, stringBuilder.toString());
    } 
  }
  
  public void h(c paramc) {
    if (a.a() && paramc != null) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" onFirstSuccess -- ");
      stringBuilder.append(paramc.h());
      a.b(str, stringBuilder.toString());
    } 
  }
  
  public void i(c paramc) {
    if (a.a() && paramc != null) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" onIntercept -- ");
      stringBuilder.append(paramc.h());
      a.b(str, stringBuilder.toString());
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */