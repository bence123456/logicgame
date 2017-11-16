// Generated from C:/BME_MSC/2_felev/onlab2/logicgame/src/main/com.bkonecsni.logicgame.antlr4/types\types.g4 by ANTLR 4.7
package types;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class typesParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EMPTY_STRING=1, NUMBER=2, CHAR=3, COLOR=4, HDN=5, SYMBOL=6, ITEMS=7, T=8, 
		EMPTY=9, LOOP=10, ISEQ=11, EQ=12, LP=13, RP=14, COMMA=15, ARR=16, COL=17, 
		WS=18;
	public static final int
		RULE_types = 0, RULE_typedef = 1, RULE_typehead = 2, RULE_loop = 3, RULE_params = 4, 
		RULE_typestatement = 5, RULE_parens_nr = 6, RULE_item = 7;
	public static final String[] ruleNames = {
		"types", "typedef", "typehead", "loop", "params", "typestatement", "parens_nr", 
		"item"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'items'", "'Type'", "'empty'", 
		"'Loop'", "'=='", "'='", "'('", "')'", "','", "'->'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "EMPTY_STRING", "NUMBER", "CHAR", "COLOR", "HDN", "SYMBOL", "ITEMS", 
		"T", "EMPTY", "LOOP", "ISEQ", "EQ", "LP", "RP", "COMMA", "ARR", "COL", 
		"WS"
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
	public String getGrammarFileName() { return "types.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public typesParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TypesContext extends ParserRuleContext {
		public List<TypeheadContext> typehead() {
			return getRuleContexts(TypeheadContext.class);
		}
		public TypeheadContext typehead(int i) {
			return getRuleContext(TypeheadContext.class,i);
		}
		public List<TypedefContext> typedef() {
			return getRuleContexts(TypedefContext.class);
		}
		public TypedefContext typedef(int i) {
			return getRuleContext(TypedefContext.class,i);
		}
		public TypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_types; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypesContext types() throws RecognitionException {
		TypesContext _localctx = new TypesContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_types);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(16);
				typehead();
				setState(17);
				typedef();
				}
				}
				setState(21); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T );
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

	public static class TypedefContext extends ParserRuleContext {
		public LoopContext loop() {
			return getRuleContext(LoopContext.class,0);
		}
		public List<TypestatementContext> typestatement() {
			return getRuleContexts(TypestatementContext.class);
		}
		public TypestatementContext typestatement(int i) {
			return getRuleContext(TypestatementContext.class,i);
		}
		public TypedefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterTypedef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitTypedef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitTypedef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedefContext typedef() throws RecognitionException {
		TypedefContext _localctx = new TypedefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_typedef);
		int _la;
		try {
			setState(30);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(23);
				loop();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(24);
					typestatement();
					}
					}
					setState(27); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ITEMS );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
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

	public static class TypeheadContext extends ParserRuleContext {
		public TerminalNode T() { return getToken(typesParser.T, 0); }
		public TerminalNode NUMBER() { return getToken(typesParser.NUMBER, 0); }
		public TerminalNode COL() { return getToken(typesParser.COL, 0); }
		public TypeheadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typehead; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterTypehead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitTypehead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitTypehead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeheadContext typehead() throws RecognitionException {
		TypeheadContext _localctx = new TypeheadContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typehead);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T);
			setState(33);
			match(NUMBER);
			setState(34);
			match(COL);
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

	public static class LoopContext extends ParserRuleContext {
		public TerminalNode ITEMS() { return getToken(typesParser.ITEMS, 0); }
		public Parens_nrContext parens_nr() {
			return getRuleContext(Parens_nrContext.class,0);
		}
		public TerminalNode COL() { return getToken(typesParser.COL, 0); }
		public TerminalNode LOOP() { return getToken(typesParser.LOOP, 0); }
		public TerminalNode LP() { return getToken(typesParser.LP, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode RP() { return getToken(typesParser.RP, 0); }
		public LoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopContext loop() throws RecognitionException {
		LoopContext _localctx = new LoopContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(ITEMS);
			setState(37);
			parens_nr();
			setState(38);
			match(COL);
			setState(39);
			match(LOOP);
			setState(40);
			match(LP);
			setState(41);
			params();
			setState(42);
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

	public static class ParamsContext extends ParserRuleContext {
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(typesParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(typesParser.COMMA, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_params);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(44);
					item();
					setState(45);
					match(COMMA);
					}
					} 
				}
				setState(51);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(52);
			item();
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

	public static class TypestatementContext extends ParserRuleContext {
		public List<TerminalNode> ITEMS() { return getTokens(typesParser.ITEMS); }
		public TerminalNode ITEMS(int i) {
			return getToken(typesParser.ITEMS, i);
		}
		public List<Parens_nrContext> parens_nr() {
			return getRuleContexts(Parens_nrContext.class);
		}
		public Parens_nrContext parens_nr(int i) {
			return getRuleContext(Parens_nrContext.class,i);
		}
		public TerminalNode ISEQ() { return getToken(typesParser.ISEQ, 0); }
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public TerminalNode ARR() { return getToken(typesParser.ARR, 0); }
		public TerminalNode EQ() { return getToken(typesParser.EQ, 0); }
		public TypestatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typestatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterTypestatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitTypestatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitTypestatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypestatementContext typestatement() throws RecognitionException {
		TypestatementContext _localctx = new TypestatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typestatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(ITEMS);
			setState(55);
			parens_nr();
			setState(56);
			match(ISEQ);
			setState(57);
			item();
			setState(58);
			match(ARR);
			setState(59);
			match(ITEMS);
			setState(60);
			parens_nr();
			setState(61);
			match(EQ);
			setState(62);
			item();
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

	public static class Parens_nrContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(typesParser.LP, 0); }
		public TerminalNode NUMBER() { return getToken(typesParser.NUMBER, 0); }
		public TerminalNode RP() { return getToken(typesParser.RP, 0); }
		public Parens_nrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parens_nr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterParens_nr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitParens_nr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitParens_nr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parens_nrContext parens_nr() throws RecognitionException {
		Parens_nrContext _localctx = new Parens_nrContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parens_nr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(LP);
			setState(65);
			match(NUMBER);
			setState(66);
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

	public static class ItemContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(typesParser.NUMBER, 0); }
		public TerminalNode CHAR() { return getToken(typesParser.CHAR, 0); }
		public TerminalNode COLOR() { return getToken(typesParser.COLOR, 0); }
		public TerminalNode SYMBOL() { return getToken(typesParser.SYMBOL, 0); }
		public TerminalNode EMPTY_STRING() { return getToken(typesParser.EMPTY_STRING, 0); }
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitItem(this);
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
			setState(68);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EMPTY_STRING) | (1L << NUMBER) | (1L << CHAR) | (1L << COLOR) | (1L << SYMBOL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24I\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\6\2\26"+
		"\n\2\r\2\16\2\27\3\3\3\3\6\3\34\n\3\r\3\16\3\35\3\3\5\3!\n\3\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\7\6\62\n\6\f\6\16\6"+
		"\65\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2\3\4\2\3\6\b\b\2E\2\25\3\2\2\2"+
		"\4 \3\2\2\2\6\"\3\2\2\2\b&\3\2\2\2\n\63\3\2\2\2\f8\3\2\2\2\16B\3\2\2\2"+
		"\20F\3\2\2\2\22\23\5\6\4\2\23\24\5\4\3\2\24\26\3\2\2\2\25\22\3\2\2\2\26"+
		"\27\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\3\3\2\2\2\31!\5\b\5\2\32\34"+
		"\5\f\7\2\33\32\3\2\2\2\34\35\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36!\3"+
		"\2\2\2\37!\3\2\2\2 \31\3\2\2\2 \33\3\2\2\2 \37\3\2\2\2!\5\3\2\2\2\"#\7"+
		"\n\2\2#$\7\4\2\2$%\7\23\2\2%\7\3\2\2\2&\'\7\t\2\2\'(\5\16\b\2()\7\23\2"+
		"\2)*\7\f\2\2*+\7\17\2\2+,\5\n\6\2,-\7\20\2\2-\t\3\2\2\2./\5\20\t\2/\60"+
		"\7\21\2\2\60\62\3\2\2\2\61.\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64"+
		"\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66\67\5\20\t\2\67\13\3\2\2\289\7"+
		"\t\2\29:\5\16\b\2:;\7\r\2\2;<\5\20\t\2<=\7\22\2\2=>\7\t\2\2>?\5\16\b\2"+
		"?@\7\16\2\2@A\5\20\t\2A\r\3\2\2\2BC\7\17\2\2CD\7\4\2\2DE\7\20\2\2E\17"+
		"\3\2\2\2FG\t\2\2\2G\21\3\2\2\2\6\27\35 \63";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}