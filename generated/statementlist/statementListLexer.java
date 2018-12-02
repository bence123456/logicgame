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
		T__24=25, T__25=26, BOOL=27, ID=28, NUMBER=29, STRING=30, INCORDESC=31, 
		WS=32, CHAR=33, COLOR=34, HDN=35, SYMBOL=36, LP=37, RP=38, COMMA=39, SCOLON=40, 
		NEG=41;
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
		"T__25", "BOOL", "ID", "NUMBER", "STRING", "INCORDESC", "WS", "CHAR", 
		"COLOR", "HDN", "SYMBOL", "LP", "RP", "COMMA", "SCOLON", "NEG"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'List'", "'else'", "'if'", "'for '", "':'", "'{'", "'}'", 
		"'return'", "'=='", "'>'", "'<'", "'<='", "'>='", "'!='", "'+'", "'-'", 
		"'+='", "'-='", "'&&'", "'||'", "'/'", "'.'", "'['", "']'", "'break'", 
		null, null, null, null, null, null, null, null, null, null, "'('", "')'", 
		"','", "';'", "'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "BOOL", "ID", "NUMBER", "STRING", "INCORDESC", "WS", 
		"CHAR", "COLOR", "HDN", "SYMBOL", "LP", "RP", "COMMA", "SCOLON", "NEG"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2+\u00f7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00ae\n\34\3\35\3\35"+
		"\7\35\u00b2\n\35\f\35\16\35\u00b5\13\35\3\36\3\36\3\36\7\36\u00ba\n\36"+
		"\f\36\16\36\u00bd\13\36\5\36\u00bf\n\36\3\37\3\37\7\37\u00c3\n\37\f\37"+
		"\16\37\u00c6\13\37\3\37\3\37\3 \3 \3 \3 \5 \u00ce\n \3!\6!\u00d1\n!\r"+
		"!\16!\u00d2\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u00e6"+
		"\n#\3$\5$\u00e9\n$\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\2\2+\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+\3\2\t\4\2C\\c|\3\2\62;\3\2\63;\5\2\f\f\17\17$$"+
		"\5\2\13\f\17\17\"\"\3\2CG\5\2\62;CHch\2\u00fe\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2"+
		"\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\3U\3\2\2\2\5W\3\2\2\2\7\\"+
		"\3\2\2\2\ta\3\2\2\2\13d\3\2\2\2\ri\3\2\2\2\17k\3\2\2\2\21m\3\2\2\2\23"+
		"o\3\2\2\2\25v\3\2\2\2\27y\3\2\2\2\31{\3\2\2\2\33}\3\2\2\2\35\u0080\3\2"+
		"\2\2\37\u0083\3\2\2\2!\u0086\3\2\2\2#\u0088\3\2\2\2%\u008a\3\2\2\2\'\u008d"+
		"\3\2\2\2)\u0090\3\2\2\2+\u0093\3\2\2\2-\u0096\3\2\2\2/\u0098\3\2\2\2\61"+
		"\u009a\3\2\2\2\63\u009c\3\2\2\2\65\u009e\3\2\2\2\67\u00ad\3\2\2\29\u00af"+
		"\3\2\2\2;\u00be\3\2\2\2=\u00c0\3\2\2\2?\u00cd\3\2\2\2A\u00d0\3\2\2\2C"+
		"\u00d6\3\2\2\2E\u00d9\3\2\2\2G\u00e8\3\2\2\2I\u00ea\3\2\2\2K\u00ed\3\2"+
		"\2\2M\u00ef\3\2\2\2O\u00f1\3\2\2\2Q\u00f3\3\2\2\2S\u00f5\3\2\2\2UV\7?"+
		"\2\2V\4\3\2\2\2WX\7N\2\2XY\7k\2\2YZ\7u\2\2Z[\7v\2\2[\6\3\2\2\2\\]\7g\2"+
		"\2]^\7n\2\2^_\7u\2\2_`\7g\2\2`\b\3\2\2\2ab\7k\2\2bc\7h\2\2c\n\3\2\2\2"+
		"de\7h\2\2ef\7q\2\2fg\7t\2\2gh\7\"\2\2h\f\3\2\2\2ij\7<\2\2j\16\3\2\2\2"+
		"kl\7}\2\2l\20\3\2\2\2mn\7\177\2\2n\22\3\2\2\2op\7t\2\2pq\7g\2\2qr\7v\2"+
		"\2rs\7w\2\2st\7t\2\2tu\7p\2\2u\24\3\2\2\2vw\7?\2\2wx\7?\2\2x\26\3\2\2"+
		"\2yz\7@\2\2z\30\3\2\2\2{|\7>\2\2|\32\3\2\2\2}~\7>\2\2~\177\7?\2\2\177"+
		"\34\3\2\2\2\u0080\u0081\7@\2\2\u0081\u0082\7?\2\2\u0082\36\3\2\2\2\u0083"+
		"\u0084\7#\2\2\u0084\u0085\7?\2\2\u0085 \3\2\2\2\u0086\u0087\7-\2\2\u0087"+
		"\"\3\2\2\2\u0088\u0089\7/\2\2\u0089$\3\2\2\2\u008a\u008b\7-\2\2\u008b"+
		"\u008c\7?\2\2\u008c&\3\2\2\2\u008d\u008e\7/\2\2\u008e\u008f\7?\2\2\u008f"+
		"(\3\2\2\2\u0090\u0091\7(\2\2\u0091\u0092\7(\2\2\u0092*\3\2\2\2\u0093\u0094"+
		"\7~\2\2\u0094\u0095\7~\2\2\u0095,\3\2\2\2\u0096\u0097\7\61\2\2\u0097."+
		"\3\2\2\2\u0098\u0099\7\60\2\2\u0099\60\3\2\2\2\u009a\u009b\7]\2\2\u009b"+
		"\62\3\2\2\2\u009c\u009d\7_\2\2\u009d\64\3\2\2\2\u009e\u009f\7d\2\2\u009f"+
		"\u00a0\7t\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2\7c\2\2\u00a2\u00a3\7m\2\2"+
		"\u00a3\66\3\2\2\2\u00a4\u00a5\7v\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a7\7"+
		"w\2\2\u00a7\u00ae\7g\2\2\u00a8\u00a9\7h\2\2\u00a9\u00aa\7c\2\2\u00aa\u00ab"+
		"\7n\2\2\u00ab\u00ac\7u\2\2\u00ac\u00ae\7g\2\2\u00ad\u00a4\3\2\2\2\u00ad"+
		"\u00a8\3\2\2\2\u00ae8\3\2\2\2\u00af\u00b3\t\2\2\2\u00b0\u00b2\t\2\2\2"+
		"\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4"+
		"\3\2\2\2\u00b4:\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00bf\t\3\2\2\u00b7"+
		"\u00bb\t\4\2\2\u00b8\u00ba\t\3\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2"+
		"\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00be\u00b6\3\2\2\2\u00be\u00b7\3\2\2\2\u00bf<\3\2\2\2"+
		"\u00c0\u00c4\7$\2\2\u00c1\u00c3\n\5\2\2\u00c2\u00c1\3\2\2\2\u00c3\u00c6"+
		"\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c7\u00c8\7$\2\2\u00c8>\3\2\2\2\u00c9\u00ca\7-\2\2\u00ca"+
		"\u00ce\7-\2\2\u00cb\u00cc\7/\2\2\u00cc\u00ce\7/\2\2\u00cd\u00c9\3\2\2"+
		"\2\u00cd\u00cb\3\2\2\2\u00ce@\3\2\2\2\u00cf\u00d1\t\6\2\2\u00d0\u00cf"+
		"\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d5\b!\2\2\u00d5B\3\2\2\2\u00d6\u00d7\7(\2\2\u00d7"+
		"\u00d8\t\7\2\2\u00d8D\3\2\2\2\u00d9\u00e5\7%\2\2\u00da\u00db\5G$\2\u00db"+
		"\u00dc\5G$\2\u00dc\u00dd\5G$\2\u00dd\u00de\5G$\2\u00de\u00df\5G$\2\u00df"+
		"\u00e0\5G$\2\u00e0\u00e6\3\2\2\2\u00e1\u00e2\5G$\2\u00e2\u00e3\5G$\2\u00e3"+
		"\u00e4\5G$\2\u00e4\u00e6\3\2\2\2\u00e5\u00da\3\2\2\2\u00e5\u00e1\3\2\2"+
		"\2\u00e6F\3\2\2\2\u00e7\u00e9\t\b\2\2\u00e8\u00e7\3\2\2\2\u00e9H\3\2\2"+
		"\2\u00ea\u00eb\7U\2\2\u00eb\u00ec\5;\36\2\u00ecJ\3\2\2\2\u00ed\u00ee\7"+
		"*\2\2\u00eeL\3\2\2\2\u00ef\u00f0\7+\2\2\u00f0N\3\2\2\2\u00f1\u00f2\7."+
		"\2\2\u00f2P\3\2\2\2\u00f3\u00f4\7=\2\2\u00f4R\3\2\2\2\u00f5\u00f6\7#\2"+
		"\2\u00f6T\3\2\2\2\f\2\u00ad\u00b3\u00bb\u00be\u00c4\u00cd\u00d2\u00e5"+
		"\u00e8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}