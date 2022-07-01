package org.chromium.base.process_launcher;

import android.content.Context;
import android.content.Intent;

final class ChildProcessConnection$1 implements ChildProcessConnection$ChildServiceConnectionFactory {
  public final ChildProcessConnection$ChildServiceConnection createConnection(Intent paramIntent, int paramInt, ChildProcessConnection$ChildServiceConnectionDelegate paramChildProcessConnection$ChildServiceConnectionDelegate) {
    return new ChildProcessConnection$ChildServiceConnectionImpl(context, paramIntent, paramInt, paramChildProcessConnection$ChildServiceConnectionDelegate, (byte)0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\process_launcher\ChildProcessConnection$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */