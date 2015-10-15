// Generated from Sum.g4 by ANTLR 4.0

package sums;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface SumListener extends ParseTreeListener {
    void enterRoot(SumParser.RootContext ctx);
    void exitRoot(SumParser.RootContext ctx);

    void enterSum(SumParser.SumContext ctx);
    void exitSum(SumParser.SumContext ctx);

    void enterTerm(SumParser.TermContext ctx);
    void exitTerm(SumParser.TermContext ctx);
}