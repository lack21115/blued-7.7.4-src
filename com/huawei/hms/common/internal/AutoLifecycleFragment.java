package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.SparseArray;
import com.huawei.hms.api.HuaweiApiClient;

public class AutoLifecycleFragment extends Fragment {
  private static final String TAG = "HmsAutoLifecycleFrag";
  
  private final SparseArray<ClientInfo> mAutoClientInfoMap = new SparseArray();
  
  private boolean mStarted;
  
  public static AutoLifecycleFragment getInstance(Activity paramActivity) {
    Preconditions.checkMainThread("Must be called on the main thread");
    try {
      AutoLifecycleFragment autoLifecycleFragment2 = (AutoLifecycleFragment)paramActivity.getFragmentManager().findFragmentByTag("HmsAutoLifecycleFrag");
      FragmentManager fragmentManager = paramActivity.getFragmentManager();
      AutoLifecycleFragment autoLifecycleFragment1 = autoLifecycleFragment2;
      if (autoLifecycleFragment2 == null) {
        autoLifecycleFragment1 = new AutoLifecycleFragment();
        fragmentManager.beginTransaction().add(autoLifecycleFragment1, "HmsAutoLifecycleFrag").commitAllowingStateLoss();
        fragmentManager.executePendingTransactions();
      } 
      return autoLifecycleFragment1;
    } catch (ClassCastException classCastException) {
      throw new IllegalStateException("Fragment with tag HmsAutoLifecycleFrag is not a AutoLifecycleFragment", classCastException);
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
  }
  
  public void onStart() {
    super.onStart();
    this.mStarted = true;
    for (int i = 0; i < this.mAutoClientInfoMap.size(); i++)
      ((ClientInfo)this.mAutoClientInfoMap.valueAt(i)).apiClient.connect(null); 
  }
  
  public void onStop() {
    super.onStop();
    int i = 0;
    this.mStarted = false;
    while (i < this.mAutoClientInfoMap.size()) {
      ((ClientInfo)this.mAutoClientInfoMap.valueAt(i)).apiClient.disconnect();
      i++;
    } 
  }
  
  public void startAutoMange(int paramInt, HuaweiApiClient paramHuaweiApiClient) {
    boolean bool;
    Preconditions.checkNotNull(paramHuaweiApiClient, "HuaweiApiClient instance cannot be null");
    if (this.mAutoClientInfoMap.indexOfKey(paramInt) < 0) {
      bool = true;
    } else {
      bool = false;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Already managing a HuaweiApiClient with this clientId: ");
    stringBuilder.append(paramInt);
    Preconditions.checkState(bool, stringBuilder.toString());
    this.mAutoClientInfoMap.put(paramInt, new ClientInfo(paramInt, paramHuaweiApiClient));
    if (this.mStarted)
      paramHuaweiApiClient.connect(null); 
  }
  
  public void stopAutoManage(int paramInt) {
    ClientInfo clientInfo = (ClientInfo)this.mAutoClientInfoMap.get(paramInt);
    this.mAutoClientInfoMap.remove(paramInt);
    if (clientInfo != null)
      clientInfo.stopAutoManage(); 
  }
  
  class ClientInfo {
    public final HuaweiApiClient apiClient;
    
    public final int clientId;
    
    public ClientInfo(int param1Int, HuaweiApiClient param1HuaweiApiClient) {
      this.apiClient = param1HuaweiApiClient;
      this.clientId = param1Int;
    }
    
    public void stopAutoManage() {
      this.apiClient.disconnect();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\AutoLifecycleFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */