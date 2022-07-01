package com.tencent.bugly.yaq.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.yaq.BuglyStrategy;
import com.tencent.bugly.yaq.crashreport.common.info.a;
import com.tencent.bugly.yaq.crashreport.common.strategy.a;
import com.tencent.bugly.yaq.proguard.aj;
import com.tencent.bugly.yaq.proguard.ak;
import com.tencent.bugly.yaq.proguard.o;
import com.tencent.bugly.yaq.proguard.p;
import com.tencent.bugly.yaq.proguard.t;
import com.tencent.bugly.yaq.proguard.u;
import com.tencent.bugly.yaq.proguard.x;
import com.tencent.bugly.yaq.proguard.z;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b {
  private static int a = 0;
  
  private Context b;
  
  private u c;
  
  private p d;
  
  private a e;
  
  private o f;
  
  private BuglyStrategy.a g;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public b(int paramInt, Context paramContext, u paramu, p paramp, a parama, BuglyStrategy.a parama1, o paramo) {
    a = paramInt;
    throw new VerifyError("bad dex opcode");
  }
  
  private static CrashDetailBean a(Cursor paramCursor) {
    if (paramCursor == null)
      return null; 
    try {
      byte[] arrayOfByte = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
      if (arrayOfByte == null)
        return null; 
      paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      CrashDetailBean crashDetailBean2 = (CrashDetailBean)z.a(arrayOfByte, CrashDetailBean.CREATOR);
      CrashDetailBean crashDetailBean1 = crashDetailBean2;
      if (crashDetailBean2 != null)
        throw new VerifyError("bad dex opcode"); 
      return crashDetailBean1;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return null;
    } 
  }
  
  private CrashDetailBean a(List<a> paramList, CrashDetailBean paramCrashDetailBean) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 13
    //   4: aload_1
    //   5: invokeinterface size : ()I
    //   10: ifne -> 15
    //   13: aload_2
    //   14: areturn
    //   15: aconst_null
    //   16: astore_2
    //   17: new java/util/ArrayList
    //   20: dup
    //   21: bipush #10
    //   23: invokespecial <init> : (I)V
    //   26: astore #4
    //   28: aload_1
    //   29: invokeinterface iterator : ()Ljava/util/Iterator;
    //   34: astore #5
    //   36: aload #5
    //   38: invokeinterface hasNext : ()Z
    //   43: ifeq -> 67
    //   46: aload #5
    //   48: invokeinterface next : ()Ljava/lang/Object;
    //   53: checkcast com/tencent/bugly/yaq/crashreport/crash/a
    //   56: astore_1
    //   57: new java/lang/VerifyError
    //   60: dup
    //   61: ldc 'bad dex opcode'
    //   63: invokespecial <init> : (Ljava/lang/String;)V
    //   66: athrow
    //   67: aload #4
    //   69: invokeinterface size : ()I
    //   74: ifle -> 214
    //   77: aload_0
    //   78: aload #4
    //   80: invokespecial b : (Ljava/util/List;)Ljava/util/List;
    //   83: astore #4
    //   85: aload #4
    //   87: ifnull -> 214
    //   90: aload #4
    //   92: invokeinterface size : ()I
    //   97: ifle -> 214
    //   100: aload #4
    //   102: invokestatic sort : (Ljava/util/List;)V
    //   105: iconst_0
    //   106: istore_3
    //   107: iload_3
    //   108: aload #4
    //   110: invokeinterface size : ()I
    //   115: if_icmpge -> 151
    //   118: aload #4
    //   120: iload_3
    //   121: invokeinterface get : (I)Ljava/lang/Object;
    //   126: checkcast com/tencent/bugly/yaq/crashreport/crash/CrashDetailBean
    //   129: astore_2
    //   130: iload_3
    //   131: ifne -> 141
    //   134: iload_3
    //   135: iconst_1
    //   136: iadd
    //   137: istore_3
    //   138: goto -> 107
    //   141: new java/lang/VerifyError
    //   144: dup
    //   145: ldc 'bad dex opcode'
    //   147: invokespecial <init> : (Ljava/lang/String;)V
    //   150: athrow
    //   151: aload_2
    //   152: ifnonnull -> 211
    //   155: new java/lang/VerifyError
    //   158: dup
    //   159: ldc 'bad dex opcode'
    //   161: invokespecial <init> : (Ljava/lang/String;)V
    //   164: athrow
    //   165: aload_1
    //   166: invokeinterface iterator : ()Ljava/util/Iterator;
    //   171: astore_1
    //   172: aload_1
    //   173: invokeinterface hasNext : ()Z
    //   178: ifeq -> 201
    //   181: aload_1
    //   182: invokeinterface next : ()Ljava/lang/Object;
    //   187: checkcast com/tencent/bugly/yaq/crashreport/crash/a
    //   190: astore_1
    //   191: new java/lang/VerifyError
    //   194: dup
    //   195: ldc 'bad dex opcode'
    //   197: invokespecial <init> : (Ljava/lang/String;)V
    //   200: athrow
    //   201: new java/lang/VerifyError
    //   204: dup
    //   205: ldc 'bad dex opcode'
    //   207: invokespecial <init> : (Ljava/lang/String;)V
    //   210: athrow
    //   211: goto -> 165
    //   214: aconst_null
    //   215: astore_2
    //   216: goto -> 151
  }
  
  private static aj a(String paramString1, Context paramContext, String paramString2) {
    if (paramString2 == null || paramContext == null) {
      x.d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
      return null;
    } 
    x.c("zip %s", new Object[] { paramString2 });
    new File(paramString2);
    throw new VerifyError("bad dex opcode");
  }
  
  private static ak a(Context paramContext, CrashDetailBean paramCrashDetailBean, a parama) {
    if (paramContext == null || paramCrashDetailBean == null || parama == null) {
      x.d("enExp args == null", new Object[0]);
      return null;
    } 
    new ak();
    throw new VerifyError("bad dex opcode");
  }
  
  private static List<a> a(List<a> paramList) {
    if (paramList == null || paramList.size() == 0)
      return null; 
    System.currentTimeMillis();
    ArrayList<a> arrayList = new ArrayList();
    Iterator<a> iterator = paramList.iterator();
    if (iterator.hasNext()) {
      a a1 = iterator.next();
      throw new VerifyError("bad dex opcode");
    } 
    return arrayList;
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, CrashDetailBean paramCrashDetailBean) {
    if (a.b() == null)
      throw new VerifyError("bad dex opcode"); 
    x.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
    x.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
    Object[] arrayOfObject = new Object[1];
    throw new VerifyError("bad dex opcode");
  }
  
  public static void a(boolean paramBoolean, List<CrashDetailBean> paramList) {
    if (paramList != null && paramList.size() > 0) {
      Object[] arrayOfObject;
      CrashDetailBean crashDetailBean;
      x.c("up finish update state %b", new Object[] { Boolean.valueOf(paramBoolean) });
      Iterator<CrashDetailBean> iterator = paramList.iterator();
      if (iterator.hasNext()) {
        crashDetailBean = iterator.next();
        arrayOfObject = new Object[4];
        throw new VerifyError("bad dex opcode");
      } 
      iterator = arrayOfObject.iterator();
      if (iterator.hasNext()) {
        crashDetailBean = iterator.next();
        c.a();
        throw new VerifyError("bad dex opcode");
      } 
      x.c("update state size %d", new Object[] { Integer.valueOf(crashDetailBean.size()) });
    } 
    if (!paramBoolean)
      x.b("[crash] upload fail.", new Object[0]); 
    throw new VerifyError("bad dex opcode");
  }
  
  private static a b(Cursor paramCursor) {
    if (paramCursor != null)
      try {
        new a();
        paramCursor.getLong(paramCursor.getColumnIndex("_id"));
        throw new VerifyError("bad dex opcode");
      } catch (Throwable throwable) {} 
    return null;
  }
  
  private List<a> b() {
    ArrayList<a> arrayList = new ArrayList();
    try {
      p.a();
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      try {
        if (!x.a(throwable))
          throw new VerifyError("bad dex opcode"); 
        if (false)
          throw new NullPointerException(); 
        return arrayList;
      } finally {}
    } finally {}
    if (false)
      throw new NullPointerException(); 
    throw arrayList;
  }
  
  private List<CrashDetailBean> b(List<a> paramList) {
    if (paramList == null || paramList.size() == 0)
      return null; 
    new StringBuilder();
    Iterator<a> iterator = paramList.iterator();
    if (iterator.hasNext()) {
      a a1 = iterator.next();
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  private static void c(List<a> paramList) {
    if (paramList == null || paramList.size() == 0)
      throw new VerifyError("bad dex opcode"); 
    new StringBuilder();
    Iterator<a> iterator = paramList.iterator();
    if (iterator.hasNext()) {
      a a1 = iterator.next();
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  private static void d(List<CrashDetailBean> paramList) {
    if (paramList != null)
      try {
        if (paramList.size() != 0) {
          new StringBuilder();
          Iterator<CrashDetailBean> iterator = paramList.iterator();
          if (iterator.hasNext()) {
            CrashDetailBean crashDetailBean = iterator.next();
            throw new VerifyError("bad dex opcode");
          } 
          throw new VerifyError("bad dex opcode");
        } 
      } catch (Throwable throwable) {} 
    throw new VerifyError("bad dex opcode");
  }
  
  private static ContentValues e(CrashDetailBean paramCrashDetailBean) {
    if (paramCrashDetailBean != null)
      try {
        new ContentValues();
        throw new VerifyError("bad dex opcode");
      } catch (Throwable throwable) {} 
    return null;
  }
  
  public final List<CrashDetailBean> a() {
    a.a();
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(CrashDetailBean paramCrashDetailBean, long paramLong, boolean paramBoolean) {
    if (c.l) {
      x.a("try to upload right now", new Object[0]);
      (new ArrayList<CrashDetailBean>()).add(paramCrashDetailBean);
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(List<CrashDetailBean> paramList, long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final boolean a(CrashDetailBean paramCrashDetailBean) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final boolean a(CrashDetailBean paramCrashDetailBean, int paramInt) {
    if (paramCrashDetailBean == null)
      return true; 
    if (c.n != null) {
      String str = c.n;
      throw new VerifyError("bad dex opcode");
    } 
    if (c.o != null) {
      String str = c.o;
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public final void b(CrashDetailBean paramCrashDetailBean) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void c(CrashDetailBean paramCrashDetailBean) {
    if (paramCrashDetailBean == null)
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
  
  public final void d(CrashDetailBean paramCrashDetailBean) {
    if (paramCrashDetailBean != null && e(paramCrashDetailBean) != null) {
      p.a();
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\crash\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */