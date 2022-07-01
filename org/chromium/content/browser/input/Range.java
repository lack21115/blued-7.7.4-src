package org.chromium.content.browser.input;

public final class Range {
  int mEnd;
  
  int mStart;
  
  public Range(int paramInt1, int paramInt2) {
    this.mStart = Math.min(paramInt1, paramInt2);
    this.mEnd = Math.max(paramInt1, paramInt2);
  }
  
  public final void clamp(int paramInt1, int paramInt2) {
    this.mStart = Math.min(Math.max(this.mStart, paramInt1), paramInt2);
    this.mEnd = Math.max(Math.min(this.mEnd, paramInt2), paramInt1);
  }
  
  public final boolean equals(Object paramObject) {
    if (!(paramObject instanceof Range))
      return false; 
    if (paramObject == this)
      return true; 
    paramObject = paramObject;
    return (this.mStart == ((Range)paramObject).mStart && this.mEnd == ((Range)paramObject).mEnd);
  }
  
  public final int hashCode() {
    return this.mStart * 11 + this.mEnd * 31;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("[ ");
    stringBuilder.append(this.mStart);
    stringBuilder.append(", ");
    stringBuilder.append(this.mEnd);
    stringBuilder.append(" ]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\input\Range.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */