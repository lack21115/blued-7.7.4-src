package com.soft.blued.ui.circle.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.fragment.CircleDetailsFragment;
import com.soft.blued.ui.circle.model.CircleConstants;
import com.soft.blued.ui.circle.model.CircleJoinState;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.circle.model.MyCircleModel;
import com.soft.blued.ui.circle.view.CircleJoinView;
import com.soft.blued.utils.StringUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\000<\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\002\b\t\n\002\020\002\n\000\n\002\030\002\n\002\b\006\030\0002\016\022\004\022\0020\002\022\004\022\0020\0030\001B\035\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007\022\006\020\b\032\0020\t¢\006\002\020\nJ\030\020\025\032\0020\0262\006\020\027\032\0020\0302\006\020\031\032\0020\002H\002J\034\020\032\032\0020\0262\b\020\033\032\004\030\0010\0032\b\020\031\032\004\030\0010\002H\024J\016\020\034\032\0020\0262\006\020\035\032\0020\fR\016\020\b\032\0020\tX\004¢\006\002\n\000R\032\020\013\032\0020\fX\016¢\006\016\n\000\032\004\b\r\020\016\"\004\b\017\020\020R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\021\020\022R\021\020\006\032\0020\007¢\006\b\n\000\032\004\b\023\020\024¨\006\036"}, d2 = {"Lcom/soft/blued/ui/circle/adapter/CircleNewListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/soft/blued/ui/circle/model/MyCircleModel;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "context", "Landroid/content/Context;", "fragmentActive", "Lcom/blued/android/core/net/IRequestHost;", "circleListPage", "Lcom/soft/blued/ui/circle/model/CircleConstants$CIRCLE_FROM_PAGE;", "(Landroid/content/Context;Lcom/blued/android/core/net/IRequestHost;Lcom/soft/blued/ui/circle/model/CircleConstants$CIRCLE_FROM_PAGE;)V", "classifyId", "", "getClassifyId", "()I", "setClassifyId", "(I)V", "getContext", "()Landroid/content/Context;", "getFragmentActive", "()Lcom/blued/android/core/net/IRequestHost;", "addCircle", "", "cjv", "Lcom/soft/blued/ui/circle/view/CircleJoinView;", "item", "convert", "helper", "setTypeId", "typeId", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
public final class CircleNewListAdapter extends BaseQuickAdapter<MyCircleModel, BaseViewHolder> {
  private int a;
  
  private final Context b;
  
  private final IRequestHost c;
  
  private final CircleConstants.CIRCLE_FROM_PAGE d;
  
  public CircleNewListAdapter(Context paramContext, IRequestHost paramIRequestHost, CircleConstants.CIRCLE_FROM_PAGE paramCIRCLE_FROM_PAGE) {
    super(2131493484, null);
    this.b = paramContext;
    this.c = paramIRequestHost;
    this.d = paramCIRCLE_FROM_PAGE;
    this.a = -1;
  }
  
  private final void a(CircleJoinView paramCircleJoinView, MyCircleModel paramMyCircleModel) {
    FragmentManager fragmentManager = (FragmentManager)null;
    if (this.k instanceof AppCompatActivity) {
      Context context = this.k;
      if (context != null) {
        fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
      } else {
        throw new TypeCastException("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
      } 
    } 
    CircleMethods.joinCircle(this.k, new CircleNewListAdapter$addCircle$1(this, paramMyCircleModel, paramCircleJoinView), paramMyCircleModel.getJoinState(), this.c, fragmentManager, false, true);
    notifyDataSetChanged();
  }
  
  public final int a() {
    return this.a;
  }
  
  public final void a(int paramInt) {
    this.a = paramInt;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, MyCircleModel paramMyCircleModel) {
    if (paramBaseViewHolder != null && paramMyCircleModel != null) {
      ImageLoader.a(this.c, paramMyCircleModel.cover).a(2131231281).a(8.0F).a((ImageView)paramBaseViewHolder.d(2131297724));
      ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297726);
      int i = paramMyCircleModel.label;
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i == 3) {
              paramBaseViewHolder.b(2131297726, true);
              imageView.setImageResource(2131232424);
            } 
          } else {
            paramBaseViewHolder.b(2131297726, true);
            imageView.setImageResource(2131232425);
          } 
        } else {
          paramBaseViewHolder.b(2131297726, true);
          Context context1 = this.k;
          Intrinsics.a(context1, "mContext");
          imageView.setImageDrawable(context1.getResources().getDrawable(2131232423));
          imageView.setImageResource(2131232423);
        } 
      } else {
        paramBaseViewHolder.b(2131297726, false);
      } 
      paramBaseViewHolder.a(2131300633, paramMyCircleModel.title);
      if (StringUtils.e(paramMyCircleModel.description)) {
        paramBaseViewHolder.b(2131300629, false);
      } else {
        paramBaseViewHolder.b(2131300629, true);
        paramBaseViewHolder.a(2131300629, paramMyCircleModel.description);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramMyCircleModel.members_big_num);
      Context context = this.k;
      Intrinsics.a(context, "mContext");
      stringBuilder.append(context.getResources().getString(2131757872));
      paramBaseViewHolder.a(2131300632, stringBuilder.toString());
      stringBuilder = new StringBuilder();
      stringBuilder.append(paramMyCircleModel.feed_big_num);
      context = this.k;
      Intrinsics.a(context, "mContext");
      stringBuilder.append(context.getResources().getString(2131755870));
      paramBaseViewHolder.a(2131300631, stringBuilder.toString());
      paramBaseViewHolder.b(2131296752, true);
      CircleJoinView circleJoinView = (CircleJoinView)paramBaseViewHolder.d(2131296752);
      circleJoinView.setJoinStatus(paramMyCircleModel.getJoinState());
      circleJoinView.setOnClickListener(new CircleNewListAdapter$convert$1(this, paramMyCircleModel, circleJoinView));
      if (!paramMyCircleModel.isDraw) {
        boolean bool;
        FeedProtos.Event event = FeedProtos.Event.CIRCLE_DRAW;
        String str = paramMyCircleModel.circle_id;
        FeedProtos.CircleSource circleSource = FeedProtos.CircleSource.CIRCLE_MORE_LIST;
        boolean bool1 = paramMyCircleModel.isJoin();
        if (paramMyCircleModel.allow_join == 0) {
          bool = true;
        } else {
          bool = false;
        } 
        EventTrackFeed.a(event, str, circleSource, bool1, bool, this.a);
        paramMyCircleModel.isDraw = true;
      } 
      ((ConstraintLayout)paramBaseViewHolder.d(2131301634)).setOnClickListener(new CircleNewListAdapter$convert$2(this, paramMyCircleModel));
    } 
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "joinModel", "Lcom/soft/blued/ui/circle/model/CircleJoinState;", "kotlin.jvm.PlatformType", "joinViewChange"}, k = 3, mv = {1, 1, 16})
  static final class CircleNewListAdapter$addCircle$1 implements CircleMethods.JoinViewChangeListener {
    CircleNewListAdapter$addCircle$1(CircleNewListAdapter param1CircleNewListAdapter, MyCircleModel param1MyCircleModel, CircleJoinView param1CircleJoinView) {}
    
    public final void joinViewChange(CircleJoinState param1CircleJoinState) {
      Intrinsics.a(param1CircleJoinState, "joinModel");
      if (param1CircleJoinState.isJoin()) {
        this.b.setMember();
      } else {
        this.b.setExitJoin();
      } 
      this.b.setJoinState(param1CircleJoinState);
      this.c.setJoinStatusWithMember(this.b);
      this.a.notifyDataSetChanged();
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class CircleNewListAdapter$convert$1 implements View.OnClickListener {
    CircleNewListAdapter$convert$1(CircleNewListAdapter param1CircleNewListAdapter, MyCircleModel param1MyCircleModel, CircleJoinView param1CircleJoinView) {}
    
    public final void onClick(View param1View) {
      if (this.b.isJoin())
        CircleDetailsFragment.a(CircleNewListAdapter.a(this.a), this.b, CircleConstants.CIRCLE_FROM_PAGE.CIRCLE_MORE_LIST); 
      if (this.b.isNotMember()) {
        int i = this.b.is_applied;
        boolean bool = true;
        if (i != 1) {
          CircleNewListAdapter circleNewListAdapter = this.a;
          CircleJoinView circleJoinView = this.c;
          Intrinsics.a(circleJoinView, "cjvJoin");
          CircleNewListAdapter.a(circleNewListAdapter, circleJoinView, this.b);
          FeedProtos.Event event = FeedProtos.Event.CIRCLE_JOIN_BTN_CLICK;
          String str = this.b.circle_id;
          FeedProtos.CircleSource circleSource = FeedProtos.CircleSource.CIRCLE_MORE_LIST;
          if (this.b.allow_join != 0)
            bool = false; 
          EventTrackFeed.a(event, str, circleSource, bool, this.a.a());
        } 
      } 
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class CircleNewListAdapter$convert$2 implements View.OnClickListener {
    CircleNewListAdapter$convert$2(CircleNewListAdapter param1CircleNewListAdapter, MyCircleModel param1MyCircleModel) {}
    
    public final void onClick(View param1View) {
      this.b.classify_id = this.a.a();
      CircleDetailsFragment.a(CircleNewListAdapter.a(this.a), this.b, CircleConstants.CIRCLE_FROM_PAGE.CIRCLE_MORE_LIST);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\adapter\CircleNewListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */