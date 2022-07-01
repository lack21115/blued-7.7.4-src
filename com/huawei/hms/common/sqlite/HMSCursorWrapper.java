package com.huawei.hms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;

public class HMSCursorWrapper extends CursorWrapper implements CrossProcessCursor {
  private AbstractWindowedCursor mCursor;
  
  public HMSCursorWrapper(Cursor paramCursor) {
    super(paramCursor);
    if (paramCursor != null) {
      if (paramCursor instanceof CursorWrapper) {
        paramCursor = ((CursorWrapper)paramCursor).getWrappedCursor();
        if (paramCursor != null) {
          if (paramCursor instanceof AbstractWindowedCursor) {
            this.mCursor = (AbstractWindowedCursor)paramCursor;
            return;
          } 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("getWrappedCursor:");
          stringBuilder1.append(paramCursor);
          stringBuilder1.append(" is not a subclass for CursorWrapper");
          throw new IllegalArgumentException(stringBuilder1.toString());
        } 
        throw new IllegalArgumentException("getWrappedCursor cannot be null");
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("cursor:");
      stringBuilder.append(paramCursor);
      stringBuilder.append(" is not a subclass for CursorWrapper");
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    throw new IllegalArgumentException("cursor cannot be null");
  }
  
  public void fillWindow(int paramInt, CursorWindow paramCursorWindow) {
    this.mCursor.fillWindow(paramInt, paramCursorWindow);
  }
  
  public CursorWindow getWindow() {
    return this.mCursor.getWindow();
  }
  
  public Cursor getWrappedCursor() {
    return (Cursor)this.mCursor;
  }
  
  public boolean onMove(int paramInt1, int paramInt2) {
    return this.mCursor.onMove(paramInt1, paramInt2);
  }
  
  public void setWindow(CursorWindow paramCursorWindow) {
    this.mCursor.setWindow(paramCursorWindow);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\sqlite\HMSCursorWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */