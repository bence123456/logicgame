// Generated from C:/BME_MSC/2_felev/onlab2/logicgame/src/main/com.bkonecsni.logicgame.antlr4/validation/simple\simple_validation.g4 by ANTLR 4.7
package validation.simple;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link simple_validationParser}.
 */
public interface simple_validationListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link simple_validationParser#validation}.
	 * @param ctx the parse tree
	 */
	void enterValidation(simple_validationParser.ValidationContext ctx);
	/**
	 * Exit a parse tree produced by {@link simple_validationParser#validation}.
	 * @param ctx the parse tree
	 */
	void exitValidation(simple_validationParser.ValidationContext ctx);
	/**
	 * Enter a parse tree produced by {@link simple_validationParser#win}.
	 * @param ctx the parse tree
	 */
	void enterWin(simple_validationParser.WinContext ctx);
	/**
	 * Exit a parse tree produced by {@link simple_validationParser#win}.
	 * @param ctx the parse tree
	 */
	void exitWin(simple_validationParser.WinContext ctx);
	/**
	 * Enter a parse tree produced by {@link simple_validationParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(simple_validationParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link simple_validationParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(simple_validationParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link simple_validationParser#funcname}.
	 * @param ctx the parse tree
	 */
	void enterFuncname(simple_validationParser.FuncnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link simple_validationParser#funcname}.
	 * @param ctx the parse tree
	 */
	void exitFuncname(simple_validationParser.FuncnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link simple_validationParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(simple_validationParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link simple_validationParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(simple_validationParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link simple_validationParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(simple_validationParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link simple_validationParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(simple_validationParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link simple_validationParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(simple_validationParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link simple_validationParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(simple_validationParser.ItemContext ctx);
}