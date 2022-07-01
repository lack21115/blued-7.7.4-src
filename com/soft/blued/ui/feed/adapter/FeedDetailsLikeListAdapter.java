package com.soft.blued.ui.feed.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.feed.observer.LikeListDataObserver;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.find.observer.UserInfoDataObserver;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.views.FollowStatusView;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;

public class FeedDetailsLikeListAdapter extends BaseQuickAdapter<BluedRecommendUsers, BaseViewHolder> implements LikeListDataObserver.ILikeListDataObserver {
  private Context a;
  
  private IRequestHost b;
  
  private Dialog c;
  
  private String d;
  
  private BluedIngSelfFeed e;
  
  public FeedDetailsLikeListAdapter(Context paramContext, IRequestHost paramIRequestHost, String paramString) {
    super(2131493381);
    this.b = paramIRequestHost;
    this.a = paramContext;
    this.c = DialogUtils.a(paramContext);
    this.d = paramString;
  }
  
  private void a(BluedRecommendUsers paramBluedRecommendUsers) {
    UserHttpUtils.b(this.a, new UserRelationshipUtils.IAddOrRemoveAttentionDone(this, paramBluedRecommendUsers) {
          public void a() {
            DialogUtils.a(FeedDetailsLikeListAdapter.c(this.b));
          }
          
          public void a(String param1String) {
            UserInfo.a().i().setAttentionCount(1);
            UserInfoDataObserver.a().b();
            this.a.relationship = param1String;
            LiveEventBus.get("feed_relation_ship").post(this.a);
            this.b.notifyDataSetChanged();
          }
          
          public void b() {
            DialogUtils.b(FeedDetailsLikeListAdapter.c(this.b));
          }
          
          public void b(String param1String) {}
          
          public void c() {
            DialogUtils.b(FeedDetailsLikeListAdapter.c(this.b));
          }
        }paramBluedRecommendUsers.uid, "", this.b);
  }
  
  private void b(BluedRecommendUsers paramBluedRecommendUsers) {
    Context context = this.a;
    CommonAlertDialog.a(context, context.getResources().getString(2131756094), this.a.getResources().getString(2131755729), this.a.getResources().getString(2131756086), new DialogInterface.OnClickListener(this, paramBluedRecommendUsers) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            UserHttpUtils.a(FeedDetailsLikeListAdapter.a(this.b), new UserRelationshipUtils.IAddOrRemoveAttentionDone(this) {
                  public void a() {
                    DialogUtils.a(FeedDetailsLikeListAdapter.c(this.a.b));
                  }
                  
                  public void a(String param2String) {}
                  
                  public void b() {
                    DialogUtils.b(FeedDetailsLikeListAdapter.c(this.a.b));
                  }
                  
                  public void b(String param2String) {
                    UserInfoDataObserver.a().b();
                    UserInfo.a().i().setAttentionCount(-1);
                    this.a.a.relationship = param2String;
                    LiveEventBus.get("feed_relation_ship").post(this.a.a);
                    this.a.b.notifyDataSetChanged();
                  }
                  
                  public void c() {
                    DialogUtils.b(FeedDetailsLikeListAdapter.c(this.a.b));
                  }
                },  this.a.uid, "", FeedDetailsLikeListAdapter.d(this.b));
          }
        }null, null, null);
  }
  
  public void a() {
    LikeListDataObserver.a().a(this);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, BluedRecommendUsers paramBluedRecommendUsers) {
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297362);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131299164);
    TextView textView5 = (TextView)paramBaseViewHolder.d(2131299358);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131296426);
    TextView textView3 = (TextView)paramBaseViewHolder.d(2131297368);
    TextView textView4 = (TextView)paramBaseViewHolder.d(2131301755);
    TextView textView6 = (TextView)paramBaseViewHolder.d(2131299744);
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297575);
    ImageView imageView3 = (ImageView)paramBaseViewHolder.d(2131297581);
    FollowStatusView followStatusView = (FollowStatusView)paramBaseViewHolder.d(2131297199);
    UserRelationshipUtils.a(imageView2, paramBluedRecommendUsers.vbadge, 3);
    ImageLoader.a(this.b, AvatarUtils.a(0, paramBluedRecommendUsers.avatar)).c().a(2131234356).a(imageView1);
    UserRelationshipUtils.a(this.a, textView6, paramBluedRecommendUsers.role);
    if (!TextUtils.isEmpty(paramBluedRecommendUsers.note)) {
      textView5.setText(paramBluedRecommendUsers.note);
    } else if (!TextUtils.isEmpty(paramBluedRecommendUsers.name)) {
      textView5.setText(paramBluedRecommendUsers.name);
    } else {
      textView5.setText("");
    } 
    UserRelationshipUtils.a(this.a, textView5, (UserBasicModel)paramBluedRecommendUsers);
    UserRelationshipUtils.a(imageView3, (UserBasicModel)paramBluedRecommendUsers);
    if (!TextUtils.isEmpty(paramBluedRecommendUsers.age)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramBluedRecommendUsers.age);
      stringBuilder.append(this.a.getResources().getString(2131755267));
      textView2.setText(stringBuilder.toString());
    } else {
      textView2.setText("");
    } 
    if (!TextUtils.isEmpty(paramBluedRecommendUsers.height)) {
      if (BlueAppLocal.d()) {
        textView3.setText(StringUtils.a(paramBluedRecommendUsers.height, BlueAppLocal.c(), false));
      } else {
        textView3.setText(StringUtils.a(paramBluedRecommendUsers.height, BlueAppLocal.c(), true));
      } 
    } else {
      textView3.setText("");
    } 
    if (!TextUtils.isEmpty(paramBluedRecommendUsers.weight)) {
      if (BlueAppLocal.d()) {
        textView4.setText(StringUtils.b(paramBluedRecommendUsers.weight, BlueAppLocal.c(), false));
      } else {
        textView4.setText(StringUtils.b(paramBluedRecommendUsers.weight, BlueAppLocal.c(), true));
      } 
    } else {
      textView4.setText("");
    } 
    if (!TextUtils.isEmpty(paramBluedRecommendUsers.location)) {
      textView1.setText(paramBluedRecommendUsers.location);
    } else {
      textView1.setText("");
    } 
    TypefaceUtils.b(this.a, textView1, paramBluedRecommendUsers.is_hide_city_settled, 1);
    if (paramBluedRecommendUsers.uid.equals(UserInfo.a().i().getUid())) {
      followStatusView.setVisibility(8);
    } else {
      followStatusView.setVisibility(0);
    } 
    followStatusView.setRelationShip(paramBluedRecommendUsers.relationship);
    followStatusView.setOnClickListener(new View.OnClickListener(this, paramBluedRecommendUsers) {
          public void onClick(View param1View) {
            if (!TextUtils.isEmpty(this.a.relationship) && (this.a.relationship.equals("1") || this.a.relationship.equals("3"))) {
              FeedDetailsLikeListAdapter.a(this.b, this.a);
              return;
            } 
            FeedDetailsLikeListAdapter.b(this.b, this.a);
          }
        });
    paramBaseViewHolder.z().setOnClickListener(new View.OnClickListener(this, paramBluedRecommendUsers, imageView1) {
          public void onClick(View param1View) {
            UserInfoFragmentNew.a(FeedDetailsLikeListAdapter.a(this.c), (UserBasicModel)this.a, FeedDetailsLikeListAdapter.b(this.c), (View)this.b);
          }
        });
  }
  
  public void a(BluedIngSelfFeed paramBluedIngSelfFeed) {
    this.e = paramBluedIngSelfFeed;
  }
  
  public void a(String paramString, int paramInt) {
    if (!StringUtils.e(paramString)) {
      BluedRecommendUsers bluedRecommendUsers;
      boolean bool = false;
      if (1 == paramInt) {
        bluedRecommendUsers = new BluedRecommendUsers();
        bluedRecommendUsers.avatar = UserInfo.a().i().getAvatar();
        bluedRecommendUsers.uid = UserInfo.a().i().getUid();
        bluedRecommendUsers.vbadge = UserInfo.a().i().getVBadge();
        bluedRecommendUsers.name = UserInfo.a().i().getName();
        bluedRecommendUsers.city_settled = UserInfo.a().i().getCity_settled();
        bluedRecommendUsers.age = UserInfo.a().i().getAge();
        bluedRecommendUsers.height = UserInfo.a().i().getHeight();
        bluedRecommendUsers.weight = UserInfo.a().i().getWeight();
        bluedRecommendUsers.role = UserInfo.a().i().getRole();
        a(0, bluedRecommendUsers);
      } else if (paramInt == 0) {
        for (paramInt = bool; paramInt < this.n.size(); paramInt++) {
          if (bluedRecommendUsers.equals(((BluedRecommendUsers)this.n.get(paramInt)).uid)) {
            this.n.remove(paramInt);
            break;
          } 
        } 
      } 
      notifyDataSetChanged();
    } 
  }
  
  public void b() {
    LikeListDataObserver.a().b(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\adapter\FeedDetailsLikeListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */