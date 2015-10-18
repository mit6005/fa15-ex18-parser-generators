// Generated from Sum.g4 by ANTLR 4.5.1

package sums;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SumParser extends Parser {
    static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
        new PredictionContextCache();
    public static final int
        T__0=1, T__1=2, T__2=3, NUMBER=4;
    public static final int
        RULE_root = 0, RULE_sum = 1, RULE_addend = 2;
    public static final String[] ruleNames = {
        "root", "sum", "addend"
    };

    private static final String[] _LITERAL_NAMES = {
        null, "'+'", "'('", "')'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
        null, null, null, null, "NUMBER"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() { return "Sum.g4"; }

    @Override
    public String[] getRuleNames() { return ruleNames; }

    @Override
    public String getSerializedATN() { return _serializedATN; }

    @Override
    public ATN getATN() { return _ATN; }


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

    public SumParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
    }
    public static class RootContext extends ParserRuleContext {
        public SumContext sum() {
            return getRuleContext(SumContext.class,0);
        }
        public TerminalNode EOF() { return getToken(SumParser.EOF, 0); }
        public RootContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_root; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof SumListener ) ((SumListener)listener).enterRoot(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof SumListener ) ((SumListener)listener).exitRoot(this);
        }
    }

    public final RootContext root() throws RecognitionException {
        RootContext _localctx = new RootContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_root);
        try {
            enterOuterAlt(_localctx, 1);
            {
            setState(6);
            sum();
            setState(7);
            match(EOF);
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SumContext extends ParserRuleContext {
        public List<AddendContext> addend() {
            return getRuleContexts(AddendContext.class);
        }
        public AddendContext addend(int i) {
            return getRuleContext(AddendContext.class,i);
        }
        public SumContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_sum; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof SumListener ) ((SumListener)listener).enterSum(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof SumListener ) ((SumListener)listener).exitSum(this);
        }
    }

    public final SumContext sum() throws RecognitionException {
        SumContext _localctx = new SumContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_sum);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
            setState(9);
            addend();
            setState(12); 
            _errHandler.sync(this);
            _la = _input.LA(1);
            do {
                {
                {
                setState(10);
                match(T__0);
                setState(11);
                addend();
                }
                }
                setState(14); 
                _errHandler.sync(this);
                _la = _input.LA(1);
            } while ( _la==T__0 );
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static class AddendContext extends ParserRuleContext {
        public TerminalNode NUMBER() { return getToken(SumParser.NUMBER, 0); }
        public SumContext sum() {
            return getRuleContext(SumContext.class,0);
        }
        public AddendContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }
        @Override public int getRuleIndex() { return RULE_addend; }
        @Override
        public void enterRule(ParseTreeListener listener) {
            if ( listener instanceof SumListener ) ((SumListener)listener).enterAddend(this);
        }
        @Override
        public void exitRule(ParseTreeListener listener) {
            if ( listener instanceof SumListener ) ((SumListener)listener).exitAddend(this);
        }
    }

    public final AddendContext addend() throws RecognitionException {
        AddendContext _localctx = new AddendContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_addend);
        try {
            setState(21);
            switch (_input.LA(1)) {
            case NUMBER:
                enterOuterAlt(_localctx, 1);
                {
                setState(16);
                match(NUMBER);
                }
                break;
            case T__1:
                enterOuterAlt(_localctx, 2);
                {
                setState(17);
                match(T__1);
                setState(18);
                sum();
                setState(19);
                match(T__2);
                }
                break;
            default:
                throw new NoViableAltException(this);
            }
        }
        catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        }
        finally {
            exitRule();
        }
        return _localctx;
    }

    public static final String _serializedATN =
        "\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\6\32\4\2\t\2\4\3"+
        "\t\3\4\4\t\4\3\2\3\2\3\2\3\3\3\3\3\3\6\3\17\n\3\r\3\16\3\20\3\4\3\4\3"+
        "\4\3\4\3\4\5\4\30\n\4\3\4\2\2\5\2\4\6\2\2\30\2\b\3\2\2\2\4\13\3\2\2\2"+
        "\6\27\3\2\2\2\b\t\5\4\3\2\t\n\7\2\2\3\n\3\3\2\2\2\13\16\5\6\4\2\f\r\7"+
        "\3\2\2\r\17\5\6\4\2\16\f\3\2\2\2\17\20\3\2\2\2\20\16\3\2\2\2\20\21\3\2"+
        "\2\2\21\5\3\2\2\2\22\30\7\6\2\2\23\24\7\4\2\2\24\25\5\4\3\2\25\26\7\5"+
        "\2\2\26\30\3\2\2\2\27\22\3\2\2\2\27\23\3\2\2\2\30\7\3\2\2\2\4\20\27";
    public static final ATN _ATN =
        new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}