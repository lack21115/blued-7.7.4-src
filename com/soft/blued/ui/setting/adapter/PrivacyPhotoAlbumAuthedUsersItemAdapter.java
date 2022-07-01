package com.soft.blued.ui.setting.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.SlideView;
import com.blued.android.module.common.utils.AvatarUtils;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.List;

public class PrivacyPhotoAlbumAuthedUsersItemAdapter extends BaseAdapter implements SlideView.OnSlideListener {
  private Context a;
  
  private LayoutInflater b;
  
  private List<UserFindResult> c;
  
  private OnDeleteClickListener d;
  
  private SlideView e;
  
  private boolean f;
  
  private IRequestHost g;
  
  public PrivacyPhotoAlbumAuthedUsersItemAdapter(Context paramContext, IRequestHost paramIRequestHost, List<UserFindResult> paramList) {
    this.a = paramContext;
    this.g = paramIRequestHost;
    this.c = paramList;
    this.b = LayoutInflater.from(this.a);
  }
  
  public void a() {
    this.c.clear();
    notifyDataSetChanged();
  }
  
  public void a(int paramInt) {
    this.c.remove(paramInt);
    notifyDataSetChanged();
  }
  
  public void a(View paramView, int paramInt) {
    SlideView slideView = this.e;
    if (slideView != null && slideView != paramView)
      slideView.a(); 
    if (paramInt == 1)
      ((SlideView)paramView).a(); 
    if (paramInt == 2)
      this.e = (SlideView)paramView; 
  }
  
  public void a(OnDeleteClickListener paramOnDeleteClickListener) {
    this.d = paramOnDeleteClickListener;
  }
  
  public void a(List<UserFindResult> paramList) {
    this.c.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean) {
    this.f = paramBoolean;
    notifyDataSetChanged();
  }
  
  public int getCount() {
    List<UserFindResult> list = this.c;
    return (list != null) ? list.size() : 0;
  }
  
  public Object getItem(int paramInt) {
    List<UserFindResult> list = this.c;
    return (list != null) ? list.get(paramInt) : null;
  }
  
  public long getItemId(int paramInt) {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder;
    UserFindResult userFindResult = (UserFindResult)getItem(paramInt);
    if (paramView == null) {
      paramView = this.b.inflate(2131493418, paramViewGroup, false);
      viewHolder = new ViewHolder(this, paramView);
      paramView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder)paramView.getTag();
    } 
    if (this.f) {
      ViewHolder.a(viewHolder).setVisibility(0);
    } else {
      ViewHolder.a(viewHolder).setVisibility(8);
    } 
    ViewHolder.a(viewHolder).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {}
        });
    if (userFindResult.is_recommend == 1) {
      ViewHolder.b(viewHolder).setVisibility(0);
      ViewHolder.c(viewHolder).setVisibility(4);
    } else {
      ViewHolder.b(viewHolder).setVisibility(4);
      ViewHolder.c(viewHolder).setVisibility(0);
      UserRelationshipUtils.a(ViewHolder.c(viewHolder), userFindResult.vbadge, 3);
    } 
    DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
    int i = DensityUtils.a(this.a, 87.5F);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(displayMetrics.widthPixels + 1, i);
    ViewHolder.d(viewHolder).setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    ViewHolder.d(viewHolder).setOnClickListener(new View.OnClickListener(this, userFindResult, viewHolder) {
          public void onClick(View param1View) {
            UserInfoFragmentNew.a(PrivacyPhotoAlbumAuthedUsersItemAdapter.a(this.c), (UserBasicModel)this.a, "", (View)PrivacyPhotoAlbumAuthedUsersItemAdapter.ViewHolder.e(this.b));
          }
        });
    ViewHolder.f(viewHolder).setOnSlideListener(this);
    ViewHolder.g(viewHolder).setOnClickListener(new View.OnClickListener(this, userFindResult, paramInt, viewHolder) {
          public void onClick(View param1View) {
            if (PrivacyPhotoAlbumAuthedUsersItemAdapter.b(this.d) != null) {
              PrivacyPhotoAlbumAuthedUsersItemAdapter.b(this.d).a(this.a.uid, this.b);
              PrivacyPhotoAlbumAuthedUsersItemAdapter.ViewHolder.f(this.c).a();
            } 
          }
        });
    String str1 = TimeAndDateUtils.a(this.a, TimeAndDateUtils.b(userFindResult.last_operate));
    String str2 = DistanceUtils.a(userFindResult.distance, BlueAppLocal.c(), false);
    if (userFindResult.live > 0) {
      ViewHolder.h(viewHolder).setVisibility(0);
    } else {
      ViewHolder.h(viewHolder).setVisibility(8);
    } 
    ImageLoader.a(this.g, AvatarUtils.a(0, userFindResult.avatar)).a(2131234356).c().a(ViewHolder.e(viewHolder));
    UserRelationshipUtils.a(this.a, ViewHolder.i(viewHolder), userFindResult.role);
    UserRelationshipUtils.a(ViewHolder.j(viewHolder), (UserBasicModel)userFindResult);
    if (!TextUtils.isEmpty(str2)) {
      ViewHolder.k(viewHolder).setText(str2);
    } else {
      ViewHolder.k(viewHolder).setText("");
    } 
    DistanceUtils.a(this.a, ViewHolder.k(viewHolder), (UserBasicModel)userFindResult, 1);
    if (!TextUtils.isEmpty(userFindResult.note)) {
      ViewHolder.l(viewHolder).setText(userFindResult.note);
    } else if (!TextUtils.isEmpty(userFindResult.name)) {
      ViewHolder.l(viewHolder).setText(userFindResult.name);
    } else {
      ViewHolder.l(viewHolder).setText("");
    } 
    UserRelationshipUtils.a(this.a, ViewHolder.l(viewHolder), (UserBasicModel)userFindResult);
    if (1 == userFindResult.online_state) {
      ViewHolder.m(viewHolder).setVisibility(0);
    } else {
      ViewHolder.m(viewHolder).setVisibility(8);
    } 
    if (!TextUtils.isEmpty(str1)) {
      ViewHolder.n(viewHolder).setText(str1);
    } else {
      ViewHolder.n(viewHolder).setText("");
    } 
    TypefaceUtils.a(this.a, ViewHolder.n(viewHolder), userFindResult.is_hide_last_operate, 1);
    if (!TextUtils.isEmpty(userFindResult.age)) {
      TextView textView = ViewHolder.o(viewHolder);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(userFindResult.age);
      stringBuilder.append(this.a.getResources().getString(2131755267));
      textView.setText(stringBuilder.toString());
    } else {
      ViewHolder.o(viewHolder).setText("");
    } 
    if (!TextUtils.isEmpty(userFindResult.height)) {
      ViewHolder.p(viewHolder).setText(userFindResult.height);
    } else {
      ViewHolder.p(viewHolder).setText("");
    } 
    if (!TextUtils.isEmpty(userFindResult.weight)) {
      ViewHolder.q(viewHolder).setText(userFindResult.weight);
    } else {
      ViewHolder.q(viewHolder).setText("");
    } 
    if (TextUtils.isEmpty(userFindResult.description)) {
      ViewHolder.r(viewHolder).setText(this.a.getResources().getString(2131759177));
      return paramView;
    } 
    ViewHolder.r(viewHolder).setText(userFindResult.description);
    return paramView;
  }
  
  public static interface OnDeleteClickListener {
    void a(String param1String, int param1Int);
  }
  
  class ViewHolder {
    private ImageView b;
    
    private ImageView c;
    
    private ImageView d;
    
    private ImageView e;
    
    private ImageView f;
    
    private LinearLayout g;
    
    private ImageView h;
    
    private SlideView i;
    
    private TextView j;
    
    private TextView k;
    
    private TextView l;
    
    private TextView m;
    
    private TextView n;
    
    private TextView o;
    
    private TextView p;
    
    private TextView q;
    
    private TextView r;
    
    private TextView s;
    
    public ViewHolder(PrivacyPhotoAlbumAuthedUsersItemAdapter this$0, View param1View) {
      this.g = (LinearLayout)param1View.findViewById(2131298064);
      this.h = (ImageView)param1View.findViewById(2131297362);
      this.b = (ImageView)param1View.findViewById(2131297447);
      this.c = (ImageView)param1View.findViewById(2131297513);
      this.d = (ImageView)param1View.findViewById(2131297536);
      this.e = (ImageView)param1View.findViewById(2131297575);
      this.f = (ImageView)param1View.findViewById(2131297545);
      this.i = (SlideView)param1View.findViewById(2131300146);
      this.j = (TextView)param1View.findViewById(2131296426);
      this.k = (TextView)param1View.findViewById(2131297368);
      this.m = (TextView)param1View.findViewById(2131299358);
      this.l = (TextView)param1View.findViewById(2131296943);
      this.n = (TextView)param1View.findViewById(2131299415);
      this.o = (TextView)param1View.findViewById(2131299744);
      this.p = (TextView)param1View.findViewById(2131299959);
      this.q = (TextView)param1View.findViewById(2131301755);
      this.r = (TextView)param1View.findViewById(2131300932);
      this.s = (TextView)param1View.findViewById(2131300680);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\adapter\PrivacyPhotoAlbumAuthedUsersItemAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */