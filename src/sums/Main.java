package sums;

import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;


public class Main {
 
    public static void main(String[] args) {
        String input = "54+(2+89)";
        Sum sum = parse(input);
        int value = sum.value();
        System.out.println(input + "=" + sum + "=" + value);
    }

    /**
     */
    public static Sum parse(String string) {
       // Create a stream of characters from the string
       CharStream stream = new ANTLRInputStream(string);

       // Make a parser
       SumParser parser = makeParser(stream);
       
       // Generate the parse tree using the starter rule.
       // root is the starter rule for this grammar.
       // Other grammars may have different names for the starter rule.
       ParseTree tree = parser.root();
       
       // *** debugging option #1: print the tree to the console
//        System.err.println(tree.toStringTree(parser));

       // *** debugging option #2: show the tree in a window
       RuleContext rootContext = (RuleContext) tree;
       rootContext.inspect(parser);
       
       // *** debugging option #3: walk the tree with a listener
       new ParseTreeWalker().walk(new PrintEverything(), tree);
       
       MakeSum sumMaker = new MakeSum();
       new ParseTreeWalker().walk(sumMaker, tree);
       return sumMaker.getSum();
   }

    
    /**
     * Make a parser that is ready to parse a stream of characters.
     * @param stream stream of characters
     * @return a parser that is ready to parse the stream.
     * To start parsing, the client should call a method on the returned parser corresponding to
     * the start rule of the grammar, e.g. parser.html() or parser.root() or
     * whatever it happens to be.
     * During parsing, if the parser encounters a syntax error,
     * it will throw a RuntimeException.
     * 
     */
    private static SumParser makeParser(CharStream stream) {
        // Make a lexer.  This converts the stream of characters into a 
        // stream of tokens.  A token is a character group, like "<i>"
        // or "</i>".  Note that this doesn't start reading the character stream yet,
        // it just sets up the lexer to read it.
        SumLexer lexer = new SumLexer(stream);
        lexer.reportErrorsAsExceptions();
        TokenStream tokens = new CommonTokenStream(lexer);
        
        // Make a parser whose input comes from the token stream produced by the lexer.
        SumParser parser = new SumParser(tokens);
        parser.reportErrorsAsExceptions();
        
        return parser;
    }
    
}

class PrintEverything implements SumListener {
    @Override public void enterRoot(SumParser.RootContext context) {
        System.err.println("entering root");
    }
    @Override public void exitRoot(SumParser.RootContext context) {
        System.err.println("exiting root");
    }

    @Override public void enterSum(SumParser.SumContext context) {
        System.err.println("entering sum");
    }
    @Override public void exitSum(SumParser.SumContext context) {
        System.err.println("exiting sum");
    }

    @Override public void enterAddend(SumParser.AddendContext context) {
        System.err.println("entering addend");
    }
    @Override public void exitAddend(SumParser.AddendContext context) {
        System.err.println("exiting addend");
    }

    @Override public void visitTerminal(TerminalNode terminal) {
        System.err.println("terminal " + terminal.getText());            
    }
    
    // don't need these here, so just make them empty implementations
    @Override public void enterEveryRule(ParserRuleContext context) { }
    @Override public void exitEveryRule(ParserRuleContext context) { }
    @Override public void visitErrorNode(ErrorNode node) { }         
}

/** Make a Sum value from a parse tree. */
class MakeSum implements SumListener {
    private Stack<Sum> stack = new Stack<>();
    // Invariant: stack contains the Sum value of each parse subtree 
    // that has been fully-walked so far, but whose parent 
    // has not yet been exited by the walk. The stack is ordered 
    // by recency of visit, so that the top of the stack is the 
    // Sum for the most recently walked subtree.
    //
    // At the start of the walk, the stack is empty, because 
    // no subtrees have been fully walked.
    //
    // Whenever a node is exited by the walk, the Sum values of 
    // its children are on top of the stack, in order with the last
    // child on top.  To preserve the invariant, we must pop 
    // those child Sum values from the stack, combine them with the
    // appropriate Sum producer, and push back a Sum value 
    // representing the entire subtree under the node.
    //
    // At the end of the walk, after all subtrees have been walked 
    // and the root has been exited, only the entire tree satisfies 
    // the invariant's "fully walked but parent not yet exited" property,
    // so the top of the stack is the Sum of the entire parse tree.
    
    /**
     * Returns the Sum constructed by this object.
     * Requires that this object has completely walked over a Sum parse tree 
     * using ParseTreeWalker.
     * @return Sum for the Sum parse tree that was walked
     */
    public Sum getSum() {
        return stack.get(0);
    }
    
    @Override public void exitRoot(SumParser.RootContext context) {
        // do nothing, root has only one child so its value is 
        // already on top of the stack
    }

    @Override public void exitSum(SumParser.SumContext context) {  
        // matched addend ('+' addend)+
        List<SumParser.AddendContext> addends = context.addend();
        assert stack.size() >= addends.size();
        
        // the pattern above always matches at least 2 addends
        assert addends.size() >= 2;  
        
        // pop the last 2 child addends from the stack and + them together
        Sum right = stack.pop();
        Sum left = stack.pop();
        Sum sum = new Plus(left, right);
        
        // pop the older child addends, one by one, and add them on
        for (int i = 2; i < addends.size(); ++i) {
            sum = new Plus(stack.pop(), sum);
        }
        
        // the result is this subtree's Sum
        stack.push(sum);
    }

    @Override public void exitAddend(SumParser.AddendContext context) {
        if (context.NUMBER() != null) {
            // matched the NUMBER alternative
            int n = Integer.valueOf(context.NUMBER().getText());
            Sum sum = new Number(n);
            stack.push(sum);
        } else {
            // matched the '(' sum ')' alternative
            // do nothing, because sum's value is already on the stack
        }
    }

    // don't need these here, so just make them empty implementations
    @Override public void enterRoot(SumParser.RootContext context) { }
    @Override public void enterSum(SumParser.SumContext context) { }
    @Override public void enterAddend(SumParser.AddendContext context) { }

    @Override public void visitTerminal(TerminalNode terminal) { }
    @Override public void enterEveryRule(ParserRuleContext context) { }
    @Override public void exitEveryRule(ParserRuleContext context) { }
    @Override public void visitErrorNode(ErrorNode node) { }         
}

/** Immutable type representing a sum of integers. */
interface Sum {
    /** @return the computed value of this sum */
    public int value();
}

class Plus implements Sum {
    private final Sum left, right;
    
    /** Make a Plus which is the sum of left and right. */
    public Plus(Sum left, Sum right) {
        this.left = left;
        this.right = right;
    }
    
    @Override public int value() {
        return left.value() + right.value();
    }
    
    @Override public String toString() {
        return "("+left+")+("+right+")";
    }
}

class Number implements Sum {
    private final int n;
    
    /** Make a Number. */
    public Number(int n) {
        this.n = n;
    }
    
    @Override public int value() {
        return n;
    }
    
    @Override public String toString() {
        return String.valueOf(n);
    }
}
