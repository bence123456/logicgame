// Generated from C:/Users/Ben/IdeaProjects/logicgame/src/main/com.bkonecsni.logicgame.antlr4\symbols.g4 by ANTLR 4.7
package symbols;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link symbolsParser}.
 */
public interface symbolsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link symbolsParser#symbols}.
	 * @param ctx the parse tree
	 */
	void enterSymbols(symbolsParser.SymbolsContext ctx);
	/**
	 * Exit a parse tree produced by {@link symbolsParser#symbols}.
	 * @param ctx the parse tree
	 */
	void exitSymbols(symbolsParser.SymbolsContext ctx);
	/**
	 * Enter a parse tree produced by {@link symbolsParser#symbol}.
	 * @param ctx the parse tree
	 */
	void enterSymbol(symbolsParser.SymbolContext ctx);
	/**
	 * Exit a parse tree produced by {@link symbolsParser#symbol}.
	 * @param ctx the parse tree
	 */
	void exitSymbol(symbolsParser.SymbolContext ctx);
}