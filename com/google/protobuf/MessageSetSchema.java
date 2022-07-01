package com.google.protobuf;

import java.io.IOException;
import java.util.Map;

final class MessageSetSchema<T> implements Schema<T> {
  private final MessageLite defaultInstance;
  
  private final ExtensionSchema<?> extensionSchema;
  
  private final boolean hasExtensions;
  
  private final UnknownFieldSchema<?, ?> unknownFieldSchema;
  
  private MessageSetSchema(UnknownFieldSchema<?, ?> paramUnknownFieldSchema, ExtensionSchema<?> paramExtensionSchema, MessageLite paramMessageLite) {
    this.unknownFieldSchema = paramUnknownFieldSchema;
    this.hasExtensions = paramExtensionSchema.hasExtensions(paramMessageLite);
    this.extensionSchema = paramExtensionSchema;
    this.defaultInstance = paramMessageLite;
  }
  
  private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> paramUnknownFieldSchema, T paramT) {
    return paramUnknownFieldSchema.getSerializedSizeAsMessageSet(paramUnknownFieldSchema.getFromMessage(paramT));
  }
  
  private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> paramUnknownFieldSchema, ExtensionSchema<ET> paramExtensionSchema, T paramT, Reader paramReader, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    UB uB = paramUnknownFieldSchema.getBuilderFromMessage(paramT);
    FieldSet<ET> fieldSet = paramExtensionSchema.getMutableExtensions(paramT);
    try {
      while (true) {
        int i = paramReader.getFieldNumber();
        if (i == Integer.MAX_VALUE)
          return; 
        boolean bool = parseMessageSetItemOrUnknownField(paramReader, paramExtensionRegistryLite, paramExtensionSchema, fieldSet, paramUnknownFieldSchema, uB);
        if (bool)
          continue; 
        return;
      } 
    } finally {
      paramUnknownFieldSchema.setBuilderToMessage(paramT, uB);
    } 
  }
  
  static <T> MessageSetSchema<T> newSchema(UnknownFieldSchema<?, ?> paramUnknownFieldSchema, ExtensionSchema<?> paramExtensionSchema, MessageLite paramMessageLite) {
    return new MessageSetSchema<T>(paramUnknownFieldSchema, paramExtensionSchema, paramMessageLite);
  }
  
  private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> boolean parseMessageSetItemOrUnknownField(Reader paramReader, ExtensionRegistryLite paramExtensionRegistryLite, ExtensionSchema<ET> paramExtensionSchema, FieldSet<ET> paramFieldSet, UnknownFieldSchema<UT, UB> paramUnknownFieldSchema, UB paramUB) throws IOException {
    int i = paramReader.getTag();
    if (i != WireFormat.MESSAGE_SET_ITEM_TAG) {
      if (WireFormat.getTagWireType(i) == 2) {
        Object object1 = paramExtensionSchema.findExtensionByNumber(paramExtensionRegistryLite, this.defaultInstance, WireFormat.getTagFieldNumber(i));
        if (object1 != null) {
          paramExtensionSchema.parseLengthPrefixedMessageSetItem(paramReader, object1, paramExtensionRegistryLite, paramFieldSet);
          return true;
        } 
        return paramUnknownFieldSchema.mergeOneFieldFrom(paramUB, paramReader);
      } 
      return paramReader.skipField();
    } 
    Object object = null;
    ByteString byteString = null;
    i = 0;
    while (paramReader.getFieldNumber() != Integer.MAX_VALUE) {
      int j = paramReader.getTag();
      if (j == WireFormat.MESSAGE_SET_TYPE_ID_TAG) {
        i = paramReader.readUInt32();
        object = paramExtensionSchema.findExtensionByNumber(paramExtensionRegistryLite, this.defaultInstance, i);
        continue;
      } 
      if (j == WireFormat.MESSAGE_SET_MESSAGE_TAG) {
        if (object != null) {
          paramExtensionSchema.parseLengthPrefixedMessageSetItem(paramReader, object, paramExtensionRegistryLite, paramFieldSet);
          continue;
        } 
        byteString = paramReader.readBytes();
        continue;
      } 
      if (!paramReader.skipField())
        break; 
    } 
    if (paramReader.getTag() == WireFormat.MESSAGE_SET_ITEM_END_TAG) {
      if (byteString != null) {
        if (object != null) {
          paramExtensionSchema.parseMessageSetItem(byteString, object, paramExtensionRegistryLite, paramFieldSet);
          return true;
        } 
        paramUnknownFieldSchema.addLengthDelimited(paramUB, i, byteString);
      } 
      return true;
    } 
    throw InvalidProtocolBufferException.invalidEndTag();
  }
  
  private <UT, UB> void writeUnknownFieldsHelper(UnknownFieldSchema<UT, UB> paramUnknownFieldSchema, T paramT, Writer paramWriter) throws IOException {
    paramUnknownFieldSchema.writeAsMessageSetTo(paramUnknownFieldSchema.getFromMessage(paramT), paramWriter);
  }
  
  public boolean equals(T paramT1, T paramT2) {
    return !this.unknownFieldSchema.getFromMessage(paramT1).equals(this.unknownFieldSchema.getFromMessage(paramT2)) ? false : (this.hasExtensions ? this.extensionSchema.getExtensions(paramT1).equals(this.extensionSchema.getExtensions(paramT2)) : true);
  }
  
  public int getSerializedSize(T paramT) {
    int j = getUnknownFieldsSerializedSize(this.unknownFieldSchema, paramT) + 0;
    int i = j;
    if (this.hasExtensions)
      i = j + this.extensionSchema.getExtensions(paramT).getMessageSetSerializedSize(); 
    return i;
  }
  
  public int hashCode(T paramT) {
    int j = this.unknownFieldSchema.getFromMessage(paramT).hashCode();
    int i = j;
    if (this.hasExtensions)
      i = j * 53 + this.extensionSchema.getExtensions(paramT).hashCode(); 
    return i;
  }
  
  public final boolean isInitialized(T paramT) {
    return this.extensionSchema.getExtensions(paramT).isInitialized();
  }
  
  public void makeImmutable(T paramT) {
    this.unknownFieldSchema.makeImmutable(paramT);
    this.extensionSchema.makeImmutable(paramT);
  }
  
  public void mergeFrom(T paramT, Reader paramReader, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException {
    mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, paramT, paramReader, paramExtensionRegistryLite);
  }
  
  public void mergeFrom(T paramT1, T paramT2) {
    SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, paramT1, paramT2);
    if (this.hasExtensions)
      SchemaUtil.mergeExtensions(this.extensionSchema, paramT1, paramT2); 
  }
  
  public void mergeFrom(T paramT, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, ArrayDecoders.Registers paramRegisters) throws IOException {
    GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite)paramT;
    UnknownFieldSetLite unknownFieldSetLite2 = generatedMessageLite.unknownFields;
    UnknownFieldSetLite unknownFieldSetLite1 = unknownFieldSetLite2;
    if (unknownFieldSetLite2 == UnknownFieldSetLite.getDefaultInstance()) {
      unknownFieldSetLite1 = UnknownFieldSetLite.newInstance();
      generatedMessageLite.unknownFields = unknownFieldSetLite1;
    } 
    FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet = ((GeneratedMessageLite.ExtendableMessage)paramT).ensureExtensionsAreMutable();
    paramT = null;
    while (paramInt1 < paramInt2) {
      GeneratedMessageLite.GeneratedExtension generatedExtension;
      ByteString byteString;
      paramInt1 = ArrayDecoders.decodeVarint32(paramArrayOfbyte, paramInt1, paramRegisters);
      int i = paramRegisters.int1;
      if (i != WireFormat.MESSAGE_SET_ITEM_TAG) {
        if (WireFormat.getTagWireType(i) == 2) {
          generatedExtension = (GeneratedMessageLite.GeneratedExtension)this.extensionSchema.findExtensionByNumber(paramRegisters.extensionRegistry, this.defaultInstance, WireFormat.getTagFieldNumber(i));
          if (generatedExtension != null) {
            paramInt1 = ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(generatedExtension.getMessageDefaultInstance().getClass()), paramArrayOfbyte, paramInt1, paramInt2, paramRegisters);
            fieldSet.setField(generatedExtension.descriptor, paramRegisters.object1);
            continue;
          } 
          paramInt1 = ArrayDecoders.decodeUnknownField(i, paramArrayOfbyte, paramInt1, paramInt2, unknownFieldSetLite1, paramRegisters);
          continue;
        } 
        paramInt1 = ArrayDecoders.skipField(i, paramArrayOfbyte, paramInt1, paramInt2, paramRegisters);
        continue;
      } 
      int j = 0;
      unknownFieldSetLite2 = null;
      while (true) {
        i = paramInt1;
        if (paramInt1 < paramInt2) {
          i = ArrayDecoders.decodeVarint32(paramArrayOfbyte, paramInt1, paramRegisters);
          paramInt1 = paramRegisters.int1;
          int k = WireFormat.getTagFieldNumber(paramInt1);
          int m = WireFormat.getTagWireType(paramInt1);
          if (k != 2) {
            if (k == 3) {
              if (generatedExtension != null) {
                paramInt1 = ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor(generatedExtension.getMessageDefaultInstance().getClass()), paramArrayOfbyte, i, paramInt2, paramRegisters);
                fieldSet.setField(generatedExtension.descriptor, paramRegisters.object1);
                continue;
              } 
              if (m == 2) {
                paramInt1 = ArrayDecoders.decodeBytes(paramArrayOfbyte, i, paramRegisters);
                byteString = (ByteString)paramRegisters.object1;
                continue;
              } 
            } 
          } else if (m == 0) {
            paramInt1 = ArrayDecoders.decodeVarint32(paramArrayOfbyte, i, paramRegisters);
            j = paramRegisters.int1;
            generatedExtension = (GeneratedMessageLite.GeneratedExtension)this.extensionSchema.findExtensionByNumber(paramRegisters.extensionRegistry, this.defaultInstance, j);
            continue;
          } 
          if (paramInt1 == WireFormat.MESSAGE_SET_ITEM_END_TAG)
            break; 
          paramInt1 = ArrayDecoders.skipField(paramInt1, paramArrayOfbyte, i, paramInt2, paramRegisters);
          continue;
        } 
        break;
      } 
      if (byteString != null)
        unknownFieldSetLite1.storeField(WireFormat.makeTag(j, 2), byteString); 
      paramInt1 = i;
    } 
    if (paramInt1 == paramInt2)
      return; 
    throw InvalidProtocolBufferException.parseFailure();
  }
  
  public T newInstance() {
    return (T)this.defaultInstance.newBuilderForType().buildPartial();
  }
  
  public void writeTo(T paramT, Writer paramWriter) throws IOException {
    for (Map.Entry entry : this.extensionSchema.getExtensions(paramT)) {
      FieldSet.FieldDescriptorLite fieldDescriptorLite = (FieldSet.FieldDescriptorLite)entry.getKey();
      if (fieldDescriptorLite.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !fieldDescriptorLite.isRepeated() && !fieldDescriptorLite.isPacked()) {
        if (entry instanceof LazyField.LazyEntry) {
          paramWriter.writeMessageSetItem(fieldDescriptorLite.getNumber(), ((LazyField.LazyEntry)entry).getField().toByteString());
          continue;
        } 
        paramWriter.writeMessageSetItem(fieldDescriptorLite.getNumber(), entry.getValue());
        continue;
      } 
      throw new IllegalStateException("Found invalid MessageSet item.");
    } 
    writeUnknownFieldsHelper(this.unknownFieldSchema, paramT, paramWriter);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\MessageSetSchema.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */