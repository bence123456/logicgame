// Generated from C:/Users/Ben/IdeaProjects/logicgame/src/main/com.bkonecsni.logicgame.antlr4\map.g4 by ANTLR 4.7
package map;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link mapParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface mapVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link mapParser#map}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMap(mapParser.MapContext ctx);
	/**
	 * Visit a parse tree produced by {@link mapParser#tile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTile(mapParser.TileContext ctx);
	/**
	 * Visit a parse tree produced by {@link mapParser#itemList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemList(mapParser.ItemListContext ctx);
	/**
	 * Visit a parse tree produced by {@link mapParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(mapParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link mapParser#position}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPosition(mapParser.PositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link mapParser#size}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSize(mapParser.SizeContext ctx);
	/**
	 * Visit a parse tree produced by {@link mapParser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColor(mapParser.ColorContext ctx);
	/**
	 * Visit a parse tree produced by {@link mapParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(mapParser.ItemContext ctx);
}