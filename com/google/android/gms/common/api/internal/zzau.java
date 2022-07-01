package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

final class zzau extends zzay {
  private final ArrayList zzfxz;
  
  public zzau(zzao paramzzao, ArrayList paramArrayList) {
    super(paramzzao, (byte)0);
    this.zzfxz = paramArrayList;
  }
  
  public final void zzajj() {
    Set<?> set;
    zzba zzba = this.zzfxt.zzfxd.zzfvq;
    zzao zzao1 = this.zzfxt;
    if (zzao1.zzfwf == null) {
      set = Collections.emptySet();
    } else {
      set = new HashSet(zzao1.zzfwf.zzfsw);
      Map map = zzao1.zzfwf.zzgfr;
      for (Api api : map.keySet()) {
        if (!zzao1.zzfxd.zzfyy.containsKey(api.zzahm()))
          set.addAll(((zzt)map.get(api)).zzenh); 
      } 
    } 
    zzba.zzfyk = set;
    ArrayList<zzba> arrayList = this.zzfxz;
    int j = arrayList.size();
    int i = 0;
    while (i < j) {
      zzba = arrayList.get(i);
      i++;
      ((Api.zze)zzba).zza(this.zzfxt.zzfxp, this.zzfxt.zzfxd.zzfvq.zzfyk);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */