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
import com.google.android.gms.vision.barcode.Barcode;
import java.nio.ByteBuffer;

public final class zzdkx extends zzdlc {
  private final zzdkv zzlgp;
  
  public zzdkx(Context paramContext, zzdkv paramzzdkv) {
    super(paramContext, "BarcodeNativeHandle");
    this.zzlgp = paramzzdkv;
    zzblo();
  }
  
  public final Barcode[] zza(Bitmap paramBitmap, zzdld paramzzdld) {
    if (!isOperational())
      return new Barcode[0]; 
    try {
      IObjectWrapper iObjectWrapper = zzn.zzz(paramBitmap);
      return ((zzdky)zzblo()).zzb(iObjectWrapper, paramzzdld);
    } catch (RemoteException remoteException) {
      Log.e("BarcodeNativeHandle", "Error calling native barcode detector", (Throwable)remoteException);
      return new Barcode[0];
    } 
  }
  
  public final Barcode[] zza(ByteBuffer paramByteBuffer, zzdld paramzzdld) {
    if (!isOperational())
      return new Barcode[0]; 
    try {
      IObjectWrapper iObjectWrapper = zzn.zzz(paramByteBuffer);
      return ((zzdky)zzblo()).zza(iObjectWrapper, paramzzdld);
    } catch (RemoteException remoteException) {
      Log.e("BarcodeNativeHandle", "Error calling native barcode detector", (Throwable)remoteException);
      return new Barcode[0];
    } 
  }
  
  protected final void zzbll() {
    if (isOperational())
      ((zzdky)zzblo()).zzblm(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\internal\zzdkx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */