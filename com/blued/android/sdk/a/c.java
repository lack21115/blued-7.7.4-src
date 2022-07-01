package com.blued.android.sdk.a;

import android.os.AsyncTask;
import android.util.Log;
import com.blued.android.sdk.BluedSDK;
import com.blued.android.sdk.model.ModelCallback;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class c {
  public static <T> void a(e.a parama, String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2, Type paramType, ModelCallback<T> paramModelCallback) {
    (new AsyncTask(paramString, parama, paramMap1, paramMap2, paramType, paramModelCallback) {
        int a = -1;
        
        String b = "";
        
        T c = null;
        
        protected Object doInBackground(Object[] param1ArrayOfObject) {
          try {
            URL uRL = new URL(this.d);
            if (BluedSDK.DEBUG) {
              String str1 = BluedSDK.TAG;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("start get link:");
              stringBuilder.append(uRL);
              Log.v(str1, stringBuilder.toString());
            } 
            HttpURLConnection httpURLConnection = e.a(this.e, uRL, this.f, this.g);
            int i = httpURLConnection.getResponseCode();
            this.a = i;
            String str = e.a(httpURLConnection);
            boolean bool = BluedSDK.DEBUG;
          } finally {
            param1ArrayOfObject = null;
            param1ArrayOfObject.printStackTrace();
          } 
          return null;
        }
        
        protected void onPostExecute(Object param1Object) {
          super.onPostExecute(param1Object);
          param1Object = this.i;
          if (param1Object != null) {
            T t = this.c;
            if (t != null) {
              param1Object.onModel(t);
              return;
            } 
            param1Object.onFailed(this.a, this.b);
          } 
        }
      }).execute(new Object[0]);
  }
  
  public static <T> void a(String paramString, Map<String, String> paramMap, Type paramType, ModelCallback<T> paramModelCallback) {
    a(e.a.a, paramString, paramMap, null, paramType, paramModelCallback);
  }
  
  public static <T> void a(String paramString, Map<String, String> paramMap1, Map<String, String> paramMap2, Type paramType, ModelCallback<T> paramModelCallback) {
    a(e.a.b, paramString, paramMap1, paramMap2, paramType, paramModelCallback);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\sdk\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */