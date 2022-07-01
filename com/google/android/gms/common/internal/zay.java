package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zay extends RemoteCreator<zak> {
  private static final zay zaa = new zay();
  
  private zay() {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }
  
  public static View zaa(Context paramContext, int paramInt1, int paramInt2) throws RemoteCreator.RemoteCreatorException {
    return zaa.zab(paramContext, paramInt1, paramInt2);
  }
  
  private final View zab(Context paramContext, int paramInt1, int paramInt2) throws RemoteCreator.RemoteCreatorException {
    try {
      zaw zaw = new zaw(paramInt1, paramInt2, null);
      IObjectWrapper iObjectWrapper = ObjectWrapper.wrap(paramContext);
      return (View)ObjectWrapper.unwrap(((zak)getRemoteCreatorInstance(paramContext)).zaa(iObjectWrapper, zaw));
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder(64);
      stringBuilder.append("Could not get button with size ");
      stringBuilder.append(paramInt1);
      stringBuilder.append(" and color ");
      stringBuilder.append(paramInt2);
      throw new RemoteCreator.RemoteCreatorException(stringBuilder.toString(), exception);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\zay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */