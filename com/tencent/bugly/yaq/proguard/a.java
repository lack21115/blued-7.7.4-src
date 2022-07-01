package com.tencent.bugly.yaq.proguard;

import android.content.Context;
import com.tencent.bugly.yaq.crashreport.biz.UserInfoBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class a {
  protected HashMap<String, HashMap<String, byte[]>> a;
  
  protected String b;
  
  i c;
  
  private HashMap<String, Object> d;
  
  a() {
    new HashMap<Object, Object>();
    throw new VerifyError("bad dex opcode");
  }
  
  public static ag a(int paramInt) {
    return (ag)((paramInt == 1) ? new af() : ((paramInt == 3) ? new ae() : null));
  }
  
  public static am a(Context paramContext, int paramInt, byte[] paramArrayOfbyte) {
    com.tencent.bugly.yaq.crashreport.common.info.a.b();
    com.tencent.bugly.yaq.crashreport.common.strategy.a.a();
    throw new VerifyError("bad dex opcode");
  }
  
  public static an a(byte[] paramArrayOfbyte, boolean paramBoolean) {
    if (paramArrayOfbyte != null)
      try {
        new d();
        throw new VerifyError("bad dex opcode");
      } catch (Throwable throwable) {
        if (!x.b(throwable))
          throw new VerifyError("bad dex opcode"); 
      }  
    return null;
  }
  
  public static aq a(UserInfoBean paramUserInfoBean) {
    if (paramUserInfoBean == null)
      return null; 
    new aq();
    throw new VerifyError("bad dex opcode");
  }
  
  public static ar a(List<UserInfoBean> paramList, int paramInt) {
    if (paramList == null || paramList.size() == 0)
      return null; 
    if (com.tencent.bugly.yaq.crashreport.common.info.a.b() == null)
      return null; 
    throw new VerifyError("bad dex opcode");
  }
  
  public static <T extends k> T a(byte[] paramArrayOfbyte, Class<T> paramClass) {
    if (paramArrayOfbyte == null || paramArrayOfbyte.length <= 0)
      return null; 
    try {
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.b(throwable))
        throw new VerifyError("bad dex opcode"); 
      return null;
    } 
  }
  
  public static String a(ArrayList<String> paramArrayList) {
    new StringBuffer();
    throw new VerifyError("bad dex opcode");
  }
  
  private void a(ArrayList<String> paramArrayList, Object paramObject) {
    throw new VerifyError("bad dex opcode");
  }
  
  public static byte[] a(k paramk) {
    try {
      new j();
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.b(throwable))
        throw new VerifyError("bad dex opcode"); 
      return null;
    } 
  }
  
  public static byte[] a(Object paramObject) {
    try {
      new d();
      throw new VerifyError("bad dex opcode");
    } catch (Throwable throwable) {
      if (!x.b(throwable))
        throw new VerifyError("bad dex opcode"); 
      return null;
    } 
  }
  
  public void a(String paramString) {
    throw new VerifyError("bad dex opcode");
  }
  
  public <T> void a(String paramString, T paramT) {
    if (paramString == null)
      throw new IllegalArgumentException("put key can not is null"); 
    if (paramT == null)
      throw new IllegalArgumentException("put value can not is null"); 
    if (paramT instanceof java.util.Set)
      throw new IllegalArgumentException("can not support Set"); 
    new j();
    throw new VerifyError("bad dex opcode");
  }
  
  public void a(byte[] paramArrayOfbyte) {
    throw new VerifyError("bad dex opcode");
  }
  
  public byte[] a() {
    new j(0);
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\tencent\bugly\yaq\proguard\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */