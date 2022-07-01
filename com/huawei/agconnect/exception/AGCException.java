package com.huawei.agconnect.exception;

public abstract class AGCException extends Exception {
  private int a;
  
  private String b;
  
  public String getMessage() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" code: ");
    stringBuilder.append(this.a);
    stringBuilder.append(" message: ");
    stringBuilder.append(this.b);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\agconnect\exception\AGCException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */