package org.chromium.mojo.bindings;

public final class DataHeader {
  public final int elementsOrVersion;
  
  public final int size;
  
  public DataHeader(int paramInt1, int paramInt2) {
    this.size = paramInt1;
    this.elementsOrVersion = paramInt2;
  }
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    return (this.elementsOrVersion == ((DataHeader)paramObject).elementsOrVersion && this.size == ((DataHeader)paramObject).size);
  }
  
  public final int hashCode() {
    return (this.elementsOrVersion + 31) * 31 + this.size;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\DataHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */