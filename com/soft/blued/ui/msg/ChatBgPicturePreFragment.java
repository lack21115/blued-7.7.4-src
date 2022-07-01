package com.soft.blued.ui.msg;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.media.selector.fragment.PhotoDetailFragment;
import com.soft.blued.ui.photo.fragment.BizPhotoDetailFragment;

public class ChatBgPicturePreFragment extends BizPhotoDetailFragment implements PhotoDetailFragment.GetConfigCallback {
  public static void a(BaseFragment paramBaseFragment, String paramString, int paramInt1, LoadOptions paramLoadOptions, boolean paramBoolean, int paramInt2) {
    Bundle bundle = a(paramString, paramLoadOptions, paramBoolean, false);
    bundle.putInt("come_code", paramInt1);
    TerminalActivity.a(bundle);
    TerminalActivity.b(bundle);
    TerminalActivity.a((Fragment)paramBaseFragment, ChatBgPicturePreFragment.class, bundle, paramInt2);
  }
  
  public View a() {
    View view = getActivity().getLayoutInflater().inflate(2131492937, null);
    ((ImageView)view.findViewById(2131296863)).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    return view;
  }
  
  public View b() {
    View view = getActivity().getLayoutInflater().inflate(2131494137, null);
    ((TextView)view.findViewById(2131296697)).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            Intent intent = new Intent();
            intent.putExtra("photo_path", ChatBgPicturePreFragment.a(this.a));
            this.a.getActivity().setResult(-1, intent);
            this.a.getActivity().finish();
          }
        });
    return view;
  }
  
  public ImageView.ScaleType c() {
    return ImageView.ScaleType.CENTER_CROP;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    a(this);
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\ChatBgPicturePreFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */