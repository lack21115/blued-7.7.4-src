package com.blued.android.chat.core.pack;

public class SyncBasePackage extends BasePackage {
  public static final short SYNC_ALL = 1;
  
  public static final short SYNC_LATER = 4;
  
  public static final short SYNC_NEW = 2;
  
  public static final short SYNC_RANGE = 3;
  
  protected final short syncType;
  
  protected SyncBasePackage(short paramShort, long paramLong) {
    this.syncType = paramShort;
    this.localId = paramLong;
  }
  
  public short getSyncType() {
    return this.syncType;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(super.toString());
    stringBuilder.append("[syncType:");
    stringBuilder.append(this.syncType);
    stringBuilder.append(", localId:");
    stringBuilder.append(this.localId);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\core\pack\SyncBasePackage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */