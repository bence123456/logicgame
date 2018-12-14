// Generated from C:/Users/Ben/IdeaProjects/logicgame/src/main/com.bkonecsni.logicgame.antlr4\statementList.g4 by ANTLR 4.7
package statementlist;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class statementListLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, BOOL=28, ID=29, NUMBER=30, STRING=31, INCORDESC=32, 
		WS=33, CHAR=34, COLOR=35, HDN=36, SYMBOL=37, LP=38, RP=39, COMMA=40, SCOLON=41, 
		NEG=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "BOOL", "ID", "NUMBER", "STRING", "INCORDESC", "WS", 
		"CHAR", "COLOR", "HDN", "SYMBOL", "LP", "RP", "COMMA", "SCOLON", "NEG"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'List'", "'else'", "'if'", "'for '", "':'", "'{'", "'}'", 
		"'return'", "'=='", "'>'", "'<'", "'<='", "'>='", "'!='", "'+'", "'-'", 
		"'+='", "'-='", "'&&'", "'||'", "'/'", "'*'", "'.'", "'['", "']'", "'break'", 
		null, null, null, null, null, null, null, null, null, null, "'('", "')'", 
		"','", "';'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "BOOL", "ID", "NUMBER", "STRING", "INCORDESC", 
		"WS", "CHAR", "COLOR", "HDN", "SYMBOL", "LP", "RP", "COMMA", "SCOLON", 
		"NEG"
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


	public statementListLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "statementList.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u00fb\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u00b2"+
		"\n\35\3\36\3\36\7\36\u00b6\n\36\f\36\16\36\u00b9\13\36\3\37\3\37\3\37"+
		"\7\37\u00be\n\37\f\37\16\37\u00c1\13\37\5\37\u00c3\n\37\3 \3 \7 \u00c7"+
		"\n \f \16 \u00ca\13 \3 \3 \3!\3!\3!\3!\5!\u00d2\n!\3\"\6\"\u00d5\n\"\r"+
		"\"\16\"\u00d6\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\5$"+
		"\u00ea\n$\3%\5%\u00ed\n%\3&\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\2\2"+
		",\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&K\'M(O)Q*S+U,\3\2\t\4\2C\\c|\3\2\62;\3\2\63;\5\2\f\f\17"+
		"\17$$\5\2\13\f\17\17\"\"\3\2C\\\5\2\62;CHch\2\u0102\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3"+
		"\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\3W\3\2\2"+
		"\2\5Y\3\2\2\2\7^\3\2\2\2\tc\3\2\2\2\13f\3\2\2\2\rk\3\2\2\2\17m\3\2\2\2"+
		"\21o\3\2\2\2\23q\3\2\2\2\25x\3\2\2\2\27{\3\2\2\2\31}\3\2\2\2\33\177\3"+
		"\2\2\2\35\u0082\3\2\2\2\37\u0085\3\2\2\2!\u0088\3\2\2\2#\u008a\3\2\2\2"+
		"%\u008c\3\2\2\2\'\u008f\3\2\2\2)\u0092\3\2\2\2+\u0095\3\2\2\2-\u0098\3"+
		"\2\2\2/\u009a\3\2\2\2\61\u009c\3\2\2\2\63\u009e\3\2\2\2\65\u00a0\3\2\2"+
		"\2\67\u00a2\3\2\2\29\u00b1\3\2\2\2;\u00b3\3\2\2\2=\u00c2\3\2\2\2?\u00c4"+
		"\3\2\2\2A\u00d1\3\2\2\2C\u00d4\3\2\2\2E\u00da\3\2\2\2G\u00dd\3\2\2\2I"+
		"\u00ec\3\2\2\2K\u00ee\3\2\2\2M\u00f1\3\2\2\2O\u00f3\3\2\2\2Q\u00f5\3\2"+
		"\2\2S\u00f7\3\2\2\2U\u00f9\3\2\2\2WX\7?\2\2X\4\3\2\2\2YZ\7N\2\2Z[\7k\2"+
		"\2[\\\7u\2\2\\]\7v\2\2]\6\3\2\2\2^_\7g\2\2_`\7n\2\2`a\7u\2\2ab\7g\2\2"+
		"b\b\3\2\2\2cd\7k\2\2de\7h\2\2e\n\3\2\2\2fg\7h\2\2gh\7q\2\2hi\7t\2\2ij"+
		"\7\"\2\2j\f\3\2\2\2kl\7<\2\2l\16\3\2\2\2mn\7}\2\2n\20\3\2\2\2op\7\177"+
		"\2\2p\22\3\2\2\2qr\7t\2\2rs\7g\2\2st\7v\2\2tu\7w\2\2uv\7t\2\2vw\7p\2\2"+
		"w\24\3\2\2\2xy\7?\2\2yz\7?\2\2z\26\3\2\2\2{|\7@\2\2|\30\3\2\2\2}~\7>\2"+
		"\2~\32\3\2\2\2\177\u0080\7>\2\2\u0080\u0081\7?\2\2\u0081\34\3\2\2\2\u0082"+
		"\u0083\7@\2\2\u0083\u0084\7?\2\2\u0084\36\3\2\2\2\u0085\u0086\7#\2\2\u0086"+
		"\u0087\7?\2\2\u0087 \3\2\2\2\u0088\u0089\7-\2\2\u0089\"\3\2\2\2\u008a"+
		"\u008b\7/\2\2\u008b$\3\2\2\2\u008c\u008d\7-\2\2\u008d\u008e\7?\2\2\u008e"+
		"&\3\2\2\2\u008f\u0090\7/\2\2\u0090\u0091\7?\2\2\u0091(\3\2\2\2\u0092\u0093"+
		"\7(\2\2\u0093\u0094\7(\2\2\u0094*\3\2\2\2\u0095\u0096\7~\2\2\u0096\u0097"+
		"\7~\2\2\u0097,\3\2\2\2\u0098\u0099\7\61\2\2\u0099.\3\2\2\2\u009a\u009b"+
		"\7,\2\2\u009b\60\3\2\2\2\u009c\u009d\7\60\2\2\u009d\62\3\2\2\2\u009e\u009f"+
		"\7]\2\2\u009f\64\3\2\2\2\u00a0\u00a1\7_\2\2\u00a1\66\3\2\2\2\u00a2\u00a3"+
		"\7d\2\2\u00a3\u00a4\7t\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7c\2\2\u00a6"+
		"\u00a7\7m\2\2\u00a78\3\2\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa\7t\2\2\u00aa"+
		"\u00ab\7w\2\2\u00ab\u00b2\7g\2\2\u00ac\u00ad\7h\2\2\u00ad\u00ae\7c\2\2"+
		"\u00ae\u00af\7n\2\2\u00af\u00b0\7u\2\2\u00b0\u00b2\7g\2\2\u00b1\u00a8"+
		"\3\2\2\2\u00b1\u00ac\3\2\2\2\u00b2:\3\2\2\2\u00b3\u00b7\t\2\2\2\u00b4"+
		"\u00b6\t\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2"+
		"\2\2\u00b7\u00b8\3\2\2\2\u00b8<\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00c3"+
		"\t\3\2\2\u00bb\u00bf\t\4\2\2\u00bc\u00be\t\3\2\2\u00bd\u00bc\3\2\2\2\u00be"+
		"\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c3\3\2"+
		"\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00ba\3\2\2\2\u00c2\u00bb\3\2\2\2\u00c3"+
		">\3\2\2\2\u00c4\u00c8\7$\2\2\u00c5\u00c7\n\5\2\2\u00c6\u00c5\3\2\2\2\u00c7"+
		"\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00cb\3\2"+
		"\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\7$\2\2\u00cc@\3\2\2\2\u00cd\u00ce"+
		"\7-\2\2\u00ce\u00d2\7-\2\2\u00cf\u00d0\7/\2\2\u00d0\u00d2\7/\2\2\u00d1"+
		"\u00cd\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2B\3\2\2\2\u00d3\u00d5\t\6\2\2"+
		"\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7"+
		"\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\b\"\2\2\u00d9D\3\2\2\2\u00da"+
		"\u00db\7(\2\2\u00db\u00dc\t\7\2\2\u00dcF\3\2\2\2\u00dd\u00e9\7%\2\2\u00de"+
		"\u00df\5I%\2\u00df\u00e0\5I%\2\u00e0\u00e1\5I%\2\u00e1\u00e2\5I%\2\u00e2"+
		"\u00e3\5I%\2\u00e3\u00e4\5I%\2\u00e4\u00ea\3\2\2\2\u00e5\u00e6\5I%\2\u00e6"+
		"\u00e7\5I%\2\u00e7\u00e8\5I%\2\u00e8\u00ea\3\2\2\2\u00e9\u00de\3\2\2\2"+
		"\u00e9\u00e5\3\2\2\2\u00eaH\3\2\2\2\u00eb\u00ed\t\b\2\2\u00ec\u00eb\3"+
		"\2\2\2\u00edJ\3\2\2\2\u00ee\u00ef\7U\2\2\u00ef\u00f0\5=\37\2\u00f0L\3"+
		"\2\2\2\u00f1\u00f2\7*\2\2\u00f2N\3\2\2\2\u00f3\u00f4\7+\2\2\u00f4P\3\2"+
		"\2\2\u00f5\u00f6\7.\2\2\u00f6R\3\2\2\2\u00f7\u00f8\7=\2\2\u00f8T\3\2\2"+
		"\2\u00f9\u00fa\7#\2\2\u00faV\3\2\2\2\f\2\u00b1\u00b7\u00bf\u00c2\u00c8"+
		"\u00d1\u00d6\u00e9\u00ec\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}