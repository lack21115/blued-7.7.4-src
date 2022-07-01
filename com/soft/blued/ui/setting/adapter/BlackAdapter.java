package com.soft.blued.ui.setting.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.utils.DialogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg.controller.tools.MsgCommonUtils;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.List;

public class BlackAdapter extends BaseQuickAdapter<BluedBlackList, BaseViewHolder> {
  private Context a;
  
  private String b = BlackAdapter.class.getSimpleName();
  
  private Dialog c;
  
  private IRequestHost d;
  
  public BlackAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(2131493082);
    this.d = paramIRequestHost;
    this.a = paramContext;
    this.c = DialogUtils.a(paramContext);
  }
  
  private void a(BluedBlackList paramBluedBlackList) {
    UserHttpUtils.c(this.a, new BluedUIHttpResponse(this, paramBluedBlackList) {
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(BlackAdapter.b(this.b));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(BlackAdapter.b(this.b));
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            DialogUtils.b(BlackAdapter.b(this.b));
            this.b.n().remove(this.a);
            this.b.notifyDataSetChanged();
            this.b.notifyDataSetChanged();
            AppMethods.d(2131755732);
            UserInfoEntity userInfoEntity = new UserInfoEntity();
            userInfoEntity.uid = this.a.uid;
            userInfoEntity.relationship = "0";
            LiveEventBus.get("feed_relation_ship").post(userInfoEntity);
          }
        }UserInfo.a().i().getUid(), paramBluedBlackList.uid, this.d);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, BluedBlackList paramBluedBlackList) {
    ImageView imageView1 = (ImageView)paramBaseViewHolder.d(2131297362);
    TextView textView6 = (TextView)paramBaseViewHolder.d(2131299358);
    TextView textView7 = (TextView)paramBaseViewHolder.d(2131296943);
    TextView textView4 = (TextView)paramBaseViewHolder.d(2131299415);
    TextView textView1 = (TextView)paramBaseViewHolder.d(2131296426);
    TextView textView2 = (TextView)paramBaseViewHolder.d(2131297368);
    TextView textView3 = (TextView)paramBaseViewHolder.d(2131301755);
    TextView textView5 = (TextView)paramBaseViewHolder.d(2131299744);
    ImageView imageView2 = (ImageView)paramBaseViewHolder.d(2131297575);
    TextView textView8 = (TextView)paramBaseViewHolder.d(2131300637);
    ImageView imageView3 = (ImageView)paramBaseViewHolder.d(2131297536);
    ImageView imageView4 = (ImageView)paramBaseViewHolder.d(2131297581);
    LinearLayout linearLayout = (LinearLayout)paramBaseViewHolder.d(2131299013);
    UserRelationshipUtils.a(imageView2, paramBluedBlackList.vbadge, 3);
    paramBaseViewHolder.z().setOnClickListener(new View.OnClickListener(this, paramBluedBlackList, imageView1) {
          public void onClick(View param1View) {
            UserInfoFragmentNew.a(BlackAdapter.a(this.c), (UserBasicModel)this.a, "", (View)this.b);
          }
        });
    ImageLoader.a(this.d, paramBluedBlackList.avatar).c().a(2131234356).a(imageView1);
    if (!TextUtils.isEmpty(paramBluedBlackList.distance)) {
      textView7.setText(DistanceUtils.a(paramBluedBlackList.distance, BlueAppLocal.c(), false));
    } else {
      textView7.setText("");
    } 
    if (!TextUtils.isEmpty(paramBluedBlackList.city_settled)) {
      textView8.setText(AreaUtils.a(paramBluedBlackList.city_settled, BlueAppLocal.c()));
    } else {
      textView8.setText("");
    } 
    TypefaceUtils.b(this.a, textView8, paramBluedBlackList.is_hide_city_settled, 1);
    if (paramBluedBlackList.online_state == 1) {
      imageView3.setVisibility(0);
    } else {
      imageView3.setVisibility(8);
    } 
    if (!TextUtils.isEmpty(paramBluedBlackList.note)) {
      textView6.setText(paramBluedBlackList.note);
    } else if (!TextUtils.isEmpty(paramBluedBlackList.name)) {
      textView6.setText(paramBluedBlackList.name);
    } else {
      textView6.setText("");
    } 
    UserRelationshipUtils.a(this.a, textView6, (UserBasicModel)paramBluedBlackList);
    UserRelationshipUtils.a(imageView4, (UserBasicModel)paramBluedBlackList);
    String str = this.a.getResources().getString(2131755653);
    if (!TextUtils.isEmpty(paramBluedBlackList.black_time)) {
      StringBuilder stringBuilder;
      long l = TimeAndDateUtils.b(paramBluedBlackList.black_time);
      String str1 = MsgCommonUtils.a(AppInfo.d(), Long.valueOf(l).longValue());
      if (StringUtils.e(str1)) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.a.getResources().getString(2131755514));
        textView4.setText(stringBuilder.toString());
      } else {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str);
        stringBuilder1.append((String)stringBuilder);
        textView4.setText(stringBuilder1.toString());
      } 
    } else {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str);
      stringBuilder.append(this.a.getResources().getString(2131755514));
      textView4.setText(stringBuilder.toString());
    } 
    if (paramBluedBlackList.vbadge != 5) {
      linearLayout.setVisibility(0);
      UserRelationshipUtils.a(this.a, textView5, paramBluedBlackList.role);
      if (!TextUtils.isEmpty(paramBluedBlackList.age)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(paramBluedBlackList.age);
        stringBuilder.append(this.a.getResources().getString(2131755267));
        textView1.setText(stringBuilder.toString());
      } else {
        textView1.setText("");
      } 
      if (!TextUtils.isEmpty(paramBluedBlackList.height)) {
        textView2.setText(paramBluedBlackList.height);
      } else {
        textView2.setText("");
      } 
      if (!TextUtils.isEmpty(paramBluedBlackList.weight)) {
        textView3.setText(paramBluedBlackList.weight);
      } else {
        textView3.setText("");
      } 
    } else {
      linearLayout.setVisibility(8);
    } 
    paramBaseViewHolder.z().setOnLongClickListener(new View.OnLongClickListener(this, paramBaseViewHolder, paramBluedBlackList) {
          public boolean onLongClick(View param1View) {
            if (this.a.getAdapterPosition() >= 0) {
              if (this.a.getAdapterPosition() > this.c.n().size())
                return true; 
              String str1 = BlackAdapter.a(this.c).getResources().getString(2131758574);
              Context context = BlackAdapter.a(this.c);
              String str2 = this.b.name;
              DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener(this) {
                  public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                    if (param2Int != 0)
                      return; 
                    BlackAdapter.a(this.a.c, this.a.b);
                  }
                };
              CommonAlertDialog.a(context, str2, new String[] { str1 }, onClickListener);
              return false;
            } 
            return true;
          }
        });
  }
  
  public void a(List<BluedBlackList> paramList) {
    n().clear();
    if (paramList != null && paramList.size() > 0) {
      for (int i = 0; i < paramList.size(); i++) {
        if (BlueAppLocal.d()) {
          ((BluedBlackList)paramList.get(i)).height = StringUtils.a(((BluedBlackList)paramList.get(i)).height, BlueAppLocal.c(), false);
          ((BluedBlackList)paramList.get(i)).weight = StringUtils.b(((BluedBlackList)paramList.get(i)).weight, BlueAppLocal.c(), false);
        } else {
          ((BluedBlackList)paramList.get(i)).height = StringUtils.a(((BluedBlackList)paramList.get(i)).height, BlueAppLocal.c(), true);
          ((BluedBlackList)paramList.get(i)).weight = StringUtils.b(((BluedBlackList)paramList.get(i)).weight, BlueAppLocal.c(), true);
        } 
      } 
      n().addAll(paramList);
    } 
    notifyDataSetChanged();
  }
  
  public void b(List<BluedBlackList> paramList) {
    if (paramList != null && paramList.size() > 0) {
      for (int i = 0; i < paramList.size(); i++) {
        if (BlueAppLocal.d()) {
          ((BluedBlackList)paramList.get(i)).height = StringUtils.a(((BluedBlackList)paramList.get(i)).height, BlueAppLocal.c(), false);
          ((BluedBlackList)paramList.get(i)).weight = StringUtils.b(((BluedBlackList)paramList.get(i)).weight, BlueAppLocal.c(), false);
        } else {
          ((BluedBlackList)paramList.get(i)).height = StringUtils.a(((BluedBlackList)paramList.get(i)).height, BlueAppLocal.c(), true);
          ((BluedBlackList)paramList.get(i)).weight = StringUtils.b(((BluedBlackList)paramList.get(i)).weight, BlueAppLocal.c(), true);
        } 
      } 
      n().addAll(paramList);
      notifyDataSetChanged();
    } 
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\adapter\BlackAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */