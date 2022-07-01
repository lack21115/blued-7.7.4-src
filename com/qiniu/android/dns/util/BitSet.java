package com.qiniu.android.dns.util;

public final class BitSet {
  private int set = 0;
  
  public boolean allIsSet(int paramInt) {
    return (this.set + 1 == 1 << paramInt);
  }
  
  public BitSet clear() {
    this.set = 0;
    return this;
  }
  
  public boolean isSet(int paramInt) {
    return ((1 << paramInt & this.set) != 0);
  }
  
  public int leadingZeros() {
    int i = this.set;
    int j = 16;
    i >>= 16;
    if (i != 0) {
      this.set = i;
    } else {
      j = 32;
    } 
    int k = this.set >> 8;
    i = j;
    if (k != 0) {
      i = j - 8;
      this.set = k;
    } 
    k = this.set >> 4;
    j = i;
    if (k != 0) {
      j = i - 4;
      this.set = k;
    } 
    k = this.set >> 2;
    i = j;
    if (k != 0) {
      i = j - 2;
      this.set = k;
    } 
    j = this.set;
    return (j >> 1 != 0) ? (i - 2) : (i - j);
  }
  
  public boolean noneIsSet(int paramInt) {
    return (this.set == 0);
  }
  
  public BitSet set(int paramInt) {
    this.set = 1 << paramInt | this.set;
    return this;
  }
  
  public int value() {
    return this.set;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\dn\\util\BitSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */