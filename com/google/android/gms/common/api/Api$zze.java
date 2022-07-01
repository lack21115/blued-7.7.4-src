package com.google.android.gms.common.api;

import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzan;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzp;
import java.io.PrintWriter;
import java.util.Set;

public interface Api$zze extends Api$zzb {
  void disconnect();
  
  void dump$ec96877(String paramString, PrintWriter paramPrintWriter);
  
  Intent getSignInIntent();
  
  boolean isConnected();
  
  boolean isConnecting();
  
  void zza(zzan paramzzan, Set paramSet);
  
  void zza(zzj paramzzj);
  
  void zza(zzp paramzzp);
  
  boolean zzacc();
  
  boolean zzacn();
  
  boolean zzahn();
  
  IBinder zzaho();
  
  String zzahp();
  
  int zzahq();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\Api$zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */