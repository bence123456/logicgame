// Generated from C:/Users/Ben/IdeaProjects/logicgame/src/main/com.bkonecsni.logicgame.antlr4\types.g4 by ANTLR 4.7
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, EMPTY_STRING=22, ITEMS=23, T=24, 
		EMPTY=25, LOOP=26, ISEQ=27, EQ=28, ARR=29, COL=30, WS=31, BOOL=32, ID=33, 
		NUMBER=34, STRING=35, INCORDESC=36, CHAR=37, COLOR=38, HDN=39, SYMBOL=40, 
		LP=41, RP=42, COMMA=43, SCOLON=44, NEG=45;
	public static final int
		RULE_types = 0, RULE_typedecl = 1, RULE_typedef = 2, RULE_typehead = 3, 
		RULE_loop = 4, RULE_typeparams = 5, RULE_typestatement = 6, RULE_condition = 7, 
		RULE_updatestatement = 8, RULE_parens_nr = 9, RULE_typeitem = 10, RULE_statementList = 11, 
		RULE_statement = 12, RULE_variableDeclaration = 13, RULE_typeName = 14, 
		RULE_listType = 15, RULE_type = 16, RULE_elseStatement = 17, RULE_ifStatement = 18, 
		RULE_forStatement = 19, RULE_block = 20, RULE_assignmentStatement = 21, 
		RULE_modifyStatement = 22, RULE_boolStatement = 23, RULE_returnStatement = 24, 
		RULE_multipleExpression = 25, RULE_operator = 26, RULE_expression = 27, 
		RULE_varName = 28, RULE_func = 29, RULE_funcname = 30, RULE_params = 31, 
		RULE_param = 32, RULE_item = 33, RULE_mparam = 34;
	public static final String[] ruleNames = {
		"types", "typedecl", "typedef", "typehead", "loop", "typeparams", "typestatement", 
		"condition", "updatestatement", "parens_nr", "typeitem", "statementList", 
		"statement", "variableDeclaration", "typeName", "listType", "type", "elseStatement", 
		"ifStatement", "forStatement", "block", "assignmentStatement", "modifyStatement", 
		"boolStatement", "returnStatement", "multipleExpression", "operator", 
		"expression", "varName", "func", "funcname", "params", "param", "item", 
		"mparam"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'List'", "'else'", "'if'", "'for '", "'{'", "'}'", "'return'", 
		"'>'", "'<'", "'<='", "'>='", "'!='", "'+'", "'-'", "'+='", "'-='", "'&&'", 
		"'||'", "'.'", "'['", "']'", null, "'items'", "'Type'", "'empty'", "'Loop'", 
		"'=='", "'='", "'->'", "':'", null, null, null, null, null, null, null, 
		null, null, null, "'('", "')'", "','", "';'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "EMPTY_STRING", 
		"ITEMS", "T", "EMPTY", "LOOP", "ISEQ", "EQ", "ARR", "COL", "WS", "BOOL", 
		"ID", "NUMBER", "STRING", "INCORDESC", "CHAR", "COLOR", "HDN", "SYMBOL", 
		"LP", "RP", "COMMA", "SCOLON", "NEG"
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
		public List<TypedeclContext> typedecl() {
			return getRuleContexts(TypedeclContext.class);
		}
		public TypedeclContext typedecl(int i) {
			return getRuleContext(TypedeclContext.class,i);
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
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70);
				typedecl();
				}
				}
				setState(73); 
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

	public static class TypedeclContext extends ParserRuleContext {
		public TypeheadContext typehead() {
			return getRuleContext(TypeheadContext.class,0);
		}
		public TypedefContext typedef() {
			return getRuleContext(TypedefContext.class,0);
		}
		public TypedeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterTypedecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitTypedecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitTypedecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedeclContext typedecl() throws RecognitionException {
		TypedeclContext _localctx = new TypedeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_typedecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			typehead();
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__6) | (1L << ITEMS) | (1L << BOOL) | (1L << ID) | (1L << NUMBER) | (1L << STRING) | (1L << NEG))) != 0)) {
				{
				setState(76);
				typedef();
				}
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
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
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
		enterRule(_localctx, 4, RULE_typedef);
		int _la;
		try {
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				loop();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(81); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(80);
					typestatement();
					}
					}
					setState(83); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==ITEMS );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(85);
				statementList();
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
		enterRule(_localctx, 6, RULE_typehead);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T);
			setState(89);
			match(NUMBER);
			setState(90);
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
		public TypeparamsContext typeparams() {
			return getRuleContext(TypeparamsContext.class,0);
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
		enterRule(_localctx, 8, RULE_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(ITEMS);
			setState(93);
			parens_nr();
			setState(94);
			match(COL);
			setState(95);
			match(LOOP);
			setState(96);
			match(LP);
			setState(97);
			typeparams();
			setState(98);
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

	public static class TypeparamsContext extends ParserRuleContext {
		public List<TypeitemContext> typeitem() {
			return getRuleContexts(TypeitemContext.class);
		}
		public TypeitemContext typeitem(int i) {
			return getRuleContext(TypeitemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(typesParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(typesParser.COMMA, i);
		}
		public TypeparamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeparams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterTypeparams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitTypeparams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitTypeparams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeparamsContext typeparams() throws RecognitionException {
		TypeparamsContext _localctx = new TypeparamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typeparams);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(100);
					typeitem();
					setState(101);
					match(COMMA);
					}
					} 
				}
				setState(107);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(108);
			typeitem();
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
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode ARR() { return getToken(typesParser.ARR, 0); }
		public List<UpdatestatementContext> updatestatement() {
			return getRuleContexts(UpdatestatementContext.class);
		}
		public UpdatestatementContext updatestatement(int i) {
			return getRuleContext(UpdatestatementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(typesParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(typesParser.COMMA, i);
		}
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
		enterRule(_localctx, 12, RULE_typestatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			condition();
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(111);
				match(COMMA);
				setState(112);
				condition();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			match(ARR);
			setState(119);
			updatestatement();
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(120);
				match(COMMA);
				setState(121);
				updatestatement();
				}
				}
				setState(126);
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

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode ITEMS() { return getToken(typesParser.ITEMS, 0); }
		public Parens_nrContext parens_nr() {
			return getRuleContext(Parens_nrContext.class,0);
		}
		public TerminalNode ISEQ() { return getToken(typesParser.ISEQ, 0); }
		public TypeitemContext typeitem() {
			return getRuleContext(TypeitemContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(ITEMS);
			setState(128);
			parens_nr();
			setState(129);
			match(ISEQ);
			setState(130);
			typeitem();
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

	public static class UpdatestatementContext extends ParserRuleContext {
		public TerminalNode ITEMS() { return getToken(typesParser.ITEMS, 0); }
		public Parens_nrContext parens_nr() {
			return getRuleContext(Parens_nrContext.class,0);
		}
		public TerminalNode EQ() { return getToken(typesParser.EQ, 0); }
		public TypeitemContext typeitem() {
			return getRuleContext(TypeitemContext.class,0);
		}
		public UpdatestatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updatestatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterUpdatestatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitUpdatestatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitUpdatestatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdatestatementContext updatestatement() throws RecognitionException {
		UpdatestatementContext _localctx = new UpdatestatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_updatestatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(ITEMS);
			setState(133);
			parens_nr();
			setState(134);
			match(EQ);
			setState(135);
			typeitem();
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
		enterRule(_localctx, 18, RULE_parens_nr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(LP);
			setState(138);
			match(NUMBER);
			setState(139);
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

	public static class TypeitemContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(typesParser.NUMBER, 0); }
		public TerminalNode CHAR() { return getToken(typesParser.CHAR, 0); }
		public TerminalNode COLOR() { return getToken(typesParser.COLOR, 0); }
		public TerminalNode SYMBOL() { return getToken(typesParser.SYMBOL, 0); }
		public TerminalNode EMPTY_STRING() { return getToken(typesParser.EMPTY_STRING, 0); }
		public TypeitemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeitem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterTypeitem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitTypeitem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitTypeitem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeitemContext typeitem() throws RecognitionException {
		TypeitemContext _localctx = new TypeitemContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typeitem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
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

	public static class StatementListContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterStatementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitStatementList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitStatementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementListContext statementList() throws RecognitionException {
		StatementListContext _localctx = new StatementListContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statementList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(143);
				statement();
				}
				}
				setState(146); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__6) | (1L << BOOL) | (1L << ID) | (1L << NUMBER) | (1L << STRING) | (1L << NEG))) != 0) );
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

	public static class StatementContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public AssignmentStatementContext assignmentStatement() {
			return getRuleContext(AssignmentStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public ModifyStatementContext modifyStatement() {
			return getRuleContext(ModifyStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_statement);
		try {
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				ifStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				block();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(151);
				assignmentStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(152);
				forStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(153);
				returnStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(154);
				modifyStatement();
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

	public static class VariableDeclarationContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(typesParser.SCOLON, 0); }
		public MultipleExpressionContext multipleExpression() {
			return getRuleContext(MultipleExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			typeName();
			setState(158);
			varName();
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(159);
				match(EQ);
				setState(160);
				multipleExpression();
				}
			}

			setState(163);
			match(SCOLON);
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

	public static class TypeNameContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ListTypeContext listType() {
			return getRuleContext(ListTypeContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_typeName);
		try {
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				type();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				listType();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ListTypeContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(typesParser.LP, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RP() { return getToken(typesParser.RP, 0); }
		public ListTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterListType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitListType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitListType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListTypeContext listType() throws RecognitionException {
		ListTypeContext _localctx = new ListTypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_listType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(T__0);
			setState(170);
			match(LP);
			setState(171);
			type();
			setState(172);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(typesParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
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

	public static class ElseStatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			match(T__1);
			setState(177);
			block();
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

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(typesParser.LP, 0); }
		public BoolStatementContext boolStatement() {
			return getRuleContext(BoolStatementContext.class,0);
		}
		public TerminalNode RP() { return getToken(typesParser.RP, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(T__2);
			setState(180);
			match(LP);
			setState(181);
			boolStatement();
			setState(182);
			match(RP);
			setState(183);
			block();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(184);
				elseStatement();
				}
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

	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(typesParser.LP, 0); }
		public TerminalNode RP() { return getToken(typesParser.RP, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<VarNameContext> varName() {
			return getRuleContexts(VarNameContext.class);
		}
		public VarNameContext varName(int i) {
			return getRuleContext(VarNameContext.class,i);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public BoolStatementContext boolStatement() {
			return getRuleContext(BoolStatementContext.class,0);
		}
		public TerminalNode INCORDESC() { return getToken(typesParser.INCORDESC, 0); }
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(T__3);
			setState(188);
			match(LP);
			setState(199);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				{
				setState(189);
				type();
				setState(190);
				varName();
				setState(191);
				match(COL);
				setState(192);
				varName();
				}
				}
				break;
			case 2:
				{
				{
				setState(194);
				variableDeclaration();
				setState(195);
				boolStatement();
				setState(196);
				varName();
				setState(197);
				match(INCORDESC);
				}
				}
				break;
			}
			setState(201);
			match(RP);
			setState(202);
			block();
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

	public static class BlockContext extends ParserRuleContext {
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(T__4);
			setState(205);
			statementList();
			setState(206);
			match(T__5);
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

	public static class AssignmentStatementContext extends ParserRuleContext {
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public MultipleExpressionContext multipleExpression() {
			return getRuleContext(MultipleExpressionContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(typesParser.SCOLON, 0); }
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			varName();
			setState(209);
			match(EQ);
			setState(210);
			multipleExpression();
			setState(211);
			match(SCOLON);
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

	public static class ModifyStatementContext extends ParserRuleContext {
		public MultipleExpressionContext multipleExpression() {
			return getRuleContext(MultipleExpressionContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(typesParser.SCOLON, 0); }
		public ModifyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterModifyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitModifyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitModifyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifyStatementContext modifyStatement() throws RecognitionException {
		ModifyStatementContext _localctx = new ModifyStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_modifyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			multipleExpression();
			setState(214);
			match(SCOLON);
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

	public static class BoolStatementContext extends ParserRuleContext {
		public MultipleExpressionContext multipleExpression() {
			return getRuleContext(MultipleExpressionContext.class,0);
		}
		public TerminalNode SCOLON() { return getToken(typesParser.SCOLON, 0); }
		public BoolStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterBoolStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitBoolStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitBoolStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolStatementContext boolStatement() throws RecognitionException {
		BoolStatementContext _localctx = new BoolStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_boolStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			multipleExpression();
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SCOLON) {
				{
				setState(217);
				match(SCOLON);
				}
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode SCOLON() { return getToken(typesParser.SCOLON, 0); }
		public TerminalNode BOOL() { return getToken(typesParser.BOOL, 0); }
		public MultipleExpressionContext multipleExpression() {
			return getRuleContext(MultipleExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			match(T__6);
			setState(223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(221);
				match(BOOL);
				}
				break;
			case 2:
				{
				setState(222);
				multipleExpression();
				}
				break;
			}
			setState(225);
			match(SCOLON);
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

	public static class MultipleExpressionContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<OperatorContext> operator() {
			return getRuleContexts(OperatorContext.class);
		}
		public OperatorContext operator(int i) {
			return getRuleContext(OperatorContext.class,i);
		}
		public MultipleExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multipleExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterMultipleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitMultipleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitMultipleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleExpressionContext multipleExpression() throws RecognitionException {
		MultipleExpressionContext _localctx = new MultipleExpressionContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_multipleExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			expression();
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << ISEQ))) != 0)) {
				{
				{
				setState(228);
				operator();
				setState(229);
				expression();
				}
				}
				setState(235);
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

	public static class OperatorContext extends ParserRuleContext {
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << ISEQ))) != 0)) ) {
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

	public static class ExpressionContext extends ParserRuleContext {
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public VarNameContext varName() {
			return getRuleContext(VarNameContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(typesParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(typesParser.STRING, 0); }
		public TerminalNode BOOL() { return getToken(typesParser.BOOL, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_expression);
		try {
			setState(243);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(238);
				func();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(239);
				varName();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(240);
				match(NUMBER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(241);
				match(STRING);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(242);
				match(BOOL);
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

	public static class VarNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(typesParser.ID, 0); }
		public VarNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterVarName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitVarName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitVarName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarNameContext varName() throws RecognitionException {
		VarNameContext _localctx = new VarNameContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_varName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
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

	public static class FuncContext extends ParserRuleContext {
		public FuncnameContext funcname() {
			return getRuleContext(FuncnameContext.class,0);
		}
		public TerminalNode LP() { return getToken(typesParser.LP, 0); }
		public TerminalNode RP() { return getToken(typesParser.RP, 0); }
		public TerminalNode NEG() { return getToken(typesParser.NEG, 0); }
		public TerminalNode ID() { return getToken(typesParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitFunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitFunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEG) {
				{
				setState(247);
				match(NEG);
				}
			}

			setState(252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(250);
				match(ID);
				setState(251);
				match(T__18);
				}
				break;
			}
			setState(254);
			funcname();
			setState(255);
			match(LP);
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(256);
				params();
				}
			}

			setState(259);
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
		public TerminalNode ID() { return getToken(typesParser.ID, 0); }
		public FuncnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterFuncname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitFuncname(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitFuncname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncnameContext funcname() throws RecognitionException {
		FuncnameContext _localctx = new FuncnameContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_funcname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
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
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
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
		enterRule(_localctx, 62, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			param();
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(264);
				match(COMMA);
				setState(265);
				param();
				}
				}
				setState(270);
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

	public static class ParamContext extends ParserRuleContext {
		public MparamContext mparam() {
			return getRuleContext(MparamContext.class,0);
		}
		public ItemContext item() {
			return getRuleContext(ItemContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(typesParser.NUMBER, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_param);
		try {
			setState(274);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				mparam();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				item();
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(273);
				match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		enterRule(_localctx, 66, RULE_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(T__19);
			setState(277);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << CHAR) | (1L << COLOR) | (1L << SYMBOL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(278);
			match(T__20);
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

	public static class MparamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(typesParser.ID, 0); }
		public MparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mparam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).enterMparam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof typesListener ) ((typesListener)listener).exitMparam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof typesVisitor ) return ((typesVisitor<? extends T>)visitor).visitMparam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MparamContext mparam() throws RecognitionException {
		MparamContext _localctx = new MparamContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_mparam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3/\u011d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\6\2J\n\2\r\2\16\2K\3\3\3\3\5\3P\n\3\3\4\3"+
		"\4\6\4T\n\4\r\4\16\4U\3\4\5\4Y\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\7\7j\n\7\f\7\16\7m\13\7\3\7\3\7\3\b\3\b\3\b\7"+
		"\bt\n\b\f\b\16\bw\13\b\3\b\3\b\3\b\3\b\7\b}\n\b\f\b\16\b\u0080\13\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r"+
		"\6\r\u0093\n\r\r\r\16\r\u0094\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u009e\n\16\3\17\3\17\3\17\3\17\5\17\u00a4\n\17\3\17\3\17\3\20\3\20\5"+
		"\20\u00aa\n\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\5\24\u00bc\n\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u00ca\n\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\5\31\u00dd"+
		"\n\31\3\32\3\32\3\32\5\32\u00e2\n\32\3\32\3\32\3\33\3\33\3\33\3\33\7\33"+
		"\u00ea\n\33\f\33\16\33\u00ed\13\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35"+
		"\5\35\u00f6\n\35\3\36\3\36\3\37\5\37\u00fb\n\37\3\37\3\37\5\37\u00ff\n"+
		"\37\3\37\3\37\3\37\5\37\u0104\n\37\3\37\3\37\3 \3 \3!\3!\3!\7!\u010d\n"+
		"!\f!\16!\u0110\13!\3\"\3\"\3\"\5\"\u0115\n\"\3#\3#\3#\3#\3$\3$\3$\2\2"+
		"%\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDF"+
		"\2\5\6\2\30\30$$\'(**\4\2\n\24\35\35\5\2$$\'(**\2\u0119\2I\3\2\2\2\4M"+
		"\3\2\2\2\6X\3\2\2\2\bZ\3\2\2\2\n^\3\2\2\2\fk\3\2\2\2\16p\3\2\2\2\20\u0081"+
		"\3\2\2\2\22\u0086\3\2\2\2\24\u008b\3\2\2\2\26\u008f\3\2\2\2\30\u0092\3"+
		"\2\2\2\32\u009d\3\2\2\2\34\u009f\3\2\2\2\36\u00a9\3\2\2\2 \u00ab\3\2\2"+
		"\2\"\u00b0\3\2\2\2$\u00b2\3\2\2\2&\u00b5\3\2\2\2(\u00bd\3\2\2\2*\u00ce"+
		"\3\2\2\2,\u00d2\3\2\2\2.\u00d7\3\2\2\2\60\u00da\3\2\2\2\62\u00de\3\2\2"+
		"\2\64\u00e5\3\2\2\2\66\u00ee\3\2\2\28\u00f5\3\2\2\2:\u00f7\3\2\2\2<\u00fa"+
		"\3\2\2\2>\u0107\3\2\2\2@\u0109\3\2\2\2B\u0114\3\2\2\2D\u0116\3\2\2\2F"+
		"\u011a\3\2\2\2HJ\5\4\3\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\3\3"+
		"\2\2\2MO\5\b\5\2NP\5\6\4\2ON\3\2\2\2OP\3\2\2\2P\5\3\2\2\2QY\5\n\6\2RT"+
		"\5\16\b\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2VY\3\2\2\2WY\5\30\r\2"+
		"XQ\3\2\2\2XS\3\2\2\2XW\3\2\2\2Y\7\3\2\2\2Z[\7\32\2\2[\\\7$\2\2\\]\7 \2"+
		"\2]\t\3\2\2\2^_\7\31\2\2_`\5\24\13\2`a\7 \2\2ab\7\34\2\2bc\7+\2\2cd\5"+
		"\f\7\2de\7,\2\2e\13\3\2\2\2fg\5\26\f\2gh\7-\2\2hj\3\2\2\2if\3\2\2\2jm"+
		"\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\5\26\f\2o\r\3\2\2\2"+
		"pu\5\20\t\2qr\7-\2\2rt\5\20\t\2sq\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2"+
		"\2vx\3\2\2\2wu\3\2\2\2xy\7\37\2\2y~\5\22\n\2z{\7-\2\2{}\5\22\n\2|z\3\2"+
		"\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\17\3\2\2\2\u0080~\3\2\2"+
		"\2\u0081\u0082\7\31\2\2\u0082\u0083\5\24\13\2\u0083\u0084\7\35\2\2\u0084"+
		"\u0085\5\26\f\2\u0085\21\3\2\2\2\u0086\u0087\7\31\2\2\u0087\u0088\5\24"+
		"\13\2\u0088\u0089\7\36\2\2\u0089\u008a\5\26\f\2\u008a\23\3\2\2\2\u008b"+
		"\u008c\7+\2\2\u008c\u008d\7$\2\2\u008d\u008e\7,\2\2\u008e\25\3\2\2\2\u008f"+
		"\u0090\t\2\2\2\u0090\27\3\2\2\2\u0091\u0093\5\32\16\2\u0092\u0091\3\2"+
		"\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\31\3\2\2\2\u0096\u009e\5\34\17\2\u0097\u009e\5&\24\2\u0098\u009e\5*\26"+
		"\2\u0099\u009e\5,\27\2\u009a\u009e\5(\25\2\u009b\u009e\5\62\32\2\u009c"+
		"\u009e\5.\30\2\u009d\u0096\3\2\2\2\u009d\u0097\3\2\2\2\u009d\u0098\3\2"+
		"\2\2\u009d\u0099\3\2\2\2\u009d\u009a\3\2\2\2\u009d\u009b\3\2\2\2\u009d"+
		"\u009c\3\2\2\2\u009e\33\3\2\2\2\u009f\u00a0\5\36\20\2\u00a0\u00a3\5:\36"+
		"\2\u00a1\u00a2\7\36\2\2\u00a2\u00a4\5\64\33\2\u00a3\u00a1\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\7.\2\2\u00a6\35\3\2\2\2"+
		"\u00a7\u00aa\5\"\22\2\u00a8\u00aa\5 \21\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8"+
		"\3\2\2\2\u00aa\37\3\2\2\2\u00ab\u00ac\7\3\2\2\u00ac\u00ad\7+\2\2\u00ad"+
		"\u00ae\5\"\22\2\u00ae\u00af\7,\2\2\u00af!\3\2\2\2\u00b0\u00b1\7#\2\2\u00b1"+
		"#\3\2\2\2\u00b2\u00b3\7\4\2\2\u00b3\u00b4\5*\26\2\u00b4%\3\2\2\2\u00b5"+
		"\u00b6\7\5\2\2\u00b6\u00b7\7+\2\2\u00b7\u00b8\5\60\31\2\u00b8\u00b9\7"+
		",\2\2\u00b9\u00bb\5*\26\2\u00ba\u00bc\5$\23\2\u00bb\u00ba\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\'\3\2\2\2\u00bd\u00be\7\6\2\2\u00be\u00c9\7+\2\2"+
		"\u00bf\u00c0\5\"\22\2\u00c0\u00c1\5:\36\2\u00c1\u00c2\7 \2\2\u00c2\u00c3"+
		"\5:\36\2\u00c3\u00ca\3\2\2\2\u00c4\u00c5\5\34\17\2\u00c5\u00c6\5\60\31"+
		"\2\u00c6\u00c7\5:\36\2\u00c7\u00c8\7&\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00bf"+
		"\3\2\2\2\u00c9\u00c4\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\7,\2\2\u00cc"+
		"\u00cd\5*\26\2\u00cd)\3\2\2\2\u00ce\u00cf\7\7\2\2\u00cf\u00d0\5\30\r\2"+
		"\u00d0\u00d1\7\b\2\2\u00d1+\3\2\2\2\u00d2\u00d3\5:\36\2\u00d3\u00d4\7"+
		"\36\2\2\u00d4\u00d5\5\64\33\2\u00d5\u00d6\7.\2\2\u00d6-\3\2\2\2\u00d7"+
		"\u00d8\5\64\33\2\u00d8\u00d9\7.\2\2\u00d9/\3\2\2\2\u00da\u00dc\5\64\33"+
		"\2\u00db\u00dd\7.\2\2\u00dc\u00db\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\61"+
		"\3\2\2\2\u00de\u00e1\7\t\2\2\u00df\u00e2\7\"\2\2\u00e0\u00e2\5\64\33\2"+
		"\u00e1\u00df\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4"+
		"\7.\2\2\u00e4\63\3\2\2\2\u00e5\u00eb\58\35\2\u00e6\u00e7\5\66\34\2\u00e7"+
		"\u00e8\58\35\2\u00e8\u00ea\3\2\2\2\u00e9\u00e6\3\2\2\2\u00ea\u00ed\3\2"+
		"\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\65\3\2\2\2\u00ed\u00eb"+
		"\3\2\2\2\u00ee\u00ef\t\3\2\2\u00ef\67\3\2\2\2\u00f0\u00f6\5<\37\2\u00f1"+
		"\u00f6\5:\36\2\u00f2\u00f6\7$\2\2\u00f3\u00f6\7%\2\2\u00f4\u00f6\7\"\2"+
		"\2\u00f5\u00f0\3\2\2\2\u00f5\u00f1\3\2\2\2\u00f5\u00f2\3\2\2\2\u00f5\u00f3"+
		"\3\2\2\2\u00f5\u00f4\3\2\2\2\u00f69\3\2\2\2\u00f7\u00f8\7#\2\2\u00f8;"+
		"\3\2\2\2\u00f9\u00fb\7/\2\2\u00fa\u00f9\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb"+
		"\u00fe\3\2\2\2\u00fc\u00fd\7#\2\2\u00fd\u00ff\7\25\2\2\u00fe\u00fc\3\2"+
		"\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\5> \2\u0101\u0103"+
		"\7+\2\2\u0102\u0104\5@!\2\u0103\u0102\3\2\2\2\u0103\u0104\3\2\2\2\u0104"+
		"\u0105\3\2\2\2\u0105\u0106\7,\2\2\u0106=\3\2\2\2\u0107\u0108\7#\2\2\u0108"+
		"?\3\2\2\2\u0109\u010e\5B\"\2\u010a\u010b\7-\2\2\u010b\u010d\5B\"\2\u010c"+
		"\u010a\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2"+
		"\2\2\u010fA\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0115\5F$\2\u0112\u0115"+
		"\5D#\2\u0113\u0115\7$\2\2\u0114\u0111\3\2\2\2\u0114\u0112\3\2\2\2\u0114"+
		"\u0113\3\2\2\2\u0115C\3\2\2\2\u0116\u0117\7\26\2\2\u0117\u0118\t\4\2\2"+
		"\u0118\u0119\7\27\2\2\u0119E\3\2\2\2\u011a\u011b\7#\2\2\u011bG\3\2\2\2"+
		"\30KOUXku~\u0094\u009d\u00a3\u00a9\u00bb\u00c9\u00dc\u00e1\u00eb\u00f5"+
		"\u00fa\u00fe\u0103\u010e\u0114";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}