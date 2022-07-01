package com.google.type;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface MoneyOrBuilder extends MessageOrBuilder {
  String getCurrencyCode();
  
  ByteString getCurrencyCodeBytes();
  
  int getNanos();
  
  long getUnits();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\type\MoneyOrBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */