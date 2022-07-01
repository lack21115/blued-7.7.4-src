package com.blued.android.chat.core.pack;

public class ReqEmptyBodyPackage extends ReqBasePackage {
  public ReqEmptyBodyPackage(short paramShort, long paramLong) {
    super(paramShort, paramLong);
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("(ReqEmptyBodyPackage)");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\ReqEmptyBodyPackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */