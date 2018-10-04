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
	 * Visit a parse tree produced by {@link typesParser#typedecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedecl(typesParser.TypedeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#typedef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedef(typesParser.TypedefContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#typehead}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypehead(typesParser.TypeheadContext ctx);
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
	 * Visit a parse tree produced by {@link typesParser#typestatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypestatement(typesParser.TypestatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(typesParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#updatestatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdatestatement(typesParser.UpdatestatementContext ctx);
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