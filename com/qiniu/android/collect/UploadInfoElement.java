package com.qiniu.android.collect;

public class UploadInfoElement {
  public static String x_log_client_id = "";
  
  public static String errorType(int paramInt, String paramString) {
    return (paramInt == 406) ? "checksum_error" : ((200 < paramInt && paramInt < 1000) ? "response_error" : ((paramInt != -1004) ? ((paramInt != -1003) ? ((paramInt != -1001) ? ((paramInt != -2) ? ((paramInt != -1) ? "unknown_error" : ((paramString != null && paramString.indexOf("but received") != -1) ? "file_changed" : "network_error")) : "user_canceled") : "timeout") : "unknown_host") : "cannot_connect_to_host"));
  }
  
  public static String resultCode(int paramInt, String paramString) {
    if (paramInt == 406)
      return "checksum_error"; 
    if (200 < paramInt && paramInt < 1000)
      return "response_error"; 
    null = "zero_size_file";
    if (paramInt != -1001) {
      if (paramInt != -406) {
        if (paramInt != 200) {
          switch (paramInt) {
            default:
              switch (paramInt) {
                default:
                  return "unknown_error";
                case -1:
                  return (paramString != null && paramString.indexOf("but received") != -1) ? "file_changed" : "network_error";
                case -2:
                  return "user_canceled";
                case -3:
                  return "invalid_file";
                case -5:
                  return "invalid_args";
                case -6:
                case -4:
                  break;
              } 
              return null;
            case -1003:
              return "unknown_host";
            case -1004:
              return "cannot_connect_to_host";
            case -1005:
              break;
          } 
          return "network_slow";
        } 
        return "ok";
      } 
      return "crc32_nomatch";
    } 
    return "timeout";
  }
  
  public static class BlockInfo {
    private long bytes_sent;
    
    private String current_region_id;
    
    private long file_size;
    
    private String log_type = "block";
    
    private long pid;
    
    private long recovered_from;
    
    private String target_region_id;
    
    private long tid;
    
    private long total_elapsed_time;
    
    private int up_api_version;
    
    private long up_time;
    
    public long getBytes_sent() {
      return this.bytes_sent;
    }
    
    public String getCurrent_region_id() {
      return this.current_region_id;
    }
    
    public long getFile_size() {
      return this.file_size;
    }
    
    public String getLog_type() {
      return this.log_type;
    }
    
    public long getPid() {
      return this.pid;
    }
    
    public long getRecovered_from() {
      return this.recovered_from;
    }
    
    public String getTarget_region_id() {
      return this.target_region_id;
    }
    
    public long getTid() {
      return this.tid;
    }
    
    public long getTotal_elapsed_time() {
      return this.total_elapsed_time;
    }
    
    public int getUp_api_version() {
      return this.up_api_version;
    }
    
    public long getUp_time() {
      return this.up_time;
    }
    
    public void setBytes_sent(long param1Long) {
      this.bytes_sent = param1Long;
    }
    
    public void setCurrent_region_id(String param1String) {
      this.current_region_id = param1String;
    }
    
    public void setFile_size(long param1Long) {
      this.file_size = param1Long;
    }
    
    public void setLog_type(String param1String) {
      this.log_type = param1String;
    }
    
    public void setPid(long param1Long) {
      this.pid = param1Long;
    }
    
    public void setRecovered_from(long param1Long) {
      this.recovered_from = param1Long;
    }
    
    public void setTarget_region_id(String param1String) {
      this.target_region_id = param1String;
    }
    
    public void setTid(long param1Long) {
      this.tid = param1Long;
    }
    
    public void setTotal_elapsed_time(long param1Long) {
      this.total_elapsed_time = param1Long;
    }
    
    public void setUp_api_version(int param1Int) {
      this.up_api_version = param1Int;
    }
    
    public void setUp_time(long param1Long) {
      this.up_time = param1Long;
    }
  }
  
  public static class ReqInfo {
    private long bytes_sent;
    
    private long bytes_total;
    
    private long connect_elapsed_time;
    
    private String current_region_id;
    
    private long dns_elapsed_time;
    
    private String error_description;
    
    private String error_type;
    
    private long file_offset;
    
    private String host;
    
    public String log_type = "request";
    
    private String network_type;
    
    private String os_name = "android";
    
    private String os_version;
    
    private long pid;
    
    private int port;
    
    private long prefetched_ip_count;
    
    private String remote_ip;
    
    private String req_id;
    
    private long request_elapsed_time;
    
    private long response_elapsed_time;
    
    private String sdk_name;
    
    private String sdk_version;
    
    private long signal_strength;
    
    private int status_code;
    
    private String target_bucket;
    
    private String target_key;
    
    private String target_region_id;
    
    private long tid;
    
    private long tls_connect_elapsed_time;
    
    private long total_elapsed_time;
    
    private long up_time;
    
    private String up_type;
    
    private long wait_elapsed_time;
    
    public long getBytes_sent() {
      return this.bytes_sent;
    }
    
    public long getBytes_total() {
      return this.bytes_total;
    }
    
    public long getConnect_elapsed_time() {
      return this.connect_elapsed_time;
    }
    
    public String getCurrent_region_id() {
      return this.current_region_id;
    }
    
    public long getDns_elapsed_time() {
      return this.dns_elapsed_time;
    }
    
    public String getError_description() {
      return this.error_description;
    }
    
    public String getError_type() {
      return this.error_type;
    }
    
    public long getFile_offset() {
      return this.file_offset;
    }
    
    public String getHost() {
      return this.host;
    }
    
    public String getLog_type() {
      return this.log_type;
    }
    
    public String getNetwork_type() {
      return this.network_type;
    }
    
    public String getOs_name() {
      return this.os_name;
    }
    
    public String getOs_version() {
      return this.os_version;
    }
    
    public long getPid() {
      return this.pid;
    }
    
    public int getPort() {
      return this.port;
    }
    
    public long getPrefetched_ip_count() {
      return this.prefetched_ip_count;
    }
    
    public String getRemote_ip() {
      return this.remote_ip;
    }
    
    public String getReq_id() {
      return this.req_id;
    }
    
    public long getRequest_elapsed_time() {
      return this.request_elapsed_time;
    }
    
    public long getResponse_elapsed_time() {
      return this.response_elapsed_time;
    }
    
    public String getSdk_name() {
      return this.sdk_name;
    }
    
    public String getSdk_version() {
      return this.sdk_version;
    }
    
    public long getSignal_strength() {
      return this.signal_strength;
    }
    
    public int getStatus_code() {
      return this.status_code;
    }
    
    public String getTarget_bucket() {
      return this.target_bucket;
    }
    
    public String getTarget_key() {
      return this.target_key;
    }
    
    public String getTarget_region_id() {
      return this.target_region_id;
    }
    
    public long getTid() {
      return this.tid;
    }
    
    public long getTls_connect_elapsed_time() {
      return this.tls_connect_elapsed_time;
    }
    
    public long getTotal_elapsed_time() {
      return this.total_elapsed_time;
    }
    
    public long getUp_time() {
      return this.up_time;
    }
    
    public String getUp_type() {
      return this.up_type;
    }
    
    public long getWait_elapsed_time() {
      return this.wait_elapsed_time;
    }
    
    public void setBytes_sent(long param1Long) {
      this.bytes_sent = param1Long;
    }
    
    public void setBytes_total(long param1Long) {
      this.bytes_total = param1Long;
    }
    
    public void setConnect_elapsed_time(long param1Long) {
      this.connect_elapsed_time = param1Long;
    }
    
    public void setCurrent_region_id(String param1String) {
      this.current_region_id = param1String;
    }
    
    public void setDns_elapsed_time(long param1Long) {
      this.dns_elapsed_time = param1Long;
    }
    
    public void setError_description(String param1String) {
      this.error_description = param1String;
    }
    
    public void setError_type(String param1String) {
      this.error_type = param1String;
    }
    
    public void setFile_offset(long param1Long) {
      this.file_offset = param1Long;
    }
    
    public void setHost(String param1String) {
      this.host = param1String;
    }
    
    public void setLog_type(String param1String) {
      this.log_type = param1String;
    }
    
    public void setNetwork_type(String param1String) {
      this.network_type = param1String;
    }
    
    public void setOs_name(String param1String) {
      this.os_name = param1String;
    }
    
    public void setOs_version(String param1String) {
      this.os_version = param1String;
    }
    
    public void setPid(long param1Long) {
      this.pid = param1Long;
    }
    
    public void setPort(int param1Int) {
      this.port = param1Int;
    }
    
    public void setPrefetched_ip_count(long param1Long) {
      this.prefetched_ip_count = param1Long;
    }
    
    public void setRemote_ip(String param1String) {
      this.remote_ip = param1String;
    }
    
    public void setReq_id(String param1String) {
      this.req_id = param1String;
    }
    
    public void setRequest_elapsed_time(long param1Long) {
      this.request_elapsed_time = param1Long;
    }
    
    public void setResponse_elapsed_time(long param1Long) {
      this.response_elapsed_time = param1Long;
    }
    
    public void setSdk_name(String param1String) {
      this.sdk_name = param1String;
    }
    
    public void setSdk_version(String param1String) {
      this.sdk_version = param1String;
    }
    
    public void setSignal_strength(long param1Long) {
      this.signal_strength = param1Long;
    }
    
    public void setStatus_code(int param1Int) {
      this.status_code = param1Int;
    }
    
    public void setTarget_bucket(String param1String) {
      this.target_bucket = param1String;
    }
    
    public void setTarget_key(String param1String) {
      this.target_key = param1String;
    }
    
    public void setTarget_region_id(String param1String) {
      this.target_region_id = param1String;
    }
    
    public void setTid(long param1Long) {
      this.tid = param1Long;
    }
    
    public void setTls_connect_elapsed_time(long param1Long) {
      this.tls_connect_elapsed_time = param1Long;
    }
    
    public void setTotal_elapsed_time(long param1Long) {
      this.total_elapsed_time = param1Long;
    }
    
    public void setUp_time(long param1Long) {
      this.up_time = param1Long;
    }
    
    public void setUp_type(String param1String) {
      this.up_type = param1String;
    }
    
    public void setWait_elapsed_time(long param1Long) {
      this.wait_elapsed_time = param1Long;
    }
  }
  
  public static class UploadQuality {
    private long bytes_sent;
    
    private String cloud_type;
    
    private String log_type = "quality";
    
    private long regions_counts = 1L;
    
    private long requests_counts;
    
    private String result;
    
    private long total_elapsed_time;
    
    private long up_time;
    
    public long getBytes_sent() {
      return this.bytes_sent;
    }
    
    public String getCloud_type() {
      return this.cloud_type;
    }
    
    public String getLog_type() {
      return this.log_type;
    }
    
    public long getRegions_counts() {
      return this.regions_counts;
    }
    
    public long getRequests_counts() {
      return this.requests_counts;
    }
    
    public String getResult() {
      return this.result;
    }
    
    public long getTotal_elapsed_time() {
      return this.total_elapsed_time;
    }
    
    public long getUp_time() {
      return this.up_time;
    }
    
    public void setBytes_sent(long param1Long) {
      this.bytes_sent = param1Long;
    }
    
    public void setCloud_type(String param1String) {
      this.cloud_type = param1String;
    }
    
    public void setLog_type(String param1String) {
      this.log_type = param1String;
    }
    
    public void setRegions_counts(long param1Long) {
      this.regions_counts = param1Long;
    }
    
    public void setRequests_counts(long param1Long) {
      this.requests_counts = param1Long;
    }
    
    public void setResult(String param1String) {
      this.result = param1String;
    }
    
    public void setTotal_elapsed_time(long param1Long) {
      this.total_elapsed_time = param1Long;
    }
    
    public void setUp_time(long param1Long) {
      this.up_time = param1Long;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\collect\UploadInfoElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */