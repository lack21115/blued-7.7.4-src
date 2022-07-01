package com.blued.android.share.sina;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;

public class StatusesAPI extends AbsOpenAPI {
  private static final String API_BASE_URL = "https://api.weibo.com/2/statuses";
  
  public static final int AUTHOR_FILTER_ALL = 0;
  
  public static final int AUTHOR_FILTER_ATTENTIONS = 1;
  
  public static final int AUTHOR_FILTER_STRANGER = 2;
  
  public static final int FEATURE_ALL = 0;
  
  public static final int FEATURE_MUSICE = 4;
  
  public static final int FEATURE_ORIGINAL = 1;
  
  public static final int FEATURE_PICTURE = 2;
  
  public static final int FEATURE_VIDEO = 3;
  
  private static final int READ_API_FRIENDS_TIMELINE = 0;
  
  private static final int READ_API_MENTIONS = 1;
  
  public static final int SRC_FILTER_ALL = 0;
  
  public static final int SRC_FILTER_WEIBO = 1;
  
  public static final int SRC_FILTER_WEIQUN = 2;
  
  public static final int TYPE_FILTER_ALL = 0;
  
  public static final int TYPE_FILTER_ORIGAL = 1;
  
  private static final int WRITE_API_REPOST = 3;
  
  private static final int WRITE_API_UPDATE = 2;
  
  private static final int WRITE_API_UPLOAD = 4;
  
  private static final int WRITE_API_UPLOAD_URL_TEXT = 5;
  
  private static final SparseArray<String> sAPIList = new SparseArray();
  
  static {
    sAPIList.put(0, "https://api.weibo.com/2/statuses/friends_timeline.json");
    sAPIList.put(1, "https://api.weibo.com/2/statuses/mentions.json");
    sAPIList.put(3, "https://api.weibo.com/2/statuses/repost.json");
    sAPIList.put(2, "https://api.weibo.com/2/statuses/update.json");
    sAPIList.put(4, "https://api.weibo.com/2/statuses/upload.json");
    sAPIList.put(5, "https://api.weibo.com/2/statuses/upload_url_text.json");
  }
  
  public StatusesAPI(Context paramContext, String paramString, Oauth2AccessToken paramOauth2AccessToken) {
    super(paramContext, paramString, paramOauth2AccessToken);
  }
  
  private WeiboParameters buildMentionsParams(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private WeiboParameters buildTimeLineParamsBase(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private WeiboParameters buildUpdateParams(String paramString1, String paramString2, String paramString3) {
    WeiboParameters weiboParameters = new WeiboParameters(this.mAppKey);
    weiboParameters.put("status", paramString1);
    if (!TextUtils.isEmpty(paramString3))
      weiboParameters.put("long", paramString3); 
    if (!TextUtils.isEmpty(paramString2))
      weiboParameters.put("lat", paramString2); 
    return weiboParameters;
  }
  
  public void friendsTimeline(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, RequestListener paramRequestListener) {
    WeiboParameters weiboParameters = buildTimeLineParamsBase(paramLong1, paramLong2, paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramInt3);
    requestAsync((String)sAPIList.get(0), weiboParameters, "GET", paramRequestListener);
  }
  
  public String friendsTimelineSync(long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2) {
    WeiboParameters weiboParameters = buildTimeLineParamsBase(paramLong1, paramLong2, paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramInt3);
    return requestSync((String)sAPIList.get(0), weiboParameters, "GET");
  }
  
  public void mentions(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, RequestListener paramRequestListener) {
    WeiboParameters weiboParameters = buildMentionsParams(paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
    requestAsync((String)sAPIList.get(1), weiboParameters, "GET", paramRequestListener);
  }
  
  public String mentionsSync(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {
    WeiboParameters weiboParameters = buildMentionsParams(paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramBoolean);
    return requestSync((String)sAPIList.get(1), weiboParameters, "GET");
  }
  
  public void update(String paramString1, String paramString2, String paramString3, RequestListener paramRequestListener) {
    WeiboParameters weiboParameters = buildUpdateParams(paramString1, paramString2, paramString3);
    requestAsync((String)sAPIList.get(2), weiboParameters, "POST", paramRequestListener);
  }
  
  public String updateSync(String paramString1, String paramString2, String paramString3) {
    WeiboParameters weiboParameters = buildUpdateParams(paramString1, paramString2, paramString3);
    return requestSync((String)sAPIList.get(2), weiboParameters, "POST");
  }
  
  public void upload(String paramString1, Bitmap paramBitmap, String paramString2, String paramString3, RequestListener paramRequestListener) {
    WeiboParameters weiboParameters = buildUpdateParams(paramString1, paramString2, paramString3);
    weiboParameters.put("pic", paramBitmap);
    requestAsync((String)sAPIList.get(4), weiboParameters, "POST", paramRequestListener);
  }
  
  public String uploadSync(String paramString1, Bitmap paramBitmap, String paramString2, String paramString3) {
    WeiboParameters weiboParameters = buildUpdateParams(paramString1, paramString2, paramString3);
    weiboParameters.put("pic", paramBitmap);
    return requestSync((String)sAPIList.get(4), weiboParameters, "POST");
  }
  
  public void uploadUrlText(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, RequestListener paramRequestListener) {
    WeiboParameters weiboParameters = buildUpdateParams(paramString1, paramString4, paramString5);
    weiboParameters.put("url", paramString2);
    weiboParameters.put("pic_id", paramString3);
    requestAsync((String)sAPIList.get(5), weiboParameters, "POST", paramRequestListener);
  }
  
  public String uploadUrlTextSync(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    WeiboParameters weiboParameters = buildUpdateParams(paramString1, paramString4, paramString5);
    weiboParameters.put("url", paramString2);
    weiboParameters.put("pic_id", paramString3);
    return requestSync((String)sAPIList.get(5), weiboParameters, "POST");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\share\sina\StatusesAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */