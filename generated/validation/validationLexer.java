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
		T__24=25, ID=26, NUMBER=27, STRING=28, BOOL=29, WS=30, CHAR=31, COLOR=32, 
		HDN=33, SYMBOL=34, LP=35, RP=36, COMMA=37, SCOLON=38, NEG=39;
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
		"ID", "NUMBER", "STRING", "BOOL", "WS", "CHAR", "COLOR", "HDN", "SYMBOL", 
		"LP", "RP", "COMMA", "SCOLON", "NEG"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'List'", "'if'", "'for '", "':'", "'++'", "'--'", "'{'", 
		"'}'", "'return'", "'=='", "'>'", "'<'", "'<='", "'>='", "'!='", "'+'", 
		"'-'", "'+='", "'-='", "'&&'", "'||'", "'.'", "'['", "']'", null, null, 
		null, null, null, null, null, null, null, "'('", "')'", "','", "';'", 
		"'!'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "ID", "NUMBER", "STRING", "BOOL", "WS", "CHAR", "COLOR", "HDN", 
		"SYMBOL", "LP", "RP", "COMMA", "SCOLON", "NEG"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u00e5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\7\33\u009c\n\33\f\33\16\33\u009f"+
		"\13\33\3\34\3\34\3\34\7\34\u00a4\n\34\f\34\16\34\u00a7\13\34\5\34\u00a9"+
		"\n\34\3\35\3\35\7\35\u00ad\n\35\f\35\16\35\u00b0\13\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u00bd\n\36\3\37\6\37\u00c0"+
		"\n\37\r\37\16\37\u00c1\3\37\3\37\3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\5!\u00d4\n!\3\"\5\"\u00d7\n\"\3#\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'"+
		"\3(\3(\2\2)\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)\3\2\t\4\2C\\c|\3\2\62;\3\2\63;\5\2\f"+
		"\f\17\17$$\5\2\13\f\17\17\"\"\3\2C\\\5\2\62;CHch\2\u00eb\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\3Q\3\2\2\2\5S\3\2\2\2\7X\3\2\2\2\t[\3"+
		"\2\2\2\13`\3\2\2\2\rb\3\2\2\2\17e\3\2\2\2\21h\3\2\2\2\23j\3\2\2\2\25l"+
		"\3\2\2\2\27s\3\2\2\2\31v\3\2\2\2\33x\3\2\2\2\35z\3\2\2\2\37}\3\2\2\2!"+
		"\u0080\3\2\2\2#\u0083\3\2\2\2%\u0085\3\2\2\2\'\u0087\3\2\2\2)\u008a\3"+
		"\2\2\2+\u008d\3\2\2\2-\u0090\3\2\2\2/\u0093\3\2\2\2\61\u0095\3\2\2\2\63"+
		"\u0097\3\2\2\2\65\u0099\3\2\2\2\67\u00a8\3\2\2\29\u00aa\3\2\2\2;\u00bc"+
		"\3\2\2\2=\u00bf\3\2\2\2?\u00c5\3\2\2\2A\u00c7\3\2\2\2C\u00d6\3\2\2\2E"+
		"\u00d8\3\2\2\2G\u00db\3\2\2\2I\u00dd\3\2\2\2K\u00df\3\2\2\2M\u00e1\3\2"+
		"\2\2O\u00e3\3\2\2\2QR\7?\2\2R\4\3\2\2\2ST\7N\2\2TU\7k\2\2UV\7u\2\2VW\7"+
		"v\2\2W\6\3\2\2\2XY\7k\2\2YZ\7h\2\2Z\b\3\2\2\2[\\\7h\2\2\\]\7q\2\2]^\7"+
		"t\2\2^_\7\"\2\2_\n\3\2\2\2`a\7<\2\2a\f\3\2\2\2bc\7-\2\2cd\7-\2\2d\16\3"+
		"\2\2\2ef\7/\2\2fg\7/\2\2g\20\3\2\2\2hi\7}\2\2i\22\3\2\2\2jk\7\177\2\2"+
		"k\24\3\2\2\2lm\7t\2\2mn\7g\2\2no\7v\2\2op\7w\2\2pq\7t\2\2qr\7p\2\2r\26"+
		"\3\2\2\2st\7?\2\2tu\7?\2\2u\30\3\2\2\2vw\7@\2\2w\32\3\2\2\2xy\7>\2\2y"+
		"\34\3\2\2\2z{\7>\2\2{|\7?\2\2|\36\3\2\2\2}~\7@\2\2~\177\7?\2\2\177 \3"+
		"\2\2\2\u0080\u0081\7#\2\2\u0081\u0082\7?\2\2\u0082\"\3\2\2\2\u0083\u0084"+
		"\7-\2\2\u0084$\3\2\2\2\u0085\u0086\7/\2\2\u0086&\3\2\2\2\u0087\u0088\7"+
		"-\2\2\u0088\u0089\7?\2\2\u0089(\3\2\2\2\u008a\u008b\7/\2\2\u008b\u008c"+
		"\7?\2\2\u008c*\3\2\2\2\u008d\u008e\7(\2\2\u008e\u008f\7(\2\2\u008f,\3"+
		"\2\2\2\u0090\u0091\7~\2\2\u0091\u0092\7~\2\2\u0092.\3\2\2\2\u0093\u0094"+
		"\7\60\2\2\u0094\60\3\2\2\2\u0095\u0096\7]\2\2\u0096\62\3\2\2\2\u0097\u0098"+
		"\7_\2\2\u0098\64\3\2\2\2\u0099\u009d\t\2\2\2\u009a\u009c\t\2\2\2\u009b"+
		"\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2"+
		"\2\2\u009e\66\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a9\t\3\2\2\u00a1\u00a5"+
		"\t\4\2\2\u00a2\u00a4\t\3\2\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2"+
		"\2\2\u00a8\u00a0\3\2\2\2\u00a8\u00a1\3\2\2\2\u00a98\3\2\2\2\u00aa\u00ae"+
		"\7$\2\2\u00ab\u00ad\n\5\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae\3\2"+
		"\2\2\u00b1\u00b2\7$\2\2\u00b2:\3\2\2\2\u00b3\u00b4\7v\2\2\u00b4\u00b5"+
		"\7t\2\2\u00b5\u00b6\7w\2\2\u00b6\u00bd\7g\2\2\u00b7\u00b8\7h\2\2\u00b8"+
		"\u00b9\7c\2\2\u00b9\u00ba\7n\2\2\u00ba\u00bb\7u\2\2\u00bb\u00bd\7g\2\2"+
		"\u00bc\u00b3\3\2\2\2\u00bc\u00b7\3\2\2\2\u00bd<\3\2\2\2\u00be\u00c0\t"+
		"\6\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\b\37\2\2\u00c4>\3\2\2\2"+
		"\u00c5\u00c6\t\7\2\2\u00c6@\3\2\2\2\u00c7\u00d3\7%\2\2\u00c8\u00c9\5C"+
		"\"\2\u00c9\u00ca\5C\"\2\u00ca\u00cb\5C\"\2\u00cb\u00cc\5C\"\2\u00cc\u00cd"+
		"\5C\"\2\u00cd\u00ce\5C\"\2\u00ce\u00d4\3\2\2\2\u00cf\u00d0\5C\"\2\u00d0"+
		"\u00d1\5C\"\2\u00d1\u00d2\5C\"\2\u00d2\u00d4\3\2\2\2\u00d3\u00c8\3\2\2"+
		"\2\u00d3\u00cf\3\2\2\2\u00d4B\3\2\2\2\u00d5\u00d7\t\b\2\2\u00d6\u00d5"+
		"\3\2\2\2\u00d7D\3\2\2\2\u00d8\u00d9\7U\2\2\u00d9\u00da\5\67\34\2\u00da"+
		"F\3\2\2\2\u00db\u00dc\7*\2\2\u00dcH\3\2\2\2\u00dd\u00de\7+\2\2\u00deJ"+
		"\3\2\2\2\u00df\u00e0\7.\2\2\u00e0L\3\2\2\2\u00e1\u00e2\7=\2\2\u00e2N\3"+
		"\2\2\2\u00e3\u00e4\7#\2\2\u00e4P\3\2\2\2\13\2\u009d\u00a5\u00a8\u00ae"+
		"\u00bc\u00c1\u00d3\u00d6\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}