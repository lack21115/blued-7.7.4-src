package com.google.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class ExtensionSchemaLite extends ExtensionSchema<GeneratedMessageLite.ExtensionDescriptor> {
  int extensionNumber(Map.Entry<?, ?> paramEntry) {
    return ((GeneratedMessageLite.ExtensionDescriptor)paramEntry.getKey()).getNumber();
  }
  
  Object findExtensionByNumber(ExtensionRegistryLite paramExtensionRegistryLite, MessageLite paramMessageLite, int paramInt) {
    return paramExtensionRegistryLite.findLiteExtensionByNumber(paramMessageLite, paramInt);
  }
  
  FieldSet<GeneratedMessageLite.ExtensionDescriptor> getExtensions(Object paramObject) {
    return ((GeneratedMessageLite.ExtendableMessage)paramObject).extensions;
  }
  
  FieldSet<GeneratedMessageLite.ExtensionDescriptor> getMutableExtensions(Object paramObject) {
    return ((GeneratedMessageLite.ExtendableMessage)paramObject).ensureExtensionsAreMutable();
  }
  
  boolean hasExtensions(MessageLite paramMessageLite) {
    return paramMessageLite instanceof GeneratedMessageLite.ExtendableMessage;
  }
  
  void makeImmutable(Object paramObject) {
    getExtensions(paramObject).makeImmutable();
  }
  
  <UT, UB> UB parseExtension(Reader paramReader, Object paramObject, ExtensionRegistryLite paramExtensionRegistryLite, FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet, UB paramUB, UnknownFieldSchema<UT, UB> paramUnknownFieldSchema) throws IOException {
    Object object;
    GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension)paramObject;
    int i = generatedExtension.getNumber();
    if (generatedExtension.descriptor.isRepeated() && generatedExtension.descriptor.isPacked()) {
      StringBuilder stringBuilder;
      switch (generatedExtension.getLiteType()) {
        default:
          stringBuilder = new StringBuilder();
          stringBuilder.append("Type cannot be packed: ");
          stringBuilder.append(generatedExtension.descriptor.getLiteType());
          throw new IllegalStateException(stringBuilder.toString());
        case ENUM:
          paramObject = new ArrayList();
          stringBuilder.readEnumList((List<Integer>)paramObject);
          paramUB = SchemaUtil.filterUnknownEnumList(i, (List<Integer>)paramObject, generatedExtension.descriptor.getEnumType(), paramUB, paramUnknownFieldSchema);
          object = paramObject;
          paramFieldSet.setField(generatedExtension.descriptor, object);
          return paramUB;
        case SINT64:
          paramObject = new ArrayList();
          object.readSInt64List((List<Long>)paramObject);
          object = paramObject;
          paramFieldSet.setField(generatedExtension.descriptor, object);
          return paramUB;
        case SINT32:
          paramObject = new ArrayList();
          object.readSInt32List((List<Integer>)paramObject);
          object = paramObject;
          paramFieldSet.setField(generatedExtension.descriptor, object);
          return paramUB;
        case SFIXED64:
          paramObject = new ArrayList();
          object.readSFixed64List((List<Long>)paramObject);
          object = paramObject;
          paramFieldSet.setField(generatedExtension.descriptor, object);
          return paramUB;
        case SFIXED32:
          paramObject = new ArrayList();
          object.readSFixed32List((List<Integer>)paramObject);
          object = paramObject;
          paramFieldSet.setField(generatedExtension.descriptor, object);
          return paramUB;
        case UINT32:
          paramObject = new ArrayList();
          object.readUInt32List((List<Integer>)paramObject);
          object = paramObject;
          paramFieldSet.setField(generatedExtension.descriptor, object);
          return paramUB;
        case BOOL:
          paramObject = new ArrayList();
          object.readBoolList((List<Boolean>)paramObject);
          object = paramObject;
          paramFieldSet.setField(generatedExtension.descriptor, object);
          return paramUB;
        case FIXED32:
          paramObject = new ArrayList();
          object.readFixed32List((List<Integer>)paramObject);
          object = paramObject;
          paramFieldSet.setField(generatedExtension.descriptor, object);
          return paramUB;
        case FIXED64:
          paramObject = new ArrayList();
          object.readFixed64List((List<Long>)paramObject);
          object = paramObject;
          paramFieldSet.setField(generatedExtension.descriptor, object);
          return paramUB;
        case INT32:
          paramObject = new ArrayList();
          object.readInt32List((List<Integer>)paramObject);
          object = paramObject;
          paramFieldSet.setField(generatedExtension.descriptor, object);
          return paramUB;
        case UINT64:
          paramObject = new ArrayList();
          object.readUInt64List((List<Long>)paramObject);
          object = paramObject;
          paramFieldSet.setField(generatedExtension.descriptor, object);
          return paramUB;
        case INT64:
          paramObject = new ArrayList();
          object.readInt64List((List<Long>)paramObject);
          object = paramObject;
          paramFieldSet.setField(generatedExtension.descriptor, object);
          return paramUB;
        case FLOAT:
          paramObject = new ArrayList();
          object.readFloatList((List<Float>)paramObject);
          object = paramObject;
          paramFieldSet.setField(generatedExtension.descriptor, object);
          return paramUB;
        case DOUBLE:
          break;
      } 
      paramObject = new ArrayList();
      object.readDoubleList((List<Double>)paramObject);
      object = paramObject;
      paramFieldSet.setField(generatedExtension.descriptor, object);
      return paramUB;
    } 
    paramObject = null;
    if (generatedExtension.getLiteType() == WireFormat.FieldType.ENUM) {
      int j = object.readInt32();
      if (generatedExtension.descriptor.getEnumType().findValueByNumber(j) == null)
        return SchemaUtil.storeUnknownEnum(i, j, paramUB, paramUnknownFieldSchema); 
      object = Integer.valueOf(j);
    } else {
      switch (generatedExtension.getLiteType()) {
        default:
          object = paramObject;
          break;
        case null:
          object = object.readMessage(generatedExtension.getMessageDefaultInstance().getClass(), paramExtensionRegistryLite);
          break;
        case GROUP:
          object = object.readGroup(generatedExtension.getMessageDefaultInstance().getClass(), paramExtensionRegistryLite);
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
    if (generatedExtension.isRepeated()) {
      paramFieldSet.addRepeatedField(generatedExtension.descriptor, object);
      return paramUB;
    } 
    i = null.$SwitchMap$com$google$protobuf$WireFormat$FieldType[generatedExtension.getLiteType().ordinal()];
    if (i != 17 && i != 18) {
      paramObject = object;
    } else {
      Object object1 = paramFieldSet.getField(generatedExtension.descriptor);
      paramObject = object;
      if (object1 != null)
        paramObject = Internal.mergeMessage(object1, object); 
    } 
    paramFieldSet.setField(generatedExtension.descriptor, paramObject);
    return paramUB;
  }
  
  void parseLengthPrefixedMessageSetItem(Reader paramReader, Object paramObject, ExtensionRegistryLite paramExtensionRegistryLite, FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet) throws IOException {
    paramObject = paramObject;
    paramReader = paramReader.readMessage(paramObject.getMessageDefaultInstance().getClass(), paramExtensionRegistryLite);
    paramFieldSet.setField(((GeneratedMessageLite.GeneratedExtension)paramObject).descriptor, paramReader);
  }
  
  void parseMessageSetItem(ByteString paramByteString, Object paramObject, ExtensionRegistryLite paramExtensionRegistryLite, FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet) throws IOException {
    paramObject = paramObject;
    MessageLite messageLite = paramObject.getMessageDefaultInstance().newBuilderForType().buildPartial();
    BinaryReader binaryReader = BinaryReader.newInstance(ByteBuffer.wrap(paramByteString.toByteArray()), true);
    Protobuf.getInstance().mergeFrom(messageLite, binaryReader, paramExtensionRegistryLite);
    paramFieldSet.setField(((GeneratedMessageLite.GeneratedExtension)paramObject).descriptor, messageLite);
    if (binaryReader.getFieldNumber() == Integer.MAX_VALUE)
      return; 
    throw InvalidProtocolBufferException.invalidEndTag();
  }
  
  void serializeExtension(Writer paramWriter, Map.Entry<?, ?> paramEntry) throws IOException {
    GeneratedMessageLite.ExtensionDescriptor extensionDescriptor = (GeneratedMessageLite.ExtensionDescriptor)paramEntry.getKey();
    if (extensionDescriptor.isRepeated()) {
      List<E> list;
      switch (extensionDescriptor.getLiteType()) {
        default:
          return;
        case null:
          list = (List)paramEntry.getValue();
          if (list != null && !list.isEmpty()) {
            SchemaUtil.writeMessageList(extensionDescriptor.getNumber(), (List)paramEntry.getValue(), paramWriter, Protobuf.getInstance().schemaFor(list.get(0).getClass()));
            return;
          } 
          return;
        case GROUP:
          list = (List<E>)paramEntry.getValue();
          if (list != null && !list.isEmpty()) {
            SchemaUtil.writeGroupList(extensionDescriptor.getNumber(), (List)paramEntry.getValue(), paramWriter, Protobuf.getInstance().schemaFor(list.get(0).getClass()));
            return;
          } 
          return;
        case STRING:
          SchemaUtil.writeStringList(extensionDescriptor.getNumber(), (List<String>)paramEntry.getValue(), paramWriter);
          return;
        case BYTES:
          SchemaUtil.writeBytesList(extensionDescriptor.getNumber(), (List<ByteString>)paramEntry.getValue(), paramWriter);
          return;
        case ENUM:
          SchemaUtil.writeInt32List(extensionDescriptor.getNumber(), (List<Integer>)paramEntry.getValue(), paramWriter, extensionDescriptor.isPacked());
          return;
        case SINT64:
          SchemaUtil.writeSInt64List(extensionDescriptor.getNumber(), (List<Long>)paramEntry.getValue(), paramWriter, extensionDescriptor.isPacked());
          return;
        case SINT32:
          SchemaUtil.writeSInt32List(extensionDescriptor.getNumber(), (List<Integer>)paramEntry.getValue(), paramWriter, extensionDescriptor.isPacked());
          return;
        case SFIXED64:
          SchemaUtil.writeSFixed64List(extensionDescriptor.getNumber(), (List<Long>)paramEntry.getValue(), paramWriter, extensionDescriptor.isPacked());
          return;
        case SFIXED32:
          SchemaUtil.writeSFixed32List(extensionDescriptor.getNumber(), (List<Integer>)paramEntry.getValue(), paramWriter, extensionDescriptor.isPacked());
          return;
        case UINT32:
          SchemaUtil.writeUInt32List(extensionDescriptor.getNumber(), (List<Integer>)paramEntry.getValue(), paramWriter, extensionDescriptor.isPacked());
          return;
        case BOOL:
          SchemaUtil.writeBoolList(extensionDescriptor.getNumber(), (List<Boolean>)paramEntry.getValue(), paramWriter, extensionDescriptor.isPacked());
          return;
        case FIXED32:
          SchemaUtil.writeFixed32List(extensionDescriptor.getNumber(), (List<Integer>)paramEntry.getValue(), paramWriter, extensionDescriptor.isPacked());
          return;
        case FIXED64:
          SchemaUtil.writeFixed64List(extensionDescriptor.getNumber(), (List<Long>)paramEntry.getValue(), paramWriter, extensionDescriptor.isPacked());
          return;
        case INT32:
          SchemaUtil.writeInt32List(extensionDescriptor.getNumber(), (List<Integer>)paramEntry.getValue(), paramWriter, extensionDescriptor.isPacked());
          return;
        case UINT64:
          SchemaUtil.writeUInt64List(extensionDescriptor.getNumber(), (List<Long>)paramEntry.getValue(), paramWriter, extensionDescriptor.isPacked());
          return;
        case INT64:
          SchemaUtil.writeInt64List(extensionDescriptor.getNumber(), (List<Long>)paramEntry.getValue(), paramWriter, extensionDescriptor.isPacked());
          return;
        case FLOAT:
          SchemaUtil.writeFloatList(extensionDescriptor.getNumber(), (List<Float>)paramEntry.getValue(), paramWriter, extensionDescriptor.isPacked());
          return;
        case DOUBLE:
          break;
      } 
      SchemaUtil.writeDoubleList(extensionDescriptor.getNumber(), (List<Double>)paramEntry.getValue(), paramWriter, extensionDescriptor.isPacked());
      return;
    } 
    switch (extensionDescriptor.getLiteType()) {
      default:
        return;
      case null:
        paramWriter.writeMessage(extensionDescriptor.getNumber(), paramEntry.getValue(), Protobuf.getInstance().schemaFor(paramEntry.getValue().getClass()));
        return;
      case GROUP:
        paramWriter.writeGroup(extensionDescriptor.getNumber(), paramEntry.getValue(), Protobuf.getInstance().schemaFor(paramEntry.getValue().getClass()));
        return;
      case STRING:
        paramWriter.writeString(extensionDescriptor.getNumber(), (String)paramEntry.getValue());
        return;
      case BYTES:
        paramWriter.writeBytes(extensionDescriptor.getNumber(), (ByteString)paramEntry.getValue());
        return;
      case ENUM:
        paramWriter.writeInt32(extensionDescriptor.getNumber(), ((Integer)paramEntry.getValue()).intValue());
        return;
      case SINT64:
        paramWriter.writeSInt64(extensionDescriptor.getNumber(), ((Long)paramEntry.getValue()).longValue());
        return;
      case SINT32:
        paramWriter.writeSInt32(extensionDescriptor.getNumber(), ((Integer)paramEntry.getValue()).intValue());
        return;
      case SFIXED64:
        paramWriter.writeSFixed64(extensionDescriptor.getNumber(), ((Long)paramEntry.getValue()).longValue());
        return;
      case SFIXED32:
        paramWriter.writeSFixed32(extensionDescriptor.getNumber(), ((Integer)paramEntry.getValue()).intValue());
        return;
      case UINT32:
        paramWriter.writeUInt32(extensionDescriptor.getNumber(), ((Integer)paramEntry.getValue()).intValue());
        return;
      case BOOL:
        paramWriter.writeBool(extensionDescriptor.getNumber(), ((Boolean)paramEntry.getValue()).booleanValue());
        return;
      case FIXED32:
        paramWriter.writeFixed32(extensionDescriptor.getNumber(), ((Integer)paramEntry.getValue()).intValue());
        return;
      case FIXED64:
        paramWriter.writeFixed64(extensionDescriptor.getNumber(), ((Long)paramEntry.getValue()).longValue());
        return;
      case INT32:
        paramWriter.writeInt32(extensionDescriptor.getNumber(), ((Integer)paramEntry.getValue()).intValue());
        return;
      case UINT64:
        paramWriter.writeUInt64(extensionDescriptor.getNumber(), ((Long)paramEntry.getValue()).longValue());
        return;
      case INT64:
        paramWriter.writeInt64(extensionDescriptor.getNumber(), ((Long)paramEntry.getValue()).longValue());
        return;
      case FLOAT:
        paramWriter.writeFloat(extensionDescriptor.getNumber(), ((Float)paramEntry.getValue()).floatValue());
        return;
      case DOUBLE:
        break;
    } 
    paramWriter.writeDouble(extensionDescriptor.getNumber(), ((Double)paramEntry.getValue()).doubleValue());
  }
  
  void setExtensions(Object paramObject, FieldSet<GeneratedMessageLite.ExtensionDescriptor> paramFieldSet) {
    ((GeneratedMessageLite.ExtendableMessage)paramObject).extensions = paramFieldSet;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\ExtensionSchemaLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */