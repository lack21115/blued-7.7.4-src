package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class zzbi {
  private final Object zzdht;
  
  private final List zzgho;
  
  private zzbi(Object paramObject) {
    this.zzdht = zzbq.checkNotNull(paramObject);
    this.zzgho = new ArrayList();
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder(100);
    stringBuilder.append(this.zzdht.getClass().getSimpleName());
    stringBuilder.append('{');
    int j = this.zzgho.size();
    for (int i = 0; i < j; i++) {
      stringBuilder.append(this.zzgho.get(i));
      if (i < j - 1)
        stringBuilder.append(", "); 
    } 
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public final zzbi zzg(String paramString, Object paramObject) {
    List<String> list = this.zzgho;
    paramString = (String)zzbq.checkNotNull(paramString);
    paramObject = String.valueOf(paramObject);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 1 + String.valueOf(paramObject).length());
    stringBuilder.append(paramString);
    stringBuilder.append("=");
    stringBuilder.append((String)paramObject);
    list.add(stringBuilder.toString());
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */