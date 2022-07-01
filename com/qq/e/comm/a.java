package com.qq.e.comm;

import android.content.Context;
import android.content.Intent;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

public class a {
  public static AdError a(int paramInt) {
    if (paramInt != 700)
      if (paramInt != 701) {
        if (paramInt != 4014) {
          if (paramInt != 4015) {
            StringBuilder stringBuilder;
            switch (paramInt) {
              default:
                switch (paramInt) {
                  default:
                    switch (paramInt) {
                      default:
                        switch (paramInt) {
                          default:
                            switch (paramInt) {
                              default:
                                switch (paramInt) {
                                  default:
                                    switch (paramInt) {
                                      default:
                                        switch (paramInt) {
                                          default:
                                            stringBuilder = new StringBuilder("未知错误，详细码：");
                                            stringBuilder.append(paramInt);
                                            return new AdError(6000, stringBuilder.toString());
                                          case 5001:
                                            return new AdError(5001, "服务端数据错误");
                                          case 5004:
                                            return new AdError(5004, "没有广告");
                                          case 5008:
                                            return new AdError(5008, "图片加载错误");
                                          case 5007:
                                            return new AdError(5007, "资源加载错误");
                                          case 5009:
                                            return new AdError(5009, "广告请求量或者消耗等超过小时限额，请一小时后再请求广告");
                                          case 5005:
                                            return new AdError(5005, "广告请求量或者消耗等超过日限额，请明天再请求广告");
                                          case 5006:
                                            return new AdError(5006, "包名校验错误，当前App的包名和广点通移动联盟官网注册的媒体包名不一致，因此无广告返回");
                                          case 5003:
                                            return new AdError(5003, "视频素材播放错误");
                                          case 5002:
                                            break;
                                        } 
                                        return new AdError(5002, "视频素材下载错误");
                                      case 2003:
                                        return new AdError(2003, "SDK未初始化");
                                      case 2002:
                                        return new AdError(2002, "内部错误");
                                      case 2001:
                                        break;
                                    } 
                                    break;
                                  case 608:
                                    return new AdError(4009, "开屏广告的自定义跳过按钮尺寸小于3x3dp");
                                  case 607:
                                    return new AdError(4006, "原生广告接口调用顺序错误，调用点击接口前未调用曝光接口");
                                  case 606:
                                    break;
                                } 
                              case 604:
                                return new AdError(2002, "内部错误，详细码：200202");
                              case 603:
                                return new AdError(2002, "内部错误，详细码：200201");
                              case 600:
                                return new AdError(4004, "开屏广告容器不可见");
                              case 602:
                                return new AdError(4002, "Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予");
                              case 601:
                                break;
                            } 
                          case 502:
                          case 501:
                          
                          case 500:
                            break;
                        } 
                      case 406:
                      case 405:
                      
                      case 404:
                        return new AdError(4011, "开屏广告拉取超时");
                      case 403:
                        break;
                    } 
                  case 400104:
                    stringBuilder = new StringBuilder("传入的参数有错误，详细码：");
                    stringBuilder.append(paramInt);
                    return new AdError(4001, stringBuilder.toString());
                  case 400103:
                    stringBuilder = new StringBuilder("传入的参数有错误，详细码：");
                    stringBuilder.append(paramInt);
                    return new AdError(4001, stringBuilder.toString());
                  case 400102:
                    stringBuilder = new StringBuilder("传入的参数有错误，详细码：");
                    stringBuilder.append(paramInt);
                    return new AdError(4001, stringBuilder.toString());
                  case 400101:
                    stringBuilder = new StringBuilder("传入的参数有错误，详细码：");
                    stringBuilder.append(paramInt);
                    return new AdError(4001, stringBuilder.toString());
                  case 200202:
                  case 200201:
                  case 109507:
                  case 109506:
                  
                  case 107035:
                    return new AdError(4013, "使用支持视频素材的原生模板广告位前，请升级您的SDK");
                  case 107034:
                    return new AdError(5010, "广告样式校验失败，请检查广告位与接口使用是否一致");
                  case 107030:
                  
                  case 100159:
                    return new AdError(4016, "应用横竖方向参数与广告位支持方向不匹配");
                  case 5022:
                    return new AdError(5022, "模板激励视频渲染失败");
                  case 5021:
                    return new AdError(5021, "该类型广告已废弃，请使用其他类型的广告");
                  case 5012:
                    return new AdError(5012, "广告数据已过期，请重新拉取广告");
                  case 5011:
                    return new AdError(5010, "原生模版渲染失败");
                  case 4011:
                  case 4009:
                  
                  case 4008:
                    return new AdError(4008, "设备方向不适合展示广告");
                  case 4007:
                    return new AdError(4007, "当前设备或系统不支持");
                  case 4006:
                  
                  case 4005:
                    return new AdError(4005, "开屏广告容器的高度低于400dp");
                  case 4004:
                  
                  case 4003:
                    return new AdError(4003, "广告位错误");
                  case 4002:
                  
                  case 4001:
                    return new AdError(4001, "传入的参数有错误");
                  case 3003:
                    return new AdError(3003, "网络不可用");
                  case 800:
                    return new AdError(4012, "内容接口调用顺序错误，调用点击接口前未调用曝光接口");
                  case 400:
                  case 3001:
                    return new AdError(3001, "网络异常");
                  case 200103:
                    return new AdError(2001, "初始化错误，详细码：200103");
                  case 200102:
                    return new AdError(2001, "初始化错误，详细码：200102");
                  case 200101:
                    break;
                } 
              case 303:
              case 302:
              
              case 301:
                return new AdError(2001, "初始化错误，详细码：200101");
              case 300:
                break;
            } 
            return new AdError(2001, "初始化错误");
          } 
          return new AdError(4015, "同一条广告不允许多次展示，请再次拉取后展示");
        } 
        return new AdError(4014, "广告数据尚未准备好");
      }  
    return new AdError(5002, "视频素材下载错误");
  }
  
  public static boolean a(Context paramContext) {
    try {
      if (b(paramContext) && a(paramContext, new Class[] { Class.forName(CustomPkgConstants.getADActivityName()) }) && a(paramContext, new Class[] { Class.forName(CustomPkgConstants.getPortraitADActivityName()) }) && a(paramContext, new Class[] { Class.forName(CustomPkgConstants.getLandscapeADActivityName()) })) {
        boolean bool = b(paramContext, new Class[] { Class.forName(CustomPkgConstants.getDownLoadServiceName()) });
        if (bool)
          return true; 
      } 
    } finally {
      paramContext = null;
    } 
  }
  
  private static boolean a(Context paramContext, Class<?>... paramVarArgs) {
    int i = 0;
    while (i) {
      try {
        Intent intent = new Intent();
        intent.setClass(paramContext, paramVarArgs[0]);
      } finally {
        paramContext = null;
        GDTLogger.e("Exception while checking required activities", (Throwable)paramContext);
      } 
    } 
    return true;
  }
  
  public static byte[] a(byte[] paramArrayOfbyte) {
    ByteArrayOutputStream byteArrayOutputStream;
    GZIPOutputStream gZIPOutputStream = null;
    if (paramArrayOfbyte != null) {
      GZIPOutputStream gZIPOutputStream1;
      Exception exception1;
      if (paramArrayOfbyte.length == 0)
        return paramArrayOfbyte; 
      byteArrayOutputStream = new ByteArrayOutputStream();
      try {
        GZIPOutputStream gZIPOutputStream3 = new GZIPOutputStream(byteArrayOutputStream);
      } catch (Exception null) {
      
      } finally {
        Exception exception2;
        exception1 = null;
        gZIPOutputStream1 = gZIPOutputStream2;
      } 
      GZIPOutputStream gZIPOutputStream2 = gZIPOutputStream1;
      exception1.printStackTrace();
      if (gZIPOutputStream1 != null) {
        try {
          gZIPOutputStream1.close();
          byteArrayOutputStream.close();
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        return null;
      } 
    } else {
      return (byte[])exception;
    } 
    byteArrayOutputStream.close();
  }
  
  private static boolean b(Context paramContext) {
    int i = 0;
    while (i < 3) {
      try {
        (new String[3])[0] = "android.permission.INTERNET";
        (new String[3])[1] = "android.permission.ACCESS_NETWORK_STATE";
        (new String[3])[2] = "android.permission.ACCESS_WIFI_STATE";
        String str = (new String[3])[i];
      } finally {
        paramContext = null;
        GDTLogger.e("Check required Permissions error", (Throwable)paramContext);
      } 
    } 
    return true;
  }
  
  private static boolean b(Context paramContext, Class<?>... paramVarArgs) {
    int i = 0;
    while (i) {
      Class<?> clazz = paramVarArgs[0];
      try {
        Intent intent = new Intent();
        intent.setClass(paramContext, clazz);
      } finally {
        paramContext = null;
        GDTLogger.e("Exception while checking required services", (Throwable)paramContext);
      } 
    } 
    return true;
  }
  
  public static byte[] b(byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore #4
    //   5: aload_0
    //   6: ifnull -> 205
    //   9: aload_0
    //   10: arraylength
    //   11: ifne -> 17
    //   14: goto -> 205
    //   17: new java/io/ByteArrayInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial <init> : ([B)V
    //   25: astore #5
    //   27: new java/io/ByteArrayOutputStream
    //   30: dup
    //   31: invokespecial <init> : ()V
    //   34: astore #6
    //   36: sipush #1024
    //   39: newarray byte
    //   41: astore #7
    //   43: new java/util/zip/GZIPInputStream
    //   46: dup
    //   47: aload #5
    //   49: invokespecial <init> : (Ljava/io/InputStream;)V
    //   52: astore_2
    //   53: aload_2
    //   54: astore_0
    //   55: aload_2
    //   56: aload #7
    //   58: invokevirtual read : ([B)I
    //   61: istore_1
    //   62: iload_1
    //   63: iconst_m1
    //   64: if_icmpeq -> 81
    //   67: aload_2
    //   68: astore_0
    //   69: aload #6
    //   71: aload #7
    //   73: iconst_0
    //   74: iload_1
    //   75: invokevirtual write : ([BII)V
    //   78: goto -> 53
    //   81: aload_2
    //   82: astore_0
    //   83: aload #6
    //   85: invokevirtual flush : ()V
    //   88: aload_2
    //   89: astore_0
    //   90: aload #6
    //   92: invokevirtual toByteArray : ()[B
    //   95: astore_3
    //   96: aload_3
    //   97: astore_0
    //   98: aload_2
    //   99: invokevirtual close : ()V
    //   102: aload_3
    //   103: astore_0
    //   104: aload #5
    //   106: invokevirtual close : ()V
    //   109: aload_3
    //   110: astore_0
    //   111: aload #6
    //   113: invokevirtual close : ()V
    //   116: aload_3
    //   117: areturn
    //   118: astore_2
    //   119: aload_2
    //   120: invokevirtual printStackTrace : ()V
    //   123: aload_0
    //   124: areturn
    //   125: astore_2
    //   126: goto -> 177
    //   129: astore_3
    //   130: goto -> 142
    //   133: astore_2
    //   134: aload_3
    //   135: astore_0
    //   136: goto -> 177
    //   139: astore_3
    //   140: aconst_null
    //   141: astore_2
    //   142: aload_2
    //   143: astore_0
    //   144: aload_3
    //   145: invokevirtual printStackTrace : ()V
    //   148: aload_2
    //   149: ifnull -> 159
    //   152: aload #4
    //   154: astore_0
    //   155: aload_2
    //   156: invokevirtual close : ()V
    //   159: aload #4
    //   161: astore_0
    //   162: aload #5
    //   164: invokevirtual close : ()V
    //   167: aload #4
    //   169: astore_0
    //   170: aload #6
    //   172: invokevirtual close : ()V
    //   175: aconst_null
    //   176: areturn
    //   177: aload_0
    //   178: ifnull -> 185
    //   181: aload_0
    //   182: invokevirtual close : ()V
    //   185: aload #5
    //   187: invokevirtual close : ()V
    //   190: aload #6
    //   192: invokevirtual close : ()V
    //   195: goto -> 203
    //   198: astore_0
    //   199: aload_0
    //   200: invokevirtual printStackTrace : ()V
    //   203: aload_2
    //   204: athrow
    //   205: aload_0
    //   206: areturn
    // Exception table:
    //   from	to	target	type
    //   43	53	139	java/lang/Exception
    //   43	53	133	finally
    //   55	62	129	java/lang/Exception
    //   55	62	125	finally
    //   69	78	129	java/lang/Exception
    //   69	78	125	finally
    //   83	88	129	java/lang/Exception
    //   83	88	125	finally
    //   90	96	129	java/lang/Exception
    //   90	96	125	finally
    //   98	102	118	java/lang/Exception
    //   104	109	118	java/lang/Exception
    //   111	116	118	java/lang/Exception
    //   144	148	125	finally
    //   155	159	118	java/lang/Exception
    //   162	167	118	java/lang/Exception
    //   170	175	118	java/lang/Exception
    //   181	185	198	java/lang/Exception
    //   185	195	198	java/lang/Exception
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */