package com.baidu.mobads.interfaces.error;

public enum XAdErrorCode {
  CLICK_FIELD_ERROR,
  CLICK_FIELD_LESS,
  CLICK_JUMP_FAILED,
  CLICK_PARSE_FAILED,
  FILTER_APP_INSTALLED,
  FILTER_APP_UNINSTALLED,
  INTERFACE_USE_PROBLEM(1010001, "接口使用问题"),
  LOADING_DL_ERROR(1010001, "接口使用问题"),
  LOADING_LP_ERROR(1010001, "接口使用问题"),
  MCACHE_FETCH_FAILED(1010001, "接口使用问题"),
  MCACHE_PREPARE_FAILED(1010001, "接口使用问题"),
  MONITOR_START_FAILED(1010001, "接口使用问题"),
  NETWORK_UNCONNECT(1010001, "接口使用问题"),
  PERMISSION_PROBLEM(1010001, "接口使用问题"),
  REQUEST_PARAM_ERROR(1010001, "接口使用问题"),
  REQUEST_STATUS_CODE_ERROR(1010001, "接口使用问题"),
  REQUEST_TIMEOUT(1010001, "接口使用问题"),
  REQUEST_URL_TOO_LONG(1010001, "接口使用问题"),
  RESPONSE_ATYPE_UNSUPPORT(1010001, "接口使用问题"),
  RESPONSE_FIELD_LESS(1010001, "接口使用问题"),
  RESPONSE_HTML_ERROR(1010001, "接口使用问题"),
  RESPONSE_MTYPE_UNSUPPORT(1010001, "接口使用问题"),
  RESPONSE_PARSE_FAILED(1010001, "接口使用问题"),
  SETTINGS_ERROR(1010001, "接口使用问题"),
  SHOW_PROCESS_FAILED(1010001, "接口使用问题"),
  SHOW_STANDARD_UNFIT(1010001, "接口使用问题"),
  VIEWKIT_PUT_PROBLEM(1010001, "接口使用问题"),
  VIEWKIT_TOO_SMALL(1010001, "接口使用问题"),
  WEBVIEW_LOAD_ERROR(1010002, "web载入异常");
  
  public static final String ERROR_CODE_MESSAGE = "msg";
  
  private int a;
  
  private String b;
  
  static {
    VIEWKIT_PUT_PROBLEM = new XAdErrorCode("VIEWKIT_PUT_PROBLEM", 2, 1010003, "控件摆放问题");
    VIEWKIT_TOO_SMALL = new XAdErrorCode("VIEWKIT_TOO_SMALL", 3, 1010004, "控件过小");
    NETWORK_UNCONNECT = new XAdErrorCode("NETWORK_UNCONNECT", 4, 1020001, "网络连接问题");
    PERMISSION_PROBLEM = new XAdErrorCode("PERMISSION_PROBLEM", 5, 1030002, "权限设置问题");
    SETTINGS_ERROR = new XAdErrorCode("SETTINGS_ERROR", 6, 1030002, "设置问题");
    REQUEST_PARAM_ERROR = new XAdErrorCode("REQUEST_PARAM_ERROR", 7, 1040001, "请求参数问题");
    REQUEST_URL_TOO_LONG = new XAdErrorCode("REQUEST_URL_TOO_LONG", 8, 1040002, "请求串过长");
    REQUEST_TIMEOUT = new XAdErrorCode("REQUEST_TIMEOUT", 9, 1040003, "请求超时");
    REQUEST_STATUS_CODE_ERROR = new XAdErrorCode("REQUEST_STATUS_CODE_ERROR", 10, 1040004, "状态码异常");
    RESPONSE_PARSE_FAILED = new XAdErrorCode("RESPONSE_PARSE_FAILED", 11, 3010001, "清单解析失败");
    RESPONSE_FIELD_LESS = new XAdErrorCode("RESPONSE_FIELD_LESS", 12, 3010002, "清单缺少字段");
    RESPONSE_MTYPE_UNSUPPORT = new XAdErrorCode("RESPONSE_MTYPE_UNSUPPORT", 13, 3010003, "物料类型不支持");
    RESPONSE_ATYPE_UNSUPPORT = new XAdErrorCode("RESPONSE_ATYPE_UNSUPPORT", 14, 3010004, "跳转类型不支持");
    RESPONSE_HTML_ERROR = new XAdErrorCode("RESPONSE_HTML_ERROR", 15, 3010005, "广告服务器返回的html内容错误, AD-SDK无法渲染该广告");
    FILTER_APP_INSTALLED = new XAdErrorCode("FILTER_APP_INSTALLED", 16, 3020001, "推广应用已被安装");
    FILTER_APP_UNINSTALLED = new XAdErrorCode("FILTER_APP_UNINSTALLED", 17, 3020002, "推广应用未被安装");
    MCACHE_PREPARE_FAILED = new XAdErrorCode("MCACHE_PREPARE_FAILED", 18, 3030001, "缓存准备失败");
    MCACHE_FETCH_FAILED = new XAdErrorCode("MCACHE_FETCH_FAILED", 19, 3030002, "缓存物料失败");
    SHOW_STANDARD_UNFIT = new XAdErrorCode("SHOW_STANDARD_UNFIT", 20, 3040001, "广告展现标准不达标");
    SHOW_PROCESS_FAILED = new XAdErrorCode("SHOW_PROCESS_FAILED", 21, 3040002, "广告展现失败");
    CLICK_PARSE_FAILED = new XAdErrorCode("CLICK_PARSE_FAILED", 22, 4010001, "点击信息解析失败");
    CLICK_FIELD_LESS = new XAdErrorCode("CLICK_FIELD_LESS", 23, 4010002, "点击信息缺失");
    CLICK_FIELD_ERROR = new XAdErrorCode("CLICK_FIELD_ERROR", 24, 4010003, "点击信息有误");
    CLICK_JUMP_FAILED = new XAdErrorCode("CLICK_JUMP_FAILED", 25, 4010004, "点击跳转失败");
    LOADING_LP_ERROR = new XAdErrorCode("LOADING_LP_ERROR", 26, 4020001, "打开LP问题");
    LOADING_DL_ERROR = new XAdErrorCode("LOADING_DL_ERROR", 27, 4020002, "下载器问题");
    MONITOR_START_FAILED = new XAdErrorCode("MONITOR_START_FAILED", 28, 4030001, "监控启动失败");
    c = new XAdErrorCode[] { 
        INTERFACE_USE_PROBLEM, WEBVIEW_LOAD_ERROR, VIEWKIT_PUT_PROBLEM, VIEWKIT_TOO_SMALL, NETWORK_UNCONNECT, PERMISSION_PROBLEM, SETTINGS_ERROR, REQUEST_PARAM_ERROR, REQUEST_URL_TOO_LONG, REQUEST_TIMEOUT, 
        REQUEST_STATUS_CODE_ERROR, RESPONSE_PARSE_FAILED, RESPONSE_FIELD_LESS, RESPONSE_MTYPE_UNSUPPORT, RESPONSE_ATYPE_UNSUPPORT, RESPONSE_HTML_ERROR, FILTER_APP_INSTALLED, FILTER_APP_UNINSTALLED, MCACHE_PREPARE_FAILED, MCACHE_FETCH_FAILED, 
        SHOW_STANDARD_UNFIT, SHOW_PROCESS_FAILED, CLICK_PARSE_FAILED, CLICK_FIELD_LESS, CLICK_FIELD_ERROR, CLICK_JUMP_FAILED, LOADING_LP_ERROR, LOADING_DL_ERROR, MONITOR_START_FAILED };
  }
  
  XAdErrorCode(int paramInt1, String paramString1) {
    this.a = paramInt1;
    this.b = paramString1;
  }
  
  public int getCode() {
    return this.a;
  }
  
  public String getMessage() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\interfaces\error\XAdErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */