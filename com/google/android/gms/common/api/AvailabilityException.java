package com.google.android.gms.common.api;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.internal.zzbq;
import java.util.ArrayList;
import java.util.Iterator;

public final class AvailabilityException extends Exception {
  public final ArrayMap zzfse;
  
  public AvailabilityException(ArrayMap paramArrayMap) {
    this.zzfse = paramArrayMap;
  }
  
  public final ConnectionResult getConnectionResult(GoogleApi paramGoogleApi) {
    boolean bool;
    zzh zzh = paramGoogleApi.zzfsn;
    if (this.zzfse.get(zzh) != null) {
      bool = true;
    } else {
      bool = false;
    } 
    zzbq.checkArgument(bool, "The given API was not part of the availability request.");
    return (ConnectionResult)this.zzfse.get(zzh);
  }
  
  public final String getMessage() {
    String str;
    ArrayList<String> arrayList = new ArrayList();
    Iterator<zzh> iterator = this.zzfse.keySet().iterator();
    boolean bool = true;
    while (iterator.hasNext()) {
      zzh zzh = iterator.next();
      ConnectionResult connectionResult = (ConnectionResult)this.zzfse.get(zzh);
      if (connectionResult.isSuccess())
        bool = false; 
      String str1 = zzh.zzfop.mName;
      String str2 = String.valueOf(connectionResult);
      StringBuilder stringBuilder1 = new StringBuilder(String.valueOf(str1).length() + 2 + String.valueOf(str2).length());
      stringBuilder1.append(str1);
      stringBuilder1.append(": ");
      stringBuilder1.append(str2);
      arrayList.add(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    if (bool) {
      str = "None of the queried APIs are available. ";
    } else {
      str = "Some of the queried APIs are unavailable. ";
    } 
    stringBuilder.append(str);
    stringBuilder.append(TextUtils.join("; ", arrayList));
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\api\AvailabilityException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */