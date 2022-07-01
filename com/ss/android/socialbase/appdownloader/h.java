package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.c.d;
import com.ss.android.socialbase.downloader.d.d;
import com.ss.android.socialbase.downloader.d.z;
import com.ss.android.socialbase.downloader.downloader.b;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.e.a;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.notification.a;
import java.io.File;

public class h extends d {
  private Context a;
  
  private int b;
  
  private String c;
  
  private String d;
  
  private String e;
  
  private String f;
  
  private a g;
  
  public h(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {
    if (paramContext != null) {
      this.a = paramContext.getApplicationContext();
    } else {
      this.a = b.B();
    } 
    this.b = paramInt;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.f = paramString4;
  }
  
  public h(a parama) {
    this.a = b.B();
    this.g = parama;
  }
  
  public a a() {
    if (this.g == null) {
      Context context = this.a;
      if (context != null)
        return new e(context, this.b, this.c, this.d, this.e, this.f); 
    } 
    return this.g;
  }
  
  public void a(c paramc) {
    if (paramc != null) {
      if (c.c(paramc.y()))
        return; 
      super.a(paramc);
    } 
  }
  
  public void a(c paramc, a parama) {
    if (paramc != null && this.a != null && paramc.af()) {
      if (c.c(paramc.y()))
        return; 
      super.a(paramc, parama);
    } 
  }
  
  public void b(c paramc) {
    if (paramc != null) {
      if (c.c(paramc.y()))
        return; 
      super.b(paramc);
    } 
  }
  
  public void c(c paramc) {
    if (paramc != null) {
      if (c.c(paramc.y()))
        return; 
      super.c(paramc);
    } 
  }
  
  public void d(c paramc) {
    if (paramc != null) {
      if (c.c(paramc.y()))
        return; 
      super.d(paramc);
    } 
  }
  
  public void e(c paramc) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 149
    //   4: aload_0
    //   5: getfield a : Landroid/content/Context;
    //   8: ifnonnull -> 12
    //   11: return
    //   12: aload_1
    //   13: invokevirtual af : ()Z
    //   16: ifeq -> 34
    //   19: aload_1
    //   20: invokevirtual y : ()Ljava/lang/String;
    //   23: invokestatic c : (Ljava/lang/String;)Z
    //   26: ifne -> 34
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial e : (Lcom/ss/android/socialbase/downloader/g/c;)V
    //   34: aload_1
    //   35: invokevirtual u : ()Z
    //   38: istore #4
    //   40: iconst_1
    //   41: istore_3
    //   42: iload #4
    //   44: ifeq -> 54
    //   47: aload_1
    //   48: invokevirtual v : ()Z
    //   51: ifeq -> 88
    //   54: aload_1
    //   55: invokevirtual y : ()Ljava/lang/String;
    //   58: invokestatic b : (Ljava/lang/String;)Z
    //   61: ifne -> 88
    //   64: aload_1
    //   65: invokevirtual ah : ()Ljava/lang/String;
    //   68: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   71: ifne -> 88
    //   74: iload_3
    //   75: istore_2
    //   76: aload_1
    //   77: invokevirtual ah : ()Ljava/lang/String;
    //   80: ldc 'application/vnd.android.package-archive'
    //   82: invokevirtual equals : (Ljava/lang/Object;)Z
    //   85: ifne -> 109
    //   88: iload_3
    //   89: istore_2
    //   90: aload_1
    //   91: invokevirtual g : ()I
    //   94: invokestatic a : (I)Lcom/ss/android/socialbase/downloader/k/a;
    //   97: ldc 'auto_install_when_resume'
    //   99: iconst_0
    //   100: invokevirtual a : (Ljava/lang/String;I)I
    //   103: iconst_1
    //   104: if_icmpeq -> 109
    //   107: iconst_0
    //   108: istore_2
    //   109: iload_2
    //   110: ifeq -> 129
    //   113: aload_0
    //   114: getfield a : Landroid/content/Context;
    //   117: aload_1
    //   118: invokevirtual g : ()I
    //   121: iconst_0
    //   122: invokestatic a : (Landroid/content/Context;IZ)I
    //   125: istore_2
    //   126: goto -> 131
    //   129: iconst_2
    //   130: istore_2
    //   131: invokestatic k : ()Ljava/util/concurrent/ExecutorService;
    //   134: new com/ss/android/socialbase/appdownloader/h$1
    //   137: dup
    //   138: aload_0
    //   139: aload_1
    //   140: iload_2
    //   141: invokespecial <init> : (Lcom/ss/android/socialbase/appdownloader/h;Lcom/ss/android/socialbase/downloader/g/c;I)V
    //   144: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   149: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\appdownloader\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */