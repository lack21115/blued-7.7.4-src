package com.soft.blued.http;

import com.blued.android.framework.urlmanager.HostConfig;
import com.blued.android.framework.urlmanager.UrlFormatUtil;

public final class H5Url {
  private static final String[] a = new String[] { 
      "0/biaoqing%s", "0/liveorders%s", "0/liverank%s", "0/liverank/game%s", "0/hotpk/index%s", "0/liverank/fansdevote%s", "0/livereports/card%s", "0/livereports/card?fromtype=1%s", "0/msg/phone%s", "0/home/user/logout%s", 
      "0/medal%s", "0/app%s", "0/home/article/recharge%s", "0/vip/deadline%s", "0/map%s", "0/user?id=%s", "0/group?id=%s", "0/standpoint?id=%s", "0/redirect?is_sobot=1&usource=%s", "1/redirect?is_sobot=1&usource=%s&uid=%s", 
      "0/term/userterm%s", "0/term/privacyclause%s", "0/term/conductterm%s", "0/term/liveterm%s", "0/user/wealth?uid=%s", "0/home/anchor/level%s", "0/term/groupterm%s", "0/feed?id=%s", "0/post?postid=%s", "0/msg/migrate%s", 
      "0/player/auth?appkey=%s", "0/term/vipprotocol%s", "0/term/vipterm%s", "0/msg/order%s", "0/blued/faq%s", "0/home/fans/huhuan%s", "3/vip/info?id=%s&detail=%s&page_grade=%s&user_grade=%s", "0/home/vip/help%s", "0/msg/order?source=1%s", "0/recordshare?lid=%s", 
      "0/home/user/supertopic?id=%s", "0/home/live/gift%s", "0/home/coupon/intro%s", "1/home/vip/shadow?uid=%s&detail=%s", "0/home/call/serviceprotocol%s", "0/home/call/promotionclaim%s", "0/home/version-info%s", "0/home/anchor/fans%s", "0/livereports/agreement%s", "0/home/call/popularize?uid=%s", 
      "0/msg/phone/addphone/1/?source=1%s", "0/home/lover%s", "1/home/fans/orderdetail?detail=%s&orderid=%s", "0/home/cool/index%s", "0/home/base/rank?circle_id=%s", "0/home/base/hotlist?is_goback=%s", "0/chat/agreement%s", "0/chat/norm%s", "0/home/live/pk%s" };
  
  private static String a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(HostConfig.a("H5"));
    stringBuilder.append("");
    return stringBuilder.toString();
  }
  
  public static String a(int paramInt) {
    return UrlFormatUtil.a(a[paramInt], a(), new Object[0]);
  }
  
  public static String a(int paramInt, Object... paramVarArgs) {
    return UrlFormatUtil.a(a[paramInt], a(), paramVarArgs);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\http\H5Url.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */