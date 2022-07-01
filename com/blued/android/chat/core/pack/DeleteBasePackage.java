package com.blued.android.chat.core.pack;

public class DeleteBasePackage extends BasePackage {
  protected DeleteBasePackage(long paramLong) {
    this.localId = paramLong;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[localId:");
    stringBuilder.append(this.localId);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\DeleteBasePackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */