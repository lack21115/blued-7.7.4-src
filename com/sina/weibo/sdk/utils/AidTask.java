package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.NetUtils;
import com.sina.weibo.sdk.net.WeiboParameters;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.concurrent.locks.ReentrantLock;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

public class AidTask {
  private static final String AID_FILE_NAME = "weibo_sdk_aid";
  
  private static final int MAX_RETRY_NUM = 3;
  
  private static final String TAG = "AidTask";
  
  private static final int VERSION = 1;
  
  public static final int WHAT_LOAD_AID_ERR = 1002;
  
  public static final int WHAT_LOAD_AID_SUC = 1001;
  
  private static AidTask sInstance;
  
  private AidInfo mAidInfo;
  
  private String mAppKey;
  
  private Context mContext;
  
  private CallbackHandler mHandler;
  
  private volatile ReentrantLock mTaskLock = new ReentrantLock(true);
  
  private AidTask(Context paramContext) {
    this.mContext = paramContext.getApplicationContext();
    this.mHandler = new CallbackHandler(this.mContext.getMainLooper());
    (new Thread(new Runnable() {
          public void run() {
            for (int i = 0;; i++) {
              if (i >= 1)
                return; 
              File file = AidTask.this.getAidInfoFile(i);
              try {
                file.delete();
              } catch (Exception exception) {}
            } 
          }
        })).start();
  }
  
  private void cacheAidInfo(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aconst_null
    //   15: astore #5
    //   17: aconst_null
    //   18: astore #4
    //   20: new java/io/FileOutputStream
    //   23: dup
    //   24: aload_0
    //   25: iconst_1
    //   26: invokespecial getAidInfoFile : (I)Ljava/io/File;
    //   29: invokespecial <init> : (Ljava/io/File;)V
    //   32: astore_3
    //   33: aload_3
    //   34: aload_1
    //   35: invokevirtual getBytes : ()[B
    //   38: invokevirtual write : ([B)V
    //   41: aload_3
    //   42: invokevirtual close : ()V
    //   45: goto -> 77
    //   48: astore_1
    //   49: goto -> 59
    //   52: goto -> 69
    //   55: astore_1
    //   56: aload #4
    //   58: astore_3
    //   59: aload_3
    //   60: ifnull -> 67
    //   63: aload_3
    //   64: invokevirtual close : ()V
    //   67: aload_1
    //   68: athrow
    //   69: aload_3
    //   70: ifnull -> 77
    //   73: aload_3
    //   74: invokevirtual close : ()V
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    //   85: astore_1
    //   86: aload #5
    //   88: astore_3
    //   89: goto -> 69
    //   92: astore_1
    //   93: goto -> 52
    //   96: astore_1
    //   97: goto -> 77
    //   100: astore_3
    //   101: goto -> 67
    // Exception table:
    //   from	to	target	type
    //   2	7	80	finally
    //   20	33	85	java/lang/Exception
    //   20	33	55	finally
    //   33	41	92	java/lang/Exception
    //   33	41	48	finally
    //   41	45	96	java/io/IOException
    //   41	45	80	finally
    //   63	67	100	java/io/IOException
    //   63	67	80	finally
    //   67	69	80	finally
    //   73	77	96	java/io/IOException
    //   73	77	80	finally
  }
  
  private static String encryptRsa(String paramString1, String paramString2) throws Exception {
    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    cipher.init(1, getPublicKey(paramString2));
    byte[] arrayOfByte = paramString1.getBytes("UTF-8");
    try {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      int i = 0;
    } finally {
      arrayOfByte = null;
    } 
    if (paramString2 != null)
      try {
        paramString2.close();
      } catch (IOException iOException) {} 
    throw arrayOfByte;
  }
  
  private static String genMfpString(Context paramContext) {
    JSONObject jSONObject = new JSONObject();
    try {
      String str = getOS();
      if (!TextUtils.isEmpty(str))
        jSONObject.put("1", str); 
      str = getImei(paramContext);
      if (!TextUtils.isEmpty(str))
        jSONObject.put("2", str); 
      str = getMeid(paramContext);
      if (!TextUtils.isEmpty(str))
        jSONObject.put("3", str); 
      str = getImsi(paramContext);
      if (!TextUtils.isEmpty(str))
        jSONObject.put("4", str); 
      str = getMac(paramContext);
      if (!TextUtils.isEmpty(str))
        jSONObject.put("5", str); 
      str = getIccid(paramContext);
      if (!TextUtils.isEmpty(str))
        jSONObject.put("6", str); 
      str = getSerialNo();
      if (!TextUtils.isEmpty(str))
        jSONObject.put("7", str); 
      str = getAndroidId(paramContext);
      if (!TextUtils.isEmpty(str))
        jSONObject.put("10", str); 
      str = getCpu();
      if (!TextUtils.isEmpty(str))
        jSONObject.put("13", str); 
      str = getModel();
      if (!TextUtils.isEmpty(str))
        jSONObject.put("14", str); 
      str = getSdSize();
      if (!TextUtils.isEmpty(str))
        jSONObject.put("15", str); 
      str = getResolution(paramContext);
      if (!TextUtils.isEmpty(str))
        jSONObject.put("16", str); 
      str = getSsid(paramContext);
      if (!TextUtils.isEmpty(str))
        jSONObject.put("17", str); 
      str = getDeviceName();
      if (!TextUtils.isEmpty(str))
        jSONObject.put("18", str); 
      str = getConnectType(paramContext);
      if (!TextUtils.isEmpty(str))
        jSONObject.put("19", str); 
      try {
        null = Utility.generateUAAid(paramContext);
      } catch (Exception exception) {
        exception.printStackTrace();
        null = "";
      } 
      if (!TextUtils.isEmpty(null))
        jSONObject.put("20", null); 
      return jSONObject.toString();
    } catch (JSONException jSONException) {
      return "";
    } 
  }
  
  private void generateAid(String paramString, final AidResultCallBack callback) {
    if (TextUtils.isEmpty(paramString))
      return; 
    this.mAppKey = paramString;
    (new Thread(new Runnable() {
          public void run() {
            AidTask.this.mTaskLock.lock();
            AidTask.AidInfo aidInfo2 = AidTask.this.loadAidInfoFromCache();
            String str2 = null;
            AidTask.AidInfo aidInfo1 = aidInfo2;
            String str1 = str2;
            if (aidInfo2 == null) {
              aidInfo1 = aidInfo2;
              try {
                str1 = AidTask.this.loadAidFromNet();
                aidInfo1 = aidInfo2;
                aidInfo2 = AidTask.AidInfo.parseJson(str1);
                aidInfo1 = aidInfo2;
                AidTask.this.cacheAidInfo(str1);
                aidInfo1 = aidInfo2;
                AidTask.this.mAidInfo = aidInfo2;
                aidInfo1 = aidInfo2;
                str1 = str2;
              } catch (WeiboException weiboException) {
                StringBuilder stringBuilder = new StringBuilder("AidTaskInit WeiboException Msg : ");
                stringBuilder.append(weiboException.getMessage());
                LogUtil.e("AidTask", stringBuilder.toString());
              } 
            } 
            AidTask.this.mTaskLock.unlock();
            Message message = Message.obtain();
            if (aidInfo1 != null) {
              message.what = 1001;
              message.obj = aidInfo1;
            } else {
              message.what = 1002;
              message.obj = weiboException;
            } 
            AidTask.this.mHandler.setCallback(callback);
            AidTask.this.mHandler.sendMessage(message);
          }
        })).start();
  }
  
  private File getAidInfoFile(int paramInt) {
    File file = this.mContext.getFilesDir();
    StringBuilder stringBuilder = new StringBuilder("weibo_sdk_aid");
    stringBuilder.append(paramInt);
    return new File(file, stringBuilder.toString());
  }
  
  private static String getAndroidId(Context paramContext) {
    try {
      return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getConnectType(Context paramContext) {
    String str = "none";
    try {
      NetworkInfo networkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      String str1 = str;
      if (networkInfo != null) {
        if (networkInfo.getType() == 0) {
          switch (networkInfo.getSubtype()) {
            default:
              return "none";
            case 13:
              return "4G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
              return "3G";
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
              break;
          } 
        } else {
          str1 = str;
          if (networkInfo.getType() == 1)
            str1 = "wifi"; 
          return str1;
        } 
      } else {
        return str1;
      } 
    } catch (Exception exception) {
      return "none";
    } 
    return "2G";
  }
  
  private static String getCpu() {
    try {
      return Build.CPU_ABI;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getDeviceName() {
    try {
      return Build.BRAND;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getIccid(Context paramContext) {
    try {
      return ((TelephonyManager)paramContext.getSystemService("phone")).getSimSerialNumber();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getImei(Context paramContext) {
    try {
      return ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getImsi(Context paramContext) {
    try {
      return ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public static AidTask getInstance(Context paramContext) {
    // Byte code:
    //   0: ldc com/sina/weibo/sdk/utils/AidTask
    //   2: monitorenter
    //   3: getstatic com/sina/weibo/sdk/utils/AidTask.sInstance : Lcom/sina/weibo/sdk/utils/AidTask;
    //   6: ifnonnull -> 20
    //   9: new com/sina/weibo/sdk/utils/AidTask
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Landroid/content/Context;)V
    //   17: putstatic com/sina/weibo/sdk/utils/AidTask.sInstance : Lcom/sina/weibo/sdk/utils/AidTask;
    //   20: getstatic com/sina/weibo/sdk/utils/AidTask.sInstance : Lcom/sina/weibo/sdk/utils/AidTask;
    //   23: astore_0
    //   24: ldc com/sina/weibo/sdk/utils/AidTask
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: astore_0
    //   30: ldc com/sina/weibo/sdk/utils/AidTask
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	29	finally
    //   20	24	29	finally
  }
  
  private static String getMac(Context paramContext) {
    String str = "";
    try {
      WifiManager wifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (wifiManager == null)
        return ""; 
      WifiInfo wifiInfo = wifiManager.getConnectionInfo();
      String str1 = str;
      if (wifiInfo != null)
        str1 = wifiInfo.getMacAddress(); 
      return str1;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getMeid(Context paramContext) {
    try {
      return ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getMfp(Context paramContext) {
    String str = genMfpString(paramContext);
    try {
      str = new String(str.getBytes(), "UTF-8");
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      str = "";
    } 
    StringBuilder stringBuilder = new StringBuilder("genMfpString() utf-8 string : ");
    stringBuilder.append(str);
    LogUtil.d("AidTask", stringBuilder.toString());
    try {
      str = encryptRsa(str, "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDHHM0Fi2Z6+QYKXqFUX2Cy6AaWq3cPi+GSn9oeAwQbPZR75JB7Netm0HtBVVbtPhzT7UO2p1JhFUKWqrqoYuAjkgMVPmA0sFrQohns5EE44Y86XQopD4ZO+dE5KjUZFE6vrPO3rWW3np2BqlgKpjnYZri6TJApmIpGcQg9/G/3zQIDAQAB");
      stringBuilder = new StringBuilder("encryptRsa() string : ");
      stringBuilder.append(str);
      LogUtil.d("AidTask", stringBuilder.toString());
      return str;
    } catch (Exception exception) {
      LogUtil.e("AidTask", exception.getMessage());
      return "";
    } 
  }
  
  private static String getModel() {
    try {
      return Build.MODEL;
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getOS() {
    try {
      StringBuilder stringBuilder = new StringBuilder("Android ");
      stringBuilder.append(Build.VERSION.RELEASE);
      return stringBuilder.toString();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static PublicKey getPublicKey(String paramString) throws Exception {
    X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decode(paramString.getBytes()));
    return KeyFactory.getInstance("RSA").generatePublic(x509EncodedKeySpec);
  }
  
  private static String getResolution(Context paramContext) {
    try {
      DisplayMetrics displayMetrics = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(String.valueOf(displayMetrics.widthPixels)));
      stringBuilder.append("*");
      stringBuilder.append(String.valueOf(displayMetrics.heightPixels));
      return stringBuilder.toString();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getSdSize() {
    try {
      StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = statFs.getBlockSize();
      return Long.toString(statFs.getBlockCount() * l);
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getSerialNo() {
    try {
      Class<?> clazz = Class.forName("android.os.SystemProperties");
      return (String)clazz.getMethod("get", new Class[] { String.class, String.class }).invoke(clazz, new Object[] { "ro.serialno", "unknown" });
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String getSsid(Context paramContext) {
    try {
      WifiInfo wifiInfo = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (wifiInfo != null)
        return wifiInfo.getSSID(); 
    } catch (Exception exception) {}
    return "";
  }
  
  private void initAidInfo(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    this.mAppKey = paramString;
    (new Thread(new Runnable() {
          public void run() {
            if (!AidTask.this.mTaskLock.tryLock()) {
              LogUtil.e("AidTask", "tryLock : false, return");
              return;
            } 
            AidTask.AidInfo aidInfo = AidTask.this.loadAidInfoFromCache();
            if (aidInfo == null) {
              int i = 1;
              while (true) {
                int j = i + 1;
                try {
                  String str = AidTask.this.loadAidFromNet();
                  AidTask.AidInfo aidInfo1 = AidTask.AidInfo.parseJson(str);
                  AidTask.this.cacheAidInfo(str);
                  AidTask.this.mAidInfo = aidInfo1;
                  break;
                } catch (WeiboException weiboException) {
                  StringBuilder stringBuilder = new StringBuilder("AidTaskInit WeiboException Msg : ");
                  stringBuilder.append(weiboException.getMessage());
                  LogUtil.e("AidTask", stringBuilder.toString());
                  i = j;
                  if (j >= 3)
                    break; 
                } 
              } 
            } else {
              AidTask.this.mAidInfo = (AidTask.AidInfo)weiboException;
            } 
            AidTask.this.mTaskLock.unlock();
          }
        })).start();
  }
  
  private String loadAidFromNet() throws WeiboException {
    String str1 = this.mContext.getPackageName();
    String str2 = Utility.getSign(this.mContext, str1);
    String str3 = getMfp(this.mContext);
    WeiboParameters weiboParameters = new WeiboParameters(this.mAppKey);
    weiboParameters.put("appkey", this.mAppKey);
    weiboParameters.put("mfp", str3);
    weiboParameters.put("packagename", str1);
    weiboParameters.put("key_hash", str2);
    try {
      str1 = NetUtils.internalHttpRequest(this.mContext, "https://api.weibo.com/oauth2/getaid.json", "GET", weiboParameters);
      StringBuilder stringBuilder = new StringBuilder("loadAidFromNet response : ");
      stringBuilder.append(str1);
      LogUtil.d("AidTask", stringBuilder.toString());
      return str1;
    } catch (WeiboException weiboException) {
      StringBuilder stringBuilder = new StringBuilder("loadAidFromNet WeiboException Msg : ");
      stringBuilder.append(weiboException.getMessage());
      LogUtil.d("AidTask", stringBuilder.toString());
      throw weiboException;
    } 
  }
  
  private AidInfo loadAidInfoFromCache() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: iconst_1
    //   8: invokespecial getAidInfoFile : (I)Ljava/io/File;
    //   11: invokespecial <init> : (Ljava/io/File;)V
    //   14: astore_1
    //   15: aload_1
    //   16: invokevirtual available : ()I
    //   19: newarray byte
    //   21: astore_2
    //   22: aload_1
    //   23: aload_2
    //   24: invokevirtual read : ([B)I
    //   27: pop
    //   28: new java/lang/String
    //   31: dup
    //   32: aload_2
    //   33: invokespecial <init> : ([B)V
    //   36: invokestatic parseJson : (Ljava/lang/String;)Lcom/sina/weibo/sdk/utils/AidTask$AidInfo;
    //   39: astore_2
    //   40: aload_1
    //   41: invokevirtual close : ()V
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: areturn
    //   48: astore_2
    //   49: goto -> 58
    //   52: goto -> 70
    //   55: astore_2
    //   56: aconst_null
    //   57: astore_1
    //   58: aload_1
    //   59: ifnull -> 66
    //   62: aload_1
    //   63: invokevirtual close : ()V
    //   66: aload_2
    //   67: athrow
    //   68: aconst_null
    //   69: astore_1
    //   70: aload_1
    //   71: ifnull -> 86
    //   74: aload_1
    //   75: invokevirtual close : ()V
    //   78: goto -> 86
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    //   86: aload_0
    //   87: monitorexit
    //   88: aconst_null
    //   89: areturn
    //   90: astore_1
    //   91: goto -> 68
    //   94: astore_2
    //   95: goto -> 52
    //   98: astore_1
    //   99: goto -> 44
    //   102: astore_1
    //   103: goto -> 66
    //   106: astore_1
    //   107: goto -> 86
    // Exception table:
    //   from	to	target	type
    //   2	15	90	java/lang/Exception
    //   2	15	55	finally
    //   15	40	94	java/lang/Exception
    //   15	40	48	finally
    //   40	44	98	java/io/IOException
    //   40	44	81	finally
    //   62	66	102	java/io/IOException
    //   62	66	81	finally
    //   66	68	81	finally
    //   74	78	106	java/io/IOException
    //   74	78	81	finally
  }
  
  private static int splite(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    return (paramInt1 >= paramArrayOfbyte.length) ? -1 : Math.min(paramArrayOfbyte.length - paramInt1, paramInt2);
  }
  
  public void aidTaskInit(String paramString) {
    if (TextUtils.isEmpty(paramString))
      return; 
    LogUtil.e("AidTask", "aidTaskInit ");
    initAidInfo(paramString);
  }
  
  public void getAidAsync(String paramString, AidResultCallBack paramAidResultCallBack) {
    if (TextUtils.isEmpty(paramString))
      return; 
    AidInfo aidInfo = this.mAidInfo;
    if (aidInfo != null && paramAidResultCallBack != null) {
      paramAidResultCallBack.onAidGenSuccessed(aidInfo.cloneAidInfo());
      return;
    } 
    generateAid(paramString, paramAidResultCallBack);
  }
  
  public AidInfo getAidSync(String paramString) throws WeiboException {
    if (TextUtils.isEmpty(paramString))
      return null; 
    LogUtil.e("AidTask", "getAidSync ");
    if (this.mAidInfo == null)
      aidTaskInit(paramString); 
    return this.mAidInfo;
  }
  
  public static final class AidInfo {
    private String mAid;
    
    private String mSubCookie;
    
    public static AidInfo parseJson(String param1String) throws WeiboException {
      AidInfo aidInfo = new AidInfo();
      try {
        JSONObject jSONObject = new JSONObject(param1String);
        if (!jSONObject.has("error") && !jSONObject.has("error_code")) {
          aidInfo.mAid = jSONObject.optString("aid", "");
          aidInfo.mSubCookie = jSONObject.optString("sub", "");
          return aidInfo;
        } 
        LogUtil.d("AidTask", "loadAidFromNet has error !!!");
        throw new WeiboException("loadAidFromNet has error !!!");
      } catch (JSONException jSONException) {
        StringBuilder stringBuilder = new StringBuilder("loadAidFromNet JSONException Msg : ");
        stringBuilder.append(jSONException.getMessage());
        LogUtil.d("AidTask", stringBuilder.toString());
        throw new WeiboException("loadAidFromNet has error !!!");
      } 
    }
    
    AidInfo cloneAidInfo() {
      AidInfo aidInfo = new AidInfo();
      aidInfo.mAid = this.mAid;
      aidInfo.mSubCookie = this.mSubCookie;
      return aidInfo;
    }
    
    public String getAid() {
      return this.mAid;
    }
    
    public String getSubCookie() {
      return this.mSubCookie;
    }
  }
  
  public static interface AidResultCallBack {
    void onAidGenFailed(Exception param1Exception);
    
    void onAidGenSuccessed(AidTask.AidInfo param1AidInfo);
  }
  
  static class CallbackHandler extends Handler {
    private WeakReference<AidTask.AidResultCallBack> callBackReference;
    
    public CallbackHandler(Looper param1Looper) {
      super(param1Looper);
    }
    
    public void handleMessage(Message param1Message) {
      AidTask.AidResultCallBack aidResultCallBack = this.callBackReference.get();
      int i = param1Message.what;
      if (i != 1001) {
        if (i != 1002)
          return; 
        if (aidResultCallBack != null) {
          aidResultCallBack.onAidGenFailed((Exception)param1Message.obj);
          return;
        } 
      } else if (aidResultCallBack != null) {
        aidResultCallBack.onAidGenSuccessed(((AidTask.AidInfo)param1Message.obj).cloneAidInfo());
      } 
    }
    
    public void setCallback(AidTask.AidResultCallBack param1AidResultCallBack) {
      WeakReference<AidTask.AidResultCallBack> weakReference = this.callBackReference;
      if (weakReference != null) {
        if ((AidTask.AidResultCallBack)weakReference.get() == param1AidResultCallBack)
          return; 
        this.callBackReference = new WeakReference<AidTask.AidResultCallBack>(param1AidResultCallBack);
        return;
      } 
      this.callBackReference = new WeakReference<AidTask.AidResultCallBack>(param1AidResultCallBack);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sd\\utils\AidTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */