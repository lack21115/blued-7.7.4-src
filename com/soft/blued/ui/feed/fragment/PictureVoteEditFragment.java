package com.soft.blued.ui.feed.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.das.client.vote.VoteProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.ScalableImageView;
import com.soft.blued.log.trackUtils.EventTrackVote;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.model.ChildImageInfo;
import com.soft.blued.ui.video.fragment.AlbumSelectFragment;
import com.soft.blued.utils.BitmapUtils;
import com.soft.blued.view.tip.CommonAlertDialog;

public class PictureVoteEditFragment extends BaseFragment implements View.OnClickListener, View.OnTouchListener {
  private boolean A = false;
  
  private Context d;
  
  private View e;
  
  private CommonTopTitleNoTrans f;
  
  private View g;
  
  private FrameLayout h;
  
  private ScalableImageView i;
  
  private ImageView j;
  
  private ImageView k;
  
  private ShapeTextView l;
  
  private FrameLayout m;
  
  private ScalableImageView n;
  
  private ImageView o;
  
  private ImageView p;
  
  private ShapeTextView q;
  
  private LinearLayout r;
  
  private LinearLayout s;
  
  private LinearLayout t;
  
  private LinearLayout u;
  
  private LinearLayout v;
  
  private int w = 0;
  
  private ChildImageInfo x;
  
  private ChildImageInfo y;
  
  private boolean z = false;
  
  private void a() {
    this.f = (CommonTopTitleNoTrans)this.e.findViewById(2131300273);
    this.f.setLeftClickListener(this);
    this.f.setRightClickListener(this);
    m();
  }
  
  public static void a(Fragment paramFragment, int paramInt) {
    TerminalActivity.a(paramFragment, PictureVoteEditFragment.class, new Bundle(), paramInt);
  }
  
  private void a(ScalableImageView paramScalableImageView) {
    if (!paramScalableImageView.a()) {
      paramScalableImageView.a(1.15F);
      return;
    } 
    AppMethods.d(2131758393);
  }
  
  private void b(ScalableImageView paramScalableImageView) {
    if (!paramScalableImageView.b()) {
      paramScalableImageView.a(0.85F);
      return;
    } 
    AppMethods.d(2131758394);
  }
  
  private void c(ScalableImageView paramScalableImageView) {
    paramScalableImageView.b(90.0F);
  }
  
  private void k() {
    this.g = this.e.findViewById(2131298106);
    this.h = (FrameLayout)this.e.findViewById(2131298104);
    this.i = (ScalableImageView)this.e.findViewById(2131299965);
    this.j = (ImageView)this.e.findViewById(2131297673);
    this.k = (ImageView)this.e.findViewById(2131297742);
    this.l = (ShapeTextView)this.e.findViewById(2131300066);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.i.setOnTouchListener(this);
    this.m = (FrameLayout)this.e.findViewById(2131298105);
    this.n = (ScalableImageView)this.e.findViewById(2131299966);
    this.o = (ImageView)this.e.findViewById(2131297679);
    this.p = (ImageView)this.e.findViewById(2131297744);
    this.q = (ShapeTextView)this.e.findViewById(2131300067);
    this.o.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.n.setOnTouchListener(this);
    this.r = (LinearLayout)this.e.findViewById(2131298098);
    this.s = (LinearLayout)this.e.findViewById(2131298057);
    this.t = (LinearLayout)this.e.findViewById(2131298074);
    this.u = (LinearLayout)this.e.findViewById(2131298091);
    this.v = (LinearLayout)this.e.findViewById(2131298058);
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.v.setOnClickListener(this);
  }
  
  private void l() {
    if (SelectPhotoManager.a().c().size() > 0) {
      int i = this.w;
      if (i != 1) {
        if (i == 2) {
          this.y = SelectPhotoManager.a().c().get(0);
          this.n.a((IRequestHost)w_(), this.y.mImagePath);
          this.o.setVisibility(8);
          this.p.setVisibility(0);
          if (SelectPhotoManager.a().c().size() > 1) {
            this.x = SelectPhotoManager.a().c().get(1);
            this.i.a((IRequestHost)w_(), this.x.mImagePath);
            this.j.setVisibility(8);
            this.k.setVisibility(0);
          } 
        } 
      } else {
        this.x = SelectPhotoManager.a().c().get(0);
        this.i.a((IRequestHost)w_(), this.x.mImagePath);
        this.j.setVisibility(8);
        this.k.setVisibility(0);
        if (SelectPhotoManager.a().c().size() > 1) {
          this.y = SelectPhotoManager.a().c().get(1);
          this.n.a((IRequestHost)w_(), this.y.mImagePath);
          this.o.setVisibility(8);
          this.p.setVisibility(0);
        } 
      } 
    } 
    SelectPhotoManager.a().c().clear();
    n();
    m();
  }
  
  private void m() {
    if (this.x != null && this.y != null) {
      this.f.setRightTextColor(2131100527);
      return;
    } 
    this.f.setRightTextColor(2131100555);
  }
  
  private void n() {
    if (this.x != null && this.y == null) {
      this.w = 1;
    } else if (this.x == null && this.y != null) {
      this.w = 2;
    } 
    int i = this.w;
    if (i != 1) {
      if (i != 2) {
        this.l.setVisibility(8);
        this.q.setVisibility(8);
        this.r.setVisibility(8);
        return;
      } 
      this.l.setVisibility(8);
      this.q.setVisibility(0);
      this.r.setVisibility(0);
      return;
    } 
    this.l.setVisibility(0);
    this.q.setVisibility(8);
    this.r.setVisibility(0);
  }
  
  private void o() {
    if (this.x == null && this.y == null) {
      getActivity().finish();
      return;
    } 
    Context context = this.d;
    CommonAlertDialog.a(context, context.getResources().getString(2131758386), this.d.getResources().getString(2131758387), this.d.getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            this.a.getActivity().finish();
          }
        },  this.d.getResources().getString(2131755726), null, null);
  }
  
  private void p() {
    if (this.x != null) {
      if (this.y == null)
        return; 
      this.k.setVisibility(8);
      this.l.setVisibility(8);
      this.p.setVisibility(8);
      this.q.setVisibility(8);
      Bitmap bitmap = BitmapUtils.a(this.g);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(RecyclingUtils.a());
      stringBuilder.append("/");
      stringBuilder.append(System.currentTimeMillis());
      stringBuilder.append(".jpg");
      String str = stringBuilder.toString();
      ImageUtils.b(bitmap, str, 100);
      Intent intent = new Intent();
      intent.putExtra("voting_picture_path", str);
      getActivity().setResult(-1, intent);
      getActivity().finish();
    } 
  }
  
  private void q() {
    this.z = true;
    int j = this.h.getMeasuredWidth() + DensityUtils.a(this.d, 3.0F);
    int m = this.h.getMeasuredHeight() / 2;
    ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(this.h, "scaleX", new float[] { 0.5F });
    ObjectAnimator objectAnimator4 = ObjectAnimator.ofFloat(this.h, "scaleY", new float[] { 0.5F });
    ObjectAnimator objectAnimator7 = ObjectAnimator.ofFloat(this.m, "scaleX", new float[] { 0.5F });
    ObjectAnimator objectAnimator9 = ObjectAnimator.ofFloat(this.m, "scaleY", new float[] { 0.5F });
    AnimatorSet animatorSet = new AnimatorSet();
    animatorSet.play((Animator)objectAnimator2).with((Animator)objectAnimator4).with((Animator)objectAnimator7).with((Animator)objectAnimator9);
    animatorSet.setDuration(500L);
    animatorSet.start();
    objectAnimator2 = ObjectAnimator.ofFloat(this.h, "translationX", new float[] { (j / 2) });
    FrameLayout frameLayout2 = this.h;
    int k = -m;
    if (this.A) {
      i = -1;
    } else {
      i = 1;
    } 
    ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(frameLayout2, "translationY", new float[] { (k * i) });
    FrameLayout frameLayout4 = this.m;
    k = -j;
    ObjectAnimator objectAnimator6 = ObjectAnimator.ofFloat(frameLayout4, "translationX", new float[] { (k / 2) });
    FrameLayout frameLayout5 = this.m;
    if (this.A) {
      i = -1;
    } else {
      i = 1;
    } 
    ObjectAnimator objectAnimator8 = ObjectAnimator.ofFloat(frameLayout5, "translationY", new float[] { (m * i) });
    animatorSet = new AnimatorSet();
    animatorSet.play((Animator)objectAnimator2).with((Animator)objectAnimator3).with((Animator)objectAnimator6).with((Animator)objectAnimator8);
    animatorSet.setDuration(500L);
    animatorSet.setStartDelay(500L);
    animatorSet.start();
    FrameLayout frameLayout1 = this.h;
    int i = j;
    if (this.A)
      i = 0; 
    ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(frameLayout1, "translationX", new float[] { i });
    objectAnimator3 = ObjectAnimator.ofFloat(this.h, "translationY", new float[] { 0.0F });
    FrameLayout frameLayout3 = this.m;
    i = k;
    if (this.A)
      i = 0; 
    ObjectAnimator objectAnimator5 = ObjectAnimator.ofFloat(frameLayout3, "translationX", new float[] { i });
    objectAnimator8 = ObjectAnimator.ofFloat(this.m, "translationY", new float[] { 0.0F });
    animatorSet = new AnimatorSet();
    animatorSet.play((Animator)objectAnimator1).with((Animator)objectAnimator3).with((Animator)objectAnimator5).with((Animator)objectAnimator8);
    animatorSet.setDuration(500L);
    animatorSet.setStartDelay(1000L);
    animatorSet.start();
    objectAnimator1 = ObjectAnimator.ofFloat(this.h, "scaleX", new float[] { 1.0F });
    objectAnimator3 = ObjectAnimator.ofFloat(this.h, "scaleY", new float[] { 1.0F });
    objectAnimator5 = ObjectAnimator.ofFloat(this.m, "scaleX", new float[] { 1.0F });
    objectAnimator8 = ObjectAnimator.ofFloat(this.m, "scaleY", new float[] { 1.0F });
    animatorSet = new AnimatorSet();
    animatorSet.play((Animator)objectAnimator1).with((Animator)objectAnimator3).with((Animator)objectAnimator5).with((Animator)objectAnimator8);
    animatorSet.setDuration(500L);
    animatorSet.setStartDelay(1500L);
    animatorSet.start();
    animatorSet.addListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this) {
          public void onAnimationEnd(Animator param1Animator) {
            super.onAnimationEnd(param1Animator);
            PictureVoteEditFragment.a(this.a, false);
            PictureVoteEditFragment pictureVoteEditFragment = this.a;
            PictureVoteEditFragment.b(pictureVoteEditFragment, PictureVoteEditFragment.a(pictureVoteEditFragment) ^ true);
          }
        });
  }
  
  public boolean V_() {
    o();
    return true;
  }
  
  public void onClick(View paramView) {
    if (this.z)
      return; 
    int j = paramView.getId();
    int i = 2;
    switch (j) {
      default:
        return;
      case 2131298091:
        EventTrackVote.a(VoteProtos.Event.VOTE_EDIT_PAGE_TURN_BTN_CLICK);
        i = this.w;
        if (i != 1) {
          if (i != 2)
            return; 
          c(this.n);
          return;
        } 
        c(this.i);
        return;
      case 2131298074:
        EventTrackVote.a(VoteProtos.Event.VOTE_EDIT_PAGE_SMALL_BTN_CLICK);
        i = this.w;
        if (i != 1) {
          if (i != 2)
            return; 
          b(this.n);
          return;
        } 
        b(this.i);
        return;
      case 2131298058:
        EventTrackVote.a(VoteProtos.Event.VOTE_EDIT_PAGE_CHANGE_BTN_CLICK);
        q();
        return;
      case 2131298057:
        EventTrackVote.a(VoteProtos.Event.VOTE_EDIT_PAGE_BIG_BTN_CLICK);
        i = this.w;
        if (i != 1) {
          if (i != 2)
            return; 
          a(this.n);
          return;
        } 
        a(this.i);
        return;
      case 2131297744:
        this.w = 0;
        this.y = null;
        this.n.setImageDrawable(null);
        this.o.setVisibility(0);
        this.p.setVisibility(8);
        n();
        m();
        return;
      case 2131297742:
        this.w = 0;
        this.x = null;
        this.i.setImageDrawable(null);
        this.j.setVisibility(0);
        this.k.setVisibility(8);
        n();
        m();
        return;
      case 2131297679:
        EventTrackVote.a(VoteProtos.Event.VOTE_EDIT_PAGE_UPLOAD_CLICK);
        this.w = 2;
        SelectPhotoManager.a().d();
        if (this.x != null)
          i = 1; 
        AlbumSelectFragment.a(this, 4, 1, i, 0);
        return;
      case 2131297673:
        EventTrackVote.a(VoteProtos.Event.VOTE_EDIT_PAGE_UPLOAD_CLICK);
        this.w = 1;
        SelectPhotoManager.a().d();
        if (this.y != null)
          i = 1; 
        AlbumSelectFragment.a(this, 4, 1, i, 0);
        return;
      case 2131296867:
        EventTrackVote.a(VoteProtos.Event.VOTE_PHOTO_PAGE_CONFIRM_BTN_CLICK);
        p();
        return;
      case 2131296863:
        break;
    } 
    o();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493269, paramViewGroup, false);
      a();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    EventTrackVote.a(VoteProtos.Event.VOTE_EDIT_PAGE_SHOW);
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
    SelectPhotoManager.a().c().clear();
  }
  
  public void onResume() {
    super.onResume();
    l();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getAction() == 0) {
      switch (paramView.getId()) {
        case 2131299966:
          if (this.y != null)
            this.w = 2; 
          break;
        case 2131299965:
          if (this.x != null)
            this.w = 1; 
          break;
      } 
      n();
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\PictureVoteEditFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */