package com.google.protobuf;

interface MessageInfo {
  MessageLite getDefaultInstance();
  
  ProtoSyntax getSyntax();
  
  boolean isMessageSetWireFormat();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\MessageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */