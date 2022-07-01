package com.google.protobuf;

import java.io.IOException;
import java.util.Map;

abstract class ExtensionSchema<T extends FieldSet.FieldDescriptorLite<T>> {
  abstract int extensionNumber(Map.Entry<?, ?> paramEntry);
  
  abstract Object findExtensionByNumber(ExtensionRegistryLite paramExtensionRegistryLite, MessageLite paramMessageLite, int paramInt);
  
  abstract FieldSet<T> getExtensions(Object paramObject);
  
  abstract FieldSet<T> getMutableExtensions(Object paramObject);
  
  abstract boolean hasExtensions(MessageLite paramMessageLite);
  
  abstract void makeImmutable(Object paramObject);
  
  abstract <UT, UB> UB parseExtension(Reader paramReader, Object paramObject, ExtensionRegistryLite paramExtensionRegistryLite, FieldSet<T> paramFieldSet, UB paramUB, UnknownFieldSchema<UT, UB> paramUnknownFieldSchema) throws IOException;
  
  abstract void parseLengthPrefixedMessageSetItem(Reader paramReader, Object paramObject, ExtensionRegistryLite paramExtensionRegistryLite, FieldSet<T> paramFieldSet) throws IOException;
  
  abstract void parseMessageSetItem(ByteString paramByteString, Object paramObject, ExtensionRegistryLite paramExtensionRegistryLite, FieldSet<T> paramFieldSet) throws IOException;
  
  abstract void serializeExtension(Writer paramWriter, Map.Entry<?, ?> paramEntry) throws IOException;
  
  abstract void setExtensions(Object paramObject, FieldSet<T> paramFieldSet);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\ExtensionSchema.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */