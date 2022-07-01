package com.tencent.tbs.sdk.extension.partner.lzma;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LzmaDec {
  static int gInit = 0;
  
  static boolean gLoadSo = false;
  
  private long LZRef;
  
  private Lock mLock = new ReentrantLock();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public LzmaDec() {
    if (gInit == -1)
      gInit = NInit(); 
  }
  
  private native int NInit();
  
  private native int NOpen(String paramString);
  
  private native int Nclose();
  
  private native int Nextract(String paramString, Object paramObject);
  
  private native int NforceCancel(int paramInt);
  
  private native Object NgetHeader();
  
  public static void loadSo(String paramString) {
    if (!gLoadSo)
      try {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append("libLzmaDec.so");
        System.load(stringBuilder.toString());
        gLoadSo = true;
        gInit = -1;
        return;
      } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
        unsatisfiedLinkError.printStackTrace();
        gLoadSo = false;
        gInit = -2;
      }  
  }
  
  public int Lzma_close() {
    this.mLock.lock();
    NforceCancel(1);
    int i = Nclose();
    this.mLock.unlock();
    gInit = -1;
    return i;
  }
  
  public int Lzma_extract(String paramString, Object paramObject) {
    this.mLock.lock();
    NforceCancel(0);
    int i = Nextract(paramString, paramObject);
    this.mLock.unlock();
    return i;
  }
  
  public int Lzma_forceCancel() {
    return NforceCancel(1);
  }
  
  public Object Lzma_getHeader() {
    return NgetHeader();
  }
  
  public int Lzma_open(String paramString) {
    return (gInit != 0) ? -1 : NOpen(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\sdk\extension\partner\lzma\LzmaDec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */