// Generated from C:/Users/Ben/IdeaProjects/logicgame/src/main/com.bkonecsni.logicgame.antlr4\statementList.g4 by ANTLR 4.7
package statementlist;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link statementListParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface statementListVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link statementListParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(statementListParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(statementListParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(statementListParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(statementListParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#listType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListType(statementListParser.ListTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(statementListParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(statementListParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(statementListParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(statementListParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(statementListParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(statementListParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#modifyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyStatement(statementListParser.ModifyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#boolStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolStatement(statementListParser.BoolStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(statementListParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#multipleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleExpression(statementListParser.MultipleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(statementListParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(statementListParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#varName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarName(statementListParser.VarNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(statementListParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#funcname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncname(statementListParser.FuncnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(statementListParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(statementListParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(statementListParser.ItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#mparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMparam(statementListParser.MparamContext ctx);
	/**
	 * Visit a parse tree produced by {@link statementListParser#loopBreak}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopBreak(statementListParser.LoopBreakContext ctx);
}