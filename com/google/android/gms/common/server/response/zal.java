package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zal extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zal> CREATOR = new zam();
  
  private final int zaa;
  
  private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zab;
  
  private final ArrayList<zak> zac;
  
  private final String zad;
  
  zal(int paramInt, ArrayList<zak> paramArrayList, String paramString) {
    this.zaa = paramInt;
    this.zac = null;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int i = paramArrayList.size();
    for (paramInt = 0; paramInt < i; paramInt++) {
      zak zak = paramArrayList.get(paramInt);
      String str = zak.zaa;
      HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
      int k = ((ArrayList)Preconditions.checkNotNull(zak.zab)).size();
      int j;
      for (j = 0; j < k; j++) {
        zan zan = zak.zab.get(j);
        hashMap1.put(zan.zaa, zan.zab);
      } 
      hashMap.put(str, hashMap1);
    } 
    this.zab = (HashMap)hashMap;
    this.zad = (String)Preconditions.checkNotNull(paramString);
    zaa();
  }
  
  public zal(Class<? extends FastJsonResponse> paramClass) {
    this.zaa = 1;
    this.zac = null;
    this.zab = new HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>>();
    this.zad = (String)Preconditions.checkNotNull(paramClass.getCanonicalName());
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (String str : this.zab.keySet()) {
      stringBuilder.append(str);
      stringBuilder.append(":\n");
      Map map = this.zab.get(str);
      for (String str1 : map.keySet()) {
        stringBuilder.append("  ");
        stringBuilder.append(str1);
        stringBuilder.append(": ");
        stringBuilder.append(map.get(str1));
      } 
    } 
    return stringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zaa);
    ArrayList<zak> arrayList = new ArrayList();
    for (String str : this.zab.keySet())
      arrayList.add(new zak(str, this.zab.get(str))); 
    SafeParcelWriter.writeTypedList(paramParcel, 2, arrayList, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zad, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final Map<String, FastJsonResponse.Field<?, ?>> zaa(String paramString) {
    return this.zab.get(paramString);
  }
  
  public final void zaa() {
    for (String str : this.zab.keySet()) {
      Map map = this.zab.get(str);
      Iterator<String> iterator = map.keySet().iterator();
      while (iterator.hasNext())
        ((FastJsonResponse.Field)map.get(iterator.next())).zaa(this); 
    } 
  }
  
  public final void zaa(Class<? extends FastJsonResponse> paramClass, Map<String, FastJsonResponse.Field<?, ?>> paramMap) {
    this.zab.put((String)Preconditions.checkNotNull(paramClass.getCanonicalName()), paramMap);
  }
  
  public final boolean zaa(Class<? extends FastJsonResponse> paramClass) {
    return this.zab.containsKey(Preconditions.checkNotNull(paramClass.getCanonicalName()));
  }
  
  public final void zab() {
    for (String str : this.zab.keySet()) {
      Map map = this.zab.get(str);
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      for (String str1 : map.keySet())
        hashMap.put(str1, ((FastJsonResponse.Field)map.get(str1)).zaa()); 
      this.zab.put(str, hashMap);
    } 
  }
  
  public final String zac() {
    return this.zad;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\server\response\zal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */