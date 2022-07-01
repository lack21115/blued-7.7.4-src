package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;

public interface Message extends MessageLite, MessageOrBuilder {
  boolean equals(Object paramObject);
  
  Parser<? extends Message> getParserForType();
  
  int hashCode();
  
  Builder newBuilderForType();
  
  Builder toBuilder();
  
  String toString();
  
  public static interface Builder extends MessageLite.Builder, MessageOrBuilder {
    Builder addRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object);
    
    Message build();
    
    Message buildPartial();
    
    Builder clear();
    
    Builder clearField(Descriptors.FieldDescriptor param1FieldDescriptor);
    
    Builder clearOneof(Descriptors.OneofDescriptor param1OneofDescriptor);
    
    Builder clone();
    
    Descriptors.Descriptor getDescriptorForType();
    
    Builder getFieldBuilder(Descriptors.FieldDescriptor param1FieldDescriptor);
    
    Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int);
    
    boolean mergeDelimitedFrom(InputStream param1InputStream) throws IOException;
    
    boolean mergeDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException;
    
    Builder mergeFrom(ByteString param1ByteString) throws InvalidProtocolBufferException;
    
    Builder mergeFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException;
    
    Builder mergeFrom(CodedInputStream param1CodedInputStream) throws IOException;
    
    Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException;
    
    Builder mergeFrom(Message param1Message);
    
    Builder mergeFrom(InputStream param1InputStream) throws IOException;
    
    Builder mergeFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException;
    
    Builder mergeFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException;
    
    Builder mergeFrom(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws InvalidProtocolBufferException;
    
    Builder mergeFrom(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException;
    
    Builder mergeFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException;
    
    Builder mergeUnknownFields(UnknownFieldSet param1UnknownFieldSet);
    
    Builder newBuilderForField(Descriptors.FieldDescriptor param1FieldDescriptor);
    
    Builder setField(Descriptors.FieldDescriptor param1FieldDescriptor, Object param1Object);
    
    Builder setRepeatedField(Descriptors.FieldDescriptor param1FieldDescriptor, int param1Int, Object param1Object);
    
    Builder setUnknownFields(UnknownFieldSet param1UnknownFieldSet);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */