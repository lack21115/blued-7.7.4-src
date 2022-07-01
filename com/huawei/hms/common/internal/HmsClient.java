package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public abstract class HmsClient extends BaseHmsClient implements AnyClient {
  private static final String TAG = "HmsClient";
  
  public HmsClient(Context paramContext, ClientSettings paramClientSettings, BaseHmsClient.OnConnectionFailedListener paramOnConnectionFailedListener, BaseHmsClient.ConnectionCallbacks paramConnectionCallbacks) {
    super(paramContext, paramClientSettings, paramOnConnectionFailedListener, paramConnectionCallbacks);
  }
  
  public void post(IMessageEntity paramIMessageEntity, String paramString, AnyClient.CallBack paramCallBack) {
    BaseAdapter baseAdapter;
    if (paramCallBack == null) {
      HMSLog.e("HmsClient", "callback is invalid, discard.");
      return;
    } 
    if (!(paramIMessageEntity instanceof RequestHeader) || paramString == null) {
      HMSLog.e("HmsClient", "arguments is invalid.");
      paramCallBack.onCallback(new ResponseHeader(1, 907135000, "Args is invalid"), (new JSONObject()).toString());
      return;
    } 
    if (!isConnected()) {
      HMSLog.e("HmsClient", "post failed for no connected.");
      paramCallBack.onCallback(new ResponseHeader(1, 907135001, "Not Connected"), (new JSONObject()).toString());
      return;
    } 
    RequestHeader requestHeader = (RequestHeader)paramIMessageEntity;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("post msg ");
    stringBuilder.append(requestHeader);
    HMSLog.i("HmsClient", stringBuilder.toString());
    Activity activity = getClientSettings().getCpActivity();
    if (activity == null) {
      baseAdapter = new BaseAdapter((ApiClient)this);
    } else {
      baseAdapter = new BaseAdapter((ApiClient)this, (Activity)baseAdapter);
    } 
    baseAdapter.baseRequest(requestHeader.toJson(), paramString, requestHeader.getParcelable(), new BaseAdapterCallBack(this, paramCallBack));
  }
  
  public void updateSessionId(String paramString) {
    if (TextUtils.isEmpty(this.sessionId))
      this.sessionId = paramString; 
  }
  
  static class BaseAdapterCallBack implements BaseAdapter.BaseCallBack {
    private final AnyClient.CallBack callback;
    
    private final WeakReference<HmsClient> hmsClient;
    
    BaseAdapterCallBack(HmsClient param1HmsClient, AnyClient.CallBack param1CallBack) {
      this.callback = param1CallBack;
      this.hmsClient = new WeakReference<HmsClient>(param1HmsClient);
    }
    
    private void doCallback(String param1String1, String param1String2) {
      ResponseHeader responseHeader = new ResponseHeader();
      if (responseHeader.fromJson(param1String1)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("receive msg ");
        stringBuilder.append(responseHeader);
        HMSLog.i("HmsClient", stringBuilder.toString());
        updateSessionId(responseHeader.getSessionId());
        this.callback.onCallback(responseHeader, param1String2);
        return;
      } 
      this.callback.onCallback(new ResponseHeader(1, 907135000, "response header json error"), (new JSONObject()).toString());
    }
    
    private void doCallback(String param1String1, String param1String2, Parcelable param1Parcelable) {
      ResponseHeader responseHeader = new ResponseHeader();
      if (responseHeader.fromJson(param1String1)) {
        responseHeader.setParcelable(param1Parcelable);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("receive msg ");
        stringBuilder.append(responseHeader);
        HMSLog.i("HmsClient", stringBuilder.toString());
        updateSessionId(responseHeader.getSessionId());
        this.callback.onCallback(responseHeader, param1String2);
        return;
      } 
      this.callback.onCallback(new ResponseHeader(1, 907135000, "response header json error"), (new JSONObject()).toString());
    }
    
    private void updateSessionId(String param1String) {
      HmsClient hmsClient = this.hmsClient.get();
      if (hmsClient != null)
        hmsClient.updateSessionId(param1String); 
    }
    
    public void onComplete(String param1String1, String param1String2, Parcelable param1Parcelable) {
      if (param1Parcelable == null) {
        doCallback(param1String1, param1String2);
        return;
      } 
      doCallback(param1String1, param1String2, param1Parcelable);
    }
    
    public void onError(String param1String) {
      ResponseHeader responseHeader = new ResponseHeader();
      if (responseHeader.fromJson(param1String)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("receive msg ");
        stringBuilder.append(responseHeader);
        HMSLog.i("HmsClient", stringBuilder.toString());
        updateSessionId(responseHeader.getSessionId());
        this.callback.onCallback(responseHeader, (new JSONObject()).toString());
        return;
      } 
      this.callback.onCallback(new ResponseHeader(1, 907135000, "response header json error"), (new JSONObject()).toString());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\HmsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */