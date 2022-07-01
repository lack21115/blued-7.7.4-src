package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.yy_china.IYYRoomInfoCallback;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYEndInfoModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import java.util.List;

public class YYHostEndView extends LinearLayout {
  private TextView a;
  
  private TextView b;
  
  private TextView c;
  
  private TextView d;
  
  private BaseYYStudioFragment e;
  
  private ImageView f;
  
  private RelativeLayout g;
  
  private RankingView h;
  
  public YYHostEndView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYHostEndView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYHostEndView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_end_layout, (ViewGroup)this, true);
    this.f = (ImageView)findViewById(R.id.iv_end_close);
    this.g = (RelativeLayout)findViewById(R.id.yy_end_title);
    this.h = (RankingView)findViewById(R.id.ranking_view);
    this.a = (TextView)findViewById(R.id.tv_total_beans);
    this.b = (TextView)findViewById(R.id.tv_total_person);
    this.c = (TextView)findViewById(R.id.tv_my_beans);
    this.d = (TextView)findViewById(R.id.tv_living_time);
    if (StatusBarHelper.a())
      ((LinearLayout.LayoutParams)this.g.getLayoutParams()).topMargin = StatusBarHelper.a(getContext()); 
    this.f.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYHostEndView.a(this.a).getActivity().finish();
          }
        });
  }
  
  private void a(View paramView, View.OnClickListener paramOnClickListener) {
    LiveAlterDialog.a(getContext(), paramView, null, paramOnClickListener, true, false);
  }
  
  private void a(String paramString) {
    YYRoomHttpUtils.e(paramString, new BluedUIHttpResponse<BluedEntityA<YYEndInfoModel>>(this, (IRequestHost)this.e.w_()) {
          protected void a(BluedEntityA<YYEndInfoModel> param1BluedEntityA) {
            YYEndInfoModel yYEndInfoModel = (YYEndInfoModel)param1BluedEntityA.getSingleData();
            if (yYEndInfoModel == null)
              return; 
            YYHostEndView.b(this.a).setText(yYEndInfoModel.total_beans);
            YYHostEndView.c(this.a).setText(yYEndInfoModel.received_beans);
            YYHostEndView.d(this.a).setText(yYEndInfoModel.total_user);
            YYHostEndView.e(this.a).setText(yYEndInfoModel.live_duration);
            if (TextUtils.equals("1", yYEndInfoModel.need_improved)) {
              YYHostEndView.f(this.a);
            } else if (TextUtils.equals("2", yYEndInfoModel.is_sign)) {
              YYHostEndView yYHostEndView = this.a;
              YYHostEndView.a(yYHostEndView, yYHostEndView.getResources().getString(R.string.yy_constract_invalid), this.a.getResources().getString(R.string.yy_constract_resign), this.a.getResources().getString(R.string.yy_go_sign));
            } else if (TextUtils.equals("0", yYEndInfoModel.is_sign)) {
              YYHostEndView yYHostEndView = this.a;
              YYHostEndView.a(yYHostEndView, yYHostEndView.getResources().getString(R.string.yy_additional_information), this.a.getResources().getString(R.string.yy_additional_description), this.a.getResources().getString(R.string.yy_go_additional));
            } 
            List<YYUserInfo> list = yYEndInfoModel.rank_list;
            if (list != null) {
              if (list.isEmpty())
                return; 
              if (list.size() > 0)
                YYHostEndView.g(this.a).a(list.get(0)); 
              if (list.size() > 1)
                YYHostEndView.g(this.a).b(list.get(1)); 
              if (list.size() > 2)
                YYHostEndView.g(this.a).c(list.get(2)); 
            } 
          }
        }(IRequestHost)this.e.w_());
  }
  
  private void a(String paramString1, String paramString2, String paramString3) {
    View view = getDialogView();
    TextView textView1 = (TextView)view.findViewById(R.id.tv_title);
    TextView textView2 = (TextView)view.findViewById(R.id.tv_des);
    TextView textView3 = (TextView)view.findViewById(R.id.tv_ok);
    textView1.setText(paramString1);
    textView2.setText(paramString2);
    textView3.setText(paramString3);
    a(view, new View.OnClickListener(this) {
          public void onClick(View param1View) {
            IYYRoomInfoCallback iYYRoomInfoCallback = YYRoomInfoManager.d().c();
            if (iYYRoomInfoCallback != null)
              iYYRoomInfoCallback.a(this.a.getContext(), iYYRoomInfoCallback.h(), 7); 
          }
        });
  }
  
  private void b() {
    View view = getDialogView();
    TextView textView1 = (TextView)view.findViewById(R.id.tv_title);
    TextView textView2 = (TextView)view.findViewById(R.id.tv_des);
    TextView textView3 = (TextView)view.findViewById(R.id.tv_ok);
    textView1.setText(getResources().getString(R.string.yy_additional_information));
    textView2.setText(getResources().getString(R.string.yy_additional_description));
    textView3.setText(getResources().getString(R.string.yy_go_additional));
    a(view, new View.OnClickListener(this) {
          public void onClick(View param1View) {
            IYYRoomInfoCallback iYYRoomInfoCallback = YYRoomInfoManager.d().c();
            if (iYYRoomInfoCallback != null)
              iYYRoomInfoCallback.b(this.a.getContext()); 
          }
        });
  }
  
  private View getDialogView() {
    return LayoutInflater.from(getContext()).inflate(R.layout.dialog_sign_up, null);
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment, String paramString) {
    StringBuilder stringBuilder;
    this.e = paramBaseYYStudioFragment;
    setVisibility(0);
    if (TextUtils.isEmpty(paramString)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("room_id: ");
      stringBuilder.append(paramString);
      Logger.e("end", new Object[] { stringBuilder.toString() });
      return;
    } 
    RankingView rankingView = this.h;
    if (rankingView != null)
      rankingView.a((BaseYYStudioFragment)stringBuilder, paramString); 
    a(paramString);
    YYRoomInfoManager.d().l();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYHostEndView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */