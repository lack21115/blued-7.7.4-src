package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface MessageLite extends MessageLiteOrBuilder {
  Parser<? extends MessageLite> getParserForType();
  
  int getSerializedSize();
  
  Builder newBuilderForType();
  
  Builder toBuilder();
  
  byte[] toByteArray();
  
  ByteString toByteString();
  
  void writeDelimitedTo(OutputStream paramOutputStream) throws IOException;
  
  void writeTo(CodedOutputStream paramCodedOutputStream) throws IOException;
  
  void writeTo(OutputStream paramOutputStream) throws IOException;
  
  public static interface Builder extends MessageLiteOrBuilder, Cloneable {
    MessageLite build();
    
    MessageLite buildPartial();
    
    Builder clear();
    
    Builder clone();
    
    boolean mergeDelimitedFrom(InputStream param1InputStream) throws IOException;
    
    boolean mergeDelimitedFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException;
    
    Builder mergeFrom(ByteString param1ByteString) throws InvalidProtocolBufferException;
    
    Builder mergeFrom(ByteString param1ByteString, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException;
    
    Builder mergeFrom(CodedInputStream param1CodedInputStream) throws IOException;
    
    Builder mergeFrom(CodedInputStream param1CodedInputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException;
    
    Builder mergeFrom(MessageLite param1MessageLite);
    
    Builder mergeFrom(InputStream param1InputStream) throws IOException;
    
    Builder mergeFrom(InputStream param1InputStream, ExtensionRegistryLite param1ExtensionRegistryLite) throws IOException;
    
    Builder mergeFrom(byte[] param1ArrayOfbyte) throws InvalidProtocolBufferException;
    
    Builder mergeFrom(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws InvalidProtocolBufferException;
    
    Builder mergeFrom(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException;
    
    Builder mergeFrom(byte[] param1ArrayOfbyte, ExtensionRegistryLite param1ExtensionRegistryLite) throws InvalidProtocolBufferException;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\MessageLite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */