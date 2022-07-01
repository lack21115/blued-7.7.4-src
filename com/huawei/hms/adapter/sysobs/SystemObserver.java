package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

public interface SystemObserver {
  boolean onSolutionResult(Intent paramIntent, String paramString);
  
  boolean onUpdateResult(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\adapter\sysobs\SystemObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */