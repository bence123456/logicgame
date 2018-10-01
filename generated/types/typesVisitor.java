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
	 * Visit a parse tree produced by {@link typesParser#typeparams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeparams(typesParser.TypeparamsContext ctx);
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
	 * Visit a parse tree produced by {@link typesParser#typeitem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeitem(typesParser.TypeitemContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(typesParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(typesParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(typesParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(typesParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#listType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListType(typesParser.ListTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(typesParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(typesParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(typesParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(typesParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(typesParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(typesParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#modifyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyStatement(typesParser.ModifyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#boolStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolStatement(typesParser.BoolStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(typesParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#multipleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleExpression(typesParser.MultipleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(typesParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(typesParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#varName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarName(typesParser.VarNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(typesParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#funcname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncname(typesParser.FuncnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(typesParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(typesParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(typesParser.ItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link typesParser#mparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMparam(typesParser.MparamContext ctx);
}