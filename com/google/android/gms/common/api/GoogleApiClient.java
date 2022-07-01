package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.internal.zzdh;
import com.google.android.gms.common.api.internal.zzm;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public abstract class GoogleApiClient {
  private static final Set zzfsv = Collections.newSetFromMap(new WeakHashMap<Object, Boolean>());
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public abstract void connect();
  
  public void connect(int paramInt) {
    throw new UnsupportedOperationException();
  }
  
  public abstract void disconnect();
  
  public abstract void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
  
  public Looper getLooper() {
    throw new UnsupportedOperationException();
  }
  
  public abstract boolean isConnected();
  
  public abstract void registerConnectionFailedListener(GoogleApiClient$OnConnectionFailedListener paramGoogleApiClient$OnConnectionFailedListener);
  
  public abstract void unregisterConnectionFailedListener(GoogleApiClient$OnConnectionFailedListener paramGoogleApiClient$OnConnectionFailedListener);
  
  public Api$zze zza(Api$zzc paramApi$zzc) {
    throw new UnsupportedOperationException();
  }
  
  public void zza(zzdh paramzzdh) {
    throw new UnsupportedOperationException();
  }
  
  public void zzb(zzdh paramzzdh) {
    throw new UnsupportedOperationException();
  }
  
  public zzm zze(zzm paramzzm) {
    throw new UnsupportedOperationException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\GoogleApiClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */