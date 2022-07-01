package com.qiniu.android.bigdata.pipeline;

import com.qiniu.android.bigdata.Configuration;
import com.qiniu.android.http.Client;
import com.qiniu.android.http.CompletionHandler;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.utils.StringMap;
import com.qiniu.android.utils.StringUtils;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class Pipeline {
  private static final String HTTPHeaderAuthorization = "Authorization";
  
  private static final String TEXT_PLAIN = "text/plain";
  
  private final Client client;
  
  private final Configuration config;
  
  public Pipeline(Configuration paramConfiguration) {
    this.config = Configuration.copy(paramConfiguration);
    this.client = new Client(this.config.proxy, this.config.connectTimeout, this.config.responseTimeout, null, null);
  }
  
  private void send(String paramString1, StringBuilder paramStringBuilder, String paramString2, final PumpCompleteHandler handler) {
    if (handler != null) {
      if (!StringUtils.isBlank(paramString2)) {
        if (!StringUtils.isBlank(paramString1)) {
          byte[] arrayOfByte = paramStringBuilder.toString().getBytes();
          StringMap stringMap = new StringMap();
          stringMap.put("Authorization", paramString2);
          stringMap.put("Content-Type", "text/plain");
          this.client.asyncPost(null, url(paramString1), arrayOfByte, stringMap, null, arrayOfByte.length, null, new CompletionHandler() {
                public void complete(ResponseInfo param1ResponseInfo, JSONObject param1JSONObject) {
                  handler.complete(param1ResponseInfo);
                }
              },  null);
          return;
        } 
        throw new IllegalArgumentException("no repo");
      } 
      throw new IllegalArgumentException("no token");
    } 
    throw new IllegalArgumentException("no CompletionHandler");
  }
  
  private String url(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.config.pipelineHost);
    stringBuilder.append("/v2/repos/");
    stringBuilder.append(paramString);
    stringBuilder.append("/data");
    return stringBuilder.toString();
  }
  
  public void pump(String paramString1, Object paramObject, String paramString2, PumpCompleteHandler paramPumpCompleteHandler) {
    StringBuilder stringBuilder = new StringBuilder();
    Points.formatPoint(paramObject, stringBuilder);
    send(paramString1, stringBuilder, paramString2, paramPumpCompleteHandler);
  }
  
  public <V> void pump(String paramString1, Map<String, V> paramMap, String paramString2, PumpCompleteHandler paramPumpCompleteHandler) {
    StringBuilder stringBuilder = new StringBuilder();
    Points.formatPoint(paramMap, stringBuilder);
    send(paramString1, stringBuilder, paramString2, paramPumpCompleteHandler);
  }
  
  public <V> void pumpMulti(String paramString1, List<Map<String, V>> paramList, String paramString2, PumpCompleteHandler paramPumpCompleteHandler) {
    send(paramString1, Points.formatPoints(paramList), paramString2, paramPumpCompleteHandler);
  }
  
  public <V> void pumpMulti(String paramString1, Map<String, V>[] paramArrayOfMap, String paramString2, PumpCompleteHandler paramPumpCompleteHandler) {
    send(paramString1, Points.formatPoints(paramArrayOfMap), paramString2, paramPumpCompleteHandler);
  }
  
  public <V> void pumpMultiObjects(String paramString1, List<V> paramList, String paramString2, PumpCompleteHandler paramPumpCompleteHandler) {
    send(paramString1, Points.formatPointsObjects(paramList), paramString2, paramPumpCompleteHandler);
  }
  
  public void pumpMultiObjects(String paramString1, Object[] paramArrayOfObject, String paramString2, PumpCompleteHandler paramPumpCompleteHandler) {
    send(paramString1, Points.formatPoints(paramArrayOfObject), paramString2, paramPumpCompleteHandler);
  }
  
  public static interface PumpCompleteHandler {
    void complete(ResponseInfo param1ResponseInfo);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\bigdata\pipeline\Pipeline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */