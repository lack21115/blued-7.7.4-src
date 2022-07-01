package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class zak extends AbstractSafeParcelable {
  public static final Parcelable.Creator<zak> CREATOR = new zao();
  
  final String zaa;
  
  final ArrayList<zan> zab;
  
  private final int zac;
  
  zak(int paramInt, String paramString, ArrayList<zan> paramArrayList) {
    this.zac = paramInt;
    this.zaa = paramString;
    this.zab = paramArrayList;
  }
  
  zak(String paramString, Map<String, FastJsonResponse.Field<?, ?>> paramMap) {
    String str;
    this.zac = 1;
    this.zaa = paramString;
    if (paramMap == null) {
      paramString = null;
    } else {
      ArrayList<zan> arrayList = new ArrayList();
      Iterator<String> iterator = paramMap.keySet().iterator();
      while (true) {
        ArrayList<zan> arrayList1 = arrayList;
        if (iterator.hasNext()) {
          str = iterator.next();
          arrayList.add(new zan(str, paramMap.get(str)));
          continue;
        } 
        break;
      } 
    } 
    this.zab = (ArrayList<zan>)str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zac);
    SafeParcelWriter.writeString(paramParcel, 2, this.zaa, false);
    SafeParcelWriter.writeTypedList(paramParcel, 3, this.zab, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\server\response\zak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */