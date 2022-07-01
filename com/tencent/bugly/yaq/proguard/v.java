package com.tencent.bugly.yaq.proguard;

import android.content.Context;
import com.tencent.bugly.yaq.crashreport.common.info.a;
import com.tencent.bugly.yaq.crashreport.common.strategy.a;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadFactory;

public final class v implements Runnable {
  private int a;
  
  private int b;
  
  private final Context c;
  
  private final int d;
  
  private final byte[] e;
  
  private final a f;
  
  private final a g;
  
  private final s h;
  
  private final u i;
  
  private final int j;
  
  private final t k;
  
  private final t l;
  
  private String m;
  
  private final String n;
  
  private final Map<String, String> o;
  
  private int p;
  
  private long q;
  
  private long r;
  
  private boolean s;
  
  private boolean t;
  
  public v(Context paramContext, int paramInt1, int paramInt2, byte[] paramArrayOfbyte, String paramString1, String paramString2, t paramt, boolean paramBoolean1, int paramInt3, int paramInt4, boolean paramBoolean2, Map<String, String> paramMap) {
    throw new VerifyError("bad dex opcode");
  }
  
  public v(Context paramContext, int paramInt1, int paramInt2, byte[] paramArrayOfbyte, String paramString1, String paramString2, t paramt, boolean paramBoolean1, boolean paramBoolean2) {
    this(paramContext, paramInt1, paramInt2, paramArrayOfbyte, paramString1, paramString2, paramt, paramBoolean1, 2, 30000, paramBoolean2, null);
  }
  
  private static String a(String paramString) {
    if (z.a(paramString))
      return paramString; 
    try {
      (new Object[2])[0] = paramString;
      UUID.randomUUID();
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      x.a(throwable);
      return paramString;
    } 
  }
  
  private void a(an paraman, boolean paramBoolean, int paramInt1, String paramString, int paramInt2) {
    throw new VerifyError("bad dex opcode");
  }
  
  private static boolean a(an paraman, a parama, a parama1) {
    if (paraman == null) {
      x.d("resp == null!", new Object[0]);
      return false;
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public final void a(long paramLong) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void b(long paramLong) {
    throw new VerifyError("bad dex opcode");
  }
  
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */