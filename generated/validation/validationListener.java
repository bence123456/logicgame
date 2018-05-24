// Generated from C:/BME_MSC/2_felev/onlab2/logicgame/src/main/com.bkonecsni.logicgame.antlr4/validation\validation.g4 by ANTLR 4.7
package validation;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link validationParser}.
 */
public interface validationListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link validationParser#validation}.
	 * @param ctx the parse tree
	 */
	void enterValidation(validationParser.ValidationContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#validation}.
	 * @param ctx the parse tree
	 */
	void exitValidation(validationParser.ValidationContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(validationParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(validationParser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(validationParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(validationParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(validationParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(validationParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(validationParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(validationParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(validationParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(validationParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(validationParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(validationParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(validationParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(validationParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(validationParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(validationParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(validationParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(validationParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#modifyStatement}.
	 * @param ctx the parse tree
	 */
	void enterModifyStatement(validationParser.ModifyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#modifyStatement}.
	 * @param ctx the parse tree
	 */
	void exitModifyStatement(validationParser.ModifyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#boolStatement}.
	 * @param ctx the parse tree
	 */
	void enterBoolStatement(validationParser.BoolStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#boolStatement}.
	 * @param ctx the parse tree
	 */
	void exitBoolStatement(validationParser.BoolStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(validationParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(validationParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#multipleExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultipleExpression(validationParser.MultipleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#multipleExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultipleExpression(validationParser.MultipleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(validationParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(validationParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(validationParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(validationParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#varName}.
	 * @param ctx the parse tree
	 */
	void enterVarName(validationParser.VarNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#varName}.
	 * @param ctx the parse tree
	 */
	void exitVarName(validationParser.VarNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(validationParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(validationParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#funcname}.
	 * @param ctx the parse tree
	 */
	void enterFuncname(validationParser.FuncnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#funcname}.
	 * @param ctx the parse tree
	 */
	void exitFuncname(validationParser.FuncnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(validationParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(validationParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(validationParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(validationParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(validationParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(validationParser.ItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#mparam}.
	 * @param ctx the parse tree
	 */
	void enterMparam(validationParser.MparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#mparam}.
	 * @param ctx the parse tree
	 */
	void exitMparam(validationParser.MparamContext ctx);
}