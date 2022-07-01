package com.huawei.hms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.util.Base64Utils;
import java.util.ArrayList;
import java.util.Iterator;

public final class SafeParcelableSerializer {
  public static <S extends SafeParcelable> S deserializeFromBytes(byte[] paramArrayOfbyte, Parcelable.Creator<S> paramCreator) {
    Preconditions.checkNotNull(paramCreator);
    Parcel parcel = Parcel.obtain();
    parcel.unmarshall(paramArrayOfbyte, 0, paramArrayOfbyte.length);
    parcel.setDataPosition(0);
    SafeParcelable safeParcelable = (SafeParcelable)paramCreator.createFromParcel(parcel);
    parcel.recycle();
    return (S)safeParcelable;
  }
  
  public static <S extends SafeParcelable> S deserializeFromIntentExtra(Intent paramIntent, String paramString, Parcelable.Creator<S> paramCreator) {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra(paramString);
    return (arrayOfByte == null) ? null : deserializeFromBytes(arrayOfByte, paramCreator);
  }
  
  public static <S extends SafeParcelable> S deserializeFromString(String paramString, Parcelable.Creator<S> paramCreator) {
    return deserializeFromBytes(Base64Utils.decodeUrlSafe(paramString), paramCreator);
  }
  
  public static <S extends SafeParcelable> ArrayList<S> deserializeIterableFromBundle(Bundle paramBundle, String paramString, Parcelable.Creator<S> paramCreator) {
    if (paramBundle == null)
      return null; 
    ArrayList arrayList1 = (ArrayList)paramBundle.getSerializable(paramString);
    if (arrayList1 == null)
      return null; 
    ArrayList<S> arrayList = new ArrayList(arrayList1.size());
    Iterator<byte[]> iterator = arrayList1.iterator();
    while (iterator.hasNext())
      arrayList.add(deserializeFromBytes(iterator.next(), paramCreator)); 
    return arrayList;
  }
  
  public static <S extends SafeParcelable> ArrayList<S> deserializeIterableFromIntentExtra(Intent paramIntent, String paramString, Parcelable.Creator<S> paramCreator) {
    ArrayList arrayList1 = (ArrayList)paramIntent.getSerializableExtra(paramString);
    if (arrayList1 == null)
      return null; 
    ArrayList<S> arrayList = new ArrayList(arrayList1.size());
    Iterator<byte[]> iterator = arrayList1.iterator();
    while (iterator.hasNext())
      arrayList.add(deserializeFromBytes(iterator.next(), paramCreator)); 
    return arrayList;
  }
  
  public static <S extends SafeParcelable> void serializeIterableToBundle(Iterable<S> paramIterable, Bundle paramBundle, String paramString) {
    ArrayList<byte[]> arrayList = new ArrayList();
    Iterator<S> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      arrayList.add(serializeToBytes((SafeParcelable)iterator.next())); 
    paramBundle.putSerializable(paramString, arrayList);
  }
  
  public static <S extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<S> paramIterable, Intent paramIntent, String paramString) {
    ArrayList<byte[]> arrayList = new ArrayList();
    Iterator<S> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      arrayList.add(serializeToBytes((SafeParcelable)iterator.next())); 
    paramIntent.putExtra(paramString, arrayList);
  }
  
  public static <S extends SafeParcelable> byte[] serializeToBytes(S paramS) {
    Parcel parcel = Parcel.obtain();
    paramS.writeToParcel(parcel, 0);
    byte[] arrayOfByte = parcel.marshall();
    parcel.recycle();
    return arrayOfByte;
  }
  
  public static <S extends SafeParcelable> void serializeToIntentExtra(S paramS, Intent paramIntent, String paramString) {
    paramIntent.putExtra(paramString, serializeToBytes(paramS));
  }
  
  public static <S extends SafeParcelable> String serializeToString(S paramS) {
    return Base64Utils.encodeUrlSafe(serializeToBytes(paramS));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\safeparcel\SafeParcelableSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */