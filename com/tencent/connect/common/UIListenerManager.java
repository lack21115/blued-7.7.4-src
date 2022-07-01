package com.tencent.connect.common;

import android.content.Intent;
import com.tencent.open.a.f;
import com.tencent.open.utils.SystemUtils;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class UIListenerManager {
  private static final String TAG = "openSDK_LOG.UIListenerManager";
  
  private static UIListenerManager mInstance;
  
  private Map<String, ApiTask> mListenerMap = Collections.synchronizedMap(new HashMap<String, ApiTask>());
  
  private UIListenerManager() {
    if (this.mListenerMap == null)
      this.mListenerMap = Collections.synchronizedMap(new HashMap<String, ApiTask>()); 
  }
  
  private IUiListener buildListener(int paramInt, IUiListener paramIUiListener) {
    if (paramInt == 11101) {
      f.e("openSDK_LOG.UIListenerManager", "登录的接口回调不能重新构建，暂时无法提供，先记录下来这种情况是否存在");
      return paramIUiListener;
    } 
    if (paramInt == 11105) {
      f.e("openSDK_LOG.UIListenerManager", "Social Api 的接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
      return paramIUiListener;
    } 
    if (paramInt == 11106)
      f.e("openSDK_LOG.UIListenerManager", "Social Api 的H5接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在"); 
    return paramIUiListener;
  }
  
  public static UIListenerManager getInstance() {
    if (mInstance == null)
      mInstance = new UIListenerManager(); 
    return mInstance;
  }
  
  public IUiListener getListnerWithAction(String paramString) {
    if (paramString == null) {
      f.e("openSDK_LOG.UIListenerManager", "getListnerWithAction action is null!");
      return null;
    } 
    synchronized (this.mListenerMap) {
      ApiTask apiTask = this.mListenerMap.get(paramString);
      this.mListenerMap.remove(paramString);
      return (apiTask == null) ? null : apiTask.mListener;
    } 
  }
  
  public IUiListener getListnerWithRequestCode(int paramInt) {
    StringBuilder stringBuilder;
    String str = SystemUtils.getActionFromRequestcode(paramInt);
    if (str == null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("getListner action is null! rquestCode=");
      stringBuilder.append(paramInt);
      f.e("openSDK_LOG.UIListenerManager", stringBuilder.toString());
      return null;
    } 
    return getListnerWithAction((String)stringBuilder);
  }
  
  public void handleDataToListener(Intent paramIntent, IUiListener paramIUiListener) {
    String str1;
    StringBuilder stringBuilder;
    f.c("openSDK_LOG.UIListenerManager", "handleDataToListener");
    if (paramIntent == null) {
      paramIUiListener.onCancel();
      return;
    } 
    String str2 = paramIntent.getStringExtra("key_action");
    if ("action_login".equals(str2)) {
      int i = paramIntent.getIntExtra("key_error_code", 0);
      if (i == 0) {
        str1 = paramIntent.getStringExtra("key_response");
        if (str1 != null)
          try {
            paramIUiListener.onComplete(Util.parseJson(str1));
            return;
          } catch (JSONException jSONException) {
            paramIUiListener.onError(new UiError(-4, "服务器返回数据格式有误!", str1));
            f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", (Throwable)jSONException);
            return;
          }  
        f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
        paramIUiListener.onComplete(new JSONObject());
        return;
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("OpenUi, onActivityResult, onError = ");
      stringBuilder.append(i);
      stringBuilder.append("");
      f.e("openSDK_LOG.UIListenerManager", stringBuilder.toString());
      paramIUiListener.onError(new UiError(i, str1.getStringExtra("key_error_msg"), str1.getStringExtra("key_error_detail")));
      return;
    } 
    if ("action_share".equals(stringBuilder)) {
      String str4 = str1.getStringExtra("result");
      String str3 = str1.getStringExtra("response");
      if ("cancel".equals(str4)) {
        paramIUiListener.onCancel();
        return;
      } 
      if ("error".equals(str4)) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str3);
        stringBuilder1.append("");
        paramIUiListener.onError(new UiError(-6, "unknown error", stringBuilder1.toString()));
        return;
      } 
      if ("complete".equals(str4)) {
        if (str3 == null) {
          str1 = "{\"ret\": 0}";
        } else {
          str1 = str3;
        } 
        try {
          paramIUiListener.onComplete(new JSONObject(str1));
          return;
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str3);
          stringBuilder1.append("");
          paramIUiListener.onError(new UiError(-4, "json error", stringBuilder1.toString()));
        } 
      } 
    } 
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent, IUiListener paramIUiListener) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onActivityResult req=");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" res=");
    stringBuilder.append(paramInt2);
    f.c("openSDK_LOG.UIListenerManager", stringBuilder.toString());
    IUiListener iUiListener2 = getListnerWithRequestCode(paramInt1);
    IUiListener iUiListener1 = iUiListener2;
    if (iUiListener2 == null)
      if (paramIUiListener != null) {
        iUiListener1 = buildListener(paramInt1, paramIUiListener);
      } else {
        f.e("openSDK_LOG.UIListenerManager", "onActivityResult can't find the listener");
        return false;
      }  
    if (paramInt2 == -1) {
      String str1;
      StringBuilder stringBuilder1;
      StringBuilder stringBuilder2;
      if (paramIntent == null) {
        iUiListener1.onError(new UiError(-6, "onActivityResult intent data is null.", "onActivityResult intent data is null."));
        return true;
      } 
      String str2 = paramIntent.getStringExtra("key_action");
      if ("action_login".equals(str2)) {
        paramInt1 = paramIntent.getIntExtra("key_error_code", 0);
        if (paramInt1 == 0) {
          str1 = paramIntent.getStringExtra("key_response");
          if (str1 != null)
            try {
              iUiListener1.onComplete(Util.parseJson(str1));
              return true;
            } catch (JSONException jSONException) {
              iUiListener1.onError(new UiError(-4, "服务器返回数据格式有误!", str1));
              f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", (Throwable)jSONException);
              return true;
            }  
          f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
          iUiListener1.onComplete(new JSONObject());
          return true;
        } 
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("OpenUi, onActivityResult, onError = ");
        stringBuilder2.append(paramInt1);
        stringBuilder2.append("");
        f.e("openSDK_LOG.UIListenerManager", stringBuilder2.toString());
        iUiListener1.onError(new UiError(paramInt1, str1.getStringExtra("key_error_msg"), str1.getStringExtra("key_error_detail")));
        return true;
      } 
      if ("action_share".equals(stringBuilder2)) {
        String str4 = str1.getStringExtra("result");
        String str3 = str1.getStringExtra("response");
        if ("cancel".equals(str4)) {
          iUiListener1.onCancel();
          return true;
        } 
        if ("error".equals(str4)) {
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(str3);
          stringBuilder1.append("");
          iUiListener1.onError(new UiError(-6, "unknown error", stringBuilder1.toString()));
          return true;
        } 
        if ("complete".equals(str4)) {
          if (str3 == null) {
            str1 = "{\"ret\": 0}";
          } else {
            str1 = str3;
          } 
          try {
            iUiListener1.onComplete(new JSONObject(str1));
            return true;
          } catch (JSONException jSONException) {
            jSONException.printStackTrace();
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append(str3);
            stringBuilder1.append("");
            iUiListener1.onError(new UiError(-4, "json error", stringBuilder1.toString()));
            return true;
          } 
        } 
      } else {
        String str;
        paramInt1 = stringBuilder1.getIntExtra("key_error_code", 0);
        if (paramInt1 == 0) {
          str = stringBuilder1.getStringExtra("key_response");
          if (str != null)
            try {
              iUiListener1.onComplete(Util.parseJson(str));
              return true;
            } catch (JSONException jSONException) {
              iUiListener1.onError(new UiError(-4, "服务器返回数据格式有误!", str));
              return true;
            }  
          iUiListener1.onComplete(new JSONObject());
          return true;
        } 
        iUiListener1.onError(new UiError(paramInt1, str.getStringExtra("key_error_msg"), str.getStringExtra("key_error_detail")));
        return true;
      } 
    } else {
      iUiListener1.onCancel();
    } 
    return true;
  }
  
  public Object setListenerWithRequestcode(int paramInt, IUiListener paramIUiListener) {
    String str = SystemUtils.getActionFromRequestcode(paramInt);
    if (str == null) {
      null = new StringBuilder();
      null.append("setListener action is null! rquestCode=");
      null.append(paramInt);
      f.e("openSDK_LOG.UIListenerManager", null.toString());
      return null;
    } 
    synchronized (this.mListenerMap) {
      ApiTask apiTask = this.mListenerMap.put(str, new ApiTask(paramInt, (IUiListener)null));
      return (apiTask == null) ? null : apiTask.mListener;
    } 
  }
  
  public Object setListnerWithAction(String paramString, IUiListener paramIUiListener) {
    StringBuilder stringBuilder;
    int i = SystemUtils.getRequestCodeFromCallback(paramString);
    if (i == -1) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("setListnerWithAction fail, action = ");
      stringBuilder.append(paramString);
      f.e("openSDK_LOG.UIListenerManager", stringBuilder.toString());
      return null;
    } 
    synchronized (this.mListenerMap) {
      ApiTask apiTask = this.mListenerMap.put(paramString, new ApiTask(i, (IUiListener)stringBuilder));
      return (apiTask == null) ? null : apiTask.mListener;
    } 
  }
  
  public class ApiTask {
    public IUiListener mListener;
    
    public int mRequestCode;
    
    public ApiTask(int param1Int, IUiListener param1IUiListener) {
      this.mRequestCode = param1Int;
      this.mListener = param1IUiListener;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\connect\common\UIListenerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */