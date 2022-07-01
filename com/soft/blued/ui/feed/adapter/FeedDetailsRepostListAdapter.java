package com.soft.blued.ui.feed.adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.feed.fragment.FeedDetailsFragment;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.model.FeedRepost;
import com.soft.blued.ui.feed.observer.RepostListDataObserver;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;

public class FeedDetailsRepostListAdapter extends BaseQuickAdapter<FeedRepost, BaseViewHolder> implements RepostListDataObserver.IRepostListDataObserver {
  private Context a;
  
  private IRequestHost b;
  
  private String c;
  
  private BluedIngSelfFeed d;
  
  public FeedDetailsRepostListAdapter(Context paramContext, IRequestHost paramIRequestHost, String paramString) {
    super(2131493520);
    this.a = paramContext;
    this.b = paramIRequestHost;
    this.c = paramString;
  }
  
  private void a(View paramView, FeedRepost paramFeedRepost) {
    paramView.setOnLongClickListener(new View.OnLongClickListener(this, paramFeedRepost) {
          public boolean onLongClick(View param1View) {
            String str = this.a.repost_content;
            if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT != 18) {
              ((ClipboardManager)FeedDetailsRepostListAdapter.a(this.b).getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", RegExpUtils.a(str)));
            } else {
              ((ClipboardManager)FeedDetailsRepostListAdapter.a(this.b).getSystemService("clipboard")).setText(RegExpUtils.a(str));
            } 
            AppMethods.a(FeedDetailsRepostListAdapter.a(this.b).getResources().getString(2131756130));
            return true;
          }
        });
  }
  
  public void a() {
    RepostListDataObserver.b().a(this);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, FeedRepost paramFeedRepost) {
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297362);
    TextView textView3 = (TextView)paramBaseViewHolder.d(2131300267);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131299358);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131296838);
    ImageView imageView3 = (ImageView)paramBaseViewHolder.d(2131297575);
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297581);
    UserRelationshipUtils.a(imageView3, paramFeedRepost.vbadge, 3);
    ImageLoader.a(this.b, AvatarUtils.a(1, paramFeedRepost.user_avatar)).c().a(2131234356).a(imageView1);
    if (!TextUtils.isEmpty(paramFeedRepost.repost_timestamp)) {
      textView3.setText(TimeAndDateUtils.g(this.a, TimeAndDateUtils.b(paramFeedRepost.repost_timestamp)));
    } else {
      textView3.setText("");
    } 
    if (!StringUtils.e(paramFeedRepost.user_name)) {
      if (!StringUtils.e(paramFeedRepost.note)) {
        textView1.setText(StringUtils.a(paramFeedRepost.note, paramFeedRepost.user_name.replace(":", "")));
      } else {
        textView1.setText(paramFeedRepost.user_name.replace(":", ""));
      } 
    } else {
      textView1.setText("");
    } 
    UserBasicModel userBasicModel = new UserBasicModel();
    userBasicModel.vip_grade = paramFeedRepost.vip_grade;
    userBasicModel.is_vip_annual = paramFeedRepost.is_vip_annual;
    userBasicModel.is_hide_vip_look = paramFeedRepost.is_hide_vip_look;
    userBasicModel.vip_exp_lvl = paramFeedRepost.vip_exp_lvl;
    UserRelationshipUtils.a(this.a, textView1, userBasicModel);
    UserRelationshipUtils.a(imageView2, userBasicModel);
    textView1.setOnClickListener(new View.OnClickListener(this, paramFeedRepost, imageView1) {
          public void onClick(View param1View) {
            if (!this.a.repost_uid.equals(UserInfo.a().i().getUid())) {
              UserBasicModel userBasicModel = new UserBasicModel();
              userBasicModel.uid = this.a.repost_uid;
              userBasicModel.avatar = this.a.user_avatar;
              userBasicModel.name = this.a.user_name;
              UserInfoFragmentNew.a(FeedDetailsRepostListAdapter.a(this.c), userBasicModel, FeedDetailsRepostListAdapter.b(this.c), (View)this.b);
            } 
          }
        });
    imageView1.setOnClickListener(new View.OnClickListener(this, paramFeedRepost, imageView1) {
          public void onClick(View param1View) {
            if (!this.a.repost_uid.equals(UserInfo.a().i().getUid())) {
              UserBasicModel userBasicModel = new UserBasicModel();
              userBasicModel.uid = this.a.repost_uid;
              userBasicModel.avatar = this.a.user_avatar;
              userBasicModel.name = this.a.user_name;
              UserInfoFragmentNew.a(FeedDetailsRepostListAdapter.a(this.c), userBasicModel, FeedDetailsRepostListAdapter.b(this.c), (View)this.b);
            } 
          }
        });
    TypefaceUtils.a(textView2, paramFeedRepost.repost_content, true, this.c);
    a(paramBaseViewHolder.z(), paramFeedRepost);
    paramBaseViewHolder.z().setOnClickListener(new View.OnClickListener(this, paramFeedRepost) {
          public void onClick(View param1View) {
            BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
            bluedIngSelfFeed.feed_id = this.a.repost_id;
            FeedDetailsFragment.a(FeedDetailsRepostListAdapter.a(this.b), bluedIngSelfFeed, -1, 0);
          }
        });
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed) {
    this.d = paramBluedIngSelfFeed;
  }
  
  public void a(FeedRepost paramFeedRepost) {
    if (paramFeedRepost != null) {
      BluedIngSelfFeed bluedIngSelfFeed = this.d;
      if (bluedIngSelfFeed != null && !TextUtils.isEmpty(bluedIngSelfFeed.feed_id) && this.d.feed_id.equals(paramFeedRepost.feed_id)) {
        if (StringUtils.e(paramFeedRepost.repost_content))
          paramFeedRepost.repost_content = this.a.getResources().getString(2131756406); 
        this.n.add(0, paramFeedRepost);
        notifyDataSetChanged();
      } 
    } 
  }
  
  public void b() {
    RepostListDataObserver.b().b(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\FeedDetailsRepostListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */