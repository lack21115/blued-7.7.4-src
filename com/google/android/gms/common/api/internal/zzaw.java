package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbt;
import com.google.android.gms.internal.zzcyw;

final class zzaw extends zzbj {
  zzaw(zzbh paramzzbh, zzao paramzzao, zzcyw paramzzcyw) {
    super(paramzzbh);
  }
  
  public final void zzajj() {
    zzao zzao1 = this.zzfya;
    zzcyw zzcyw1 = this.zzfyb;
    if (zzao1.zzbs(0)) {
      String str;
      ConnectionResult connectionResult = zzcyw1.zzfuw;
      if (connectionResult.isSuccess()) {
        zzbt zzbt = zzcyw1.zzklz;
        ConnectionResult connectionResult1 = zzbt.zzfuw;
        if (!connectionResult1.isSuccess()) {
          str = String.valueOf(connectionResult1);
          StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 48);
          stringBuilder.append("Sign-in succeeded with resolve account failure: ");
          stringBuilder.append(str);
          Log.wtf("GoogleApiClientConnecting", stringBuilder.toString(), new Exception());
          zzao1.zze(connectionResult1);
          return;
        } 
        zzao1.zzfxo = true;
        zzao1.zzfxp = str.zzamy();
        zzao1.zzfxq = ((zzbt)str).zzfxq;
        zzao1.zzfxr = ((zzbt)str).zzghy;
        zzao1.zzajl();
        return;
      } 
      if (zzao1.zzd((ConnectionResult)str)) {
        zzao1.zzajn();
        zzao1.zzajl();
        return;
      } 
      zzao1.zze((ConnectionResult)str);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */