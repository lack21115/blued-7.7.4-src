package org.chromium.mojo.system;

public abstract class Flags {
  public int mFlags;
  
  boolean mImmutable = false;
  
  protected Flags(int paramInt) {
    this.mFlags = paramInt;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (getClass() != paramObject.getClass())
      return false; 
    paramObject = paramObject;
    return !(this.mFlags != ((Flags)paramObject).mFlags);
  }
  
  public int hashCode() {
    return this.mFlags;
  }
  
  protected final Flags setFlag(int paramInt, boolean paramBoolean) {
    if (!this.mImmutable) {
      if (paramBoolean) {
        this.mFlags = paramInt | this.mFlags;
        return this;
      } 
      this.mFlags = (paramInt ^ 0xFFFFFFFF) & this.mFlags;
      return this;
    } 
    throw new UnsupportedOperationException("Flags is immutable.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\system\Flags.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */