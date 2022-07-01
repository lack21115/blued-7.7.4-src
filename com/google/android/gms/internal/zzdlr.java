package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamite.DynamiteModule;

public final class zzdlr extends zzdlc {
  private final zzdls zzlie;
  
  public zzdlr(Context paramContext, zzdls paramzzdls) {
    super(paramContext, "TextNativeHandle");
    this.zzlie = paramzzdls;
    zzblo();
  }
  
  public final zzdll[] zza(Bitmap paramBitmap, zzdld paramzzdld, zzdln paramzzdln) {
    if (!isOperational())
      return new zzdll[0]; 
    try {
      IObjectWrapper iObjectWrapper = zzn.zzz(paramBitmap);
      return ((zzdlh)zzblo()).zza(iObjectWrapper, paramzzdld, paramzzdln);
    } catch (RemoteException remoteException) {
      Log.e("TextNativeHandle", "Error calling native text recognizer", (Throwable)remoteException);
      return new zzdll[0];
    } 
  }
  
  protected final void zzbll() {
    ((zzdlh)zzblo()).zzblp();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzdlr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */