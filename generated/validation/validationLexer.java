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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, BOOL=8, ID=9, 
		NUMBER=10, WIN=11, ISEQ=12, TRUE=13, FALSE=14, EMPTY=15, ITEM=16, NULL=17, 
		STRING=18, LP=19, RP=20, COMMA=21, COL=22, WS=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "BOOL", "ID", 
		"NUMBER", "WIN", "ISEQ", "TRUE", "FALSE", "EMPTY", "ITEM", "NULL", "STRING", 
		"LP", "RP", "COMMA", "COL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "';'", "'if'", "'{'", "'}'", "'['", "']'", null, null, null, 
		null, "'=='", "'true'", "'false'", "'empty'", "'item'", "'null'", null, 
		"'('", "')'", "','", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "BOOL", "ID", "NUMBER", 
		"WIN", "ISEQ", "TRUE", "FALSE", "EMPTY", "ITEM", "NULL", "STRING", "LP", 
		"RP", "COMMA", "COL", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u0091\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\5\tC"+
		"\n\t\3\n\3\n\7\nG\n\n\f\n\16\nJ\13\n\3\13\3\13\3\13\7\13O\n\13\f\13\16"+
		"\13R\13\13\5\13T\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\7\23|"+
		"\n\23\f\23\16\23\177\13\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\30\6\30\u008c\n\30\r\30\16\30\u008d\3\30\3\30\2\2\31\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\3\2\b\4\2C\\c|\6\2\62;C\\aac|\3\2\62;\3"+
		"\2\63;\5\2\f\f\17\17$$\5\2\13\f\17\17\"\"\2\u0096\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2\2\5\63\3"+
		"\2\2\2\7\65\3\2\2\2\t8\3\2\2\2\13:\3\2\2\2\r<\3\2\2\2\17>\3\2\2\2\21B"+
		"\3\2\2\2\23D\3\2\2\2\25S\3\2\2\2\27U\3\2\2\2\31[\3\2\2\2\33^\3\2\2\2\35"+
		"c\3\2\2\2\37i\3\2\2\2!o\3\2\2\2#t\3\2\2\2%y\3\2\2\2\'\u0082\3\2\2\2)\u0084"+
		"\3\2\2\2+\u0086\3\2\2\2-\u0088\3\2\2\2/\u008b\3\2\2\2\61\62\7?\2\2\62"+
		"\4\3\2\2\2\63\64\7=\2\2\64\6\3\2\2\2\65\66\7k\2\2\66\67\7h\2\2\67\b\3"+
		"\2\2\289\7}\2\29\n\3\2\2\2:;\7\177\2\2;\f\3\2\2\2<=\7]\2\2=\16\3\2\2\2"+
		">?\7_\2\2?\20\3\2\2\2@C\5\33\16\2AC\5\35\17\2B@\3\2\2\2BA\3\2\2\2C\22"+
		"\3\2\2\2DH\t\2\2\2EG\t\3\2\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I"+
		"\24\3\2\2\2JH\3\2\2\2KT\t\4\2\2LP\t\5\2\2MO\t\4\2\2NM\3\2\2\2OR\3\2\2"+
		"\2PN\3\2\2\2PQ\3\2\2\2QT\3\2\2\2RP\3\2\2\2SK\3\2\2\2SL\3\2\2\2T\26\3\2"+
		"\2\2UV\7y\2\2VW\7k\2\2WX\7p\2\2XY\3\2\2\2YZ\5-\27\2Z\30\3\2\2\2[\\\7?"+
		"\2\2\\]\7?\2\2]\32\3\2\2\2^_\7v\2\2_`\7t\2\2`a\7w\2\2ab\7g\2\2b\34\3\2"+
		"\2\2cd\7h\2\2de\7c\2\2ef\7n\2\2fg\7u\2\2gh\7g\2\2h\36\3\2\2\2ij\7g\2\2"+
		"jk\7o\2\2kl\7r\2\2lm\7v\2\2mn\7{\2\2n \3\2\2\2op\7k\2\2pq\7v\2\2qr\7g"+
		"\2\2rs\7o\2\2s\"\3\2\2\2tu\7p\2\2uv\7w\2\2vw\7n\2\2wx\7n\2\2x$\3\2\2\2"+
		"y}\7$\2\2z|\n\6\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080"+
		"\3\2\2\2\177}\3\2\2\2\u0080\u0081\7$\2\2\u0081&\3\2\2\2\u0082\u0083\7"+
		"*\2\2\u0083(\3\2\2\2\u0084\u0085\7+\2\2\u0085*\3\2\2\2\u0086\u0087\7."+
		"\2\2\u0087,\3\2\2\2\u0088\u0089\7<\2\2\u0089.\3\2\2\2\u008a\u008c\t\7"+
		"\2\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\b\30\2\2\u0090\60\3\2\2"+
		"\2\t\2BHPS}\u008d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}