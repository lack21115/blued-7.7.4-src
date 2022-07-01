package com.google.protobuf;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

final class MessageLiteToString {
  private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
  
  private static final String BYTES_SUFFIX = "Bytes";
  
  private static final String LIST_SUFFIX = "List";
  
  private static final String MAP_SUFFIX = "Map";
  
  private static final String camelCaseToSnakeCase(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < paramString.length(); i++) {
      char c = paramString.charAt(i);
      if (Character.isUpperCase(c))
        stringBuilder.append("_"); 
      stringBuilder.append(Character.toLowerCase(c));
    } 
    return stringBuilder.toString();
  }
  
  private static boolean isDefaultValue(Object paramObject) {
    return (paramObject instanceof Boolean) ? (((Boolean)paramObject).booleanValue() ^ true) : ((paramObject instanceof Integer) ? ((((Integer)paramObject).intValue() == 0)) : ((paramObject instanceof Float) ? ((((Float)paramObject).floatValue() == 0.0F)) : ((paramObject instanceof Double) ? ((((Double)paramObject).doubleValue() == 0.0D)) : ((paramObject instanceof String) ? paramObject.equals("") : ((paramObject instanceof ByteString) ? paramObject.equals(ByteString.EMPTY) : ((paramObject instanceof MessageLite) ? ((paramObject == ((MessageLite)paramObject).getDefaultInstanceForType())) : ((paramObject instanceof java.lang.Enum) ? ((((java.lang.Enum)paramObject).ordinal() == 0)) : false)))))));
  }
  
  static final void printField(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject) {
    if (paramObject instanceof List) {
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext())
        printField(paramStringBuilder, paramInt, paramString, paramObject.next()); 
      return;
    } 
    if (paramObject instanceof Map) {
      paramObject = ((Map)paramObject).entrySet().iterator();
      while (paramObject.hasNext())
        printField(paramStringBuilder, paramInt, paramString, paramObject.next()); 
      return;
    } 
    paramStringBuilder.append('\n');
    boolean bool1 = false;
    boolean bool2 = false;
    int i;
    for (i = 0; i < paramInt; i++)
      paramStringBuilder.append(' '); 
    paramStringBuilder.append(paramString);
    if (paramObject instanceof String) {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(TextFormatEscaper.escapeText((String)paramObject));
      paramStringBuilder.append('"');
      return;
    } 
    if (paramObject instanceof ByteString) {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(TextFormatEscaper.escapeBytes((ByteString)paramObject));
      paramStringBuilder.append('"');
      return;
    } 
    if (paramObject instanceof GeneratedMessageLite) {
      paramStringBuilder.append(" {");
      reflectivePrintWithIndent((GeneratedMessageLite)paramObject, paramStringBuilder, paramInt + 2);
      paramStringBuilder.append("\n");
      for (i = bool2; i < paramInt; i++)
        paramStringBuilder.append(' '); 
      paramStringBuilder.append("}");
      return;
    } 
    if (paramObject instanceof Map.Entry) {
      paramStringBuilder.append(" {");
      Map.Entry entry = (Map.Entry)paramObject;
      i = paramInt + 2;
      printField(paramStringBuilder, i, "key", entry.getKey());
      printField(paramStringBuilder, i, "value", entry.getValue());
      paramStringBuilder.append("\n");
      for (i = bool1; i < paramInt; i++)
        paramStringBuilder.append(' '); 
      paramStringBuilder.append("}");
      return;
    } 
    paramStringBuilder.append(": ");
    paramStringBuilder.append(paramObject.toString());
  }
  
  private static void reflectivePrintWithIndent(MessageLite paramMessageLite, StringBuilder paramStringBuilder, int paramInt) {
    HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
    HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
    TreeSet<String> treeSet = new TreeSet();
    for (Method method : paramMessageLite.getClass().getDeclaredMethods()) {
      hashMap2.put(method.getName(), method);
      if ((method.getParameterTypes()).length == 0) {
        hashMap1.put(method.getName(), method);
        if (method.getName().startsWith("get"))
          treeSet.add(method.getName()); 
      } 
    } 
    for (String str3 : treeSet) {
      String str1;
      if (str3.startsWith("get")) {
        str1 = str3.substring(3);
      } else {
        str1 = str3;
      } 
      if (str1.endsWith("List") && !str1.endsWith("OrBuilderList") && !str1.equals("List")) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1.substring(0, 1).toLowerCase());
        stringBuilder.append(str1.substring(1, str1.length() - 4));
        String str = stringBuilder.toString();
        Method method = (Method)hashMap1.get(str3);
        if (method != null && method.getReturnType().equals(List.class)) {
          printField(paramStringBuilder, paramInt, camelCaseToSnakeCase(str), GeneratedMessageLite.invokeOrDie(method, paramMessageLite, new Object[0]));
          continue;
        } 
      } 
      if (str1.endsWith("Map") && !str1.equals("Map")) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str1.substring(0, 1).toLowerCase());
        stringBuilder.append(str1.substring(1, str1.length() - 3));
        String str = stringBuilder.toString();
        Method method = (Method)hashMap1.get(str3);
        if (method != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent((Class)Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
          printField(paramStringBuilder, paramInt, camelCaseToSnakeCase(str), GeneratedMessageLite.invokeOrDie(method, paramMessageLite, new Object[0]));
          continue;
        } 
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("set");
      stringBuilder1.append(str1);
      if ((Method)hashMap2.get(stringBuilder1.toString()) == null)
        continue; 
      if (str1.endsWith("Bytes")) {
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("get");
        stringBuilder1.append(str1.substring(0, str1.length() - 5));
        if (hashMap1.containsKey(stringBuilder1.toString()))
          continue; 
      } 
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1.substring(0, 1).toLowerCase());
      stringBuilder1.append(str1.substring(1));
      String str2 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("get");
      stringBuilder2.append(str1);
      Method method2 = (Method)hashMap1.get(stringBuilder2.toString());
      StringBuilder stringBuilder3 = new StringBuilder();
      stringBuilder3.append("has");
      stringBuilder3.append(str1);
      Method method1 = (Method)hashMap1.get(stringBuilder3.toString());
      if (method2 != null) {
        boolean bool;
        Object object = GeneratedMessageLite.invokeOrDie(method2, paramMessageLite, new Object[0]);
        if (method1 == null) {
          if (!isDefaultValue(object)) {
            bool = true;
          } else {
            bool = false;
          } 
        } else {
          bool = ((Boolean)GeneratedMessageLite.invokeOrDie(method1, paramMessageLite, new Object[0])).booleanValue();
        } 
        if (bool)
          printField(paramStringBuilder, paramInt, camelCaseToSnakeCase(str2), object); 
      } 
    } 
    if (paramMessageLite instanceof GeneratedMessageLite.ExtendableMessage)
      for (Map.Entry entry : ((GeneratedMessageLite.ExtendableMessage)paramMessageLite).extensions) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        stringBuilder.append(((GeneratedMessageLite.ExtensionDescriptor)entry.getKey()).getNumber());
        stringBuilder.append("]");
        printField(paramStringBuilder, paramInt, stringBuilder.toString(), entry.getValue());
      }  
    paramMessageLite = paramMessageLite;
    if (((GeneratedMessageLite)paramMessageLite).unknownFields != null)
      ((GeneratedMessageLite)paramMessageLite).unknownFields.printWithIndent(paramStringBuilder, paramInt); 
  }
  
  static String toString(MessageLite paramMessageLite, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("# ");
    stringBuilder.append(paramString);
    reflectivePrintWithIndent(paramMessageLite, stringBuilder, 0);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\MessageLiteToString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */