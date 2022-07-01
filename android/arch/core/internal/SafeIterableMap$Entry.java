package android.arch.core.internal;

import java.util.Map;

final class SafeIterableMap$Entry implements Map.Entry {
  private Object mKey;
  
  SafeIterableMap$Entry mNext;
  
  SafeIterableMap$Entry mPrevious;
  
  private Object mValue;
  
  public final boolean equals(Object paramObject) {
    if (paramObject == this)
      return true; 
    if (!(paramObject instanceof SafeIterableMap$Entry))
      return false; 
    paramObject = paramObject;
    return (this.mKey.equals(((SafeIterableMap$Entry)paramObject).mKey) && this.mValue.equals(((SafeIterableMap$Entry)paramObject).mValue));
  }
  
  public final Object getKey() {
    return this.mKey;
  }
  
  public final Object getValue() {
    return this.mValue;
  }
  
  public final Object setValue(Object paramObject) {
    throw new UnsupportedOperationException("An entry modification is not supported");
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.mKey);
    stringBuilder.append("=");
    stringBuilder.append(this.mValue);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\arch\core\internal\SafeIterableMap$Entry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */