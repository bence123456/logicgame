// Generated from C:/BME_MSC/2_felev/onlab2/logicgame/src/main/com.bkonecsni.logicgame.antlr4/validation\validation.g4 by ANTLR 4.7
package validation;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link validationParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface validationVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link validationParser#validation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidation(validationParser.ValidationContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(validationParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(validationParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(validationParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(validationParser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#listType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListType(validationParser.ListTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(validationParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(validationParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(validationParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(validationParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#assignmentStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStatement(validationParser.AssignmentStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#modifyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifyStatement(validationParser.ModifyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#boolStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolStatement(validationParser.BoolStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(validationParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#multipleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleExpression(validationParser.MultipleExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(validationParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(validationParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#varName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarName(validationParser.VarNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(validationParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#funcname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncname(validationParser.FuncnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(validationParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(validationParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(validationParser.ItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#mparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMparam(validationParser.MparamContext ctx);
}