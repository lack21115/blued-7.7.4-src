package com.google.android.gms.vision;

import android.util.SparseArray;

public final class zzc {
  private static final Object sLock = new Object();
  
  private static int zzlgg = 0;
  
  private SparseArray zzlgh = new SparseArray();
  
  private SparseArray zzlgi = new SparseArray();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public final int zzfm(int paramInt) {
    synchronized (sLock) {
      Integer integer = (Integer)this.zzlgh.get(paramInt);
      if (integer != null) {
        paramInt = integer.intValue();
        return paramInt;
      } 
      int i = zzlgg;
      zzlgg++;
      this.zzlgh.append(paramInt, Integer.valueOf(i));
      this.zzlgi.append(i, Integer.valueOf(paramInt));
      return i;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */