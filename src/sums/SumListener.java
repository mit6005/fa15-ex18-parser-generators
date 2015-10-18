// Generated from Sum.g4 by ANTLR 4.5.1

package sums;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SumParser}.
 */
public interface SumListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link SumParser#root}.
     * @param ctx the parse tree
     */
    void enterRoot(SumParser.RootContext ctx);
    /**
     * Exit a parse tree produced by {@link SumParser#root}.
     * @param ctx the parse tree
     */
    void exitRoot(SumParser.RootContext ctx);
    /**
     * Enter a parse tree produced by {@link SumParser#sum}.
     * @param ctx the parse tree
     */
    void enterSum(SumParser.SumContext ctx);
    /**
     * Exit a parse tree produced by {@link SumParser#sum}.
     * @param ctx the parse tree
     */
    void exitSum(SumParser.SumContext ctx);
    /**
     * Enter a parse tree produced by {@link SumParser#addend}.
     * @param ctx the parse tree
     */
    void enterAddend(SumParser.AddendContext ctx);
    /**
     * Exit a parse tree produced by {@link SumParser#addend}.
     * @param ctx the parse tree
     */
    void exitAddend(SumParser.AddendContext ctx);
}