// Generated from C:/Users/Ben/IdeaProjects/logicgame/src/main/com.bkonecsni.logicgame.antlr4\types.g4 by ANTLR 4.7
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
	 * Enter a parse tree produced by {@link typesParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(typesParser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(typesParser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void enterTypeDefinition(typesParser.TypeDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#typeDefinition}.
	 * @param ctx the parse tree
	 */
	void exitTypeDefinition(typesParser.TypeDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#typeHeader}.
	 * @param ctx the parse tree
	 */
	void enterTypeHeader(typesParser.TypeHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#typeHeader}.
	 * @param ctx the parse tree
	 */
	void exitTypeHeader(typesParser.TypeHeaderContext ctx);
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
	 * Enter a parse tree produced by {@link typesParser#typeStatement}.
	 * @param ctx the parse tree
	 */
	void enterTypeStatement(typesParser.TypeStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#typeStatement}.
	 * @param ctx the parse tree
	 */
	void exitTypeStatement(typesParser.TypeStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(typesParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(typesParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#updateStatement}.
	 * @param ctx the parse tree
	 */
	void enterUpdateStatement(typesParser.UpdateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#updateStatement}.
	 * @param ctx the parse tree
	 */
	void exitUpdateStatement(typesParser.UpdateStatementContext ctx);
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