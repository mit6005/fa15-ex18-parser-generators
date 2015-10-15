grammar Sum;

// This puts a package statement at the top of the output Java files.
@header {
package sums;
}

// This adds code to the generated parser. Do not change these lines.
@members {
    // This method makes the parser stop running if it encounters
    // invalid input and throw a RuntimeException.
    public void reportErrorsAsExceptions() {
        //removeErrorListeners();
        
        addErrorListener(new ExceptionThrowingErrorListener());
    }
    
    private static class ExceptionThrowingErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                Object offendingSymbol, int line, int charPositionInLine,
                String msg, RecognitionException e) {
            throw new RuntimeException(msg);
        }
    }
}

/*
 * These are the parser rules. They define the structures used by the parser.
 */
root : sum EOF ;
sum : term ('+' term)+;
term : NUMBER | '(' sum ')' ;
NUMBER : [0-9]+ ;
