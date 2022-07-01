package com.sina.weibo.sdk.net;

import android.content.Context;
import android.os.AsyncTask;
import com.sina.weibo.sdk.cmd.WbAppActivator;
import com.sina.weibo.sdk.exception.WeiboException;

public class AsyncWeiboRunner {
  private Context mContext;
  
  public AsyncWeiboRunner(Context paramContext) {
    this.mContext = paramContext;
  }
  
  public String request(String paramString1, WeiboParameters paramWeiboParameters, String paramString2) throws WeiboException {
    WbAppActivator.getInstance(this.mContext, paramWeiboParameters.getAppKey()).activateApp();
    return HttpManager.openUrl(this.mContext, paramString1, paramString2, paramWeiboParameters);
  }
  
  public void requestAsync(String paramString1, WeiboParameters paramWeiboParameters, String paramString2, RequestListener paramRequestListener) {
    WbAppActivator.getInstance(this.mContext, paramWeiboParameters.getAppKey()).activateApp();
    (new RequestRunner(this.mContext, paramString1, paramWeiboParameters, paramString2, paramRequestListener)).execute((Object[])new Void[1]);
  }
  
  @Deprecated
  public void requestByThread(final String url, final WeiboParameters params, final String httpMethod, final RequestListener listener) {
    (new Thread() {
        public void run() {
          try {
            String str = HttpManager.openUrl(AsyncWeiboRunner.this.mContext, url, httpMethod, params);
            if (listener != null) {
              listener.onComplete(str);
              return;
            } 
          } catch (WeiboException weiboException) {
            RequestListener requestListener = listener;
            if (requestListener != null)
              requestListener.onWeiboException(weiboException); 
          } 
        }
      }).start();
  }
  
  static class AsyncTaskResult<T> {
    private WeiboException error;
    
    private T result;
    
    public AsyncTaskResult(WeiboException param1WeiboException) {
      this.error = param1WeiboException;
    }
    
    public AsyncTaskResult(T param1T) {
      this.result = param1T;
    }
    
    public WeiboException getError() {
      return this.error;
    }
    
    public T getResult() {
      return this.result;
    }
  }
  
  static class RequestRunner extends AsyncTask<Void, Void, AsyncTaskResult<String>> {
    private final Context mContext;
    
    private final String mHttpMethod;
    
    private final RequestListener mListener;
    
    private final WeiboParameters mParams;
    
    private final String mUrl;
    
    public RequestRunner(Context param1Context, String param1String1, WeiboParameters param1WeiboParameters, String param1String2, RequestListener param1RequestListener) {
      this.mContext = param1Context;
      this.mUrl = param1String1;
      this.mParams = param1WeiboParameters;
      this.mHttpMethod = param1String2;
      this.mListener = param1RequestListener;
    }
    
    protected AsyncWeiboRunner.AsyncTaskResult<String> doInBackground(Void... param1VarArgs) {
      try {
        return new AsyncWeiboRunner.AsyncTaskResult<String>(HttpManager.openUrl(this.mContext, this.mUrl, this.mHttpMethod, this.mParams));
      } catch (WeiboException weiboException) {
        return new AsyncWeiboRunner.AsyncTaskResult<String>(weiboException);
      } 
    }
    
    protected void onPostExecute(AsyncWeiboRunner.AsyncTaskResult<String> param1AsyncTaskResult) {
      WeiboException weiboException = param1AsyncTaskResult.getError();
      if (weiboException != null) {
        this.mListener.onWeiboException(weiboException);
        return;
      } 
      this.mListener.onComplete(param1AsyncTaskResult.getResult());
    }
    
    protected void onPreExecute() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\net\AsyncWeiboRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */