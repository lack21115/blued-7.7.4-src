package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e {
  private Bundle a(String paramString, Bundle paramBundle, Object paramObject) {
    Bundle bundle = new Bundle();
    a(paramString, paramObject, bundle);
    paramBundle.putBundle("_next_item_", bundle);
    return bundle;
  }
  
  private Object a(Field paramField, Bundle paramBundle) {
    String str = paramField.getName();
    Object object = paramBundle.get(str);
    if (object instanceof Bundle)
      try {
        Bundle bundle = (Bundle)object;
        int i = bundle.getInt("_val_type_", -1);
        if (i == 1)
          return a(paramField.getGenericType(), bundle); 
        if (i == 0) {
          null = (IMessageEntity)paramField.getType().newInstance();
          return a((Bundle)object, null);
        } 
        return object;
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("decode, read value of the field exception, field name: ");
        stringBuilder.append(str);
        Log.e("MessageCodec", stringBuilder.toString());
        return null;
      }  
    return object;
  }
  
  private void a(IMessageEntity paramIMessageEntity, Field paramField, Bundle paramBundle) throws IllegalAccessException {
    Object object = a(paramField, paramBundle);
    if (object != null) {
      boolean bool = paramField.isAccessible();
      paramField.setAccessible(true);
      paramField.set(paramIMessageEntity, object);
      paramField.setAccessible(bool);
    } 
  }
  
  private void b(IMessageEntity paramIMessageEntity, Field paramField, Bundle paramBundle) throws IllegalAccessException {
    boolean bool = paramField.isAccessible();
    paramField.setAccessible(true);
    a(paramField.getName(), paramField.get(paramIMessageEntity), paramBundle);
    paramField.setAccessible(bool);
  }
  
  private boolean b(String paramString, Object paramObject, Bundle paramBundle) {
    if (paramObject instanceof String) {
      paramBundle.putString(paramString, (String)paramObject);
    } else if (paramObject instanceof Integer) {
      paramBundle.putInt(paramString, ((Integer)paramObject).intValue());
    } else if (paramObject instanceof Short) {
      paramBundle.putShort(paramString, ((Short)paramObject).shortValue());
    } else if (paramObject instanceof Long) {
      paramBundle.putLong(paramString, ((Long)paramObject).longValue());
    } else if (paramObject instanceof Float) {
      paramBundle.putFloat(paramString, ((Float)paramObject).floatValue());
    } else if (paramObject instanceof Double) {
      paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
    } else {
      if (paramObject instanceof Boolean) {
        paramBundle.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
        return true;
      } 
      return false;
    } 
    return true;
  }
  
  public Bundle a(IMessageEntity paramIMessageEntity, Bundle paramBundle) {
    Class<?> clazz = paramIMessageEntity.getClass();
    label20: while (true) {
      if (clazz != null) {
        Field[] arrayOfField = clazz.getDeclaredFields();
        int j = arrayOfField.length;
        int i = 0;
        while (true) {
          if (i < j) {
            Field field = arrayOfField[i];
            if (field.isAnnotationPresent((Class)Packed.class))
              try {
                b(paramIMessageEntity, field, paramBundle);
              } catch (IllegalAccessException|IllegalArgumentException illegalAccessException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("encode, get value of the field exception, field name: ");
                stringBuilder.append(field.getName());
                Log.e("MessageCodec", stringBuilder.toString());
              }  
            i++;
            continue;
          } 
          clazz = clazz.getSuperclass();
          continue label20;
        } 
        break;
      } 
      return paramBundle;
    } 
  }
  
  public IMessageEntity a(Bundle paramBundle, IMessageEntity paramIMessageEntity) {
    if (paramBundle == null)
      return paramIMessageEntity; 
    paramBundle.setClassLoader(getClass().getClassLoader());
    Class<?> clazz = paramIMessageEntity.getClass();
    label22: while (true) {
      if (clazz != null) {
        Field[] arrayOfField = clazz.getDeclaredFields();
        int j = arrayOfField.length;
        int i = 0;
        while (true) {
          if (i < j) {
            Field field = arrayOfField[i];
            if (field.isAnnotationPresent((Class)Packed.class))
              try {
                a(paramIMessageEntity, field, paramBundle);
              } catch (IllegalAccessException|IllegalArgumentException illegalAccessException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("decode, set value of the field exception, field name:");
                stringBuilder.append(field.getName());
                Log.e("MessageCodec", stringBuilder.toString());
              }  
            i++;
            continue;
          } 
          clazz = clazz.getSuperclass();
          continue label22;
        } 
        break;
      } 
      return paramIMessageEntity;
    } 
  }
  
  protected List<Object> a(Type paramType, Bundle paramBundle) throws InstantiationException, IllegalAccessException {
    ArrayList<Object> arrayList = new ArrayList();
    for (paramBundle = paramBundle.getBundle("_next_item_"); paramBundle != null; paramBundle = paramBundle.getBundle("_next_item_")) {
      Object object = paramBundle.get("_value_");
      if (object.getClass().isPrimitive() || object instanceof String || object instanceof Serializable) {
        arrayList.add(object);
      } else if (object instanceof Bundle) {
        object = object;
        int i = object.getInt("_val_type_", -1);
        if (i != 1) {
          if (i == 0) {
            arrayList.add(a((Bundle)object, ((Class<IMessageEntity>)((ParameterizedType)paramType).getActualTypeArguments()[0]).newInstance()));
          } else {
            throw new InstantiationException("Unknown type can not be supported");
          } 
        } else {
          throw new InstantiationException("Nested List can not be supported");
        } 
      } 
    } 
    return arrayList;
  }
  
  protected void a(String paramString, Object paramObject, Bundle paramBundle) {
    if (paramObject == null)
      return; 
    if (b(paramString, paramObject, paramBundle))
      return; 
    if (paramObject instanceof CharSequence) {
      paramBundle.putCharSequence(paramString, (CharSequence)paramObject);
      return;
    } 
    if (paramObject instanceof Parcelable) {
      paramBundle.putParcelable(paramString, (Parcelable)paramObject);
      return;
    } 
    if (paramObject instanceof byte[]) {
      paramBundle.putByteArray(paramString, (byte[])paramObject);
      return;
    } 
    if (paramObject instanceof List) {
      a(paramString, (List)paramObject, paramBundle);
      return;
    } 
    if (paramObject instanceof Serializable) {
      paramBundle.putSerializable(paramString, (Serializable)paramObject);
      return;
    } 
    if (paramObject instanceof IMessageEntity) {
      paramObject = a((IMessageEntity)paramObject, new Bundle());
      paramObject.putInt("_val_type_", 0);
      paramBundle.putBundle(paramString, (Bundle)paramObject);
      return;
    } 
    paramObject = new StringBuilder();
    paramObject.append("cannot support type, ");
    paramObject.append(paramString);
    Log.e("MessageCodec", paramObject.toString());
  }
  
  protected void a(String paramString, List paramList, Bundle paramBundle) {
    Iterator<Object> iterator = paramList.iterator();
    paramList = null;
    while (iterator.hasNext()) {
      Bundle bundle2;
      Object object = iterator.next();
      List list = paramList;
      if (paramList == null) {
        bundle2 = new Bundle();
        paramBundle.putBundle(paramString, bundle2);
        bundle2.putInt("_val_type_", 1);
      } 
      Bundle bundle1 = a("_value_", bundle2, object);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\core\aidl\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */