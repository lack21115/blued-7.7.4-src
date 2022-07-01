package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Objects {
  private Objects() {
    throw new AssertionError("Uninstantiable");
  }
  
  public static boolean equal(Object paramObject1, Object paramObject2) {
    return (paramObject1 == paramObject2) ? true : ((paramObject1 != null && paramObject1.equals(paramObject2)));
  }
  
  public static int hashCode(Object... paramVarArgs) {
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static ToStringHelper toStringHelper(Object paramObject) {
    return new ToStringHelper(paramObject);
  }
  
  public static final class ToStringHelper {
    private final List<String> a;
    
    private final Object b;
    
    private ToStringHelper(Object param1Object) {
      this.b = Preconditions.checkNotNull(param1Object);
      this.a = new ArrayList<String>();
    }
    
    public final ToStringHelper add(String param1String, Object param1Object) {
      param1String = Preconditions.<String>checkNotNull(param1String);
      param1Object = String.valueOf(param1Object);
      StringBuilder stringBuilder = new StringBuilder(param1String.length() + param1Object.length() + 1);
      stringBuilder.append(param1String);
      stringBuilder.append("=");
      stringBuilder.append((String)param1Object);
      param1String = stringBuilder.toString();
      this.a.add(param1String);
      return this;
    }
    
    public final String toString() {
      String str = this.b.getClass().getSimpleName();
      StringBuilder stringBuilder = new StringBuilder(100);
      stringBuilder.append(str);
      stringBuilder.append('{');
      int j = this.a.size();
      for (int i = 0; i < j; i++) {
        stringBuilder.append(this.a.get(i));
        if (i < j - 1)
          stringBuilder.append(", "); 
      } 
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\Objects.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */