package com.soft.blued.http;

import android.text.TextUtils;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedComment;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import java.util.Map;

public class CircleHttpUtils {
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/circles/class");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/users/circle?page=");
    stringBuilder.append(paramInt);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt1, int paramInt2) {
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
    stringBuilder.append("/ticktocks/circle/posts_list");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt1, int paramInt2, IRequestHost paramIRequestHost) {
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
    stringBuilder.append("/ticktocks/users/circle/notice");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt1, int paramInt2, String paramString) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt1);
    stringBuilder2.append("");
    map.put("page", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt2);
    stringBuilder2.append("");
    map.put("size", stringBuilder2.toString());
    map.put("classify_id", paramString);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/ticktocks/circles");
    HttpManager.a(stringBuilder1.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt, String paramString) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt);
    stringBuilder2.append("");
    map.put("page", stringBuilder2.toString());
    map.put("type", paramString);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/ticktocks/my/posting");
    HttpManager.a(stringBuilder1.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/recommend/circles");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, BluedIngSelfFeed paramBluedIngSelfFeed, FeedComment paramFeedComment, String paramString, boolean paramBoolean, int paramInt, IRequestHost paramIRequestHost) {
    String str2;
    String str3;
    if (paramBluedIngSelfFeed == null)
      return; 
    String str4 = "1";
    if (paramFeedComment == null || TextUtils.isEmpty(paramFeedComment.comment_id)) {
      str3 = "0";
    } else {
      str3 = "1";
    } 
    if (paramFeedComment == null) {
      str2 = "";
    } else {
      str2 = ((FeedComment)str2).comment_id;
    } 
    Map<String, String> map2 = BluedHttpTools.a();
    map2.put("text", paramString);
    map2.put("is_reply", str3);
    map2.put("reply_id", str2);
    if (paramBoolean) {
      str2 = str4;
    } else {
      str2 = "0";
    } 
    map2.put("is_anonym", str2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    map2.put("anonym_avatar", stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/");
    stringBuilder.append(paramBluedIngSelfFeed.feed_id);
    stringBuilder.append("/comments");
    String str1 = stringBuilder.toString();
    Map<String, String> map1 = BluedHttpTools.a();
    map1.put("source", "posting");
    if (!TextUtils.isEmpty(paramBluedIngSelfFeed.comments_url))
      FindHttpUtils.a(paramBluedIngSelfFeed.comments_url); 
    HttpManager.b(HttpUtils.a(map1, str1), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map2)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("posting_id", paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/posting/shared");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, null).a(BluedHttpTools.a(map)).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, int paramInt1, int paramInt2, String paramString2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt1);
    stringBuilder2.append("");
    map.put("page", stringBuilder2.toString());
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(paramInt2);
    stringBuilder2.append("");
    map.put("size", stringBuilder2.toString());
    map.put("source", "posting");
    map.put("anchor_comment_id", paramString2);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(BluedHttpUrl.n());
    stringBuilder1.append("/ticktocks/");
    stringBuilder1.append(paramString1);
    stringBuilder1.append("/comments");
    HttpManager.a(stringBuilder1.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, int paramInt, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/");
    stringBuilder.append(paramString);
    stringBuilder.append("/posts_voted/");
    stringBuilder.append((UserInfo.a().i()).uid);
    paramString = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("vote_option", String.valueOf(paramInt));
    HttpManager.b(paramString, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).a(BluedHttpTools.a(map)).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/circle/posts/top");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("tid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).a(BluedHttpTools.a(map)).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, int paramInt1, int paramInt2) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("circle_id", paramString1);
    map.put("type", paramString2);
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
    stringBuilder.append("/ticktocks/circles/list");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    Map<String, String> map1 = BluedHttpTools.a();
    map1.put("tid", paramString2);
    map1.put("uid", paramString1);
    Map<String, String> map2 = BluedHttpTools.a();
    map2.put("source", "posting");
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/");
    stringBuilder.append(paramString2);
    stringBuilder.append("/liked/");
    stringBuilder.append(paramString1);
    stringBuilder.append("?http_method_override=DELETE");
    HttpManager.b(HttpUtils.a(map2, stringBuilder.toString()), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(map1)).i();
  }
  
  public static void a(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    Map<String, String> map1 = BluedHttpTools.a();
    map1.put("tid", paramString2);
    map1.put("uid", paramString1);
    Map<String, String> map2 = BluedHttpTools.a();
    map2.put("source", "posting");
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
  
  public static void a(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/users/circle?http_method_override=PUT");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("circle_id", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).a(BluedHttpTools.a(map)).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(String paramString1, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString2, int paramInt, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("circle_id", paramString1);
    map.put("target_uid", paramString2);
    map.put("is_anonym", String.valueOf(paramInt));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/circle/mute?http_method_override=DELETE");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).a(BluedHttpTools.a(map)).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(String paramString1, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString2, int paramInt, String paramString3, String paramString4, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("circle_id", paramString1);
    map.put("target_uid", paramString2);
    map.put("is_anonym", String.valueOf(paramInt));
    map.put("anonym_name", paramString3);
    map.put("anonym_avatar", paramString4);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/circle/mute?http_method_override=PUT");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).a(BluedHttpTools.a(map)).b(BluedHttpTools.a(true)).i();
  }
  
  public static void a(String paramString1, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("page", paramString2);
    map.put("size", paramString3);
    map.put("circle_id", paramString1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/circle/members");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void a(String paramString1, String paramString2, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/users/circle/apply?http_method_override=PUT");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("circle_id", paramString1);
    map.put("reason", paramString2);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).a(BluedHttpTools.a(map)).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/users/circle?filter=admin&page=");
    stringBuilder.append(paramInt);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/hot/posting");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, int paramInt, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(BluedHttpUrl.n());
    stringBuilder2.append("/ticktocks/users/circle/notice");
    String str = stringBuilder2.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("id", paramString);
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(paramInt);
    stringBuilder1.append("");
    map.put("result", stringBuilder1.toString());
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).a(BluedHttpTools.a(map)).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/circle/posts/top?http_method_override=DELETE");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("tid", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).a(BluedHttpTools.a(map)).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("circle_id", paramString1);
    map.put("uid", paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/users/circle/invitation?http_method_override=PUT");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).a(BluedHttpTools.a(map)).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("circle_id", paramString1);
    map.put("cover", paramString2);
    map.put("description", paramString3);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/circles");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).a(BluedHttpTools.a(map)).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(String paramString, BluedUIHttpResponse paramBluedUIHttpResponse, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/users/circle?http_method_override=DELETE");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("circle_id", paramString);
    HttpManager.b(str, (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).a(BluedHttpTools.a(map)).b(BluedHttpTools.a(true)).i();
  }
  
  public static void b(String paramString1, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("page", paramString2);
    map.put("size", paramString3);
    map.put("circle_id", paramString1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/circle/mute");
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).a(map).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/circles?page=");
    stringBuilder.append(paramInt);
    HttpManager.a(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse).b(BluedHttpTools.a(true)).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("posting_id", paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/circle/posts/essence");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).a(BluedHttpTools.a(map)).b(BluedHttpTools.a(true)).i();
  }
  
  public static void c(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString1, String paramString2, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("circle_id", paramString1);
    map.put("allow_join", paramString2);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/circles");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).a(BluedHttpTools.a(map)).b(BluedHttpTools.a(true)).i();
  }
  
  public static void c(String paramString1, BluedUIHttpResponse paramBluedUIHttpResponse, String paramString2, String paramString3, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("circle_id", paramString1);
    map.put("uid", paramString2);
    map.put("level", paramString3);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/circle/members/setup");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).a(BluedHttpTools.a(map)).b(BluedHttpTools.a(true)).i();
  }
  
  public static void d(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    Map<String, String> map = BluedHttpTools.a();
    map.put("posting_id", paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/circle/posts/essence?http_method_override=DELETE");
    HttpManager.b(stringBuilder.toString(), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).a(BluedHttpTools.a(map)).b(BluedHttpTools.a(true)).i();
  }
  
  public static void e(BluedUIHttpResponse paramBluedUIHttpResponse, String paramString, IRequestHost paramIRequestHost) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(BluedHttpUrl.n());
    stringBuilder.append("/ticktocks/circles/bubble");
    String str = stringBuilder.toString();
    Map<String, String> map = BluedHttpTools.a();
    map.put("circle_id", paramString);
    HttpManager.a(HttpUtils.a(map, str), (HttpResponseHandler)paramBluedUIHttpResponse, paramIRequestHost).b(BluedHttpTools.a(true)).i();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\CircleHttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */