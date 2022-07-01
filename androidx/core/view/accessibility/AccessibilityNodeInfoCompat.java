package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AccessibilityNodeInfoCompat {
  public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
  
  public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
  
  public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
  
  public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
  
  public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
  
  public static final String ACTION_ARGUMENT_MOVE_WINDOW_X = "ACTION_ARGUMENT_MOVE_WINDOW_X";
  
  public static final String ACTION_ARGUMENT_MOVE_WINDOW_Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";
  
  public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
  
  public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
  
  public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
  
  public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
  
  public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
  
  public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
  
  public static final int ACTION_CLEAR_FOCUS = 2;
  
  public static final int ACTION_CLEAR_SELECTION = 8;
  
  public static final int ACTION_CLICK = 16;
  
  public static final int ACTION_COLLAPSE = 524288;
  
  public static final int ACTION_COPY = 16384;
  
  public static final int ACTION_CUT = 65536;
  
  public static final int ACTION_DISMISS = 1048576;
  
  public static final int ACTION_EXPAND = 262144;
  
  public static final int ACTION_FOCUS = 1;
  
  public static final int ACTION_LONG_CLICK = 32;
  
  public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
  
  public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
  
  public static final int ACTION_PASTE = 32768;
  
  public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
  
  public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
  
  public static final int ACTION_SCROLL_BACKWARD = 8192;
  
  public static final int ACTION_SCROLL_FORWARD = 4096;
  
  public static final int ACTION_SELECT = 4;
  
  public static final int ACTION_SET_SELECTION = 131072;
  
  public static final int ACTION_SET_TEXT = 2097152;
  
  public static final int FOCUS_ACCESSIBILITY = 2;
  
  public static final int FOCUS_INPUT = 1;
  
  public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
  
  public static final int MOVEMENT_GRANULARITY_LINE = 4;
  
  public static final int MOVEMENT_GRANULARITY_PAGE = 16;
  
  public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
  
  public static final int MOVEMENT_GRANULARITY_WORD = 2;
  
  private static int c;
  
  private final AccessibilityNodeInfo a;
  
  private int b = -1;
  
  public int mParentVirtualDescendantId = -1;
  
  private AccessibilityNodeInfoCompat(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    this.a = paramAccessibilityNodeInfo;
  }
  
  @Deprecated
  public AccessibilityNodeInfoCompat(Object paramObject) {
    this.a = (AccessibilityNodeInfo)paramObject;
  }
  
  private int a(ClickableSpan paramClickableSpan, SparseArray<WeakReference<ClickableSpan>> paramSparseArray) {
    if (paramSparseArray != null)
      for (int j = 0; j < paramSparseArray.size(); j++) {
        if (paramClickableSpan.equals(((WeakReference<ClickableSpan>)paramSparseArray.valueAt(j)).get()))
          return paramSparseArray.keyAt(j); 
      }  
    int i = c;
    c = i + 1;
    return i;
  }
  
  private SparseArray<WeakReference<ClickableSpan>> a(View paramView) {
    SparseArray<WeakReference<ClickableSpan>> sparseArray2 = b(paramView);
    SparseArray<WeakReference<ClickableSpan>> sparseArray1 = sparseArray2;
    if (sparseArray2 == null) {
      sparseArray1 = new SparseArray();
      paramView.setTag(R.id.tag_accessibility_clickable_spans, sparseArray1);
    } 
    return sparseArray1;
  }
  
  static AccessibilityNodeInfoCompat a(Object paramObject) {
    return (paramObject != null) ? new AccessibilityNodeInfoCompat(paramObject) : null;
  }
  
  private List<Integer> a(String paramString) {
    if (Build.VERSION.SDK_INT < 19)
      return new ArrayList<Integer>(); 
    ArrayList<Integer> arrayList2 = this.a.getExtras().getIntegerArrayList(paramString);
    ArrayList<Integer> arrayList1 = arrayList2;
    if (arrayList2 == null) {
      arrayList1 = new ArrayList();
      this.a.getExtras().putIntegerArrayList(paramString, arrayList1);
    } 
    return arrayList1;
  }
  
  private void a(int paramInt, boolean paramBoolean) {
    Bundle bundle = getExtras();
    if (bundle != null) {
      boolean bool;
      int i = bundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0);
      if (paramBoolean) {
        bool = paramInt;
      } else {
        bool = false;
      } 
      bundle.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", bool | i & paramInt);
    } 
  }
  
  private void a(ClickableSpan paramClickableSpan, Spanned paramSpanned, int paramInt) {
    a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(paramSpanned.getSpanStart(paramClickableSpan)));
    a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(paramSpanned.getSpanEnd(paramClickableSpan)));
    a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(paramSpanned.getSpanFlags(paramClickableSpan)));
    a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(paramInt));
  }
  
  private boolean a() {
    return a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty() ^ true;
  }
  
  private boolean a(int paramInt) {
    Bundle bundle = getExtras();
    boolean bool = false;
    if (bundle == null)
      return false; 
    if ((bundle.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & paramInt) == paramInt)
      bool = true; 
    return bool;
  }
  
  private SparseArray<WeakReference<ClickableSpan>> b(View paramView) {
    return (SparseArray<WeakReference<ClickableSpan>>)paramView.getTag(R.id.tag_accessibility_clickable_spans);
  }
  
  private static String b(int paramInt) {
    if (paramInt != 1) {
      if (paramInt != 2) {
        switch (paramInt) {
          default:
            switch (paramInt) {
              default:
                switch (paramInt) {
                  default:
                    return "ACTION_UNKNOWN";
                  case 16908361:
                    return "ACTION_PAGE_RIGHT";
                  case 16908360:
                    return "ACTION_PAGE_LEFT";
                  case 16908359:
                    return "ACTION_PAGE_DOWN";
                  case 16908358:
                    return "ACTION_PAGE_UP";
                  case 16908357:
                    return "ACTION_HIDE_TOOLTIP";
                  case 16908356:
                    break;
                } 
                return "ACTION_SHOW_TOOLTIP";
              case 16908349:
                return "ACTION_SET_PROGRESS";
              case 16908348:
                return "ACTION_CONTEXT_CLICK";
              case 16908347:
                return "ACTION_SCROLL_RIGHT";
              case 16908346:
                return "ACTION_SCROLL_DOWN";
              case 16908345:
                return "ACTION_SCROLL_LEFT";
              case 16908344:
                return "ACTION_SCROLL_UP";
              case 16908343:
                return "ACTION_SCROLL_TO_POSITION";
              case 16908342:
                break;
            } 
            return "ACTION_SHOW_ON_SCREEN";
          case 16908354:
            return "ACTION_MOVE_WINDOW";
          case 2097152:
            return "ACTION_SET_TEXT";
          case 524288:
            return "ACTION_COLLAPSE";
          case 262144:
            return "ACTION_EXPAND";
          case 131072:
            return "ACTION_SET_SELECTION";
          case 65536:
            return "ACTION_CUT";
          case 32768:
            return "ACTION_PASTE";
          case 16384:
            return "ACTION_COPY";
          case 8192:
            return "ACTION_SCROLL_BACKWARD";
          case 4096:
            return "ACTION_SCROLL_FORWARD";
          case 2048:
            return "ACTION_PREVIOUS_HTML_ELEMENT";
          case 1024:
            return "ACTION_NEXT_HTML_ELEMENT";
          case 512:
            return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
          case 256:
            return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
          case 128:
            return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
          case 64:
            return "ACTION_ACCESSIBILITY_FOCUS";
          case 32:
            return "ACTION_LONG_CLICK";
          case 16:
            return "ACTION_CLICK";
          case 8:
            return "ACTION_CLEAR_SELECTION";
          case 4:
            break;
        } 
        return "ACTION_SELECT";
      } 
      return "ACTION_CLEAR_FOCUS";
    } 
    return "ACTION_FOCUS";
  }
  
  private void b() {
    if (Build.VERSION.SDK_INT >= 19) {
      this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
      this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
      this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
      this.a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    } 
  }
  
  private void c(View paramView) {
    SparseArray<WeakReference<ClickableSpan>> sparseArray = b(paramView);
    if (sparseArray != null) {
      int j;
      ArrayList<Integer> arrayList = new ArrayList();
      byte b = 0;
      int i = 0;
      while (true) {
        j = b;
        if (i < sparseArray.size()) {
          if (((WeakReference)sparseArray.valueAt(i)).get() == null)
            arrayList.add(Integer.valueOf(i)); 
          i++;
          continue;
        } 
        break;
      } 
      while (j < arrayList.size()) {
        sparseArray.remove(((Integer)arrayList.get(j)).intValue());
        j++;
      } 
    } 
  }
  
  public static ClickableSpan[] getClickableSpans(CharSequence paramCharSequence) {
    return (paramCharSequence instanceof Spanned) ? (ClickableSpan[])((Spanned)paramCharSequence).getSpans(0, paramCharSequence.length(), ClickableSpan.class) : null;
  }
  
  public static AccessibilityNodeInfoCompat obtain() {
    return wrap(AccessibilityNodeInfo.obtain());
  }
  
  public static AccessibilityNodeInfoCompat obtain(View paramView) {
    return wrap(AccessibilityNodeInfo.obtain(paramView));
  }
  
  public static AccessibilityNodeInfoCompat obtain(View paramView, int paramInt) {
    return (Build.VERSION.SDK_INT >= 16) ? a(AccessibilityNodeInfo.obtain(paramView, paramInt)) : null;
  }
  
  public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {
    return wrap(AccessibilityNodeInfo.obtain(paramAccessibilityNodeInfoCompat.a));
  }
  
  public static AccessibilityNodeInfoCompat wrap(AccessibilityNodeInfo paramAccessibilityNodeInfo) {
    return new AccessibilityNodeInfoCompat(paramAccessibilityNodeInfo);
  }
  
  public void addAction(int paramInt) {
    this.a.addAction(paramInt);
  }
  
  public void addAction(AccessibilityActionCompat paramAccessibilityActionCompat) {
    if (Build.VERSION.SDK_INT >= 21)
      this.a.addAction((AccessibilityNodeInfo.AccessibilityAction)paramAccessibilityActionCompat.a); 
  }
  
  public void addChild(View paramView) {
    this.a.addChild(paramView);
  }
  
  public void addChild(View paramView, int paramInt) {
    if (Build.VERSION.SDK_INT >= 16)
      this.a.addChild(paramView, paramInt); 
  }
  
  public void addSpansToExtras(CharSequence paramCharSequence, View paramView) {
    if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 26) {
      b();
      c(paramView);
      ClickableSpan[] arrayOfClickableSpan = getClickableSpans(paramCharSequence);
      if (arrayOfClickableSpan != null && arrayOfClickableSpan.length > 0) {
        getExtras().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", R.id.accessibility_action_clickable_span);
        SparseArray<WeakReference<ClickableSpan>> sparseArray = a(paramView);
        for (int i = 0; arrayOfClickableSpan != null && i < arrayOfClickableSpan.length; i++) {
          int j = a(arrayOfClickableSpan[i], sparseArray);
          sparseArray.put(j, new WeakReference<ClickableSpan>(arrayOfClickableSpan[i]));
          a(arrayOfClickableSpan[i], (Spanned)paramCharSequence, j);
        } 
      } 
    } 
  }
  
  public boolean canOpenPopup() {
    return (Build.VERSION.SDK_INT >= 19) ? this.a.canOpenPopup() : false;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject == null)
      return false; 
    if (!(paramObject instanceof AccessibilityNodeInfoCompat))
      return false; 
    paramObject = paramObject;
    AccessibilityNodeInfo accessibilityNodeInfo = this.a;
    if (accessibilityNodeInfo == null) {
      if (((AccessibilityNodeInfoCompat)paramObject).a != null)
        return false; 
    } else if (!accessibilityNodeInfo.equals(((AccessibilityNodeInfoCompat)paramObject).a)) {
      return false;
    } 
    return (this.b != ((AccessibilityNodeInfoCompat)paramObject).b) ? false : (!(this.mParentVirtualDescendantId != ((AccessibilityNodeInfoCompat)paramObject).mParentVirtualDescendantId));
  }
  
  public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String paramString) {
    ArrayList<AccessibilityNodeInfoCompat> arrayList = new ArrayList();
    List<AccessibilityNodeInfo> list = this.a.findAccessibilityNodeInfosByText(paramString);
    int j = list.size();
    for (int i = 0; i < j; i++)
      arrayList.add(wrap(list.get(i))); 
    return arrayList;
  }
  
  public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String paramString) {
    if (Build.VERSION.SDK_INT >= 18) {
      List list = this.a.findAccessibilityNodeInfosByViewId(paramString);
      ArrayList<AccessibilityNodeInfoCompat> arrayList = new ArrayList();
      Iterator<AccessibilityNodeInfo> iterator = list.iterator();
      while (iterator.hasNext())
        arrayList.add(wrap(iterator.next())); 
      return arrayList;
    } 
    return Collections.emptyList();
  }
  
  public AccessibilityNodeInfoCompat findFocus(int paramInt) {
    return (Build.VERSION.SDK_INT >= 16) ? a(this.a.findFocus(paramInt)) : null;
  }
  
  public AccessibilityNodeInfoCompat focusSearch(int paramInt) {
    return (Build.VERSION.SDK_INT >= 16) ? a(this.a.focusSearch(paramInt)) : null;
  }
  
  public List<AccessibilityActionCompat> getActionList() {
    List list;
    if (Build.VERSION.SDK_INT >= 21) {
      list = this.a.getActionList();
    } else {
      list = null;
    } 
    if (list != null) {
      ArrayList<AccessibilityActionCompat> arrayList = new ArrayList();
      int j = list.size();
      for (int i = 0; i < j; i++)
        arrayList.add(new AccessibilityActionCompat(list.get(i))); 
      return arrayList;
    } 
    return Collections.emptyList();
  }
  
  public int getActions() {
    return this.a.getActions();
  }
  
  @Deprecated
  public void getBoundsInParent(Rect paramRect) {
    this.a.getBoundsInParent(paramRect);
  }
  
  public void getBoundsInScreen(Rect paramRect) {
    this.a.getBoundsInScreen(paramRect);
  }
  
  public AccessibilityNodeInfoCompat getChild(int paramInt) {
    return a(this.a.getChild(paramInt));
  }
  
  public int getChildCount() {
    return this.a.getChildCount();
  }
  
  public CharSequence getClassName() {
    return this.a.getClassName();
  }
  
  public CollectionInfoCompat getCollectionInfo() {
    if (Build.VERSION.SDK_INT >= 19) {
      AccessibilityNodeInfo.CollectionInfo collectionInfo = this.a.getCollectionInfo();
      if (collectionInfo != null)
        return new CollectionInfoCompat(collectionInfo); 
    } 
    return null;
  }
  
  public CollectionItemInfoCompat getCollectionItemInfo() {
    if (Build.VERSION.SDK_INT >= 19) {
      AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = this.a.getCollectionItemInfo();
      if (collectionItemInfo != null)
        return new CollectionItemInfoCompat(collectionItemInfo); 
    } 
    return null;
  }
  
  public CharSequence getContentDescription() {
    return this.a.getContentDescription();
  }
  
  public int getDrawingOrder() {
    return (Build.VERSION.SDK_INT >= 24) ? this.a.getDrawingOrder() : 0;
  }
  
  public CharSequence getError() {
    return (Build.VERSION.SDK_INT >= 21) ? this.a.getError() : null;
  }
  
  public Bundle getExtras() {
    return (Build.VERSION.SDK_INT >= 19) ? this.a.getExtras() : new Bundle();
  }
  
  public CharSequence getHintText() {
    return (Build.VERSION.SDK_INT >= 26) ? this.a.getHintText() : ((Build.VERSION.SDK_INT >= 19) ? this.a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY") : null);
  }
  
  @Deprecated
  public Object getInfo() {
    return this.a;
  }
  
  public int getInputType() {
    return (Build.VERSION.SDK_INT >= 19) ? this.a.getInputType() : 0;
  }
  
  public AccessibilityNodeInfoCompat getLabelFor() {
    return (Build.VERSION.SDK_INT >= 17) ? a(this.a.getLabelFor()) : null;
  }
  
  public AccessibilityNodeInfoCompat getLabeledBy() {
    return (Build.VERSION.SDK_INT >= 17) ? a(this.a.getLabeledBy()) : null;
  }
  
  public int getLiveRegion() {
    return (Build.VERSION.SDK_INT >= 19) ? this.a.getLiveRegion() : 0;
  }
  
  public int getMaxTextLength() {
    return (Build.VERSION.SDK_INT >= 21) ? this.a.getMaxTextLength() : -1;
  }
  
  public int getMovementGranularities() {
    return (Build.VERSION.SDK_INT >= 16) ? this.a.getMovementGranularities() : 0;
  }
  
  public CharSequence getPackageName() {
    return this.a.getPackageName();
  }
  
  public CharSequence getPaneTitle() {
    return (Build.VERSION.SDK_INT >= 28) ? this.a.getPaneTitle() : ((Build.VERSION.SDK_INT >= 19) ? this.a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY") : null);
  }
  
  public AccessibilityNodeInfoCompat getParent() {
    return a(this.a.getParent());
  }
  
  public RangeInfoCompat getRangeInfo() {
    if (Build.VERSION.SDK_INT >= 19) {
      AccessibilityNodeInfo.RangeInfo rangeInfo = this.a.getRangeInfo();
      if (rangeInfo != null)
        return new RangeInfoCompat(rangeInfo); 
    } 
    return null;
  }
  
  public CharSequence getRoleDescription() {
    return (Build.VERSION.SDK_INT >= 19) ? this.a.getExtras().getCharSequence("AccessibilityNodeInfo.roleDescription") : null;
  }
  
  public CharSequence getText() {
    if (a()) {
      List<Integer> list1 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
      List<Integer> list2 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
      List<Integer> list3 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
      List<Integer> list4 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
      CharSequence charSequence = this.a.getText();
      int j = this.a.getText().length();
      int i = 0;
      SpannableString spannableString = new SpannableString(TextUtils.substring(charSequence, 0, j));
      while (i < list1.size()) {
        spannableString.setSpan(new AccessibilityClickableSpanCompat(((Integer)list4.get(i)).intValue(), this, getExtras().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer)list1.get(i)).intValue(), ((Integer)list2.get(i)).intValue(), ((Integer)list3.get(i)).intValue());
        i++;
      } 
      return (CharSequence)spannableString;
    } 
    return this.a.getText();
  }
  
  public int getTextSelectionEnd() {
    return (Build.VERSION.SDK_INT >= 18) ? this.a.getTextSelectionEnd() : -1;
  }
  
  public int getTextSelectionStart() {
    return (Build.VERSION.SDK_INT >= 18) ? this.a.getTextSelectionStart() : -1;
  }
  
  public CharSequence getTooltipText() {
    return (Build.VERSION.SDK_INT >= 28) ? this.a.getTooltipText() : ((Build.VERSION.SDK_INT >= 19) ? this.a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY") : null);
  }
  
  public TouchDelegateInfoCompat getTouchDelegateInfo() {
    if (Build.VERSION.SDK_INT >= 29) {
      AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo = this.a.getTouchDelegateInfo();
      if (touchDelegateInfo != null)
        return new TouchDelegateInfoCompat(touchDelegateInfo); 
    } 
    return null;
  }
  
  public AccessibilityNodeInfoCompat getTraversalAfter() {
    return (Build.VERSION.SDK_INT >= 22) ? a(this.a.getTraversalAfter()) : null;
  }
  
  public AccessibilityNodeInfoCompat getTraversalBefore() {
    return (Build.VERSION.SDK_INT >= 22) ? a(this.a.getTraversalBefore()) : null;
  }
  
  public String getViewIdResourceName() {
    return (Build.VERSION.SDK_INT >= 18) ? this.a.getViewIdResourceName() : null;
  }
  
  public AccessibilityWindowInfoCompat getWindow() {
    return (Build.VERSION.SDK_INT >= 21) ? AccessibilityWindowInfoCompat.a(this.a.getWindow()) : null;
  }
  
  public int getWindowId() {
    return this.a.getWindowId();
  }
  
  public int hashCode() {
    AccessibilityNodeInfo accessibilityNodeInfo = this.a;
    return (accessibilityNodeInfo == null) ? 0 : accessibilityNodeInfo.hashCode();
  }
  
  public boolean isAccessibilityFocused() {
    return (Build.VERSION.SDK_INT >= 16) ? this.a.isAccessibilityFocused() : false;
  }
  
  public boolean isCheckable() {
    return this.a.isCheckable();
  }
  
  public boolean isChecked() {
    return this.a.isChecked();
  }
  
  public boolean isClickable() {
    return this.a.isClickable();
  }
  
  public boolean isContentInvalid() {
    return (Build.VERSION.SDK_INT >= 19) ? this.a.isContentInvalid() : false;
  }
  
  public boolean isContextClickable() {
    return (Build.VERSION.SDK_INT >= 23) ? this.a.isContextClickable() : false;
  }
  
  public boolean isDismissable() {
    return (Build.VERSION.SDK_INT >= 19) ? this.a.isDismissable() : false;
  }
  
  public boolean isEditable() {
    return (Build.VERSION.SDK_INT >= 18) ? this.a.isEditable() : false;
  }
  
  public boolean isEnabled() {
    return this.a.isEnabled();
  }
  
  public boolean isFocusable() {
    return this.a.isFocusable();
  }
  
  public boolean isFocused() {
    return this.a.isFocused();
  }
  
  public boolean isHeading() {
    if (Build.VERSION.SDK_INT >= 28)
      return this.a.isHeading(); 
    if (a(2))
      return true; 
    CollectionItemInfoCompat collectionItemInfoCompat = getCollectionItemInfo();
    return (collectionItemInfoCompat != null && collectionItemInfoCompat.isHeading());
  }
  
  public boolean isImportantForAccessibility() {
    return (Build.VERSION.SDK_INT >= 24) ? this.a.isImportantForAccessibility() : true;
  }
  
  public boolean isLongClickable() {
    return this.a.isLongClickable();
  }
  
  public boolean isMultiLine() {
    return (Build.VERSION.SDK_INT >= 19) ? this.a.isMultiLine() : false;
  }
  
  public boolean isPassword() {
    return this.a.isPassword();
  }
  
  public boolean isScreenReaderFocusable() {
    return (Build.VERSION.SDK_INT >= 28) ? this.a.isScreenReaderFocusable() : a(1);
  }
  
  public boolean isScrollable() {
    return this.a.isScrollable();
  }
  
  public boolean isSelected() {
    return this.a.isSelected();
  }
  
  public boolean isShowingHintText() {
    return (Build.VERSION.SDK_INT >= 26) ? this.a.isShowingHintText() : a(4);
  }
  
  public boolean isTextEntryKey() {
    return (Build.VERSION.SDK_INT >= 29) ? this.a.isTextEntryKey() : a(8);
  }
  
  public boolean isVisibleToUser() {
    return (Build.VERSION.SDK_INT >= 16) ? this.a.isVisibleToUser() : false;
  }
  
  public boolean performAction(int paramInt) {
    return this.a.performAction(paramInt);
  }
  
  public boolean performAction(int paramInt, Bundle paramBundle) {
    return (Build.VERSION.SDK_INT >= 16) ? this.a.performAction(paramInt, paramBundle) : false;
  }
  
  public void recycle() {
    this.a.recycle();
  }
  
  public boolean refresh() {
    return (Build.VERSION.SDK_INT >= 18) ? this.a.refresh() : false;
  }
  
  public boolean removeAction(AccessibilityActionCompat paramAccessibilityActionCompat) {
    return (Build.VERSION.SDK_INT >= 21) ? this.a.removeAction((AccessibilityNodeInfo.AccessibilityAction)paramAccessibilityActionCompat.a) : false;
  }
  
  public boolean removeChild(View paramView) {
    return (Build.VERSION.SDK_INT >= 21) ? this.a.removeChild(paramView) : false;
  }
  
  public boolean removeChild(View paramView, int paramInt) {
    return (Build.VERSION.SDK_INT >= 21) ? this.a.removeChild(paramView, paramInt) : false;
  }
  
  public void setAccessibilityFocused(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 16)
      this.a.setAccessibilityFocused(paramBoolean); 
  }
  
  @Deprecated
  public void setBoundsInParent(Rect paramRect) {
    this.a.setBoundsInParent(paramRect);
  }
  
  public void setBoundsInScreen(Rect paramRect) {
    this.a.setBoundsInScreen(paramRect);
  }
  
  public void setCanOpenPopup(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 19)
      this.a.setCanOpenPopup(paramBoolean); 
  }
  
  public void setCheckable(boolean paramBoolean) {
    this.a.setCheckable(paramBoolean);
  }
  
  public void setChecked(boolean paramBoolean) {
    this.a.setChecked(paramBoolean);
  }
  
  public void setClassName(CharSequence paramCharSequence) {
    this.a.setClassName(paramCharSequence);
  }
  
  public void setClickable(boolean paramBoolean) {
    this.a.setClickable(paramBoolean);
  }
  
  public void setCollectionInfo(Object paramObject) {
    if (Build.VERSION.SDK_INT >= 19) {
      AccessibilityNodeInfo accessibilityNodeInfo = this.a;
      if (paramObject == null) {
        paramObject = null;
      } else {
        paramObject = ((CollectionInfoCompat)paramObject).a;
      } 
      accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo)paramObject);
    } 
  }
  
  public void setCollectionItemInfo(Object paramObject) {
    if (Build.VERSION.SDK_INT >= 19) {
      AccessibilityNodeInfo accessibilityNodeInfo = this.a;
      if (paramObject == null) {
        paramObject = null;
      } else {
        paramObject = ((CollectionItemInfoCompat)paramObject).a;
      } 
      accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo)paramObject);
    } 
  }
  
  public void setContentDescription(CharSequence paramCharSequence) {
    this.a.setContentDescription(paramCharSequence);
  }
  
  public void setContentInvalid(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 19)
      this.a.setContentInvalid(paramBoolean); 
  }
  
  public void setContextClickable(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 23)
      this.a.setContextClickable(paramBoolean); 
  }
  
  public void setDismissable(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 19)
      this.a.setDismissable(paramBoolean); 
  }
  
  public void setDrawingOrder(int paramInt) {
    if (Build.VERSION.SDK_INT >= 24)
      this.a.setDrawingOrder(paramInt); 
  }
  
  public void setEditable(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 18)
      this.a.setEditable(paramBoolean); 
  }
  
  public void setEnabled(boolean paramBoolean) {
    this.a.setEnabled(paramBoolean);
  }
  
  public void setError(CharSequence paramCharSequence) {
    if (Build.VERSION.SDK_INT >= 21)
      this.a.setError(paramCharSequence); 
  }
  
  public void setFocusable(boolean paramBoolean) {
    this.a.setFocusable(paramBoolean);
  }
  
  public void setFocused(boolean paramBoolean) {
    this.a.setFocused(paramBoolean);
  }
  
  public void setHeading(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 28) {
      this.a.setHeading(paramBoolean);
      return;
    } 
    a(2, paramBoolean);
  }
  
  public void setHintText(CharSequence paramCharSequence) {
    if (Build.VERSION.SDK_INT >= 26) {
      this.a.setHintText(paramCharSequence);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 19)
      this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", paramCharSequence); 
  }
  
  public void setImportantForAccessibility(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 24)
      this.a.setImportantForAccessibility(paramBoolean); 
  }
  
  public void setInputType(int paramInt) {
    if (Build.VERSION.SDK_INT >= 19)
      this.a.setInputType(paramInt); 
  }
  
  public void setLabelFor(View paramView) {
    if (Build.VERSION.SDK_INT >= 17)
      this.a.setLabelFor(paramView); 
  }
  
  public void setLabelFor(View paramView, int paramInt) {
    if (Build.VERSION.SDK_INT >= 17)
      this.a.setLabelFor(paramView, paramInt); 
  }
  
  public void setLabeledBy(View paramView) {
    if (Build.VERSION.SDK_INT >= 17)
      this.a.setLabeledBy(paramView); 
  }
  
  public void setLabeledBy(View paramView, int paramInt) {
    if (Build.VERSION.SDK_INT >= 17)
      this.a.setLabeledBy(paramView, paramInt); 
  }
  
  public void setLiveRegion(int paramInt) {
    if (Build.VERSION.SDK_INT >= 19)
      this.a.setLiveRegion(paramInt); 
  }
  
  public void setLongClickable(boolean paramBoolean) {
    this.a.setLongClickable(paramBoolean);
  }
  
  public void setMaxTextLength(int paramInt) {
    if (Build.VERSION.SDK_INT >= 21)
      this.a.setMaxTextLength(paramInt); 
  }
  
  public void setMovementGranularities(int paramInt) {
    if (Build.VERSION.SDK_INT >= 16)
      this.a.setMovementGranularities(paramInt); 
  }
  
  public void setMultiLine(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 19)
      this.a.setMultiLine(paramBoolean); 
  }
  
  public void setPackageName(CharSequence paramCharSequence) {
    this.a.setPackageName(paramCharSequence);
  }
  
  public void setPaneTitle(CharSequence paramCharSequence) {
    if (Build.VERSION.SDK_INT >= 28) {
      this.a.setPaneTitle(paramCharSequence);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 19)
      this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", paramCharSequence); 
  }
  
  public void setParent(View paramView) {
    this.mParentVirtualDescendantId = -1;
    this.a.setParent(paramView);
  }
  
  public void setParent(View paramView, int paramInt) {
    this.mParentVirtualDescendantId = paramInt;
    if (Build.VERSION.SDK_INT >= 16)
      this.a.setParent(paramView, paramInt); 
  }
  
  public void setPassword(boolean paramBoolean) {
    this.a.setPassword(paramBoolean);
  }
  
  public void setRangeInfo(RangeInfoCompat paramRangeInfoCompat) {
    if (Build.VERSION.SDK_INT >= 19)
      this.a.setRangeInfo((AccessibilityNodeInfo.RangeInfo)paramRangeInfoCompat.a); 
  }
  
  public void setRoleDescription(CharSequence paramCharSequence) {
    if (Build.VERSION.SDK_INT >= 19)
      this.a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", paramCharSequence); 
  }
  
  public void setScreenReaderFocusable(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 28) {
      this.a.setScreenReaderFocusable(paramBoolean);
      return;
    } 
    a(1, paramBoolean);
  }
  
  public void setScrollable(boolean paramBoolean) {
    this.a.setScrollable(paramBoolean);
  }
  
  public void setSelected(boolean paramBoolean) {
    this.a.setSelected(paramBoolean);
  }
  
  public void setShowingHintText(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 26) {
      this.a.setShowingHintText(paramBoolean);
      return;
    } 
    a(4, paramBoolean);
  }
  
  public void setSource(View paramView) {
    this.b = -1;
    this.a.setSource(paramView);
  }
  
  public void setSource(View paramView, int paramInt) {
    this.b = paramInt;
    if (Build.VERSION.SDK_INT >= 16)
      this.a.setSource(paramView, paramInt); 
  }
  
  public void setText(CharSequence paramCharSequence) {
    this.a.setText(paramCharSequence);
  }
  
  public void setTextEntryKey(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 29) {
      this.a.setTextEntryKey(paramBoolean);
      return;
    } 
    a(8, paramBoolean);
  }
  
  public void setTextSelection(int paramInt1, int paramInt2) {
    if (Build.VERSION.SDK_INT >= 18)
      this.a.setTextSelection(paramInt1, paramInt2); 
  }
  
  public void setTooltipText(CharSequence paramCharSequence) {
    if (Build.VERSION.SDK_INT >= 28) {
      this.a.setTooltipText(paramCharSequence);
      return;
    } 
    if (Build.VERSION.SDK_INT >= 19)
      this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY", paramCharSequence); 
  }
  
  public void setTouchDelegateInfo(TouchDelegateInfoCompat paramTouchDelegateInfoCompat) {
    if (Build.VERSION.SDK_INT >= 29)
      this.a.setTouchDelegateInfo(paramTouchDelegateInfoCompat.a); 
  }
  
  public void setTraversalAfter(View paramView) {
    if (Build.VERSION.SDK_INT >= 22)
      this.a.setTraversalAfter(paramView); 
  }
  
  public void setTraversalAfter(View paramView, int paramInt) {
    if (Build.VERSION.SDK_INT >= 22)
      this.a.setTraversalAfter(paramView, paramInt); 
  }
  
  public void setTraversalBefore(View paramView) {
    if (Build.VERSION.SDK_INT >= 22)
      this.a.setTraversalBefore(paramView); 
  }
  
  public void setTraversalBefore(View paramView, int paramInt) {
    if (Build.VERSION.SDK_INT >= 22)
      this.a.setTraversalBefore(paramView, paramInt); 
  }
  
  public void setViewIdResourceName(String paramString) {
    if (Build.VERSION.SDK_INT >= 18)
      this.a.setViewIdResourceName(paramString); 
  }
  
  public void setVisibleToUser(boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 16)
      this.a.setVisibleToUser(paramBoolean); 
  }
  
  public String toString() {
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append(super.toString());
    Rect rect = new Rect();
    getBoundsInParent(rect);
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("; boundsInParent: ");
    stringBuilder2.append(rect);
    stringBuilder3.append(stringBuilder2.toString());
    getBoundsInScreen(rect);
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("; boundsInScreen: ");
    stringBuilder2.append(rect);
    stringBuilder3.append(stringBuilder2.toString());
    stringBuilder3.append("; packageName: ");
    stringBuilder3.append(getPackageName());
    stringBuilder3.append("; className: ");
    stringBuilder3.append(getClassName());
    stringBuilder3.append("; text: ");
    stringBuilder3.append(getText());
    stringBuilder3.append("; contentDescription: ");
    stringBuilder3.append(getContentDescription());
    stringBuilder3.append("; viewId: ");
    stringBuilder3.append(getViewIdResourceName());
    stringBuilder3.append("; checkable: ");
    stringBuilder3.append(isCheckable());
    stringBuilder3.append("; checked: ");
    stringBuilder3.append(isChecked());
    stringBuilder3.append("; focusable: ");
    stringBuilder3.append(isFocusable());
    stringBuilder3.append("; focused: ");
    stringBuilder3.append(isFocused());
    stringBuilder3.append("; selected: ");
    stringBuilder3.append(isSelected());
    stringBuilder3.append("; clickable: ");
    stringBuilder3.append(isClickable());
    stringBuilder3.append("; longClickable: ");
    stringBuilder3.append(isLongClickable());
    stringBuilder3.append("; enabled: ");
    stringBuilder3.append(isEnabled());
    stringBuilder3.append("; password: ");
    stringBuilder3.append(isPassword());
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("; scrollable: ");
    stringBuilder1.append(isScrollable());
    stringBuilder3.append(stringBuilder1.toString());
    stringBuilder3.append("; [");
    if (Build.VERSION.SDK_INT >= 21) {
      List<AccessibilityActionCompat> list = getActionList();
      for (int i = 0; i < list.size(); i++) {
        AccessibilityActionCompat accessibilityActionCompat = list.get(i);
        String str2 = b(accessibilityActionCompat.getId());
        String str1 = str2;
        if (str2.equals("ACTION_UNKNOWN")) {
          str1 = str2;
          if (accessibilityActionCompat.getLabel() != null)
            str1 = accessibilityActionCompat.getLabel().toString(); 
        } 
        stringBuilder3.append(str1);
        if (i != list.size() - 1)
          stringBuilder3.append(", "); 
      } 
    } else {
      int i = getActions();
      while (i != 0) {
        int k = 1 << Integer.numberOfTrailingZeros(i);
        int j = i & k;
        stringBuilder3.append(b(k));
        i = j;
        if (j != 0) {
          stringBuilder3.append(", ");
          i = j;
        } 
      } 
    } 
    stringBuilder3.append("]");
    return stringBuilder3.toString();
  }
  
  public AccessibilityNodeInfo unwrap() {
    return this.a;
  }
  
  public static class AccessibilityActionCompat {
    public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS;
    
    public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS;
    
    public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
    
    public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION;
    
    public static final AccessibilityActionCompat ACTION_CLICK;
    
    public static final AccessibilityActionCompat ACTION_COLLAPSE;
    
    public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK;
    
    public static final AccessibilityActionCompat ACTION_COPY;
    
    public static final AccessibilityActionCompat ACTION_CUT;
    
    public static final AccessibilityActionCompat ACTION_DISMISS;
    
    public static final AccessibilityActionCompat ACTION_EXPAND;
    
    public static final AccessibilityActionCompat ACTION_FOCUS = new AccessibilityActionCompat(1, null);
    
    public static final AccessibilityActionCompat ACTION_HIDE_TOOLTIP;
    
    public static final AccessibilityActionCompat ACTION_LONG_CLICK;
    
    public static final AccessibilityActionCompat ACTION_MOVE_WINDOW;
    
    public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
    
    public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT;
    
    public static final AccessibilityActionCompat ACTION_PAGE_DOWN;
    
    public static final AccessibilityActionCompat ACTION_PAGE_LEFT;
    
    public static final AccessibilityActionCompat ACTION_PAGE_RIGHT;
    
    public static final AccessibilityActionCompat ACTION_PAGE_UP;
    
    public static final AccessibilityActionCompat ACTION_PASTE;
    
    public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
    
    public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT;
    
    public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD;
    
    public static final AccessibilityActionCompat ACTION_SCROLL_DOWN;
    
    public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD;
    
    public static final AccessibilityActionCompat ACTION_SCROLL_LEFT;
    
    public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT;
    
    public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION;
    
    public static final AccessibilityActionCompat ACTION_SCROLL_UP;
    
    public static final AccessibilityActionCompat ACTION_SELECT = new AccessibilityActionCompat(4, null);
    
    public static final AccessibilityActionCompat ACTION_SET_PROGRESS;
    
    public static final AccessibilityActionCompat ACTION_SET_SELECTION;
    
    public static final AccessibilityActionCompat ACTION_SET_TEXT;
    
    public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN;
    
    public static final AccessibilityActionCompat ACTION_SHOW_TOOLTIP;
    
    final Object a;
    
    protected final AccessibilityViewCommand b;
    
    private final int c;
    
    private final Class<? extends AccessibilityViewCommand.CommandArguments> d;
    
    static {
      ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, null);
      ACTION_CLICK = new AccessibilityActionCompat(16, null);
      ACTION_LONG_CLICK = new AccessibilityActionCompat(32, null);
      ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, null);
      ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, null);
      ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, null, (Class)AccessibilityViewCommand.MoveAtGranularityArguments.class);
      ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, null, (Class)AccessibilityViewCommand.MoveAtGranularityArguments.class);
      ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, null, (Class)AccessibilityViewCommand.MoveHtmlArguments.class);
      ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, null, (Class)AccessibilityViewCommand.MoveHtmlArguments.class);
      ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, null);
      ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, null);
      ACTION_COPY = new AccessibilityActionCompat(16384, null);
      ACTION_PASTE = new AccessibilityActionCompat(32768, null);
      ACTION_CUT = new AccessibilityActionCompat(65536, null);
      ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, null, (Class)AccessibilityViewCommand.SetSelectionArguments.class);
      ACTION_EXPAND = new AccessibilityActionCompat(262144, null);
      ACTION_COLLAPSE = new AccessibilityActionCompat(524288, null);
      ACTION_DISMISS = new AccessibilityActionCompat(1048576, null);
      ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, null, (Class)AccessibilityViewCommand.SetTextArguments.class);
      if (Build.VERSION.SDK_INT >= 23) {
        accessibilityAction1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
      } else {
        accessibilityAction1 = null;
      } 
      ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(accessibilityAction1, 16908342, null, null, null);
      if (Build.VERSION.SDK_INT >= 23) {
        accessibilityAction1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
      } else {
        accessibilityAction1 = null;
      } 
      ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(accessibilityAction1, 16908343, null, null, (Class)AccessibilityViewCommand.ScrollToPositionArguments.class);
      if (Build.VERSION.SDK_INT >= 23) {
        accessibilityAction1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
      } else {
        accessibilityAction1 = null;
      } 
      ACTION_SCROLL_UP = new AccessibilityActionCompat(accessibilityAction1, 16908344, null, null, null);
      if (Build.VERSION.SDK_INT >= 23) {
        accessibilityAction1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
      } else {
        accessibilityAction1 = null;
      } 
      ACTION_SCROLL_LEFT = new AccessibilityActionCompat(accessibilityAction1, 16908345, null, null, null);
      if (Build.VERSION.SDK_INT >= 23) {
        accessibilityAction1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
      } else {
        accessibilityAction1 = null;
      } 
      ACTION_SCROLL_DOWN = new AccessibilityActionCompat(accessibilityAction1, 16908346, null, null, null);
      if (Build.VERSION.SDK_INT >= 23) {
        accessibilityAction1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
      } else {
        accessibilityAction1 = null;
      } 
      ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(accessibilityAction1, 16908347, null, null, null);
      if (Build.VERSION.SDK_INT >= 29) {
        accessibilityAction1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
      } else {
        accessibilityAction1 = null;
      } 
      ACTION_PAGE_UP = new AccessibilityActionCompat(accessibilityAction1, 16908358, null, null, null);
      if (Build.VERSION.SDK_INT >= 29) {
        accessibilityAction1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
      } else {
        accessibilityAction1 = null;
      } 
      ACTION_PAGE_DOWN = new AccessibilityActionCompat(accessibilityAction1, 16908359, null, null, null);
      if (Build.VERSION.SDK_INT >= 29) {
        accessibilityAction1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
      } else {
        accessibilityAction1 = null;
      } 
      ACTION_PAGE_LEFT = new AccessibilityActionCompat(accessibilityAction1, 16908360, null, null, null);
      if (Build.VERSION.SDK_INT >= 29) {
        accessibilityAction1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
      } else {
        accessibilityAction1 = null;
      } 
      ACTION_PAGE_RIGHT = new AccessibilityActionCompat(accessibilityAction1, 16908361, null, null, null);
      if (Build.VERSION.SDK_INT >= 23) {
        accessibilityAction1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
      } else {
        accessibilityAction1 = null;
      } 
      ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(accessibilityAction1, 16908348, null, null, null);
      if (Build.VERSION.SDK_INT >= 24) {
        accessibilityAction1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
      } else {
        accessibilityAction1 = null;
      } 
      ACTION_SET_PROGRESS = new AccessibilityActionCompat(accessibilityAction1, 16908349, null, null, (Class)AccessibilityViewCommand.SetProgressArguments.class);
      if (Build.VERSION.SDK_INT >= 26) {
        accessibilityAction1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
      } else {
        accessibilityAction1 = null;
      } 
      ACTION_MOVE_WINDOW = new AccessibilityActionCompat(accessibilityAction1, 16908354, null, null, (Class)AccessibilityViewCommand.MoveWindowArguments.class);
      if (Build.VERSION.SDK_INT >= 28) {
        accessibilityAction1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
      } else {
        accessibilityAction1 = null;
      } 
      ACTION_SHOW_TOOLTIP = new AccessibilityActionCompat(accessibilityAction1, 16908356, null, null, null);
      AccessibilityNodeInfo.AccessibilityAction accessibilityAction1 = accessibilityAction2;
      if (Build.VERSION.SDK_INT >= 28)
        accessibilityAction1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP; 
      ACTION_HIDE_TOOLTIP = new AccessibilityActionCompat(accessibilityAction1, 16908357, null, null, null);
    }
    
    public AccessibilityActionCompat(int param1Int, CharSequence param1CharSequence) {
      this(null, param1Int, param1CharSequence, null, null);
    }
    
    public AccessibilityActionCompat(int param1Int, CharSequence param1CharSequence, AccessibilityViewCommand param1AccessibilityViewCommand) {
      this(null, param1Int, param1CharSequence, param1AccessibilityViewCommand, null);
    }
    
    private AccessibilityActionCompat(int param1Int, CharSequence param1CharSequence, Class<? extends AccessibilityViewCommand.CommandArguments> param1Class) {
      this(null, param1Int, param1CharSequence, null, param1Class);
    }
    
    AccessibilityActionCompat(Object param1Object) {
      this(param1Object, 0, null, null, null);
    }
    
    AccessibilityActionCompat(Object param1Object, int param1Int, CharSequence param1CharSequence, AccessibilityViewCommand param1AccessibilityViewCommand, Class<? extends AccessibilityViewCommand.CommandArguments> param1Class) {
      this.c = param1Int;
      this.b = param1AccessibilityViewCommand;
      if (Build.VERSION.SDK_INT >= 21 && param1Object == null) {
        this.a = new AccessibilityNodeInfo.AccessibilityAction(param1Int, param1CharSequence);
      } else {
        this.a = param1Object;
      } 
      this.d = param1Class;
    }
    
    public AccessibilityActionCompat createReplacementAction(CharSequence param1CharSequence, AccessibilityViewCommand param1AccessibilityViewCommand) {
      return new AccessibilityActionCompat(null, this.c, param1CharSequence, param1AccessibilityViewCommand, this.d);
    }
    
    public boolean equals(Object param1Object) {
      if (param1Object == null)
        return false; 
      if (!(param1Object instanceof AccessibilityActionCompat))
        return false; 
      param1Object = param1Object;
      Object object = this.a;
      if (object == null) {
        if (((AccessibilityActionCompat)param1Object).a != null)
          return false; 
      } else if (!object.equals(((AccessibilityActionCompat)param1Object).a)) {
        return false;
      } 
      return true;
    }
    
    public int getId() {
      return (Build.VERSION.SDK_INT >= 21) ? ((AccessibilityNodeInfo.AccessibilityAction)this.a).getId() : 0;
    }
    
    public CharSequence getLabel() {
      return (Build.VERSION.SDK_INT >= 21) ? ((AccessibilityNodeInfo.AccessibilityAction)this.a).getLabel() : null;
    }
    
    public int hashCode() {
      Object object = this.a;
      return (object != null) ? object.hashCode() : 0;
    }
    
    public boolean perform(View param1View, Bundle param1Bundle) {
      if (this.b != null) {
        AccessibilityViewCommand.CommandArguments commandArguments = null;
        Object object = null;
        Class<? extends AccessibilityViewCommand.CommandArguments> clazz = this.d;
        if (clazz != null) {
          Exception exception1;
          String str;
          try {
            commandArguments = clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            try {
              commandArguments.setBundle(param1Bundle);
            } catch (Exception exception2) {
              AccessibilityViewCommand.CommandArguments commandArguments1 = commandArguments;
              exception = exception2;
            } 
          } catch (Exception exception) {
            exception1 = exception2;
          } 
          Class<? extends AccessibilityViewCommand.CommandArguments> clazz1 = this.d;
          if (clazz1 == null) {
            str = "null";
          } else {
            str = str.getName();
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Failed to execute command with argument class ViewCommandArgument: ");
          stringBuilder.append(str);
          Log.e("A11yActionCompat", stringBuilder.toString(), exception);
          exception = exception1;
        } 
        return this.b.perform(param1View, (AccessibilityViewCommand.CommandArguments)exception);
      } 
      return false;
    }
    
    static {
      AccessibilityNodeInfo.AccessibilityAction accessibilityAction2 = null;
    }
  }
  
  public static class CollectionInfoCompat {
    public static final int SELECTION_MODE_MULTIPLE = 2;
    
    public static final int SELECTION_MODE_NONE = 0;
    
    public static final int SELECTION_MODE_SINGLE = 1;
    
    final Object a;
    
    CollectionInfoCompat(Object param1Object) {
      this.a = param1Object;
    }
    
    public static CollectionInfoCompat obtain(int param1Int1, int param1Int2, boolean param1Boolean) {
      return (Build.VERSION.SDK_INT >= 19) ? new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(param1Int1, param1Int2, param1Boolean)) : new CollectionInfoCompat(null);
    }
    
    public static CollectionInfoCompat obtain(int param1Int1, int param1Int2, boolean param1Boolean, int param1Int3) {
      return (Build.VERSION.SDK_INT >= 21) ? new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(param1Int1, param1Int2, param1Boolean, param1Int3)) : ((Build.VERSION.SDK_INT >= 19) ? new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(param1Int1, param1Int2, param1Boolean)) : new CollectionInfoCompat(null));
    }
    
    public int getColumnCount() {
      return (Build.VERSION.SDK_INT >= 19) ? ((AccessibilityNodeInfo.CollectionInfo)this.a).getColumnCount() : 0;
    }
    
    public int getRowCount() {
      return (Build.VERSION.SDK_INT >= 19) ? ((AccessibilityNodeInfo.CollectionInfo)this.a).getRowCount() : 0;
    }
    
    public int getSelectionMode() {
      return (Build.VERSION.SDK_INT >= 21) ? ((AccessibilityNodeInfo.CollectionInfo)this.a).getSelectionMode() : 0;
    }
    
    public boolean isHierarchical() {
      return (Build.VERSION.SDK_INT >= 19) ? ((AccessibilityNodeInfo.CollectionInfo)this.a).isHierarchical() : false;
    }
  }
  
  public static class CollectionItemInfoCompat {
    final Object a;
    
    CollectionItemInfoCompat(Object param1Object) {
      this.a = param1Object;
    }
    
    public static CollectionItemInfoCompat obtain(int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean) {
      return (Build.VERSION.SDK_INT >= 19) ? new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(param1Int1, param1Int2, param1Int3, param1Int4, param1Boolean)) : new CollectionItemInfoCompat(null);
    }
    
    public static CollectionItemInfoCompat obtain(int param1Int1, int param1Int2, int param1Int3, int param1Int4, boolean param1Boolean1, boolean param1Boolean2) {
      return (Build.VERSION.SDK_INT >= 21) ? new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(param1Int1, param1Int2, param1Int3, param1Int4, param1Boolean1, param1Boolean2)) : ((Build.VERSION.SDK_INT >= 19) ? new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(param1Int1, param1Int2, param1Int3, param1Int4, param1Boolean1)) : new CollectionItemInfoCompat(null));
    }
    
    public int getColumnIndex() {
      return (Build.VERSION.SDK_INT >= 19) ? ((AccessibilityNodeInfo.CollectionItemInfo)this.a).getColumnIndex() : 0;
    }
    
    public int getColumnSpan() {
      return (Build.VERSION.SDK_INT >= 19) ? ((AccessibilityNodeInfo.CollectionItemInfo)this.a).getColumnSpan() : 0;
    }
    
    public int getRowIndex() {
      return (Build.VERSION.SDK_INT >= 19) ? ((AccessibilityNodeInfo.CollectionItemInfo)this.a).getRowIndex() : 0;
    }
    
    public int getRowSpan() {
      return (Build.VERSION.SDK_INT >= 19) ? ((AccessibilityNodeInfo.CollectionItemInfo)this.a).getRowSpan() : 0;
    }
    
    @Deprecated
    public boolean isHeading() {
      return (Build.VERSION.SDK_INT >= 19) ? ((AccessibilityNodeInfo.CollectionItemInfo)this.a).isHeading() : false;
    }
    
    public boolean isSelected() {
      return (Build.VERSION.SDK_INT >= 21) ? ((AccessibilityNodeInfo.CollectionItemInfo)this.a).isSelected() : false;
    }
  }
  
  public static class RangeInfoCompat {
    public static final int RANGE_TYPE_FLOAT = 1;
    
    public static final int RANGE_TYPE_INT = 0;
    
    public static final int RANGE_TYPE_PERCENT = 2;
    
    final Object a;
    
    RangeInfoCompat(Object param1Object) {
      this.a = param1Object;
    }
    
    public static RangeInfoCompat obtain(int param1Int, float param1Float1, float param1Float2, float param1Float3) {
      return (Build.VERSION.SDK_INT >= 19) ? new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(param1Int, param1Float1, param1Float2, param1Float3)) : new RangeInfoCompat(null);
    }
    
    public float getCurrent() {
      return (Build.VERSION.SDK_INT >= 19) ? ((AccessibilityNodeInfo.RangeInfo)this.a).getCurrent() : 0.0F;
    }
    
    public float getMax() {
      return (Build.VERSION.SDK_INT >= 19) ? ((AccessibilityNodeInfo.RangeInfo)this.a).getMax() : 0.0F;
    }
    
    public float getMin() {
      return (Build.VERSION.SDK_INT >= 19) ? ((AccessibilityNodeInfo.RangeInfo)this.a).getMin() : 0.0F;
    }
    
    public int getType() {
      return (Build.VERSION.SDK_INT >= 19) ? ((AccessibilityNodeInfo.RangeInfo)this.a).getType() : 0;
    }
  }
  
  public static final class TouchDelegateInfoCompat {
    final AccessibilityNodeInfo.TouchDelegateInfo a;
    
    TouchDelegateInfoCompat(AccessibilityNodeInfo.TouchDelegateInfo param1TouchDelegateInfo) {
      this.a = param1TouchDelegateInfo;
    }
    
    public TouchDelegateInfoCompat(Map<Region, View> param1Map) {
      if (Build.VERSION.SDK_INT >= 29) {
        this.a = new AccessibilityNodeInfo.TouchDelegateInfo(param1Map);
        return;
      } 
      this.a = null;
    }
    
    public Region getRegionAt(int param1Int) {
      return (Build.VERSION.SDK_INT >= 29) ? this.a.getRegionAt(param1Int) : null;
    }
    
    public int getRegionCount() {
      return (Build.VERSION.SDK_INT >= 29) ? this.a.getRegionCount() : 0;
    }
    
    public AccessibilityNodeInfoCompat getTargetForRegion(Region param1Region) {
      if (Build.VERSION.SDK_INT >= 29) {
        AccessibilityNodeInfo accessibilityNodeInfo = this.a.getTargetForRegion(param1Region);
        if (accessibilityNodeInfo != null)
          return AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo); 
      } 
      return null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\accessibility\AccessibilityNodeInfoCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */