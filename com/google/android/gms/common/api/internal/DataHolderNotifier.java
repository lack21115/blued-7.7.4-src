package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.data.DataHolder;

public abstract class DataHolderNotifier<L> implements ListenerHolder.Notifier<L> {
  private final DataHolder zaa;
  
  protected DataHolderNotifier(DataHolder paramDataHolder) {
    this.zaa = paramDataHolder;
  }
  
  public final void notifyListener(L paramL) {
    notifyListener(paramL, this.zaa);
  }
  
  protected abstract void notifyListener(L paramL, DataHolder paramDataHolder);
  
  public void onNotifyListenerFailed() {
    DataHolder dataHolder = this.zaa;
    if (dataHolder != null)
      dataHolder.close(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\DataHolderNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */