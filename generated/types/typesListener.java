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
	 * Enter a parse tree produced by {@link typesParser#typeparams}.
	 * @param ctx the parse tree
	 */
	void enterTypeparams(typesParser.TypeparamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#typeparams}.
	 * @param ctx the parse tree
	 */
	void exitTypeparams(typesParser.TypeparamsContext ctx);
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
	 * Enter a parse tree produced by {@link typesParser#typeitem}.
	 * @param ctx the parse tree
	 */
	void enterTypeitem(typesParser.TypeitemContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#typeitem}.
	 * @param ctx the parse tree
	 */
	void exitTypeitem(typesParser.TypeitemContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(typesParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(typesParser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(typesParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(typesParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(typesParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(typesParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(typesParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(typesParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#listType}.
	 * @param ctx the parse tree
	 */
	void enterListType(typesParser.ListTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#listType}.
	 * @param ctx the parse tree
	 */
	void exitListType(typesParser.ListTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(typesParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(typesParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(typesParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(typesParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(typesParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(typesParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(typesParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(typesParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(typesParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(typesParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStatement(typesParser.AssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#assignmentStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStatement(typesParser.AssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#modifyStatement}.
	 * @param ctx the parse tree
	 */
	void enterModifyStatement(typesParser.ModifyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#modifyStatement}.
	 * @param ctx the parse tree
	 */
	void exitModifyStatement(typesParser.ModifyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#boolStatement}.
	 * @param ctx the parse tree
	 */
	void enterBoolStatement(typesParser.BoolStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#boolStatement}.
	 * @param ctx the parse tree
	 */
	void exitBoolStatement(typesParser.BoolStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(typesParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(typesParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#multipleExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultipleExpression(typesParser.MultipleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#multipleExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultipleExpression(typesParser.MultipleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(typesParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(typesParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(typesParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(typesParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#varName}.
	 * @param ctx the parse tree
	 */
	void enterVarName(typesParser.VarNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#varName}.
	 * @param ctx the parse tree
	 */
	void exitVarName(typesParser.VarNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(typesParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(typesParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link typesParser#funcname}.
	 * @param ctx the parse tree
	 */
	void enterFuncname(typesParser.FuncnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#funcname}.
	 * @param ctx the parse tree
	 */
	void exitFuncname(typesParser.FuncnameContext ctx);
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
	 * Enter a parse tree produced by {@link typesParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(typesParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(typesParser.ParamContext ctx);
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
	/**
	 * Enter a parse tree produced by {@link typesParser#mparam}.
	 * @param ctx the parse tree
	 */
	void enterMparam(typesParser.MparamContext ctx);
	/**
	 * Exit a parse tree produced by {@link typesParser#mparam}.
	 * @param ctx the parse tree
	 */
	void exitMparam(typesParser.MparamContext ctx);
}