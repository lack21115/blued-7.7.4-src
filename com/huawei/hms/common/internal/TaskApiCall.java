package com.huawei.hms.common.internal;

import android.os.Parcelable;
import com.huawei.hmf.tasks.CancellationToken;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.support.log.HMSLog;

public abstract class TaskApiCall<ClientT extends AnyClient, ResultT> {
  private static final String TAG = "TaskApiCall";
  
  private int apiLevel = 1;
  
  private final String mRequestJson;
  
  private final String mUri;
  
  private Parcelable parcelable;
  
  private CancellationToken token;
  
  private String transactionId;
  
  @Deprecated
  public TaskApiCall(String paramString1, String paramString2) {
    this.mUri = paramString1;
    this.mRequestJson = paramString2;
    this.parcelable = null;
    this.transactionId = null;
  }
  
  public TaskApiCall(String paramString1, String paramString2, String paramString3) {
    this.mUri = paramString1;
    this.mRequestJson = paramString2;
    this.parcelable = null;
    this.transactionId = paramString3;
  }
  
  public TaskApiCall(String paramString1, String paramString2, String paramString3, int paramInt) {
    this.mUri = paramString1;
    this.mRequestJson = paramString2;
    this.parcelable = null;
    this.transactionId = paramString3;
    this.apiLevel = paramInt;
  }
  
  protected abstract void doExecute(ClientT paramClientT, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<ResultT> paramTaskCompletionSource);
  
  public int getApiLevel() {
    return this.apiLevel;
  }
  
  @Deprecated
  public int getMinApkVersion() {
    return 30000000;
  }
  
  public Parcelable getParcelable() {
    return this.parcelable;
  }
  
  public String getRequestJson() {
    return this.mRequestJson;
  }
  
  public CancellationToken getToken() {
    return this.token;
  }
  
  public String getTransactionId() {
    return this.transactionId;
  }
  
  public String getUri() {
    return this.mUri;
  }
  
  public final void onResponse(ClientT paramClientT, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<ResultT> paramTaskCompletionSource) {
    StringBuilder stringBuilder;
    CancellationToken cancellationToken = this.token;
    if (cancellationToken != null && cancellationToken.a()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("This Task has been canceled, uri:");
      stringBuilder.append(this.mUri);
      stringBuilder.append(", transactionId:");
      stringBuilder.append(this.transactionId);
      HMSLog.i("TaskApiCall", stringBuilder.toString());
      return;
    } 
    doExecute((ClientT)stringBuilder, paramResponseErrorCode, paramString, paramTaskCompletionSource);
  }
  
  public void setApiLevel(int paramInt) {
    this.apiLevel = paramInt;
  }
  
  public void setParcelable(Parcelable paramParcelable) {
    this.parcelable = paramParcelable;
  }
  
  public void setToken(CancellationToken paramCancellationToken) {
    this.token = paramCancellationToken;
  }
  
  public void setTransactionId(String paramString) {
    this.transactionId = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\TaskApiCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */