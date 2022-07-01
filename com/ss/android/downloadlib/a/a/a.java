package com.ss.android.downloadlib.a.a;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.ss.android.a.a.a.j;
import com.ss.android.a.a.b.c;
import com.ss.android.a.a.c.c;
import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.e.d;
import com.ss.android.downloadlib.e.f;
import com.ss.android.downloadlib.e.g;
import com.ss.android.downloadlib.h;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.g.c;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

public class a {
  private static final String a = a.class.getSimpleName();
  
  private static a b;
  
  private CopyOnWriteArrayList<com.ss.android.downloadlib.a.b.a> c = this.g.a("sp_ad_install_back_dialog", "key_uninstalled_list");
  
  private boolean d = false;
  
  private String e;
  
  private CopyOnWriteArrayList<com.ss.android.downloadlib.a.b.a> f = this.g.a("sp_name_installed_app", "key_installed_list");
  
  private b g = new b();
  
  public static a a() {
    if (b == null)
      b = new a(); 
    return b;
  }
  
  private void a(Context paramContext, com.ss.android.downloadad.a.b.a parama) {
    if (parama == null)
      return; 
    try {
      if (d.b(paramContext, parama.d()).a() != 3) {
        j.d().a(4, paramContext, (c)parama.s(), "应用打开失败，请检查是否安装", null, 1);
        com.ss.android.downloadlib.d.a.a().a("market_openapp_failed", parama);
        return;
      } 
      com.ss.android.downloadlib.d.a.a().a("market_openapp_success", parama);
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  private void a(Context paramContext, com.ss.android.downloadlib.a.b.a parama, a parama1, boolean paramBoolean) {
    String str;
    com.ss.android.downloadad.a.b.a a1 = c.a().d(parama.b);
    if (a1 == null) {
      g.b();
      return;
    } 
    j j = j.d();
    c.a a2 = new c.a(paramContext);
    if (paramBoolean) {
      str = "应用安装确认";
    } else {
      str = "退出确认";
    } 
    a2 = a2.a(str);
    if (TextUtils.isEmpty(parama.e)) {
      str = "刚刚下载的应用";
    } else {
      str = parama.e;
    } 
    a2 = a2.b(String.format("%1$s下载完成，是否立即安装？", new Object[] { str })).c("立即安装");
    if (paramBoolean) {
      str = "暂不安装";
    } else {
      str = String.format("退出%1$s", new Object[] { paramContext.getResources().getString((paramContext.getApplicationContext().getApplicationInfo()).labelRes) });
    } 
    j.b(a2.d(str).a(false).a(g.a(paramContext, parama.g)).a(new c.b(this, a1, paramContext, parama, parama1) {
            public void a(DialogInterface param1DialogInterface) {
              com.ss.android.downloadlib.d.a.a().a("backdialog_install", this.a);
              d.a(this.b, (int)this.c.a);
              param1DialogInterface.dismiss();
            }
            
            public void b(DialogInterface param1DialogInterface) {
              com.ss.android.downloadlib.d.a.a().a("backdialog_exit", this.a);
              a.a a1 = this.d;
              if (a1 != null)
                a1.a(); 
              this.e.b("");
              param1DialogInterface.dismiss();
            }
            
            public void c(DialogInterface param1DialogInterface) {
              this.e.b("");
            }
          }).a(1).a());
    com.ss.android.downloadlib.d.a.a().a("backdialog_show", a1);
    this.e = parama.d;
  }
  
  private boolean a(Context paramContext, com.ss.android.downloadlib.a.b.a parama) {
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("showOpenAppDialog appname:");
    stringBuilder.append(parama.e);
    stringBuilder.append(",pgk:");
    stringBuilder.append(parama.d);
    f.a(str, stringBuilder.toString(), null);
    com.ss.android.downloadad.a.b.a a1 = c.a().d(parama.b);
    if (a1 == null) {
      g.b();
      return true;
    } 
    j j = j.d();
    c.a a2 = (new c.a(paramContext)).a("已安装完成");
    if (TextUtils.isEmpty(parama.e)) {
      str = "刚刚下载的应用";
    } else {
      str = parama.e;
    } 
    j.b(a2.b(String.format("%1$s已安装完成，是否立即打开？", new Object[] { str })).c("打开").d("取消").a(false).a(g.b(paramContext, parama.d)).a(new c.b(this, paramContext, a1) {
            public void a(DialogInterface param1DialogInterface) {
              a.a(this.c, this.a, this.b);
              param1DialogInterface.dismiss();
            }
            
            public void b(DialogInterface param1DialogInterface) {
              com.ss.android.downloadlib.d.a.a().a("market_openapp_cancel", this.b);
              param1DialogInterface.dismiss();
            }
            
            public void c(DialogInterface param1DialogInterface) {}
          }).a(2).a());
    com.ss.android.downloadlib.d.a.a().a("market_openapp_window_show", a1);
    return true;
  }
  
  public c a(Context paramContext) {
    long l = h.a(paramContext).b();
    int i = j.i().optInt("enable_miniapp_dialog", 0);
    c c2 = null;
    c c1 = null;
    if (i == 0)
      return null; 
    List list = f.a(paramContext).b("application/vnd.android.package-archive");
    if (list != null) {
      if (list.isEmpty())
        return null; 
      Iterator<c> iterator = list.iterator();
      long l1 = 0L;
      while (true) {
        c2 = c1;
        if (iterator.hasNext()) {
          c2 = iterator.next();
          if (c2 == null || g.c(paramContext, c2.z()) || !g.a(c2.n()))
            continue; 
          long l2 = (new File(c2.n())).lastModified();
          if (l2 < l || c2.y() == null)
            continue; 
          try {
            boolean bool = (new JSONObject(c2.y())).has("isMiniApp");
            if (bool && (l1 == 0L || l2 > l1)) {
              c1 = c2;
              l1 = l2;
            } 
          } catch (Exception exception) {
            exception.printStackTrace();
          } 
          continue;
        } 
        break;
      } 
    } 
    return (c)exception;
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, String paramString3, String paramString4) {
    int i;
    for (i = 0; i < this.c.size(); i++) {
      com.ss.android.downloadlib.a.b.a a1 = this.c.get(i);
      if (a1 != null && a1.b == paramLong2) {
        this.c.set(i, new com.ss.android.downloadlib.a.b.a(paramLong1, paramLong2, paramLong3, paramString1, paramString2, paramString3, paramString4));
        this.g.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.c);
        return;
      } 
    } 
    this.c.add(new com.ss.android.downloadlib.a.b.a(paramLong1, paramLong2, paramLong3, paramString1, paramString2, paramString3, paramString4));
    this.g.a("sp_ad_install_back_dialog", "key_uninstalled_list", this.c);
  }
  
  public void a(Context paramContext, com.ss.android.downloadlib.a.b.a parama, boolean paramBoolean, a parama1) {
    this.c.clear();
    a(paramContext, parama, parama1, paramBoolean);
    this.d = true;
    h.a(paramContext).c();
    this.g.b("sp_ad_install_back_dialog", "key_uninstalled_list");
    f.a(a, "tryShowInstallDialog isShow:true", null);
  }
  
  public void a(com.ss.android.downloadlib.a.b.a parama) {
    if (parama == null)
      return; 
    for (int i = 0; i < this.f.size(); i++) {
      com.ss.android.downloadlib.a.b.a a1 = this.f.get(i);
      if (a1 != null && a1.b == parama.b)
        return; 
    } 
    this.f.add(parama);
    this.g.a("sp_name_installed_app", "key_installed_list", this.f);
  }
  
  public boolean a(Context paramContext, boolean paramBoolean, a parama) {
    // Byte code:
    //   0: getstatic com/ss/android/downloadlib/a/a/a.a : Ljava/lang/String;
    //   3: astore #8
    //   5: new java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial <init> : ()V
    //   12: astore #9
    //   14: aload #9
    //   16: ldc_w 'tryShowInstallDialog canBackRefresh:'
    //   19: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload #9
    //   25: iload_2
    //   26: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload #8
    //   32: aload #9
    //   34: invokevirtual toString : ()Ljava/lang/String;
    //   37: aconst_null
    //   38: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   41: invokestatic i : ()Lorg/json/JSONObject;
    //   44: ldc_w 'disable_install_app_dialog'
    //   47: invokevirtual optInt : (Ljava/lang/String;)I
    //   50: istore #4
    //   52: iconst_1
    //   53: istore #5
    //   55: iload #4
    //   57: iconst_1
    //   58: if_icmpne -> 63
    //   61: iconst_0
    //   62: ireturn
    //   63: aload_0
    //   64: getfield d : Z
    //   67: ifeq -> 72
    //   70: iconst_0
    //   71: ireturn
    //   72: aload_0
    //   73: aload_1
    //   74: invokevirtual a : (Landroid/content/Context;)Lcom/ss/android/socialbase/downloader/g/c;
    //   77: astore #8
    //   79: aload #8
    //   81: ifnonnull -> 96
    //   84: aload_0
    //   85: getfield c : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   88: invokevirtual isEmpty : ()Z
    //   91: ifeq -> 96
    //   94: iconst_0
    //   95: ireturn
    //   96: aload #8
    //   98: ifnull -> 151
    //   101: aload_0
    //   102: getfield c : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   105: invokevirtual isEmpty : ()Z
    //   108: ifeq -> 151
    //   111: aload_0
    //   112: aload_1
    //   113: new com/ss/android/downloadlib/a/b/a
    //   116: dup
    //   117: aload #8
    //   119: invokevirtual g : ()I
    //   122: i2l
    //   123: lconst_0
    //   124: lconst_0
    //   125: aload #8
    //   127: invokevirtual z : ()Ljava/lang/String;
    //   130: aload #8
    //   132: invokevirtual i : ()Ljava/lang/String;
    //   135: aconst_null
    //   136: aload #8
    //   138: invokevirtual n : ()Ljava/lang/String;
    //   141: invokespecial <init> : (JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   144: iload_2
    //   145: aload_3
    //   146: invokevirtual a : (Landroid/content/Context;Lcom/ss/android/downloadlib/a/b/a;ZLcom/ss/android/downloadlib/a/a/a$a;)V
    //   149: iconst_1
    //   150: ireturn
    //   151: lconst_0
    //   152: lstore #6
    //   154: aload #8
    //   156: ifnull -> 176
    //   159: new java/io/File
    //   162: dup
    //   163: aload #8
    //   165: invokevirtual n : ()Ljava/lang/String;
    //   168: invokespecial <init> : (Ljava/lang/String;)V
    //   171: invokevirtual lastModified : ()J
    //   174: lstore #6
    //   176: aload_0
    //   177: getfield c : Ljava/util/concurrent/CopyOnWriteArrayList;
    //   180: astore #9
    //   182: aload #9
    //   184: aload #9
    //   186: invokevirtual size : ()I
    //   189: invokevirtual listIterator : (I)Ljava/util/ListIterator;
    //   192: astore #9
    //   194: aload #9
    //   196: invokeinterface hasPrevious : ()Z
    //   201: ifeq -> 330
    //   204: aload #9
    //   206: invokeinterface previous : ()Ljava/lang/Object;
    //   211: checkcast com/ss/android/downloadlib/a/b/a
    //   214: astore #10
    //   216: aload #10
    //   218: ifnonnull -> 224
    //   221: goto -> 194
    //   224: aload_1
    //   225: aload #10
    //   227: getfield d : Ljava/lang/String;
    //   230: invokestatic c : (Landroid/content/Context;Ljava/lang/String;)Z
    //   233: ifne -> 194
    //   236: aload #10
    //   238: getfield g : Ljava/lang/String;
    //   241: invokestatic a : (Ljava/lang/String;)Z
    //   244: ifne -> 250
    //   247: goto -> 194
    //   250: new java/io/File
    //   253: dup
    //   254: aload #10
    //   256: getfield g : Ljava/lang/String;
    //   259: invokespecial <init> : (Ljava/lang/String;)V
    //   262: invokevirtual lastModified : ()J
    //   265: lload #6
    //   267: lcmp
    //   268: iflt -> 286
    //   271: aload_0
    //   272: aload_1
    //   273: aload #10
    //   275: iload_2
    //   276: aload_3
    //   277: invokevirtual a : (Landroid/content/Context;Lcom/ss/android/downloadlib/a/b/a;ZLcom/ss/android/downloadlib/a/a/a$a;)V
    //   280: iload #5
    //   282: istore_2
    //   283: goto -> 332
    //   286: aload_0
    //   287: aload_1
    //   288: new com/ss/android/downloadlib/a/b/a
    //   291: dup
    //   292: aload #8
    //   294: invokevirtual g : ()I
    //   297: i2l
    //   298: lconst_0
    //   299: lconst_0
    //   300: aload #8
    //   302: invokevirtual z : ()Ljava/lang/String;
    //   305: aload #8
    //   307: invokevirtual i : ()Ljava/lang/String;
    //   310: aconst_null
    //   311: aload #8
    //   313: invokevirtual n : ()Ljava/lang/String;
    //   316: invokespecial <init> : (JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   319: iload_2
    //   320: aload_3
    //   321: invokevirtual a : (Landroid/content/Context;Lcom/ss/android/downloadlib/a/b/a;ZLcom/ss/android/downloadlib/a/a/a$a;)V
    //   324: iload #5
    //   326: istore_2
    //   327: goto -> 332
    //   330: iconst_0
    //   331: istore_2
    //   332: getstatic com/ss/android/downloadlib/a/a/a.a : Ljava/lang/String;
    //   335: astore_1
    //   336: new java/lang/StringBuilder
    //   339: dup
    //   340: invokespecial <init> : ()V
    //   343: astore_3
    //   344: aload_3
    //   345: ldc_w 'tryShowInstallDialog isShow:'
    //   348: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload_3
    //   353: iload_2
    //   354: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload_1
    //   359: aload_3
    //   360: invokevirtual toString : ()Ljava/lang/String;
    //   363: aconst_null
    //   364: invokestatic a : (Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   367: iload_2
    //   368: ireturn
  }
  
  public boolean a(String paramString) {
    return TextUtils.equals(this.e, paramString);
  }
  
  public void b(Context paramContext) {
    f.a(a, "tryShowOpenAppDialog start", null);
    if (j.i().optInt("disable_open_app_dialog") == 1)
      return; 
    if (paramContext != null) {
      if (this.f.isEmpty())
        return; 
      f.a(a, "tryShowOpenAppDialog next", null);
      CopyOnWriteArrayList<com.ss.android.downloadlib.a.b.a> copyOnWriteArrayList = this.f;
      ListIterator<com.ss.android.downloadlib.a.b.a> listIterator = copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size());
      while (listIterator.hasPrevious()) {
        com.ss.android.downloadlib.a.b.a a1 = listIterator.previous();
        if (System.currentTimeMillis() - a1.h > 3600000L) {
          this.f.clear();
          return;
        } 
        if (!g.c(paramContext, a1.d)) {
          this.f.remove(a1);
          continue;
        } 
        if (a(paramContext, a1)) {
          this.f.clear();
          this.g.b("sp_name_installed_app", "key_installed_list");
          break;
        } 
      } 
    } 
  }
  
  public void b(String paramString) {
    if (TextUtils.isEmpty(paramString)) {
      this.e = "";
      return;
    } 
    if (TextUtils.equals(this.e, paramString))
      this.e = ""; 
  }
  
  public static interface a {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */