package com.baidu.mobad.nativevideo;

import android.content.Context;
import com.baidu.mobad.feeds.BaiduNative;
import com.baidu.mobad.feeds.NativeErrorCode;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.production.c.c;
import java.util.ArrayList;
import java.util.List;

public class a implements BaiduNative.BaiduNativeNetworkListener {
  private c a;
  
  private a b;
  
  private BaiduNative c;
  
  public a(Context paramContext, String paramString, a parama) {
    this.a = (c)new com.baidu.mobads.production.i.a(paramContext, paramString);
    this.b = parama;
    this.c = new BaiduNative(paramContext, paramString, this, this.a);
  }
  
  public void a(RequestParameters paramRequestParameters) {
    this.c.makeRequest(paramRequestParameters);
  }
  
  public void onNativeFail(NativeErrorCode paramNativeErrorCode) {
    this.b.a(paramNativeErrorCode);
  }
  
  public void onNativeLoad(List<NativeResponse> paramList) {
    ArrayList<XAdVideoResponse> arrayList = new ArrayList();
    for (int i = 0; i < paramList.size(); i++)
      arrayList.add(new XAdVideoResponse(paramList.get(i), this.a.d, this.a.h)); 
    this.b.a((List)arrayList);
  }
  
  public static interface a {
    void a(NativeErrorCode param1NativeErrorCode);
    
    void a(List<e> param1List);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\nativevideo\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */