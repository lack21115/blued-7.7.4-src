package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;

public abstract class FastSafeParcelableJsonResponse extends FastJsonResponse implements SafeParcelable {
  public final int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    if (paramObject == null)
      return false; 
    if (this == paramObject)
      return true; 
    if (!getClass().isInstance(paramObject))
      return false; 
    paramObject = paramObject;
    for (FastJsonResponse.Field<?, ?> field : getFieldMappings().values()) {
      if (isFieldSet(field)) {
        if (!paramObject.isFieldSet(field) || !Objects.equal(getFieldValue(field), paramObject.getFieldValue(field)))
          return false; 
        continue;
      } 
      if (paramObject.isFieldSet(field))
        return false; 
    } 
    return true;
  }
  
  public Object getValueObject(String paramString) {
    return null;
  }
  
  public int hashCode() {
    Iterator<FastJsonResponse.Field> iterator = getFieldMappings().values().iterator();
    int i = 0;
    while (iterator.hasNext()) {
      FastJsonResponse.Field field = iterator.next();
      if (isFieldSet(field))
        i = i * 31 + Preconditions.checkNotNull(getFieldValue(field)).hashCode(); 
    } 
    return i;
  }
  
  public boolean isPrimitiveFieldSet(String paramString) {
    return false;
  }
  
  public byte[] toByteArray() {
    Parcel parcel = Parcel.obtain();
    writeToParcel(parcel, 0);
    byte[] arrayOfByte = parcel.marshall();
    parcel.recycle();
    return arrayOfByte;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\server\response\FastSafeParcelableJsonResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */