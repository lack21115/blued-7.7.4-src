package com.loopj.android.http;

import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class RequestParams implements Serializable {
  public static final String APPLICATION_JSON = "application/json";
  
  public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
  
  protected static final String LOG_TAG = "RequestParams";
  
  protected boolean autoCloseInputStreams;
  
  protected String contentEncoding = "UTF-8";
  
  protected final ConcurrentHashMap<String, FileWrapper> fileParams = new ConcurrentHashMap<String, FileWrapper>();
  
  protected boolean isRepeatable;
  
  protected final ConcurrentHashMap<String, StreamWrapper> streamParams = new ConcurrentHashMap<String, StreamWrapper>();
  
  protected final ConcurrentHashMap<String, String> urlParams = new ConcurrentHashMap<String, String>();
  
  protected final ConcurrentHashMap<String, Object> urlParamsWithObjects = new ConcurrentHashMap<String, Object>();
  
  protected boolean useJsonStreamer;
  
  public RequestParams() {
    this((Map<String, String>)null);
  }
  
  public RequestParams(String paramString1, String paramString2) {
    this(new HashMap<String, String>(paramString1, paramString2) {
        
        });
  }
  
  public RequestParams(Map<String, String> paramMap) {
    if (paramMap != null)
      for (Map.Entry<String, String> entry : paramMap.entrySet())
        put((String)entry.getKey(), (String)entry.getValue());  
  }
  
  public RequestParams(Object... paramVarArgs) {
    int i = paramVarArgs.length;
    if (i % 2 == 0) {
      for (int j = 0; j < i; j += 2)
        put(String.valueOf(paramVarArgs[j]), String.valueOf(paramVarArgs[j + 1])); 
      return;
    } 
    throw new IllegalArgumentException("Supplied arguments must be even");
  }
  
  private HttpEntity createFormEntity() {
    try {
      return (HttpEntity)new UrlEncodedFormEntity(getParamsList(), this.contentEncoding);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      Log.e("RequestParams", "createFormEntity failed", unsupportedEncodingException);
      return null;
    } 
  }
  
  private HttpEntity createJsonStreamerEntity(ResponseHandlerInterface paramResponseHandlerInterface) throws IOException {
    boolean bool;
    if (!this.fileParams.isEmpty() || !this.streamParams.isEmpty()) {
      bool = true;
    } else {
      bool = false;
    } 
    JsonStreamerEntity jsonStreamerEntity = new JsonStreamerEntity(paramResponseHandlerInterface, bool);
    for (Map.Entry<String, String> entry : this.urlParams.entrySet())
      jsonStreamerEntity.addPart((String)entry.getKey(), entry.getValue()); 
    for (Map.Entry<String, Object> entry : this.urlParamsWithObjects.entrySet())
      jsonStreamerEntity.addPart((String)entry.getKey(), entry.getValue()); 
    for (Map.Entry<String, FileWrapper> entry : this.fileParams.entrySet())
      jsonStreamerEntity.addPart((String)entry.getKey(), entry.getValue()); 
    for (Map.Entry<String, StreamWrapper> entry : this.streamParams.entrySet()) {
      StreamWrapper streamWrapper = (StreamWrapper)entry.getValue();
      if (streamWrapper.inputStream != null)
        jsonStreamerEntity.addPart((String)entry.getKey(), StreamWrapper.newInstance(streamWrapper.inputStream, streamWrapper.name, streamWrapper.contentType, streamWrapper.autoClose)); 
    } 
    return jsonStreamerEntity;
  }
  
  private HttpEntity createMultipartEntity(ResponseHandlerInterface paramResponseHandlerInterface) throws IOException {
    SimpleMultipartEntity simpleMultipartEntity = new SimpleMultipartEntity(paramResponseHandlerInterface);
    simpleMultipartEntity.setIsRepeatable(this.isRepeatable);
    for (Map.Entry<String, String> entry : this.urlParams.entrySet())
      simpleMultipartEntity.addPartWithCharset((String)entry.getKey(), (String)entry.getValue(), this.contentEncoding); 
    for (BasicNameValuePair basicNameValuePair : getParamsList(null, this.urlParamsWithObjects))
      simpleMultipartEntity.addPartWithCharset(basicNameValuePair.getName(), basicNameValuePair.getValue(), this.contentEncoding); 
    for (Map.Entry<String, StreamWrapper> entry : this.streamParams.entrySet()) {
      StreamWrapper streamWrapper = (StreamWrapper)entry.getValue();
      if (streamWrapper.inputStream != null)
        simpleMultipartEntity.addPart((String)entry.getKey(), streamWrapper.name, streamWrapper.inputStream, streamWrapper.contentType); 
    } 
    for (Map.Entry<String, FileWrapper> entry : this.fileParams.entrySet()) {
      FileWrapper fileWrapper = (FileWrapper)entry.getValue();
      simpleMultipartEntity.addPart((String)entry.getKey(), fileWrapper.file, fileWrapper.contentType, fileWrapper.customFileName);
    } 
    return simpleMultipartEntity;
  }
  
  private List<BasicNameValuePair> getParamsList(String paramString, Object paramObject) {
    LinkedList<BasicNameValuePair> linkedList = new LinkedList();
    if (paramObject instanceof Map) {
      Map map = (Map)paramObject;
      paramObject = new ArrayList(map.keySet());
      if (paramObject.size() > 0 && paramObject.get(0) instanceof Comparable)
        Collections.sort((List<Comparable>)paramObject); 
      for (Object paramObject : paramObject) {
        if (paramObject instanceof String) {
          Object object = map.get(paramObject);
          if (object != null) {
            if (paramString == null) {
              paramObject = paramObject;
            } else {
              paramObject = String.format("%s[%s]", new Object[] { paramString, paramObject });
            } 
            linkedList.addAll(getParamsList((String)paramObject, object));
          } 
        } 
      } 
    } else if (paramObject instanceof List) {
      paramObject = paramObject;
      int j = paramObject.size();
      for (int i = 0; i < j; i++) {
        linkedList.addAll(getParamsList(String.format("%s[%d]", new Object[] { paramString, Integer.valueOf(i) }), paramObject.get(i)));
      } 
    } else if (paramObject instanceof Object[]) {
      paramObject = paramObject;
      int j = paramObject.length;
      for (int i = 0; i < j; i++) {
        linkedList.addAll(getParamsList(String.format("%s[%d]", new Object[] { paramString, Integer.valueOf(i) }), paramObject[i]));
      } 
    } else if (paramObject instanceof Set) {
      paramObject = ((Set)paramObject).iterator();
      while (paramObject.hasNext())
        linkedList.addAll(getParamsList(paramString, paramObject.next())); 
    } else {
      linkedList.add(new BasicNameValuePair(paramString, paramObject.toString()));
    } 
    return linkedList;
  }
  
  public void add(String paramString1, String paramString2) {
    if (paramString1 != null && paramString2 != null) {
      Object object2 = this.urlParamsWithObjects.get(paramString1);
      Object object1 = object2;
      if (object2 == null) {
        object1 = new HashSet();
        put(paramString1, object1);
      } 
      if (object1 instanceof List) {
        ((List<String>)object1).add(paramString2);
        return;
      } 
      if (object1 instanceof Set)
        ((Set<String>)object1).add(paramString2); 
    } 
  }
  
  public HttpEntity getEntity(ResponseHandlerInterface paramResponseHandlerInterface) throws IOException {
    return this.useJsonStreamer ? createJsonStreamerEntity(paramResponseHandlerInterface) : ((this.streamParams.isEmpty() && this.fileParams.isEmpty()) ? createFormEntity() : createMultipartEntity(paramResponseHandlerInterface));
  }
  
  protected String getParamString() {
    return URLEncodedUtils.format(getParamsList(), this.contentEncoding);
  }
  
  protected List<BasicNameValuePair> getParamsList() {
    LinkedList<BasicNameValuePair> linkedList = new LinkedList();
    for (Map.Entry<String, String> entry : this.urlParams.entrySet())
      linkedList.add(new BasicNameValuePair((String)entry.getKey(), (String)entry.getValue())); 
    linkedList.addAll(getParamsList(null, this.urlParamsWithObjects));
    return linkedList;
  }
  
  public boolean has(String paramString) {
    return (this.urlParams.get(paramString) != null || this.streamParams.get(paramString) != null || this.fileParams.get(paramString) != null || this.urlParamsWithObjects.get(paramString) != null);
  }
  
  public void put(String paramString, int paramInt) {
    if (paramString != null)
      this.urlParams.put(paramString, String.valueOf(paramInt)); 
  }
  
  public void put(String paramString, long paramLong) {
    if (paramString != null)
      this.urlParams.put(paramString, String.valueOf(paramLong)); 
  }
  
  public void put(String paramString, File paramFile) throws FileNotFoundException {
    put(paramString, paramFile, (String)null, (String)null);
  }
  
  public void put(String paramString1, File paramFile, String paramString2) throws FileNotFoundException {
    put(paramString1, paramFile, paramString2, (String)null);
  }
  
  public void put(String paramString1, File paramFile, String paramString2, String paramString3) throws FileNotFoundException {
    if (paramFile != null && paramFile.exists()) {
      if (paramString1 != null)
        this.fileParams.put(paramString1, new FileWrapper(paramFile, paramString2, paramString3)); 
      return;
    } 
    throw new FileNotFoundException();
  }
  
  public void put(String paramString, InputStream paramInputStream) {
    put(paramString, paramInputStream, (String)null);
  }
  
  public void put(String paramString1, InputStream paramInputStream, String paramString2) {
    put(paramString1, paramInputStream, paramString2, (String)null);
  }
  
  public void put(String paramString1, InputStream paramInputStream, String paramString2, String paramString3) {
    put(paramString1, paramInputStream, paramString2, paramString3, this.autoCloseInputStreams);
  }
  
  public void put(String paramString1, InputStream paramInputStream, String paramString2, String paramString3, boolean paramBoolean) {
    if (paramString1 != null && paramInputStream != null)
      this.streamParams.put(paramString1, StreamWrapper.newInstance(paramInputStream, paramString2, paramString3, paramBoolean)); 
  }
  
  public void put(String paramString, Object paramObject) {
    if (paramString != null && paramObject != null)
      this.urlParamsWithObjects.put(paramString, paramObject); 
  }
  
  public void put(String paramString1, String paramString2) {
    if (paramString1 != null && paramString2 != null)
      this.urlParams.put(paramString1, paramString2); 
  }
  
  public void put(String paramString1, String paramString2, File paramFile) throws FileNotFoundException {
    put(paramString1, paramFile, (String)null, paramString2);
  }
  
  public void remove(String paramString) {
    this.urlParams.remove(paramString);
    this.streamParams.remove(paramString);
    this.fileParams.remove(paramString);
    this.urlParamsWithObjects.remove(paramString);
  }
  
  public void setAutoCloseInputStreams(boolean paramBoolean) {
    this.autoCloseInputStreams = paramBoolean;
  }
  
  public void setContentEncoding(String paramString) {
    if (paramString != null) {
      this.contentEncoding = paramString;
      return;
    } 
    Log.d("RequestParams", "setContentEncoding called with null attribute");
  }
  
  public void setHttpEntityIsRepeatable(boolean paramBoolean) {
    this.isRepeatable = paramBoolean;
  }
  
  public void setUseJsonStreamer(boolean paramBoolean) {
    this.useJsonStreamer = paramBoolean;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry<String, String> entry : this.urlParams.entrySet()) {
      if (stringBuilder.length() > 0)
        stringBuilder.append("&"); 
      stringBuilder.append((String)entry.getKey());
      stringBuilder.append("=");
      stringBuilder.append((String)entry.getValue());
    } 
    for (Map.Entry<String, StreamWrapper> entry : this.streamParams.entrySet()) {
      if (stringBuilder.length() > 0)
        stringBuilder.append("&"); 
      stringBuilder.append((String)entry.getKey());
      stringBuilder.append("=");
      stringBuilder.append("STREAM");
    } 
    for (Map.Entry<String, FileWrapper> entry : this.fileParams.entrySet()) {
      if (stringBuilder.length() > 0)
        stringBuilder.append("&"); 
      stringBuilder.append((String)entry.getKey());
      stringBuilder.append("=");
      stringBuilder.append("FILE");
    } 
    for (BasicNameValuePair basicNameValuePair : getParamsList(null, this.urlParamsWithObjects)) {
      if (stringBuilder.length() > 0)
        stringBuilder.append("&"); 
      stringBuilder.append(basicNameValuePair.getName());
      stringBuilder.append("=");
      stringBuilder.append(basicNameValuePair.getValue());
    } 
    return stringBuilder.toString();
  }
  
  public static class FileWrapper {
    public final String contentType;
    
    public final String customFileName;
    
    public final File file;
    
    public FileWrapper(File param1File, String param1String1, String param1String2) {
      this.file = param1File;
      this.contentType = param1String1;
      this.customFileName = param1String2;
    }
  }
  
  public static class StreamWrapper {
    public final boolean autoClose;
    
    public final String contentType;
    
    public final InputStream inputStream;
    
    public final String name;
    
    public StreamWrapper(InputStream param1InputStream, String param1String1, String param1String2, boolean param1Boolean) {
      this.inputStream = param1InputStream;
      this.name = param1String1;
      this.contentType = param1String2;
      this.autoClose = param1Boolean;
    }
    
    static StreamWrapper newInstance(InputStream param1InputStream, String param1String1, String param1String2, boolean param1Boolean) {
      String str = param1String2;
      if (param1String2 == null)
        str = "application/octet-stream"; 
      return new StreamWrapper(param1InputStream, param1String1, str, param1Boolean);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loopj\android\http\RequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */