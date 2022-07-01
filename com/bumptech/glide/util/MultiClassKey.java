package com.bumptech.glide.util;

public class MultiClassKey {
  private Class<?> a;
  
  private Class<?> b;
  
  private Class<?> c;
  
  public MultiClassKey() {}
  
  public MultiClassKey(Class<?> paramClass1, Class<?> paramClass2, Class<?> paramClass3) {
    a(paramClass1, paramClass2, paramClass3);
  }
  
  public void a(Class<?> paramClass1, Class<?> paramClass2, Class<?> paramClass3) {
    this.a = paramClass1;
    this.b = paramClass2;
    this.c = paramClass3;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      return !this.a.equals(((MultiClassKey)paramObject).a) ? false : (!this.b.equals(((MultiClassKey)paramObject).b) ? false : (!!Util.a(this.c, ((MultiClassKey)paramObject).c)));
    } 
    return false;
  }
  
  public int hashCode() {
    byte b;
    int i = this.a.hashCode();
    int j = this.b.hashCode();
    Class<?> clazz = this.c;
    if (clazz != null) {
      b = clazz.hashCode();
    } else {
      b = 0;
    } 
    return (i * 31 + j) * 31 + b;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("MultiClassKey{first=");
    stringBuilder.append(this.a);
    stringBuilder.append(", second=");
    stringBuilder.append(this.b);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glid\\util\MultiClassKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */