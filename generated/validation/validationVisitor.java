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
	 * Visit a parse tree produced by {@link validationParser#win}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWin(validationParser.WinContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#loose}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoose(validationParser.LooseContext ctx);
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
	 * Visit a parse tree produced by {@link validationParser#parens_nr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens_nr(validationParser.Parens_nrContext ctx);
	/**
	 * Visit a parse tree produced by {@link validationParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(validationParser.ItemContext ctx);
}