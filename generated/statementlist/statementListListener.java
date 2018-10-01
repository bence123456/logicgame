// Generated from C:/Users/Ben/IdeaProjects/logicgame/src/main/com.bkonecsni.logicgame.antlr4\statementList.g4 by ANTLR 4.7
package statementlist;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link statementListParser}.
 */
public interface statementListListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link statementListParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(statementListParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(statementListParser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(statementListParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(statementListParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(statementListParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(statementListParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(statementListParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(statementListParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#listType}.
	 * @param ctx the parse tree
	 */
	void enterListType(statementListParser.ListTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#listType}.
	 * @param ctx the parse tree
	 */
	void exitListType(statementListParser.ListTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(statementListParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(statementListParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(statementListParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(statementListParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(statementListParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(statementListParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(statementListParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(statementListParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(statementListParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(statementListParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(statementListParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(statementListParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#modifyStatement}.
	 * @param ctx the parse tree
	 */
	void enterModifyStatement(statementListParser.ModifyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#modifyStatement}.
	 * @param ctx the parse tree
	 */
	void exitModifyStatement(statementListParser.ModifyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#boolStatement}.
	 * @param ctx the parse tree
	 */
	void enterBoolStatement(statementListParser.BoolStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#boolStatement}.
	 * @param ctx the parse tree
	 */
	void exitBoolStatement(statementListParser.BoolStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(statementListParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(statementListParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#multipleExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultipleExpression(statementListParser.MultipleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#multipleExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultipleExpression(statementListParser.MultipleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(statementListParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(statementListParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(statementListParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(statementListParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#varName}.
	 * @param ctx the parse tree
	 */
	void enterVarName(statementListParser.VarNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#varName}.
	 * @param ctx the parse tree
	 */
	void exitVarName(statementListParser.VarNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(statementListParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(statementListParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#funcname}.
	 * @param ctx the parse tree
	 */
	void enterFuncname(statementListParser.FuncnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#funcname}.
	 * @param ctx the parse tree
	 */
	void exitFuncname(statementListParser.FuncnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(statementListParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(statementListParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(statementListParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(statementListParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(statementListParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(statementListParser.ItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link statementListParser#mparam}.
	 * @param ctx the parse tree
	 */
	void enterMparam(statementListParser.MparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link statementListParser#mparam}.
	 * @param ctx the parse tree
	 */
	void exitMparam(statementListParser.MparamContext ctx);
}