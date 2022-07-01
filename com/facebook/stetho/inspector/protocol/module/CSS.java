package com.facebook.stetho.inspector.protocol.module;

import com.facebook.stetho.common.ListUtil;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.StringUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.ComputedStyleAccumulator;
import com.facebook.stetho.inspector.elements.Document;
import com.facebook.stetho.inspector.elements.Origin;
import com.facebook.stetho.inspector.elements.StyleAccumulator;
import com.facebook.stetho.inspector.elements.StyleRuleNameAccumulator;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeerRegistrationListener;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public class CSS implements ChromeDevtoolsDomain {
  private final Document mDocument;
  
  private final ObjectMapper mObjectMapper;
  
  private final ChromePeerManager mPeerManager;
  
  public CSS(Document paramDocument) {
    this.mDocument = (Document)Util.throwIfNull(paramDocument);
    this.mObjectMapper = new ObjectMapper();
    this.mPeerManager = new ChromePeerManager();
    this.mPeerManager.setListener((PeerRegistrationListener)new PeerManagerListener());
  }
  
  @ChromeDevtoolsMethod
  public void disable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  @ChromeDevtoolsMethod
  public void enable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {}
  
  @ChromeDevtoolsMethod
  public JsonRpcResult getComputedStyleForNode(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    final GetComputedStyleForNodeRequest request = (GetComputedStyleForNodeRequest)this.mObjectMapper.convertValue(paramJSONObject, GetComputedStyleForNodeRequest.class);
    final GetComputedStyleForNodeResult result = new GetComputedStyleForNodeResult();
    getComputedStyleForNodeResult.computedStyle = new ArrayList<CSSComputedStyleProperty>();
    this.mDocument.postAndWait(new Runnable() {
          public void run() {
            Object object = CSS.this.mDocument.getElementForNodeId(request.nodeId);
            if (object == null) {
              object = new StringBuilder();
              object.append("Tried to get the style of an element that does not exist, using nodeid=");
              object.append(request.nodeId);
              LogUtil.e(object.toString());
              return;
            } 
            CSS.this.mDocument.getElementComputedStyles(object, new ComputedStyleAccumulator() {
                  public void store(String param2String1, String param2String2) {
                    CSS.CSSComputedStyleProperty cSSComputedStyleProperty = new CSS.CSSComputedStyleProperty();
                    cSSComputedStyleProperty.name = param2String1;
                    cSSComputedStyleProperty.value = param2String2;
                    result.computedStyle.add(cSSComputedStyleProperty);
                  }
                });
          }
        });
    return getComputedStyleForNodeResult;
  }
  
  @ChromeDevtoolsMethod
  public JsonRpcResult getMatchedStylesForNode(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    final GetMatchedStylesForNodeRequest request = (GetMatchedStylesForNodeRequest)this.mObjectMapper.convertValue(paramJSONObject, GetMatchedStylesForNodeRequest.class);
    final GetMatchedStylesForNodeResult result = new GetMatchedStylesForNodeResult();
    getMatchedStylesForNodeResult.matchedCSSRules = new ArrayList<RuleMatch>();
    getMatchedStylesForNodeResult.inherited = Collections.emptyList();
    getMatchedStylesForNodeResult.pseudoElements = Collections.emptyList();
    this.mDocument.postAndWait(new Runnable() {
          public void run() {
            final Object elementForNodeId = CSS.this.mDocument.getElementForNodeId(request.nodeId);
            if (object == null) {
              object = new StringBuilder();
              object.append("Failed to get style of an element that does not exist, nodeid=");
              object.append(request.nodeId);
              LogUtil.w(object.toString());
              return;
            } 
            CSS.this.mDocument.getElementStyleRuleNames(object, new StyleRuleNameAccumulator() {
                  public void store(String param2String, boolean param2Boolean) {
                    final ArrayList<CSS.CSSProperty> properties = new ArrayList();
                    CSS.RuleMatch ruleMatch = new CSS.RuleMatch();
                    ruleMatch.matchingSelectors = ListUtil.newImmutableList(Integer.valueOf(0));
                    CSS.Selector selector = new CSS.Selector();
                    selector.value = param2String;
                    CSS.CSSRule cSSRule = new CSS.CSSRule();
                    cSSRule.origin = Origin.REGULAR;
                    cSSRule.selectorList = new CSS.SelectorList();
                    cSSRule.selectorList.selectors = ListUtil.newImmutableList(selector);
                    cSSRule.style = new CSS.CSSStyle();
                    cSSRule.style.cssProperties = arrayList;
                    cSSRule.style.shorthandEntries = Collections.emptyList();
                    if (param2Boolean)
                      cSSRule.style.styleSheetId = String.format("%s.%s", new Object[] { Integer.toString(this.this$1.val$request.nodeId), selector.value }); 
                    CSS.this.mDocument.getElementStyles(elementForNodeId, param2String, new StyleAccumulator() {
                          public void store(String param3String1, String param3String2, boolean param3Boolean) {
                            CSS.CSSProperty cSSProperty = new CSS.CSSProperty();
                            cSSProperty.name = param3String1;
                            cSSProperty.value = param3String2;
                            properties.add(cSSProperty);
                          }
                        });
                    ruleMatch.rule = cSSRule;
                    result.matchedCSSRules.add(ruleMatch);
                  }
                });
          }
        });
    return getMatchedStylesForNodeResult;
  }
  
  @ChromeDevtoolsMethod
  public SetPropertyTextResult setPropertyText(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject) {
    SetPropertyTextRequest setPropertyTextRequest = (SetPropertyTextRequest)this.mObjectMapper.convertValue(paramJSONObject, SetPropertyTextRequest.class);
    final String[] key = setPropertyTextRequest.styleSheetId.split("\\.", 2);
    final int nodeId = Integer.parseInt(arrayOfString1[0]);
    final String ruleName = arrayOfString1[1];
    if (setPropertyTextRequest.text == null || !setPropertyTextRequest.text.contains(":")) {
      arrayOfString1 = null;
      final String[] value = arrayOfString1;
      final SetPropertyTextResult result = new SetPropertyTextResult();
      setPropertyTextResult1.style = new CSSStyle();
      setPropertyTextResult1.style.styleSheetId = setPropertyTextRequest.styleSheetId;
      setPropertyTextResult1.style.cssProperties = new ArrayList<CSSProperty>();
      setPropertyTextResult1.style.shorthandEntries = Collections.emptyList();
      this.mDocument.postAndWait(new Runnable() {
            public void run() {
              Object object = CSS.this.mDocument.getElementForNodeId(nodeId);
              if (object == null) {
                object = new StringBuilder();
                object.append("Failed to get style of an element that does not exist, nodeid=");
                object.append(nodeId);
                LogUtil.w(object.toString());
                return;
              } 
              if (key != null)
                CSS.this.mDocument.setElementStyle(object, ruleName, key, value); 
              CSS.this.mDocument.getElementStyles(object, ruleName, new StyleAccumulator() {
                    public void store(String param2String1, String param2String2, boolean param2Boolean) {
                      CSS.CSSProperty cSSProperty = new CSS.CSSProperty();
                      cSSProperty.name = param2String1;
                      cSSProperty.value = param2String2;
                      result.style.cssProperties.add(cSSProperty);
                    }
                  });
            }
          });
      return setPropertyTextResult1;
    } 
    String[] arrayOfString2 = setPropertyTextRequest.text.split(":", 2);
    final String key = arrayOfString2[0].trim();
    final String value = StringUtil.removeAll(arrayOfString2[1], ';').trim();
    final SetPropertyTextResult result = new SetPropertyTextResult();
    setPropertyTextResult.style = new CSSStyle();
    setPropertyTextResult.style.styleSheetId = setPropertyTextRequest.styleSheetId;
    setPropertyTextResult.style.cssProperties = new ArrayList<CSSProperty>();
    setPropertyTextResult.style.shorthandEntries = Collections.emptyList();
    this.mDocument.postAndWait(new Runnable() {
          public void run() {
            Object object = CSS.this.mDocument.getElementForNodeId(nodeId);
            if (object == null) {
              object = new StringBuilder();
              object.append("Failed to get style of an element that does not exist, nodeid=");
              object.append(nodeId);
              LogUtil.w(object.toString());
              return;
            } 
            if (key != null)
              CSS.this.mDocument.setElementStyle(object, ruleName, key, value); 
            CSS.this.mDocument.getElementStyles(object, ruleName, new StyleAccumulator() {
                  public void store(String param2String1, String param2String2, boolean param2Boolean) {
                    CSS.CSSProperty cSSProperty = new CSS.CSSProperty();
                    cSSProperty.name = param2String1;
                    cSSProperty.value = param2String2;
                    result.style.cssProperties.add(cSSProperty);
                  }
                });
          }
        });
    return setPropertyTextResult;
  }
  
  static class CSSComputedStyleProperty {
    @JsonProperty(required = true)
    public String name;
    
    @JsonProperty(required = true)
    public String value;
    
    private CSSComputedStyleProperty() {}
  }
  
  static class CSSProperty {
    @JsonProperty
    public Boolean disabled;
    
    @JsonProperty
    public Boolean implicit;
    
    @JsonProperty
    public Boolean important;
    
    @JsonProperty(required = true)
    public String name;
    
    @JsonProperty
    public Boolean parsedOk;
    
    @JsonProperty
    public CSS.SourceRange range;
    
    @JsonProperty
    public String text;
    
    @JsonProperty(required = true)
    public String value;
    
    private CSSProperty() {}
  }
  
  static class CSSRule {
    @JsonProperty
    public Origin origin;
    
    @JsonProperty(required = true)
    public CSS.SelectorList selectorList;
    
    @JsonProperty
    public CSS.CSSStyle style;
    
    @JsonProperty
    public String styleSheetId;
    
    private CSSRule() {}
  }
  
  static class CSSStyle {
    @JsonProperty(required = true)
    public List<CSS.CSSProperty> cssProperties;
    
    @JsonProperty
    public String cssText;
    
    @JsonProperty
    public CSS.SourceRange range;
    
    @JsonProperty
    public List<CSS.ShorthandEntry> shorthandEntries;
    
    @JsonProperty
    public String styleSheetId;
    
    private CSSStyle() {}
  }
  
  static class GetComputedStyleForNodeRequest {
    @JsonProperty(required = true)
    public int nodeId;
  }
  
  static class GetComputedStyleForNodeResult implements JsonRpcResult {
    @JsonProperty(required = true)
    public List<CSS.CSSComputedStyleProperty> computedStyle;
    
    private GetComputedStyleForNodeResult() {}
  }
  
  static class GetMatchedStylesForNodeRequest implements JsonRpcResult {
    @JsonProperty
    public Boolean excludeInherited;
    
    @JsonProperty
    public Boolean excludePseudo;
    
    @JsonProperty(required = true)
    public int nodeId;
  }
  
  static class GetMatchedStylesForNodeResult implements JsonRpcResult {
    @JsonProperty
    public List<CSS.InheritedStyleEntry> inherited;
    
    @JsonProperty
    public List<CSS.RuleMatch> matchedCSSRules;
    
    @JsonProperty
    public List<CSS.PseudoIdMatches> pseudoElements;
    
    private GetMatchedStylesForNodeResult() {}
  }
  
  static class InheritedStyleEntry {
    @JsonProperty(required = true)
    public CSS.CSSStyle inlineStyle;
    
    @JsonProperty(required = true)
    public List<CSS.RuleMatch> matchedCSSRules;
  }
  
  final class PeerManagerListener extends PeersRegisteredListener {
    private PeerManagerListener() {}
    
    public void onFirstPeerRegistered() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield this$0 : Lcom/facebook/stetho/inspector/protocol/module/CSS;
      //   6: invokestatic access$200 : (Lcom/facebook/stetho/inspector/protocol/module/CSS;)Lcom/facebook/stetho/inspector/elements/Document;
      //   9: invokevirtual addRef : ()V
      //   12: aload_0
      //   13: monitorexit
      //   14: return
      //   15: astore_1
      //   16: aload_0
      //   17: monitorexit
      //   18: aload_1
      //   19: athrow
      // Exception table:
      //   from	to	target	type
      //   2	12	15	finally
    }
    
    public void onLastPeerUnregistered() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield this$0 : Lcom/facebook/stetho/inspector/protocol/module/CSS;
      //   6: invokestatic access$200 : (Lcom/facebook/stetho/inspector/protocol/module/CSS;)Lcom/facebook/stetho/inspector/elements/Document;
      //   9: invokevirtual release : ()V
      //   12: aload_0
      //   13: monitorexit
      //   14: return
      //   15: astore_1
      //   16: aload_0
      //   17: monitorexit
      //   18: aload_1
      //   19: athrow
      // Exception table:
      //   from	to	target	type
      //   2	12	15	finally
    }
  }
  
  static class PseudoIdMatches {
    @JsonProperty(required = true)
    public List<CSS.RuleMatch> matches = new ArrayList<CSS.RuleMatch>();
    
    @JsonProperty(required = true)
    public int pseudoId;
  }
  
  static class RuleMatch {
    @JsonProperty
    public List<Integer> matchingSelectors;
    
    @JsonProperty
    public CSS.CSSRule rule;
    
    private RuleMatch() {}
  }
  
  static class Selector {
    @JsonProperty
    public CSS.SourceRange range;
    
    @JsonProperty(required = true)
    public String value;
    
    private Selector() {}
  }
  
  static class SelectorList {
    @JsonProperty
    public List<CSS.Selector> selectors;
    
    @JsonProperty
    public String text;
    
    private SelectorList() {}
  }
  
  static class SetPropertyTextRequest implements JsonRpcResult {
    @JsonProperty(required = true)
    public String styleSheetId;
    
    @JsonProperty(required = true)
    public String text;
  }
  
  static class SetPropertyTextResult implements JsonRpcResult {
    @JsonProperty(required = true)
    public CSS.CSSStyle style;
    
    private SetPropertyTextResult() {}
  }
  
  static class ShorthandEntry {
    @JsonProperty
    public Boolean imporant;
    
    @JsonProperty(required = true)
    public String name;
    
    @JsonProperty(required = true)
    public String value;
  }
  
  static class SourceRange {
    @JsonProperty(required = true)
    public int endColumn;
    
    @JsonProperty(required = true)
    public int endLine;
    
    @JsonProperty(required = true)
    public int startColumn;
    
    @JsonProperty(required = true)
    public int startLine;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\protocol\module\CSS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */