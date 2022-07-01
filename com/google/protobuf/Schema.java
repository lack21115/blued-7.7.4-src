package com.google.protobuf;

import java.io.IOException;

interface Schema<T> {
  boolean equals(T paramT1, T paramT2);
  
  int getSerializedSize(T paramT);
  
  int hashCode(T paramT);
  
  boolean isInitialized(T paramT);
  
  void makeImmutable(T paramT);
  
  void mergeFrom(T paramT, Reader paramReader, ExtensionRegistryLite paramExtensionRegistryLite) throws IOException;
  
  void mergeFrom(T paramT1, T paramT2);
  
  void mergeFrom(T paramT, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, ArrayDecoders.Registers paramRegisters) throws IOException;
  
  T newInstance();
  
  void writeTo(T paramT, Writer paramWriter) throws IOException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\Schema.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */