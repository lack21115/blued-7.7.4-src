package com.huawei.hms.support.api.push.utils.common.base;

import java.nio.charset.Charset;

public class PushConst {
  public static final String ACTION_SDK_COMMOM_COMMAND = "com.huawei.android.push.intent.SDK_COMMAND";
  
  public static final String EXTRA_SELFSHOW_PKGNAME_KEY = "pkgName";
  
  public static final String EXTRA_SELFSHOW_TYPE_KEY = "type";
  
  public static final String EXTRA_SELFSHOW_URL_KEY = "url";
  
  public static final String FILE_TYPE_XML = "xml";
  
  public static final String FRAMEWORK_PKGNAME = "android";
  
  public static final String FRAMEWORK_PUSH_PROXYSERVICE = "com.huawei.android.pushagentproxy.PushService";
  
  public static final String KEY_SELFSHOW_FLAG = "enalbeFlag";
  
  public static final String NC_PKGNAME = "com.huawei.android.pushagent";
  
  public static final long NEW_NOTIFY_NC_VERSION = 90101310L;
  
  public static final String PUSH_NOTIFY_FILE_PATH = "/shared_prefs/push_notify_flag.xml";
  
  public static final String PUSH_PROVIDER_AUTHORITY = ".huawei.push.provider/";
  
  public static final int REMOVE_FILES_PATH = 6;
  
  public static final String TAG = "PushLogSC3004";
  
  public static final Charset UTF_8 = Charset.forName("UTF-8");
  
  public static final int VERSION_CODE = 3004;
  
  public static class KeyType {
    public static final String MSG_ID_STR = "msgIdStr";
    
    public static final String PUSH_BROADCAST_MESSAGE = "msg_data";
    
    public static final String PUSH_KEY_DEVICE_TOKEN = "device_token";
  }
  
  public static class SERVER {
    public static final String DEVICETOKEN = "device_token";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\pus\\utils\common\base\PushConst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */