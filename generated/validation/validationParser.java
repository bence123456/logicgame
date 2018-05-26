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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, ID=24, NUMBER=25, 
		STRING=26, BOOL=27, INCORDESC=28, WS=29, CHAR=30, COLOR=31, HDN=32, SYMBOL=33, 
		LP=34, RP=35, COMMA=36, SCOLON=37, NEG=38;
	public static final int
		RULE_validation = 0, RULE_statementList = 1, RULE_statement = 2, RULE_variableDeclaration = 3, 
		RULE_typeName = 4, RULE_listType = 5, RULE_type = 6, RULE_ifStatement = 7, 
		RULE_forStatement = 8, RULE_block = 9, RULE_assignmentStatement = 10, 
		RULE_modifyStatement = 11, RULE_boolStatement = 12, RULE_returnStatement = 13, 
		RULE_multipleExpression = 14, RULE_operator = 15, RULE_expression = 16, 
		RULE_varName = 17, RULE_func = 18, RULE_funcname = 19, RULE_params = 20, 
		RULE_param = 21, RULE_item = 22, RULE_mparam = 23;
	public static final String[] ruleNames = {
		"validation", "statementList", "statement", "variableDeclaration", "typeName", 
		"listType", "type", "ifStatement", "forStatement", "block", "assignmentStatement", 
		"modifyStatement", "boolStatement", "returnStatement", "multipleExpression", 
		"operator", "expression", "varName", "func", "funcname", "params", "param", 
		"item", "mparam"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'List'", "'if'", "'for '", "':'", "'{'", "'}'", "'return'", 
		"'=='", "'>'", "'<'", "'<='", "'>='", "'!='", "'+'", "'-'", "'+='", "'-='", 
		"'&&'", "'||'", "'.'", "'['", "']'", null, null, null, null, null, null, 
		null, null, null, null, "'('", "')'", "','", "';'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"ID", "NUMBER", "STRING", "BOOL", "INCORDESC", "WS", "CHAR", "COLOR", 
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
			setState(48);
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
			setState(51); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(50);
				statement();
				}
				}
				setState(53); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__5) | (1L << T__7) | (1L << ID) | (1L << NUMBER) | (1L << STRING) | (1L << BOOL) | (1L << NEG))) != 0) );
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
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				ifStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
				block();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(58);
				assignmentStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(59);
				forStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(60);
				returnStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(61);
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
			setState(64);
			typeName();
			setState(65);
			varName();
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(66);
				match(T__0);
				setState(67);
				multipleExpression();
				}
			}

			setState(70);
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
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				type();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
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
			setState(76);
			match(T__1);
			setState(77);
			match(LP);
			setState(78);
			type();
			setState(79);
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
			setState(81);
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

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(validationParser.LP, 0); }
		public BoolStatementContext boolStatement() {
			return getRuleContext(BoolStatementContext.class,0);
		}
		public TerminalNode RP() { return getToken(validationParser.RP, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 14, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__2);
			setState(84);
			match(LP);
			setState(85);
			boolStatement();
			setState(86);
			match(RP);
			setState(87);
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
		enterRule(_localctx, 16, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__3);
			setState(90);
			match(LP);
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				{
				setState(91);
				type();
				setState(92);
				varName();
				setState(93);
				match(T__4);
				setState(94);
				varName();
				}
				}
				break;
			case 2:
				{
				{
				setState(96);
				variableDeclaration();
				setState(97);
				boolStatement();
				setState(98);
				varName();
				setState(99);
				match(INCORDESC);
				}
				}
				break;
			}
			setState(103);
			match(RP);
			setState(104);
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
		enterRule(_localctx, 18, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__5);
			setState(107);
			statementList();
			setState(108);
			match(T__6);
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
		enterRule(_localctx, 20, RULE_assignmentStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			varName();
			setState(111);
			match(T__0);
			setState(112);
			multipleExpression();
			setState(113);
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
		enterRule(_localctx, 22, RULE_modifyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			multipleExpression();
			setState(116);
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
		enterRule(_localctx, 24, RULE_boolStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			multipleExpression();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SCOLON) {
				{
				setState(119);
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
		enterRule(_localctx, 26, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(T__7);
			setState(125);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(123);
				match(BOOL);
				}
				break;
			case 2:
				{
				setState(124);
				multipleExpression();
				}
				break;
			}
			setState(127);
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
		enterRule(_localctx, 28, RULE_multipleExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			expression();
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) {
				{
				{
				setState(130);
				operator();
				setState(131);
				expression();
				}
				}
				setState(137);
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
		enterRule(_localctx, 30, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
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
		enterRule(_localctx, 32, RULE_expression);
		try {
			setState(145);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				func();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				varName();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				match(NUMBER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				match(STRING);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(144);
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
		enterRule(_localctx, 34, RULE_varName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
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
		enterRule(_localctx, 36, RULE_func);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEG) {
				{
				setState(149);
				match(NEG);
				}
			}

			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(152);
				match(ID);
				setState(153);
				match(T__20);
				}
				break;
			}
			setState(156);
			funcname();
			setState(157);
			match(LP);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << ID) | (1L << NUMBER))) != 0)) {
				{
				setState(158);
				params();
				}
			}

			setState(161);
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
		enterRule(_localctx, 38, RULE_funcname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
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
		enterRule(_localctx, 40, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			param();
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(166);
				match(COMMA);
				setState(167);
				param();
				}
				}
				setState(172);
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
		enterRule(_localctx, 42, RULE_param);
		try {
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				mparam();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				item();
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(175);
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
		enterRule(_localctx, 44, RULE_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(T__21);
			setState(179);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUMBER) | (1L << CHAR) | (1L << COLOR) | (1L << SYMBOL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(180);
			match(T__22);
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
		enterRule(_localctx, 46, RULE_mparam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u00bb\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\3\6\3\66\n\3\r\3\16\3\67\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4A\n"+
		"\4\3\5\3\5\3\5\3\5\5\5G\n\5\3\5\3\5\3\6\3\6\5\6M\n\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\nh\n\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\16\3\16\5\16{\n\16\3\17\3\17\3\17\5\17\u0080\n\17\3"+
		"\17\3\17\3\20\3\20\3\20\3\20\7\20\u0088\n\20\f\20\16\20\u008b\13\20\3"+
		"\21\3\21\3\22\3\22\3\22\3\22\3\22\5\22\u0094\n\22\3\23\3\23\3\24\5\24"+
		"\u0099\n\24\3\24\3\24\5\24\u009d\n\24\3\24\3\24\3\24\5\24\u00a2\n\24\3"+
		"\24\3\24\3\25\3\25\3\26\3\26\3\26\7\26\u00ab\n\26\f\26\16\26\u00ae\13"+
		"\26\3\27\3\27\3\27\5\27\u00b3\n\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\2\2\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\4\3\2\13"+
		"\26\5\2\33\33 !##\2\u00b9\2\62\3\2\2\2\4\65\3\2\2\2\6@\3\2\2\2\bB\3\2"+
		"\2\2\nL\3\2\2\2\fN\3\2\2\2\16S\3\2\2\2\20U\3\2\2\2\22[\3\2\2\2\24l\3\2"+
		"\2\2\26p\3\2\2\2\30u\3\2\2\2\32x\3\2\2\2\34|\3\2\2\2\36\u0083\3\2\2\2"+
		" \u008c\3\2\2\2\"\u0093\3\2\2\2$\u0095\3\2\2\2&\u0098\3\2\2\2(\u00a5\3"+
		"\2\2\2*\u00a7\3\2\2\2,\u00b2\3\2\2\2.\u00b4\3\2\2\2\60\u00b8\3\2\2\2\62"+
		"\63\5\4\3\2\63\3\3\2\2\2\64\66\5\6\4\2\65\64\3\2\2\2\66\67\3\2\2\2\67"+
		"\65\3\2\2\2\678\3\2\2\28\5\3\2\2\29A\5\b\5\2:A\5\20\t\2;A\5\24\13\2<A"+
		"\5\26\f\2=A\5\22\n\2>A\5\34\17\2?A\5\30\r\2@9\3\2\2\2@:\3\2\2\2@;\3\2"+
		"\2\2@<\3\2\2\2@=\3\2\2\2@>\3\2\2\2@?\3\2\2\2A\7\3\2\2\2BC\5\n\6\2CF\5"+
		"$\23\2DE\7\3\2\2EG\5\36\20\2FD\3\2\2\2FG\3\2\2\2GH\3\2\2\2HI\7\'\2\2I"+
		"\t\3\2\2\2JM\5\16\b\2KM\5\f\7\2LJ\3\2\2\2LK\3\2\2\2M\13\3\2\2\2NO\7\4"+
		"\2\2OP\7$\2\2PQ\5\16\b\2QR\7%\2\2R\r\3\2\2\2ST\7\32\2\2T\17\3\2\2\2UV"+
		"\7\5\2\2VW\7$\2\2WX\5\32\16\2XY\7%\2\2YZ\5\24\13\2Z\21\3\2\2\2[\\\7\6"+
		"\2\2\\g\7$\2\2]^\5\16\b\2^_\5$\23\2_`\7\7\2\2`a\5$\23\2ah\3\2\2\2bc\5"+
		"\b\5\2cd\5\32\16\2de\5$\23\2ef\7\36\2\2fh\3\2\2\2g]\3\2\2\2gb\3\2\2\2"+
		"hi\3\2\2\2ij\7%\2\2jk\5\24\13\2k\23\3\2\2\2lm\7\b\2\2mn\5\4\3\2no\7\t"+
		"\2\2o\25\3\2\2\2pq\5$\23\2qr\7\3\2\2rs\5\36\20\2st\7\'\2\2t\27\3\2\2\2"+
		"uv\5\36\20\2vw\7\'\2\2w\31\3\2\2\2xz\5\36\20\2y{\7\'\2\2zy\3\2\2\2z{\3"+
		"\2\2\2{\33\3\2\2\2|\177\7\n\2\2}\u0080\7\35\2\2~\u0080\5\36\20\2\177}"+
		"\3\2\2\2\177~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\7\'\2\2\u0082\35"+
		"\3\2\2\2\u0083\u0089\5\"\22\2\u0084\u0085\5 \21\2\u0085\u0086\5\"\22\2"+
		"\u0086\u0088\3\2\2\2\u0087\u0084\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087"+
		"\3\2\2\2\u0089\u008a\3\2\2\2\u008a\37\3\2\2\2\u008b\u0089\3\2\2\2\u008c"+
		"\u008d\t\2\2\2\u008d!\3\2\2\2\u008e\u0094\5&\24\2\u008f\u0094\5$\23\2"+
		"\u0090\u0094\7\33\2\2\u0091\u0094\7\34\2\2\u0092\u0094\7\35\2\2\u0093"+
		"\u008e\3\2\2\2\u0093\u008f\3\2\2\2\u0093\u0090\3\2\2\2\u0093\u0091\3\2"+
		"\2\2\u0093\u0092\3\2\2\2\u0094#\3\2\2\2\u0095\u0096\7\32\2\2\u0096%\3"+
		"\2\2\2\u0097\u0099\7(\2\2\u0098\u0097\3\2\2\2\u0098\u0099\3\2\2\2\u0099"+
		"\u009c\3\2\2\2\u009a\u009b\7\32\2\2\u009b\u009d\7\27\2\2\u009c\u009a\3"+
		"\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\5(\25\2\u009f"+
		"\u00a1\7$\2\2\u00a0\u00a2\5*\26\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2"+
		"\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\7%\2\2\u00a4\'\3\2\2\2\u00a5\u00a6"+
		"\7\32\2\2\u00a6)\3\2\2\2\u00a7\u00ac\5,\27\2\u00a8\u00a9\7&\2\2\u00a9"+
		"\u00ab\5,\27\2\u00aa\u00a8\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad+\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b3"+
		"\5\60\31\2\u00b0\u00b3\5.\30\2\u00b1\u00b3\7\33\2\2\u00b2\u00af\3\2\2"+
		"\2\u00b2\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3-\3\2\2\2\u00b4\u00b5"+
		"\7\30\2\2\u00b5\u00b6\t\3\2\2\u00b6\u00b7\7\31\2\2\u00b7/\3\2\2\2\u00b8"+
		"\u00b9\7\32\2\2\u00b9\61\3\2\2\2\20\67@FLgz\177\u0089\u0093\u0098\u009c"+
		"\u00a1\u00ac\u00b2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}