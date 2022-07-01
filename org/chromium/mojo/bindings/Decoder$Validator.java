package org.chromium.mojo.bindings;

final class Decoder$Validator {
  private final long mMaxMemory;
  
  int mMinNextClaimedHandle;
  
  private long mMinNextMemory;
  
  final long mNumberOfHandles;
  
  long mStackDepth;
  
  Decoder$Validator(long paramLong, int paramInt) {
    this.mMaxMemory = paramLong;
    this.mNumberOfHandles = paramInt;
    this.mStackDepth = 0L;
  }
  
  public final void claimMemory(long paramLong1, long paramLong2) {
    if (paramLong1 % 8L == 0L) {
      if (paramLong1 >= this.mMinNextMemory) {
        if (paramLong2 >= paramLong1) {
          if (paramLong2 <= this.mMaxMemory) {
            this.mMinNextMemory = BindingsHelper.align(paramLong2);
            return;
          } 
          throw new DeserializationException("Trying to access out of range memory.");
        } 
        throw new DeserializationException("Incorrect memory range.");
      } 
      throw new DeserializationException("Trying to access memory out of order.");
    } 
    StringBuilder stringBuilder = new StringBuilder("Incorrect starting alignment: ");
    stringBuilder.append(paramLong1);
    stringBuilder.append(".");
    throw new DeserializationException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\Decoder$Validator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */