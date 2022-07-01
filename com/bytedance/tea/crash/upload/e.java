package com.bytedance.tea.crash.upload;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.GZIPOutputStream;

public class e {
  private final String a;
  
  private HttpURLConnection b;
  
  private String c;
  
  private boolean d;
  
  private DataOutputStream e;
  
  private GZIPOutputStream f;
  
  e(String paramString1, String paramString2, boolean paramBoolean) throws IOException {
    this.c = paramString2;
    this.d = paramBoolean;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AAA");
    stringBuilder.append(System.currentTimeMillis());
    stringBuilder.append("AAA");
    this.a = stringBuilder.toString();
    this.b = (HttpURLConnection)(new URL(paramString1)).openConnection();
    this.b.setUseCaches(false);
    this.b.setDoOutput(true);
    this.b.setDoInput(true);
    this.b.setRequestMethod("POST");
    HttpURLConnection httpURLConnection = this.b;
    stringBuilder = new StringBuilder();
    stringBuilder.append("multipart/form-data; boundary=");
    stringBuilder.append(this.a);
    httpURLConnection.setRequestProperty("Content-Type", stringBuilder.toString());
    if (paramBoolean) {
      this.b.setRequestProperty("Content-Encoding", "gzip");
      this.f = new GZIPOutputStream(this.b.getOutputStream());
      return;
    } 
    this.e = new DataOutputStream(this.b.getOutputStream());
  }
  
  public String a() throws IOException {
    ArrayList<String> arrayList = new ArrayList();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("\r\n--");
    stringBuilder2.append(this.a);
    stringBuilder2.append("--");
    stringBuilder2.append("\r\n");
    byte[] arrayOfByte = stringBuilder2.toString().getBytes();
    if (this.d) {
      this.f.write(arrayOfByte);
      this.f.finish();
      this.f.close();
    } else {
      this.e.write(arrayOfByte);
      this.e.flush();
      this.e.close();
    } 
    int i = this.b.getResponseCode();
    if (i == 200) {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.b.getInputStream()));
      while (true) {
        String str = bufferedReader.readLine();
        if (str != null) {
          arrayList.add(str);
          continue;
        } 
        bufferedReader.close();
        this.b.disconnect();
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext())
          stringBuilder.append(iterator.next()); 
        return stringBuilder.toString();
      } 
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("Server returned non-OK status: ");
    stringBuilder1.append(i);
    throw new IOException(stringBuilder1.toString());
  }
  
  public void a(String paramString, File paramFile) throws IOException {
    String str = paramFile.getName();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("--");
    stringBuilder.append(this.a);
    stringBuilder.append("\r\n");
    stringBuilder.append("Content-Disposition: form-data; name=\"");
    stringBuilder.append(paramString);
    stringBuilder.append("\"; filename=\"");
    stringBuilder.append(str);
    stringBuilder.append("\"");
    stringBuilder.append("\r\n");
    stringBuilder.append("Content-Transfer-Encoding: binary");
    stringBuilder.append("\r\n");
    stringBuilder.append("\r\n");
    if (this.d) {
      this.f.write(stringBuilder.toString().getBytes());
    } else {
      this.e.write(stringBuilder.toString().getBytes());
    } 
    FileInputStream fileInputStream = new FileInputStream(paramFile);
    byte[] arrayOfByte = new byte[8192];
    while (true) {
      int i = fileInputStream.read(arrayOfByte);
      if (i != -1) {
        if (this.d) {
          this.f.write(arrayOfByte, 0, i);
          continue;
        } 
        this.e.write(arrayOfByte, 0, i);
        continue;
      } 
      fileInputStream.close();
      if (this.d) {
        this.f.write("\r\n".getBytes());
        return;
      } 
      this.e.write(stringBuilder.toString().getBytes());
      this.e.flush();
      return;
    } 
  }
  
  public void a(String paramString1, String paramString2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("--");
    stringBuilder.append(this.a);
    stringBuilder.append("\r\n");
    stringBuilder.append("Content-Disposition: form-data; name=\"");
    stringBuilder.append(paramString1);
    stringBuilder.append("\"");
    stringBuilder.append("\r\n");
    stringBuilder.append("Content-Type: text/plain; charset=");
    stringBuilder.append(this.c);
    stringBuilder.append("\r\n");
    stringBuilder.append("\r\n");
    stringBuilder.append(paramString2);
    stringBuilder.append("\r\n");
    try {
      if (this.d) {
        this.f.write(stringBuilder.toString().getBytes());
        return;
      } 
      this.e.write(stringBuilder.toString().getBytes());
      return;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\tea\cras\\upload\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */