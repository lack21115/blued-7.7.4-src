package com.tencent.bugly.yaq.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.yaq.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.yaq.crashreport.crash.b;
import com.tencent.bugly.yaq.crashreport.crash.c;
import com.tencent.bugly.yaq.proguard.x;
import java.util.Map;

public final class a implements NativeExceptionHandler {
  private final Context a;
  
  private final b b;
  
  private final com.tencent.bugly.yaq.crashreport.common.info.a c;
  
  private final com.tencent.bugly.yaq.crashreport.common.strategy.a d;
  
  public a(Context paramContext, com.tencent.bugly.yaq.crashreport.common.info.a parama, b paramb, com.tencent.bugly.yaq.crashreport.common.strategy.a parama1) {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void handleNativeException(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7) {
    x.a("Native Crash Happen v1", new Object[0]);
    throw new VerifyError("bad dex opcode");
  }
  
  public final void handleNativeException2(int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt3, String paramString5, int paramInt4, int paramInt5, int paramInt6, String paramString6, String paramString7, String[] paramArrayOfString) {
    x.a("Native Crash Happen v2", new Object[0]);
    try {
      b.a(paramString3);
      if (paramInt3 > 0) {
        new StringBuilder();
        throw new VerifyError("bad dex opcode");
      } 
      if (paramInt4 > 0)
        throw new VerifyError("bad dex opcode"); 
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.a(throwable))
        throw new VerifyError("bad dex opcode"); 
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  public final CrashDetailBean packageCrashDatas(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, byte[] paramArrayOfbyte, Map<String, String> paramMap, boolean paramBoolean1, boolean paramBoolean2) {
    c.a();
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\crashreport\crash\jni\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */