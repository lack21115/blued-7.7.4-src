package com.google.protobuf;

final class ProtobufLists {
  public static Internal.BooleanList emptyBooleanList() {
    return BooleanArrayList.emptyList();
  }
  
  public static Internal.DoubleList emptyDoubleList() {
    return DoubleArrayList.emptyList();
  }
  
  public static Internal.FloatList emptyFloatList() {
    return FloatArrayList.emptyList();
  }
  
  public static Internal.IntList emptyIntList() {
    return IntArrayList.emptyList();
  }
  
  public static Internal.LongList emptyLongList() {
    return LongArrayList.emptyList();
  }
  
  public static <E> Internal.ProtobufList<E> emptyProtobufList() {
    return ProtobufArrayList.emptyList();
  }
  
  public static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> paramProtobufList) {
    int i = paramProtobufList.size();
    if (i == 0) {
      i = 10;
    } else {
      i *= 2;
    } 
    return paramProtobufList.mutableCopyWithCapacity(i);
  }
  
  public static Internal.BooleanList newBooleanList() {
    return new BooleanArrayList();
  }
  
  public static Internal.DoubleList newDoubleList() {
    return new DoubleArrayList();
  }
  
  public static Internal.FloatList newFloatList() {
    return new FloatArrayList();
  }
  
  public static Internal.IntList newIntList() {
    return new IntArrayList();
  }
  
  public static Internal.LongList newLongList() {
    return new LongArrayList();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\ProtobufLists.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */