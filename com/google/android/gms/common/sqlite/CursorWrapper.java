package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.CursorWrapper;

public class CursorWrapper extends CursorWrapper implements CrossProcessCursor {
  private AbstractWindowedCursor zza;
  
  public CursorWrapper(Cursor paramCursor) {
    super(paramCursor);
    String str;
    for (int i = 0; i < 10 && paramCursor instanceof CursorWrapper; i++)
      paramCursor = ((CursorWrapper)paramCursor).getWrappedCursor(); 
    if (!(paramCursor instanceof AbstractWindowedCursor)) {
      str = String.valueOf(paramCursor.getClass().getName());
      if (str.length() != 0) {
        str = "Unknown type: ".concat(str);
      } else {
        str = new String("Unknown type: ");
      } 
      throw new IllegalArgumentException(str);
    } 
    this.zza = (AbstractWindowedCursor)str;
  }
  
  public void fillWindow(int paramInt, CursorWindow paramCursorWindow) {
    this.zza.fillWindow(paramInt, paramCursorWindow);
  }
  
  public CursorWindow getWindow() {
    return this.zza.getWindow();
  }
  
  public boolean onMove(int paramInt1, int paramInt2) {
    return this.zza.onMove(paramInt1, paramInt2);
  }
  
  public void setWindow(CursorWindow paramCursorWindow) {
    this.zza.setWindow(paramCursorWindow);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\sqlite\CursorWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */