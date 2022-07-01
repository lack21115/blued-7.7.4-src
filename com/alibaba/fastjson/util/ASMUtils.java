package com.alibaba.fastjson.util;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;

public class ASMUtils {
  public static final boolean IS_ANDROID;
  
  public static final String JAVA_VM_NAME = System.getProperty("java.vm.name");
  
  static {
    IS_ANDROID = isAndroid(JAVA_VM_NAME);
  }
  
  public static boolean checkName(String paramString) {
    int i = 0;
    while (i < paramString.length()) {
      char c = paramString.charAt(i);
      if (c >= '\001') {
        if (c > '')
          return false; 
        i++;
        continue;
      } 
      return false;
    } 
    return true;
  }
  
  public static String desc(Class<?> paramClass) {
    if (paramClass.isPrimitive())
      return getPrimitiveLetter(paramClass); 
    if (paramClass.isArray()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("[");
      stringBuilder1.append(desc(paramClass.getComponentType()));
      return stringBuilder1.toString();
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("L");
    stringBuilder.append(type(paramClass));
    stringBuilder.append(";");
    return stringBuilder.toString();
  }
  
  public static String desc(Method paramMethod) {
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    StringBuilder stringBuilder = new StringBuilder(arrayOfClass.length + 1 << 4);
    stringBuilder.append('(');
    for (int i = 0; i < arrayOfClass.length; i++)
      stringBuilder.append(desc(arrayOfClass[i])); 
    stringBuilder.append(')');
    stringBuilder.append(desc(paramMethod.getReturnType()));
    return stringBuilder.toString();
  }
  
  public static Type getFieldType(Class<?> paramClass, String paramString) {
    try {
      return paramClass.getField(paramString).getGenericType();
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static Type getMethodType(Class<?> paramClass, String paramString) {
    try {
      return paramClass.getMethod(paramString, new Class[0]).getGenericReturnType();
    } catch (Exception exception) {
      return null;
    } 
  }
  
  public static String getPrimitiveLetter(Class<?> paramClass) {
    if (int.class.equals(paramClass))
      return "I"; 
    if (void.class.equals(paramClass))
      return "V"; 
    if (boolean.class.equals(paramClass))
      return "Z"; 
    if (char.class.equals(paramClass))
      return "C"; 
    if (byte.class.equals(paramClass))
      return "B"; 
    if (short.class.equals(paramClass))
      return "S"; 
    if (float.class.equals(paramClass))
      return "F"; 
    if (long.class.equals(paramClass))
      return "J"; 
    if (double.class.equals(paramClass))
      return "D"; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Type: ");
    stringBuilder.append(paramClass.getCanonicalName());
    stringBuilder.append(" is not a primitive type");
    throw new IllegalStateException(stringBuilder.toString());
  }
  
  public static boolean isAndroid(String paramString) {
    boolean bool = false;
    if (paramString == null)
      return false; 
    paramString = paramString.toLowerCase();
    if (paramString.contains("dalvik") || paramString.contains("lemur"))
      bool = true; 
    return bool;
  }
  
  public static void parseArray(Collection<Object> paramCollection, ObjectDeserializer paramObjectDeserializer, DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    paramObject = paramDefaultJSONParser.lexer;
    if (paramObject.token() == 8)
      paramObject.nextToken(16); 
    paramDefaultJSONParser.accept(14, 14);
    int i = 0;
    while (true) {
      paramCollection.add(paramObjectDeserializer.deserialze(paramDefaultJSONParser, paramType, Integer.valueOf(i)));
      i++;
      if (paramObject.token() == 16) {
        paramObject.nextToken(14);
        continue;
      } 
      paramDefaultJSONParser.accept(15, 16);
      return;
    } 
  }
  
  public static String type(Class<?> paramClass) {
    if (paramClass.isArray()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[");
      stringBuilder.append(desc(paramClass.getComponentType()));
      return stringBuilder.toString();
    } 
    return !paramClass.isPrimitive() ? paramClass.getName().replace('.', '/') : getPrimitiveLetter(paramClass);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjso\\util\ASMUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */