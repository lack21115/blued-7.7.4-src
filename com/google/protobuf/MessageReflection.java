package com.google.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class MessageReflection {
  static String delimitWithCommas(List<String> paramList) {
    StringBuilder stringBuilder = new StringBuilder();
    for (String str : paramList) {
      if (stringBuilder.length() > 0)
        stringBuilder.append(", "); 
      stringBuilder.append(str);
    } 
    return stringBuilder.toString();
  }
  
  private static void eagerlyMergeMessageSetExtension(CodedInputStream paramCodedInputStream, ExtensionRegistry.ExtensionInfo paramExtensionInfo, ExtensionRegistryLite paramExtensionRegistryLite, MergeTarget paramMergeTarget) throws IOException {
    Descriptors.FieldDescriptor fieldDescriptor = paramExtensionInfo.descriptor;
    paramMergeTarget.setField(fieldDescriptor, paramMergeTarget.parseMessage(paramCodedInputStream, paramExtensionRegistryLite, fieldDescriptor, paramExtensionInfo.defaultInstance));
  }
  
  static List<String> findMissingFields(MessageOrBuilder paramMessageOrBuilder) {
    ArrayList<String> arrayList = new ArrayList();
    findMissingFields(paramMessageOrBuilder, "", arrayList);
    return arrayList;
  }
  
  private static void findMissingFields(MessageOrBuilder paramMessageOrBuilder, String paramString, List<String> paramList) {
    for (Descriptors.FieldDescriptor fieldDescriptor : paramMessageOrBuilder.getDescriptorForType().getFields()) {
      if (fieldDescriptor.isRequired() && !paramMessageOrBuilder.hasField(fieldDescriptor)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramString);
        stringBuilder.append(fieldDescriptor.getName());
        paramList.add(stringBuilder.toString());
      } 
    } 
    for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : paramMessageOrBuilder.getAllFields().entrySet()) {
      Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor)entry.getKey();
      entry = (Map.Entry<Descriptors.FieldDescriptor, Object>)entry.getValue();
      if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        Iterator<MessageOrBuilder> iterator;
        if (fieldDescriptor.isRepeated()) {
          int i = 0;
          iterator = ((List)entry).iterator();
          while (iterator.hasNext()) {
            findMissingFields(iterator.next(), subMessagePrefix(paramString, fieldDescriptor, i), paramList);
            i++;
          } 
          continue;
        } 
        if (paramMessageOrBuilder.hasField(fieldDescriptor))
          findMissingFields((MessageOrBuilder)iterator, subMessagePrefix(paramString, fieldDescriptor, -1), paramList); 
      } 
    } 
  }
  
  static int getSerializedSize(Message paramMessage, Map<Descriptors.FieldDescriptor, Object> paramMap) {
    int j;
    boolean bool = paramMessage.getDescriptorForType().getOptions().getMessageSetWireFormat();
    Iterator<Map.Entry> iterator = paramMap.entrySet().iterator();
    int i;
    for (i = 0; iterator.hasNext(); i += j) {
      Map.Entry entry = iterator.next();
      Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor)entry.getKey();
      entry = (Map.Entry)entry.getValue();
      if (bool && fieldDescriptor.isExtension() && fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && !fieldDescriptor.isRepeated()) {
        j = CodedOutputStream.computeMessageSetExtensionSize(fieldDescriptor.getNumber(), (Message)entry);
      } else {
        j = FieldSet.computeFieldSize(fieldDescriptor, entry);
      } 
    } 
    UnknownFieldSet unknownFieldSet = paramMessage.getUnknownFields();
    if (bool) {
      j = unknownFieldSet.getSerializedSizeAsMessageSet();
    } else {
      j = unknownFieldSet.getSerializedSize();
    } 
    return i + j;
  }
  
  static boolean isInitialized(MessageOrBuilder paramMessageOrBuilder) {
    for (Descriptors.FieldDescriptor fieldDescriptor : paramMessageOrBuilder.getDescriptorForType().getFields()) {
      if (fieldDescriptor.isRequired() && !paramMessageOrBuilder.hasField(fieldDescriptor))
        return false; 
    } 
    for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : paramMessageOrBuilder.getAllFields().entrySet()) {
      Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor)entry.getKey();
      if (fieldDescriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
        Iterator<Message> iterator;
        if (fieldDescriptor.isRepeated()) {
          iterator = ((List)entry.getValue()).iterator();
          while (iterator.hasNext()) {
            if (!((Message)iterator.next()).isInitialized())
              return false; 
          } 
          continue;
        } 
        if (!((Message)iterator.getValue()).isInitialized())
          return false; 
      } 
    } 
    return true;
  }
  
  static boolean mergeFieldFrom(CodedInputStream paramCodedInputStream, UnknownFieldSet.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite, Descriptors.Descriptor paramDescriptor, MergeTarget paramMergeTarget, int paramInt) throws IOException {
    // Byte code:
    //   0: aload_3
    //   1: invokevirtual getOptions : ()Lcom/google/protobuf/DescriptorProtos$MessageOptions;
    //   4: invokevirtual getMessageSetWireFormat : ()Z
    //   7: ifeq -> 29
    //   10: iload #5
    //   12: getstatic com/google/protobuf/WireFormat.MESSAGE_SET_ITEM_TAG : I
    //   15: if_icmpne -> 29
    //   18: aload_0
    //   19: aload_1
    //   20: aload_2
    //   21: aload_3
    //   22: aload #4
    //   24: invokestatic mergeMessageSetExtensionFromCodedStream : (Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;Lcom/google/protobuf/Descriptors$Descriptor;Lcom/google/protobuf/MessageReflection$MergeTarget;)V
    //   27: iconst_1
    //   28: ireturn
    //   29: iload #5
    //   31: invokestatic getTagWireType : (I)I
    //   34: istore #6
    //   36: iload #5
    //   38: invokestatic getTagFieldNumber : (I)I
    //   41: istore #8
    //   43: aload_3
    //   44: iload #8
    //   46: invokevirtual isExtensionNumber : (I)Z
    //   49: istore #9
    //   51: aconst_null
    //   52: astore #11
    //   54: iload #9
    //   56: ifeq -> 160
    //   59: aload_2
    //   60: instanceof com/google/protobuf/ExtensionRegistry
    //   63: ifeq -> 186
    //   66: aload #4
    //   68: aload_2
    //   69: checkcast com/google/protobuf/ExtensionRegistry
    //   72: aload_3
    //   73: iload #8
    //   75: invokeinterface findExtensionByNumber : (Lcom/google/protobuf/ExtensionRegistry;Lcom/google/protobuf/Descriptors$Descriptor;I)Lcom/google/protobuf/ExtensionRegistry$ExtensionInfo;
    //   80: astore #10
    //   82: aload #10
    //   84: ifnonnull -> 90
    //   87: goto -> 186
    //   90: aload #10
    //   92: getfield descriptor : Lcom/google/protobuf/Descriptors$FieldDescriptor;
    //   95: astore_3
    //   96: aload #10
    //   98: getfield defaultInstance : Lcom/google/protobuf/Message;
    //   101: astore #10
    //   103: aload #10
    //   105: ifnonnull -> 157
    //   108: aload_3
    //   109: invokevirtual getJavaType : ()Lcom/google/protobuf/Descriptors$FieldDescriptor$JavaType;
    //   112: getstatic com/google/protobuf/Descriptors$FieldDescriptor$JavaType.MESSAGE : Lcom/google/protobuf/Descriptors$FieldDescriptor$JavaType;
    //   115: if_acmpeq -> 121
    //   118: goto -> 157
    //   121: new java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial <init> : ()V
    //   128: astore_0
    //   129: aload_0
    //   130: ldc 'Message-typed extension lacked default instance: '
    //   132: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_0
    //   137: aload_3
    //   138: invokevirtual getFullName : ()Ljava/lang/String;
    //   141: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: new java/lang/IllegalStateException
    //   148: dup
    //   149: aload_0
    //   150: invokevirtual toString : ()Ljava/lang/String;
    //   153: invokespecial <init> : (Ljava/lang/String;)V
    //   156: athrow
    //   157: goto -> 192
    //   160: aload #4
    //   162: invokeinterface getContainerType : ()Lcom/google/protobuf/MessageReflection$MergeTarget$ContainerType;
    //   167: getstatic com/google/protobuf/MessageReflection$MergeTarget$ContainerType.MESSAGE : Lcom/google/protobuf/MessageReflection$MergeTarget$ContainerType;
    //   170: if_acmpne -> 186
    //   173: aload_3
    //   174: iload #8
    //   176: invokevirtual findFieldByNumber : (I)Lcom/google/protobuf/Descriptors$FieldDescriptor;
    //   179: astore_3
    //   180: aconst_null
    //   181: astore #10
    //   183: goto -> 192
    //   186: aconst_null
    //   187: astore #10
    //   189: aload #11
    //   191: astore_3
    //   192: iconst_0
    //   193: istore #7
    //   195: aload_3
    //   196: ifnonnull -> 208
    //   199: iconst_0
    //   200: istore #6
    //   202: iconst_1
    //   203: istore #7
    //   205: goto -> 250
    //   208: iload #6
    //   210: aload_3
    //   211: invokevirtual getLiteType : ()Lcom/google/protobuf/WireFormat$FieldType;
    //   214: iconst_0
    //   215: invokestatic getWireFormatForFieldType : (Lcom/google/protobuf/WireFormat$FieldType;Z)I
    //   218: if_icmpne -> 227
    //   221: iconst_0
    //   222: istore #6
    //   224: goto -> 250
    //   227: aload_3
    //   228: invokevirtual isPackable : ()Z
    //   231: ifeq -> 199
    //   234: iload #6
    //   236: aload_3
    //   237: invokevirtual getLiteType : ()Lcom/google/protobuf/WireFormat$FieldType;
    //   240: iconst_1
    //   241: invokestatic getWireFormatForFieldType : (Lcom/google/protobuf/WireFormat$FieldType;Z)I
    //   244: if_icmpne -> 199
    //   247: iconst_1
    //   248: istore #6
    //   250: iload #7
    //   252: ifeq -> 274
    //   255: aload_1
    //   256: ifnull -> 267
    //   259: aload_1
    //   260: iload #5
    //   262: aload_0
    //   263: invokevirtual mergeFieldFrom : (ILcom/google/protobuf/CodedInputStream;)Z
    //   266: ireturn
    //   267: aload_0
    //   268: iload #5
    //   270: invokevirtual skipField : (I)Z
    //   273: ireturn
    //   274: iload #6
    //   276: ifeq -> 429
    //   279: aload_0
    //   280: aload_0
    //   281: invokevirtual readRawVarint32 : ()I
    //   284: invokevirtual pushLimit : (I)I
    //   287: istore #5
    //   289: aload_3
    //   290: invokevirtual getLiteType : ()Lcom/google/protobuf/WireFormat$FieldType;
    //   293: getstatic com/google/protobuf/WireFormat$FieldType.ENUM : Lcom/google/protobuf/WireFormat$FieldType;
    //   296: if_acmpne -> 386
    //   299: aload_0
    //   300: invokevirtual getBytesUntilLimit : ()I
    //   303: ifle -> 421
    //   306: aload_0
    //   307: invokevirtual readEnum : ()I
    //   310: istore #6
    //   312: aload_3
    //   313: invokevirtual getFile : ()Lcom/google/protobuf/Descriptors$FileDescriptor;
    //   316: invokevirtual supportsUnknownEnumValue : ()Z
    //   319: ifeq -> 343
    //   322: aload #4
    //   324: aload_3
    //   325: aload_3
    //   326: invokevirtual getEnumType : ()Lcom/google/protobuf/Descriptors$EnumDescriptor;
    //   329: iload #6
    //   331: invokevirtual findValueByNumberCreatingIfUnknown : (I)Lcom/google/protobuf/Descriptors$EnumValueDescriptor;
    //   334: invokeinterface addRepeatedField : (Lcom/google/protobuf/Descriptors$FieldDescriptor;Ljava/lang/Object;)Lcom/google/protobuf/MessageReflection$MergeTarget;
    //   339: pop
    //   340: goto -> 299
    //   343: aload_3
    //   344: invokevirtual getEnumType : ()Lcom/google/protobuf/Descriptors$EnumDescriptor;
    //   347: iload #6
    //   349: invokevirtual findValueByNumber : (I)Lcom/google/protobuf/Descriptors$EnumValueDescriptor;
    //   352: astore_2
    //   353: aload_2
    //   354: ifnonnull -> 373
    //   357: aload_1
    //   358: ifnull -> 299
    //   361: aload_1
    //   362: iload #8
    //   364: iload #6
    //   366: invokevirtual mergeVarintField : (II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   369: pop
    //   370: goto -> 299
    //   373: aload #4
    //   375: aload_3
    //   376: aload_2
    //   377: invokeinterface addRepeatedField : (Lcom/google/protobuf/Descriptors$FieldDescriptor;Ljava/lang/Object;)Lcom/google/protobuf/MessageReflection$MergeTarget;
    //   382: pop
    //   383: goto -> 299
    //   386: aload_0
    //   387: invokevirtual getBytesUntilLimit : ()I
    //   390: ifle -> 421
    //   393: aload #4
    //   395: aload_3
    //   396: aload_0
    //   397: aload_3
    //   398: invokevirtual getLiteType : ()Lcom/google/protobuf/WireFormat$FieldType;
    //   401: aload #4
    //   403: aload_3
    //   404: invokeinterface getUtf8Validation : (Lcom/google/protobuf/Descriptors$FieldDescriptor;)Lcom/google/protobuf/WireFormat$Utf8Validation;
    //   409: invokestatic readPrimitiveField : (Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/WireFormat$FieldType;Lcom/google/protobuf/WireFormat$Utf8Validation;)Ljava/lang/Object;
    //   412: invokeinterface addRepeatedField : (Lcom/google/protobuf/Descriptors$FieldDescriptor;Ljava/lang/Object;)Lcom/google/protobuf/MessageReflection$MergeTarget;
    //   417: pop
    //   418: goto -> 386
    //   421: aload_0
    //   422: iload #5
    //   424: invokevirtual popLimit : (I)V
    //   427: iconst_1
    //   428: ireturn
    //   429: getstatic com/google/protobuf/MessageReflection$1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type : [I
    //   432: aload_3
    //   433: invokevirtual getType : ()Lcom/google/protobuf/Descriptors$FieldDescriptor$Type;
    //   436: invokevirtual ordinal : ()I
    //   439: iaload
    //   440: istore #5
    //   442: iload #5
    //   444: iconst_1
    //   445: if_icmpeq -> 557
    //   448: iload #5
    //   450: iconst_2
    //   451: if_icmpeq -> 541
    //   454: iload #5
    //   456: iconst_3
    //   457: if_icmpeq -> 480
    //   460: aload_0
    //   461: aload_3
    //   462: invokevirtual getLiteType : ()Lcom/google/protobuf/WireFormat$FieldType;
    //   465: aload #4
    //   467: aload_3
    //   468: invokeinterface getUtf8Validation : (Lcom/google/protobuf/Descriptors$FieldDescriptor;)Lcom/google/protobuf/WireFormat$Utf8Validation;
    //   473: invokestatic readPrimitiveField : (Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/WireFormat$FieldType;Lcom/google/protobuf/WireFormat$Utf8Validation;)Ljava/lang/Object;
    //   476: astore_0
    //   477: goto -> 570
    //   480: aload_0
    //   481: invokevirtual readEnum : ()I
    //   484: istore #5
    //   486: aload_3
    //   487: invokevirtual getFile : ()Lcom/google/protobuf/Descriptors$FileDescriptor;
    //   490: invokevirtual supportsUnknownEnumValue : ()Z
    //   493: ifeq -> 509
    //   496: aload_3
    //   497: invokevirtual getEnumType : ()Lcom/google/protobuf/Descriptors$EnumDescriptor;
    //   500: iload #5
    //   502: invokevirtual findValueByNumberCreatingIfUnknown : (I)Lcom/google/protobuf/Descriptors$EnumValueDescriptor;
    //   505: astore_0
    //   506: goto -> 570
    //   509: aload_3
    //   510: invokevirtual getEnumType : ()Lcom/google/protobuf/Descriptors$EnumDescriptor;
    //   513: iload #5
    //   515: invokevirtual findValueByNumber : (I)Lcom/google/protobuf/Descriptors$EnumValueDescriptor;
    //   518: astore_0
    //   519: aload_0
    //   520: ifnonnull -> 538
    //   523: aload_1
    //   524: ifnull -> 536
    //   527: aload_1
    //   528: iload #8
    //   530: iload #5
    //   532: invokevirtual mergeVarintField : (II)Lcom/google/protobuf/UnknownFieldSet$Builder;
    //   535: pop
    //   536: iconst_1
    //   537: ireturn
    //   538: goto -> 570
    //   541: aload #4
    //   543: aload_0
    //   544: aload_2
    //   545: aload_3
    //   546: aload #10
    //   548: invokeinterface parseMessage : (Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;Lcom/google/protobuf/Descriptors$FieldDescriptor;Lcom/google/protobuf/Message;)Ljava/lang/Object;
    //   553: astore_0
    //   554: goto -> 570
    //   557: aload #4
    //   559: aload_0
    //   560: aload_2
    //   561: aload_3
    //   562: aload #10
    //   564: invokeinterface parseGroup : (Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;Lcom/google/protobuf/Descriptors$FieldDescriptor;Lcom/google/protobuf/Message;)Ljava/lang/Object;
    //   569: astore_0
    //   570: aload_3
    //   571: invokevirtual isRepeated : ()Z
    //   574: ifeq -> 589
    //   577: aload #4
    //   579: aload_3
    //   580: aload_0
    //   581: invokeinterface addRepeatedField : (Lcom/google/protobuf/Descriptors$FieldDescriptor;Ljava/lang/Object;)Lcom/google/protobuf/MessageReflection$MergeTarget;
    //   586: pop
    //   587: iconst_1
    //   588: ireturn
    //   589: aload #4
    //   591: aload_3
    //   592: aload_0
    //   593: invokeinterface setField : (Lcom/google/protobuf/Descriptors$FieldDescriptor;Ljava/lang/Object;)Lcom/google/protobuf/MessageReflection$MergeTarget;
    //   598: pop
    //   599: iconst_1
    //   600: ireturn
  }
  
  private static void mergeMessageSetExtensionFromBytes(ByteString paramByteString, ExtensionRegistry.ExtensionInfo paramExtensionInfo, ExtensionRegistryLite paramExtensionRegistryLite, MergeTarget paramMergeTarget) throws IOException {
    Descriptors.FieldDescriptor fieldDescriptor = paramExtensionInfo.descriptor;
    if (paramMergeTarget.hasField(fieldDescriptor) || ExtensionRegistryLite.isEagerlyParseMessageSets()) {
      paramMergeTarget.setField(fieldDescriptor, paramMergeTarget.parseMessageFromBytes(paramByteString, paramExtensionRegistryLite, fieldDescriptor, paramExtensionInfo.defaultInstance));
      return;
    } 
    paramMergeTarget.setField(fieldDescriptor, new LazyField(paramExtensionInfo.defaultInstance, paramExtensionRegistryLite, paramByteString));
  }
  
  private static void mergeMessageSetExtensionFromCodedStream(CodedInputStream paramCodedInputStream, UnknownFieldSet.Builder paramBuilder, ExtensionRegistryLite paramExtensionRegistryLite, Descriptors.Descriptor paramDescriptor, MergeTarget paramMergeTarget) throws IOException {
    ByteString byteString;
    int i = 0;
    ExtensionRegistry.ExtensionInfo extensionInfo1 = null;
    ExtensionRegistry.ExtensionInfo extensionInfo2 = extensionInfo1;
    while (true) {
      int j = paramCodedInputStream.readTag();
      if (j == 0)
        break; 
      if (j == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
        j = paramCodedInputStream.readUInt32();
        i = j;
        if (j != 0) {
          i = j;
          if (paramExtensionRegistryLite instanceof ExtensionRegistry) {
            extensionInfo2 = paramMergeTarget.findExtensionByNumber((ExtensionRegistry)paramExtensionRegistryLite, paramDescriptor, j);
            i = j;
          } 
        } 
        continue;
      } 
      if (j == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
        if (i != 0 && extensionInfo2 != null && ExtensionRegistryLite.isEagerlyParseMessageSets()) {
          eagerlyMergeMessageSetExtension(paramCodedInputStream, extensionInfo2, paramExtensionRegistryLite, paramMergeTarget);
          extensionInfo1 = null;
          continue;
        } 
        byteString = paramCodedInputStream.readBytes();
        continue;
      } 
      if (!paramCodedInputStream.skipField(j))
        break; 
    } 
    paramCodedInputStream.checkLastTagWas(WireFormat.MESSAGE_SET_ITEM_END_TAG);
    if (byteString != null && i != 0) {
      if (extensionInfo2 != null) {
        mergeMessageSetExtensionFromBytes(byteString, extensionInfo2, paramExtensionRegistryLite, paramMergeTarget);
        return;
      } 
      if (byteString != null && paramBuilder != null)
        paramBuilder.mergeField(i, UnknownFieldSet.Field.newBuilder().addLengthDelimited(byteString).build()); 
    } 
  }
  
  private static String subMessagePrefix(String paramString, Descriptors.FieldDescriptor paramFieldDescriptor, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder(paramString);
    if (paramFieldDescriptor.isExtension()) {
      stringBuilder.append('(');
      stringBuilder.append(paramFieldDescriptor.getFullName());
      stringBuilder.append(')');
    } else {
      stringBuilder.append(paramFieldDescriptor.getName());
    } 
    if (paramInt != -1) {
      stringBuilder.append('[');
      stringBuilder.append(paramInt);
      stringBuilder.append(']');
    } 
    stringBuilder.append('.');
    return stringBuilder.toString();
  }
  
  static void writeMessageTo(Message paramMessage, Map<Descriptors.FieldDescriptor, Object> paramMap, CodedOutputStream paramCodedOutputStream, boolean paramBoolean) throws IOException {
    boolean bool = paramMessage.getDescriptorForType().getOptions().getMessageSetWireFormat();
    Map<Descriptors.FieldDescriptor, Object> map = paramMap;
    if (paramBoolean) {
      map = new TreeMap<Descriptors.FieldDescriptor, Object>(paramMap);
      for (Descriptors.FieldDescriptor fieldDescriptor : paramMessage.getDescriptorForType().getFields()) {
        if (fieldDescriptor.isRequired() && !map.containsKey(fieldDescriptor))
          map.put(fieldDescriptor, paramMessage.getField(fieldDescriptor)); 
      } 
    } 
    for (Map.Entry<Descriptors.FieldDescriptor, Object> entry : map.entrySet()) {
      Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor)entry.getKey();
      entry = (Map.Entry<Descriptors.FieldDescriptor, Object>)entry.getValue();
      if (bool && fieldDescriptor.isExtension() && fieldDescriptor.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && !fieldDescriptor.isRepeated()) {
        paramCodedOutputStream.writeMessageSetExtension(fieldDescriptor.getNumber(), (Message)entry);
        continue;
      } 
      FieldSet.writeField(fieldDescriptor, entry, paramCodedOutputStream);
    } 
    UnknownFieldSet unknownFieldSet = paramMessage.getUnknownFields();
    if (bool) {
      unknownFieldSet.writeAsMessageSetTo(paramCodedOutputStream);
      return;
    } 
    unknownFieldSet.writeTo(paramCodedOutputStream);
  }
  
  static class BuilderAdapter implements MergeTarget {
    private final Message.Builder builder;
    
    public BuilderAdapter(Message.Builder param1Builder) {
      this.builder = param1Builder;
    }
    
    public MessageReflection.MergeTarget addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      this.builder.addRepeatedField(param1FieldDescriptor, param1Object);
      return this;
    }
    
    public MessageReflection.MergeTarget clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      this.builder.clearField(param1FieldDescriptor);
      return this;
    }
    
    public MessageReflection.MergeTarget clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      this.builder.clearOneof(param1OneofDescriptor);
      return this;
    }
    
    public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry param1ExtensionRegistry, String param1String) {
      return param1ExtensionRegistry.findImmutableExtensionByName(param1String);
    }
    
    public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry param1ExtensionRegistry, Descriptors.Descriptor param1Descriptor, int param1Int) {
      return param1ExtensionRegistry.findImmutableExtensionByNumber(param1Descriptor, param1Int);
    }
    
    public Object finish() {
      return this.builder.buildPartial();
    }
    
    public MessageReflection.MergeTarget.ContainerType getContainerType() {
      return MessageReflection.MergeTarget.ContainerType.MESSAGE;
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      return this.builder.getDescriptorForType();
    }
    
    public Object getField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return this.builder.getField(param1FieldDescriptor);
    }
    
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return this.builder.getOneofFieldDescriptor(param1OneofDescriptor);
    }
    
    public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return param1FieldDescriptor.needsUtf8Check() ? WireFormat.Utf8Validation.STRICT : ((!param1FieldDescriptor.isRepeated() && this.builder instanceof GeneratedMessage.Builder) ? WireFormat.Utf8Validation.LAZY : WireFormat.Utf8Validation.LOOSE);
    }
    
    public boolean hasField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return this.builder.hasField(param1FieldDescriptor);
    }
    
    public boolean hasOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return this.builder.hasOneof(param1OneofDescriptor);
    }
    
    public MessageReflection.MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor param1FieldDescriptor, Message param1Message) {
      Message.Builder builder;
      if (param1Message != null) {
        builder = param1Message.newBuilderForType();
      } else {
        builder = this.builder.newBuilderForField((Descriptors.FieldDescriptor)builder);
      } 
      return new BuilderAdapter(builder);
    }
    
    public MessageReflection.MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor param1FieldDescriptor, Message param1Message) {
      Message.Builder builder;
      if (param1Message != null) {
        builder = param1Message.newBuilderForType();
      } else {
        builder = this.builder.newBuilderForField(param1FieldDescriptor);
      } 
      if (!param1FieldDescriptor.isRepeated()) {
        Message message = (Message)getField(param1FieldDescriptor);
        if (message != null)
          builder.mergeFrom(message); 
      } 
      return new BuilderAdapter(builder);
    }
    
    public Object parseGroup(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite, Descriptors.FieldDescriptor param1FieldDescriptor, Message param1Message) throws IOException {
      Message.Builder builder;
      if (param1Message != null) {
        builder = param1Message.newBuilderForType();
      } else {
        builder = this.builder.newBuilderForField(param1FieldDescriptor);
      } 
      if (!param1FieldDescriptor.isRepeated()) {
        Message message = (Message)getField(param1FieldDescriptor);
        if (message != null)
          builder.mergeFrom(message); 
      } 
      param1CodedInputStream.readGroup(param1FieldDescriptor.getNumber(), builder, param1ExtensionRegistryLite);
      return builder.buildPartial();
    }
    
    public Object parseMessage(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite, Descriptors.FieldDescriptor param1FieldDescriptor, Message param1Message) throws IOException {
      Message.Builder builder;
      if (param1Message != null) {
        builder = param1Message.newBuilderForType();
      } else {
        builder = this.builder.newBuilderForField(param1FieldDescriptor);
      } 
      if (!param1FieldDescriptor.isRepeated()) {
        Message message = (Message)getField(param1FieldDescriptor);
        if (message != null)
          builder.mergeFrom(message); 
      } 
      param1CodedInputStream.readMessage(builder, param1ExtensionRegistryLite);
      return builder.buildPartial();
    }
    
    public Object parseMessageFromBytes(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite, Descriptors.FieldDescriptor param1FieldDescriptor, Message param1Message) throws IOException {
      Message.Builder builder;
      if (param1Message != null) {
        builder = param1Message.newBuilderForType();
      } else {
        builder = this.builder.newBuilderForField(param1FieldDescriptor);
      } 
      if (!param1FieldDescriptor.isRepeated()) {
        Message message = (Message)getField(param1FieldDescriptor);
        if (message != null)
          builder.mergeFrom(message); 
      } 
      builder.mergeFrom(param1ByteString, param1ExtensionRegistryLite);
      return builder.buildPartial();
    }
    
    public MessageReflection.MergeTarget setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      this.builder.setField(param1FieldDescriptor, param1Object);
      return this;
    }
    
    public MessageReflection.MergeTarget setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      this.builder.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
      return this;
    }
  }
  
  static class ExtensionAdapter implements MergeTarget {
    private final FieldSet<Descriptors.FieldDescriptor> extensions;
    
    ExtensionAdapter(FieldSet<Descriptors.FieldDescriptor> param1FieldSet) {
      this.extensions = param1FieldSet;
    }
    
    public MessageReflection.MergeTarget addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      this.extensions.addRepeatedField(param1FieldDescriptor, param1Object);
      return this;
    }
    
    public MessageReflection.MergeTarget clearField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      this.extensions.clearField(param1FieldDescriptor);
      return this;
    }
    
    public MessageReflection.MergeTarget clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return this;
    }
    
    public ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry param1ExtensionRegistry, String param1String) {
      return param1ExtensionRegistry.findImmutableExtensionByName(param1String);
    }
    
    public ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry param1ExtensionRegistry, Descriptors.Descriptor param1Descriptor, int param1Int) {
      return param1ExtensionRegistry.findImmutableExtensionByNumber(param1Descriptor, param1Int);
    }
    
    public Object finish() {
      throw new UnsupportedOperationException("finish() called on FieldSet object");
    }
    
    public MessageReflection.MergeTarget.ContainerType getContainerType() {
      return MessageReflection.MergeTarget.ContainerType.EXTENSION_SET;
    }
    
    public Descriptors.Descriptor getDescriptorForType() {
      throw new UnsupportedOperationException("getDescriptorForType() called on FieldSet object");
    }
    
    public Object getField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return this.extensions.getField(param1FieldDescriptor);
    }
    
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return null;
    }
    
    public WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return param1FieldDescriptor.needsUtf8Check() ? WireFormat.Utf8Validation.STRICT : WireFormat.Utf8Validation.LOOSE;
    }
    
    public boolean hasField(Descriptors.FieldDescriptor param1FieldDescriptor) {
      return this.extensions.hasField(param1FieldDescriptor);
    }
    
    public boolean hasOneof(Descriptors.OneofDescriptor param1OneofDescriptor) {
      return false;
    }
    
    public MessageReflection.MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor param1FieldDescriptor, Message param1Message) {
      throw new UnsupportedOperationException("newEmptyTargetForField() called on FieldSet object");
    }
    
    public MessageReflection.MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor param1FieldDescriptor, Message param1Message) {
      throw new UnsupportedOperationException("newMergeTargetForField() called on FieldSet object");
    }
    
    public Object parseGroup(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite, Descriptors.FieldDescriptor param1FieldDescriptor, Message param1Message) throws IOException {
      Message.Builder builder = param1Message.newBuilderForType();
      if (!param1FieldDescriptor.isRepeated()) {
        Message message = (Message)getField(param1FieldDescriptor);
        if (message != null)
          builder.mergeFrom(message); 
      } 
      param1CodedInputStream.readGroup(param1FieldDescriptor.getNumber(), builder, param1ExtensionRegistryLite);
      return builder.buildPartial();
    }
    
    public Object parseMessage(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite, Descriptors.FieldDescriptor param1FieldDescriptor, Message param1Message) throws IOException {
      Message.Builder builder = param1Message.newBuilderForType();
      if (!param1FieldDescriptor.isRepeated()) {
        Message message = (Message)getField(param1FieldDescriptor);
        if (message != null)
          builder.mergeFrom(message); 
      } 
      param1CodedInputStream.readMessage(builder, param1ExtensionRegistryLite);
      return builder.buildPartial();
    }
    
    public Object parseMessageFromBytes(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite, Descriptors.FieldDescriptor param1FieldDescriptor, Message param1Message) throws IOException {
      Message.Builder builder = param1Message.newBuilderForType();
      if (!param1FieldDescriptor.isRepeated()) {
        Message message = (Message)getField(param1FieldDescriptor);
        if (message != null)
          builder.mergeFrom(message); 
      } 
      builder.mergeFrom(param1ByteString, param1ExtensionRegistryLite);
      return builder.buildPartial();
    }
    
    public MessageReflection.MergeTarget setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object) {
      this.extensions.setField(param1FieldDescriptor, param1Object);
      return this;
    }
    
    public MessageReflection.MergeTarget setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object) {
      this.extensions.setRepeatedField(param1FieldDescriptor, param1Int, param1Object);
      return this;
    }
  }
  
  static interface MergeTarget {
    MergeTarget addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object);
    
    MergeTarget clearField(Descriptors.FieldDescriptor param1FieldDescriptor);
    
    MergeTarget clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor);
    
    ExtensionRegistry.ExtensionInfo findExtensionByName(ExtensionRegistry param1ExtensionRegistry, String param1String);
    
    ExtensionRegistry.ExtensionInfo findExtensionByNumber(ExtensionRegistry param1ExtensionRegistry, Descriptors.Descriptor param1Descriptor, int param1Int);
    
    Object finish();
    
    ContainerType getContainerType();
    
    Descriptors.Descriptor getDescriptorForType();
    
    Object getField(Descriptors.FieldDescriptor param1FieldDescriptor);
    
    Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor param1OneofDescriptor);
    
    WireFormat.Utf8Validation getUtf8Validation(Descriptors.FieldDescriptor param1FieldDescriptor);
    
    boolean hasField(Descriptors.FieldDescriptor param1FieldDescriptor);
    
    boolean hasOneof(Descriptors.OneofDescriptor param1OneofDescriptor);
    
    MergeTarget newEmptyTargetForField(Descriptors.FieldDescriptor param1FieldDescriptor, Message param1Message);
    
    MergeTarget newMergeTargetForField(Descriptors.FieldDescriptor param1FieldDescriptor, Message param1Message);
    
    Object parseGroup(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite, Descriptors.FieldDescriptor param1FieldDescriptor, Message param1Message) throws IOException;
    
    Object parseMessage(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite, Descriptors.FieldDescriptor param1FieldDescriptor, Message param1Message) throws IOException;
    
    Object parseMessageFromBytes(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite, Descriptors.FieldDescriptor param1FieldDescriptor, Message param1Message) throws IOException;
    
    MergeTarget setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object);
    
    MergeTarget setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object);
    
    public enum ContainerType {
      EXTENSION_SET, MESSAGE;
      
      static {
      
      }
    }
  }
  
  public enum ContainerType {
    EXTENSION_SET, MESSAGE;
    
    static {
      $VALUES = new ContainerType[] { MESSAGE, EXTENSION_SET };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\MessageReflection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */