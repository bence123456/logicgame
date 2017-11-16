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
		BOOL=1, AREA_DEF=2, ID=3, NUMBER=4, CHAR=5, COLOR=6, HDN=7, SYMBOL=8, 
		WIN=9, LOOSE=10, ISEQ=11, TRUE=12, FALSE=13, EMPTY=14, LP=15, RP=16, COMMA=17, 
		COL=18, WS=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"BOOL", "AREA_DEF", "ID", "NUMBER", "CHAR", "COLOR", "HDN", "SYMBOL", 
		"WIN", "LOOSE", "ISEQ", "TRUE", "FALSE", "EMPTY", "LP", "RP", "COMMA", 
		"COL", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u0090\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\3\2\3\2\5\2,\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\3\67\n\3\3\4\3\4\7\4;\n\4\f\4\16\4>\13\4\3\5\3\5\3\5\7\5C\n"+
		"\5\f\5\16\5F\13\5\5\5H\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7X\n\7\3\b\5\b[\n\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\6\24\u008b\n\24\r\24\16\24\u008c"+
		"\3\24\3\24\2\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\t\3\2c|\4\2C\\c|\3\2\62;\3"+
		"\2\63;\3\2C\\\5\2\62;CHch\5\2\13\f\17\17\"\"\2\u0096\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\3+\3\2\2\2\5\66\3\2\2\2\78\3\2\2\2\tG\3\2\2\2\13I\3\2\2\2\rK"+
		"\3\2\2\2\17Z\3\2\2\2\21\\\3\2\2\2\23_\3\2\2\2\25e\3\2\2\2\27m\3\2\2\2"+
		"\31p\3\2\2\2\33u\3\2\2\2\35{\3\2\2\2\37\u0081\3\2\2\2!\u0083\3\2\2\2#"+
		"\u0085\3\2\2\2%\u0087\3\2\2\2\'\u008a\3\2\2\2),\5\31\r\2*,\5\33\16\2+"+
		")\3\2\2\2+*\3\2\2\2,\4\3\2\2\2-.\7E\2\2./\7Q\2\2/\60\7N\2\2\60\61\7Q\2"+
		"\2\61\67\7T\2\2\62\63\7T\2\2\63\64\7G\2\2\64\65\7E\2\2\65\67\7V\2\2\66"+
		"-\3\2\2\2\66\62\3\2\2\2\67\6\3\2\2\28<\t\2\2\29;\t\3\2\2:9\3\2\2\2;>\3"+
		"\2\2\2<:\3\2\2\2<=\3\2\2\2=\b\3\2\2\2><\3\2\2\2?H\t\4\2\2@D\t\5\2\2AC"+
		"\t\4\2\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2EH\3\2\2\2FD\3\2\2\2G"+
		"?\3\2\2\2G@\3\2\2\2H\n\3\2\2\2IJ\t\6\2\2J\f\3\2\2\2KW\7%\2\2LM\5\17\b"+
		"\2MN\5\17\b\2NO\5\17\b\2OP\5\17\b\2PQ\5\17\b\2QR\5\17\b\2RX\3\2\2\2ST"+
		"\5\17\b\2TU\5\17\b\2UV\5\17\b\2VX\3\2\2\2WL\3\2\2\2WS\3\2\2\2X\16\3\2"+
		"\2\2Y[\t\7\2\2ZY\3\2\2\2[\20\3\2\2\2\\]\7U\2\2]^\5\t\5\2^\22\3\2\2\2_"+
		"`\7y\2\2`a\7k\2\2ab\7p\2\2bc\3\2\2\2cd\5%\23\2d\24\3\2\2\2ef\7n\2\2fg"+
		"\7q\2\2gh\7q\2\2hi\7u\2\2ij\7g\2\2jk\3\2\2\2kl\5%\23\2l\26\3\2\2\2mn\7"+
		"?\2\2no\7?\2\2o\30\3\2\2\2pq\7v\2\2qr\7t\2\2rs\7w\2\2st\7g\2\2t\32\3\2"+
		"\2\2uv\7h\2\2vw\7c\2\2wx\7n\2\2xy\7u\2\2yz\7g\2\2z\34\3\2\2\2{|\7g\2\2"+
		"|}\7o\2\2}~\7r\2\2~\177\7v\2\2\177\u0080\7{\2\2\u0080\36\3\2\2\2\u0081"+
		"\u0082\7*\2\2\u0082 \3\2\2\2\u0083\u0084\7+\2\2\u0084\"\3\2\2\2\u0085"+
		"\u0086\7.\2\2\u0086$\3\2\2\2\u0087\u0088\7<\2\2\u0088&\3\2\2\2\u0089\u008b"+
		"\t\b\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\b\24\2\2\u008f(\3\2\2\2"+
		"\13\2+\66<DGWZ\u008c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}