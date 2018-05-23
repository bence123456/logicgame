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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, BOOL=7, ID=8, NUMBER=9, 
		CHAR=10, COLOR=11, HDN=12, SYMBOL=13, WIN=14, ISEQ=15, TRUE=16, FALSE=17, 
		EMPTY=18, ITEM=19, NULL=20, STRING=21, LP=22, RP=23, COMMA=24, COL=25, 
		WS=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "BOOL", "ID", "NUMBER", 
		"CHAR", "COLOR", "HDN", "SYMBOL", "WIN", "ISEQ", "TRUE", "FALSE", "EMPTY", 
		"ITEM", "NULL", "STRING", "LP", "RP", "COMMA", "COL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "';'", "'if'", "'{'", "'}'", "'item:'", null, null, null, 
		null, null, null, null, null, "'=='", "'true'", "'false'", "'empty'", 
		"'item'", "'null'", null, "'('", "')'", "','", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "BOOL", "ID", "NUMBER", "CHAR", 
		"COLOR", "HDN", "SYMBOL", "WIN", "ISEQ", "TRUE", "FALSE", "EMPTY", "ITEM", 
		"NULL", "STRING", "LP", "RP", "COMMA", "COL", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u00af\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\5\bK\n\b\3\t\3\t\7\tO\n\t\f\t\16\tR\13"+
		"\t\3\n\3\n\3\n\7\nW\n\n\f\n\16\nZ\13\n\5\n\\\n\n\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\fl\n\f\3\r\5\ro\n\r\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\7\26\u009a\n\26"+
		"\f\26\16\26\u009d\13\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3"+
		"\32\3\33\6\33\u00aa\n\33\r\33\16\33\u00ab\3\33\3\33\2\2\34\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\3\2\n\3\2c|\4\2C\\c|\3\2\62"+
		";\3\2\63;\3\2C\\\5\2\62;CHch\5\2\f\f\17\17$$\5\2\13\f\17\17\"\"\2\u00b5"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\59\3\2\2\2\7;\3"+
		"\2\2\2\t>\3\2\2\2\13@\3\2\2\2\rB\3\2\2\2\17J\3\2\2\2\21L\3\2\2\2\23[\3"+
		"\2\2\2\25]\3\2\2\2\27_\3\2\2\2\31n\3\2\2\2\33p\3\2\2\2\35s\3\2\2\2\37"+
		"y\3\2\2\2!|\3\2\2\2#\u0081\3\2\2\2%\u0087\3\2\2\2\'\u008d\3\2\2\2)\u0092"+
		"\3\2\2\2+\u0097\3\2\2\2-\u00a0\3\2\2\2/\u00a2\3\2\2\2\61\u00a4\3\2\2\2"+
		"\63\u00a6\3\2\2\2\65\u00a9\3\2\2\2\678\7?\2\28\4\3\2\2\29:\7=\2\2:\6\3"+
		"\2\2\2;<\7k\2\2<=\7h\2\2=\b\3\2\2\2>?\7}\2\2?\n\3\2\2\2@A\7\177\2\2A\f"+
		"\3\2\2\2BC\7k\2\2CD\7v\2\2DE\7g\2\2EF\7o\2\2FG\7<\2\2G\16\3\2\2\2HK\5"+
		"!\21\2IK\5#\22\2JH\3\2\2\2JI\3\2\2\2K\20\3\2\2\2LP\t\2\2\2MO\t\3\2\2N"+
		"M\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\22\3\2\2\2RP\3\2\2\2S\\\t\4\2"+
		"\2TX\t\5\2\2UW\t\4\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\\\3\2"+
		"\2\2ZX\3\2\2\2[S\3\2\2\2[T\3\2\2\2\\\24\3\2\2\2]^\t\6\2\2^\26\3\2\2\2"+
		"_k\7%\2\2`a\5\31\r\2ab\5\31\r\2bc\5\31\r\2cd\5\31\r\2de\5\31\r\2ef\5\31"+
		"\r\2fl\3\2\2\2gh\5\31\r\2hi\5\31\r\2ij\5\31\r\2jl\3\2\2\2k`\3\2\2\2kg"+
		"\3\2\2\2l\30\3\2\2\2mo\t\7\2\2nm\3\2\2\2o\32\3\2\2\2pq\7U\2\2qr\5\23\n"+
		"\2r\34\3\2\2\2st\7y\2\2tu\7k\2\2uv\7p\2\2vw\3\2\2\2wx\5\63\32\2x\36\3"+
		"\2\2\2yz\7?\2\2z{\7?\2\2{ \3\2\2\2|}\7v\2\2}~\7t\2\2~\177\7w\2\2\177\u0080"+
		"\7g\2\2\u0080\"\3\2\2\2\u0081\u0082\7h\2\2\u0082\u0083\7c\2\2\u0083\u0084"+
		"\7n\2\2\u0084\u0085\7u\2\2\u0085\u0086\7g\2\2\u0086$\3\2\2\2\u0087\u0088"+
		"\7g\2\2\u0088\u0089\7o\2\2\u0089\u008a\7r\2\2\u008a\u008b\7v\2\2\u008b"+
		"\u008c\7{\2\2\u008c&\3\2\2\2\u008d\u008e\7k\2\2\u008e\u008f\7v\2\2\u008f"+
		"\u0090\7g\2\2\u0090\u0091\7o\2\2\u0091(\3\2\2\2\u0092\u0093\7p\2\2\u0093"+
		"\u0094\7w\2\2\u0094\u0095\7n\2\2\u0095\u0096\7n\2\2\u0096*\3\2\2\2\u0097"+
		"\u009b\7$\2\2\u0098\u009a\n\b\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2"+
		"\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3\2\2\2\u009d"+
		"\u009b\3\2\2\2\u009e\u009f\7$\2\2\u009f,\3\2\2\2\u00a0\u00a1\7*\2\2\u00a1"+
		".\3\2\2\2\u00a2\u00a3\7+\2\2\u00a3\60\3\2\2\2\u00a4\u00a5\7.\2\2\u00a5"+
		"\62\3\2\2\2\u00a6\u00a7\7<\2\2\u00a7\64\3\2\2\2\u00a8\u00aa\t\t\2\2\u00a9"+
		"\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2"+
		"\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\b\33\2\2\u00ae\66\3\2\2\2\13\2JP"+
		"X[kn\u009b\u00ab\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}