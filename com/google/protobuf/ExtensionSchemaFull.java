package com.google.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class ExtensionSchemaFull extends ExtensionSchema<Descriptors.FieldDescriptor> {
  private static final long EXTENSION_FIELD_OFFSET = getExtensionsFieldOffset();
  
  private static <T> long getExtensionsFieldOffset() {
    try {
      return UnsafeUtil.objectFieldOffset(GeneratedMessageV3.ExtendableMessage.class.getDeclaredField("extensions"));
    } finally {
      Exception exception = null;
    } 
  }
  
  int extensionNumber(Map.Entry<?, ?> paramEntry) {
    return ((Descriptors.FieldDescriptor)paramEntry.getKey()).getNumber();
  }
  
  Object findExtensionByNumber(ExtensionRegistryLite paramExtensionRegistryLite, MessageLite paramMessageLite, int paramInt) {
    return ((ExtensionRegistry)paramExtensionRegistryLite).findExtensionByNumber(((Message)paramMessageLite).getDescriptorForType(), paramInt);
  }
  
  public FieldSet<Descriptors.FieldDescriptor> getExtensions(Object paramObject) {
    return (FieldSet<Descriptors.FieldDescriptor>)UnsafeUtil.getObject(paramObject, EXTENSION_FIELD_OFFSET);
  }
  
  FieldSet<Descriptors.FieldDescriptor> getMutableExtensions(Object paramObject) {
    FieldSet<Descriptors.FieldDescriptor> fieldSet2 = getExtensions(paramObject);
    FieldSet<Descriptors.FieldDescriptor> fieldSet1 = fieldSet2;
    if (fieldSet2.isImmutable()) {
      fieldSet1 = fieldSet2.clone();
      setExtensions(paramObject, fieldSet1);
    } 
    return fieldSet1;
  }
  
  boolean hasExtensions(MessageLite paramMessageLite) {
    return paramMessageLite instanceof GeneratedMessageV3.ExtendableMessage;
  }
  
  void makeImmutable(Object paramObject) {
    getExtensions(paramObject).makeImmutable();
  }
  
  <UT, UB> UB parseExtension(Reader paramReader, Object paramObject, ExtensionRegistryLite paramExtensionRegistryLite, FieldSet<Descriptors.FieldDescriptor> paramFieldSet, UB paramUB, UnknownFieldSchema<UT, UB> paramUnknownFieldSchema) throws IOException {
    Object object;
    Descriptors.EnumValueDescriptor enumValueDescriptor;
    ExtensionRegistry.ExtensionInfo extensionInfo = (ExtensionRegistry.ExtensionInfo)paramObject;
    int i = extensionInfo.descriptor.getNumber();
    if (extensionInfo.descriptor.isRepeated() && extensionInfo.descriptor.isPacked()) {
      StringBuilder stringBuilder;
      ArrayList<Descriptors.EnumValueDescriptor> arrayList;
      switch (extensionInfo.descriptor.getLiteType()) {
        default:
          stringBuilder = new StringBuilder();
          stringBuilder.append("Type cannot be packed: ");
          stringBuilder.append(extensionInfo.descriptor.getLiteType());
          throw new IllegalStateException(stringBuilder.toString());
        case ENUM:
          paramObject = new ArrayList();
          stringBuilder.readEnumList((List<Integer>)paramObject);
          arrayList = new ArrayList();
          paramObject = paramObject.iterator();
          while (paramObject.hasNext()) {
            int j = ((Integer)paramObject.next()).intValue();
            enumValueDescriptor = extensionInfo.descriptor.getEnumType().findValueByNumber(j);
            if (enumValueDescriptor != null) {
              arrayList.add(enumValueDescriptor);
              continue;
            } 
            paramUB = SchemaUtil.storeUnknownEnum(i, j, paramUB, paramUnknownFieldSchema);
          } 
          paramFieldSet.setField(extensionInfo.descriptor, arrayList);
          return paramUB;
        case SINT64:
          paramObject = new ArrayList();
          arrayList.readSInt64List((List<Long>)paramObject);
          object = paramObject;
          paramFieldSet.setField(extensionInfo.descriptor, object);
          return paramUB;
        case SINT32:
          paramObject = new ArrayList();
          object.readSInt32List((List<Integer>)paramObject);
          object = paramObject;
          paramFieldSet.setField(extensionInfo.descriptor, object);
          return paramUB;
        case SFIXED64:
          paramObject = new ArrayList();
          object.readSFixed64List((List<Long>)paramObject);
          object = paramObject;
          paramFieldSet.setField(extensionInfo.descriptor, object);
          return paramUB;
        case SFIXED32:
          paramObject = new ArrayList();
          object.readSFixed32List((List<Integer>)paramObject);
          object = paramObject;
          paramFieldSet.setField(extensionInfo.descriptor, object);
          return paramUB;
        case UINT32:
          paramObject = new ArrayList();
          object.readUInt32List((List<Integer>)paramObject);
          object = paramObject;
          paramFieldSet.setField(extensionInfo.descriptor, object);
          return paramUB;
        case BOOL:
          paramObject = new ArrayList();
          object.readBoolList((List<Boolean>)paramObject);
          object = paramObject;
          paramFieldSet.setField(extensionInfo.descriptor, object);
          return paramUB;
        case FIXED32:
          paramObject = new ArrayList();
          object.readFixed32List((List<Integer>)paramObject);
          object = paramObject;
          paramFieldSet.setField(extensionInfo.descriptor, object);
          return paramUB;
        case FIXED64:
          paramObject = new ArrayList();
          object.readFixed64List((List<Long>)paramObject);
          object = paramObject;
          paramFieldSet.setField(extensionInfo.descriptor, object);
          return paramUB;
        case INT32:
          paramObject = new ArrayList();
          object.readInt32List((List<Integer>)paramObject);
          object = paramObject;
          paramFieldSet.setField(extensionInfo.descriptor, object);
          return paramUB;
        case UINT64:
          paramObject = new ArrayList();
          object.readUInt64List((List<Long>)paramObject);
          object = paramObject;
          paramFieldSet.setField(extensionInfo.descriptor, object);
          return paramUB;
        case INT64:
          paramObject = new ArrayList();
          object.readInt64List((List<Long>)paramObject);
          object = paramObject;
          paramFieldSet.setField(extensionInfo.descriptor, object);
          return paramUB;
        case FLOAT:
          paramObject = new ArrayList();
          object.readFloatList((List<Float>)paramObject);
          object = paramObject;
          paramFieldSet.setField(extensionInfo.descriptor, object);
          return paramUB;
        case DOUBLE:
          break;
      } 
      paramObject = new ArrayList();
      object.readDoubleList((List<Double>)paramObject);
      object = paramObject;
      paramFieldSet.setField(extensionInfo.descriptor, object);
      return paramUB;
    } 
    paramObject = null;
    if (extensionInfo.descriptor.getLiteType() == WireFormat.FieldType.ENUM) {
      int j = object.readInt32();
      paramObject = extensionInfo.descriptor.getEnumType().findValueByNumber(j);
      object = paramObject;
      if (paramObject == null)
        return SchemaUtil.storeUnknownEnum(i, j, paramUB, paramUnknownFieldSchema); 
    } else {
      switch (extensionInfo.descriptor.getLiteType()) {
        default:
          object = paramObject;
          break;
        case null:
          object = object.readMessage(extensionInfo.defaultInstance.getClass(), (ExtensionRegistryLite)enumValueDescriptor);
          break;
        case GROUP:
          object = object.readGroup(extensionInfo.defaultInstance.getClass(), (ExtensionRegistryLite)enumValueDescriptor);
          break;
        case STRING:
          object = object.readString();
          break;
        case BYTES:
          object = object.readBytes();
          break;
        case ENUM:
          throw new IllegalStateException("Shouldn't reach here.");
        case SINT64:
          object = Long.valueOf(object.readSInt64());
          break;
        case SINT32:
          object = Integer.valueOf(object.readSInt32());
          break;
        case SFIXED64:
          object = Long.valueOf(object.readSFixed64());
          break;
        case SFIXED32:
          object = Integer.valueOf(object.readSFixed32());
          break;
        case UINT32:
          object = Integer.valueOf(object.readUInt32());
          break;
        case BOOL:
          object = Boolean.valueOf(object.readBool());
          break;
        case FIXED32:
          object = Integer.valueOf(object.readFixed32());
          break;
        case FIXED64:
          object = Long.valueOf(object.readFixed64());
          break;
        case INT32:
          object = Integer.valueOf(object.readInt32());
          break;
        case UINT64:
          object = Long.valueOf(object.readUInt64());
          break;
        case INT64:
          object = Long.valueOf(object.readInt64());
          break;
        case FLOAT:
          object = Float.valueOf(object.readFloat());
          break;
        case DOUBLE:
          object = Double.valueOf(object.readDouble());
          break;
      } 
    } 
    if (extensionInfo.descriptor.isRepeated()) {
      paramFieldSet.addRepeatedField(extensionInfo.descriptor, object);
      return paramUB;
    } 
    i = null.$SwitchMap$com$google$protobuf$WireFormat$FieldType[extensionInfo.descriptor.getLiteType().ordinal()];
    if (i != 17 && i != 18) {
      paramObject = object;
    } else {
      Object object1 = paramFieldSet.getField(extensionInfo.descriptor);
      paramObject = object;
      if (object1 != null)
        paramObject = Internal.mergeMessage(object1, object); 
    } 
    paramFieldSet.setField(extensionInfo.descriptor, paramObject);
    return paramUB;
  }
  
  void parseLengthPrefixedMessageSetItem(Reader paramReader, Object paramObject, ExtensionRegistryLite paramExtensionRegistryLite, FieldSet<Descriptors.FieldDescriptor> paramFieldSet) throws IOException {
    paramObject = paramObject;
    if (ExtensionRegistryLite.isEagerlyParseMessageSets()) {
      paramReader = paramReader.readMessage(((ExtensionRegistry.ExtensionInfo)paramObject).defaultInstance.getClass(), paramExtensionRegistryLite);
      paramFieldSet.setField(((ExtensionRegistry.ExtensionInfo)paramObject).descriptor, paramReader);
      return;
    } 
    paramFieldSet.setField(((ExtensionRegistry.ExtensionInfo)paramObject).descriptor, new LazyField(((ExtensionRegistry.ExtensionInfo)paramObject).defaultInstance, paramExtensionRegistryLite, paramReader.readBytes()));
  }
  
  void parseMessageSetItem(ByteString paramByteString, Object paramObject, ExtensionRegistryLite paramExtensionRegistryLite, FieldSet<Descriptors.FieldDescriptor> paramFieldSet) throws IOException {
    BinaryReader binaryReader;
    paramObject = paramObject;
    Message message = ((ExtensionRegistry.ExtensionInfo)paramObject).defaultInstance.newBuilderForType().buildPartial();
    if (ExtensionRegistryLite.isEagerlyParseMessageSets()) {
      binaryReader = BinaryReader.newInstance(ByteBuffer.wrap(paramByteString.toByteArray()), true);
      Protobuf.getInstance().mergeFrom(message, binaryReader, paramExtensionRegistryLite);
      paramFieldSet.setField(((ExtensionRegistry.ExtensionInfo)paramObject).descriptor, message);
      if (binaryReader.getFieldNumber() == Integer.MAX_VALUE)
        return; 
      throw InvalidProtocolBufferException.invalidEndTag();
    } 
    paramFieldSet.setField(((ExtensionRegistry.ExtensionInfo)paramObject).descriptor, new LazyField(((ExtensionRegistry.ExtensionInfo)paramObject).defaultInstance, paramExtensionRegistryLite, (ByteString)binaryReader));
  }
  
  void serializeExtension(Writer paramWriter, Map.Entry<?, ?> paramEntry) throws IOException {
    ArrayList<Integer> arrayList;
    Descriptors.FieldDescriptor fieldDescriptor = (Descriptors.FieldDescriptor)paramEntry.getKey();
    if (fieldDescriptor.isRepeated()) {
      List list;
      Iterator<Descriptors.EnumValueDescriptor> iterator;
      switch (fieldDescriptor.getLiteType()) {
        default:
          return;
        case null:
          SchemaUtil.writeMessageList(fieldDescriptor.getNumber(), (List)paramEntry.getValue(), paramWriter);
          return;
        case GROUP:
          SchemaUtil.writeGroupList(fieldDescriptor.getNumber(), (List)paramEntry.getValue(), paramWriter);
          return;
        case STRING:
          SchemaUtil.writeStringList(fieldDescriptor.getNumber(), (List<String>)paramEntry.getValue(), paramWriter);
          return;
        case BYTES:
          SchemaUtil.writeBytesList(fieldDescriptor.getNumber(), (List<ByteString>)paramEntry.getValue(), paramWriter);
          return;
        case ENUM:
          list = (List)paramEntry.getValue();
          arrayList = new ArrayList();
          iterator = list.iterator();
          while (iterator.hasNext())
            arrayList.add(Integer.valueOf(((Descriptors.EnumValueDescriptor)iterator.next()).getNumber())); 
          SchemaUtil.writeInt32List(fieldDescriptor.getNumber(), arrayList, paramWriter, fieldDescriptor.isPacked());
          return;
        case SINT64:
          SchemaUtil.writeSInt64List(fieldDescriptor.getNumber(), arrayList.getValue(), paramWriter, fieldDescriptor.isPacked());
          return;
        case SINT32:
          SchemaUtil.writeSInt32List(fieldDescriptor.getNumber(), arrayList.getValue(), paramWriter, fieldDescriptor.isPacked());
          return;
        case SFIXED64:
          SchemaUtil.writeSFixed64List(fieldDescriptor.getNumber(), arrayList.getValue(), paramWriter, fieldDescriptor.isPacked());
          return;
        case SFIXED32:
          SchemaUtil.writeSFixed32List(fieldDescriptor.getNumber(), arrayList.getValue(), paramWriter, fieldDescriptor.isPacked());
          return;
        case UINT32:
          SchemaUtil.writeUInt32List(fieldDescriptor.getNumber(), arrayList.getValue(), paramWriter, fieldDescriptor.isPacked());
          return;
        case BOOL:
          SchemaUtil.writeBoolList(fieldDescriptor.getNumber(), arrayList.getValue(), paramWriter, fieldDescriptor.isPacked());
          return;
        case FIXED32:
          SchemaUtil.writeFixed32List(fieldDescriptor.getNumber(), arrayList.getValue(), paramWriter, fieldDescriptor.isPacked());
          return;
        case FIXED64:
          SchemaUtil.writeFixed64List(fieldDescriptor.getNumber(), arrayList.getValue(), paramWriter, fieldDescriptor.isPacked());
          return;
        case INT32:
          SchemaUtil.writeInt32List(fieldDescriptor.getNumber(), arrayList.getValue(), paramWriter, fieldDescriptor.isPacked());
          return;
        case UINT64:
          SchemaUtil.writeUInt64List(fieldDescriptor.getNumber(), arrayList.getValue(), paramWriter, fieldDescriptor.isPacked());
          return;
        case INT64:
          SchemaUtil.writeInt64List(fieldDescriptor.getNumber(), arrayList.getValue(), paramWriter, fieldDescriptor.isPacked());
          return;
        case FLOAT:
          SchemaUtil.writeFloatList(fieldDescriptor.getNumber(), arrayList.getValue(), paramWriter, fieldDescriptor.isPacked());
          return;
        case DOUBLE:
          break;
      } 
      SchemaUtil.writeDoubleList(fieldDescriptor.getNumber(), arrayList.getValue(), paramWriter, fieldDescriptor.isPacked());
      return;
    } 
    switch (fieldDescriptor.getLiteType()) {
      default:
        return;
      case null:
        paramWriter.writeMessage(fieldDescriptor.getNumber(), arrayList.getValue());
        return;
      case GROUP:
        paramWriter.writeGroup(fieldDescriptor.getNumber(), arrayList.getValue());
        return;
      case STRING:
        paramWriter.writeString(fieldDescriptor.getNumber(), arrayList.getValue());
        return;
      case BYTES:
        paramWriter.writeBytes(fieldDescriptor.getNumber(), arrayList.getValue());
        return;
      case ENUM:
        paramWriter.writeInt32(fieldDescriptor.getNumber(), ((Descriptors.EnumValueDescriptor)arrayList.getValue()).getNumber());
        return;
      case SINT64:
        paramWriter.writeSInt64(fieldDescriptor.getNumber(), ((Long)arrayList.getValue()).longValue());
        return;
      case SINT32:
        paramWriter.writeSInt32(fieldDescriptor.getNumber(), ((Integer)arrayList.getValue()).intValue());
        return;
      case SFIXED64:
        paramWriter.writeSFixed64(fieldDescriptor.getNumber(), ((Long)arrayList.getValue()).longValue());
        return;
      case SFIXED32:
        paramWriter.writeSFixed32(fieldDescriptor.getNumber(), ((Integer)arrayList.getValue()).intValue());
        return;
      case UINT32:
        paramWriter.writeUInt32(fieldDescriptor.getNumber(), ((Integer)arrayList.getValue()).intValue());
        return;
      case BOOL:
        paramWriter.writeBool(fieldDescriptor.getNumber(), ((Boolean)arrayList.getValue()).booleanValue());
        return;
      case FIXED32:
        paramWriter.writeFixed32(fieldDescriptor.getNumber(), ((Integer)arrayList.getValue()).intValue());
        return;
      case FIXED64:
        paramWriter.writeFixed64(fieldDescriptor.getNumber(), ((Long)arrayList.getValue()).longValue());
        return;
      case INT32:
        paramWriter.writeInt32(fieldDescriptor.getNumber(), ((Integer)arrayList.getValue()).intValue());
        return;
      case UINT64:
        paramWriter.writeUInt64(fieldDescriptor.getNumber(), ((Long)arrayList.getValue()).longValue());
        return;
      case INT64:
        paramWriter.writeInt64(fieldDescriptor.getNumber(), ((Long)arrayList.getValue()).longValue());
        return;
      case FLOAT:
        paramWriter.writeFloat(fieldDescriptor.getNumber(), ((Float)arrayList.getValue()).floatValue());
        return;
      case DOUBLE:
        break;
    } 
    paramWriter.writeDouble(fieldDescriptor.getNumber(), ((Double)arrayList.getValue()).doubleValue());
  }
  
  void setExtensions(Object paramObject, FieldSet<Descriptors.FieldDescriptor> paramFieldSet) {
    UnsafeUtil.putObject(paramObject, EXTENSION_FIELD_OFFSET, paramFieldSet);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\ExtensionSchemaFull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */