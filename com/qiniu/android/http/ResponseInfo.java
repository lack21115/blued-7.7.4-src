package com.qiniu.android.http;

import android.os.Process;
import com.qiniu.android.collect.Config;
import com.qiniu.android.collect.LogHandler;
import com.qiniu.android.collect.UploadInfoCollector;
import com.qiniu.android.collect.UploadInfoElement;
import com.qiniu.android.collect.UploadInfoElementCollector;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.utils.Json;
import com.qiniu.android.utils.StringUtils;
import java.net.InetAddress;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public final class ResponseInfo {
  public static final int Cancelled = -2;
  
  public static final int CannotConnectToHost = -1004;
  
  public static final int Crc32NotMatch = -406;
  
  public static final int InvalidArgument = -4;
  
  public static final int InvalidFile = -3;
  
  public static final int InvalidToken = -5;
  
  public static final int NetworkConnectionLost = -1005;
  
  public static final int NetworkError = -1;
  
  public static final int TimedOut = -1001;
  
  public static final int UnknownError = 0;
  
  public static final int UnknownHost = -1003;
  
  public static final int ZeroSizeFile = -6;
  
  public static long bytes_sent;
  
  public static long requests_count;
  
  public final long duration;
  
  public final String error;
  
  public final String host;
  
  public final String id;
  
  public final String ip;
  
  public final String path;
  
  public final int port;
  
  public final String reqId;
  
  public final JSONObject response;
  
  public final long sent;
  
  public final int statusCode;
  
  public final long timeStamp;
  
  public final long totalSize;
  
  public final UpToken upToken;
  
  public String xClientId;
  
  public final String xlog;
  
  public final String xvia;
  
  private ResponseInfo(JSONObject paramJSONObject, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt2, long paramLong1, long paramLong2, String paramString8, UpToken paramUpToken, long paramLong3) {
    this.response = paramJSONObject;
    this.statusCode = paramInt1;
    this.xClientId = paramString1;
    this.reqId = paramString2;
    this.xlog = paramString3;
    this.xvia = paramString4;
    this.host = paramString5;
    this.path = paramString6;
    this.duration = paramLong1;
    this.error = paramString8;
    this.ip = paramString7;
    this.port = paramInt2;
    this.id = (UserAgent.instance()).id;
    this.timeStamp = System.currentTimeMillis() / 1000L;
    this.sent = paramLong2;
    this.upToken = paramUpToken;
    this.totalSize = paramLong3;
  }
  
  public static ResponseInfo cancelled(UpToken paramUpToken) {
    return create(null, null, -2, "", "", "", "", "", "", 80, -1L, -1L, "cancelled by user", paramUpToken, 0L);
  }
  
  public static ResponseInfo create(final LogHandler logHandler, JSONObject paramJSONObject, final int statusCode, final String reqId, String paramString2, String paramString3, final String host, String paramString5, final String ip, final int port, long paramLong1, final long sent, final String error, final UpToken upToken, long paramLong3) {
    bytes_sent += sent;
    requests_count++;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(ip);
    stringBuilder.append("");
    ip = stringBuilder.toString().split(":")[0];
    ip = ip.substring(Math.max(0, ip.indexOf("/") + 1));
    ResponseInfo responseInfo = new ResponseInfo(paramJSONObject, statusCode, UploadInfoElement.x_log_client_id, reqId, paramString2, paramString3, host, paramString5, ip, port, paramLong1, sent, error, upToken, paramLong3);
    if (Config.isRecord) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(responseInfo.timeStamp);
      stringBuilder1.append("");
      stringBuilder1.toString();
      UploadInfoCollector.handleHttp(upToken, new UploadInfoCollector.RecordMsg() {
            public String toRecordMsg() {
              logHandler.send("pid", Long.valueOf(Process.myPid()));
              LogHandler logHandler = logHandler;
              if (logHandler == null)
                return ""; 
              logHandler.send("status_code", Integer.valueOf(statusCode));
              logHandler.send("req_id", reqId);
              logHandler.send("host", host);
              logHandler.send("remote_ip", ip);
              logHandler.send("port", Integer.valueOf(port));
              if (upToken.token != "" && upToken.token != null)
                logHandler.send("target_bucket", StringUtils.getBucket(upToken.token)); 
              logHandler.send("bytes_sent", Long.valueOf(sent));
              List<InetAddress> list = DnsPrefetcher.getDnsPrefetcher().getInetAddressByHost(host);
              if (list != null)
                logHandler.send("prefetched_ip_count", Long.valueOf(list.size())); 
              String str = error;
              if (str != null) {
                logHandler.send("error_type", UploadInfoElement.errorType(statusCode, str));
                logHandler.send("error_description", error);
              } 
              UploadInfoElement.ReqInfo reqInfo = (UploadInfoElement.ReqInfo)logHandler.getUploadInfo();
              UploadInfoElementCollector.setReqCommonElements(reqInfo);
              return Json.object2Json(reqInfo);
            }
          });
      return responseInfo;
    } 
    return responseInfo;
  }
  
  public static ResponseInfo errorInfo(ResponseInfo paramResponseInfo, int paramInt, String paramString) {
    return new ResponseInfo(paramResponseInfo.response, paramInt, UploadInfoElement.x_log_client_id, paramResponseInfo.reqId, paramResponseInfo.xlog, paramResponseInfo.xvia, paramResponseInfo.host, paramResponseInfo.path, paramResponseInfo.ip, paramResponseInfo.port, paramResponseInfo.duration, paramResponseInfo.sent, paramString, paramResponseInfo.upToken, paramResponseInfo.totalSize);
  }
  
  public static ResponseInfo fileError(Exception paramException, UpToken paramUpToken) {
    return create(null, null, -3, "", "", "", "", "", "", 80, 0L, 0L, paramException.getMessage(), paramUpToken, 0L);
  }
  
  private static String getUpType(String paramString) {
    if (paramString != null) {
      if (!paramString.startsWith("/"))
        return ""; 
      if ("/".equals(paramString))
        return "form"; 
      int i = paramString.indexOf('/', 1);
      if (i < 1)
        return ""; 
      paramString = paramString.substring(1, i);
      switch (paramString.hashCode()) {
        default:
          i = -1;
          break;
        case 103949059:
          if (paramString.equals("mkblk")) {
            i = 0;
            break;
          } 
        case 3030893:
          if (paramString.equals("bput")) {
            i = 1;
            break;
          } 
        case 111375:
          if (paramString.equals("put")) {
            i = 3;
            break;
          } 
        case -1072430054:
          if (paramString.equals("mkfile")) {
            i = 2;
            break;
          } 
      } 
      return (i != 0) ? ((i != 1) ? ((i != 2) ? ((i != 3) ? "" : "put") : "mkfile") : "bput") : "mkblk";
    } 
    return "";
  }
  
  public static ResponseInfo invalidArgument(String paramString, UpToken paramUpToken) {
    return create(null, null, -4, "", "", "", "", "", "", 80, 0L, 0L, paramString, paramUpToken, 0L);
  }
  
  public static ResponseInfo invalidToken(String paramString) {
    return create(null, null, -5, "", "", "", "", "", "", 80, 0L, 0L, paramString, null, 0L);
  }
  
  public static boolean isStatusCodeForBrokenNetwork(int paramInt) {
    return (paramInt == -1 || paramInt == -1003 || paramInt == -1004 || paramInt == -1001 || paramInt == -1005);
  }
  
  public static ResponseInfo networkError(int paramInt, UpToken paramUpToken) {
    return create(null, null, paramInt, "", "", "", "", "", "", 80, 0L, 0L, "Network error during preQuery, Please check your network or use http try again", paramUpToken, 0L);
  }
  
  public static ResponseInfo zeroSize(UpToken paramUpToken) {
    return create(null, null, -6, "", "", "", "", "", "", 80, 0L, 0L, "file or data size is zero", paramUpToken, 0L);
  }
  
  public boolean hasReqId() {
    return (this.reqId != null);
  }
  
  public boolean isCancelled() {
    return (this.statusCode == -2);
  }
  
  public boolean isNetworkBroken() {
    int i = this.statusCode;
    return (i == -1 || i == -1003 || i == -1004 || i == -1001 || i == -1005);
  }
  
  public boolean isNotQiniu() {
    int i = this.statusCode;
    return (i < 500 && i >= 200 && !hasReqId() && this.response == null);
  }
  
  public boolean isOK() {
    return (this.statusCode == 200 && this.error == null && (hasReqId() || this.response != null));
  }
  
  public boolean isServerError() {
    int i = this.statusCode;
    return ((i >= 500 && i < 600 && i != 579) || this.statusCode == 996);
  }
  
  public boolean needRetry() {
    if (!isCancelled())
      if (!needSwitchServer()) {
        int i = this.statusCode;
        if (i == 406 || (i == 200 && this.error != null) || (isNotQiniu() && !this.upToken.hasReturnUrl()))
          return true; 
      } else {
        return true;
      }  
    return false;
  }
  
  public boolean needSwitchServer() {
    return (isNetworkBroken() || isServerError());
  }
  
  public String toString() {
    return String.format(Locale.ENGLISH, "{ver:%s,ResponseInfo:%s,status:%d, xClientId:%s, reqId:%s, xlog:%s, xvia:%s, host:%s, path:%s, ip:%s, port:%d, duration:%d s, time:%d, sent:%d,error:%s}", new Object[] { 
          "7.4.6", this.id, Integer.valueOf(this.statusCode), this.xClientId, this.reqId, this.xlog, this.xvia, this.host, this.path, this.ip, 
          Integer.valueOf(this.port), Long.valueOf(this.duration), Long.valueOf(this.timeStamp), Long.valueOf(this.sent), this.error });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\http\ResponseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */