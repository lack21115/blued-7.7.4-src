package org.chromium.base.process_launcher;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import org.chromium.base.TraceEvent;

final class ChildProcessConnection$ChildServiceConnectionImpl implements ServiceConnection, ChildProcessConnection$ChildServiceConnection {
  private final int mBindFlags;
  
  private final Intent mBindIntent;
  
  private boolean mBound;
  
  private final Context mContext;
  
  private final ChildProcessConnection$ChildServiceConnectionDelegate mDelegate;
  
  private ChildProcessConnection$ChildServiceConnectionImpl(Context paramContext, Intent paramIntent, int paramInt, ChildProcessConnection$ChildServiceConnectionDelegate paramChildProcessConnection$ChildServiceConnectionDelegate) {
    this.mContext = paramContext;
    this.mBindIntent = paramIntent;
    this.mBindFlags = paramInt;
    this.mDelegate = paramChildProcessConnection$ChildServiceConnectionDelegate;
  }
  
  public final boolean bind() {
    if (!this.mBound)
      try {
        TraceEvent.begin("ChildProcessConnection.ChildServiceConnectionImpl.bind");
        this.mBound = this.mContext.bindService(this.mBindIntent, this, this.mBindFlags);
      } finally {
        TraceEvent.end("ChildProcessConnection.ChildServiceConnectionImpl.bind");
      }  
    return this.mBound;
  }
  
  public final boolean isBound() {
    return this.mBound;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    this.mDelegate.onServiceConnected(paramIBinder);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {
    this.mDelegate.onServiceDisconnected();
  }
  
  public final void unbind() {
    if (this.mBound) {
      this.mContext.unbindService(this);
      this.mBound = false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\process_launcher\ChildProcessConnection$ChildServiceConnectionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */