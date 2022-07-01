package com.google.protobuf;

interface MessageInfoFactory {
  boolean isSupported(Class<?> paramClass);
  
  MessageInfo messageInfoFor(Class<?> paramClass);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\MessageInfoFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */