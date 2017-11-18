// Generated from C:/BME_MSC/2_felev/onlab2/logicgame/src/main/com.bkonecsni.logicgame.antlr4/map\map.g4 by ANTLR 4.7
package map;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link mapParser}.
 */
public interface mapListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link mapParser#map}.
	 * @param ctx the parse tree
	 */
	void enterMap(mapParser.MapContext ctx);
	/**
	 * Exit a parse tree produced by {@link mapParser#map}.
	 * @param ctx the parse tree
	 */
	void exitMap(mapParser.MapContext ctx);
	/**
	 * Enter a parse tree produced by {@link mapParser#tile}.
	 * @param ctx the parse tree
	 */
	void enterTile(mapParser.TileContext ctx);
	/**
	 * Exit a parse tree produced by {@link mapParser#tile}.
	 * @param ctx the parse tree
	 */
	void exitTile(mapParser.TileContext ctx);
	/**
	 * Enter a parse tree produced by {@link mapParser#itemList}.
	 * @param ctx the parse tree
	 */
	void enterItemList(mapParser.ItemListContext ctx);
	/**
	 * Exit a parse tree produced by {@link mapParser#itemList}.
	 * @param ctx the parse tree
	 */
	void exitItemList(mapParser.ItemListContext ctx);
	/**
	 * Enter a parse tree produced by {@link mapParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(mapParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link mapParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(mapParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link mapParser#position}.
	 * @param ctx the parse tree
	 */
	void enterPosition(mapParser.PositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link mapParser#position}.
	 * @param ctx the parse tree
	 */
	void exitPosition(mapParser.PositionContext ctx);
	/**
	 * Enter a parse tree produced by {@link mapParser#size}.
	 * @param ctx the parse tree
	 */
	void enterSize(mapParser.SizeContext ctx);
	/**
	 * Exit a parse tree produced by {@link mapParser#size}.
	 * @param ctx the parse tree
	 */
	void exitSize(mapParser.SizeContext ctx);
	/**
	 * Enter a parse tree produced by {@link mapParser#color}.
	 * @param ctx the parse tree
	 */
	void enterColor(mapParser.ColorContext ctx);
	/**
	 * Exit a parse tree produced by {@link mapParser#color}.
	 * @param ctx the parse tree
	 */
	void exitColor(mapParser.ColorContext ctx);
	/**
	 * Enter a parse tree produced by {@link mapParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(mapParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link mapParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(mapParser.ItemContext ctx);
}