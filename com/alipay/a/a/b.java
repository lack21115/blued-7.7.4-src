package com.alipay.a.a;

import com.alipay.a.b.a;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import org.json.alipay.a;

public final class b implements i, j {
  private static Collection<Object> a(Class<?> paramClass, Type paramType) {
    if (paramClass == AbstractCollection.class)
      return new ArrayList(); 
    if (paramClass.isAssignableFrom(HashSet.class))
      return new HashSet(); 
    if (paramClass.isAssignableFrom(LinkedHashSet.class))
      return new LinkedHashSet(); 
    if (paramClass.isAssignableFrom(TreeSet.class))
      return new TreeSet(); 
    if (paramClass.isAssignableFrom(ArrayList.class))
      return new ArrayList(); 
    if (paramClass.isAssignableFrom(EnumSet.class)) {
      if (paramType instanceof ParameterizedType) {
        Type type = ((ParameterizedType)paramType).getActualTypeArguments()[0];
      } else {
        paramClass = Object.class;
      } 
      return EnumSet.noneOf(paramClass);
    } 
    try {
      return (Collection)paramClass.newInstance();
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder("create instane error, class ");
      stringBuilder.append(paramClass.getName());
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
  }
  
  public final Object a(Object paramObject) {
    ArrayList<Object> arrayList = new ArrayList();
    paramObject = ((Iterable)paramObject).iterator();
    while (paramObject.hasNext())
      arrayList.add(f.b(paramObject.next())); 
    return arrayList;
  }
  
  public final Object a(Object paramObject, Type paramType) {
    if (!paramObject.getClass().equals(a.class))
      return null; 
    Class<?> clazz = a.a(paramType);
    paramObject = paramObject;
    Collection<Object> collection = a(clazz, paramType);
    if (paramType instanceof ParameterizedType) {
      Type[] arrayOfType = ((ParameterizedType)paramType).getActualTypeArguments();
      int k = 0;
      Type type = arrayOfType[0];
      while (k < paramObject.a()) {
        collection.add(e.a(paramObject.a(k), type));
        k++;
      } 
      return collection;
    } 
    throw new IllegalArgumentException("Does not support the implement for generics.");
  }
  
  public final boolean a(Class<?> paramClass) {
    return Collection.class.isAssignableFrom(paramClass);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */