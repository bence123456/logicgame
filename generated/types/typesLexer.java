// Generated from C:/BME_MSC/2_felev/onlab2/logicgame/src/main/com.bkonecsni.logicgame.antlr4/types\types.g4 by ANTLR 4.7
package types;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class typesLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EMPTY_STRING=1, NUMBER=2, CHAR=3, COLOR=4, HDN=5, SYMBOL=6, ITEMS=7, T=8, 
		EMPTY=9, LOOP=10, ISEQ=11, EQ=12, LP=13, RP=14, COMMA=15, ARR=16, COL=17, 
		WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"EMPTY_STRING", "NUMBER", "CHAR", "COLOR", "HDN", "SYMBOL", "ITEMS", "T", 
		"EMPTY", "LOOP", "ISEQ", "EQ", "LP", "RP", "COMMA", "ARR", "COL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'items'", "'Type'", "'empty'", 
		"'Loop'", "'=='", "'='", "'('", "')'", "','", "'->'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "EMPTY_STRING", "NUMBER", "CHAR", "COLOR", "HDN", "SYMBOL", "ITEMS", 
		"T", "EMPTY", "LOOP", "ISEQ", "EQ", "LP", "RP", "COMMA", "ARR", "COL", 
		"WS"
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


	public typesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "types.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24v\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\5\3\62\n\3\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5B\n\5\3\6\5"+
		"\6E\n\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\6\23q\n\23\r\23"+
		"\16\23r\3\23\3\23\2\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\7\3\2\62;\3\2\63;\3\2C\\"+
		"\5\2\62;CHch\5\2\13\f\17\17\"\"\2y\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5\61\3\2"+
		"\2\2\7\63\3\2\2\2\t\65\3\2\2\2\13D\3\2\2\2\rF\3\2\2\2\17I\3\2\2\2\21O"+
		"\3\2\2\2\23T\3\2\2\2\25Z\3\2\2\2\27_\3\2\2\2\31b\3\2\2\2\33d\3\2\2\2\35"+
		"f\3\2\2\2\37h\3\2\2\2!j\3\2\2\2#m\3\2\2\2%p\3\2\2\2\'(\5\23\n\2(\4\3\2"+
		"\2\2)\62\t\2\2\2*.\t\3\2\2+-\t\2\2\2,+\3\2\2\2-\60\3\2\2\2.,\3\2\2\2."+
		"/\3\2\2\2/\62\3\2\2\2\60.\3\2\2\2\61)\3\2\2\2\61*\3\2\2\2\62\6\3\2\2\2"+
		"\63\64\t\4\2\2\64\b\3\2\2\2\65A\7%\2\2\66\67\5\13\6\2\678\5\13\6\289\5"+
		"\13\6\29:\5\13\6\2:;\5\13\6\2;<\5\13\6\2<B\3\2\2\2=>\5\13\6\2>?\5\13\6"+
		"\2?@\5\13\6\2@B\3\2\2\2A\66\3\2\2\2A=\3\2\2\2B\n\3\2\2\2CE\t\5\2\2DC\3"+
		"\2\2\2E\f\3\2\2\2FG\7U\2\2GH\5\5\3\2H\16\3\2\2\2IJ\7k\2\2JK\7v\2\2KL\7"+
		"g\2\2LM\7o\2\2MN\7u\2\2N\20\3\2\2\2OP\7V\2\2PQ\7{\2\2QR\7r\2\2RS\7g\2"+
		"\2S\22\3\2\2\2TU\7g\2\2UV\7o\2\2VW\7r\2\2WX\7v\2\2XY\7{\2\2Y\24\3\2\2"+
		"\2Z[\7N\2\2[\\\7q\2\2\\]\7q\2\2]^\7r\2\2^\26\3\2\2\2_`\7?\2\2`a\7?\2\2"+
		"a\30\3\2\2\2bc\7?\2\2c\32\3\2\2\2de\7*\2\2e\34\3\2\2\2fg\7+\2\2g\36\3"+
		"\2\2\2hi\7.\2\2i \3\2\2\2jk\7/\2\2kl\7@\2\2l\"\3\2\2\2mn\7<\2\2n$\3\2"+
		"\2\2oq\t\6\2\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2st\3\2\2\2tu\b\23"+
		"\2\2u&\3\2\2\2\b\2.\61ADr\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}