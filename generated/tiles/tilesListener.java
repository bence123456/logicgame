// Generated from C:/BME_MSC/2_felev/onlab2/logicgame/src/main/com.bkonecsni.logicgame.antlr4/tiles\tiles.g4 by ANTLR 4.7
package tiles;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link tilesParser}.
 */
public interface tilesListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link tilesParser#tiles}.
	 * @param ctx the parse tree
	 */
	void enterTiles(tilesParser.TilesContext ctx);
	/**
	 * Exit a parse tree produced by {@link tilesParser#tiles}.
	 * @param ctx the parse tree
	 */
	void exitTiles(tilesParser.TilesContext ctx);
	/**
	 * Enter a parse tree produced by {@link tilesParser#tile}.
	 * @param ctx the parse tree
	 */
	void enterTile(tilesParser.TileContext ctx);
	/**
	 * Exit a parse tree produced by {@link tilesParser#tile}.
	 * @param ctx the parse tree
	 */
	void exitTile(tilesParser.TileContext ctx);
	/**
	 * Enter a parse tree produced by {@link tilesParser#itemList}.
	 * @param ctx the parse tree
	 */
	void enterItemList(tilesParser.ItemListContext ctx);
	/**
	 * Exit a parse tree produced by {@link tilesParser#itemList}.
	 * @param ctx the parse tree
	 */
	void exitItemList(tilesParser.ItemListContext ctx);
	/**
	 * Enter a parse tree produced by {@link tilesParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(tilesParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link tilesParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(tilesParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link tilesParser#position}.
	 * @param ctx the parse tree
	 */
	void enterPosition(tilesParser.PositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link tilesParser#position}.
	 * @param ctx the parse tree
	 */
	void exitPosition(tilesParser.PositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link tilesParser#size}.
	 * @param ctx the parse tree
	 */
	void enterSize(tilesParser.SizeContext ctx);
	/**
	 * Exit a parse tree produced by {@link tilesParser#size}.
	 * @param ctx the parse tree
	 */
	void exitSize(tilesParser.SizeContext ctx);
	/**
	 * Enter a parse tree produced by {@link tilesParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColor(tilesParser.ColorContext ctx);
	/**
	 * Exit a parse tree produced by {@link tilesParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColor(tilesParser.ColorContext ctx);
	/**
	 * Enter a parse tree produced by {@link tilesParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(tilesParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link tilesParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(tilesParser.ItemContext ctx);
}