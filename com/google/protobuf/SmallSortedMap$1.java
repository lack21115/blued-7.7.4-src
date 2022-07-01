package com.google.protobuf;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class SmallSortedMap$1 extends SmallSortedMap {
  SmallSortedMap$1(int paramInt) {
    super(paramInt, (byte)0);
  }
  
  public final void makeImmutable() {
    if (!this.isImmutable) {
      for (int i = 0; i < getNumArrayEntries(); i++) {
        Map.Entry entry = getArrayEntryAt(i);
        if (((FieldSet$FieldDescriptorLite)entry.getKey()).isRepeated())
          entry.setValue(Collections.unmodifiableList((List)entry.getValue())); 
      } 
      for (Map.Entry entry : getOverflowEntries()) {
        if (((FieldSet$FieldDescriptorLite)entry.getKey()).isRepeated())
          entry.setValue(Collections.unmodifiableList((List)entry.getValue())); 
      } 
    } 
    super.makeImmutable();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\SmallSortedMap$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */