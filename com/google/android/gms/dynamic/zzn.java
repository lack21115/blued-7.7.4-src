package com.google.android.gms.dynamic;

import android.os.IBinder;
import java.lang.reflect.Field;

public final class zzn extends IObjectWrapper$zza {
  private final Object mWrappedObject;
  
  private zzn(Object paramObject) {
    this.mWrappedObject = paramObject;
  }
  
  public static Object zzy(IObjectWrapper paramIObjectWrapper) {
    Field field;
    if (paramIObjectWrapper instanceof zzn)
      return ((zzn)paramIObjectWrapper).mWrappedObject; 
    IBinder iBinder = paramIObjectWrapper.asBinder();
    Field[] arrayOfField = iBinder.getClass().getDeclaredFields();
    int k = arrayOfField.length;
    int i = 0;
    paramIObjectWrapper = null;
    int j;
    for (j = 0; i < k; j = m) {
      Field field1 = arrayOfField[i];
      int m = j;
      if (!field1.isSynthetic()) {
        m = j + 1;
        field = field1;
      } 
      i++;
    } 
    if (j == 1) {
      if (!field.isAccessible()) {
        field.setAccessible(true);
        try {
          return field.get(iBinder);
        } catch (NullPointerException nullPointerException) {
          throw new IllegalArgumentException("Binder object is null.", nullPointerException);
        } catch (IllegalAccessException illegalAccessException) {
          throw new IllegalArgumentException("Could not access the field in remoteBinder.", illegalAccessException);
        } 
      } 
      throw new IllegalArgumentException("IObjectWrapper declared field not private!");
    } 
    i = arrayOfField.length;
    StringBuilder stringBuilder = new StringBuilder(64);
    stringBuilder.append("Unexpected number of IObjectWrapper declared fields: ");
    stringBuilder.append(i);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static IObjectWrapper zzz(Object paramObject) {
    return new zzn(paramObject);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\dynamic\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */