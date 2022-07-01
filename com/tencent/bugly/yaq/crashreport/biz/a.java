package com.tencent.bugly.yaq.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.yaq.proguard.p;
import com.tencent.bugly.yaq.proguard.t;
import com.tencent.bugly.yaq.proguard.w;
import com.tencent.bugly.yaq.proguard.x;
import com.tencent.bugly.yaq.proguard.z;
import java.util.List;

public final class a {
  private Context a;
  
  private long b;
  
  private int c;
  
  private boolean d;
  
  public a(Context paramContext, boolean paramBoolean) {
    throw new VerifyError("bad dex opcode");
  }
  
  private static ContentValues a(UserInfoBean paramUserInfoBean) {
    if (paramUserInfoBean != null)
      try {
        new ContentValues();
        throw new VerifyError("bad dex opcode");
      } catch (Throwable throwable) {} 
    return null;
  }
  
  private static UserInfoBean a(Cursor paramCursor) {
    if (paramCursor == null)
      return null; 
    try {
      byte[] arrayOfByte = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
      if (arrayOfByte == null)
        return null; 
      paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      UserInfoBean userInfoBean2 = (UserInfoBean)z.a(arrayOfByte, UserInfoBean.CREATOR);
      UserInfoBean userInfoBean1 = userInfoBean2;
      if (userInfoBean2 != null)
        throw new VerifyError("bad dex opcode"); 
      return userInfoBean1;
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      return null;
    } 
  }
  
  private static void a(List<UserInfoBean> paramList) {
    if (paramList == null || paramList.size() == 0)
      throw new VerifyError("bad dex opcode"); 
    new StringBuilder();
    if (paramList.size() < 0 && 50 < 0) {
      UserInfoBean userInfoBean = paramList.get(0);
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  private void c() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/VerifyError
    //   5: dup
    //   6: ldc 'bad dex opcode'
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: athrow
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_1
    //   16: athrow
    // Exception table:
    //   from	to	target	type
    //   2	12	12	finally
  }
  
  public final List<UserInfoBean> a(String paramString) {
    try {
      if (z.a(paramString)) {
        p.a();
        throw new VerifyError("bad dex opcode");
      } 
      new StringBuilder("_pc = '");
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      try {
        if (!x.a(throwable))
          throw new VerifyError("bad dex opcode"); 
        if (false)
          throw new NullPointerException(); 
        return null;
      } finally {}
    } finally {}
    if (false)
      throw new NullPointerException(); 
    throw paramString;
  }
  
  public final void a() {
    z.b();
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(int paramInt, boolean paramBoolean, long paramLong) {
    if (com.tencent.bugly.yaq.crashreport.common.strategy.a.a() != null)
      throw new VerifyError("bad dex opcode"); 
    if (paramInt == 1 || paramInt == 3)
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
  
  public final void b() {
    if (w.a() != null) {
      new Runnable(this) {
          public final void run() {
            try {
              throw new VerifyError("bad dex opcode");
            } catch (Throwable throwable) {
              x.a(throwable);
              throw new VerifyError("bad dex opcode");
            } 
          }
        };
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  final class a implements Runnable {
    private boolean a;
    
    private UserInfoBean b;
    
    public a(a this$0, UserInfoBean param1UserInfoBean, boolean param1Boolean) {}
    
    public final void run() {
      try {
        throw new VerifyError("bad dex opcode");
      } catch (Throwable throwable) {
        if (!x.a(throwable))
          throw new VerifyError("bad dex opcode"); 
        throw new VerifyError("bad dex opcode");
      } 
    }
  }
  
  final class b implements Runnable {
    b(a this$0) {}
    
    public final void run() {
      System.currentTimeMillis();
      throw new VerifyError("bad dex opcode");
    }
  }
  
  final class c implements Runnable {
    private long a;
    
    public c(a this$0, long param1Long) {}
    
    public final void run() {
      throw new VerifyError("bad dex opcode");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\biz\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */