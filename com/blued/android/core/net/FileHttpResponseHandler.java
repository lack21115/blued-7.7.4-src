package com.blued.android.core.net;

import android.text.TextUtils;
import com.blued.android.core.net.http.RequestParams;
import com.blued.android.core.utils.ByteArrayPool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.ResponseBody;

public abstract class FileHttpResponseHandler extends HttpResponseHandler<File> {
  public long getResponseLength(File paramFile) {
    return (paramFile == null) ? 0L : paramFile.length();
  }
  
  public String getResponseType() {
    return "file";
  }
  
  protected File parseResponse(int paramInt, ResponseBody paramResponseBody) throws IOException {
    boolean bool = isCancelled();
    InputStream inputStream = null;
    File file1 = null;
    File file2 = null;
    if (bool) {
      sendCancelMessage("request is cancelled");
      return null;
    } 
    if (this.requestWrapper != null) {
      RequestParams requestParams = this.requestWrapper.c();
      if (requestParams != null) {
        String str = requestParams.a();
      } else {
        requestParams = null;
      } 
      if (!TextUtils.isEmpty((CharSequence)requestParams)) {
        InputStream inputStream1;
        InputStream inputStream2;
        RequestParams requestParams1;
        try {
          File file = new File((String)requestParams);
          file.createNewFile();
          FileOutputStream fileOutputStream1 = new FileOutputStream((String)requestParams);
        } catch (IOException iOException2) {
        
        } finally {
          inputStream = null;
          requestParams = null;
          IOException iOException = iOException2;
        } 
        try {
          throw inputStream2;
        } finally {
          inputStream2 = null;
          requestParams1 = requestParams;
        } 
        ByteArrayPool.a.a((byte[])requestParams1);
        iOException1.close();
        if (inputStream1 != null) {
          try {
            inputStream1.flush();
          } catch (IOException iOException) {
            iOException.printStackTrace();
          } 
          try {
            inputStream1.close();
          } catch (IOException iOException) {
            iOException.printStackTrace();
          } 
        } 
        throw inputStream2;
      } 
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\FileHttpResponseHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */