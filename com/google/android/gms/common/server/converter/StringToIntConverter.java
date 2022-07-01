package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.FieldConverter<String, Integer> {
  public static final Parcelable.Creator<StringToIntConverter> CREATOR = new zac();
  
  private final int zaa = 1;
  
  private final HashMap<String, Integer> zab = new HashMap<String, Integer>();
  
  private final SparseArray<String> zac = new SparseArray();
  
  private final ArrayList<zaa> zad = null;
  
  public StringToIntConverter() {}
  
  StringToIntConverter(int paramInt, ArrayList<zaa> paramArrayList) {
    paramArrayList = paramArrayList;
    int i = paramArrayList.size();
    paramInt = 0;
    while (paramInt < i) {
      zaa zaa = (zaa)paramArrayList.get(paramInt);
      paramInt++;
      zaa = zaa;
      add(zaa.zaa, zaa.zab);
    } 
  }
  
  public final StringToIntConverter add(String paramString, int paramInt) {
    this.zab.put(paramString, Integer.valueOf(paramInt));
    this.zac.put(paramInt, paramString);
    return this;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zaa);
    ArrayList<zaa> arrayList = new ArrayList();
    for (String str : this.zab.keySet())
      arrayList.add(new zaa(str, ((Integer)this.zab.get(str)).intValue())); 
    SafeParcelWriter.writeTypedList(paramParcel, 2, arrayList, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final int zaa() {
    return 7;
  }
  
  public final int zab() {
    return 0;
  }
  
  public static final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new zad();
    
    final String zaa;
    
    final int zab;
    
    private final int zac;
    
    zaa(int param1Int1, String param1String, int param1Int2) {
      this.zac = param1Int1;
      this.zaa = param1String;
      this.zab = param1Int2;
    }
    
    zaa(String param1String, int param1Int) {
      this.zac = 1;
      this.zaa = param1String;
      this.zab = param1Int;
    }
    
    public final void writeToParcel(Parcel param1Parcel, int param1Int) {
      param1Int = SafeParcelWriter.beginObjectHeader(param1Parcel);
      SafeParcelWriter.writeInt(param1Parcel, 1, this.zac);
      SafeParcelWriter.writeString(param1Parcel, 2, this.zaa, false);
      SafeParcelWriter.writeInt(param1Parcel, 3, this.zab);
      SafeParcelWriter.finishObjectHeader(param1Parcel, param1Int);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\server\converter\StringToIntConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */