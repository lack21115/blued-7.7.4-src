package com.soft.blued.ui.share_custom;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module_share_china.R;
import com.blued.android.share.CallbackListener;
import com.blued.android.share.Constants;
import com.blued.android.share.ShareProvider;
import com.blued.android.share.msg.MsgImage;
import com.blued.android.share.msg.MsgImageText;
import com.blued.android.share.msg.MsgWeixinVideoText;
import com.blued.android.share.qq.QQActivity;
import com.blued.android.share.sina.SinaShareActivity;
import com.soft.blued.customview.PopMenuFromBottom;
import com.soft.blued.customview.PopMenuFromCenter;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.Model.BaseShareEntity;
import com.soft.blued.ui.share_custom.Model.ShareOption;
import com.soft.blued.utils.HttpUtils;
import com.soft.blued.utils.ShareCoreUtils;
import com.soft.blued.wxapi.WXEntryActivity;
import java.util.ArrayList;
import java.util.Map;

public class BaseShareToPlatform {
  private static final String c = BaseShareToPlatform.class.getSimpleName();
  
  protected Context a;
  
  ShareCoreUtils.ShareBackLister b;
  
  private PopMenuFromBottom d;
  
  private View e;
  
  private RecyclerView f;
  
  private RecyclerView g;
  
  private ShareOptionRecyclerAdapter h;
  
  private ShareOptionRecyclerAdapter i;
  
  private BaseShareEntity j;
  
  private String k = "blued";
  
  private ShareOptionRecyclerAdapter.ShareOptionsItemClickListener l;
  
  public BaseShareToPlatform(Context paramContext, ShareCoreUtils.ShareBackLister paramShareBackLister, PopWindowSetting paramPopWindowSetting, ShareOptionRecyclerAdapter.ShareOptionsItemClickListener paramShareOptionsItemClickListener) {
    PopWindowSetting popWindowSetting = paramPopWindowSetting;
    if (paramPopWindowSetting == null)
      popWindowSetting = new PopWindowSetting(); 
    this.a = paramContext;
    this.e = LayoutInflater.from(paramContext).inflate(R.layout.share_common_layout, null);
    a(popWindowSetting.a);
    this.f = (RecyclerView)this.e.findViewById(R.id.lv_platforms);
    this.g = (RecyclerView)this.e.findViewById(R.id.lv_blued);
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.e.findViewById(R.id.ll_all).getLayoutParams();
    if (popWindowSetting.b)
      layoutParams.width = DensityUtils.a(this.a, 355.0F); 
    this.e.findViewById(R.id.ll_all).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    ArrayList<ShareOption> arrayList2 = new ArrayList();
    if (!popWindowSetting.a) {
      arrayList2.add(new ShareOption(R.drawable.icon_share_to_people, R.string.share_to_friends));
      arrayList2.add(new ShareOption(R.drawable.icon_share_to_feed, R.string.common_main_feed));
      arrayList2.add(new ShareOption(R.drawable.icon_share_repost_to_feed, R.string.feed_repost));
    } else {
      arrayList2.add(new ShareOption(R.drawable.icon_share_to_people_dark, R.string.share_to_friends));
      arrayList2.add(new ShareOption(R.drawable.icon_share_to_feed_dark, R.string.common_main_feed));
      arrayList2.add(new ShareOption(R.drawable.icon_share_repost_to_feed_dark, R.string.feed_repost));
    } 
    this.i = new ShareOptionRecyclerAdapter(paramContext, arrayList2, popWindowSetting.a);
    LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.a);
    linearLayoutManager2.setStackFromEnd(true);
    linearLayoutManager2.setOrientation(0);
    linearLayoutManager2.scrollToPosition(0);
    this.g.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager2);
    this.g.setHasFixedSize(true);
    this.g.setAdapter((RecyclerView.Adapter)this.i);
    this.i.notifyDataSetChanged();
    ArrayList<ShareOption> arrayList1 = new ArrayList();
    if (!popWindowSetting.a) {
      arrayList1.add(new ShareOption(R.drawable.icon_share_to_wechat, R.string.ssdk_wechat));
      arrayList1.add(new ShareOption(R.drawable.icon_share_to_wechat_moment, R.string.ssdk_wechatmoments));
      arrayList1.add(new ShareOption(R.drawable.icon_share_to_qq, R.string.ssdk_qq));
      arrayList1.add(new ShareOption(R.drawable.icon_share_to_sina_weibo, R.string.ssdk_sinaweibo));
    } else {
      arrayList1.add(new ShareOption(R.drawable.icon_share_to_wechat_dark, R.string.ssdk_wechat));
      arrayList1.add(new ShareOption(R.drawable.icon_share_to_wechat_moment_dark, R.string.ssdk_wechatmoments));
      arrayList1.add(new ShareOption(R.drawable.icon_share_to_qq_dark, R.string.ssdk_qq));
      arrayList1.add(new ShareOption(R.drawable.icon_share_to_sina_weibo_dark, R.string.ssdk_sinaweibo));
    } 
    this.h = new ShareOptionRecyclerAdapter(paramContext, arrayList1, popWindowSetting.a);
    LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this.a);
    linearLayoutManager1.setStackFromEnd(true);
    linearLayoutManager1.setOrientation(0);
    linearLayoutManager1.scrollToPosition(0);
    this.f.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager1);
    this.f.setHasFixedSize(true);
    this.f.setAdapter((RecyclerView.Adapter)this.h);
    this.h.notifyDataSetChanged();
    this.l = new ShareOptionRecyclerAdapter.ShareOptionsItemClickListener(this, paramShareOptionsItemClickListener, paramShareBackLister, popWindowSetting) {
        public void onItemClick(int param1Int) {
          ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener = this.a;
          if (shareOptionsItemClickListener != null)
            shareOptionsItemClickListener.onItemClick(param1Int); 
          this.d.a(param1Int, this.b, this.c);
        }
      };
    this.h.a(this.l);
    this.i.a(this.l);
    this.b = paramShareBackLister;
    if (popWindowSetting.b) {
      this.d = (PopMenuFromBottom)new PopMenuFromCenter(this.a, this.e);
      return;
    } 
    this.d = new PopMenuFromBottom(this.a, this.e);
  }
  
  private void a() {
    if (this.j.shareFrom == 8) {
      BaseShareEntity baseShareEntity = this.j;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.j.content);
      stringBuilder.append(" ");
      stringBuilder.append(String.format(this.a.getResources().getString(R.string.live_share_enterToPersionPage), new Object[] { "" }));
      baseShareEntity.content = stringBuilder.toString();
      this.j.netImgUrl = "";
    } 
    Intent intent = new Intent(this.a, SinaShareActivity.class);
    if (this.j.shareFrom == 6) {
      intent.putExtra("title", "");
      intent.putExtra("des", this.j.title);
    } else {
      intent.putExtra("title", this.j.title);
      intent.putExtra("des", this.j.content);
    } 
    intent.putExtra("flag", this.j.flag);
    intent.putExtra("imgUrl", this.j.netImgUrl);
    intent.putExtra("linkUrl", this.j.linkUrl);
    intent.putExtra("fileUrl", this.j.fileUrl);
    ShareProvider.getInstance().registerCallback(new ShareCallbackListener(this));
    this.a.startActivity(intent);
  }
  
  private void a(int paramInt) {
    MsgImageText msgImageText = new MsgImageText();
    msgImageText.pType = 2;
    msgImageText.appName = this.k;
    msgImageText.title = this.j.title;
    msgImageText.summary = this.j.mainBody;
    if (this.j.flag == 1) {
      msgImageText.imageUrl = this.j.netImgUrl;
    } else {
      msgImageText.imageUrl = this.j.fileUrl;
    } 
    msgImageText.targetUrl = this.j.linkUrl;
    Intent intent = new Intent(this.a, QQActivity.class);
    intent.putExtra("QQEnetry_jrj_show", (Parcelable)msgImageText);
    if (paramInt == 1) {
      intent.putExtra("type", 1);
    } else {
      intent.putExtra("type", 0);
    } 
    intent.putExtra("flag", this.j.flag);
    ShareProvider.getInstance().registerCallback(new ShareCallbackListener(this));
    this.a.startActivity(intent);
  }
  
  private void a(int paramInt1, int paramInt2) {
    Intent intent = new Intent(this.a, WXEntryActivity.class);
    if (paramInt2 == 2) {
      String str;
      MsgWeixinVideoText msgWeixinVideoText = new MsgWeixinVideoText();
      msgWeixinVideoText.pType = paramInt1;
      if (paramInt1 == 8) {
        str = this.j.title;
      } else {
        str = this.j.content;
      } 
      msgWeixinVideoText.title = str;
      msgWeixinVideoText.summary = this.j.content;
      if (this.j.flag == 1) {
        msgWeixinVideoText.imageUrl = this.j.netImgUrl;
      } else {
        msgWeixinVideoText.imageUrl = this.j.fileUrl;
      } 
      msgWeixinVideoText.targetUrl = this.j.linkUrl;
      intent.putExtra("WXEnetry_jrj_show", (Parcelable)msgWeixinVideoText);
    } else if (paramInt2 == 1) {
      MsgImage msgImage = new MsgImage();
      if (this.j.flag == 1) {
        msgImage.imageUrl = this.j.netImgUrl;
      } else {
        msgImage.imageUrl = this.j.fileUrl;
      } 
      msgImage.pType = paramInt1;
      intent.putExtra("WXEnetry_jrj_show", (Parcelable)msgImage);
    } else {
      MsgImageText msgImageText = new MsgImageText();
      msgImageText.pType = paramInt1;
      if (this.j.shareFrom == 6) {
        msgImageText.title = this.j.title;
      } else {
        String str;
        if (paramInt1 == 8) {
          str = this.j.title;
        } else {
          str = this.j.content;
        } 
        msgImageText.title = str;
      } 
      msgImageText.summary = this.j.content;
      if (this.j.flag == 1) {
        msgImageText.imageUrl = this.j.netImgUrl;
      } else {
        msgImageText.imageUrl = this.j.fileUrl;
      } 
      msgImageText.targetUrl = this.j.linkUrl;
      intent.putExtra("WXEnetry_jrj_show", (Parcelable)msgImageText);
    } 
    intent.putExtra("intent_mode", "intent_mode_share");
    ShareProvider.getInstance().registerCallback(new ShareCallbackListener(this));
    this.a.startActivity(intent);
  }
  
  protected void a(int paramInt, ShareCoreUtils.ShareBackLister paramShareBackLister, PopWindowSetting paramPopWindowSetting) {
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            BaseShareToPlatform.a(this.a).d();
          }
        },  300L);
    ArrayMap<String, String> arrayMap = new ArrayMap();
    if (paramInt == R.string.ssdk_sinaweibo) {
      arrayMap.put("af_adset", "weibo");
      BaseShareEntity baseShareEntity = this.j;
      baseShareEntity.linkUrl = HttpUtils.a((Map)arrayMap, baseShareEntity.linkUrl);
      a();
    } else if (paramInt == R.string.ssdk_wechat) {
      arrayMap.put("af_adset", "wechat");
      BaseShareEntity baseShareEntity = this.j;
      baseShareEntity.linkUrl = HttpUtils.a((Map)arrayMap, baseShareEntity.linkUrl);
      a(8, this.j.shareType);
    } else if (paramInt == R.string.ssdk_wechatmoments) {
      arrayMap.put("af_adset", "wechatmoment");
      BaseShareEntity baseShareEntity = this.j;
      baseShareEntity.linkUrl = HttpUtils.a((Map)arrayMap, baseShareEntity.linkUrl);
      a(16, this.j.shareType);
    } else if (paramInt == R.string.ssdk_qq) {
      arrayMap.put("af_adset", "qq");
      BaseShareEntity baseShareEntity = this.j;
      baseShareEntity.linkUrl = HttpUtils.a((Map)arrayMap, baseShareEntity.linkUrl);
      a(this.j.shareType);
    } 
    Logger.c(c, new Object[] { "mShareEntity.linkUrl platform", this.j.linkUrl });
  }
  
  protected void a(BaseShareEntity paramBaseShareEntity) {
    this.j = paramBaseShareEntity;
    if (this.j.netImgUrl == null)
      this.j.netImgUrl = ""; 
    if (paramBaseShareEntity.fileUrl == null)
      this.j.fileUrl = ""; 
    if (paramBaseShareEntity.ifHideShareToFeed)
      this.i.a(R.string.common_main_feed); 
    if (paramBaseShareEntity.ifHideShareToPeopleAndGroup)
      this.i.a(R.string.share_to_friends); 
    if (paramBaseShareEntity.ifHideRepostToFeed)
      this.i.a(R.string.feed_repost); 
    PopMenuFromBottom popMenuFromBottom = this.d;
    if (popMenuFromBottom != null)
      popMenuFromBottom.e(); 
  }
  
  protected void a(String paramString) {
    ShareCoreUtils.ShareBackLister shareBackLister = this.b;
    if (shareBackLister != null)
      shareBackLister.a(paramString); 
    if (TextUtils.equals(paramString, Constants.SinaWeiboNAME) || TextUtils.equals(paramString, Constants.QQNAME))
      AppMethods.d(R.string.ssdk_oks_share_completed); 
  }
  
  public void a(boolean paramBoolean) {
    ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout)this.e.findViewById(R.id.ll_all);
    TextView textView = (TextView)this.e.findViewById(R.id.tv_cancel);
    if (paramBoolean) {
      ShapeHelper.b((ShapeHelper.ShapeView)shapeLinearLayout, R.color.share_dark_bg);
      textView.setTextColor(this.a.getResources().getColor(R.color.share_dark_text));
      textView.setBackgroundColor(this.a.getResources().getColor(R.color.share_dark_btn));
    } 
  }
  
  protected void b(BaseShareEntity paramBaseShareEntity) {
    this.j = paramBaseShareEntity;
    if (this.j.netImgUrl == null)
      this.j.netImgUrl = ""; 
    if (this.j.fileUrl == null)
      this.j.fileUrl = ""; 
    ArrayMap<String, String> arrayMap = new ArrayMap();
    if (!TextUtils.isEmpty(this.j.platFormName) && this.j.platFormName.equals(Constants.SinaWeiboNAME)) {
      arrayMap.put("af_adset", "weibo");
      BaseShareEntity baseShareEntity = this.j;
      baseShareEntity.linkUrl = HttpUtils.a((Map)arrayMap, baseShareEntity.linkUrl);
      a();
      return;
    } 
    if (!TextUtils.isEmpty(this.j.platFormName) && this.j.platFormName.equals(Constants.WechatNAME)) {
      arrayMap.put("af_adset", "wechat");
      BaseShareEntity baseShareEntity = this.j;
      baseShareEntity.linkUrl = HttpUtils.a((Map)arrayMap, baseShareEntity.linkUrl);
      a(8, this.j.shareType);
      return;
    } 
    if (!TextUtils.isEmpty(this.j.platFormName) && this.j.platFormName.equals(Constants.WechatMomentsNAME)) {
      arrayMap.put("af_adset", "wechatmoment");
      BaseShareEntity baseShareEntity = this.j;
      baseShareEntity.linkUrl = HttpUtils.a((Map)arrayMap, baseShareEntity.linkUrl);
      a(16, this.j.shareType);
      return;
    } 
    if (!TextUtils.isEmpty(this.j.platFormName) && this.j.platFormName.equals(Constants.QQNAME)) {
      arrayMap.put("af_adset", "qq");
      BaseShareEntity baseShareEntity = this.j;
      baseShareEntity.linkUrl = HttpUtils.a((Map)arrayMap, baseShareEntity.linkUrl);
      a(this.j.shareType);
    } 
  }
  
  public static class PopWindowSetting {
    public boolean a = false;
    
    public boolean b = false;
  }
  
  public class ShareCallbackListener implements CallbackListener {
    public ShareCallbackListener(BaseShareToPlatform this$0) {}
    
    public void onCancel(String param1String) {
      if (this.a.b != null)
        this.a.b.c(param1String); 
    }
    
    public void onFailure(String param1String) {
      if (this.a.b != null)
        this.a.b.b(param1String); 
      if (TextUtils.equals(param1String, Constants.SinaWeiboNAME) || TextUtils.equals(param1String, Constants.QQNAME) || TextUtils.equals(param1String, Constants.WechatNAME) || TextUtils.equals(param1String, Constants.WechatMomentsNAME))
        AppMethods.d(R.string.ssdk_oks_share_failed); 
    }
    
    public void onResume(String param1String) {
      if (this.a.b != null)
        this.a.b.d(param1String); 
    }
    
    public void onSuccess(String param1String) {
      this.a.a(param1String);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\share_custom\BaseShareToPlatform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */