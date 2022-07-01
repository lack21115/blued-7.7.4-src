package com.soft.blued.ui.circle.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.soft.blued.customview.EditInputNumView;
import com.soft.blued.customview.emoji.manager.Emoji;
import com.soft.blued.customview.emoji.view.EmojiKeyboardLayout;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.feed.adapter.FeedPostImageAdapter;
import com.soft.blued.ui.feed.manager.ChildPhotoManager;
import com.soft.blued.ui.feed.manager.SelectPhotoManager;
import com.soft.blued.ui.feed.model.BluedIngSelfFeed;
import com.soft.blued.ui.msg.customview.Emotion;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.video.fragment.AlbumSelectFragment;
import com.soft.blued.utils.ActivityChangeAnimationUtils;
import com.soft.blued.utils.AtChooseUserHelper;
import com.soft.blued.utils.StringUtils;
import java.io.Serializable;

public class CircleCommentFragment extends KeyBoardFragment implements View.OnClickListener {
  private FrameLayout A;
  
  private CheckBox B;
  
  private ImageView C;
  
  private String D;
  
  private int E = -1;
  
  private BluedIngSelfFeed F;
  
  private FeedProtos.NoteSource G;
  
  private String H;
  
  private boolean I;
  
  private boolean J;
  
  private boolean K;
  
  private boolean L;
  
  private boolean M;
  
  private TextWatcher N = new TextWatcher(this) {
      private int b;
      
      private int c;
      
      private String d;
      
      private String e;
      
      public void afterTextChanged(Editable param1Editable) {
        try {
          this.b = CircleCommentFragment.d(this.a).getSelectionStart();
          this.c = CircleCommentFragment.d(this.a).getSelectionEnd();
          CircleCommentFragment.d(this.a).removeTextChangedListener(CircleCommentFragment.g(this.a));
          if (!CircleCommentFragment.h(this.a).a(this.a, this.d, this.e, param1Editable, this.c))
            CircleCommentFragment.d(this.a).setSelection(Math.max(CircleCommentFragment.d(this.a).getSelectionStart(), 0)); 
          CircleCommentFragment.d(this.a).addTextChangedListener(CircleCommentFragment.g(this.a));
        } catch (Exception exception) {
          exception.printStackTrace();
        } 
        CircleCommentFragment.i(this.a);
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(param1CharSequence);
        stringBuilder.append("");
        this.d = stringBuilder.toString();
      }
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(param1CharSequence);
        stringBuilder.append("");
        this.e = stringBuilder.toString();
      }
    };
  
  private Context e;
  
  private View f;
  
  private KeyboardListenLinearLayout o;
  
  private AtChooseUserHelper p;
  
  private ImageView q;
  
  private ImageView r;
  
  private EditText s;
  
  private EditInputNumView t;
  
  private ImageView u;
  
  private ShapeTextView v;
  
  private Emotion w;
  
  private EmojiKeyboardLayout x;
  
  private RecyclerView y;
  
  private FeedPostImageAdapter z;
  
  private void A() {
    this.A = (FrameLayout)this.f.findViewById(2131297084);
    this.B = (CheckBox)this.f.findViewById(2131296667);
    this.C = (ImageView)this.f.findViewById(2131297682);
    ImageLoader.a((IRequestHost)w_(), this.D).a(CircleMethods.getAnonymousHeaderRes(this.e, this.E)).c(CircleMethods.getAnonymousHeaderRes(this.e, this.E)).a(this.C);
    this.B.setEnabled(this.I);
    this.B.setClickable(this.I);
    this.B.setChecked(this.J);
    this.B.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) {
          public void onCheckedChanged(CompoundButton param1CompoundButton, boolean param1Boolean) {
            CircleCommentFragment.a(this.a).setVisibility(8);
          }
        });
    this.A.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (!CircleCommentFragment.b(this.a).isEnabled()) {
              if (CircleCommentFragment.c(this.a)) {
                AppMethods.d(2131755844);
                return;
              } 
              AppMethods.d(2131755841);
            } 
          }
        });
  }
  
  private void B() {
    this.s = (EditText)this.f.findViewById(2131296977);
    this.t = (EditInputNumView)this.f.findViewById(2131297597);
    this.w = new Emotion(this.e);
    this.t.a(this.s, 512);
    this.s.addTextChangedListener(this.N);
    this.s.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            if (param1View.getId() == 2131296977) {
              param1View.getParent().requestDisallowInterceptTouchEvent(true);
              if (param1MotionEvent.getAction() == 1)
                param1View.getParent().requestDisallowInterceptTouchEvent(false); 
            } 
            return false;
          }
        });
    a(this.H);
  }
  
  private void C() {
    this.x = (EmojiKeyboardLayout)this.f.findViewById(2131296983);
    this.x.setKeyboardColor(2);
    this.x.setFragmentManager(getChildFragmentManager());
    this.x.setEmojiCallback(new EmojiKeyboardLayout.EmojiCallback(this) {
          public void a() {
            KeyEvent keyEvent = new KeyEvent(0, 67);
            CircleCommentFragment.d(this.a).onKeyDown(67, keyEvent);
          }
          
          public void a(Emoji param1Emoji) {
            SpannableString spannableString = new SpannableString(param1Emoji.a());
            if (this.a.i.getText().length() + spannableString.length() <= 512)
              CircleCommentFragment.d(this.a).getText().insert(CircleCommentFragment.d(this.a).getSelectionStart(), (CharSequence)spannableString); 
          }
        });
  }
  
  private void D() {
    this.y = (RecyclerView)this.f.findViewById(2131299783);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(this.e, 3);
    this.y.setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
    OnItemDragListener onItemDragListener = new OnItemDragListener(this) {
        public void a(RecyclerView.ViewHolder param1ViewHolder, int param1Int) {
          ((BaseViewHolder)param1ViewHolder).b(2131296961, true);
        }
        
        public void a(RecyclerView.ViewHolder param1ViewHolder1, int param1Int1, RecyclerView.ViewHolder param1ViewHolder2, int param1Int2) {}
        
        public void b(RecyclerView.ViewHolder param1ViewHolder, int param1Int) {
          ((BaseViewHolder)param1ViewHolder).b(2131296961, false);
          CircleCommentFragment.e(this.a).d();
        }
      };
    this.z = new FeedPostImageAdapter((IRequestHost)w_());
    ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback((BaseItemDraggableAdapter)this.z);
    ItemTouchHelper itemTouchHelper = new ItemTouchHelper((ItemTouchHelper.Callback)itemDragAndSwipeCallback);
    itemTouchHelper.attachToRecyclerView(this.y);
    itemDragAndSwipeCallback.a(15);
    itemDragAndSwipeCallback.b(48);
    this.z.a();
    this.z.a(itemTouchHelper);
    this.z.a(onItemDragListener);
    this.z.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            BasePhotoFragment.a((Context)this.a.getActivity(), param1Int, 0, null);
          }
        });
    this.z.a(new BaseQuickAdapter.OnItemChildClickListener(this) {
          public void onItemChildClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            CircleCommentFragment.f(this.a);
          }
        });
    this.y.setAdapter((RecyclerView.Adapter)this.z);
  }
  
  private void E() {
    if (!F()) {
      this.x.setVisibility(8);
      int i = this.z.D();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("mPhotoAdapter.getDataListSize():");
      stringBuilder.append(SelectPhotoManager.a().c().size());
      Log.v("drb", stringBuilder.toString());
      AlbumSelectFragment.a(this, 4, 1, 9 - i, 109);
      return;
    } 
    I();
  }
  
  private boolean F() {
    if (SelectPhotoManager.a().c().size() >= 9) {
      AppMethods.a(String.format(getResources().getString(2131757865), new Object[] { Integer.valueOf(9) }));
      return true;
    } 
    return false;
  }
  
  private void G() {
    if (t()) {
      this.v.setAlpha(1.0F);
      return;
    } 
    this.v.setAlpha(0.3F);
  }
  
  private void H() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void I() {
    a(new Runnable(this) {
          public void run() {
            if (!CircleCommentFragment.d(this.a).isFocusable())
              CircleCommentFragment.d(this.a).requestFocus(); 
            KeyboardUtils.c((Activity)this.a.getActivity());
          }
        },  300L);
  }
  
  private void J() {
    Intent intent = new Intent();
    intent.putExtra("comment_content", this.s.getText().toString());
    intent.putExtra("is_anonymous", this.B.isChecked());
    intent.putExtra("is_can_change_anonymous", this.I);
    getActivity().setResult(-1, intent);
    getActivity().finish();
    ActivityChangeAnimationUtils.c((Activity)getActivity());
  }
  
  private void K() {
    Intent intent = new Intent();
    intent.putExtra("comment_content", "");
    intent.putExtra("is_anonymous", this.B.isChecked());
    intent.putExtra("is_can_change_anonymous", false);
    getActivity().setResult(-1, intent);
    getActivity().finish();
    ActivityChangeAnimationUtils.c((Activity)getActivity());
  }
  
  public static void a(BaseFragment paramBaseFragment, BluedIngSelfFeed paramBluedIngSelfFeed, String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, String paramString2, int paramInt2, FeedProtos.NoteSource paramNoteSource) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("circle_data", (Serializable)paramBluedIngSelfFeed);
    bundle.putString("comment_content", paramString1);
    bundle.putBoolean("is_can_change_anonymous", paramBoolean1);
    bundle.putBoolean("is_anonymous", paramBoolean2);
    bundle.putBoolean("is_can_anonymous", paramBoolean3);
    bundle.putInt("anonymous_header_number", paramInt1);
    bundle.putString("anonymous_header_url", paramString2);
    bundle.putSerializable("circle_from_page", (Serializable)paramNoteSource);
    TerminalActivity.a(bundle);
    TerminalActivity.a((Fragment)paramBaseFragment, CircleCommentFragment.class, bundle, paramInt2);
    if (paramBaseFragment.getActivity() instanceof Activity)
      ActivityChangeAnimationUtils.a((Activity)paramBaseFragment.getActivity()); 
  }
  
  private void a(String paramString) {
    CharSequence charSequence = StringUtils.a(StringUtils.a(paramString, (int)this.s.getTextSize(), 3), true, true, true, null, true, "", "");
    this.s.setText(charSequence);
    EditText editText = this.s;
    editText.setSelection(editText.length());
  }
  
  private void v() {
    this.z.c();
  }
  
  private void w() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.F = (BluedIngSelfFeed)bundle.getSerializable("circle_data");
      this.H = bundle.getString("comment_content");
      this.I = bundle.getBoolean("is_can_change_anonymous");
      this.J = bundle.getBoolean("is_anonymous");
      this.K = bundle.getBoolean("is_can_anonymous");
      this.E = bundle.getInt("anonymous_header_number");
      this.D = bundle.getString("anonymous_header_url");
      this.G = (FeedProtos.NoteSource)bundle.getSerializable("circle_from_page");
    } 
  }
  
  private void x() {
    if (!this.s.isFocusable()) {
      this.s.setFocusable(true);
      this.s.setFocusableInTouchMode(true);
      this.s.requestFocus();
    } 
  }
  
  private void y() {
    this.o = (KeyboardListenLinearLayout)this.f.findViewById(2131297980);
    a((View)this.x, this.o, this.s);
  }
  
  private void z() {
    this.u = (ImageView)this.f.findViewById(2131297729);
    this.v = (ShapeTextView)this.f.findViewById(2131301186);
    this.q = (ImageView)this.f.findViewById(2131297812);
    this.r = (ImageView)this.f.findViewById(2131297753);
    this.u.setOnClickListener(this);
    this.v.setOnClickListener(this);
    this.q.setOnClickListener(this);
    this.r.setOnClickListener(this);
  }
  
  public boolean V_() {
    if (this.x.getVisibility() == 0) {
      this.x.setVisibility(8);
      this.r.setImageDrawable(BluedSkinUtils.b(this.e, 2131231278));
      return true;
    } 
    J();
    return true;
  }
  
  public void e_(int paramInt) {
    if (paramInt != -3) {
      if (paramInt != -2)
        return; 
      this.L = false;
      if (this.M) {
        this.x.setVisibility(0);
        this.r.setImageDrawable(BluedSkinUtils.b(this.e, 2131232209));
      } else {
        this.r.setImageDrawable(BluedSkinUtils.b(this.e, 2131231278));
      } 
      this.M = false;
      if (this.x.getVisibility() != 0) {
        this.s.setCursorVisible(false);
        return;
      } 
    } else {
      this.L = true;
      this.x.setVisibility(8);
      this.s.setCursorVisible(true);
      this.r.setImageDrawable(BluedSkinUtils.b(this.e, 2131231278));
    } 
  }
  
  public boolean j() {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onActivityResult resultCode:");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" -- requestCode:");
    stringBuilder.append(paramInt1);
    Log.v("drb", stringBuilder.toString());
    if (paramInt2 == -1) {
      if (paramInt1 != 9090) {
        I();
      } else {
        this.p.a(this.s, paramIntent, this.N);
        I();
      } 
    } else if (paramInt1 == 9090) {
      I();
    } 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131301186:
        if (this.F != null) {
          boolean bool;
          FeedProtos.Event event = FeedProtos.Event.CIRCLE_NOTE_COMMENT;
          String str1 = this.F.circle_id;
          String str2 = this.F.feed_id;
          boolean bool1 = StringUtils.a(this.H);
          FeedProtos.FeedClass feedClass = EventTrackFeed.a(this.F);
          FeedProtos.NoteType noteType = EventTrackFeed.b(this.F);
          if (this.F.is_anonym == 1) {
            bool = true;
          } else {
            bool = false;
          } 
          EventTrackFeed.a(event, str1, str2, "", bool1, feedClass, noteType, bool, this.J, this.G);
        } 
        H();
        return;
      case 2131297812:
        E();
        return;
      case 2131297753:
        if (this.x.getVisibility() == 0) {
          KeyboardUtils.c((Activity)getActivity());
          return;
        } 
        if (this.L) {
          this.M = true;
          KeyboardUtils.a((Activity)getActivity());
          return;
        } 
        x();
        this.x.setVisibility(0);
        return;
      case 2131297729:
        break;
    } 
    J();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    getActivity().getWindow().setSoftInputMode(18);
    this.p = new AtChooseUserHelper(this.e);
    View view = this.f;
    if (view == null) {
      this.f = paramLayoutInflater.inflate(2131493090, paramViewGroup, false);
      w();
      z();
      B();
      C();
      y();
      D();
      A();
      E();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.f.getParent()).removeView(this.f);
    } 
    return this.f;
  }
  
  public void onResume() {
    super.onResume();
    v();
    x();
    G();
  }
  
  protected boolean t() {
    return !TextUtils.isEmpty(this.s.getText().toString().trim());
  }
  
  protected void u() {
    SelectPhotoManager.a().d();
    ChildPhotoManager.a().d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleCommentFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */