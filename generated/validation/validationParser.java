// Generated from C:/BME_MSC/2_felev/onlab2/logicgame/src/main/com.bkonecsni.logicgame.antlr4/validation\validation.g4 by ANTLR 4.7
package validation;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class validationParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BOOL=1, AREA_DEF=2, ID=3, NUMBER=4, CHAR=5, COLOR=6, HDN=7, SYMBOL=8, 
		WIN=9, LOOSE=10, ISEQ=11, TRUE=12, FALSE=13, EMPTY=14, LP=15, RP=16, COMMA=17, 
		COL=18, WS=19;
	public static final int
		RULE_validation = 0, RULE_win = 1, RULE_loose = 2, RULE_func = 3, RULE_funcname = 4, 
		RULE_params = 5, RULE_parens_nr = 6, RULE_item = 7;
	public static final String[] ruleNames = {
		"validation", "win", "loose", "func", "funcname", "params", "parens_nr", 
		"item"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "'=='", 
		"'true'", "'false'", "'empty'", "'('", "')'", "','", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "BOOL", "AREA_DEF", "ID", "NUMBER", "CHAR", "COLOR", "HDN", "SYMBOL", 
		"WIN", "LOOSE", "ISEQ", "TRUE", "FALSE", "EMPTY", "LP", "RP", "COMMA", 
		"COL", "WS"
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
	public String getGrammarFileName() { return "validation.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public validationParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ValidationContext extends ParserRuleContext {
		public TerminalNode LOOSE() { return getToken(validationParser.LOOSE, 0); }
		public TerminalNode WIN() { return getToken(validationParser.WIN, 0); }
		public List<WinContext> win() {
			return getRuleContexts(WinContext.class);
		}
		public WinContext win(int i) {
			return getRuleContext(WinContext.class,i);
		}
		public List<LooseContext> loose() {
			return getRuleContexts(LooseContext.class);
		}
		public LooseContext loose(int i) {
			return getRuleContext(LooseContext.class,i);
		}
		public ValidationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_validation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterValidation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitValidation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitValidation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValidationContext validation() throws RecognitionException {
		ValidationContext _localctx = new ValidationContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_validation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WIN) {
				{
				setState(16);
				match(WIN);
				}
			}

			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(19);
				win();
				}
				}
				setState(24);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(25);
			match(LOOSE);
			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26);
				loose();
				}
				}
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
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

	public static class WinContext extends ParserRuleContext {
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public TerminalNode ISEQ() { return getToken(validationParser.ISEQ, 0); }
		public TerminalNode BOOL() { return getToken(validationParser.BOOL, 0); }
		public WinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_win; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterWin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitWin(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitWin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WinContext win() throws RecognitionException {
		WinContext _localctx = new WinContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_win);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			func();
			setState(32);
			match(ISEQ);
			setState(33);
			match(BOOL);
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

	public static class LooseContext extends ParserRuleContext {
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public TerminalNode ISEQ() { return getToken(validationParser.ISEQ, 0); }
		public TerminalNode BOOL() { return getToken(validationParser.BOOL, 0); }
		public LooseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loose; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterLoose(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitLoose(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitLoose(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LooseContext loose() throws RecognitionException {
		LooseContext _localctx = new LooseContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_loose);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			func();
			setState(36);
			match(ISEQ);
			setState(37);
			match(BOOL);
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

	public static class FuncContext extends ParserRuleContext {
		public FuncnameContext funcname() {
			return getRuleContext(FuncnameContext.class,0);
		}
		public TerminalNode LP() { return getToken(validationParser.LP, 0); }
		public TerminalNode RP() { return getToken(validationParser.RP, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			funcname();
			setState(40);
			match(LP);
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AREA_DEF) | (1L << NUMBER) | (1L << CHAR) | (1L << COLOR) | (1L << SYMBOL))) != 0)) {
				{
				setState(41);
				params();
				}
			}

			setState(44);
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

	public static class FuncnameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(validationParser.ID, 0); }
		public FuncnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterFuncname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitFuncname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitFuncname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncnameContext funcname() throws RecognitionException {
		FuncnameContext _localctx = new FuncnameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(ID);
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
		public List<TerminalNode> COMMA() { return getTokens(validationParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(validationParser.COMMA, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(48);
					item();
					setState(49);
					match(COMMA);
					}
					} 
				}
				setState(55);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(56);
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
		public TerminalNode LP() { return getToken(validationParser.LP, 0); }
		public TerminalNode NUMBER() { return getToken(validationParser.NUMBER, 0); }
		public TerminalNode RP() { return getToken(validationParser.RP, 0); }
		public Parens_nrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parens_nr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterParens_nr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitParens_nr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitParens_nr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parens_nrContext parens_nr() throws RecognitionException {
		Parens_nrContext _localctx = new Parens_nrContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parens_nr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(LP);
			setState(59);
			match(NUMBER);
			setState(60);
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
		public TerminalNode NUMBER() { return getToken(validationParser.NUMBER, 0); }
		public TerminalNode CHAR() { return getToken(validationParser.CHAR, 0); }
		public TerminalNode COLOR() { return getToken(validationParser.COLOR, 0); }
		public TerminalNode SYMBOL() { return getToken(validationParser.SYMBOL, 0); }
		public TerminalNode AREA_DEF() { return getToken(validationParser.AREA_DEF, 0); }
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitItem(this);
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
			setState(62);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AREA_DEF) | (1L << NUMBER) | (1L << CHAR) | (1L << COLOR) | (1L << SYMBOL))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25C\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\5\2\24\n\2\3\2"+
		"\7\2\27\n\2\f\2\16\2\32\13\2\3\2\3\2\6\2\36\n\2\r\2\16\2\37\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\5\5-\n\5\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\7\7\7\66\n\7\f\7\16\79\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\2\2\n"+
		"\2\4\6\b\n\f\16\20\2\3\5\2\4\4\6\b\n\n\2?\2\23\3\2\2\2\4!\3\2\2\2\6%\3"+
		"\2\2\2\b)\3\2\2\2\n\60\3\2\2\2\f\67\3\2\2\2\16<\3\2\2\2\20@\3\2\2\2\22"+
		"\24\7\13\2\2\23\22\3\2\2\2\23\24\3\2\2\2\24\30\3\2\2\2\25\27\5\4\3\2\26"+
		"\25\3\2\2\2\27\32\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\33\3\2\2\2\32"+
		"\30\3\2\2\2\33\35\7\f\2\2\34\36\5\6\4\2\35\34\3\2\2\2\36\37\3\2\2\2\37"+
		"\35\3\2\2\2\37 \3\2\2\2 \3\3\2\2\2!\"\5\b\5\2\"#\7\r\2\2#$\7\3\2\2$\5"+
		"\3\2\2\2%&\5\b\5\2&\'\7\r\2\2\'(\7\3\2\2(\7\3\2\2\2)*\5\n\6\2*,\7\21\2"+
		"\2+-\5\f\7\2,+\3\2\2\2,-\3\2\2\2-.\3\2\2\2./\7\22\2\2/\t\3\2\2\2\60\61"+
		"\7\5\2\2\61\13\3\2\2\2\62\63\5\20\t\2\63\64\7\23\2\2\64\66\3\2\2\2\65"+
		"\62\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28:\3\2\2\29\67\3\2\2"+
		"\2:;\5\20\t\2;\r\3\2\2\2<=\7\21\2\2=>\7\6\2\2>?\7\22\2\2?\17\3\2\2\2@"+
		"A\t\2\2\2A\21\3\2\2\2\7\23\30\37,\67";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}