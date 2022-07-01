package com.soft.blued.http;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.google.gson.JsonParser;
import com.soft.blued.db.model.NewFeedModel;
import com.soft.blued.ui.feed.adapter.MyTopicAdapter;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.ui.feed.model.FeedExtra;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.net.URLEncoder;
import java.util.Map;

public class FeedHttpUtils {
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/qiniu?filter=token&action=ticktocks");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt1, int paramInt2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append("");
    map.put("page", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt2);
    stringBuilder.append("");
    map.put("size", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/super_topics/list");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/circles?filter=explore");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, int paramInt1, int paramInt2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append("");
    map.put("page", stringBuilder.toString());
    paramInt1 = paramInt2;
    if (paramInt2 == 0)
      paramInt1 = 20; 
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append("");
    map.put("size", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/");
    stringBuilder.append(paramString);
    stringBuilder.append("/comments/hot");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("contents", paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/feedback");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost, boolean paramBoolean) {
    String str;
    Map<String, String> map = BluedHttpTools.a();
    if (paramBoolean) {
      str = "ticktock";
    } else {
      str = "posting";
    } 
    map.put("source", str);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/");
    stringBuilder.append(paramString);
    stringBuilder.append("?http_method_override=DELETE");
    HttpManager.b(HttpUtils.a(map, stringBuilder.toString()), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3, String paramString4, String paramString5, int paramInt4, String paramString6, String paramString7, int paramInt5) {
    Map<String, String> map1 = BluedHttpTools.b();
    map1.put("contents", paramString2);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt1);
    stringBuilder1.append("");
    map1.put("allow_comments", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt2);
    stringBuilder1.append("");
    map1.put("reading_scope", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt4);
    stringBuilder1.append("");
    map1.put("is_super_topics", stringBuilder1.toString());
    map1.put("super_did", paramString6);
    map1.put("share_circle_posting_id", paramString7);
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt5);
    stringBuilder1.append("");
    map1.put("repost_also_comment", stringBuilder1.toString());
    Map<String, String> map2 = BluedHttpTools.a();
    if (paramInt3 != 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramInt3);
      stringBuilder.append("");
      map2.put("is_ads", stringBuilder.toString());
    } 
    map1.put("location", paramString3);
    map1.put("location_lot", paramString4);
    map1.put("location_lat", paramString5);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(BluedHttpUrl.n());
    stringBuilder2.append("/ticktocks/");
    stringBuilder2.append(paramString1);
    stringBuilder2.append("/repost");
    HttpManager.b(HttpUtils.a(map2, stringBuilder2.toString()), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map1)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, int paramInt, IRequestHost paramIRequestHost) {
    Map<String, String> map1 = BluedHttpTools.a();
    map1.put("tid", paramString2);
    map1.put("uid", paramString1);
    if (paramInt != 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramInt);
      stringBuilder1.append("");
      map1.put("is_ads", stringBuilder1.toString());
    } 
    Map<String, String> map2 = BluedHttpTools.a();
    map2.put("source", "ticktock");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/");
    stringBuilder.append(paramString2);
    stringBuilder.append("/liked/");
    stringBuilder.append(paramString1);
    stringBuilder.append("?http_method_override=DELETE");
    HttpManager.b(HttpUtils.a(map2, stringBuilder.toString()), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map1)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, int paramInt, String paramString3, IRequestHost paramIRequestHost) {
    Map<String, String> map1 = BluedHttpTools.a();
    map1.put("tid", paramString2);
    map1.put("uid", paramString1);
    if (paramInt != 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramInt);
      stringBuilder1.append("");
      map1.put("is_ads", stringBuilder1.toString());
    } 
    Map<String, String> map2 = BluedHttpTools.a();
    map2.put("source", "ticktock");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/");
    stringBuilder.append(paramString2);
    stringBuilder.append("/liked/");
    stringBuilder.append(paramString1);
    paramString1 = HttpUtils.a(map2, stringBuilder.toString());
    if (!StringUtils.e(paramString3))
      FindHttpUtils.a(paramString3); 
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map1)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/objectionable/ticktocks/");
    stringBuilder.append(paramString1);
    paramString1 = stringBuilder.toString();
    map.put("reason", paramString2);
    HttpManager.b(paramString1, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, int paramInt, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("page", paramString2);
    map.put("size", paramString3);
    if (paramInt != 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramInt);
      stringBuilder1.append("");
      map.put("is_ads", stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/repost");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("tid", paramString1);
    map.put("page", paramString2);
    map.put("size", paramString3);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/recommend/");
    stringBuilder.append(paramString1);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, IRequestHost paramIRequestHost) {
    String str = paramString1;
    try {
      if (!StringUtils.e(paramString1))
        str = URLEncoder.encode(paramString1); 
    } catch (Exception exception) {
      str = "";
    } 
    Map<String, String> map = BluedHttpTools.a();
    map.put("filter", paramString3);
    map.put("page", paramString4);
    map.put("size", paramString5);
    if (!TextUtils.isEmpty(str))
      map.put("name", str); 
    if (!TextUtils.isEmpty(paramString2))
      map.put("super_did", paramString2); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/super_topics");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).a(map).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, IRequestHost paramIRequestHost) {
    a(paramContext, paramBluedUIHttpResponse, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, "", paramIRequestHost);
  }
  
  public static void a(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("filter", paramString2);
    map.put("page", paramString3);
    map.put("size", paramString4);
    map.put("lot", paramString5);
    map.put("lat", paramString6);
    map.put("distance", paramString7);
    if (!StringUtils.e(paramString8))
      map.put("exclude_id", paramString8); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/users/");
    stringBuilder.append(paramString1);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt1, int paramInt2, String paramString, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt1);
    stringBuilder2.append("");
    map.put("page", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt2);
    stringBuilder2.append("");
    map.put("size", stringBuilder2.toString());
    map.put("q", URLEncoder.encode(paramString));
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/ticktocks/super_topics/search");
    HttpManager.a(stringBuilder1.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/live/feed/followed-onair-list?page=");
    stringBuilder.append(paramInt);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/super_topics/outside");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, NewFeedModel paramNewFeedModel, String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString3, String paramString4, double paramDouble) {
    String[] arrayOfString;
    Map<String, String> map = BluedHttpTools.b();
    map.put("os", paramString1);
    map.put("phone", paramString2);
    map.put("duration", String.valueOf(paramDouble));
    map.put("text", paramNewFeedModel.getContent());
    map.put("pics", (String)paramArrayOfString1);
    map.put("videos", (String)paramArrayOfString2);
    map.put("width", paramString3);
    map.put("height", paramString4);
    map.put("location_lot", paramNewFeedModel.getLng());
    map.put("location_lat", paramNewFeedModel.getLat());
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramNewFeedModel.allow_comments);
    stringBuilder3.append("");
    map.put("allow_comments", stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramNewFeedModel.reading_scope);
    stringBuilder3.append("");
    map.put("reading_scope", stringBuilder3.toString());
    map.put("location", paramNewFeedModel.address);
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramNewFeedModel.is_vote);
    stringBuilder3.append("");
    map.put("is_vote", stringBuilder3.toString());
    stringBuilder3 = new StringBuilder();
    stringBuilder3.append(paramNewFeedModel.is_super_topics);
    stringBuilder3.append("");
    map.put("is_super_topics", stringBuilder3.toString());
    map.put("super_did", paramNewFeedModel.super_did);
    map.put("super_topics_avatar", paramNewFeedModel.super_topics_avatar);
    map.put("super_topics_name", paramNewFeedModel.super_topics_name);
    map.put("is_share_super_topics", Integer.valueOf(paramNewFeedModel.is_share_super_topics));
    map.put("share_s_t_did", paramNewFeedModel.share_s_t_did);
    map.put("circle_id", paramNewFeedModel.circle_id);
    map.put("is_posts_vote", Integer.valueOf(paramNewFeedModel.is_posts_vote));
    map.put("posts_vote_title", paramNewFeedModel.posts_vote_title);
    if (TextUtils.isEmpty(paramNewFeedModel.option)) {
      String str = "";
    } else {
      arrayOfString = paramNewFeedModel.option.split(";");
    } 
    map.put("option", (String)arrayOfString);
    map.put("share_circle_posting_id", paramNewFeedModel.share_posting_id);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramNewFeedModel.is_join_circle);
    stringBuilder2.append("");
    map.put("is_join_circle", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramNewFeedModel.join_circle_id);
    stringBuilder2.append("");
    map.put("join_circle_id", stringBuilder2.toString());
    map.put("join_circle_title", paramNewFeedModel.join_circle_title);
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramNewFeedModel.repost_also_comment);
    stringBuilder2.append("");
    map.put("repost_also_comment", stringBuilder2.toString());
    if (!TextUtils.isEmpty(paramNewFeedModel.music_id))
      map.put("music_id", paramNewFeedModel.music_id); 
    map.put("is_anonym", Integer.valueOf(paramNewFeedModel.is_anonym));
    map.put("anonym_comment", Integer.valueOf(paramNewFeedModel.anonym_comment));
    map.put("anonym_avatar", Integer.valueOf(paramNewFeedModel.anonym_avatar));
    if (!StringUtils.e(paramNewFeedModel.extraJSON)) {
      if (!TextUtils.isEmpty(((FeedExtra)AppInfo.f().fromJson(paramNewFeedModel.extraJSON, FeedExtra.class)).url))
        map.put("is_url", "1"); 
      map.put("extras", (new JsonParser()).parse(paramNewFeedModel.extraJSON));
    } 
    if (paramArrayOfString2 != null && paramArrayOfString2.length > 0) {
      map.put("is_catch", "1");
    } else {
      map.put("is_catch", "0");
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/ticktocks/me");
    HttpManager.b(stringBuilder1.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, MyTopicAdapter.MY_TOPIC_PAGE paramMY_TOPIC_PAGE, int paramInt1, int paramInt2, IRequestHost paramIRequestHost) {
    String str;
    if (paramMY_TOPIC_PAGE == MyTopicAdapter.MY_TOPIC_PAGE.a) {
      str = "created";
    } else {
      str = "joined";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/super_topics/recorded?filter=");
    stringBuilder.append(str);
    stringBuilder.append("&page=");
    stringBuilder.append(paramInt1);
    stringBuilder.append("&size=");
    stringBuilder.append(paramInt2);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, BluedIngSelfFeed paramBluedIngSelfFeed, FeedComment paramFeedComment, String paramString, IRequestHost paramIRequestHost) {
    int i;
    String str2;
    String str3;
    if (paramBluedIngSelfFeed == null)
      return; 
    if (paramFeedComment == null || TextUtils.isEmpty(paramFeedComment.comment_id)) {
      str2 = "0";
    } else {
      str2 = "1";
    } 
    if (paramFeedComment == null) {
      str3 = "";
    } else {
      str3 = paramFeedComment.comment_id;
    } 
    if (paramFeedComment == null) {
      i = paramBluedIngSelfFeed.is_ads;
    } else {
      i = paramFeedComment.is_ads;
    } 
    Map<String, String> map1 = BluedHttpTools.a();
    map1.put("text", paramString);
    map1.put("is_reply", str2);
    map1.put("reply_id", str3);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/");
    stringBuilder.append(paramBluedIngSelfFeed.feed_id);
    stringBuilder.append("/comments");
    String str1 = stringBuilder.toString();
    Map<String, String> map2 = BluedHttpTools.a();
    if (i != 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(i);
      stringBuilder1.append("");
      map2.put("is_ads", stringBuilder1.toString());
    } 
    map2.put("source", "ticktock");
    if (!TextUtils.isEmpty(paramBluedIngSelfFeed.comments_url))
      FindHttpUtils.a(paramBluedIngSelfFeed.comments_url); 
    HttpManager.b(HttpUtils.a(map2, str1), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map1)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, int paramInt1, int paramInt2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/catch/music/");
    stringBuilder.append(paramString);
    stringBuilder.append("/detail?size=");
    stringBuilder.append(paramInt2);
    stringBuilder.append("&page=");
    stringBuilder.append(paramInt1);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/");
    stringBuilder.append(paramString);
    stringBuilder.append("/stickypost");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, int paramInt1, int paramInt2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/catch/music/star/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/own?size=");
    stringBuilder.append(paramInt2);
    stringBuilder.append("&page=");
    stringBuilder.append(paramInt1);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/waterfall/");
    stringBuilder.append(paramString3);
    paramString3 = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("page", paramString1);
    map.put("size", paramString2);
    HttpManager.a(paramString3, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("page", paramString2);
    map.put("size", paramString3);
    map.put("source", "ticktock");
    map.put("anchor_comment_id", paramString4);
    if (paramInt != 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramInt);
      stringBuilder1.append("");
      map.put("is_ads", stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/comments");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, boolean paramBoolean, IRequestHost paramIRequestHost) {
    String str;
    Map<String, String> map = BluedHttpTools.a();
    if (paramBoolean) {
      str = "a";
    } else {
      str = "b";
    } 
    map.put("vote_option", str);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/voted/");
    stringBuilder.append(paramString2);
    stringBuilder.append("?is_ads=0");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String[] paramArrayOfString, boolean paramBoolean) {
    Map<String, String> map2 = BluedHttpTools.b();
    map2.put("text", paramString2);
    paramString2 = "0";
    map2.put("is_reply", "0");
    map2.put("reply_id", "");
    map2.put("pics", (String)paramArrayOfString);
    if (paramBoolean)
      paramString2 = "1"; 
    map2.put("is_anonym", paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/comments");
    paramString1 = stringBuilder.toString();
    Map<String, String> map1 = BluedHttpTools.a();
    map1.put("source", "posting");
    HttpManager.b(HttpUtils.a(map1, paramString1), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map2)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, boolean paramBoolean, String paramString1, String paramString2, int paramInt, IRequestHost paramIRequestHost) {
    if (!StringUtils.e(paramString1) && !StringUtils.e(paramString2)) {
      Map<String, String> map1 = BluedHttpTools.a();
      map1.put("cid", paramString2);
      Map<String, String> map2 = BluedHttpTools.a();
      if (paramBoolean) {
        paramString2 = "ticktock";
      } else {
        paramString2 = "posting";
      } 
      map2.put("source", paramString2);
      if (paramInt != 0) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(paramInt);
        stringBuilder1.append("");
        map2.put("is_ads", stringBuilder1.toString());
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(BluedHttpUrl.n());
      stringBuilder.append("/ticktocks/");
      stringBuilder.append(paramString1);
      stringBuilder.append("/comments?http_method_override=DELETE");
      HttpManager.b(HttpUtils.a(map2, stringBuilder.toString()), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map1)).i();
    } 
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("page", paramString2);
    map.put("size", paramString3);
    if (paramBoolean) {
      paramString2 = "ticktock";
    } else {
      paramString2 = "posting";
    } 
    map.put("source", paramString2);
    map.put("anchor_comment_id", paramString4);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/comments/");
    stringBuilder.append(paramString1);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(String paramString, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    map.put("allow_comments", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/");
    stringBuilder.append(paramString);
    stringBuilder.append("?http_method_override=PUT");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost, boolean paramBoolean) {
    Map map = BluedHttpTools.a();
    if (paramInt == 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(BluedHttpUrl.n());
      stringBuilder.append("/ticktocks/");
      stringBuilder.append(paramString1);
      stringBuilder.append("/comments/");
      stringBuilder.append(paramString2);
      stringBuilder.append("?http_method_override=DELETE");
      paramString1 = stringBuilder.toString();
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(BluedHttpUrl.n());
      stringBuilder.append("/ticktocks/");
      stringBuilder.append(paramString1);
      stringBuilder.append("/comments/");
      stringBuilder.append(paramString2);
      paramString1 = stringBuilder.toString();
    } 
    Map<String, String> map1 = BluedHttpTools.a();
    if (paramBoolean) {
      paramString2 = "ticktock";
    } else {
      paramString2 = "posting";
    } 
    map1.put("source", paramString2);
    HttpManager.b(HttpUtils.a(map1, paramString1), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void b(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/blued/qiniu?filter=token&action=videos&ops=ticktocks");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/super_topics/top");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/super_topics?filter=list&page=");
    stringBuilder.append(paramString1);
    stringBuilder.append("&size=");
    stringBuilder.append(paramString2);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, int paramInt, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("page", paramString2);
    map.put("size", paramString3);
    if (paramInt != 0) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(paramInt);
      stringBuilder1.append("");
      map.put("is_ads", stringBuilder1.toString());
    } 
    map.put("source", "ticktock");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/");
    stringBuilder.append(paramString1);
    stringBuilder.append("/liked");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/users/operate_re");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/");
    stringBuilder.append(paramString);
    stringBuilder.append("/stickypost?http_method_override=DELETE");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(String paramString, int paramInt, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    map.put("reading_scope", stringBuilder2.toString());
    map.put("tid", paramString);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/ticktocks/scope?http_method_override=PUT");
    HttpManager.b(stringBuilder1.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map)).i();
  }
  
  public static void c(Context paramContext, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    a(paramContext, paramBluedUIHttpResponse, UserInfo.a().i().getUid(), "handsome", paramString1, paramString2, BluedPreferences.s(), BluedPreferences.t(), "", "", paramIRequestHost);
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/super_topics/exist?name=");
    stringBuilder.append(paramString);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void d(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/super_topics/recorded?http_method_override=DELETE&filter=joined");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("super_did", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).a(BluedHttpTools.a(map)).b(BluedHttpTools.a(true)).i();
  }
  
  public static void e(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/catch/music/");
    stringBuilder.append(paramString);
    stringBuilder.append("/star?http_method_override=POST");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void f(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/catch/music/");
    stringBuilder.append(paramString);
    stringBuilder.append("/star?http_method_override=DELETE");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\FeedHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */