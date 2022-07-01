package com.ss.android.downloadlib.e;

import android.os.AsyncTask;

public class b {
  static final a a = new b();
  
  public static <T> void a(AsyncTask<T, ?, ?> paramAsyncTask, T... paramVarArgs) {
    a.a(paramAsyncTask, paramVarArgs);
  }
  
  static class a {
    private a() {}
    
    public <T> void a(AsyncTask<T, ?, ?> param1AsyncTask, T... param1VarArgs) {
      try {
        return;
      } finally {
        param1AsyncTask = null;
      } 
    }
  }
  
  static class b extends a {
    private b() {}
    
    public <T> void a(AsyncTask<T, ?, ?> param1AsyncTask, T... param1VarArgs) {
      try {
        return;
      } finally {
        param1AsyncTask = null;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */