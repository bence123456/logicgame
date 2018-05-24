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
	 * Visit a parse tree produced by {@link validationParser#varName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarName(validationParser.VarNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(validationParser.IfStatementContext ctx);
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
	 * Visit a parse tree produced by {@link validationParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(validationParser.ExpressionContext ctx);
}