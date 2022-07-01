package com.google.protobuf;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

final class MessageLiteToString {
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
  
  static final void printField(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject) {
    if (paramObject instanceof List) {
      paramObject = ((List)paramObject).iterator();
      while (paramObject.hasNext())
        printField(paramStringBuilder, paramInt, paramString, paramObject.next()); 
      return;
    } 
    paramStringBuilder.append('\n');
    boolean bool = false;
    int i;
    for (i = 0; i < paramInt; i++)
      paramStringBuilder.append(' '); 
    paramStringBuilder.append(paramString);
    if (paramObject instanceof String) {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(TextFormatEscaper.escapeBytes(ByteString.copyFromUtf8((String)paramObject)));
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
      for (i = bool; i < paramInt; i++)
        paramStringBuilder.append(' '); 
      paramStringBuilder.append("}");
      return;
    } 
    paramStringBuilder.append(": ");
    paramStringBuilder.append(paramObject.toString());
  }
  
  static void reflectivePrintWithIndent(MessageLite paramMessageLite, StringBuilder paramStringBuilder, int paramInt) {
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
    Iterator<String> iterator = treeSet.iterator();
    while (true) {
      while (true)
        break; 
      if (SYNTHETIC_LOCAL_VARIABLE_5 != null)
        printField(paramStringBuilder, paramInt, camelCaseToSnakeCase((String)method), SYNTHETIC_LOCAL_VARIABLE_11); 
    } 
    if (paramMessageLite instanceof GeneratedMessageLite$ExtendableMessage) {
      Iterator<Map.Entry> iterator1;
      FieldSet fieldSet = ((GeneratedMessageLite$ExtendableMessage)paramMessageLite).extensions;
      if (fieldSet.hasLazyField) {
        iterator1 = new LazyField$LazyIterator(fieldSet.fields.entrySet().iterator());
      } else {
        iterator1 = ((FieldSet)iterator1).fields.entrySet().iterator();
      } 
      while (iterator1.hasNext()) {
        Map.Entry entry = iterator1.next();
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(((GeneratedMessageLite$ExtensionDescriptor)entry.getKey()).number);
        stringBuilder.append("]");
        printField(paramStringBuilder, paramInt, stringBuilder.toString(), entry.getValue());
      } 
    } 
    paramMessageLite = paramMessageLite;
    if (((GeneratedMessageLite)paramMessageLite).unknownFields != null)
      ((GeneratedMessageLite)paramMessageLite).unknownFields.printWithIndent(paramStringBuilder, paramInt); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\MessageLiteToString.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */