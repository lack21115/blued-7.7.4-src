package com.alibaba.fastjson.asm;

public class Label {
  int inputStackTop;
  
  Label next;
  
  int outputStackMax;
  
  int position;
  
  private int referenceCount;
  
  private int[] srcAndRefPositions;
  
  int status;
  
  Label successor;
  
  private void addReference(int paramInt1, int paramInt2) {
    if (this.srcAndRefPositions == null)
      this.srcAndRefPositions = new int[6]; 
    int i = this.referenceCount;
    int[] arrayOfInt = this.srcAndRefPositions;
    if (i >= arrayOfInt.length) {
      int[] arrayOfInt1 = new int[arrayOfInt.length + 6];
      System.arraycopy(arrayOfInt, 0, arrayOfInt1, 0, arrayOfInt.length);
      this.srcAndRefPositions = arrayOfInt1;
    } 
    arrayOfInt = this.srcAndRefPositions;
    i = this.referenceCount;
    this.referenceCount = i + 1;
    arrayOfInt[i] = paramInt1;
    paramInt1 = this.referenceCount;
    this.referenceCount = paramInt1 + 1;
    arrayOfInt[paramInt1] = paramInt2;
  }
  
  void put(MethodWriter paramMethodWriter, ByteVector paramByteVector, int paramInt) {
    if ((this.status & 0x2) == 0) {
      addReference(paramInt, paramByteVector.length);
      paramByteVector.putShort(-1);
      return;
    } 
    paramByteVector.putShort(this.position - paramInt);
  }
  
  void resolve(MethodWriter paramMethodWriter, int paramInt, byte[] paramArrayOfbyte) {
    this.status |= 0x2;
    this.position = paramInt;
    int i;
    for (i = 0; i < this.referenceCount; i = j + 1) {
      int[] arrayOfInt = this.srcAndRefPositions;
      int j = i + 1;
      int k = arrayOfInt[i];
      i = arrayOfInt[j];
      k = paramInt - k;
      paramArrayOfbyte[i] = (byte)(k >>> 8);
      paramArrayOfbyte[i + 1] = (byte)k;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\asm\Label.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */