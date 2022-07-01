package com.blued.android.module.shortvideo.contract;

import android.opengl.GLSurfaceView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.shortvideo.model.CommonModel;

public interface IBaseView extends IView {
  GLSurfaceView a();
  
  void a(int paramInt1, int paramInt2, int paramInt3);
  
  void a(CommonModel paramCommonModel);
  
  BaseFragment b();
  
  void d();
  
  FragmentActivity getActivity();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\contract\IBaseView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */