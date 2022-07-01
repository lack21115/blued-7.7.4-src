package com.huawei.updatesdk.a.a.c;

import com.huawei.updatesdk.a.a.b.a.a.a;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class f {
  private static final String a = "f";
  
  public static Class a(Field paramField) {
    if (Map.class.isAssignableFrom(paramField.getType())) {
      boolean bool = true;
      return a(paramField, bool);
    } 
    if (List.class.isAssignableFrom(paramField.getType())) {
      boolean bool = false;
      return a(paramField, bool);
    } 
    return null;
  }
  
  private static Class a(Field paramField, int paramInt) {
    Type type = paramField.getGenericType();
    if (type instanceof ParameterizedType) {
      Type[] arrayOfType = ((ParameterizedType)type).getActualTypeArguments();
      if (arrayOfType != null && arrayOfType.length > paramInt)
        try {
          if (arrayOfType[paramInt] instanceof Class)
            return (Class)arrayOfType[paramInt]; 
          String str = arrayOfType[paramInt].toString();
          int i = str.indexOf("class ");
          paramInt = i;
          if (i < 0)
            paramInt = 0; 
          int j = str.indexOf("<");
          i = j;
          if (j < 0)
            i = str.length(); 
          return Class.forName(str.substring(paramInt, i));
        } catch (ClassNotFoundException classNotFoundException) {
          String str = a;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("getType exception!");
          stringBuilder.append(classNotFoundException.getMessage());
          a.b(str, stringBuilder.toString());
        }  
    } 
    return null;
  }
  
  public static Field[] a(Class paramClass) {
    Field field;
    if (paramClass.getSuperclass() != null) {
      field = (Field)a(paramClass.getSuperclass());
    } else {
      field = null;
    } 
    Field[] arrayOfField3 = paramClass.getDeclaredFields();
    int i = 0;
    Field[] arrayOfField1 = arrayOfField3;
    if (field != null) {
      arrayOfField1 = arrayOfField3;
      if (field.length > 0) {
        arrayOfField1 = new Field[arrayOfField3.length + field.length];
        System.arraycopy(field, 0, arrayOfField1, 0, field.length);
        System.arraycopy(arrayOfField3, 0, arrayOfField1, field.length, arrayOfField3.length);
      } 
    } 
    ArrayList<Field> arrayList = new ArrayList();
    int j = arrayOfField1.length;
    while (i < j) {
      field = arrayOfField1[i];
      if (field.getName().indexOf("$") < 0)
        arrayList.add(field); 
      i++;
    } 
    Field[] arrayOfField2 = arrayOfField1;
    if (arrayList.size() != arrayOfField1.length) {
      arrayOfField2 = new Field[arrayList.size()];
      arrayList.toArray(arrayOfField2);
    } 
    return arrayOfField2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\a\a\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */