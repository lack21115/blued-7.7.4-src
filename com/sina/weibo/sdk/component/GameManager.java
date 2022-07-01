package com.sina.weibo.sdk.component;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.HttpManager;
import com.sina.weibo.sdk.net.WeiboParameters;
import com.sina.weibo.sdk.utils.LogUtil;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;

public class GameManager {
  private static final String BOUNDARY;
  
  public static final String DEFAULT_CHARSET = "UTF-8";
  
  private static final String HTTP_METHOD_GET = "GET";
  
  private static final String HTTP_METHOD_POST = "POST";
  
  private static String INVITATION_ONE_FRINED_URL;
  
  private static String INVITATION_URL;
  
  private static final String MULTIPART_FORM_DATA = "multipart/form-data";
  
  private static final String TAG = "GameManager";
  
  private static StringBuffer URL = new StringBuffer("https://api.weibo.com/2/proxy/darwin/graph/game/");
  
  private static String URL_ACHIEVEMENT_ADD_UPDATE;
  
  private static String URL_ACHIEVEMENT_READ_PLAYER_FRIENDS;
  
  private static String URL_ACHIEVEMENT_READ_PLAYER_SCORE;
  
  private static String URL_ACHIEVEMENT_RELATION_ADD_UPDATE;
  
  private static String URL_ACHIEVEMENT_SCORE_ADD_UPDATE;
  
  private static String URL_ACHIEVEMENT_USER_GAIN;
  
  static {
    BOUNDARY = HttpManager.getBoundry();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(URL);
    stringBuilder.append("achievement/add.json");
    URL_ACHIEVEMENT_ADD_UPDATE = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(URL);
    stringBuilder.append("achievement/gain/add.json");
    URL_ACHIEVEMENT_RELATION_ADD_UPDATE = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(URL);
    stringBuilder.append("score/add.json");
    URL_ACHIEVEMENT_SCORE_ADD_UPDATE = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(URL);
    stringBuilder.append("score/read_player.json");
    URL_ACHIEVEMENT_READ_PLAYER_SCORE = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(URL);
    stringBuilder.append("score/read_player_friends.json");
    URL_ACHIEVEMENT_READ_PLAYER_FRIENDS = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(URL);
    stringBuilder.append("achievement/user_gain.json");
    URL_ACHIEVEMENT_USER_GAIN = stringBuilder.toString();
    INVITATION_URL = "http://widget.weibo.com/invitation/app.php?";
    INVITATION_ONE_FRINED_URL = "http://widget.weibo.com/invitation/appinfo.php?";
  }
  
  public static String AddOrUpdateGameAchievement(Context paramContext, WeiboParameters paramWeiboParameters) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    paramWeiboParameters.put("updated_time", simpleDateFormat.format(date));
    if (TextUtils.isEmpty((String)paramWeiboParameters.get("create_time")))
      paramWeiboParameters.put("create_time", simpleDateFormat.format(date)); 
    String str = HttpManager.readRsponse(requestHttpExecute(paramContext, URL_ACHIEVEMENT_ADD_UPDATE, "POST", paramWeiboParameters));
    StringBuilder stringBuilder = new StringBuilder("Response : ");
    stringBuilder.append(str);
    LogUtil.d("GameManager", stringBuilder.toString());
    return str;
  }
  
  public static String addOrUpdateAchievementScore(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
    WeiboParameters weiboParameters = new WeiboParameters("");
    if (!TextUtils.isEmpty(paramString1))
      weiboParameters.put("access_token", paramString1); 
    if (!TextUtils.isEmpty(paramString2))
      weiboParameters.put("source", paramString2); 
    if (!TextUtils.isEmpty(paramString3))
      weiboParameters.put("game_id", paramString3); 
    if (!TextUtils.isEmpty(paramString4))
      weiboParameters.put("uid", paramString4); 
    if (!TextUtils.isEmpty(paramString5))
      weiboParameters.put("score", paramString5); 
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    weiboParameters.put("updated_time", simpleDateFormat.format(date));
    if (TextUtils.isEmpty((String)weiboParameters.get("create_time")))
      weiboParameters.put("create_time", simpleDateFormat.format(date)); 
    String str = HttpManager.readRsponse(requestHttpExecute(paramContext, URL_ACHIEVEMENT_SCORE_ADD_UPDATE, "POST", weiboParameters));
    StringBuilder stringBuilder = new StringBuilder("Response : ");
    stringBuilder.append(str);
    LogUtil.d("GameManager", stringBuilder.toString());
    return str;
  }
  
  public static String addOrUpdateGameAchievementRelation(Context paramContext, WeiboParameters paramWeiboParameters) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();
    paramWeiboParameters.put("updated_time", simpleDateFormat.format(date));
    if (TextUtils.isEmpty((String)paramWeiboParameters.get("create_time")))
      paramWeiboParameters.put("create_time", simpleDateFormat.format(date)); 
    String str = HttpManager.readRsponse(requestHttpExecute(paramContext, URL_ACHIEVEMENT_RELATION_ADD_UPDATE, "POST", paramWeiboParameters));
    StringBuilder stringBuilder = new StringBuilder("Response : ");
    stringBuilder.append(str);
    LogUtil.d("GameManager", stringBuilder.toString());
    return str;
  }
  
  public static String readPlayerAchievementGain(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
    WeiboParameters weiboParameters = new WeiboParameters("");
    if (!TextUtils.isEmpty(paramString1))
      weiboParameters.put("access_token", paramString1); 
    if (!TextUtils.isEmpty(paramString2))
      weiboParameters.put("source", paramString2); 
    if (!TextUtils.isEmpty(paramString3))
      weiboParameters.put("game_id", paramString3); 
    if (!TextUtils.isEmpty(paramString4))
      weiboParameters.put("uid", paramString4); 
    weiboParameters.put("create_time", new Timestamp((new Date()).getTime()));
    String str = HttpManager.readRsponse(requestHttpExecute(paramContext, URL_ACHIEVEMENT_USER_GAIN, "GET", weiboParameters));
    StringBuilder stringBuilder = new StringBuilder("Response : ");
    stringBuilder.append(str);
    LogUtil.d("GameManager", stringBuilder.toString());
    return str;
  }
  
  public static String readPlayerFriendsScoreInfo(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
    WeiboParameters weiboParameters = new WeiboParameters("");
    if (!TextUtils.isEmpty(paramString1))
      weiboParameters.put("access_token", paramString1); 
    if (!TextUtils.isEmpty(paramString2))
      weiboParameters.put("source", paramString2); 
    if (!TextUtils.isEmpty(paramString3))
      weiboParameters.put("game_id", paramString3); 
    if (!TextUtils.isEmpty(paramString4))
      weiboParameters.put("uid", paramString4); 
    weiboParameters.put("create_time", new Timestamp((new Date()).getTime()));
    String str = HttpManager.readRsponse(requestHttpExecute(paramContext, URL_ACHIEVEMENT_READ_PLAYER_FRIENDS, "GET", weiboParameters));
    StringBuilder stringBuilder = new StringBuilder("Response : ");
    stringBuilder.append(str);
    LogUtil.d("GameManager", stringBuilder.toString());
    return str;
  }
  
  public static String readPlayerScoreInfo(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4) {
    WeiboParameters weiboParameters = new WeiboParameters("");
    if (!TextUtils.isEmpty(paramString1))
      weiboParameters.put("access_token", paramString1); 
    if (!TextUtils.isEmpty(paramString2))
      weiboParameters.put("source", paramString2); 
    if (!TextUtils.isEmpty(paramString3))
      weiboParameters.put("game_id", paramString3); 
    if (!TextUtils.isEmpty(paramString4))
      weiboParameters.put("uid", paramString4); 
    String str = HttpManager.readRsponse(requestHttpExecute(paramContext, URL_ACHIEVEMENT_READ_PLAYER_SCORE, "GET", weiboParameters));
    StringBuilder stringBuilder = new StringBuilder("Response : ");
    stringBuilder.append(str);
    LogUtil.d("GameManager", stringBuilder.toString());
    return str;
  }
  
  private static HttpResponse requestHttpExecute(Context paramContext, String paramString1, String paramString2, WeiboParameters paramWeiboParameters) {
    Object object1;
    Object object2;
    IOException iOException1;
    IOException iOException2;
    ByteArrayOutputStream byteArrayOutputStream3 = null;
    ByteArrayOutputStream byteArrayOutputStream4 = null;
    ByteArrayOutputStream byteArrayOutputStream1 = null;
    ByteArrayOutputStream byteArrayOutputStream2 = null;
    paramContext = null;
    try {
      object2 = HttpManager.getNewHttpClient();
      byteArrayOutputStream1 = byteArrayOutputStream3;
    } catch (IOException iOException) {
    
    } finally {
      paramString1 = null;
      object2 = null;
    } 
    try {
      throw new WeiboException(paramString1);
    } finally {
      paramString1 = null;
    } 
    Context context = paramContext;
    if (context != null)
      try {
        context.close();
      } catch (IOException iOException) {} 
    HttpManager.shutdownHttpClient((HttpClient)object2);
    throw paramString1;
  }
  
  public void invatationWeiboFriendsByList(Context paramContext, String paramString1, String paramString2, String paramString3, WeiboAuthListener paramWeiboAuthListener) {
    WeiboParameters weiboParameters = new WeiboParameters(paramString2);
    weiboParameters.put("access_token", paramString1);
    weiboParameters.put("source", paramString2);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(INVITATION_URL.toString()));
    stringBuilder.append(weiboParameters.encodeUrl());
    String str = stringBuilder.toString();
    GameRequestParam gameRequestParam = new GameRequestParam(paramContext);
    gameRequestParam.setAppKey(paramString2);
    gameRequestParam.setToken(paramString1);
    gameRequestParam.setLauncher(BrowserLauncher.GAME);
    gameRequestParam.setUrl(str);
    gameRequestParam.setAuthListener(paramWeiboAuthListener);
    Intent intent = new Intent(paramContext, WeiboSdkBrowser.class);
    Bundle bundle = gameRequestParam.createRequestParamBundle();
    bundle.putString("key_specify_title", paramString3);
    intent.putExtras(bundle);
    paramContext.startActivity(intent);
  }
  
  public void invatationWeiboFriendsInOnePage(Context paramContext, String paramString1, String paramString2, String paramString3, WeiboAuthListener paramWeiboAuthListener, ArrayList<String> paramArrayList) {
    StringBuffer stringBuffer = new StringBuffer();
    if (paramArrayList != null) {
      int i;
      for (i = 0; i < paramArrayList.size(); i++) {
        String str1 = paramArrayList.get(i);
        if (i == 0) {
          stringBuffer.append(str1);
        } else {
          StringBuilder stringBuilder1 = new StringBuilder(",");
          stringBuilder1.append(str1);
          stringBuffer.append(stringBuilder1.toString());
        } 
      } 
    } 
    WeiboParameters weiboParameters = new WeiboParameters(paramString2);
    weiboParameters.put("access_token", paramString1);
    weiboParameters.put("source", paramString2);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(INVITATION_ONE_FRINED_URL.toString()));
    stringBuilder.append(weiboParameters.encodeUrl());
    stringBuilder.append("&uids=");
    stringBuilder.append(stringBuffer.toString());
    String str = stringBuilder.toString();
    GameRequestParam gameRequestParam = new GameRequestParam(paramContext);
    gameRequestParam.setAppKey(paramString2);
    gameRequestParam.setToken(paramString1);
    gameRequestParam.setLauncher(BrowserLauncher.GAME);
    gameRequestParam.setUrl(str);
    gameRequestParam.setAuthListener(paramWeiboAuthListener);
    Intent intent = new Intent(paramContext, WeiboSdkBrowser.class);
    Bundle bundle = gameRequestParam.createRequestParamBundle();
    bundle.putString("key_specify_title", paramString3);
    intent.putExtras(bundle);
    paramContext.startActivity(intent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\component\GameManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */