package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.util.ArrayList;
import java.util.Iterator;

public final class SafeParcelableSerializer {
  public static <T extends SafeParcelable> T deserializeFromBytes(byte[] paramArrayOfbyte, Parcelable.Creator<T> paramCreator) {
    Preconditions.checkNotNull(paramCreator);
    Parcel parcel = Parcel.obtain();
    parcel.unmarshall(paramArrayOfbyte, 0, paramArrayOfbyte.length);
    parcel.setDataPosition(0);
    SafeParcelable safeParcelable = (SafeParcelable)paramCreator.createFromParcel(parcel);
    parcel.recycle();
    return (T)safeParcelable;
  }
  
  public static <T extends SafeParcelable> T deserializeFromIntentExtra(Intent paramIntent, String paramString, Parcelable.Creator<T> paramCreator) {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra(paramString);
    return (arrayOfByte == null) ? null : deserializeFromBytes(arrayOfByte, paramCreator);
  }
  
  public static <T extends SafeParcelable> T deserializeFromString(String paramString, Parcelable.Creator<T> paramCreator) {
    return deserializeFromBytes(Base64Utils.decodeUrlSafe(paramString), paramCreator);
  }
  
  public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromBundle(Bundle paramBundle, String paramString, Parcelable.Creator<T> paramCreator) {
    ArrayList<Object> arrayList1 = (ArrayList)paramBundle.getSerializable(paramString);
    if (arrayList1 == null)
      return null; 
    ArrayList<T> arrayList = new ArrayList(arrayList1.size());
    arrayList1 = arrayList1;
    int j = arrayList1.size();
    int i = 0;
    while (i < j) {
      byte[] arrayOfByte = (byte[])arrayList1.get(i);
      i++;
      arrayList.add(deserializeFromBytes(arrayOfByte, paramCreator));
    } 
    return arrayList;
  }
  
  public static <T extends SafeParcelable> ArrayList<T> deserializeIterableFromIntentExtra(Intent paramIntent, String paramString, Parcelable.Creator<T> paramCreator) {
    ArrayList<Object> arrayList1 = (ArrayList)paramIntent.getSerializableExtra(paramString);
    if (arrayList1 == null)
      return null; 
    ArrayList<T> arrayList = new ArrayList(arrayList1.size());
    arrayList1 = arrayList1;
    int j = arrayList1.size();
    int i = 0;
    while (i < j) {
      byte[] arrayOfByte = (byte[])arrayList1.get(i);
      i++;
      arrayList.add(deserializeFromBytes(arrayOfByte, paramCreator));
    } 
    return arrayList;
  }
  
  public static <T extends SafeParcelable> void serializeIterableToBundle(Iterable<T> paramIterable, Bundle paramBundle, String paramString) {
    ArrayList<byte[]> arrayList = new ArrayList();
    Iterator<T> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      arrayList.add(serializeToBytes((SafeParcelable)iterator.next())); 
    paramBundle.putSerializable(paramString, arrayList);
  }
  
  public static <T extends SafeParcelable> void serializeIterableToIntentExtra(Iterable<T> paramIterable, Intent paramIntent, String paramString) {
    ArrayList<byte[]> arrayList = new ArrayList();
    Iterator<T> iterator = paramIterable.iterator();
    while (iterator.hasNext())
      arrayList.add(serializeToBytes((SafeParcelable)iterator.next())); 
    paramIntent.putExtra(paramString, arrayList);
  }
  
  public static <T extends SafeParcelable> byte[] serializeToBytes(T paramT) {
    Parcel parcel = Parcel.obtain();
    paramT.writeToParcel(parcel, 0);
    byte[] arrayOfByte = parcel.marshall();
    parcel.recycle();
    return arrayOfByte;
  }
  
  public static <T extends SafeParcelable> void serializeToIntentExtra(T paramT, Intent paramIntent, String paramString) {
    paramIntent.putExtra(paramString, serializeToBytes(paramT));
  }
  
  public static <T extends SafeParcelable> String serializeToString(T paramT) {
    return Base64Utils.encodeUrlSafe(serializeToBytes(paramT));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\safeparcel\SafeParcelableSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */