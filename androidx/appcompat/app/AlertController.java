package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

class AlertController {
  private int A;
  
  private boolean B = false;
  
  private CharSequence C;
  
  private Drawable D;
  
  private CharSequence E;
  
  private Drawable F;
  
  private CharSequence G;
  
  private Drawable H;
  
  private int I = 0;
  
  private Drawable J;
  
  private ImageView K;
  
  private TextView L;
  
  private TextView M;
  
  private View N;
  
  private int O;
  
  private int P;
  
  private boolean Q;
  
  private int R = 0;
  
  private final View.OnClickListener S = new View.OnClickListener(this) {
      public void onClick(View param1View) {
        Message message;
        if (param1View == this.a.c && this.a.d != null) {
          message = Message.obtain(this.a.d);
        } else if (message == this.a.e && this.a.f != null) {
          message = Message.obtain(this.a.f);
        } else if (message == this.a.g && this.a.h != null) {
          message = Message.obtain(this.a.h);
        } else {
          message = null;
        } 
        if (message != null)
          message.sendToTarget(); 
        this.a.p.obtainMessage(1, this.a.a).sendToTarget();
      }
    };
  
  final AppCompatDialog a;
  
  ListView b;
  
  Button c;
  
  Message d;
  
  Button e;
  
  Message f;
  
  Button g;
  
  Message h;
  
  NestedScrollView i;
  
  ListAdapter j;
  
  int k = -1;
  
  int l;
  
  int m;
  
  int n;
  
  int o;
  
  Handler p;
  
  private final Context q;
  
  private final Window r;
  
  private final int s;
  
  private CharSequence t;
  
  private CharSequence u;
  
  private View v;
  
  private int w;
  
  private int x;
  
  private int y;
  
  private int z;
  
  public AlertController(Context paramContext, AppCompatDialog paramAppCompatDialog, Window paramWindow) {
    this.q = paramContext;
    this.a = paramAppCompatDialog;
    this.r = paramWindow;
    this.p = new ButtonHandler((DialogInterface)paramAppCompatDialog);
    TypedArray typedArray = paramContext.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
    this.O = typedArray.getResourceId(R.styleable.AlertDialog_android_layout, 0);
    this.P = typedArray.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
    this.l = typedArray.getResourceId(R.styleable.AlertDialog_listLayout, 0);
    this.m = typedArray.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
    this.n = typedArray.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
    this.o = typedArray.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
    this.Q = typedArray.getBoolean(R.styleable.AlertDialog_showTitle, true);
    this.s = typedArray.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
    typedArray.recycle();
    paramAppCompatDialog.supportRequestWindowFeature(1);
  }
  
  private int a() {
    int i = this.P;
    return (i == 0) ? this.O : ((this.R == 1) ? i : this.O);
  }
  
  private ViewGroup a(View paramView1, View paramView2) {
    if (paramView1 == null) {
      paramView1 = paramView2;
      if (paramView2 instanceof ViewStub)
        paramView1 = ((ViewStub)paramView2).inflate(); 
      return (ViewGroup)paramView1;
    } 
    if (paramView2 != null) {
      ViewParent viewParent = paramView2.getParent();
      if (viewParent instanceof ViewGroup)
        ((ViewGroup)viewParent).removeView(paramView2); 
    } 
    paramView2 = paramView1;
    if (paramView1 instanceof ViewStub)
      paramView2 = ((ViewStub)paramView1).inflate(); 
    return (ViewGroup)paramView2;
  }
  
  static void a(View paramView1, View paramView2, View paramView3) {
    boolean bool = false;
    if (paramView2 != null) {
      byte b;
      if (paramView1.canScrollVertically(-1)) {
        b = 0;
      } else {
        b = 4;
      } 
      paramView2.setVisibility(b);
    } 
    if (paramView3 != null) {
      byte b;
      if (paramView1.canScrollVertically(1)) {
        b = bool;
      } else {
        b = 4;
      } 
      paramView3.setVisibility(b);
    } 
  }
  
  private void a(ViewGroup paramViewGroup) {
    View view = this.v;
    boolean bool = false;
    if (view == null)
      if (this.w != 0) {
        view = LayoutInflater.from(this.q).inflate(this.w, paramViewGroup, false);
      } else {
        view = null;
      }  
    if (view != null)
      bool = true; 
    if (!bool || !a(view))
      this.r.setFlags(131072, 131072); 
    if (bool) {
      FrameLayout frameLayout = (FrameLayout)this.r.findViewById(R.id.custom);
      frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
      if (this.B)
        frameLayout.setPadding(this.x, this.y, this.z, this.A); 
      if (this.b != null) {
        ((LinearLayoutCompat.LayoutParams)paramViewGroup.getLayoutParams()).weight = 0.0F;
        return;
      } 
    } else {
      paramViewGroup.setVisibility(8);
    } 
  }
  
  private void a(ViewGroup paramViewGroup, View paramView, int paramInt1, int paramInt2) {
    View view2 = this.r.findViewById(R.id.scrollIndicatorUp);
    View view1 = this.r.findViewById(R.id.scrollIndicatorDown);
    if (Build.VERSION.SDK_INT >= 23) {
      ViewCompat.setScrollIndicators(paramView, paramInt1, paramInt2);
      if (view2 != null)
        paramViewGroup.removeView(view2); 
      if (view1 != null) {
        paramViewGroup.removeView(view1);
        return;
      } 
    } else {
      View view = null;
      paramView = view2;
      if (view2 != null) {
        paramView = view2;
        if ((paramInt1 & 0x1) == 0) {
          paramViewGroup.removeView(view2);
          paramView = null;
        } 
      } 
      if (view1 != null && (paramInt1 & 0x2) == 0) {
        paramViewGroup.removeView(view1);
        view1 = view;
      } 
      if (paramView != null || view1 != null) {
        if (this.u != null) {
          this.i.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener(this, paramView, view1) {
                public void onScrollChange(NestedScrollView param1NestedScrollView, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
                  AlertController.a((View)param1NestedScrollView, this.a, this.b);
                }
              });
          this.i.post(new Runnable(this, paramView, view1) {
                public void run() {
                  AlertController.a((View)this.c.i, this.a, this.b);
                }
              });
          return;
        } 
        ListView listView = this.b;
        if (listView != null) {
          listView.setOnScrollListener(new AbsListView.OnScrollListener(this, paramView, view1) {
                public void onScroll(AbsListView param1AbsListView, int param1Int1, int param1Int2, int param1Int3) {
                  AlertController.a((View)param1AbsListView, this.a, this.b);
                }
                
                public void onScrollStateChanged(AbsListView param1AbsListView, int param1Int) {}
              });
          this.b.post(new Runnable(this, paramView, view1) {
                public void run() {
                  AlertController.a((View)this.c.b, this.a, this.b);
                }
              });
          return;
        } 
        if (paramView != null)
          paramViewGroup.removeView(paramView); 
        if (view1 != null)
          paramViewGroup.removeView(view1); 
      } 
    } 
  }
  
  private void a(Button paramButton) {
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)paramButton.getLayoutParams();
    layoutParams.gravity = 1;
    layoutParams.weight = 0.5F;
    paramButton.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  private static boolean a(Context paramContext) {
    TypedValue typedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
    return (typedValue.data != 0);
  }
  
  static boolean a(View paramView) {
    if (paramView.onCheckIsTextEditor())
      return true; 
    if (!(paramView instanceof ViewGroup))
      return false; 
    ViewGroup viewGroup = (ViewGroup)paramView;
    int i = viewGroup.getChildCount();
    while (i > 0) {
      int j = i - 1;
      i = j;
      if (a(viewGroup.getChildAt(j)))
        return true; 
    } 
    return false;
  }
  
  private void b() {
    int i;
    int j;
    boolean bool;
    View view4 = this.r.findViewById(R.id.parentPanel);
    View view3 = view4.findViewById(R.id.topPanel);
    View view2 = view4.findViewById(R.id.contentPanel);
    View view1 = view4.findViewById(R.id.buttonPanel);
    ViewGroup viewGroup4 = (ViewGroup)view4.findViewById(R.id.customPanel);
    a(viewGroup4);
    View view7 = viewGroup4.findViewById(R.id.topPanel);
    View view6 = viewGroup4.findViewById(R.id.contentPanel);
    View view5 = viewGroup4.findViewById(R.id.buttonPanel);
    ViewGroup viewGroup3 = a(view7, view3);
    ViewGroup viewGroup2 = a(view6, view2);
    ViewGroup viewGroup1 = a(view5, view1);
    c(viewGroup2);
    d(viewGroup1);
    b(viewGroup3);
    byte b = 0;
    if (viewGroup4 != null && viewGroup4.getVisibility() != 8) {
      i = 1;
    } else {
      i = 0;
    } 
    if (viewGroup3 != null && viewGroup3.getVisibility() != 8) {
      j = 1;
    } else {
      j = 0;
    } 
    if (viewGroup1 != null && viewGroup1.getVisibility() != 8) {
      bool = true;
    } else {
      bool = false;
    } 
    if (!bool && viewGroup2 != null) {
      View view = viewGroup2.findViewById(R.id.textSpacerNoButtons);
      if (view != null)
        view.setVisibility(0); 
    } 
    if (j) {
      View view;
      NestedScrollView nestedScrollView = this.i;
      if (nestedScrollView != null)
        nestedScrollView.setClipToPadding(true); 
      nestedScrollView = null;
      if (this.u != null || this.b != null)
        view = viewGroup3.findViewById(R.id.titleDividerNoCustom); 
      if (view != null)
        view.setVisibility(0); 
    } else if (viewGroup2 != null) {
      View view = viewGroup2.findViewById(R.id.textSpacerNoTitle);
      if (view != null)
        view.setVisibility(0); 
    } 
    ListView listView = this.b;
    if (listView instanceof RecycleListView)
      ((RecycleListView)listView).setHasDecor(j, bool); 
    if (!i) {
      NestedScrollView nestedScrollView;
      listView = this.b;
      if (listView == null)
        nestedScrollView = this.i; 
      if (nestedScrollView != null) {
        i = b;
        if (bool)
          i = 2; 
        a(viewGroup2, (View)nestedScrollView, j | i, 3);
      } 
    } 
    listView = this.b;
    if (listView != null) {
      ListAdapter listAdapter = this.j;
      if (listAdapter != null) {
        listView.setAdapter(listAdapter);
        i = this.k;
        if (i > -1) {
          listView.setItemChecked(i, true);
          listView.setSelection(i);
        } 
      } 
    } 
  }
  
  private void b(ViewGroup paramViewGroup) {
    Drawable drawable;
    if (this.N != null) {
      ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
      paramViewGroup.addView(this.N, 0, layoutParams);
      this.r.findViewById(R.id.title_template).setVisibility(8);
      return;
    } 
    this.K = (ImageView)this.r.findViewById(16908294);
    if ((TextUtils.isEmpty(this.t) ^ true) != 0 && this.Q) {
      this.L = (TextView)this.r.findViewById(R.id.alertTitle);
      this.L.setText(this.t);
      int i = this.I;
      if (i != 0) {
        this.K.setImageResource(i);
        return;
      } 
      drawable = this.J;
      if (drawable != null) {
        this.K.setImageDrawable(drawable);
        return;
      } 
      this.L.setPadding(this.K.getPaddingLeft(), this.K.getPaddingTop(), this.K.getPaddingRight(), this.K.getPaddingBottom());
      this.K.setVisibility(8);
      return;
    } 
    this.r.findViewById(R.id.title_template).setVisibility(8);
    this.K.setVisibility(8);
    drawable.setVisibility(8);
  }
  
  private void c(ViewGroup paramViewGroup) {
    this.i = (NestedScrollView)this.r.findViewById(R.id.scrollView);
    this.i.setFocusable(false);
    this.i.setNestedScrollingEnabled(false);
    this.M = (TextView)paramViewGroup.findViewById(16908299);
    TextView textView = this.M;
    if (textView == null)
      return; 
    CharSequence charSequence = this.u;
    if (charSequence != null) {
      textView.setText(charSequence);
      return;
    } 
    textView.setVisibility(8);
    this.i.removeView((View)this.M);
    if (this.b != null) {
      paramViewGroup = (ViewGroup)this.i.getParent();
      int i = paramViewGroup.indexOfChild((View)this.i);
      paramViewGroup.removeViewAt(i);
      paramViewGroup.addView((View)this.b, i, new ViewGroup.LayoutParams(-1, -1));
      return;
    } 
    paramViewGroup.setVisibility(8);
  }
  
  private void d(ViewGroup paramViewGroup) {
    int i;
    this.c = (Button)paramViewGroup.findViewById(16908313);
    this.c.setOnClickListener(this.S);
    boolean bool1 = TextUtils.isEmpty(this.C);
    boolean bool = true;
    if (bool1 && this.D == null) {
      this.c.setVisibility(8);
      i = 0;
    } else {
      this.c.setText(this.C);
      Drawable drawable = this.D;
      if (drawable != null) {
        int j = this.s;
        drawable.setBounds(0, 0, j, j);
        this.c.setCompoundDrawables(this.D, null, null, null);
      } 
      this.c.setVisibility(0);
      i = 1;
    } 
    this.e = (Button)paramViewGroup.findViewById(16908314);
    this.e.setOnClickListener(this.S);
    if (TextUtils.isEmpty(this.E) && this.F == null) {
      this.e.setVisibility(8);
    } else {
      this.e.setText(this.E);
      Drawable drawable = this.F;
      if (drawable != null) {
        int j = this.s;
        drawable.setBounds(0, 0, j, j);
        this.e.setCompoundDrawables(this.F, null, null, null);
      } 
      this.e.setVisibility(0);
      i |= 0x2;
    } 
    this.g = (Button)paramViewGroup.findViewById(16908315);
    this.g.setOnClickListener(this.S);
    if (TextUtils.isEmpty(this.G) && this.H == null) {
      this.g.setVisibility(8);
    } else {
      this.g.setText(this.G);
      Drawable drawable = this.D;
      if (drawable != null) {
        int j = this.s;
        drawable.setBounds(0, 0, j, j);
        this.c.setCompoundDrawables(this.D, null, null, null);
      } 
      this.g.setVisibility(0);
      i |= 0x4;
    } 
    if (a(this.q))
      if (i == 1) {
        a(this.c);
      } else if (i == 2) {
        a(this.e);
      } else if (i == 4) {
        a(this.g);
      }  
    if (i != 0) {
      i = bool;
    } else {
      i = 0;
    } 
    if (i == 0)
      paramViewGroup.setVisibility(8); 
  }
  
  public Button getButton(int paramInt) {
    return (paramInt != -3) ? ((paramInt != -2) ? ((paramInt != -1) ? null : this.c) : this.e) : this.g;
  }
  
  public int getIconAttributeResId(int paramInt) {
    TypedValue typedValue = new TypedValue();
    this.q.getTheme().resolveAttribute(paramInt, typedValue, true);
    return typedValue.resourceId;
  }
  
  public ListView getListView() {
    return this.b;
  }
  
  public void installContent() {
    int i = a();
    this.a.setContentView(i);
    b();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
    NestedScrollView nestedScrollView = this.i;
    return (nestedScrollView != null && nestedScrollView.executeKeyEvent(paramKeyEvent));
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent) {
    NestedScrollView nestedScrollView = this.i;
    return (nestedScrollView != null && nestedScrollView.executeKeyEvent(paramKeyEvent));
  }
  
  public void setButton(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener, Message paramMessage, Drawable paramDrawable) {
    Message message = paramMessage;
    if (paramMessage == null) {
      message = paramMessage;
      if (paramOnClickListener != null)
        message = this.p.obtainMessage(paramInt, paramOnClickListener); 
    } 
    if (paramInt != -3) {
      if (paramInt != -2) {
        if (paramInt == -1) {
          this.C = paramCharSequence;
          this.d = message;
          this.D = paramDrawable;
          return;
        } 
        throw new IllegalArgumentException("Button does not exist");
      } 
      this.E = paramCharSequence;
      this.f = message;
      this.F = paramDrawable;
      return;
    } 
    this.G = paramCharSequence;
    this.h = message;
    this.H = paramDrawable;
  }
  
  public void setButtonPanelLayoutHint(int paramInt) {
    this.R = paramInt;
  }
  
  public void setCustomTitle(View paramView) {
    this.N = paramView;
  }
  
  public void setIcon(int paramInt) {
    this.J = null;
    this.I = paramInt;
    ImageView imageView = this.K;
    if (imageView != null) {
      if (paramInt != 0) {
        imageView.setVisibility(0);
        this.K.setImageResource(this.I);
        return;
      } 
      imageView.setVisibility(8);
    } 
  }
  
  public void setIcon(Drawable paramDrawable) {
    this.J = paramDrawable;
    this.I = 0;
    ImageView imageView = this.K;
    if (imageView != null) {
      if (paramDrawable != null) {
        imageView.setVisibility(0);
        this.K.setImageDrawable(paramDrawable);
        return;
      } 
      imageView.setVisibility(8);
    } 
  }
  
  public void setMessage(CharSequence paramCharSequence) {
    this.u = paramCharSequence;
    TextView textView = this.M;
    if (textView != null)
      textView.setText(paramCharSequence); 
  }
  
  public void setTitle(CharSequence paramCharSequence) {
    this.t = paramCharSequence;
    TextView textView = this.L;
    if (textView != null)
      textView.setText(paramCharSequence); 
  }
  
  public void setView(int paramInt) {
    this.v = null;
    this.w = paramInt;
    this.B = false;
  }
  
  public void setView(View paramView) {
    this.v = paramView;
    this.w = 0;
    this.B = false;
  }
  
  public void setView(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.v = paramView;
    this.w = 0;
    this.B = true;
    this.x = paramInt1;
    this.y = paramInt2;
    this.z = paramInt3;
    this.A = paramInt4;
  }
  
  public static class AlertParams {
    public ListAdapter mAdapter;
    
    public boolean mCancelable;
    
    public int mCheckedItem = -1;
    
    public boolean[] mCheckedItems;
    
    public final Context mContext;
    
    public Cursor mCursor;
    
    public View mCustomTitleView;
    
    public boolean mForceInverseBackground;
    
    public Drawable mIcon;
    
    public int mIconAttrId = 0;
    
    public int mIconId = 0;
    
    public final LayoutInflater mInflater;
    
    public String mIsCheckedColumn;
    
    public boolean mIsMultiChoice;
    
    public boolean mIsSingleChoice;
    
    public CharSequence[] mItems;
    
    public String mLabelColumn;
    
    public CharSequence mMessage;
    
    public Drawable mNegativeButtonIcon;
    
    public DialogInterface.OnClickListener mNegativeButtonListener;
    
    public CharSequence mNegativeButtonText;
    
    public Drawable mNeutralButtonIcon;
    
    public DialogInterface.OnClickListener mNeutralButtonListener;
    
    public CharSequence mNeutralButtonText;
    
    public DialogInterface.OnCancelListener mOnCancelListener;
    
    public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
    
    public DialogInterface.OnClickListener mOnClickListener;
    
    public DialogInterface.OnDismissListener mOnDismissListener;
    
    public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    
    public DialogInterface.OnKeyListener mOnKeyListener;
    
    public OnPrepareListViewListener mOnPrepareListViewListener;
    
    public Drawable mPositiveButtonIcon;
    
    public DialogInterface.OnClickListener mPositiveButtonListener;
    
    public CharSequence mPositiveButtonText;
    
    public boolean mRecycleOnMeasure = true;
    
    public CharSequence mTitle;
    
    public View mView;
    
    public int mViewLayoutResId;
    
    public int mViewSpacingBottom;
    
    public int mViewSpacingLeft;
    
    public int mViewSpacingRight;
    
    public boolean mViewSpacingSpecified = false;
    
    public int mViewSpacingTop;
    
    public AlertParams(Context param1Context) {
      this.mContext = param1Context;
      this.mCancelable = true;
      this.mInflater = (LayoutInflater)param1Context.getSystemService("layout_inflater");
    }
    
    private void a(AlertController param1AlertController) {
      ArrayAdapter<CharSequence> arrayAdapter;
      AlertController.RecycleListView recycleListView = (AlertController.RecycleListView)this.mInflater.inflate(param1AlertController.l, null);
      if (this.mIsMultiChoice) {
        Cursor cursor = this.mCursor;
        if (cursor == null) {
          arrayAdapter = new ArrayAdapter<CharSequence>(this, this.mContext, param1AlertController.m, 16908308, this.mItems, recycleListView) {
              public View getView(int param2Int, View param2View, ViewGroup param2ViewGroup) {
                param2View = super.getView(param2Int, param2View, param2ViewGroup);
                if (this.b.mCheckedItems != null && this.b.mCheckedItems[param2Int])
                  this.a.setItemChecked(param2Int, true); 
                return param2View;
              }
            };
        } else {
          CursorAdapter cursorAdapter = new CursorAdapter(this, this.mContext, (Cursor)arrayAdapter, false, recycleListView, param1AlertController) {
              private final int d;
              
              private final int e;
              
              public void bindView(View param2View, Context param2Context, Cursor param2Cursor) {
                ((CheckedTextView)param2View.findViewById(16908308)).setText(param2Cursor.getString(this.d));
                AlertController.RecycleListView recycleListView = this.a;
                int i = param2Cursor.getPosition();
                int j = param2Cursor.getInt(this.e);
                boolean bool = true;
                if (j != 1)
                  bool = false; 
                recycleListView.setItemChecked(i, bool);
              }
              
              public View newView(Context param2Context, Cursor param2Cursor, ViewGroup param2ViewGroup) {
                return this.c.mInflater.inflate(this.b.m, param2ViewGroup, false);
              }
            };
        } 
      } else {
        int i;
        if (this.mIsSingleChoice) {
          i = param1AlertController.n;
        } else {
          i = param1AlertController.o;
        } 
        Cursor cursor = this.mCursor;
        if (cursor != null) {
          SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this.mContext, i, cursor, new String[] { this.mLabelColumn }, new int[] { 16908308 });
        } else {
          ListAdapter listAdapter = this.mAdapter;
          if (listAdapter == null)
            arrayAdapter = new AlertController.CheckedItemAdapter(this.mContext, i, 16908308, this.mItems); 
        } 
      } 
      OnPrepareListViewListener onPrepareListViewListener = this.mOnPrepareListViewListener;
      if (onPrepareListViewListener != null)
        onPrepareListViewListener.onPrepareListView(recycleListView); 
      param1AlertController.j = (ListAdapter)arrayAdapter;
      param1AlertController.k = this.mCheckedItem;
      if (this.mOnClickListener != null) {
        recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener(this, param1AlertController) {
              public void onItemClick(AdapterView<?> param2AdapterView, View param2View, int param2Int, long param2Long) {
                this.b.mOnClickListener.onClick((DialogInterface)this.a.a, param2Int);
                if (!this.b.mIsSingleChoice)
                  this.a.a.dismiss(); 
              }
            });
      } else if (this.mOnCheckboxClickListener != null) {
        recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener(this, recycleListView, param1AlertController) {
              public void onItemClick(AdapterView<?> param2AdapterView, View param2View, int param2Int, long param2Long) {
                if (this.c.mCheckedItems != null)
                  this.c.mCheckedItems[param2Int] = this.a.isItemChecked(param2Int); 
                this.c.mOnCheckboxClickListener.onClick((DialogInterface)this.b.a, param2Int, this.a.isItemChecked(param2Int));
              }
            });
      } 
      AdapterView.OnItemSelectedListener onItemSelectedListener = this.mOnItemSelectedListener;
      if (onItemSelectedListener != null)
        recycleListView.setOnItemSelectedListener(onItemSelectedListener); 
      if (this.mIsSingleChoice) {
        recycleListView.setChoiceMode(1);
      } else if (this.mIsMultiChoice) {
        recycleListView.setChoiceMode(2);
      } 
      param1AlertController.b = recycleListView;
    }
    
    public void apply(AlertController param1AlertController) {
      View view2 = this.mCustomTitleView;
      if (view2 != null) {
        param1AlertController.setCustomTitle(view2);
      } else {
        CharSequence charSequence1 = this.mTitle;
        if (charSequence1 != null)
          param1AlertController.setTitle(charSequence1); 
        Drawable drawable = this.mIcon;
        if (drawable != null)
          param1AlertController.setIcon(drawable); 
        int j = this.mIconId;
        if (j != 0)
          param1AlertController.setIcon(j); 
        j = this.mIconAttrId;
        if (j != 0)
          param1AlertController.setIcon(param1AlertController.getIconAttributeResId(j)); 
      } 
      CharSequence charSequence = this.mMessage;
      if (charSequence != null)
        param1AlertController.setMessage(charSequence); 
      if (this.mPositiveButtonText != null || this.mPositiveButtonIcon != null)
        param1AlertController.setButton(-1, this.mPositiveButtonText, this.mPositiveButtonListener, null, this.mPositiveButtonIcon); 
      if (this.mNegativeButtonText != null || this.mNegativeButtonIcon != null)
        param1AlertController.setButton(-2, this.mNegativeButtonText, this.mNegativeButtonListener, null, this.mNegativeButtonIcon); 
      if (this.mNeutralButtonText != null || this.mNeutralButtonIcon != null)
        param1AlertController.setButton(-3, this.mNeutralButtonText, this.mNeutralButtonListener, null, this.mNeutralButtonIcon); 
      if (this.mItems != null || this.mCursor != null || this.mAdapter != null)
        a(param1AlertController); 
      View view1 = this.mView;
      if (view1 != null) {
        if (this.mViewSpacingSpecified) {
          param1AlertController.setView(view1, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
          return;
        } 
        param1AlertController.setView(view1);
        return;
      } 
      int i = this.mViewLayoutResId;
      if (i != 0)
        param1AlertController.setView(i); 
    }
    
    public static interface OnPrepareListViewListener {
      void onPrepareListView(ListView param2ListView);
    }
  }
  
  class null extends ArrayAdapter<CharSequence> {
    null(AlertController this$0, Context param1Context, int param1Int1, int param1Int2, CharSequence[] param1ArrayOfCharSequence, AlertController.RecycleListView param1RecycleListView) {
      super(param1Context, param1Int1, param1Int2, (Object[])param1ArrayOfCharSequence);
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      param1View = super.getView(param1Int, param1View, param1ViewGroup);
      if (this.b.mCheckedItems != null && this.b.mCheckedItems[param1Int])
        this.a.setItemChecked(param1Int, true); 
      return param1View;
    }
  }
  
  class null extends CursorAdapter {
    private final int d;
    
    private final int e;
    
    null(AlertController this$0, Context param1Context, Cursor param1Cursor, boolean param1Boolean, AlertController.RecycleListView param1RecycleListView, AlertController param1AlertController) {
      super(param1Context, param1Cursor, param1Boolean);
      Cursor cursor = getCursor();
      this.d = cursor.getColumnIndexOrThrow(this.c.mLabelColumn);
      this.e = cursor.getColumnIndexOrThrow(this.c.mIsCheckedColumn);
    }
    
    public void bindView(View param1View, Context param1Context, Cursor param1Cursor) {
      ((CheckedTextView)param1View.findViewById(16908308)).setText(param1Cursor.getString(this.d));
      AlertController.RecycleListView recycleListView = this.a;
      int i = param1Cursor.getPosition();
      int j = param1Cursor.getInt(this.e);
      boolean bool = true;
      if (j != 1)
        bool = false; 
      recycleListView.setItemChecked(i, bool);
    }
    
    public View newView(Context param1Context, Cursor param1Cursor, ViewGroup param1ViewGroup) {
      return this.c.mInflater.inflate(this.b.m, param1ViewGroup, false);
    }
  }
  
  class null implements AdapterView.OnItemClickListener {
    null(AlertController this$0, AlertController param1AlertController) {}
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      this.b.mOnClickListener.onClick((DialogInterface)this.a.a, param1Int);
      if (!this.b.mIsSingleChoice)
        this.a.a.dismiss(); 
    }
  }
  
  class null implements AdapterView.OnItemClickListener {
    null(AlertController this$0, AlertController.RecycleListView param1RecycleListView, AlertController param1AlertController) {}
    
    public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
      if (this.c.mCheckedItems != null)
        this.c.mCheckedItems[param1Int] = this.a.isItemChecked(param1Int); 
      this.c.mOnCheckboxClickListener.onClick((DialogInterface)this.b.a, param1Int, this.a.isItemChecked(param1Int));
    }
  }
  
  public static interface OnPrepareListViewListener {
    void onPrepareListView(ListView param1ListView);
  }
  
  static final class ButtonHandler extends Handler {
    private WeakReference<DialogInterface> a;
    
    public ButtonHandler(DialogInterface param1DialogInterface) {
      this.a = new WeakReference<DialogInterface>(param1DialogInterface);
    }
    
    public void handleMessage(Message param1Message) {
      int i = param1Message.what;
      if (i != -3 && i != -2 && i != -1) {
        if (i != 1)
          return; 
        ((DialogInterface)param1Message.obj).dismiss();
        return;
      } 
      ((DialogInterface.OnClickListener)param1Message.obj).onClick(this.a.get(), param1Message.what);
    }
  }
  
  static class CheckedItemAdapter extends ArrayAdapter<CharSequence> {
    public CheckedItemAdapter(Context param1Context, int param1Int1, int param1Int2, CharSequence[] param1ArrayOfCharSequence) {
      super(param1Context, param1Int1, param1Int2, (Object[])param1ArrayOfCharSequence);
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public boolean hasStableIds() {
      return true;
    }
  }
  
  public static class RecycleListView extends ListView {
    private final int a;
    
    private final int b;
    
    public RecycleListView(Context param1Context) {
      this(param1Context, (AttributeSet)null);
    }
    
    public RecycleListView(Context param1Context, AttributeSet param1AttributeSet) {
      super(param1Context, param1AttributeSet);
      TypedArray typedArray = param1Context.obtainStyledAttributes(param1AttributeSet, R.styleable.RecycleListView);
      this.b = typedArray.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
      this.a = typedArray.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
    }
    
    public void setHasDecor(boolean param1Boolean1, boolean param1Boolean2) {
      if (!param1Boolean2 || !param1Boolean1) {
        int i;
        int j;
        int k = getPaddingLeft();
        if (param1Boolean1) {
          i = getPaddingTop();
        } else {
          i = this.a;
        } 
        int m = getPaddingRight();
        if (param1Boolean2) {
          j = getPaddingBottom();
        } else {
          j = this.b;
        } 
        setPadding(k, i, m, j);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\app\AlertController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */