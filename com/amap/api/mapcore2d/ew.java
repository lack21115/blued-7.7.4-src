package com.amap.api.mapcore2d;

import android.text.TextUtils;
import java.net.Proxy;
import java.util.Map;

public abstract class ew {
  int c = 20000;
  
  int d = 20000;
  
  Proxy e = null;
  
  public final void a(int paramInt) {
    this.c = paramInt;
  }
  
  public final void a(Proxy paramProxy) {
    this.e = paramProxy;
  }
  
  public byte[] a_() {
    return null;
  }
  
  public final void b(int paramInt) {
    this.d = paramInt;
  }
  
  public abstract Map<String, String> f();
  
  public abstract Map<String, String> g();
  
  public abstract String h();
  
  String l() {
    byte[] arrayOfByte = a_();
    if (arrayOfByte == null || arrayOfByte.length == 0)
      return h(); 
    Map<String, String> map = g();
    if (map == null)
      return h(); 
    String str = eu.a(map);
    StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(h());
    stringBuffer.append("?");
    stringBuffer.append(str);
    return stringBuffer.toString();
  }
  
  protected String m() {
    return "";
  }
  
  protected boolean n() {
    return TextUtils.isEmpty(m()) ^ true;
  }
  
  public boolean o() {
    return false;
  }
  
  byte[] p() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual a_ : ()[B
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull -> 16
    //   9: aload_2
    //   10: astore_1
    //   11: aload_2
    //   12: arraylength
    //   13: ifne -> 38
    //   16: aload_0
    //   17: invokevirtual g : ()Ljava/util/Map;
    //   20: invokestatic a : (Ljava/util/Map;)Ljava/lang/String;
    //   23: astore_3
    //   24: aload_2
    //   25: astore_1
    //   26: aload_3
    //   27: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   30: ifne -> 38
    //   33: aload_3
    //   34: invokestatic a : (Ljava/lang/String;)[B
    //   37: astore_1
    //   38: aload_1
    //   39: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */