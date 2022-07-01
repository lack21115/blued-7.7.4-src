package com.baidu.mobads.nativecpu;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.error.XAdErrorCode;
import com.baidu.mobads.nativecpu.a.a;
import com.baidu.mobads.nativecpu.a.b;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NativeCPUManager {
  private static final String a = NativeCPUManager.class.getSimpleName();
  
  private CPUAdListener b;
  
  private Context c;
  
  private int d = 10;
  
  private a e;
  
  private a f = null;
  
  private Map<String, Object> g = new HashMap<String, Object>();
  
  public NativeCPUManager(Context paramContext, String paramString, CPUAdListener paramCPUAdListener) {
    if (paramContext != null && !TextUtils.isEmpty(paramString)) {
      this.b = paramCPUAdListener;
      this.c = paramContext;
      this.e = new a(this);
      this.f = new a(paramContext, paramString);
      this.f.a(this.e);
      return;
    } 
    q.a().e(new Object[] { a, "Init params error!" });
    if (paramCPUAdListener != null)
      paramCPUAdListener.onAdError("Input params error.", XAdErrorCode.INTERFACE_USE_PROBLEM.getCode()); 
  }
  
  private void a(int paramInt, int[] paramArrayOfint, boolean paramBoolean) {
    if (paramInt > 0 && paramArrayOfint != null) {
      a a1 = this.f;
      if (a1 != null) {
        a1.a(paramInt, this.d, paramArrayOfint, paramBoolean, this.g);
        return;
      } 
    } else {
      q.a().e(new Object[] { a, "LoadAd with terrible params!" });
    } 
  }
  
  public void loadAd(int paramInt1, int paramInt2, boolean paramBoolean) {
    a(paramInt1, new int[] { paramInt2 }, paramBoolean);
  }
  
  public void setPageSize(int paramInt) {
    if (paramInt > 0 && paramInt <= 20) {
      this.d = paramInt;
      return;
    } 
    q.a().e(new Object[] { a, "Input page size is wrong which should be in (0,20]!" });
  }
  
  public void setRequestParameter(CPUAdRequest paramCPUAdRequest) {
    if (paramCPUAdRequest != null && paramCPUAdRequest.getExtras() != null) {
      this.g.clear();
      this.g.putAll(paramCPUAdRequest.getExtras());
    } 
  }
  
  public void setRequestTimeoutMillis(int paramInt) {
    a a1 = this.f;
    if (a1 != null)
      a1.a(paramInt); 
  }
  
  public static interface CPUAdListener {
    void onAdClick();
    
    void onAdError(String param1String, int param1Int);
    
    void onAdLoaded(List<IBasicCPUData> param1List);
    
    void onAdStatusChanged(String param1String);
    
    void onNoAd(String param1String, int param1Int);
    
    void onVideoDownloadFailed();
    
    void onVideoDownloadSuccess();
  }
  
  class a implements IOAdEventListener {
    public a(NativeCPUManager this$0) {}
    
    private String a(IOAdEvent param1IOAdEvent) {
      String str;
      if (param1IOAdEvent != null) {
        String str1 = param1IOAdEvent.getMessage();
        str = str1;
        if (TextUtils.isEmpty(str1)) {
          Map map = param1IOAdEvent.getData();
          str = str1;
          if (map != null) {
            map = (Map)map.get("msg");
            str = str1;
            if (map instanceof String)
              return (String)map; 
          } 
        } 
      } else {
        str = null;
      } 
      return str;
    }
    
    public void run(IOAdEvent param1IOAdEvent) {
      ArrayList<b> arrayList;
      if ("AdLoaded".equals(param1IOAdEvent.getType())) {
        if (NativeCPUManager.a(this.a) != null) {
          arrayList = new ArrayList();
          for (Object object : NativeCPUManager.b(this.a).b())
            arrayList.add(new b(NativeCPUManager.c(this.a), object)); 
          XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new b(this, arrayList));
          return;
        } 
      } else if ("AdError".equals(arrayList.getType())) {
        NativeCPUManager.b(this.a).a();
        String str = a((IOAdEvent)arrayList);
        int i = arrayList.getCode();
        if (NativeCPUManager.a(this.a) != null) {
          XAdSDKFoundationFacade.getInstance().getCommonUtils().a(new c(this, str, i));
          return;
        } 
      } else if ("AdEmptyList".equals(arrayList.getType())) {
        String str = (String)arrayList.getData().get("message");
        int i = arrayList.getCode();
        if (NativeCPUManager.a(this.a) != null) {
          NativeCPUManager.a(this.a).onNoAd(str, i);
          return;
        } 
      } else if ("AdUserClick".equals(arrayList.getType())) {
        if (NativeCPUManager.a(this.a) != null) {
          NativeCPUManager.a(this.a).onAdClick();
          return;
        } 
      } else if ("AdStatusChange".equals(arrayList.getType())) {
        if (NativeCPUManager.a(this.a) != null) {
          NativeCPUManager.a(this.a).onAdStatusChanged(arrayList.getMessage());
          return;
        } 
      } else if ("vdieoCacheSucc".equals(arrayList.getType())) {
        if (NativeCPUManager.a(this.a) != null) {
          NativeCPUManager.a(this.a).onVideoDownloadSuccess();
          return;
        } 
      } else if ("vdieoCacheFailed".equals(arrayList.getType()) && NativeCPUManager.a(this.a) != null) {
        NativeCPUManager.a(this.a).onVideoDownloadFailed();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\nativecpu\NativeCPUManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */