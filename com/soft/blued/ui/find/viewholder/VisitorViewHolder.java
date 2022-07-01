package com.soft.blued.ui.find.viewholder;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.das.message.MessageProtos;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.model.LogData;
import com.soft.blued.ui.find.model.BluedMyVisitorList;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.DistanceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;

public class VisitorViewHolder {
  private int a;
  
  private TextView b;
  
  public BluedMyVisitorList c;
  
  public LinearLayout d;
  
  public ImageView e;
  
  public LoadOptions f;
  
  private TextView g;
  
  private TextView h;
  
  private TextView i;
  
  private TextView j;
  
  private TextView k;
  
  private ImageView l;
  
  private ImageView m;
  
  private TextView n;
  
  private TextView o;
  
  private ImageView p;
  
  private Context q;
  
  private int r;
  
  private IRequestHost s;
  
  private LinearLayout t;
  
  public VisitorViewHolder(Context paramContext, IRequestHost paramIRequestHost, View paramView, LoadOptions paramLoadOptions, int paramInt) {
    this.f = paramLoadOptions;
    this.q = paramContext;
    this.s = paramIRequestHost;
    this.r = paramInt;
    this.d = (LinearLayout)paramView.findViewById(2131298064);
    this.e = (ImageView)paramView.findViewById(2131297362);
    this.k = (TextView)paramView.findViewById(2131299744);
    this.b = (TextView)paramView.findViewById(2131299358);
    this.g = (TextView)paramView.findViewById(2131296943);
    this.h = (TextView)paramView.findViewById(2131296426);
    this.i = (TextView)paramView.findViewById(2131297368);
    this.j = (TextView)paramView.findViewById(2131301755);
    this.l = (ImageView)paramView.findViewById(2131297536);
    this.m = (ImageView)paramView.findViewById(2131297575);
    this.n = (TextView)paramView.findViewById(2131299959);
    this.o = (TextView)paramView.findViewById(2131299415);
    this.p = (ImageView)paramView.findViewById(2131297447);
    this.t = (LinearLayout)paramView.findViewById(2131299013);
  }
  
  private void a() {
    if (this.r == 0) {
      if (this.c.online_state == 1) {
        this.l.setImageDrawable(BluedSkinUtils.b(this.q, 2131234365));
        return;
      } 
      this.l.setImageDrawable(BluedSkinUtils.b(this.q, 2131234364));
      return;
    } 
    if (this.c.is_call == 1) {
      this.l.setImageDrawable(BluedSkinUtils.b(this.q, 2131232507));
      return;
    } 
    if (this.c.is_shadow == 1) {
      this.l.setImageDrawable(BluedSkinUtils.b(this.q, 2131232508));
      return;
    } 
    if (this.c.online_state == 1) {
      this.l.setImageDrawable(BluedSkinUtils.b(this.q, 2131234365));
      return;
    } 
    this.l.setImageDrawable(BluedSkinUtils.b(this.q, 2131234364));
  }
  
  public void a(int paramInt) {
    String str1;
    UserRelationshipUtils.b(this.m, this.c.vbadge, 2, 8);
    this.o.setVisibility(8);
    ImageLoader.a(this.s, AvatarUtils.a(0, this.c.avatar)).a(2131234356).c().a(this.e);
    UserRelationshipUtils.a(this.p, (UserBasicModel)this.c);
    if (this.c.vbadge != 3 && this.c.vbadge != 5)
      UserRelationshipUtils.a(this.q, this.k, this.c.role); 
    if (this.c.vbadge == 3) {
      this.g.setText("");
    } else {
      if (!TextUtils.isEmpty(this.c.distance)) {
        BluedMyVisitorList bluedMyVisitorList = this.c;
        bluedMyVisitorList.distanceStr = DistanceUtils.a(bluedMyVisitorList.distance, BlueAppLocal.c(), false);
        TextView textView = this.g;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.c.distanceStr);
        stringBuilder1.append(" ");
        textView.setText(stringBuilder1.toString());
      } else {
        this.g.setText("");
      } 
      DistanceUtils.a(this.q, this.g, (UserBasicModel)this.c, 1);
    } 
    if (!TextUtils.isEmpty(this.c.note)) {
      this.b.setText(this.c.note);
    } else if (!TextUtils.isEmpty(this.c.name)) {
      this.b.setText(this.c.name);
    } else {
      this.b.setText("");
    } 
    UserRelationshipUtils.a(this.q, this.b, (UserBasicModel)this.c);
    if (this.c.vbadge == 3 || this.c.vbadge == 5) {
      this.t.setVisibility(8);
    } else {
      this.t.setVisibility(0);
      if (!TextUtils.isEmpty(this.c.age)) {
        TextView textView = this.h;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(this.c.age);
        stringBuilder1.append(this.q.getResources().getString(2131755267));
        textView.setText(stringBuilder1.toString());
      } else {
        this.h.setText("");
      } 
      if (!TextUtils.isEmpty(this.c.height)) {
        this.i.setText(this.c.height);
      } else {
        this.i.setText("");
      } 
      if (!TextUtils.isEmpty(this.c.weight)) {
        this.j.setText(this.c.weight);
      } else {
        this.j.setText("");
      } 
    } 
    if (this.c.online_state == 1) {
      TextView textView = this.o;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(" ");
      stringBuilder1.append(this.q.getResources().getString(2131756566));
      textView.setText(stringBuilder1.toString());
    } else if (!TextUtils.isEmpty(this.c.last_operate)) {
      TextView textView;
      Long long_ = Long.valueOf(TimeAndDateUtils.b(this.c.last_operate));
      if (StringUtils.e(TimeAndDateUtils.f(AppInfo.d(), long_.longValue()))) {
        textView = this.o;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(" ");
        stringBuilder1.append(this.q.getResources().getString(2131755514));
        textView.setText(stringBuilder1.toString());
      } else {
        TextView textView1 = this.o;
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(" ");
        stringBuilder1.append(TimeAndDateUtils.f(AppInfo.d(), textView.longValue()));
        textView1.setText(stringBuilder1.toString());
      } 
    } else {
      TextView textView = this.o;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(" ");
      stringBuilder1.append(this.q.getResources().getString(2131755514));
      textView.setText(stringBuilder1.toString());
    } 
    TypefaceUtils.a(this.q, this.o, this.c.is_hide_last_operate, 1);
    if (this.r == 0) {
      if (!TextUtils.isEmpty(this.c.visited_time)) {
        this.n.setVisibility(0);
        if (BlueAppLocal.d()) {
          TextView textView = this.n;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(TimeAndDateUtils.g(this.q, TimeAndDateUtils.b(this.c.visited_time)));
          stringBuilder1.append(this.q.getResources().getString(2131759316));
          textView.setText(stringBuilder1.toString());
        } else {
          TextView textView = this.n;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(this.q.getResources().getString(2131759316));
          stringBuilder1.append(TimeAndDateUtils.g(this.q, TimeAndDateUtils.b(this.c.visited_time)));
          textView.setText(stringBuilder1.toString());
        } 
      } else {
        this.n.setVisibility(4);
      } 
    } else {
      if (!TextUtils.isEmpty(this.c.visitors_time)) {
        this.n.setVisibility(0);
        if (BlueAppLocal.d()) {
          if (this.c.is_shadow == 1) {
            TextView textView = this.n;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(TimeAndDateUtils.g(this.q, TimeAndDateUtils.b(this.c.visitors_time)));
            stringBuilder1.append(this.q.getResources().getString(2131759320));
            textView.setText(stringBuilder1.toString());
          } else {
            TextView textView = this.n;
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(TimeAndDateUtils.g(this.q, TimeAndDateUtils.b(this.c.visitors_time)));
            stringBuilder1.append(this.q.getResources().getString(2131759317));
            textView.setText(stringBuilder1.toString());
          } 
        } else if (this.c.is_shadow == 1) {
          TextView textView = this.n;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(this.q.getResources().getString(2131759320));
          stringBuilder1.append(TimeAndDateUtils.g(this.q, TimeAndDateUtils.b(this.c.visitors_time)));
          textView.setText(stringBuilder1.toString());
        } else {
          TextView textView = this.n;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append(this.q.getResources().getString(2131759317));
          stringBuilder1.append(TimeAndDateUtils.g(this.q, TimeAndDateUtils.b(this.c.visitors_time)));
          textView.setText(stringBuilder1.toString());
        } 
      } else {
        this.n.setVisibility(4);
      } 
      if (StringUtils.a(this.c.last_visit_time, 0L) < StringUtils.a(this.c.visitors_time, 0L)) {
        this.d.setBackground((Drawable)new ColorDrawable(BluedSkinUtils.a(this.q, 2131100733)));
      } else {
        this.d.setBackground(BluedSkinUtils.b(this.q, 2131233702));
      } 
    } 
    LogData logData = new LogData();
    logData.g = "my_visitor";
    logData.J = "click_position";
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    logData.l = stringBuilder.toString();
    logData.c = this.c.uid;
    paramInt = this.c.is_call;
    String str2 = "1";
    if (paramInt == 1) {
      str1 = "1";
    } else {
      str1 = "0";
    } 
    logData.u = str1;
    this.e.setOnClickListener(new View.OnClickListener(this, logData) {
          public void onClick(View param1View) {
            this.b.a(this.a);
          }
        });
    this.d.setOnClickListener(new View.OnClickListener(this, logData) {
          public void onClick(View param1View) {
            this.b.a(this.a);
          }
        });
    if (!this.c.isShowUrlVisited) {
      logData = new LogData();
      logData.J = "my_visitor_show";
      logData.c = this.c.uid;
      if (this.c.is_call == 1) {
        str1 = str2;
      } else {
        str1 = "0";
      } 
      logData.u = str1;
      InstantLog.a(logData);
      this.c.isShowUrlVisited = true;
    } 
    a();
  }
  
  public void a(LogData paramLogData) {
    MessageProtos.StrangerSource strangerSource;
    String str;
    if (this.r == 1) {
      strangerSource = MessageProtos.StrangerSource.FRIEND_NEARBY_VISIT;
      str = "my_visitor";
    } else {
      strangerSource = MessageProtos.StrangerSource.FRIEND_NEARBY_VIEW;
      str = "my_visited";
    } 
    BluedMyVisitorList bluedMyVisitorList = this.c.clone();
    bluedMyVisitorList.uid = this.c.uid;
    bluedMyVisitorList.is_show_vip_page = this.c.is_show_vip_page;
    bluedMyVisitorList.is_shadow = 0;
    UserInfoFragmentNew.a(this.q, (UserBasicModel)bluedMyVisitorList, str, (View)this.e, null, new MsgSourceEntity(strangerSource, ""));
    InstantLog.a(paramLogData);
  }
  
  public void a(BluedMyVisitorList paramBluedMyVisitorList, int paramInt) {
    this.c = paramBluedMyVisitorList;
    this.a = paramInt;
    a(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\viewholder\VisitorViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */