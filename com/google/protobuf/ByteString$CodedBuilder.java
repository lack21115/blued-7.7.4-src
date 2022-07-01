package com.google.protobuf;

final class ByteString$CodedBuilder {
  final byte[] buffer;
  
  final CodedOutputStream output;
  
  private ByteString$CodedBuilder(int paramInt) {
    this.buffer = new byte[paramInt];
    this.output = CodedOutputStream.newInstance(this.buffer);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\ByteString$CodedBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */