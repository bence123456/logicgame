// Generated from C:/Users/Ben/IdeaProjects/logicgame/src/main/com.bkonecsni.logicgame.antlr4\map.g4 by ANTLR 4.7
package map;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class mapParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NUMBER=1, CHAR=2, COLOR=3, HDN=4, SYMBOL=5, TILE=6, ITEMS=7, T=8, LP=9, 
		RP=10, COMMA=11, AT=12, LBR=13, RBR=14, LCBR=15, RCBR=16, WS=17;
	public static final int
		RULE_map = 0, RULE_tile = 1, RULE_itemList = 2, RULE_type = 3, RULE_position = 4, 
		RULE_size = 5, RULE_color = 6, RULE_item = 7;
	public static final String[] ruleNames = {
		"map", "tile", "itemList", "type", "position", "size", "color", "item"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, "'tile:'", "'items:'", "'Type'", "'('", 
		"')'", "','", "'@'", "'['", "']'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NUMBER", "CHAR", "COLOR", "HDN", "SYMBOL", "TILE", "ITEMS", "T", 
		"LP", "RP", "COMMA", "AT", "LBR", "RBR", "LCBR", "RCBR", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "map.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public mapParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MapContext extends ParserRuleContext {
		public List<TileContext> tile() {
			return getRuleContexts(TileContext.class);
		}
		public TileContext tile(int i) {
			return getRuleContext(TileContext.class,i);
		}
		public MapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_map; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mapListener ) ((mapListener)listener).enterMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mapListener ) ((mapListener)listener).exitMap(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mapVisitor ) return ((mapVisitor<? extends T>)visitor).visitMap(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MapContext map() throws RecognitionException {
		MapContext _localctx = new MapContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_map);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TILE) {
				{
				{
				setState(16);
				tile();
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TileContext extends ParserRuleContext {
		public TerminalNode TILE() { return getToken(mapParser.TILE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode AT() { return getToken(mapParser.AT, 0); }
		public PositionContext position() {
			return getRuleContext(PositionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(mapParser.COMMA, 0); }
		public ItemListContext itemList() {
			return getRuleContext(ItemListContext.class,0);
		}
		public SizeContext size() {
			return getRuleContext(SizeContext.class,0);
		}
		public TileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mapListener ) ((mapListener)listener).enterTile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mapListener ) ((mapListener)listener).exitTile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mapVisitor ) return ((mapVisitor<? extends T>)visitor).visitTile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TileContext tile() throws RecognitionException {
		TileContext _localctx = new TileContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_tile);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(TILE);
			setState(23);
			type();
			setState(24);
			match(AT);
			setState(25);
			position();
			setState(27);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(26);
				size();
				}
				break;
			}
			setState(29);
			match(COMMA);
			setState(30);
			itemList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ItemListContext extends ParserRuleContext {
		public TerminalNode ITEMS() { return getToken(mapParser.ITEMS, 0); }
		public TerminalNode LCBR() { return getToken(mapParser.LCBR, 0); }
		public ColorContext color() {
			return getRuleContext(ColorContext.class,0);
		}
		public TerminalNode RCBR() { return getToken(mapParser.RCBR, 0); }
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public ItemListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itemList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mapListener ) ((mapListener)listener).enterItemList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mapListener ) ((mapListener)listener).exitItemList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mapVisitor ) return ((mapVisitor<? extends T>)visitor).visitItemList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemListContext itemList() throws RecognitionException {
		ItemListContext _localctx = new ItemListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_itemList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(ITEMS);
			setState(33);
			match(LCBR);
			setState(34);
			color();
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBR) {
				{
				{
				setState(35);
				item();
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			match(RCBR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode T() { return getToken(mapParser.T, 0); }
		public TerminalNode NUMBER() { return getToken(mapParser.NUMBER, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mapListener ) ((mapListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mapListener ) ((mapListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mapVisitor ) return ((mapVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(T);
			setState(44);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PositionContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(mapParser.LP, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(mapParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(mapParser.NUMBER, i);
		}
		public TerminalNode COMMA() { return getToken(mapParser.COMMA, 0); }
		public TerminalNode RP() { return getToken(mapParser.RP, 0); }
		public PositionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_position; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mapListener ) ((mapListener)listener).enterPosition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mapListener ) ((mapListener)listener).exitPosition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mapVisitor ) return ((mapVisitor<? extends T>)visitor).visitPosition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PositionContext position() throws RecognitionException {
		PositionContext _localctx = new PositionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_position);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(LP);
			setState(47);
			match(NUMBER);
			setState(48);
			match(COMMA);
			setState(49);
			match(NUMBER);
			setState(50);
			match(RP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SizeContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(mapParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(mapParser.COMMA, i);
		}
		public TerminalNode LBR() { return getToken(mapParser.LBR, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(mapParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(mapParser.NUMBER, i);
		}
		public TerminalNode RBR() { return getToken(mapParser.RBR, 0); }
		public SizeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_size; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mapListener ) ((mapListener)listener).enterSize(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mapListener ) ((mapListener)listener).exitSize(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mapVisitor ) return ((mapVisitor<? extends T>)visitor).visitSize(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SizeContext size() throws RecognitionException {
		SizeContext _localctx = new SizeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_size);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(COMMA);
			setState(53);
			match(LBR);
			setState(54);
			match(NUMBER);
			setState(55);
			match(COMMA);
			setState(56);
			match(NUMBER);
			setState(57);
			match(RBR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColorContext extends ParserRuleContext {
		public TerminalNode LBR() { return getToken(mapParser.LBR, 0); }
		public TerminalNode COLOR() { return getToken(mapParser.COLOR, 0); }
		public TerminalNode RBR() { return getToken(mapParser.RBR, 0); }
		public ColorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_color; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mapListener ) ((mapListener)listener).enterColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mapListener ) ((mapListener)listener).exitColor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mapVisitor ) return ((mapVisitor<? extends T>)visitor).visitColor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColorContext color() throws RecognitionException {
		ColorContext _localctx = new ColorContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_color);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(LBR);
			setState(60);
			match(COLOR);
			setState(61);
			match(RBR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ItemContext extends ParserRuleContext {
		public TerminalNode LBR() { return getToken(mapParser.LBR, 0); }
		public TerminalNode RBR() { return getToken(mapParser.RBR, 0); }
		public TerminalNode NUMBER() { return getToken(mapParser.NUMBER, 0); }
		public TerminalNode CHAR() { return getToken(mapParser.CHAR, 0); }
		public TerminalNode SYMBOL() { return getToken(mapParser.SYMBOL, 0); }
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mapListener ) ((mapListener)listener).enterItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mapListener ) ((mapListener)listener).exitItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mapVisitor ) return ((mapVisitor<? extends T>)visitor).visitItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(LBR);
			setState(64);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << CHAR) | (1L << SYMBOL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(65);
			match(RBR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23F\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\7\2\24\n\2\f\2"+
		"\16\2\27\13\2\3\3\3\3\3\3\3\3\3\3\5\3\36\n\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\7\4\'\n\4\f\4\16\4*\13\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\2\2"+
		"\n\2\4\6\b\n\f\16\20\2\3\4\2\3\4\7\7\2@\2\25\3\2\2\2\4\30\3\2\2\2\6\""+
		"\3\2\2\2\b-\3\2\2\2\n\60\3\2\2\2\f\66\3\2\2\2\16=\3\2\2\2\20A\3\2\2\2"+
		"\22\24\5\4\3\2\23\22\3\2\2\2\24\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2"+
		"\26\3\3\2\2\2\27\25\3\2\2\2\30\31\7\b\2\2\31\32\5\b\5\2\32\33\7\16\2\2"+
		"\33\35\5\n\6\2\34\36\5\f\7\2\35\34\3\2\2\2\35\36\3\2\2\2\36\37\3\2\2\2"+
		"\37 \7\r\2\2 !\5\6\4\2!\5\3\2\2\2\"#\7\t\2\2#$\7\21\2\2$(\5\16\b\2%\'"+
		"\5\20\t\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)+\3\2\2\2*(\3\2\2\2"+
		"+,\7\22\2\2,\7\3\2\2\2-.\7\n\2\2./\7\3\2\2/\t\3\2\2\2\60\61\7\13\2\2\61"+
		"\62\7\3\2\2\62\63\7\r\2\2\63\64\7\3\2\2\64\65\7\f\2\2\65\13\3\2\2\2\66"+
		"\67\7\r\2\2\678\7\17\2\289\7\3\2\29:\7\r\2\2:;\7\3\2\2;<\7\20\2\2<\r\3"+
		"\2\2\2=>\7\17\2\2>?\7\5\2\2?@\7\20\2\2@\17\3\2\2\2AB\7\17\2\2BC\t\2\2"+
		"\2CD\7\20\2\2D\21\3\2\2\2\5\25\35(";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}