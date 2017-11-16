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
	 * Enter a parse tree produced by {@link validationParser#win}.
	 * @param ctx the parse tree
	 */
	void enterWin(validationParser.WinContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#win}.
	 * @param ctx the parse tree
	 */
	void exitWin(validationParser.WinContext ctx);
	/**
	 * Enter a parse tree produced by {@link validationParser#loose}.
	 * @param ctx the parse tree
	 */
	void enterLoose(validationParser.LooseContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#loose}.
	 * @param ctx the parse tree
	 */
	void exitLoose(validationParser.LooseContext ctx);
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
	 * Enter a parse tree produced by {@link validationParser#parens_nr}.
	 * @param ctx the parse tree
	 */
	void enterParens_nr(validationParser.Parens_nrContext ctx);
	/**
	 * Exit a parse tree produced by {@link validationParser#parens_nr}.
	 * @param ctx the parse tree
	 */
	void exitParens_nr(validationParser.Parens_nrContext ctx);
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
}