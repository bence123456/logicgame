// Generated from C:/BME_MSC/2_felev/onlab2/logicgame/src/main/com.bkonecsni.logicgame.antlr4/types\types.g4 by ANTLR 4.7
package types;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link typesParser}.
 */
public interface typesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link typesParser#types}.
	 * @param ctx the parse tree
	 */
	void enterTypes(typesParser.TypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#types}.
	 * @param ctx the parse tree
	 */
	void exitTypes(typesParser.TypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#typedecl}.
	 * @param ctx the parse tree
	 */
	void enterTypedecl(typesParser.TypedeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#typedecl}.
	 * @param ctx the parse tree
	 */
	void exitTypedecl(typesParser.TypedeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#typedef}.
	 * @param ctx the parse tree
	 */
	void enterTypedef(typesParser.TypedefContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#typedef}.
	 * @param ctx the parse tree
	 */
	void exitTypedef(typesParser.TypedefContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#typehead}.
	 * @param ctx the parse tree
	 */
	void enterTypehead(typesParser.TypeheadContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#typehead}.
	 * @param ctx the parse tree
	 */
	void exitTypehead(typesParser.TypeheadContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#loop}.
	 * @param ctx the parse tree
	 */
	void enterLoop(typesParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#loop}.
	 * @param ctx the parse tree
	 */
	void exitLoop(typesParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(typesParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(typesParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#typestatement}.
	 * @param ctx the parse tree
	 */
	void enterTypestatement(typesParser.TypestatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#typestatement}.
	 * @param ctx the parse tree
	 */
	void exitTypestatement(typesParser.TypestatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#updatestatement}.
	 * @param ctx the parse tree
	 */
	void enterUpdatestatement(typesParser.UpdatestatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#updatestatement}.
	 * @param ctx the parse tree
	 */
	void exitUpdatestatement(typesParser.UpdatestatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#parens_nr}.
	 * @param ctx the parse tree
	 */
	void enterParens_nr(typesParser.Parens_nrContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#parens_nr}.
	 * @param ctx the parse tree
	 */
	void exitParens_nr(typesParser.Parens_nrContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(typesParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(typesParser.ItemContext ctx);
}