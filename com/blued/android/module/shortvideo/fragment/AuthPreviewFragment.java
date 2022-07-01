package com.blued.android.module.shortvideo.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IAuthPreviewView;
import com.blued.android.module.shortvideo.presenter.AuthPreviewPresenter;
import com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent;

public class AuthPreviewFragment extends ShortVideoBaseFragment<IAuthPreviewView, AuthPreviewPresenter> implements View.OnClickListener, IAuthPreviewView {
  private Context A;
  
  private LinearLayout e;
  
  private LinearLayout f;
  
  private TextView s;
  
  private TextView t;
  
  private TextView u;
  
  private TextView v;
  
  private TextView w;
  
  private ImageView x;
  
  private VideoView y;
  
  private ImageView z;
  
  private void a(int paramInt, boolean paramBoolean) {
    Intent intent = new Intent();
    intent.putExtra("auth_upload_state", paramBoolean);
    getActivity().setResult(paramInt, intent);
    getActivity().finish();
  }
  
  public static void a(BaseFragment paramBaseFragment, String paramString, int paramInt1, int paramInt2) {
    Bundle bundle = new Bundle();
    bundle.putString("video_path", paramString);
    bundle.putInt("from", paramInt1);
    TerminalActivity.a(bundle);
    TerminalActivity.b(bundle);
    TerminalActivity.a((Fragment)paramBaseFragment, AuthPreviewFragment.class, bundle, paramInt2);
  }
  
  private void u() {
    this.w.setText(getString(R.string.auth_prompt_top));
  }
  
  private void v() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this.A);
    builder.setMessage(getString(R.string.auth_stop_video_upload));
    builder.setTitle(getString(R.string.hint));
    builder.setPositiveButton(getString(R.string.auth_over), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (this.a.p != null)
              this.a.p.h(); 
            param1DialogInterface.dismiss();
            this.a.a(false);
          }
        });
    builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            param1DialogInterface.dismiss();
          }
        });
    builder.create().show();
  }
  
  private void w() {
    ab_();
    if (this.p != null)
      this.p.h(); 
    b();
  }
  
  public boolean V_() {
    v();
    return true;
  }
  
  public void Y_() {
    a(100.0F);
    a(true);
  }
  
  public void Z_() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this.A);
    builder.setTitle(getString(R.string.hint));
    builder.setMessage(getString(R.string.auth_notify_fail));
    builder.setPositiveButton(getString(R.string.auth_notify_try_again), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (this.a.p != null)
              this.a.p.j(); 
          }
        });
    builder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            AuthPreviewFragment.d(this.a);
          }
        });
    builder.create().show();
  }
  
  public VideoView a() {
    return this.y;
  }
  
  protected AuthPreviewPresenter a(Bundle paramBundle) {
    return new AuthPreviewPresenter(paramBundle);
  }
  
  public void a(float paramFloat) {
    AppInfo.n().post(new Runnable(this, paramFloat) {
          public void run() {
            AuthPreviewFragment.a(this.b).setVisibility(0);
            AuthPreviewFragment.b(this.b).setVisibility(8);
            TextView textView = AuthPreviewFragment.c(this.b);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.b.getString(R.string.uploading));
            stringBuilder.append(this.a);
            stringBuilder.append("%");
            textView.setText(stringBuilder.toString());
          }
        });
  }
  
  public void a(String paramString) {
    if (!TextUtils.isEmpty(paramString)) {
      this.w.setText(paramString);
    } else {
      this.w.setText(getString(R.string.auth_error_top));
    } 
    this.s.setEnabled(true);
    this.t.setEnabled(true);
  }
  
  public void a(boolean paramBoolean) {
    a(-1, paramBoolean);
  }
  
  public void a_(Runnable paramRunnable, long paramLong) {
    a(paramRunnable, paramLong);
  }
  
  public void b() {
    a(0, false);
  }
  
  protected void b(Bundle paramBundle) {
    this.z = (ImageView)this.r.findViewById(R.id.iv_back);
    this.s = (TextView)this.r.findViewById(R.id.upload_btn);
    this.t = (TextView)this.r.findViewById(R.id.re_recorder_btn);
    this.e = (LinearLayout)this.r.findViewById(R.id.upload_video_layout);
    this.f = (LinearLayout)this.r.findViewById(R.id.upload_btn_layout);
    this.u = (TextView)this.r.findViewById(R.id.upload_video_text);
    this.v = (TextView)this.r.findViewById(R.id.upload_video_cancel);
    this.w = (TextView)this.r.findViewById(R.id.prompt_top);
    this.x = (ImageView)this.r.findViewById(R.id.video_play_btn);
    this.y = (VideoView)this.r.findViewById(R.id.stv_auth_videoview);
    u();
  }
  
  public void c(boolean paramBoolean) {}
  
  public void d() {
    ImageView imageView = this.x;
    if (imageView != null)
      imageView.setVisibility(0); 
  }
  
  public void e() {
    ImageView imageView = this.x;
    if (imageView != null)
      imageView.setVisibility(8); 
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == R.id.upload_btn) {
      if (this.p != null) {
        this.s.setEnabled(false);
        this.t.setEnabled(false);
        a(30.0F);
        this.p.i();
        return;
      } 
    } else {
      if (i == R.id.re_recorder_btn) {
        w();
        return;
      } 
      if (i == R.id.upload_video_cancel) {
        v();
        return;
      } 
      if (i == R.id.iv_back)
        v(); 
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    getActivity().getWindow().setSoftInputMode(19);
    super.onCreate(paramBundle);
    this.A = getContext();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    a(paramLayoutInflater, R.layout.auth_upload_video_v, paramViewGroup, paramBundle);
    return (View)this.r;
  }
  
  public void onPause() {
    super.onPause();
  }
  
  protected void t() {
    this.e.setVisibility(4);
    this.f.setVisibility(0);
    this.s.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.z.setOnClickListener(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\fragment\AuthPreviewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */