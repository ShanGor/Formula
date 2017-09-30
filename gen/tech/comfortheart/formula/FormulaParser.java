// Generated from C:/temp/formula/src/main/resources\Formula.g4 by ANTLR 4.7
package tech.comfortheart.formula;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormulaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, ID=8, NUMBER=9, 
		STRING=10, NEWLINE=11, WS=12, POW=13, MUL=14, MOD=15, DIV=16, ADD=17, 
		SUB=18, GT=19, GE=20, LT=21, LE=22, EQ=23, NE=24;
	public static final int
		RULE_formula = 0, RULE_stat = 1, RULE_expr = 2, RULE_condition = 3, RULE_functionDefinition = 4, 
		RULE_paramsDef = 5, RULE_functionBody = 6, RULE_functionPredefinition = 7, 
		RULE_paramsPredefine = 8, RULE_functionInvoke = 9, RULE_params = 10, RULE_param = 11;
	public static final String[] ruleNames = {
		"formula", "stat", "expr", "condition", "functionDefinition", "paramsDef", 
		"functionBody", "functionPredefinition", "paramsPredefine", "functionInvoke", 
		"params", "param"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'('", "')'", "'not'", "'and'", "'or'", "','", null, null, 
		null, "'\n'", null, "'^'", "'*'", "'%'", "'/'", "'+'", "'-'", "'>'", null, 
		"'<'", null, "'=='", "'<>'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "ID", "NUMBER", "STRING", 
		"NEWLINE", "WS", "POW", "MUL", "MOD", "DIV", "ADD", "SUB", "GT", "GE", 
		"LT", "LE", "EQ", "NE"
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
	public String getGrammarFileName() { return "Formula.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FormulaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class FormulaContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public FormulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterFormula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitFormula(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitFormula(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormulaContext formula() throws RecognitionException {
		FormulaContext _localctx = new FormulaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_formula);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24);
				stat();
				}
				}
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID );
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

	public static class StatContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(FormulaParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(FormulaParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FormulaParser.NEWLINE, i);
		}
		public FunctionDefinitionContext functionDefinition() {
			return getRuleContext(FunctionDefinitionContext.class,0);
		}
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public FunctionPredefinitionContext functionPredefinition() {
			return getRuleContext(FunctionPredefinitionContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		int _la;
		try {
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				match(ID);
				setState(30);
				match(T__0);
				setState(31);
				expr(0);
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(32);
					match(NEWLINE);
					}
					}
					setState(37);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				functionDefinition();
				setState(39);
				match(T__0);
				setState(40);
				functionBody();
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(41);
					match(NEWLINE);
					}
					}
					setState(46);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(47);
				functionPredefinition();
				setState(48);
				match(T__0);
				setState(49);
				expr(0);
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NEWLINE) {
					{
					{
					setState(50);
					match(NEWLINE);
					}
					}
					setState(55);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddMinusContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ADD() { return getToken(FormulaParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(FormulaParser.SUB, 0); }
		public AddMinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterAddMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitAddMinus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitAddMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegativeContext extends ExprContext {
		public TerminalNode NUMBER() { return getToken(FormulaParser.NUMBER, 0); }
		public NegativeContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterNegative(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitNegative(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitNegative(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumberContext extends ExprContext {
		public TerminalNode NUMBER() { return getToken(FormulaParser.NUMBER, 0); }
		public NumberContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MultDivModContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(FormulaParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(FormulaParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(FormulaParser.MOD, 0); }
		public MultDivModContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterMultDivMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitMultDivMod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitMultDivMod(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCallContext extends ExprContext {
		public FunctionInvokeContext functionInvoke() {
			return getRuleContext(FunctionInvokeContext.class,0);
		}
		public FunctionCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode POW() { return getToken(FormulaParser.POW, 0); }
		public PowContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterPow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitPow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitPow(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdContext extends ExprContext {
		public TerminalNode ID() { return getToken(FormulaParser.ID, 0); }
		public IdContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(FormulaParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprParenthesesContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprParenthesesContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterExprParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitExprParentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitExprParentheses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				_localctx = new NegativeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(59);
				match(SUB);
				setState(60);
				match(NUMBER);
				}
				break;
			case 2:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(61);
				match(NUMBER);
				}
				break;
			case 3:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(62);
				match(ID);
				}
				break;
			case 4:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63);
				match(STRING);
				}
				break;
			case 5:
				{
				_localctx = new FunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(64);
				functionInvoke();
				}
				break;
			case 6:
				{
				_localctx = new ExprParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(65);
				match(T__1);
				setState(66);
				expr(0);
				setState(67);
				match(T__2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(82);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(80);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new PowContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(71);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(72);
						match(POW);
						setState(73);
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new MultDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(74);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(75);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << MOD) | (1L << DIV))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(76);
						expr(8);
						}
						break;
					case 3:
						{
						_localctx = new AddMinusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(77);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(78);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(79);
						expr(7);
						}
						break;
					}
					} 
				}
				setState(84);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	 
		public ConditionContext() { }
		public void copyFrom(ConditionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConditionJointAndOrContext extends ConditionContext {
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public ConditionJointAndOrContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterConditionJointAndOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitConditionJointAndOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitConditionJointAndOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionExprContext extends ConditionContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LT() { return getToken(FormulaParser.LT, 0); }
		public TerminalNode GT() { return getToken(FormulaParser.GT, 0); }
		public TerminalNode LE() { return getToken(FormulaParser.LE, 0); }
		public TerminalNode GE() { return getToken(FormulaParser.GE, 0); }
		public TerminalNode EQ() { return getToken(FormulaParser.EQ, 0); }
		public TerminalNode NE() { return getToken(FormulaParser.NE, 0); }
		public ConditionExprContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterConditionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitConditionExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitConditionExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionJointNotContext extends ConditionContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ConditionJointNotContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterConditionJointNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitConditionJointNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitConditionJointNot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionParenthesesContext extends ConditionContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ConditionParenthesesContext(ConditionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterConditionParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitConditionParentheses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitConditionParentheses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_condition, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new ConditionJointNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(86);
				match(T__3);
				setState(87);
				condition(4);
				}
				break;
			case 2:
				{
				_localctx = new ConditionExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				expr(0);
				setState(89);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << GE) | (1L << LT) | (1L << LE) | (1L << EQ) | (1L << NE))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(90);
				expr(0);
				}
				break;
			case 3:
				{
				_localctx = new ConditionParenthesesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92);
				match(T__1);
				setState(93);
				condition(0);
				setState(94);
				match(T__2);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionJointAndOrContext(new ConditionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_condition);
					setState(98);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(99);
					_la = _input.LA(1);
					if ( !(_la==T__4 || _la==T__5) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(100);
					condition(3);
					}
					} 
				}
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FunctionDefinitionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(FormulaParser.ID, 0); }
		public ParamsDefContext paramsDef() {
			return getRuleContext(ParamsDefContext.class,0);
		}
		public FunctionDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterFunctionDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitFunctionDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitFunctionDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefinitionContext functionDefinition() throws RecognitionException {
		FunctionDefinitionContext _localctx = new FunctionDefinitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(ID);
			setState(107);
			match(T__1);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(108);
				paramsDef();
				}
			}

			setState(111);
			match(T__2);
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

	public static class ParamsDefContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(FormulaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FormulaParser.ID, i);
		}
		public ParamsDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramsDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterParamsDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitParamsDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitParamsDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsDefContext paramsDef() throws RecognitionException {
		ParamsDefContext _localctx = new ParamsDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_paramsDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(ID);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(114);
				match(T__6);
				setState(115);
				match(ID);
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class FunctionBodyContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterFunctionBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitFunctionBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitFunctionBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionBodyContext functionBody() throws RecognitionException {
		FunctionBodyContext _localctx = new FunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			expr(0);
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

	public static class FunctionPredefinitionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(FormulaParser.ID, 0); }
		public ParamsPredefineContext paramsPredefine() {
			return getRuleContext(ParamsPredefineContext.class,0);
		}
		public FunctionPredefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionPredefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterFunctionPredefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitFunctionPredefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitFunctionPredefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionPredefinitionContext functionPredefinition() throws RecognitionException {
		FunctionPredefinitionContext _localctx = new FunctionPredefinitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionPredefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(ID);
			setState(124);
			match(T__1);
			setState(125);
			paramsPredefine();
			setState(126);
			match(T__2);
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

	public static class ParamsPredefineContext extends ParserRuleContext {
		public List<TerminalNode> NUMBER() { return getTokens(FormulaParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(FormulaParser.NUMBER, i);
		}
		public List<TerminalNode> STRING() { return getTokens(FormulaParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(FormulaParser.STRING, i);
		}
		public ParamsPredefineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramsPredefine; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterParamsPredefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitParamsPredefine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitParamsPredefine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsPredefineContext paramsPredefine() throws RecognitionException {
		ParamsPredefineContext _localctx = new ParamsPredefineContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_paramsPredefine);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_la = _input.LA(1);
			if ( !(_la==NUMBER || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(129);
				match(T__6);
				setState(130);
				_la = _input.LA(1);
				if ( !(_la==NUMBER || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class FunctionInvokeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(FormulaParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FunctionInvokeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionInvoke; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterFunctionInvoke(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitFunctionInvoke(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitFunctionInvoke(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionInvokeContext functionInvoke() throws RecognitionException {
		FunctionInvokeContext _localctx = new FunctionInvokeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_functionInvoke);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(ID);
			setState(137);
			match(T__1);
			setState(138);
			params();
			setState(139);
			match(T__2);
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

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			param();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(142);
				match(T__6);
				setState(143);
				param();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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

	public static class ParamContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof FormulaListener ) ((FormulaListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof FormulaVisitor ) return ((FormulaVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_param);
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				condition(0);
				}
				break;
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 3:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\32\u009c\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\6\2\34\n\2\r\2\16\2\35\3\3\3\3\3\3\3\3\7\3$"+
		"\n\3\f\3\16\3\'\13\3\3\3\3\3\3\3\3\3\7\3-\n\3\f\3\16\3\60\13\3\3\3\3\3"+
		"\3\3\3\3\7\3\66\n\3\f\3\16\39\13\3\5\3;\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\5\4H\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4S\n"+
		"\4\f\4\16\4V\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5c\n\5"+
		"\3\5\3\5\3\5\7\5h\n\5\f\5\16\5k\13\5\3\6\3\6\3\6\5\6p\n\6\3\6\3\6\3\7"+
		"\3\7\3\7\7\7w\n\7\f\7\16\7z\13\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\7\n\u0086\n\n\f\n\16\n\u0089\13\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\7\f\u0093\n\f\f\f\16\f\u0096\13\f\3\r\3\r\5\r\u009a\n\r\3\r\2\4\6"+
		"\b\16\2\4\6\b\n\f\16\20\22\24\26\30\2\7\3\2\20\22\3\2\23\24\3\2\25\32"+
		"\3\2\7\b\3\2\13\f\2\u00a5\2\33\3\2\2\2\4:\3\2\2\2\6G\3\2\2\2\bb\3\2\2"+
		"\2\nl\3\2\2\2\fs\3\2\2\2\16{\3\2\2\2\20}\3\2\2\2\22\u0082\3\2\2\2\24\u008a"+
		"\3\2\2\2\26\u008f\3\2\2\2\30\u0099\3\2\2\2\32\34\5\4\3\2\33\32\3\2\2\2"+
		"\34\35\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\3\3\2\2\2\37 \7\n\2\2 !"+
		"\7\3\2\2!%\5\6\4\2\"$\7\r\2\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2"+
		"\2&;\3\2\2\2\'%\3\2\2\2()\5\n\6\2)*\7\3\2\2*.\5\16\b\2+-\7\r\2\2,+\3\2"+
		"\2\2-\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/;\3\2\2\2\60.\3\2\2\2\61\62\5\20"+
		"\t\2\62\63\7\3\2\2\63\67\5\6\4\2\64\66\7\r\2\2\65\64\3\2\2\2\669\3\2\2"+
		"\2\67\65\3\2\2\2\678\3\2\2\28;\3\2\2\29\67\3\2\2\2:\37\3\2\2\2:(\3\2\2"+
		"\2:\61\3\2\2\2;\5\3\2\2\2<=\b\4\1\2=>\7\24\2\2>H\7\13\2\2?H\7\13\2\2@"+
		"H\7\n\2\2AH\7\f\2\2BH\5\24\13\2CD\7\4\2\2DE\5\6\4\2EF\7\5\2\2FH\3\2\2"+
		"\2G<\3\2\2\2G?\3\2\2\2G@\3\2\2\2GA\3\2\2\2GB\3\2\2\2GC\3\2\2\2HT\3\2\2"+
		"\2IJ\f\n\2\2JK\7\17\2\2KS\5\6\4\13LM\f\t\2\2MN\t\2\2\2NS\5\6\4\nOP\f\b"+
		"\2\2PQ\t\3\2\2QS\5\6\4\tRI\3\2\2\2RL\3\2\2\2RO\3\2\2\2SV\3\2\2\2TR\3\2"+
		"\2\2TU\3\2\2\2U\7\3\2\2\2VT\3\2\2\2WX\b\5\1\2XY\7\6\2\2Yc\5\b\5\6Z[\5"+
		"\6\4\2[\\\t\4\2\2\\]\5\6\4\2]c\3\2\2\2^_\7\4\2\2_`\5\b\5\2`a\7\5\2\2a"+
		"c\3\2\2\2bW\3\2\2\2bZ\3\2\2\2b^\3\2\2\2ci\3\2\2\2de\f\4\2\2ef\t\5\2\2"+
		"fh\5\b\5\5gd\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\t\3\2\2\2ki\3\2\2"+
		"\2lm\7\n\2\2mo\7\4\2\2np\5\f\7\2on\3\2\2\2op\3\2\2\2pq\3\2\2\2qr\7\5\2"+
		"\2r\13\3\2\2\2sx\7\n\2\2tu\7\t\2\2uw\7\n\2\2vt\3\2\2\2wz\3\2\2\2xv\3\2"+
		"\2\2xy\3\2\2\2y\r\3\2\2\2zx\3\2\2\2{|\5\6\4\2|\17\3\2\2\2}~\7\n\2\2~\177"+
		"\7\4\2\2\177\u0080\5\22\n\2\u0080\u0081\7\5\2\2\u0081\21\3\2\2\2\u0082"+
		"\u0087\t\6\2\2\u0083\u0084\7\t\2\2\u0084\u0086\t\6\2\2\u0085\u0083\3\2"+
		"\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088"+
		"\23\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\7\n\2\2\u008b\u008c\7\4\2"+
		"\2\u008c\u008d\5\26\f\2\u008d\u008e\7\5\2\2\u008e\25\3\2\2\2\u008f\u0094"+
		"\5\30\r\2\u0090\u0091\7\t\2\2\u0091\u0093\5\30\r\2\u0092\u0090\3\2\2\2"+
		"\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\27"+
		"\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u009a\5\6\4\2\u0098\u009a\5\b\5\2\u0099"+
		"\u0097\3\2\2\2\u0099\u0098\3\2\2\2\u009a\31\3\2\2\2\21\35%.\67:GRTbio"+
		"x\u0087\u0094\u0099";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}