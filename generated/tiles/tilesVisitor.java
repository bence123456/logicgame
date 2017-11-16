// Generated from C:/BME_MSC/2_felev/onlab2/logicgame/src/main/com.bkonecsni.logicgame.antlr4/tiles\tiles.g4 by ANTLR 4.7
package tiles;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link tilesParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface tilesVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link tilesParser#tiles}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTiles(tilesParser.TilesContext ctx);
	/**
	 * Visit a parse tree produced by {@link tilesParser#tile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTile(tilesParser.TileContext ctx);
	/**
	 * Visit a parse tree produced by {@link tilesParser#itemList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItemList(tilesParser.ItemListContext ctx);
	/**
	 * Visit a parse tree produced by {@link tilesParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(tilesParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link tilesParser#position}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPosition(tilesParser.PositionContext ctx);
	/**
	 * Visit a parse tree produced by {@link tilesParser#size}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSize(tilesParser.SizeContext ctx);
	/**
	 * Visit a parse tree produced by {@link tilesParser#color}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColor(tilesParser.ColorContext ctx);
	/**
	 * Visit a parse tree produced by {@link tilesParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(tilesParser.ItemContext ctx);
}