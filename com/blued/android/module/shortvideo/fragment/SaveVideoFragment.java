package com.blued.android.module.shortvideo.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.base.shortvideo.ISaveInterface;
import com.blued.android.module.base.shortvideo.StvResultModel;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EditDataModel;
import com.blued.android.module.shortvideo.utils.StvMediaUtils;
import java.io.Serializable;

public class SaveVideoFragment extends KeyBoardFragment {
  private static String e = "from";
  
  private ProgressBar f;
  
  private TextView o;
  
  private View p;
  
  private View q;
  
  private EditDataModel r;
  
  private int s;
  
  private void a(Bundle paramBundle) {
    Bundle bundle = paramBundle;
    if (paramBundle == null)
      bundle = getArguments(); 
    if (bundle == null) {
      AppMethods.d(R.string.common_net_error);
      getActivity().finish();
      return;
    } 
    CommonModel commonModel = (CommonModel)bundle.getSerializable("commont_model");
    EditDataModel.SerializableData serializableData = (EditDataModel.SerializableData)bundle.getSerializable("serializeble_data");
    if ((serializableData == null || TextUtils.isEmpty(serializableData.getVideoPath())) && (commonModel == null || TextUtils.isEmpty(commonModel.getVideoPath()))) {
      AppMethods.d(R.string.common_net_error);
      getActivity().finish();
      return;
    } 
    this.r = new EditDataModel();
    this.r.copyModel(commonModel, serializableData);
    this.s = bundle.getInt(e);
    StvMediaUtils.a(getContext(), (CommonModel)this.r.getSerializableData(), this.r.getSerializableData(), this.s, this.r.getSerializableData().getPrePageType(), new ISaveInterface(this) {
          public void a() {
            Logger.c("StvMediaUtils", new Object[] { "onSaveVideoCanceled " });
            this.a.a(new Runnable(this) {
                  public void run() {
                    SaveVideoFragment.b(this.a.a).setVisibility(8);
                    AppMethods.d(R.string.common_net_error);
                    this.a.a.getActivity().finish();
                  }
                });
          }
          
          public void a(float param1Float) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("progress ");
            stringBuilder.append(param1Float);
            Logger.c("StvMediaUtils", new Object[] { stringBuilder.toString() });
            this.a.a(new Runnable(this, param1Float) {
                  public void run() {
                    int i = (int)(this.a * 100.0F);
                    TextView textView = SaveVideoFragment.a(this.b.a);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(i);
                    stringBuilder.append("%");
                    textView.setText(stringBuilder.toString());
                  }
                });
          }
          
          public void a(int param1Int) {
            Logger.c("StvMediaUtils", new Object[] { "onSaveFailed " });
            this.a.a(new Runnable(this) {
                  public void run() {
                    SaveVideoFragment.b(this.a.a).setVisibility(8);
                    AppMethods.d(R.string.common_net_error);
                    this.a.a.getActivity().finish();
                  }
                });
          }
          
          public void a(StvResultModel param1StvResultModel) {
            Logger.c("StvMediaUtils", new Object[] { "onSaveSucess" });
            this.a.a(new Runnable(this, param1StvResultModel) {
                  public void run() {
                    SaveVideoFragment.a(this.b.a).setText("100%");
                    SaveVideoFragment.b(this.b.a).setVisibility(8);
                    SaveVideoFragment.a(this.b.a, this.a);
                  }
                });
          }
          
          public void b() {
            if (SaveVideoFragment.c(this.a).getVisibility() != 0)
              SaveVideoFragment.c(this.a).setVisibility(0); 
          }
        });
  }
  
  private void a(StvResultModel paramStvResultModel) {
    Intent intent = new Intent();
    intent.putExtra("result_model", (Serializable)paramStvResultModel);
    intent.putExtra("close_page", true);
    getActivity().setResult(-1, intent);
    getActivity().finish();
  }
  
  public static void a(Object paramObject, Bundle paramBundle, int paramInt1, int paramInt2) {
    if (paramBundle == null)
      return; 
    paramBundle.putSerializable(e, Integer.valueOf(paramInt1));
    TerminalActivity.a(paramBundle);
    TerminalActivity.b(paramBundle);
    if (paramObject instanceof android.app.Activity) {
      TransparentActivity.b((Context)paramObject, SaveVideoFragment.class, paramBundle, paramInt2);
      return;
    } 
    if (paramObject instanceof Fragment) {
      TransparentActivity.b((Fragment)paramObject, SaveVideoFragment.class, paramBundle, paramInt2);
      return;
    } 
    if (paramObject instanceof android.app.Application)
      TransparentActivity.b((Context)paramObject, SaveVideoFragment.class, paramBundle); 
  }
  
  public boolean V_() {
    return false;
  }
  
  public void e_(int paramInt) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.q = paramLayoutInflater.inflate(R.layout.activity_stv_save, paramViewGroup, false);
    this.f = (ProgressBar)this.q.findViewById(R.id.pb);
    this.o = (TextView)this.q.findViewById(R.id.progress);
    this.p = this.q.findViewById(R.id.pblayout);
    a(paramBundle);
    return this.q;
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public void onPause() {
    super.onPause();
  }
  
  public void onResume() {
    super.onResume();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\fragment\SaveVideoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */