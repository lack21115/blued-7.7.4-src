package com.google.protobuf.util;

import com.google.common.base.CaseFormat;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.primitives.Ints;
import com.google.protobuf.Descriptors;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Internal;
import com.google.protobuf.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class FieldMaskUtil {
  private static final String FIELD_PATH_SEPARATOR = ",";
  
  private static final String FIELD_PATH_SEPARATOR_REGEX = ",";
  
  private static final String FIELD_SEPARATOR_REGEX = "\\.";
  
  public static FieldMask fromFieldNumbers(Class<? extends Message> paramClass, Iterable<Integer> paramIterable) {
    Descriptors.Descriptor descriptor = ((Message)Internal.getDefaultInstance(paramClass)).getDescriptorForType();
    FieldMask.Builder builder = FieldMask.newBuilder();
    for (Integer integer : paramIterable) {
      boolean bool;
      Descriptors.FieldDescriptor fieldDescriptor = descriptor.findFieldByNumber(integer.intValue());
      if (fieldDescriptor != null) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.a(bool, String.format("%s is not a valid field number for %s.", new Object[] { integer, paramClass }));
      builder.addPaths(fieldDescriptor.getName());
    } 
    return builder.build();
  }
  
  public static FieldMask fromFieldNumbers(Class<? extends Message> paramClass, int... paramVarArgs) {
    return fromFieldNumbers(paramClass, Ints.b(paramVarArgs));
  }
  
  public static FieldMask fromJsonString(String paramString) {
    Iterable iterable = Splitter.a(",").a(paramString);
    FieldMask.Builder builder = FieldMask.newBuilder();
    for (String str : iterable) {
      if (str.isEmpty())
        continue; 
      builder.addPaths(CaseFormat.c.a(CaseFormat.b, str));
    } 
    return builder.build();
  }
  
  public static FieldMask fromString(Class<? extends Message> paramClass, String paramString) {
    return fromStringList(paramClass, Arrays.asList(paramString.split(",")));
  }
  
  public static FieldMask fromString(String paramString) {
    return fromStringList(null, Arrays.asList(paramString.split(",")));
  }
  
  public static FieldMask fromStringList(Class<? extends Message> paramClass, Iterable<String> paramIterable) {
    StringBuilder stringBuilder;
    FieldMask.Builder builder = FieldMask.newBuilder();
    for (String str : paramIterable) {
      if (str.isEmpty())
        continue; 
      if (paramClass == null || isValid(paramClass, str)) {
        builder.addPaths(str);
        continue;
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(" is not a valid path for ");
      stringBuilder.append(paramClass);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    return stringBuilder.build();
  }
  
  public static FieldMask intersection(FieldMask paramFieldMask1, FieldMask paramFieldMask2) {
    FieldMaskTree fieldMaskTree1 = new FieldMaskTree(paramFieldMask1);
    FieldMaskTree fieldMaskTree2 = new FieldMaskTree();
    Iterator<String> iterator = paramFieldMask2.getPathsList().iterator();
    while (iterator.hasNext())
      fieldMaskTree1.intersectFieldPath(iterator.next(), fieldMaskTree2); 
    return fieldMaskTree2.toFieldMask();
  }
  
  public static boolean isValid(Descriptors.Descriptor paramDescriptor, FieldMask paramFieldMask) {
    Iterator<String> iterator = paramFieldMask.getPathsList().iterator();
    while (iterator.hasNext()) {
      if (!isValid(paramDescriptor, iterator.next()))
        return false; 
    } 
    return true;
  }
  
  public static boolean isValid(Descriptors.Descriptor paramDescriptor, String paramString) {
    String[] arrayOfString = paramString.split("\\.");
    if (arrayOfString.length == 0)
      return false; 
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      String str = arrayOfString[i];
      if (paramDescriptor == null)
        return false; 
      Descriptors.FieldDescriptor fieldDescriptor = paramDescriptor.findFieldByName(str);
      if (fieldDescriptor == null)
        return false; 
      if (!fieldDescriptor.isRepeated() && fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        Descriptors.Descriptor descriptor = fieldDescriptor.getMessageType();
      } else {
        fieldDescriptor = null;
      } 
    } 
    return true;
  }
  
  public static boolean isValid(Class<? extends Message> paramClass, FieldMask paramFieldMask) {
    return isValid(((Message)Internal.getDefaultInstance(paramClass)).getDescriptorForType(), paramFieldMask);
  }
  
  public static boolean isValid(Class<? extends Message> paramClass, String paramString) {
    return isValid(((Message)Internal.getDefaultInstance(paramClass)).getDescriptorForType(), paramString);
  }
  
  public static void merge(FieldMask paramFieldMask, Message paramMessage, Message.Builder paramBuilder) {
    merge(paramFieldMask, paramMessage, paramBuilder, new MergeOptions());
  }
  
  public static void merge(FieldMask paramFieldMask, Message paramMessage, Message.Builder paramBuilder, MergeOptions paramMergeOptions) {
    (new FieldMaskTree(paramFieldMask)).merge(paramMessage, paramBuilder, paramMergeOptions);
  }
  
  public static FieldMask normalize(FieldMask paramFieldMask) {
    return (new FieldMaskTree(paramFieldMask)).toFieldMask();
  }
  
  public static String toJsonString(FieldMask paramFieldMask) {
    ArrayList<String> arrayList = new ArrayList(paramFieldMask.getPathsCount());
    for (String str : paramFieldMask.getPathsList()) {
      if (str.isEmpty())
        continue; 
      arrayList.add(CaseFormat.b.a(CaseFormat.c, str));
    } 
    return Joiner.a(",").a(arrayList);
  }
  
  public static String toString(FieldMask paramFieldMask) {
    StringBuilder stringBuilder = new StringBuilder();
    Iterator<String> iterator = paramFieldMask.getPathsList().iterator();
    boolean bool = true;
    while (iterator.hasNext()) {
      String str = iterator.next();
      if (str.isEmpty())
        continue; 
      if (bool) {
        bool = false;
      } else {
        stringBuilder.append(",");
      } 
      stringBuilder.append(str);
    } 
    return stringBuilder.toString();
  }
  
  public static FieldMask union(FieldMask paramFieldMask1, FieldMask paramFieldMask2, FieldMask... paramVarArgs) {
    FieldMaskTree fieldMaskTree = (new FieldMaskTree(paramFieldMask1)).mergeFromFieldMask(paramFieldMask2);
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++)
      fieldMaskTree.mergeFromFieldMask(paramVarArgs[i]); 
    return fieldMaskTree.toFieldMask();
  }
  
  public static final class MergeOptions {
    private boolean replaceMessageFields = false;
    
    private boolean replacePrimitiveFields = false;
    
    private boolean replaceRepeatedFields = false;
    
    public boolean replaceMessageFields() {
      return this.replaceMessageFields;
    }
    
    public boolean replacePrimitiveFields() {
      return this.replacePrimitiveFields;
    }
    
    public boolean replaceRepeatedFields() {
      return this.replaceRepeatedFields;
    }
    
    public MergeOptions setReplaceMessageFields(boolean param1Boolean) {
      this.replaceMessageFields = param1Boolean;
      return this;
    }
    
    public MergeOptions setReplacePrimitiveFields(boolean param1Boolean) {
      this.replacePrimitiveFields = param1Boolean;
      return this;
    }
    
    public MergeOptions setReplaceRepeatedFields(boolean param1Boolean) {
      this.replaceRepeatedFields = param1Boolean;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobu\\util\FieldMaskUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */