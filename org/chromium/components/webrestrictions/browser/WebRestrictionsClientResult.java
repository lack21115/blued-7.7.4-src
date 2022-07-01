package org.chromium.components.webrestrictions.browser;

import android.database.Cursor;
import org.chromium.base.annotations.CalledByNative;

public class WebRestrictionsClientResult {
  private final Cursor mCursor;
  
  public WebRestrictionsClientResult(Cursor paramCursor) {
    this.mCursor = paramCursor;
    if (paramCursor == null)
      return; 
    paramCursor.moveToFirst();
  }
  
  @CalledByNative
  public int getColumnCount() {
    return (this.mCursor == null) ? 0 : this.mCursor.getColumnCount();
  }
  
  @CalledByNative
  public String getColumnName(int paramInt) {
    return (this.mCursor == null) ? null : this.mCursor.getColumnName(paramInt);
  }
  
  @CalledByNative
  public int getInt(int paramInt) {
    return (this.mCursor == null) ? 0 : this.mCursor.getInt(paramInt);
  }
  
  @CalledByNative
  public String getString(int paramInt) {
    return (this.mCursor == null) ? null : this.mCursor.getString(paramInt);
  }
  
  @CalledByNative
  public boolean isString(int paramInt) {
    return (this.mCursor == null) ? false : ((this.mCursor.getType(paramInt) == 3));
  }
  
  @CalledByNative
  public boolean shouldProceed() {
    return (this.mCursor == null) ? false : ((this.mCursor.getInt(0) > 0));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\components\webrestrictions\browser\WebRestrictionsClientResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */