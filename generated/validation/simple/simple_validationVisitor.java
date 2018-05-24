// Generated from C:/BME_MSC/2_felev/onlab2/logicgame/src/main/com.bkonecsni.logicgame.antlr4/validation/simple\simple_validation.g4 by ANTLR 4.7
package validation.simple;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link simple_validationParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface simple_validationVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link simple_validationParser#validation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValidation(simple_validationParser.ValidationContext ctx);
	/**
	 * Visit a parse tree produced by {@link simple_validationParser#win}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWin(simple_validationParser.WinContext ctx);
	/**
	 * Visit a parse tree produced by {@link simple_validationParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(simple_validationParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link simple_validationParser#funcname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncname(simple_validationParser.FuncnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link simple_validationParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(simple_validationParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link simple_validationParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(simple_validationParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link simple_validationParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(simple_validationParser.ItemContext ctx);
}