package com.blued.android.chat.utils;

import android.app.ProgressDialog;
import android.os.AsyncTask;

public class AsyncHelperChat extends AsyncTask<Void, Void, Void> {
  private OnAsyncListener onAsyncListener;
  
  private ProgressDialog progressDialog;
  
  protected Void doInBackground(Void... paramVarArgs) {
    OnAsyncListener onAsyncListener = this.onAsyncListener;
    if (onAsyncListener != null)
      onAsyncListener.onAsyncDoInBackground(); 
    return null;
  }
  
  public ProgressDialog getProgressDialog() {
    return this.progressDialog;
  }
  
  protected void onPostExecute(Void paramVoid) {
    super.onPostExecute(paramVoid);
    OnAsyncListener onAsyncListener = this.onAsyncListener;
    if (onAsyncListener != null)
      onAsyncListener.onAsyncFinish(); 
    ProgressDialog progressDialog = this.progressDialog;
    if (progressDialog != null)
      progressDialog.dismiss(); 
  }
  
  protected void onPreExecute() {
    super.onPreExecute();
    ProgressDialog progressDialog = this.progressDialog;
    if (progressDialog != null)
      progressDialog.show(); 
    OnAsyncListener onAsyncListener = this.onAsyncListener;
    if (onAsyncListener != null)
      onAsyncListener.onAsyncStart(); 
  }
  
  public void setOnAsyncListener(OnAsyncListener paramOnAsyncListener) {
    this.onAsyncListener = paramOnAsyncListener;
  }
  
  public void setProgressDialog(ProgressDialog paramProgressDialog) {
    this.progressDialog = paramProgressDialog;
  }
  
  public static interface OnAsyncListener {
    void onAsyncDoInBackground();
    
    void onAsyncFinish();
    
    void onAsyncStart();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cha\\utils\AsyncHelperChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */