package com.google.android.gms.common.internal;

import android.accounts.Account;
import com.google.android.gms.internal.zzcyk;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzr {
  public final String zzehh;
  
  public final Account zzeho;
  
  public final Set zzfsw;
  
  final String zzfta;
  
  final Set zzgfq;
  
  public final Map zzgfr;
  
  public final zzcyk zzgfs;
  
  public Integer zzgft;
  
  public zzr(Account paramAccount, Set<?> paramSet, Map paramMap, String paramString1, String paramString2, zzcyk paramzzcyk) {
    Set<?> set;
    this.zzeho = paramAccount;
    if (paramSet == null) {
      set = Collections.EMPTY_SET;
    } else {
      set = Collections.unmodifiableSet(paramSet);
    } 
    this.zzfsw = set;
    Map map = paramMap;
    if (paramMap == null)
      map = Collections.EMPTY_MAP; 
    this.zzgfr = map;
    this.zzehh = paramString1;
    this.zzfta = paramString2;
    this.zzgfs = paramzzcyk;
    HashSet<?> hashSet = new HashSet(this.zzfsw);
    Iterator iterator = this.zzgfr.values().iterator();
    while (iterator.hasNext())
      hashSet.addAll(((zzt)iterator.next()).zzenh); 
    this.zzgfq = Collections.unmodifiableSet(hashSet);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\common\internal\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */