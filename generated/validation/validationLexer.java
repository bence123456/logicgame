// Generated from C:/BME_MSC/2_felev/onlab2/logicgame/src/main/com.bkonecsni.logicgame.antlr4/validation\validation.g4 by ANTLR 4.7
package validation;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class validationLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, ID=26, NUMBER=27, STRING=28, BOOL=29, NULL=30, WS=31, CHAR=32, 
		COLOR=33, HDN=34, SYMBOL=35, LP=36, RP=37, COMMA=38, SCOLON=39, NEG=40;
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
		"ID", "NUMBER", "STRING", "BOOL", "NULL", "WS", "CHAR", "COLOR", "HDN", 
		"SYMBOL", "LP", "RP", "COMMA", "SCOLON", "NEG"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'List'", "'if'", "'for '", "':'", "'++'", "'--'", "'{'", 
		"'}'", "'return'", "'=='", "'>'", "'<'", "'<='", "'>='", "'!='", "'+'", 
		"'-'", "'+='", "'-='", "'&&'", "'||'", "'.'", "'['", "']'", null, null, 
		null, null, "'null'", null, null, null, null, null, "'('", "')'", "','", 
		"';'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "ID", "NUMBER", "STRING", "BOOL", "NULL", "WS", "CHAR", "COLOR", 
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


	public validationLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "validation.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u00ec\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22"+
		"\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\7\33\u009e\n\33\f\33\16"+
		"\33\u00a1\13\33\3\34\3\34\3\34\7\34\u00a6\n\34\f\34\16\34\u00a9\13\34"+
		"\5\34\u00ab\n\34\3\35\3\35\7\35\u00af\n\35\f\35\16\35\u00b2\13\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u00bf\n\36\3\37"+
		"\3\37\3\37\3\37\3\37\3 \6 \u00c7\n \r \16 \u00c8\3 \3 \3!\3!\3\"\3\"\3"+
		"\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u00db\n\"\3#\5#\u00de\n#\3"+
		"$\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\2\2*\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*\3"+
		"\2\t\4\2C\\c|\3\2\62;\3\2\63;\5\2\f\f\17\17$$\5\2\13\f\17\17\"\"\3\2C"+
		"\\\5\2\62;CHch\2\u00f2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\3S\3\2\2\2\5U\3\2\2\2\7Z\3\2\2\2\t]\3\2\2\2\13b\3\2\2\2\rd\3"+
		"\2\2\2\17g\3\2\2\2\21j\3\2\2\2\23l\3\2\2\2\25n\3\2\2\2\27u\3\2\2\2\31"+
		"x\3\2\2\2\33z\3\2\2\2\35|\3\2\2\2\37\177\3\2\2\2!\u0082\3\2\2\2#\u0085"+
		"\3\2\2\2%\u0087\3\2\2\2\'\u0089\3\2\2\2)\u008c\3\2\2\2+\u008f\3\2\2\2"+
		"-\u0092\3\2\2\2/\u0095\3\2\2\2\61\u0097\3\2\2\2\63\u0099\3\2\2\2\65\u009b"+
		"\3\2\2\2\67\u00aa\3\2\2\29\u00ac\3\2\2\2;\u00be\3\2\2\2=\u00c0\3\2\2\2"+
		"?\u00c6\3\2\2\2A\u00cc\3\2\2\2C\u00ce\3\2\2\2E\u00dd\3\2\2\2G\u00df\3"+
		"\2\2\2I\u00e2\3\2\2\2K\u00e4\3\2\2\2M\u00e6\3\2\2\2O\u00e8\3\2\2\2Q\u00ea"+
		"\3\2\2\2ST\7?\2\2T\4\3\2\2\2UV\7N\2\2VW\7k\2\2WX\7u\2\2XY\7v\2\2Y\6\3"+
		"\2\2\2Z[\7k\2\2[\\\7h\2\2\\\b\3\2\2\2]^\7h\2\2^_\7q\2\2_`\7t\2\2`a\7\""+
		"\2\2a\n\3\2\2\2bc\7<\2\2c\f\3\2\2\2de\7-\2\2ef\7-\2\2f\16\3\2\2\2gh\7"+
		"/\2\2hi\7/\2\2i\20\3\2\2\2jk\7}\2\2k\22\3\2\2\2lm\7\177\2\2m\24\3\2\2"+
		"\2no\7t\2\2op\7g\2\2pq\7v\2\2qr\7w\2\2rs\7t\2\2st\7p\2\2t\26\3\2\2\2u"+
		"v\7?\2\2vw\7?\2\2w\30\3\2\2\2xy\7@\2\2y\32\3\2\2\2z{\7>\2\2{\34\3\2\2"+
		"\2|}\7>\2\2}~\7?\2\2~\36\3\2\2\2\177\u0080\7@\2\2\u0080\u0081\7?\2\2\u0081"+
		" \3\2\2\2\u0082\u0083\7#\2\2\u0083\u0084\7?\2\2\u0084\"\3\2\2\2\u0085"+
		"\u0086\7-\2\2\u0086$\3\2\2\2\u0087\u0088\7/\2\2\u0088&\3\2\2\2\u0089\u008a"+
		"\7-\2\2\u008a\u008b\7?\2\2\u008b(\3\2\2\2\u008c\u008d\7/\2\2\u008d\u008e"+
		"\7?\2\2\u008e*\3\2\2\2\u008f\u0090\7(\2\2\u0090\u0091\7(\2\2\u0091,\3"+
		"\2\2\2\u0092\u0093\7~\2\2\u0093\u0094\7~\2\2\u0094.\3\2\2\2\u0095\u0096"+
		"\7\60\2\2\u0096\60\3\2\2\2\u0097\u0098\7]\2\2\u0098\62\3\2\2\2\u0099\u009a"+
		"\7_\2\2\u009a\64\3\2\2\2\u009b\u009f\t\2\2\2\u009c\u009e\t\2\2\2\u009d"+
		"\u009c\3\2\2\2\u009e\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\66\3\2\2\2\u00a1\u009f\3\2\2\2\u00a2\u00ab\t\3\2\2\u00a3\u00a7"+
		"\t\4\2\2\u00a4\u00a6\t\3\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2"+
		"\2\2\u00aa\u00a2\3\2\2\2\u00aa\u00a3\3\2\2\2\u00ab8\3\2\2\2\u00ac\u00b0"+
		"\7$\2\2\u00ad\u00af\n\5\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0"+
		"\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b0\3\2"+
		"\2\2\u00b3\u00b4\7$\2\2\u00b4:\3\2\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7"+
		"\7t\2\2\u00b7\u00b8\7w\2\2\u00b8\u00bf\7g\2\2\u00b9\u00ba\7h\2\2\u00ba"+
		"\u00bb\7c\2\2\u00bb\u00bc\7n\2\2\u00bc\u00bd\7u\2\2\u00bd\u00bf\7g\2\2"+
		"\u00be\u00b5\3\2\2\2\u00be\u00b9\3\2\2\2\u00bf<\3\2\2\2\u00c0\u00c1\7"+
		"p\2\2\u00c1\u00c2\7w\2\2\u00c2\u00c3\7n\2\2\u00c3\u00c4\7n\2\2\u00c4>"+
		"\3\2\2\2\u00c5\u00c7\t\6\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8"+
		"\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\b "+
		"\2\2\u00cb@\3\2\2\2\u00cc\u00cd\t\7\2\2\u00cdB\3\2\2\2\u00ce\u00da\7%"+
		"\2\2\u00cf\u00d0\5E#\2\u00d0\u00d1\5E#\2\u00d1\u00d2\5E#\2\u00d2\u00d3"+
		"\5E#\2\u00d3\u00d4\5E#\2\u00d4\u00d5\5E#\2\u00d5\u00db\3\2\2\2\u00d6\u00d7"+
		"\5E#\2\u00d7\u00d8\5E#\2\u00d8\u00d9\5E#\2\u00d9\u00db\3\2\2\2\u00da\u00cf"+
		"\3\2\2\2\u00da\u00d6\3\2\2\2\u00dbD\3\2\2\2\u00dc\u00de\t\b\2\2\u00dd"+
		"\u00dc\3\2\2\2\u00deF\3\2\2\2\u00df\u00e0\7U\2\2\u00e0\u00e1\5\67\34\2"+
		"\u00e1H\3\2\2\2\u00e2\u00e3\7*\2\2\u00e3J\3\2\2\2\u00e4\u00e5\7+\2\2\u00e5"+
		"L\3\2\2\2\u00e6\u00e7\7.\2\2\u00e7N\3\2\2\2\u00e8\u00e9\7=\2\2\u00e9P"+
		"\3\2\2\2\u00ea\u00eb\7#\2\2\u00ebR\3\2\2\2\13\2\u009f\u00a7\u00aa\u00b0"+
		"\u00be\u00c8\u00da\u00dd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}