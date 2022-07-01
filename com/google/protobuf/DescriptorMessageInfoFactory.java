package com.google.protobuf;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;

final class DescriptorMessageInfoFactory implements MessageInfoFactory {
  private static final String GET_DEFAULT_INSTANCE_METHOD_NAME = "getDefaultInstance";
  
  private static final DescriptorMessageInfoFactory instance = new DescriptorMessageInfoFactory();
  
  private static IsInitializedCheckAnalyzer isInitializedCheckAnalyzer;
  
  private static final Set<String> specialFieldNames = new HashSet<String>(Arrays.asList(new String[] { "cached_size", "serialized_size", "class" }));
  
  static {
    isInitializedCheckAnalyzer = new IsInitializedCheckAnalyzer();
  }
  
  private static Field bitField(Class<?> paramClass, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("bitField");
    stringBuilder.append(paramInt);
    stringBuilder.append("_");
    return field(paramClass, stringBuilder.toString());
  }
  
  private static FieldInfo buildOneofMember(Class<?> paramClass, Descriptors.FieldDescriptor paramFieldDescriptor, OneofState paramOneofState, boolean paramBoolean, Internal.EnumVerifier paramEnumVerifier) {
    OneofInfo oneofInfo = paramOneofState.getOneof(paramClass, paramFieldDescriptor.getContainingOneof());
    FieldType fieldType = getFieldType(paramFieldDescriptor);
    paramClass = getOneofStoredType(paramClass, paramFieldDescriptor, fieldType);
    return FieldInfo.forOneofMemberField(paramFieldDescriptor.getNumber(), fieldType, oneofInfo, paramClass, paramBoolean, paramEnumVerifier);
  }
  
  private static Field cachedSizeField(Class<?> paramClass, Descriptors.FieldDescriptor paramFieldDescriptor) {
    return field(paramClass, getCachedSizeFieldName(paramFieldDescriptor));
  }
  
  private static MessageInfo convert(Class<?> paramClass, Descriptors.Descriptor paramDescriptor) {
    StringBuilder stringBuilder;
    int i = null.$SwitchMap$com$google$protobuf$Descriptors$FileDescriptor$Syntax[paramDescriptor.getFile().getSyntax().ordinal()];
    if (i != 1) {
      if (i == 2)
        return convertProto3(paramClass, paramDescriptor); 
      stringBuilder = new StringBuilder();
      stringBuilder.append("Unsupported syntax: ");
      stringBuilder.append(paramDescriptor.getFile().getSyntax());
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    return convertProto2((Class<?>)stringBuilder, paramDescriptor);
  }
  
  private static StructuralMessageInfo convertProto2(Class<?> paramClass, Descriptors.Descriptor paramDescriptor) {
    List<Descriptors.FieldDescriptor> list = paramDescriptor.getFields();
    StructuralMessageInfo.Builder builder = StructuralMessageInfo.newBuilder(list.size());
    builder.withDefaultInstance(getDefaultInstance(paramClass));
    builder.withSyntax(ProtoSyntax.PROTO2);
    builder.withMessageSetWireFormat(paramDescriptor.getOptions().getMessageSetWireFormat());
    OneofState oneofState = new OneofState();
    boolean bool2 = false;
    paramDescriptor = null;
    int j = 0;
    boolean bool1 = false;
    int i;
    for (i = 1;; i <<= 1) {
      if (j < list.size()) {
        Internal.EnumVerifier enumVerifier;
        final Descriptors.FieldDescriptor fd = list.get(j);
        boolean bool = fieldDescriptor.getFile().getOptions().getJavaStringCheckUtf8();
        if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) {
          enumVerifier = new Internal.EnumVerifier() {
              public boolean isInRange(int param1Int) {
                return (fd.getEnumType().findValueByNumber(param1Int) != null);
              }
            };
        } else {
          enumVerifier = null;
        } 
        if (fieldDescriptor.getContainingOneof() != null) {
          builder.withField(buildOneofMember(paramClass, fieldDescriptor, oneofState, bool, enumVerifier));
        } else {
          Field field = field(paramClass, fieldDescriptor);
          int k = fieldDescriptor.getNumber();
          FieldType fieldType = getFieldType(fieldDescriptor);
          if (fieldDescriptor.isMapField()) {
            final Descriptors.FieldDescriptor valueField = fieldDescriptor.getMessageType().findFieldByNumber(2);
            if (fieldDescriptor1.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM)
              enumVerifier = new Internal.EnumVerifier() {
                  public boolean isInRange(int param1Int) {
                    return (valueField.getEnumType().findValueByNumber(param1Int) != null);
                  }
                }; 
            builder.withField(FieldInfo.forMapField(field, k, SchemaUtil.getMapDefaultEntry(paramClass, fieldDescriptor.getName()), enumVerifier));
          } else if (fieldDescriptor.isRepeated()) {
            if (enumVerifier != null) {
              if (fieldDescriptor.isPacked()) {
                builder.withField(FieldInfo.forPackedFieldWithEnumVerifier(field, k, fieldType, enumVerifier, cachedSizeField(paramClass, fieldDescriptor)));
              } else {
                builder.withField(FieldInfo.forFieldWithEnumVerifier(field, k, fieldType, enumVerifier));
              } 
            } else if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
              builder.withField(FieldInfo.forRepeatedMessageField(field, k, fieldType, getTypeForRepeatedMessageField(paramClass, fieldDescriptor)));
            } else if (fieldDescriptor.isPacked()) {
              builder.withField(FieldInfo.forPackedField(field, k, fieldType, cachedSizeField(paramClass, fieldDescriptor)));
            } else {
              builder.withField(FieldInfo.forField(field, k, fieldType, bool));
            } 
          } else {
            Field field1;
            Descriptors.Descriptor descriptor = paramDescriptor;
            if (paramDescriptor == null)
              field1 = bitField(paramClass, bool1); 
            if (fieldDescriptor.isRequired()) {
              builder.withField(FieldInfo.forProto2RequiredField(field, k, fieldType, field1, i, bool, enumVerifier));
              Field field2 = field1;
            } else {
              builder.withField(FieldInfo.forProto2OptionalField(field, k, fieldType, field1, i, bool, enumVerifier));
              Field field2 = field1;
            } 
            i <<= 1;
          } 
          j++;
        } 
      } else {
        break;
      } 
    } 
    ArrayList<Integer> arrayList = new ArrayList();
    for (i = 0; i < list.size(); i++) {
      final Descriptors.FieldDescriptor fd = list.get(i);
      if (fieldDescriptor.isRequired() || (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE && needsIsInitializedCheck(fieldDescriptor.getMessageType())))
        arrayList.add(Integer.valueOf(fieldDescriptor.getNumber())); 
    } 
    int[] arrayOfInt = new int[arrayList.size()];
    for (i = bool2; i < arrayList.size(); i++)
      arrayOfInt[i] = ((Integer)arrayList.get(i)).intValue(); 
    builder.withCheckInitialized(arrayOfInt);
    return builder.build();
  }
  
  private static StructuralMessageInfo convertProto3(Class<?> paramClass, Descriptors.Descriptor paramDescriptor) {
    List<Descriptors.FieldDescriptor> list = paramDescriptor.getFields();
    StructuralMessageInfo.Builder builder = StructuralMessageInfo.newBuilder(list.size());
    builder.withDefaultInstance(getDefaultInstance(paramClass));
    builder.withSyntax(ProtoSyntax.PROTO3);
    OneofState oneofState = new OneofState();
    for (int i = 0; i < list.size(); i++) {
      Descriptors.FieldDescriptor fieldDescriptor = list.get(i);
      if (fieldDescriptor.getContainingOneof() != null) {
        builder.withField(buildOneofMember(paramClass, fieldDescriptor, oneofState, true, null));
      } else if (fieldDescriptor.isMapField()) {
        builder.withField(FieldInfo.forMapField(field(paramClass, fieldDescriptor), fieldDescriptor.getNumber(), SchemaUtil.getMapDefaultEntry(paramClass, fieldDescriptor.getName()), null));
      } else if (fieldDescriptor.isRepeated() && fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        builder.withField(FieldInfo.forRepeatedMessageField(field(paramClass, fieldDescriptor), fieldDescriptor.getNumber(), getFieldType(fieldDescriptor), getTypeForRepeatedMessageField(paramClass, fieldDescriptor)));
      } else if (fieldDescriptor.isPacked()) {
        builder.withField(FieldInfo.forPackedField(field(paramClass, fieldDescriptor), fieldDescriptor.getNumber(), getFieldType(fieldDescriptor), cachedSizeField(paramClass, fieldDescriptor)));
      } else {
        builder.withField(FieldInfo.forField(field(paramClass, fieldDescriptor), fieldDescriptor.getNumber(), getFieldType(fieldDescriptor), true));
      } 
    } 
    return builder.build();
  }
  
  private static Descriptors.Descriptor descriptorForType(Class<?> paramClass) {
    return getDefaultInstance(paramClass).getDescriptorForType();
  }
  
  private static Field field(Class<?> paramClass, Descriptors.FieldDescriptor paramFieldDescriptor) {
    return field(paramClass, getFieldName(paramFieldDescriptor));
  }
  
  private static Field field(Class<?> paramClass, String paramString) {
    try {
      return paramClass.getDeclaredField(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to find field ");
      stringBuilder.append(paramString);
      stringBuilder.append(" in message class ");
      stringBuilder.append(paramClass.getName());
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
  }
  
  private static String getCachedSizeFieldName(Descriptors.FieldDescriptor paramFieldDescriptor) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(snakeCaseToCamelCase(paramFieldDescriptor.getName()));
    stringBuilder.append("MemoizedSerializedSize");
    return stringBuilder.toString();
  }
  
  private static Message getDefaultInstance(Class<?> paramClass) {
    try {
      return (Message)paramClass.getDeclaredMethod("getDefaultInstance", new Class[0]).invoke(null, new Object[0]);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unable to get default instance for message class ");
      stringBuilder.append(paramClass.getName());
      throw new IllegalArgumentException(stringBuilder.toString(), exception);
    } 
  }
  
  static String getFieldName(Descriptors.FieldDescriptor paramFieldDescriptor) {
    String str1;
    String str2;
    if (paramFieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.GROUP) {
      str1 = paramFieldDescriptor.getMessageType().getName();
    } else {
      str1 = str1.getName();
    } 
    if (specialFieldNames.contains(str1)) {
      str2 = "__";
    } else {
      str2 = "_";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(snakeCaseToCamelCase(str1));
    stringBuilder.append(str2);
    return stringBuilder.toString();
  }
  
  private static FieldType getFieldType(Descriptors.FieldDescriptor paramFieldDescriptor) {
    StringBuilder stringBuilder;
    switch (paramFieldDescriptor.getType()) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported field type: ");
        stringBuilder.append(paramFieldDescriptor.getType());
        throw new IllegalArgumentException(stringBuilder.toString());
      case UINT64:
        return !paramFieldDescriptor.isRepeated() ? FieldType.UINT64 : (paramFieldDescriptor.isPacked() ? FieldType.UINT64_LIST_PACKED : FieldType.UINT64_LIST);
      case UINT32:
        return !paramFieldDescriptor.isRepeated() ? FieldType.UINT32 : (paramFieldDescriptor.isPacked() ? FieldType.UINT32_LIST_PACKED : FieldType.UINT32_LIST);
      case STRING:
        return paramFieldDescriptor.isRepeated() ? FieldType.STRING_LIST : FieldType.STRING;
      case SINT64:
        return !paramFieldDescriptor.isRepeated() ? FieldType.SINT64 : (paramFieldDescriptor.isPacked() ? FieldType.SINT64_LIST_PACKED : FieldType.SINT64_LIST);
      case SINT32:
        return !paramFieldDescriptor.isRepeated() ? FieldType.SINT32 : (paramFieldDescriptor.isPacked() ? FieldType.SINT32_LIST_PACKED : FieldType.SINT32_LIST);
      case SFIXED64:
        return !paramFieldDescriptor.isRepeated() ? FieldType.SFIXED64 : (paramFieldDescriptor.isPacked() ? FieldType.SFIXED64_LIST_PACKED : FieldType.SFIXED64_LIST);
      case SFIXED32:
        return !paramFieldDescriptor.isRepeated() ? FieldType.SFIXED32 : (paramFieldDescriptor.isPacked() ? FieldType.SFIXED32_LIST_PACKED : FieldType.SFIXED32_LIST);
      case MESSAGE:
        return paramFieldDescriptor.isMapField() ? FieldType.MAP : (paramFieldDescriptor.isRepeated() ? FieldType.MESSAGE_LIST : FieldType.MESSAGE);
      case INT64:
        return !paramFieldDescriptor.isRepeated() ? FieldType.INT64 : (paramFieldDescriptor.isPacked() ? FieldType.INT64_LIST_PACKED : FieldType.INT64_LIST);
      case INT32:
        return !paramFieldDescriptor.isRepeated() ? FieldType.INT32 : (paramFieldDescriptor.isPacked() ? FieldType.INT32_LIST_PACKED : FieldType.INT32_LIST);
      case GROUP:
        return paramFieldDescriptor.isRepeated() ? FieldType.GROUP_LIST : FieldType.GROUP;
      case FLOAT:
        return !paramFieldDescriptor.isRepeated() ? FieldType.FLOAT : (paramFieldDescriptor.isPacked() ? FieldType.FLOAT_LIST_PACKED : FieldType.FLOAT_LIST);
      case FIXED64:
        return !paramFieldDescriptor.isRepeated() ? FieldType.FIXED64 : (paramFieldDescriptor.isPacked() ? FieldType.FIXED64_LIST_PACKED : FieldType.FIXED64_LIST);
      case FIXED32:
        return !paramFieldDescriptor.isRepeated() ? FieldType.FIXED32 : (paramFieldDescriptor.isPacked() ? FieldType.FIXED32_LIST_PACKED : FieldType.FIXED32_LIST);
      case ENUM:
        return !paramFieldDescriptor.isRepeated() ? FieldType.ENUM : (paramFieldDescriptor.isPacked() ? FieldType.ENUM_LIST_PACKED : FieldType.ENUM_LIST);
      case DOUBLE:
        return !paramFieldDescriptor.isRepeated() ? FieldType.DOUBLE : (paramFieldDescriptor.isPacked() ? FieldType.DOUBLE_LIST_PACKED : FieldType.DOUBLE_LIST);
      case BYTES:
        return paramFieldDescriptor.isRepeated() ? FieldType.BYTES_LIST : FieldType.BYTES;
      case BOOL:
        break;
    } 
    return !paramFieldDescriptor.isRepeated() ? FieldType.BOOL : (paramFieldDescriptor.isPacked() ? FieldType.BOOL_LIST_PACKED : FieldType.BOOL_LIST);
  }
  
  public static DescriptorMessageInfoFactory getInstance() {
    return instance;
  }
  
  private static Class<?> getOneofStoredType(Class<?> paramClass, Descriptors.FieldDescriptor paramFieldDescriptor, FieldType paramFieldType) {
    StringBuilder stringBuilder;
    switch (paramFieldType.getJavaType()) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid type for oneof: ");
        stringBuilder.append(paramFieldType);
        throw new IllegalArgumentException(stringBuilder.toString());
      case INT32:
        return getOneofStoredTypeForMessage((Class<?>)stringBuilder, paramFieldDescriptor);
      case GROUP:
        return String.class;
      case FLOAT:
        return Long.class;
      case FIXED32:
      case FIXED64:
        return Integer.class;
      case ENUM:
        return Float.class;
      case DOUBLE:
        return Double.class;
      case BYTES:
        return ByteString.class;
      case BOOL:
        break;
    } 
    return Boolean.class;
  }
  
  private static Class<?> getOneofStoredTypeForMessage(Class<?> paramClass, Descriptors.FieldDescriptor paramFieldDescriptor) {
    try {
      String str;
      if (paramFieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.GROUP) {
        str = paramFieldDescriptor.getMessageType().getName();
      } else {
        str = str.getName();
      } 
      return paramClass.getDeclaredMethod(getterForField(str), new Class[0]).getReturnType();
    } catch (Exception exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  private static Class<?> getTypeForRepeatedMessageField(Class<?> paramClass, Descriptors.FieldDescriptor paramFieldDescriptor) {
    try {
      String str;
      if (paramFieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.GROUP) {
        str = paramFieldDescriptor.getMessageType().getName();
      } else {
        str = str.getName();
      } 
      return paramClass.getDeclaredMethod(getterForField(str), new Class[] { int.class }).getReturnType();
    } catch (Exception exception) {
      throw new RuntimeException(exception);
    } 
  }
  
  private static String getterForField(String paramString) {
    paramString = snakeCaseToCamelCase(paramString);
    StringBuilder stringBuilder = new StringBuilder("get");
    stringBuilder.append(Character.toUpperCase(paramString.charAt(0)));
    stringBuilder.append(paramString.substring(1, paramString.length()));
    return stringBuilder.toString();
  }
  
  private static boolean needsIsInitializedCheck(Descriptors.Descriptor paramDescriptor) {
    return isInitializedCheckAnalyzer.needsIsInitializedCheck(paramDescriptor);
  }
  
  private static String snakeCaseToCamelCase(String paramString) {
    StringBuilder stringBuilder = new StringBuilder(paramString.length() + 1);
    int i = 0;
    boolean bool = false;
    while (true) {
      if (i < paramString.length()) {
        char c = paramString.charAt(i);
        if (c != '_')
          if (Character.isDigit(c)) {
            stringBuilder.append(c);
          } else {
            if (bool) {
              stringBuilder.append(Character.toUpperCase(c));
              bool = false;
            } else if (i == 0) {
              stringBuilder.append(Character.toLowerCase(c));
            } else {
              stringBuilder.append(c);
            } 
            i++;
          }  
        bool = true;
      } else {
        break;
      } 
      i++;
    } 
    return stringBuilder.toString();
  }
  
  public boolean isSupported(Class<?> paramClass) {
    return GeneratedMessageV3.class.isAssignableFrom(paramClass);
  }
  
  public MessageInfo messageInfoFor(Class<?> paramClass) {
    if (GeneratedMessageV3.class.isAssignableFrom(paramClass))
      return convert(paramClass, descriptorForType(paramClass)); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unsupported message type: ");
    stringBuilder.append(paramClass.getName());
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  static class IsInitializedCheckAnalyzer {
    private int index = 0;
    
    private final Map<Descriptors.Descriptor, Node> nodeCache = new HashMap<Descriptors.Descriptor, Node>();
    
    private final Map<Descriptors.Descriptor, Boolean> resultCache = new ConcurrentHashMap<Descriptors.Descriptor, Boolean>();
    
    private final Stack<Node> stack = new Stack<Node>();
    
    private void analyze(StronglyConnectedComponent param1StronglyConnectedComponent) {
      boolean bool;
      null = param1StronglyConnectedComponent.messages.iterator();
      label27: while (true) {
        boolean bool1 = null.hasNext();
        bool = true;
        if (bool1) {
          Descriptors.Descriptor descriptor = null.next();
          if (descriptor.isExtendable())
            break; 
          for (Descriptors.FieldDescriptor fieldDescriptor : descriptor.getFields()) {
            if (fieldDescriptor.isRequired())
              break label27; 
            if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
              Node node = this.nodeCache.get(fieldDescriptor.getMessageType());
              if (node.component != param1StronglyConnectedComponent && node.component.needsIsInitializedCheck)
                break label27; 
            } 
          } 
          continue;
        } 
        bool = false;
        break;
      } 
      param1StronglyConnectedComponent.needsIsInitializedCheck = bool;
      for (Descriptors.Descriptor descriptor : param1StronglyConnectedComponent.messages)
        this.resultCache.put(descriptor, Boolean.valueOf(param1StronglyConnectedComponent.needsIsInitializedCheck)); 
    }
    
    private Node dfs(Descriptors.Descriptor param1Descriptor) {
      int i = this.index;
      this.index = i + 1;
      Node node = new Node(param1Descriptor, i);
      this.stack.push(node);
      this.nodeCache.put(param1Descriptor, node);
      for (Descriptors.FieldDescriptor fieldDescriptor : param1Descriptor.getFields()) {
        if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
          Node node1 = this.nodeCache.get(fieldDescriptor.getMessageType());
          if (node1 == null) {
            Node node2 = dfs(fieldDescriptor.getMessageType());
            node.lowLink = Math.min(node.lowLink, node2.lowLink);
            continue;
          } 
          if (node1.component == null)
            node.lowLink = Math.min(node.lowLink, node1.lowLink); 
        } 
      } 
      if (node.index == node.lowLink) {
        StronglyConnectedComponent stronglyConnectedComponent = new StronglyConnectedComponent();
        while (true) {
          Node node1 = this.stack.pop();
          node1.component = stronglyConnectedComponent;
          stronglyConnectedComponent.messages.add(node1.descriptor);
          if (node1 == node) {
            analyze(stronglyConnectedComponent);
            break;
          } 
        } 
      } 
      return node;
    }
    
    public boolean needsIsInitializedCheck(Descriptors.Descriptor param1Descriptor) {
      // Byte code:
      //   0: aload_0
      //   1: getfield resultCache : Ljava/util/Map;
      //   4: aload_1
      //   5: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   10: checkcast java/lang/Boolean
      //   13: astore_3
      //   14: aload_3
      //   15: ifnull -> 23
      //   18: aload_3
      //   19: invokevirtual booleanValue : ()Z
      //   22: ireturn
      //   23: aload_0
      //   24: monitorenter
      //   25: aload_0
      //   26: getfield resultCache : Ljava/util/Map;
      //   29: aload_1
      //   30: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   35: checkcast java/lang/Boolean
      //   38: astore_3
      //   39: aload_3
      //   40: ifnull -> 52
      //   43: aload_3
      //   44: invokevirtual booleanValue : ()Z
      //   47: istore_2
      //   48: aload_0
      //   49: monitorexit
      //   50: iload_2
      //   51: ireturn
      //   52: aload_0
      //   53: aload_1
      //   54: invokespecial dfs : (Lcom/google/protobuf/Descriptors$Descriptor;)Lcom/google/protobuf/DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$Node;
      //   57: getfield component : Lcom/google/protobuf/DescriptorMessageInfoFactory$IsInitializedCheckAnalyzer$StronglyConnectedComponent;
      //   60: getfield needsIsInitializedCheck : Z
      //   63: istore_2
      //   64: aload_0
      //   65: monitorexit
      //   66: iload_2
      //   67: ireturn
      //   68: astore_1
      //   69: aload_0
      //   70: monitorexit
      //   71: aload_1
      //   72: athrow
      // Exception table:
      //   from	to	target	type
      //   25	39	68	finally
      //   43	50	68	finally
      //   52	66	68	finally
      //   69	71	68	finally
    }
    
    static class Node {
      DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.StronglyConnectedComponent component;
      
      final Descriptors.Descriptor descriptor;
      
      final int index;
      
      int lowLink;
      
      Node(Descriptors.Descriptor param2Descriptor, int param2Int) {
        this.descriptor = param2Descriptor;
        this.index = param2Int;
        this.lowLink = param2Int;
        this.component = null;
      }
    }
    
    static class StronglyConnectedComponent {
      final List<Descriptors.Descriptor> messages = new ArrayList<Descriptors.Descriptor>();
      
      boolean needsIsInitializedCheck = false;
      
      private StronglyConnectedComponent() {}
    }
  }
  
  static class Node {
    DescriptorMessageInfoFactory.IsInitializedCheckAnalyzer.StronglyConnectedComponent component;
    
    final Descriptors.Descriptor descriptor;
    
    final int index;
    
    int lowLink;
    
    Node(Descriptors.Descriptor param1Descriptor, int param1Int) {
      this.descriptor = param1Descriptor;
      this.index = param1Int;
      this.lowLink = param1Int;
      this.component = null;
    }
  }
  
  static class StronglyConnectedComponent {
    final List<Descriptors.Descriptor> messages = new ArrayList<Descriptors.Descriptor>();
    
    boolean needsIsInitializedCheck = false;
    
    private StronglyConnectedComponent() {}
  }
  
  static final class OneofState {
    private OneofInfo[] oneofs = new OneofInfo[2];
    
    private OneofState() {}
    
    private static OneofInfo newInfo(Class<?> param1Class, Descriptors.OneofDescriptor param1OneofDescriptor) {
      String str1 = DescriptorMessageInfoFactory.snakeCaseToCamelCase(param1OneofDescriptor.getName());
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append("_");
      String str2 = stringBuilder1.toString();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str1);
      stringBuilder2.append("Case_");
      str1 = stringBuilder2.toString();
      return new OneofInfo(param1OneofDescriptor.getIndex(), DescriptorMessageInfoFactory.field(param1Class, str1), DescriptorMessageInfoFactory.field(param1Class, str2));
    }
    
    OneofInfo getOneof(Class<?> param1Class, Descriptors.OneofDescriptor param1OneofDescriptor) {
      int i = param1OneofDescriptor.getIndex();
      OneofInfo[] arrayOfOneofInfo = this.oneofs;
      if (i >= arrayOfOneofInfo.length)
        this.oneofs = Arrays.<OneofInfo>copyOf(arrayOfOneofInfo, i * 2); 
      OneofInfo oneofInfo2 = this.oneofs[i];
      OneofInfo oneofInfo1 = oneofInfo2;
      if (oneofInfo2 == null) {
        oneofInfo1 = newInfo(param1Class, param1OneofDescriptor);
        this.oneofs[i] = oneofInfo1;
      } 
      return oneofInfo1;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\DescriptorMessageInfoFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */