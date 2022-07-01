package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class zzd extends zzn {
  private int zza;
  
  protected zzd(byte[] paramArrayOfbyte) {
    boolean bool;
    if (paramArrayOfbyte.length == 25) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool);
    this.zza = Arrays.hashCode(paramArrayOfbyte);
  }
  
  protected static byte[] zza(String paramString) {
    try {
      return paramString.getBytes("ISO-8859-1");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new AssertionError(unsupportedEncodingException);
    } 
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject != null) {
      if (!(paramObject instanceof com.google.android.gms.common.internal.zzl))
        return false; 
      try {
        paramObject = paramObject;
        if (paramObject.zzc() != hashCode())
          return false; 
        paramObject = paramObject.zzb();
        if (paramObject == null)
          return false; 
        paramObject = ObjectWrapper.unwrap((IObjectWrapper)paramObject);
        return Arrays.equals(zza(), (byte[])paramObject);
      } catch (RemoteException remoteException) {
        Log.e("GoogleCertificates", "Failed to get Google certificates from remote", (Throwable)remoteException);
      } 
    } 
    return false;
  }
  
  public int hashCode() {
    return this.zza;
  }
  
  abstract byte[] zza();
  
  public final IObjectWrapper zzb() {
    return ObjectWrapper.wrap(zza());
  }
  
  public final int zzc() {
    return hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */