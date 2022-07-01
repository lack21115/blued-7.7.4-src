package com.soft.blued.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.H5Url;
import com.soft.blued.log.InstantLog;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.BluedTopic;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.group.model.BluedGroupLists;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.ui.share_custom.BaseShareToPlatform;
import com.soft.blued.ui.share_custom.Model.BaseShareEntity;
import com.soft.blued.ui.share_custom.Model.ShareEntity;
import com.soft.blued.ui.share_custom.ShareToPlatform;
import com.soft.blued.user.UserInfo;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class ShareUtils extends ShareCoreUtils {
  private static ShareUtils a;
  
  public static ShareUtils a() {
    if (a == null)
      a = new ShareUtils(); 
    return a;
  }
  
  private void a(Context paramContext, BluedIngSelfFeed paramBluedIngSelfFeed, ShareEntity paramShareEntity, Bitmap paramBitmap) {
    String str;
    paramBitmap = BitmapUtils.a(paramBitmap, BitmapUtils.a(BitmapFactory.decodeResource(paramContext.getResources(), 2131232712), 1.2F));
    if (paramBitmap != null)
      paramShareEntity.fileUrl = BitmapUtils.a(paramBitmap, false); 
    paramShareEntity.netImgUrl = "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500";
    paramShareEntity.title = String.format(paramContext.getResources().getString(2131758769), new Object[] { paramBluedIngSelfFeed.user_name });
    if (StringUtils.e(paramBluedIngSelfFeed.feed_content)) {
      str = paramContext.getResources().getString(2131756443);
    } else {
      str = ((BluedIngSelfFeed)str).feed_content;
    } 
    paramShareEntity.mainBody = str;
    b(paramContext, paramShareEntity);
  }
  
  private void b(Context paramContext, ShareEntity paramShareEntity) {
    (new ShareToPlatform(paramContext, paramShareEntity.shareBackLister, null, null)).b(paramShareEntity);
  }
  
  public ShareEntity a(Context paramContext, String paramString1, View paramView, Bitmap paramBitmap, String paramString2, String paramString3, String paramString4, String paramString5, UserBasicModel paramUserBasicModel) {
    String str;
    ShareEntity shareEntity = new ShareEntity();
    if (StringUtils.e(paramString1)) {
      shareEntity.flag = 0;
      paramString1 = "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500";
    } else {
      shareEntity.flag = 1;
    } 
    if (paramBitmap != null) {
      str = BitmapUtils.a(paramBitmap, false);
    } else {
      str = BitmapUtils.a(BitmapUtils.a(paramView), true);
    } 
    shareEntity.netImgUrl = paramString1;
    shareEntity.fileUrl = str;
    shareEntity.linkUrl = paramString2;
    shareEntity.title = paramString3;
    shareEntity.content = paramString4;
    shareEntity.mainBody = paramString5;
    shareEntity.shareType = 0;
    shareEntity.shareBackLister = null;
    shareEntity.e = -1;
    shareEntity.shareFrom = 1;
    shareEntity.c = paramUserBasicModel;
    shareEntity.m = true;
    return shareEntity;
  }
  
  public ShareEntity a(String paramString1, View paramView, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt) {
    String str1;
    boolean bool;
    boolean bool1 = StringUtils.e(paramString1);
    String str2 = "";
    String str3 = "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500";
    if (!bool1 && paramString1.startsWith("http")) {
      str1 = paramString1;
      bool = true;
      paramString1 = str2;
    } else {
      paramString1 = str2;
      if (str1 != null)
        paramString1 = BitmapUtils.a(BitmapUtils.a((View)str1), true); 
      bool = false;
      str1 = str3;
    } 
    ShareEntity shareEntity = new ShareEntity();
    shareEntity.flag = bool;
    shareEntity.netImgUrl = str1;
    shareEntity.fileUrl = paramString1;
    shareEntity.linkUrl = paramString2;
    shareEntity.title = paramString3;
    shareEntity.content = paramString4;
    shareEntity.mainBody = paramString5;
    shareEntity.shareType = paramInt;
    shareEntity.shareBackLister = null;
    shareEntity.ifHideShareToFeed = false;
    if (shareEntity.shareType == 1) {
      shareEntity.shareFrom = 9;
      return shareEntity;
    } 
    shareEntity.shareFrom = 6;
    return shareEntity;
  }
  
  public String a(Context paramContext, ShareToMsgEntity paramShareToMsgEntity) {
    if (paramShareToMsgEntity != null) {
      switch (paramShareToMsgEntity.share_from) {
        default:
          return "";
        case 12:
          return paramContext.getResources().getString(2131758753);
        case 11:
          return paramContext.getResources().getString(2131758747);
        case 9:
          return paramContext.getResources().getString(2131758750);
        case 6:
        case 7:
          return paramContext.getResources().getString(2131758751);
        case 5:
          return paramContext.getResources().getString(2131758770);
        case 4:
          return paramContext.getResources().getString(2131758758);
        case 3:
          return paramContext.getResources().getString(2131758752);
        case 2:
          return paramContext.getResources().getString(2131758748);
        case 1:
          break;
      } 
      return paramContext.getResources().getString(2131758749);
    } 
    return "";
  }
  
  public void a(Activity paramActivity, int paramInt1, String paramString1, View paramView, Bitmap paramBitmap, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, BluedGroupLists paramBluedGroupLists) {
    String str;
    if (paramBitmap != null) {
      str = BitmapUtils.a(paramBitmap, false);
    } else if (str != null) {
      str = BitmapUtils.a(BitmapUtils.a((View)str), true);
    } else {
      str = "";
    } 
    ShareEntity shareEntity = new ShareEntity();
    shareEntity.flag = paramInt1;
    shareEntity.netImgUrl = paramString1;
    shareEntity.fileUrl = str;
    shareEntity.linkUrl = paramString2;
    shareEntity.title = paramString3;
    shareEntity.content = paramString4;
    shareEntity.mainBody = paramString5;
    shareEntity.shareType = paramInt2;
    shareEntity.shareBackLister = null;
    shareEntity.e = -1;
    shareEntity.shareFrom = 2;
    shareEntity.d = paramBluedGroupLists;
    b((Context)paramActivity, shareEntity);
  }
  
  public void a(Context paramContext, long paramLong, short paramShort, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, ShareToMsgEntity paramShareToMsgEntity, String paramString3, String paramString4) {
    String str = a().a(paramContext, paramShareToMsgEntity);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(str);
    stringBuilder.append(" ");
    stringBuilder.append(paramString3);
    paramString3 = stringBuilder.toString();
    CommonAlertDialog.a(paramContext, paramContext.getResources().getString(2131756931), paramString3, paramContext.getResources().getString(2131758968), new DialogInterface.OnClickListener(this, paramLong, paramShort, paramShareToMsgEntity, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramString4, paramContext) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            ArrayList<String> arrayList1 = new ArrayList();
            ArrayList<String> arrayList2 = new ArrayList();
            arrayList1.add(String.valueOf(this.a));
            arrayList2.add(String.valueOf(this.b));
            if (this.c.share_from != 3) {
              ChatHelperV4.a().a(this.c, this.a, this.b, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k);
            } else {
              LiveMsgSendManager.a().a(this.c.sessionId, arrayList1.<String>toArray(new String[arrayList1.size()]), arrayList2.<String>toArray(new String[arrayList2.size()]), this.c.name);
              AppMethods.a(this.l.getString(2131757179));
            } 
            ((Activity)this.l).finish();
          }
        }paramContext.getResources().getString(2131755726), null, null);
  }
  
  public void a(Context paramContext, View paramView1, View paramView2, Bitmap paramBitmap, BluedIngSelfFeed paramBluedIngSelfFeed, String paramString1, boolean paramBoolean, int paramInt1, String paramString2, int paramInt2, int paramInt3) {
    String str;
    ShareEntity shareEntity = new ShareEntity();
    if (StringUtils.e(paramBluedIngSelfFeed.feed_content)) {
      if (!StringUtils.e(paramBluedIngSelfFeed.is_videos))
        if (paramBluedIngSelfFeed.is_videos.equals("0")) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramBluedIngSelfFeed.user_name);
          stringBuilder1.append(" ");
          stringBuilder1.append(paramContext.getResources().getString(2131756442));
          shareEntity.content = stringBuilder1.toString();
        } else if (paramBluedIngSelfFeed.is_videos.equals("1")) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(paramBluedIngSelfFeed.user_name);
          stringBuilder1.append(" ");
          stringBuilder1.append(paramContext.getResources().getString(2131756443));
          shareEntity.content = stringBuilder1.toString();
        }  
    } else {
      shareEntity.content = StringUtils.a(paramBluedIngSelfFeed.feed_content, true, true, true, "").toString();
    } 
    shareEntity.flag = 1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(EncryptTool.b(paramBluedIngSelfFeed.feed_id));
    if (paramBluedIngSelfFeed.is_ads == 1) {
      str = "&is_ads=1";
    } else {
      str = "";
    } 
    stringBuilder.append(str);
    shareEntity.linkUrl = H5Url.a(27, new Object[] { stringBuilder.toString() });
    shareEntity.shareBackLister = null;
    shareEntity.e = -1;
    shareEntity.a = paramBluedIngSelfFeed;
    shareEntity.shareFrom = 4;
    shareEntity.ifHideRepostToFeed = paramBoolean;
    shareEntity.f = paramInt1;
    shareEntity.g = paramString2;
    shareEntity.h = paramInt2;
    shareEntity.k = true;
    shareEntity.l = paramInt3;
    shareEntity.shareBackLister = new ShareCoreUtils.ShareBackLister(this, paramString1) {
        public void a(String param1String) {
          InstantLog.e(param1String, this.a);
        }
        
        public void b(String param1String) {}
        
        public void c(String param1String) {}
        
        public void d(String param1String) {}
      };
    if (!StringUtils.e(paramBluedIngSelfFeed.is_videos)) {
      shareEntity.shareType = 0;
      if (paramBluedIngSelfFeed.is_videos.equals("0")) {
        if (paramBluedIngSelfFeed.feed_pics != null && paramBluedIngSelfFeed.feed_pics.length > 0) {
          shareEntity.netImgUrl = paramBluedIngSelfFeed.feed_pics[0];
        } else if (!StringUtils.e(paramBluedIngSelfFeed.user_avatar)) {
          shareEntity.netImgUrl = paramBluedIngSelfFeed.user_avatar;
        } else {
          shareEntity.netImgUrl = "";
        } 
        if (paramBitmap != null) {
          shareEntity.fileUrl = BitmapUtils.a(paramBitmap, false);
        } else if (paramView2 != null) {
          shareEntity.fileUrl = BitmapUtils.a(BitmapUtils.a(paramView2), true);
        } 
        if (StringUtils.e(shareEntity.netImgUrl)) {
          shareEntity.flag = 0;
          shareEntity.netImgUrl = "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500";
        } else {
          shareEntity.flag = 1;
        } 
        shareEntity.title = String.format(paramContext.getResources().getString(2131758755), new Object[] { paramBluedIngSelfFeed.user_name });
        if (StringUtils.e(paramBluedIngSelfFeed.feed_content)) {
          str = paramContext.getResources().getString(2131756442);
        } else {
          str = paramBluedIngSelfFeed.feed_content;
        } 
        shareEntity.mainBody = str;
        b(paramContext, shareEntity);
      } else if (paramBluedIngSelfFeed.is_videos.equals("1")) {
        shareEntity.shareType = 2;
        if (paramBluedIngSelfFeed.feed_videos != null && paramBluedIngSelfFeed.feed_videos.length > 0) {
          ImageFileLoader.a(null).b(paramBluedIngSelfFeed.feed_videos[0]).a(new ImageFileLoader.OnLoadFileListener(this, paramContext, paramBluedIngSelfFeed, shareEntity) {
                public void onUIFinish(File param1File, Exception param1Exception) {
                  if (param1File != null && param1File.exists()) {
                    Bitmap bitmap = BitmapFactory.decodeFile(param1File.getPath());
                    ShareUtils.a(this.d, this.a, this.b, this.c, bitmap);
                    return;
                  } 
                  ShareUtils.a(this.d, this.a, this.b, this.c, null);
                }
              }).a();
        } else {
          a(paramContext, paramBluedIngSelfFeed, shareEntity, paramBitmap);
        } 
      } 
    } 
    if (!StringUtils.e(paramBluedIngSelfFeed.share_url))
      FindHttpUtils.a(paramBluedIngSelfFeed.share_url); 
  }
  
  public void a(Context paramContext, BluedIngSelfFeed paramBluedIngSelfFeed, int paramInt) {
    ShareEntity shareEntity = new ShareEntity();
    if (StringUtils.e(paramBluedIngSelfFeed.feed_pure_content)) {
      shareEntity.content = paramContext.getResources().getString(2131755943);
    } else {
      shareEntity.content = StringUtils.a(paramBluedIngSelfFeed.feed_pure_content, true, true, true, "").toString();
      if (!shareEntity.content.isEmpty() && shareEntity.content.length() > 100)
        shareEntity.content = shareEntity.content.substring(0, 100); 
    } 
    shareEntity.flag = 1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(EncryptTool.b(paramBluedIngSelfFeed.circle_id));
    stringBuilder.append("&feedid=");
    stringBuilder.append(EncryptTool.b(paramBluedIngSelfFeed.feed_id));
    shareEntity.linkUrl = H5Url.a(28, new Object[] { stringBuilder.toString() });
    shareEntity.shareBackLister = null;
    shareEntity.e = -1;
    shareEntity.a = paramBluedIngSelfFeed;
    shareEntity.shareFrom = 11;
    shareEntity.l = paramInt;
    shareEntity.o = true;
    shareEntity.ifHideRepostToFeed = false;
    shareEntity.shareType = 0;
    if (paramBluedIngSelfFeed.is_video_posts == 1 && paramBluedIngSelfFeed.feed_videos != null && paramBluedIngSelfFeed.feed_videos.length > 0) {
      shareEntity.netImgUrl = paramBluedIngSelfFeed.feed_videos[0];
    } else if (paramBluedIngSelfFeed.feed_pics != null && paramBluedIngSelfFeed.feed_pics.length > 0) {
      shareEntity.netImgUrl = paramBluedIngSelfFeed.feed_pics[0];
    } else {
      shareEntity.netImgUrl = "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500";
    } 
    shareEntity.title = paramBluedIngSelfFeed.circle_title;
    shareEntity.mainBody = paramContext.getResources().getString(2131755942);
    b(paramContext, shareEntity);
  }
  
  public void a(Context paramContext, BluedTopic paramBluedTopic) {
    String str1;
    ShareEntity shareEntity = new ShareEntity();
    shareEntity.content = "";
    shareEntity.flag = 1;
    shareEntity.linkUrl = H5Url.a(40, new Object[] { paramBluedTopic.super_did });
    shareEntity.shareBackLister = null;
    shareEntity.e = -1;
    shareEntity.b = paramBluedTopic;
    shareEntity.ifHideRepostToFeed = false;
    shareEntity.shareFrom = 10;
    shareEntity.shareType = 0;
    shareEntity.shareBackLister = new ShareCoreUtils.ShareBackLister(this) {
        public void a(String param1String) {}
        
        public void b(String param1String) {}
        
        public void c(String param1String) {}
        
        public void d(String param1String) {}
      };
    shareEntity.netImgUrl = paramBluedTopic.avatar;
    if (StringUtils.e(shareEntity.netImgUrl))
      shareEntity.netImgUrl = "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500"; 
    shareEntity.title = paramBluedTopic.name;
    shareEntity.content = paramBluedTopic.name;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append((UserInfo.a().i()).name);
    stringBuilder.append(paramContext.getResources().getString(2131758772));
    String str2 = stringBuilder.toString();
    if (StringUtils.e(paramBluedTopic.description)) {
      str1 = str2;
    } else {
      str1 = ((BluedTopic)str1).description;
    } 
    shareEntity.mainBody = str1;
    b(paramContext, shareEntity);
  }
  
  public void a(Context paramContext, BaseShareEntity.ShareLiveData paramShareLiveData) {
    String str1;
    String str2;
    if (StringUtils.e(paramShareLiveData.d))
      paramShareLiveData.d = "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500"; 
    if (paramShareLiveData.e != null) {
      str2 = BitmapUtils.a(paramShareLiveData.e, false);
    } else {
      str2 = "";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("https://app.blued.cn/live?id=");
    stringBuilder.append(EncryptTool.b(paramShareLiveData.f));
    String str3 = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramShareLiveData.a);
    stringBuilder.append(" ");
    stringBuilder.append(AppInfo.d().getResources().getString(2131757723));
    stringBuilder.append(paramShareLiveData.c);
    String str4 = stringBuilder.toString();
    Logger.a("drb", new Object[] { "shareLiveData.description = ", paramShareLiveData.j });
    if (TextUtils.isEmpty(paramShareLiveData.b)) {
      int i = (new Random()).nextInt(3);
      if (i == 0) {
        str1 = String.format(paramContext.getString(2131757716), new Object[] { paramShareLiveData.a });
      } else if (i == 1) {
        str1 = String.format(paramContext.getString(2131757718), new Object[] { paramShareLiveData.a });
      } else {
        str1 = String.format(paramContext.getString(2131757717), new Object[] { paramShareLiveData.a });
      } 
    } else {
      str1 = paramShareLiveData.b;
    } 
    ShareEntity shareEntity = new ShareEntity();
    shareEntity.flag = 1;
    shareEntity.netImgUrl = paramShareLiveData.d;
    shareEntity.fileUrl = str2;
    shareEntity.linkUrl = str3;
    shareEntity.title = str4;
    shareEntity.content = str1;
    shareEntity.mainBody = str1;
    shareEntity.shareType = 0;
    shareEntity.platFormName = paramShareLiveData.g;
    shareEntity.i = paramShareLiveData;
    shareEntity.shareFrom = 3;
    shareEntity.n = true;
    BaseShareToPlatform.PopWindowSetting popWindowSetting = new BaseShareToPlatform.PopWindowSetting();
    popWindowSetting.a = true;
    popWindowSetting.b = paramShareLiveData.i;
    if (TextUtils.isEmpty(paramShareLiveData.g)) {
      (new ShareToPlatform(paramContext, paramShareLiveData.k, popWindowSetting, paramShareLiveData.l)).b(shareEntity);
      return;
    } 
    (new ShareToPlatform(paramContext, paramShareLiveData.k, popWindowSetting, paramShareLiveData.l)).a(shareEntity);
  }
  
  public void a(Context paramContext, ShareEntity paramShareEntity) {
    b(paramContext, paramShareEntity);
  }
  
  public void a(Bitmap paramBitmap, long paramLong, Context paramContext, View paramView) {
    String str1;
    boolean bool;
    String str2 = UserInfo.a().i().getAvatar();
    if (StringUtils.e(str2)) {
      str2 = "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500";
      bool = false;
    } else {
      bool = true;
    } 
    if (paramBitmap != null) {
      str1 = BitmapUtils.a(paramBitmap, true);
    } else {
      str1 = "";
    } 
    String str3 = String.format(paramContext.getString(2131757727), new Object[] { UserInfo.a().i().getName() });
    String str4 = String.format(paramContext.getResources().getString(2131757726), new Object[] { UserInfo.a().i().getName() });
    String str5 = H5Url.a(39, new Object[] { EncryptTool.b(String.valueOf(paramLong)) });
    ShareEntity shareEntity = new ShareEntity();
    BaseShareEntity.ShareLiveData shareLiveData = new BaseShareEntity.ShareLiveData();
    shareLiveData.h = String.valueOf(paramLong);
    shareEntity.flag = bool;
    shareEntity.i = shareLiveData;
    shareEntity.netImgUrl = str2;
    shareEntity.fileUrl = str1;
    shareEntity.linkUrl = str5;
    shareEntity.title = str3;
    shareEntity.ifHideShareToPeopleAndGroup = true;
    shareEntity.ifHideShareToFeed = false;
    shareEntity.j = paramView;
    shareEntity.content = str4;
    shareEntity.mainBody = str4;
    shareEntity.shareType = 0;
    shareEntity.shareFrom = 8;
    (new ShareToPlatform(paramContext, null, null, null)).b(shareEntity);
  }
  
  public void b(Context paramContext, BaseShareEntity.ShareLiveData paramShareLiveData) {
    String str1;
    String str2;
    if (StringUtils.e(paramShareLiveData.d))
      paramShareLiveData.d = "http://7vznnm.com2.z0.glb.qiniucdn.com/blued-logo.png-500"; 
    if (paramShareLiveData.e != null) {
      str2 = BitmapUtils.a(paramShareLiveData.e, false);
    } else {
      str2 = "";
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("https://app.blued.cn//chat/live?room_id=");
    stringBuilder.append(paramShareLiveData.h);
    stringBuilder.append("&source_uid=");
    stringBuilder.append(EncryptTool.b(paramShareLiveData.f));
    String str3 = stringBuilder.toString();
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramShareLiveData.a);
    stringBuilder.append(" ");
    stringBuilder.append(AppInfo.d().getResources().getString(2131757723));
    stringBuilder.append(paramShareLiveData.c);
    String str4 = stringBuilder.toString();
    Logger.a("drb", new Object[] { "shareLiveData.description = ", paramShareLiveData.j });
    if (TextUtils.isEmpty(paramShareLiveData.b)) {
      int i = (new Random()).nextInt(3);
      if (i == 0) {
        str1 = String.format(paramContext.getString(2131757716), new Object[] { paramShareLiveData.a });
      } else if (i == 1) {
        str1 = String.format(paramContext.getString(2131757718), new Object[] { paramShareLiveData.a });
      } else {
        str1 = String.format(paramContext.getString(2131757717), new Object[] { paramShareLiveData.a });
      } 
    } else {
      str1 = paramShareLiveData.b;
    } 
    ShareEntity shareEntity = new ShareEntity();
    shareEntity.flag = 1;
    shareEntity.netImgUrl = paramShareLiveData.d;
    shareEntity.fileUrl = str2;
    shareEntity.linkUrl = str3;
    shareEntity.title = str4;
    shareEntity.content = str1;
    shareEntity.mainBody = str1;
    shareEntity.shareType = 0;
    shareEntity.platFormName = paramShareLiveData.g;
    shareEntity.i = paramShareLiveData;
    shareEntity.shareFrom = 12;
    shareEntity.n = true;
    BaseShareToPlatform.PopWindowSetting popWindowSetting = new BaseShareToPlatform.PopWindowSetting();
    popWindowSetting.a = true;
    popWindowSetting.b = paramShareLiveData.i;
    if (TextUtils.isEmpty(paramShareLiveData.g)) {
      (new ShareToPlatform(paramContext, paramShareLiveData.k, popWindowSetting, paramShareLiveData.l)).b(shareEntity);
      return;
    } 
    (new ShareToPlatform(paramContext, paramShareLiveData.k, popWindowSetting, paramShareLiveData.l)).a(shareEntity);
  }
  
  public static interface SHARE_FLAG {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\ShareUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */