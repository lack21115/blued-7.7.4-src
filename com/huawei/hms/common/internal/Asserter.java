package com.huawei.hms.common.internal;

public final class Asserter {
  private Asserter() {
    throw new AssertionError("Cannot use constructor to make a new instance");
  }
  
  public static void checkNotNull(Object paramObject) {
    if (paramObject != null)
      return; 
    throw new IllegalArgumentException("checked object is null");
  }
  
  public static void checkNotNull(Object paramObject1, Object paramObject2) {
    if (paramObject1 != null)
      return; 
    throw new IllegalArgumentException(paramObject2.toString());
  }
  
  public static void checkNull(Object paramObject) {
    if (paramObject == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramObject.toString());
    stringBuilder.append(" is not null");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public static void checkState(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException();
  }
  
  public static void checkState(boolean paramBoolean, Object paramObject) {
    if (paramBoolean)
      return; 
    throw new IllegalStateException(paramObject.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\Asserter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */