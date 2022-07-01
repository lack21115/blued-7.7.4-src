package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.zzf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

final class zzar extends zzay {
  private final Map zzfxv;
  
  public zzar(zzao paramzzao, Map paramMap) {
    super(paramzzao, (byte)0);
    this.zzfxv = paramMap;
  }
  
  private final int zza(Api.zze paramzze, Map<Api.zze, Integer> paramMap) {
    byte b;
    zzbq.checkNotNull(paramzze);
    zzbq.checkNotNull(paramMap);
    if (!paramzze.zzahn())
      return 0; 
    if (paramMap.containsKey(paramzze))
      return ((Integer)paramMap.get(paramzze)).intValue(); 
    Iterator<Api.zze> iterator = paramMap.keySet().iterator();
    if (iterator.hasNext()) {
      b = ((Integer)paramMap.get(iterator.next())).intValue();
    } else {
      b = -1;
    } 
    int i = b;
    if (b == -1)
      i = zzf.zzc(this.zzfxt.mContext, paramzze.zzahq()); 
    paramMap.put(paramzze, Integer.valueOf(i));
    return i;
  }
  
  public final void zzajj() {
    ConnectionResult connectionResult;
    ArrayList<Api.zze> arrayList1 = new ArrayList();
    ArrayList<Api.zze> arrayList2 = new ArrayList();
    for (Api.zze zze : this.zzfxv.keySet()) {
      if (zze.zzahn() && !((zzaq)this.zzfxv.get(zze)).zzfvo) {
        arrayList1.add(zze);
        continue;
      } 
      arrayList2.add(zze);
    } 
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>(this.zzfxv.size());
    int i = -1;
    boolean bool = arrayList1.isEmpty();
    int k = 0;
    int j = 0;
    if (bool) {
      arrayList1 = arrayList2;
      int m = arrayList1.size();
      while (j < m) {
        arrayList2 = (ArrayList<Api.zze>)arrayList1.get(j);
        j++;
        k = zza((Api.zze)arrayList2, hashMap);
        i = k;
        if (k == 0) {
          i = k;
          break;
        } 
      } 
    } else {
      arrayList1 = arrayList1;
      int m = arrayList1.size();
      j = k;
      while (j < m) {
        arrayList2 = (ArrayList<Api.zze>)arrayList1.get(j);
        j++;
        k = zza((Api.zze)arrayList2, hashMap);
        i = k;
        if (k != 0) {
          i = k;
          break;
        } 
      } 
    } 
    if (i != 0) {
      connectionResult = new ConnectionResult(i, null);
      this.zzfxt.zzfxd.zza(new zzas(this, this.zzfxt, connectionResult));
      return;
    } 
    if (this.zzfxt.zzfxn)
      this.zzfxt.zzfxl.connect(); 
    for (Api.zze zze : this.zzfxv.keySet()) {
      zzj zzj = (zzj)this.zzfxv.get(zze);
      if (zze.zzahn() && zza(zze, (Map)connectionResult) != 0) {
        this.zzfxt.zzfxd.zza(new zzat(this.zzfxt, zzj));
        continue;
      } 
      zze.zza(zzj);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\internal\zzar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */