// Generated from C:/Users/Ben/IdeaProjects/logicgame/src/main/com.bkonecsni.logicgame.antlr4/validation\validation.g4 by ANTLR 4.7
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		BOOL=25, ID=26, NUMBER=27, STRING=28, INCORDESC=29, WS=30, CHAR=31, COLOR=32, 
		HDN=33, SYMBOL=34, LP=35, RP=36, COMMA=37, SCOLON=38, NEG=39;
	public static final int
		RULE_validation = 0, RULE_statementList = 1, RULE_statement = 2, RULE_variableDeclaration = 3, 
		RULE_typeName = 4, RULE_listType = 5, RULE_type = 6, RULE_elseStatement = 7, 
		RULE_ifStatement = 8, RULE_forStatement = 9, RULE_block = 10, RULE_assignmentStatement = 11, 
		RULE_modifyStatement = 12, RULE_boolStatement = 13, RULE_returnStatement = 14, 
		RULE_multipleExpression = 15, RULE_operator = 16, RULE_expression = 17, 
		RULE_varName = 18, RULE_func = 19, RULE_funcname = 20, RULE_params = 21, 
		RULE_param = 22, RULE_item = 23, RULE_mparam = 24;
	public static final String[] ruleNames = {
		"validation", "statementList", "statement", "variableDeclaration", "typeName", 
		"listType", "type", "elseStatement", "ifStatement", "forStatement", "block", 
		"assignmentStatement", "modifyStatement", "boolStatement", "returnStatement", 
		"multipleExpression", "operator", "expression", "varName", "func", "funcname", 
		"params", "param", "item", "mparam"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'List'", "'else'", "'if'", "'for '", "':'", "'{'", "'}'", 
		"'return'", "'=='", "'>'", "'<'", "'<='", "'>='", "'!='", "'+'", "'-'", 
		"'+='", "'-='", "'&&'", "'||'", "'.'", "'['", "']'", null, null, null, 
		null, null, null, null, null, null, null, "'('", "')'", "','", "';'", 
		"'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "BOOL", "ID", "NUMBER", "STRING", "INCORDESC", "WS", "CHAR", "COLOR", 
		"HDN", "SYMBOL", "LP", "RP", "COMMA", "SCOLON", "NEG"
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
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			statementList();
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
			if ( listener instanceof validationListener ) ((validationListener)listener).enterStatementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitStatementList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitStatementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementListContext statementList() throws RecognitionException {
		StatementListContext _localctx = new StatementListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statementList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(52);
				statement();
				}
				}
				setState(55); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__3) | (1L << T__4) | (1L << T__6) | (1L << T__8) | (1L << BOOL) | (1L << ID) | (1L << NUMBER) | (1L << STRING) | (1L << NEG))) != 0) );
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
			if ( listener instanceof validationListener ) ((validationListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				ifStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				block();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(60);
				assignmentStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(61);
				forStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(62);
				returnStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(63);
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
		public TerminalNode SCOLON() { return getToken(validationParser.SCOLON, 0); }
		public MultipleExpressionContext multipleExpression() {
			return getRuleContext(MultipleExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			typeName();
			setState(67);
			varName();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(68);
				match(T__0);
				setState(69);
				multipleExpression();
				}
			}

			setState(72);
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
			if ( listener instanceof validationListener ) ((validationListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_typeName);
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				type();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
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
		public TerminalNode LP() { return getToken(validationParser.LP, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RP() { return getToken(validationParser.RP, 0); }
		public ListTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterListType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitListType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitListType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListTypeContext listType() throws RecognitionException {
		ListTypeContext _localctx = new ListTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_listType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__1);
			setState(79);
			match(LP);
			setState(80);
			type();
			setState(81);
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
		public TerminalNode ID() { return getToken(validationParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
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
			if ( listener instanceof validationListener ) ((validationListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__2);
			setState(86);
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
		public TerminalNode LP() { return getToken(validationParser.LP, 0); }
		public BoolStatementContext boolStatement() {
			return getRuleContext(BoolStatementContext.class,0);
		}
		public TerminalNode RP() { return getToken(validationParser.RP, 0); }
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
			if ( listener instanceof validationListener ) ((validationListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__3);
			setState(89);
			match(LP);
			setState(90);
			boolStatement();
			setState(91);
			match(RP);
			setState(92);
			block();
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(93);
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
		public TerminalNode LP() { return getToken(validationParser.LP, 0); }
		public TerminalNode RP() { return getToken(validationParser.RP, 0); }
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
		public TerminalNode INCORDESC() { return getToken(validationParser.INCORDESC, 0); }
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__4);
			setState(97);
			match(LP);
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				{
				setState(98);
				type();
				setState(99);
				varName();
				setState(100);
				match(T__5);
				setState(101);
				varName();
				}
				}
				break;
			case 2:
				{
				{
				setState(103);
				variableDeclaration();
				setState(104);
				boolStatement();
				setState(105);
				varName();
				setState(106);
				match(INCORDESC);
				}
				}
				break;
			}
			setState(110);
			match(RP);
			setState(111);
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
			if ( listener instanceof validationListener ) ((validationListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(T__6);
			setState(114);
			statementList();
			setState(115);
			match(T__7);
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
		public TerminalNode SCOLON() { return getToken(validationParser.SCOLON, 0); }
		public AssignmentStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterAssignmentStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitAssignmentStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitAssignmentStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentStatementContext assignmentStatement() throws RecognitionException {
		AssignmentStatementContext _localctx = new AssignmentStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			varName();
			setState(118);
			match(T__0);
			setState(119);
			multipleExpression();
			setState(120);
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
		public TerminalNode SCOLON() { return getToken(validationParser.SCOLON, 0); }
		public ModifyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterModifyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitModifyStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitModifyStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifyStatementContext modifyStatement() throws RecognitionException {
		ModifyStatementContext _localctx = new ModifyStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_modifyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			multipleExpression();
			setState(123);
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
		public TerminalNode SCOLON() { return getToken(validationParser.SCOLON, 0); }
		public BoolStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterBoolStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitBoolStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitBoolStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolStatementContext boolStatement() throws RecognitionException {
		BoolStatementContext _localctx = new BoolStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_boolStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			multipleExpression();
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SCOLON) {
				{
				setState(126);
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
		public TerminalNode SCOLON() { return getToken(validationParser.SCOLON, 0); }
		public TerminalNode BOOL() { return getToken(validationParser.BOOL, 0); }
		public MultipleExpressionContext multipleExpression() {
			return getRuleContext(MultipleExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(T__8);
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(130);
				match(BOOL);
				}
				break;
			case 2:
				{
				setState(131);
				multipleExpression();
				}
				break;
			}
			setState(134);
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
			if ( listener instanceof validationListener ) ((validationListener)listener).enterMultipleExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitMultipleExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitMultipleExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultipleExpressionContext multipleExpression() throws RecognitionException {
		MultipleExpressionContext _localctx = new MultipleExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_multipleExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			expression();
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) {
				{
				{
				setState(137);
				operator();
				setState(138);
				expression();
				}
				}
				setState(144);
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
			if ( listener instanceof validationListener ) ((validationListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) ) {
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
		public TerminalNode NUMBER() { return getToken(validationParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(validationParser.STRING, 0); }
		public TerminalNode BOOL() { return getToken(validationParser.BOOL, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expression);
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				func();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				varName();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				match(NUMBER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(150);
				match(STRING);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(151);
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
		public TerminalNode ID() { return getToken(validationParser.ID, 0); }
		public VarNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterVarName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitVarName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitVarName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarNameContext varName() throws RecognitionException {
		VarNameContext _localctx = new VarNameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_varName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
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
		public TerminalNode LP() { return getToken(validationParser.LP, 0); }
		public TerminalNode RP() { return getToken(validationParser.RP, 0); }
		public TerminalNode NEG() { return getToken(validationParser.NEG, 0); }
		public TerminalNode ID() { return getToken(validationParser.ID, 0); }
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
		enterRule(_localctx, 38, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEG) {
				{
				setState(156);
				match(NEG);
				}
			}

			setState(161);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(159);
				match(ID);
				setState(160);
				match(T__21);
				}
				break;
			}
			setState(163);
			funcname();
			setState(164);
			match(LP);
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(165);
				params();
				}
			}

			setState(168);
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
		enterRule(_localctx, 40, RULE_funcname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
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
		enterRule(_localctx, 42, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			param();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(173);
				match(COMMA);
				setState(174);
				param();
				}
				}
				setState(179);
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
		public TerminalNode NUMBER() { return getToken(validationParser.NUMBER, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_param);
		try {
			setState(183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(180);
				mparam();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(181);
				item();
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(182);
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
		public TerminalNode NUMBER() { return getToken(validationParser.NUMBER, 0); }
		public TerminalNode CHAR() { return getToken(validationParser.CHAR, 0); }
		public TerminalNode COLOR() { return getToken(validationParser.COLOR, 0); }
		public TerminalNode SYMBOL() { return getToken(validationParser.SYMBOL, 0); }
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
		enterRule(_localctx, 46, RULE_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__22);
			setState(186);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << CHAR) | (1L << COLOR) | (1L << SYMBOL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(187);
			match(T__23);
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
		public TerminalNode ID() { return getToken(validationParser.ID, 0); }
		public MparamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mparam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).enterMparam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof validationListener ) ((validationListener)listener).exitMparam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof validationVisitor ) return ((validationVisitor<? extends T>)visitor).visitMparam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MparamContext mparam() throws RecognitionException {
		MparamContext _localctx = new MparamContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_mparam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00c2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\3\6\38\n\3\r\3\16\39\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\5\4C\n\4\3\5\3\5\3\5\3\5\5\5I\n\5\3\5\3\5\3\6\3\6\5\6O\n\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\5\na\n\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13o\n\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17"+
		"\5\17\u0082\n\17\3\20\3\20\3\20\5\20\u0087\n\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\7\21\u008f\n\21\f\21\16\21\u0092\13\21\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\23\5\23\u009b\n\23\3\24\3\24\3\25\5\25\u00a0\n\25\3\25\3\25"+
		"\5\25\u00a4\n\25\3\25\3\25\3\25\5\25\u00a9\n\25\3\25\3\25\3\26\3\26\3"+
		"\27\3\27\3\27\7\27\u00b2\n\27\f\27\16\27\u00b5\13\27\3\30\3\30\3\30\5"+
		"\30\u00ba\n\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\2\2\33\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\4\3\2\f\27\5\2\35\35!\"$$\2"+
		"\u00c0\2\64\3\2\2\2\4\67\3\2\2\2\6B\3\2\2\2\bD\3\2\2\2\nN\3\2\2\2\fP\3"+
		"\2\2\2\16U\3\2\2\2\20W\3\2\2\2\22Z\3\2\2\2\24b\3\2\2\2\26s\3\2\2\2\30"+
		"w\3\2\2\2\32|\3\2\2\2\34\177\3\2\2\2\36\u0083\3\2\2\2 \u008a\3\2\2\2\""+
		"\u0093\3\2\2\2$\u009a\3\2\2\2&\u009c\3\2\2\2(\u009f\3\2\2\2*\u00ac\3\2"+
		"\2\2,\u00ae\3\2\2\2.\u00b9\3\2\2\2\60\u00bb\3\2\2\2\62\u00bf\3\2\2\2\64"+
		"\65\5\4\3\2\65\3\3\2\2\2\668\5\6\4\2\67\66\3\2\2\289\3\2\2\29\67\3\2\2"+
		"\29:\3\2\2\2:\5\3\2\2\2;C\5\b\5\2<C\5\22\n\2=C\5\26\f\2>C\5\30\r\2?C\5"+
		"\24\13\2@C\5\36\20\2AC\5\32\16\2B;\3\2\2\2B<\3\2\2\2B=\3\2\2\2B>\3\2\2"+
		"\2B?\3\2\2\2B@\3\2\2\2BA\3\2\2\2C\7\3\2\2\2DE\5\n\6\2EH\5&\24\2FG\7\3"+
		"\2\2GI\5 \21\2HF\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JK\7(\2\2K\t\3\2\2\2LO\5\16"+
		"\b\2MO\5\f\7\2NL\3\2\2\2NM\3\2\2\2O\13\3\2\2\2PQ\7\4\2\2QR\7%\2\2RS\5"+
		"\16\b\2ST\7&\2\2T\r\3\2\2\2UV\7\34\2\2V\17\3\2\2\2WX\7\5\2\2XY\5\26\f"+
		"\2Y\21\3\2\2\2Z[\7\6\2\2[\\\7%\2\2\\]\5\34\17\2]^\7&\2\2^`\5\26\f\2_a"+
		"\5\20\t\2`_\3\2\2\2`a\3\2\2\2a\23\3\2\2\2bc\7\7\2\2cn\7%\2\2de\5\16\b"+
		"\2ef\5&\24\2fg\7\b\2\2gh\5&\24\2ho\3\2\2\2ij\5\b\5\2jk\5\34\17\2kl\5&"+
		"\24\2lm\7\37\2\2mo\3\2\2\2nd\3\2\2\2ni\3\2\2\2op\3\2\2\2pq\7&\2\2qr\5"+
		"\26\f\2r\25\3\2\2\2st\7\t\2\2tu\5\4\3\2uv\7\n\2\2v\27\3\2\2\2wx\5&\24"+
		"\2xy\7\3\2\2yz\5 \21\2z{\7(\2\2{\31\3\2\2\2|}\5 \21\2}~\7(\2\2~\33\3\2"+
		"\2\2\177\u0081\5 \21\2\u0080\u0082\7(\2\2\u0081\u0080\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\35\3\2\2\2\u0083\u0086\7\13\2\2\u0084\u0087\7\33\2\2\u0085"+
		"\u0087\5 \21\2\u0086\u0084\3\2\2\2\u0086\u0085\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\u0089\7(\2\2\u0089\37\3\2\2\2\u008a\u0090\5$\23\2\u008b\u008c"+
		"\5\"\22\2\u008c\u008d\5$\23\2\u008d\u008f\3\2\2\2\u008e\u008b\3\2\2\2"+
		"\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091!\3"+
		"\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\t\2\2\2\u0094#\3\2\2\2\u0095\u009b"+
		"\5(\25\2\u0096\u009b\5&\24\2\u0097\u009b\7\35\2\2\u0098\u009b\7\36\2\2"+
		"\u0099\u009b\7\33\2\2\u009a\u0095\3\2\2\2\u009a\u0096\3\2\2\2\u009a\u0097"+
		"\3\2\2\2\u009a\u0098\3\2\2\2\u009a\u0099\3\2\2\2\u009b%\3\2\2\2\u009c"+
		"\u009d\7\34\2\2\u009d\'\3\2\2\2\u009e\u00a0\7)\2\2\u009f\u009e\3\2\2\2"+
		"\u009f\u00a0\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u00a2\7\34\2\2\u00a2\u00a4"+
		"\7\30\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2"+
		"\u00a5\u00a6\5*\26\2\u00a6\u00a8\7%\2\2\u00a7\u00a9\5,\27\2\u00a8\u00a7"+
		"\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\7&\2\2\u00ab"+
		")\3\2\2\2\u00ac\u00ad\7\34\2\2\u00ad+\3\2\2\2\u00ae\u00b3\5.\30\2\u00af"+
		"\u00b0\7\'\2\2\u00b0\u00b2\5.\30\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3\2"+
		"\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4-\3\2\2\2\u00b5\u00b3"+
		"\3\2\2\2\u00b6\u00ba\5\62\32\2\u00b7\u00ba\5\60\31\2\u00b8\u00ba\7\35"+
		"\2\2\u00b9\u00b6\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba"+
		"/\3\2\2\2\u00bb\u00bc\7\31\2\2\u00bc\u00bd\t\3\2\2\u00bd\u00be\7\32\2"+
		"\2\u00be\61\3\2\2\2\u00bf\u00c0\7\34\2\2\u00c0\63\3\2\2\2\219BHN`n\u0081"+
		"\u0086\u0090\u009a\u009f\u00a3\u00a8\u00b3\u00b9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}