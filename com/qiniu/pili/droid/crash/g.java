package com.qiniu.pili.droid.crash;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.Callable;

public class g implements Callable<Integer> {
  private File a;
  
  g(File paramFile) {
    this.a = paramFile;
  }
  
  public Integer a() throws Exception {
    try {
      HttpURLConnection httpURLConnection = (HttpURLConnection)(new URL("https://sdk-dau.cn-shanghai.log.aliyuncs.com/logstores/crash/track")).openConnection();
      httpURLConnection.setDoOutput(true);
      httpURLConnection.setRequestMethod("POST");
      httpURLConnection.setRequestProperty("x-log-apiversion", "0.6.0");
      httpURLConnection.setRequestProperty("x-log-bodyrawsize", "1234");
      BufferedReader bufferedReader = new BufferedReader(new FileReader(this.a));
      StringBuilder stringBuilder = new StringBuilder();
      while (true) {
        String str2 = bufferedReader.readLine();
        if (str2 != null) {
          stringBuilder.append(str2);
          continue;
        } 
        bufferedReader.close();
        String str1 = stringBuilder.toString();
        PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(httpURLConnection.getOutputStream()));
        printWriter.write(str1);
        printWriter.flush();
        printWriter.close();
        int i = httpURLConnection.getResponseCode();
        httpURLConnection.disconnect();
        return Integer.valueOf(i);
      } 
    } catch (UnknownHostException unknownHostException) {
      return Integer.valueOf(500);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\crash\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */