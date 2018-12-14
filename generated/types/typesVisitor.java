// Generated from C:/Users/Ben/IdeaProjects/logicgame/src/main/com.bkonecsni.logicgame.antlr4\types.g4 by ANTLR 4.7
package types;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link typesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface typesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link typesParser#types}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypes(typesParser.TypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#typeDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDeclaration(typesParser.TypeDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#typeDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDefinition(typesParser.TypeDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#typeHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeHeader(typesParser.TypeHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoop(typesParser.LoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(typesParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#typeStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeStatement(typesParser.TypeStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(typesParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#updateStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateStatement(typesParser.UpdateStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#parens_nr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens_nr(typesParser.Parens_nrContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(typesParser.ItemContext ctx);
}