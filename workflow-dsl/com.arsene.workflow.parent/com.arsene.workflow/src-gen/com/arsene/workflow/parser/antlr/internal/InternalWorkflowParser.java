package com.arsene.workflow.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.arsene.workflow.services.WorkflowGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalWorkflowParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Workflow'", "'type:'", "'{'", "'}'", "'step'", "'Execute'", "'()'", "'function'", "'('", "','", "')'", "'return'", "'call'", "'service'", "'if'", "'else'", "'loop:'", "'boolean'", "'number'", "'string'", "':'", "'Define'", "'['", "']'", "'='", "'var'", "'Artifact'", "'Event'", "'print'", "'or'", "'and'", "'=='", "'!='", "'>='", "'<='", "'>'", "'<'", "'+'", "'-'", "'%'", "'*'", "'/'", "'^'", "'!'", "'true'", "'false'", "'sequence'", "'parallel'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalWorkflowParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalWorkflowParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalWorkflowParser.tokenNames; }
    public String getGrammarFileName() { return "InternalWorkflow.g"; }



     	private WorkflowGrammarAccess grammarAccess;

        public InternalWorkflowParser(TokenStream input, WorkflowGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "WorkflowProgramModel";
       	}

       	@Override
       	protected WorkflowGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleWorkflowProgramModel"
    // InternalWorkflow.g:65:1: entryRuleWorkflowProgramModel returns [EObject current=null] : iv_ruleWorkflowProgramModel= ruleWorkflowProgramModel EOF ;
    public final EObject entryRuleWorkflowProgramModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkflowProgramModel = null;


        try {
            // InternalWorkflow.g:65:61: (iv_ruleWorkflowProgramModel= ruleWorkflowProgramModel EOF )
            // InternalWorkflow.g:66:2: iv_ruleWorkflowProgramModel= ruleWorkflowProgramModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWorkflowProgramModelRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleWorkflowProgramModel=ruleWorkflowProgramModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWorkflowProgramModel; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWorkflowProgramModel"


    // $ANTLR start "ruleWorkflowProgramModel"
    // InternalWorkflow.g:72:1: ruleWorkflowProgramModel returns [EObject current=null] : ( (lv_features_0_0= ruleFeature ) )* ;
    public final EObject ruleWorkflowProgramModel() throws RecognitionException {
        EObject current = null;

        EObject lv_features_0_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:78:2: ( ( (lv_features_0_0= ruleFeature ) )* )
            // InternalWorkflow.g:79:2: ( (lv_features_0_0= ruleFeature ) )*
            {
            // InternalWorkflow.g:79:2: ( (lv_features_0_0= ruleFeature ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||LA1_0==11||LA1_0==18||LA1_0==23||LA1_0==25||(LA1_0>=27 && LA1_0<=30)||LA1_0==32||(LA1_0>=36 && LA1_0<=39)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalWorkflow.g:80:3: (lv_features_0_0= ruleFeature )
            	    {
            	    // InternalWorkflow.g:80:3: (lv_features_0_0= ruleFeature )
            	    // InternalWorkflow.g:81:4: lv_features_0_0= ruleFeature
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getWorkflowProgramModelAccess().getFeaturesFeatureParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_features_0_0=ruleFeature();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElementForParent(grammarAccess.getWorkflowProgramModelRule());
            	      				}
            	      				add(
            	      					current,
            	      					"features",
            	      					lv_features_0_0,
            	      					"com.arsene.workflow.Workflow.Feature");
            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWorkflowProgramModel"


    // $ANTLR start "entryRuleFeature"
    // InternalWorkflow.g:101:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // InternalWorkflow.g:101:48: (iv_ruleFeature= ruleFeature EOF )
            // InternalWorkflow.g:102:2: iv_ruleFeature= ruleFeature EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeature=ruleFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeature; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeature"


    // $ANTLR start "ruleFeature"
    // InternalWorkflow.g:108:1: ruleFeature returns [EObject current=null] : ( ( (lv_statement_0_0= ruleStatement ) ) | ( (lv_Method_1_0= ruleMethod ) ) | ( (lv_workflow_2_0= ruleWorkflow ) ) ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        EObject lv_statement_0_0 = null;

        EObject lv_Method_1_0 = null;

        EObject lv_workflow_2_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:114:2: ( ( ( (lv_statement_0_0= ruleStatement ) ) | ( (lv_Method_1_0= ruleMethod ) ) | ( (lv_workflow_2_0= ruleWorkflow ) ) ) )
            // InternalWorkflow.g:115:2: ( ( (lv_statement_0_0= ruleStatement ) ) | ( (lv_Method_1_0= ruleMethod ) ) | ( (lv_workflow_2_0= ruleWorkflow ) ) )
            {
            // InternalWorkflow.g:115:2: ( ( (lv_statement_0_0= ruleStatement ) ) | ( (lv_Method_1_0= ruleMethod ) ) | ( (lv_workflow_2_0= ruleWorkflow ) ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case 23:
            case 25:
            case 27:
            case 28:
            case 29:
            case 30:
            case 32:
            case 36:
            case 37:
            case 38:
            case 39:
                {
                alt2=1;
                }
                break;
            case 18:
                {
                alt2=2;
                }
                break;
            case 11:
                {
                alt2=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalWorkflow.g:116:3: ( (lv_statement_0_0= ruleStatement ) )
                    {
                    // InternalWorkflow.g:116:3: ( (lv_statement_0_0= ruleStatement ) )
                    // InternalWorkflow.g:117:4: (lv_statement_0_0= ruleStatement )
                    {
                    // InternalWorkflow.g:117:4: (lv_statement_0_0= ruleStatement )
                    // InternalWorkflow.g:118:5: lv_statement_0_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFeatureAccess().getStatementStatementParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_statement_0_0=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFeatureRule());
                      					}
                      					set(
                      						current,
                      						"statement",
                      						lv_statement_0_0,
                      						"com.arsene.workflow.Workflow.Statement");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:136:3: ( (lv_Method_1_0= ruleMethod ) )
                    {
                    // InternalWorkflow.g:136:3: ( (lv_Method_1_0= ruleMethod ) )
                    // InternalWorkflow.g:137:4: (lv_Method_1_0= ruleMethod )
                    {
                    // InternalWorkflow.g:137:4: (lv_Method_1_0= ruleMethod )
                    // InternalWorkflow.g:138:5: lv_Method_1_0= ruleMethod
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFeatureAccess().getMethodMethodParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_Method_1_0=ruleMethod();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFeatureRule());
                      					}
                      					set(
                      						current,
                      						"Method",
                      						lv_Method_1_0,
                      						"com.arsene.workflow.Workflow.Method");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:156:3: ( (lv_workflow_2_0= ruleWorkflow ) )
                    {
                    // InternalWorkflow.g:156:3: ( (lv_workflow_2_0= ruleWorkflow ) )
                    // InternalWorkflow.g:157:4: (lv_workflow_2_0= ruleWorkflow )
                    {
                    // InternalWorkflow.g:157:4: (lv_workflow_2_0= ruleWorkflow )
                    // InternalWorkflow.g:158:5: lv_workflow_2_0= ruleWorkflow
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getFeatureAccess().getWorkflowWorkflowParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_workflow_2_0=ruleWorkflow();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getFeatureRule());
                      					}
                      					set(
                      						current,
                      						"workflow",
                      						lv_workflow_2_0,
                      						"com.arsene.workflow.Workflow.Workflow");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeature"


    // $ANTLR start "entryRuleWorkflow"
    // InternalWorkflow.g:179:1: entryRuleWorkflow returns [EObject current=null] : iv_ruleWorkflow= ruleWorkflow EOF ;
    public final EObject entryRuleWorkflow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWorkflow = null;


        try {
            // InternalWorkflow.g:179:49: (iv_ruleWorkflow= ruleWorkflow EOF )
            // InternalWorkflow.g:180:2: iv_ruleWorkflow= ruleWorkflow EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWorkflowRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleWorkflow=ruleWorkflow();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWorkflow; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWorkflow"


    // $ANTLR start "ruleWorkflow"
    // InternalWorkflow.g:186:1: ruleWorkflow returns [EObject current=null] : (otherlv_0= 'Workflow' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'type:' ( (lv_type_3_0= ruleWorkflowType ) ) )? otherlv_4= '{' ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' ( (lv_execute_7_0= ruleExecute ) ) ) ;
    public final EObject ruleWorkflow() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_type_3_0 = null;

        EObject lv_steps_5_0 = null;

        EObject lv_execute_7_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:192:2: ( (otherlv_0= 'Workflow' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'type:' ( (lv_type_3_0= ruleWorkflowType ) ) )? otherlv_4= '{' ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' ( (lv_execute_7_0= ruleExecute ) ) ) )
            // InternalWorkflow.g:193:2: (otherlv_0= 'Workflow' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'type:' ( (lv_type_3_0= ruleWorkflowType ) ) )? otherlv_4= '{' ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' ( (lv_execute_7_0= ruleExecute ) ) )
            {
            // InternalWorkflow.g:193:2: (otherlv_0= 'Workflow' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'type:' ( (lv_type_3_0= ruleWorkflowType ) ) )? otherlv_4= '{' ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' ( (lv_execute_7_0= ruleExecute ) ) )
            // InternalWorkflow.g:194:3: otherlv_0= 'Workflow' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'type:' ( (lv_type_3_0= ruleWorkflowType ) ) )? otherlv_4= '{' ( (lv_steps_5_0= ruleStep ) )* otherlv_6= '}' ( (lv_execute_7_0= ruleExecute ) )
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getWorkflowAccess().getWorkflowKeyword_0());
              		
            }
            // InternalWorkflow.g:198:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:199:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:199:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:200:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getWorkflowAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getWorkflowRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalWorkflow.g:216:3: (otherlv_2= 'type:' ( (lv_type_3_0= ruleWorkflowType ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalWorkflow.g:217:4: otherlv_2= 'type:' ( (lv_type_3_0= ruleWorkflowType ) )
                    {
                    otherlv_2=(Token)match(input,12,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getWorkflowAccess().getTypeKeyword_2_0());
                      			
                    }
                    // InternalWorkflow.g:221:4: ( (lv_type_3_0= ruleWorkflowType ) )
                    // InternalWorkflow.g:222:5: (lv_type_3_0= ruleWorkflowType )
                    {
                    // InternalWorkflow.g:222:5: (lv_type_3_0= ruleWorkflowType )
                    // InternalWorkflow.g:223:6: lv_type_3_0= ruleWorkflowType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getWorkflowAccess().getTypeWorkflowTypeEnumRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_7);
                    lv_type_3_0=ruleWorkflowType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getWorkflowRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_3_0,
                      							"com.arsene.workflow.Workflow.WorkflowType");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,13,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getWorkflowAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalWorkflow.g:245:3: ( (lv_steps_5_0= ruleStep ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalWorkflow.g:246:4: (lv_steps_5_0= ruleStep )
            	    {
            	    // InternalWorkflow.g:246:4: (lv_steps_5_0= ruleStep )
            	    // InternalWorkflow.g:247:5: lv_steps_5_0= ruleStep
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getWorkflowAccess().getStepsStepParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_steps_5_0=ruleStep();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getWorkflowRule());
            	      					}
            	      					add(
            	      						current,
            	      						"steps",
            	      						lv_steps_5_0,
            	      						"com.arsene.workflow.Workflow.Step");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getWorkflowAccess().getRightCurlyBracketKeyword_5());
              		
            }
            // InternalWorkflow.g:268:3: ( (lv_execute_7_0= ruleExecute ) )
            // InternalWorkflow.g:269:4: (lv_execute_7_0= ruleExecute )
            {
            // InternalWorkflow.g:269:4: (lv_execute_7_0= ruleExecute )
            // InternalWorkflow.g:270:5: lv_execute_7_0= ruleExecute
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getWorkflowAccess().getExecuteExecuteParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_execute_7_0=ruleExecute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getWorkflowRule());
              					}
              					set(
              						current,
              						"execute",
              						lv_execute_7_0,
              						"com.arsene.workflow.Workflow.Execute");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWorkflow"


    // $ANTLR start "entryRuleStep"
    // InternalWorkflow.g:291:1: entryRuleStep returns [EObject current=null] : iv_ruleStep= ruleStep EOF ;
    public final EObject entryRuleStep() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStep = null;


        try {
            // InternalWorkflow.g:291:45: (iv_ruleStep= ruleStep EOF )
            // InternalWorkflow.g:292:2: iv_ruleStep= ruleStep EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStepRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStep=ruleStep();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStep; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStep"


    // $ANTLR start "ruleStep"
    // InternalWorkflow.g:298:1: ruleStep returns [EObject current=null] : (otherlv_0= 'step' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_body_2_0= ruleBlock ) ) ) ;
    public final EObject ruleStep() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:304:2: ( (otherlv_0= 'step' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_body_2_0= ruleBlock ) ) ) )
            // InternalWorkflow.g:305:2: (otherlv_0= 'step' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_body_2_0= ruleBlock ) ) )
            {
            // InternalWorkflow.g:305:2: (otherlv_0= 'step' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_body_2_0= ruleBlock ) ) )
            // InternalWorkflow.g:306:3: otherlv_0= 'step' ( (lv_name_1_0= RULE_STRING ) ) ( (lv_body_2_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStepAccess().getStepKeyword_0());
              		
            }
            // InternalWorkflow.g:310:3: ( (lv_name_1_0= RULE_STRING ) )
            // InternalWorkflow.g:311:4: (lv_name_1_0= RULE_STRING )
            {
            // InternalWorkflow.g:311:4: (lv_name_1_0= RULE_STRING )
            // InternalWorkflow.g:312:5: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)match(input,RULE_STRING,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getStepAccess().getNameSTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStepRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.STRING");
              				
            }

            }


            }

            // InternalWorkflow.g:328:3: ( (lv_body_2_0= ruleBlock ) )
            // InternalWorkflow.g:329:4: (lv_body_2_0= ruleBlock )
            {
            // InternalWorkflow.g:329:4: (lv_body_2_0= ruleBlock )
            // InternalWorkflow.g:330:5: lv_body_2_0= ruleBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getStepAccess().getBodyBlockParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_2_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getStepRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_2_0,
              						"com.arsene.workflow.Workflow.Block");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStep"


    // $ANTLR start "entryRuleExecute"
    // InternalWorkflow.g:351:1: entryRuleExecute returns [EObject current=null] : iv_ruleExecute= ruleExecute EOF ;
    public final EObject entryRuleExecute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecute = null;


        try {
            // InternalWorkflow.g:351:48: (iv_ruleExecute= ruleExecute EOF )
            // InternalWorkflow.g:352:2: iv_ruleExecute= ruleExecute EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExecuteRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExecute=ruleExecute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExecute; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExecute"


    // $ANTLR start "ruleExecute"
    // InternalWorkflow.g:358:1: ruleExecute returns [EObject current=null] : (otherlv_0= 'Execute' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()' ) ;
    public final EObject ruleExecute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalWorkflow.g:364:2: ( (otherlv_0= 'Execute' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()' ) )
            // InternalWorkflow.g:365:2: (otherlv_0= 'Execute' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()' )
            {
            // InternalWorkflow.g:365:2: (otherlv_0= 'Execute' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()' )
            // InternalWorkflow.g:366:3: otherlv_0= 'Execute' ( (otherlv_1= RULE_ID ) ) otherlv_2= '()'
            {
            otherlv_0=(Token)match(input,16,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getExecuteAccess().getExecuteKeyword_0());
              		
            }
            // InternalWorkflow.g:370:3: ( (otherlv_1= RULE_ID ) )
            // InternalWorkflow.g:371:4: (otherlv_1= RULE_ID )
            {
            // InternalWorkflow.g:371:4: (otherlv_1= RULE_ID )
            // InternalWorkflow.g:372:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getExecuteRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getExecuteAccess().getWorkflowWorkflowCrossReference_1_0());
              				
            }

            }


            }

            otherlv_2=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getExecuteAccess().getLeftParenthesisRightParenthesisKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExecute"


    // $ANTLR start "entryRuleMethod"
    // InternalWorkflow.g:391:1: entryRuleMethod returns [EObject current=null] : iv_ruleMethod= ruleMethod EOF ;
    public final EObject entryRuleMethod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethod = null;


        try {
            // InternalWorkflow.g:391:47: (iv_ruleMethod= ruleMethod EOF )
            // InternalWorkflow.g:392:2: iv_ruleMethod= ruleMethod EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMethodRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMethod=ruleMethod();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMethod; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMethod"


    // $ANTLR start "ruleMethod"
    // InternalWorkflow.g:398:1: ruleMethod returns [EObject current=null] : (otherlv_0= 'function' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '(' ( ( (lv_params_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleVariable ) ) )* )? otherlv_6= ')' ) | otherlv_7= '()' ) ( (lv_body_8_0= ruleBlock ) ) ) ;
    public final EObject ruleMethod() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_params_3_0 = null;

        EObject lv_params_5_0 = null;

        EObject lv_body_8_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:404:2: ( (otherlv_0= 'function' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '(' ( ( (lv_params_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleVariable ) ) )* )? otherlv_6= ')' ) | otherlv_7= '()' ) ( (lv_body_8_0= ruleBlock ) ) ) )
            // InternalWorkflow.g:405:2: (otherlv_0= 'function' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '(' ( ( (lv_params_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleVariable ) ) )* )? otherlv_6= ')' ) | otherlv_7= '()' ) ( (lv_body_8_0= ruleBlock ) ) )
            {
            // InternalWorkflow.g:405:2: (otherlv_0= 'function' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '(' ( ( (lv_params_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleVariable ) ) )* )? otherlv_6= ')' ) | otherlv_7= '()' ) ( (lv_body_8_0= ruleBlock ) ) )
            // InternalWorkflow.g:406:3: otherlv_0= 'function' ( (lv_name_1_0= RULE_ID ) ) ( (otherlv_2= '(' ( ( (lv_params_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleVariable ) ) )* )? otherlv_6= ')' ) | otherlv_7= '()' ) ( (lv_body_8_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getMethodAccess().getFunctionKeyword_0());
              		
            }
            // InternalWorkflow.g:410:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:411:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:411:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:412:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getMethodAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getMethodRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalWorkflow.g:428:3: ( (otherlv_2= '(' ( ( (lv_params_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleVariable ) ) )* )? otherlv_6= ')' ) | otherlv_7= '()' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==19) ) {
                alt7=1;
            }
            else if ( (LA7_0==17) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalWorkflow.g:429:4: (otherlv_2= '(' ( ( (lv_params_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleVariable ) ) )* )? otherlv_6= ')' )
                    {
                    // InternalWorkflow.g:429:4: (otherlv_2= '(' ( ( (lv_params_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleVariable ) ) )* )? otherlv_6= ')' )
                    // InternalWorkflow.g:430:5: otherlv_2= '(' ( ( (lv_params_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleVariable ) ) )* )? otherlv_6= ')'
                    {
                    otherlv_2=(Token)match(input,19,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getMethodAccess().getLeftParenthesisKeyword_2_0_0());
                      				
                    }
                    // InternalWorkflow.g:434:5: ( ( (lv_params_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleVariable ) ) )* )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( ((LA6_0>=28 && LA6_0<=30)||LA6_0==32||(LA6_0>=36 && LA6_0<=38)) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalWorkflow.g:435:6: ( (lv_params_3_0= ruleVariable ) ) (otherlv_4= ',' ( (lv_params_5_0= ruleVariable ) ) )*
                            {
                            // InternalWorkflow.g:435:6: ( (lv_params_3_0= ruleVariable ) )
                            // InternalWorkflow.g:436:7: (lv_params_3_0= ruleVariable )
                            {
                            // InternalWorkflow.g:436:7: (lv_params_3_0= ruleVariable )
                            // InternalWorkflow.g:437:8: lv_params_3_0= ruleVariable
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getMethodAccess().getParamsVariableParserRuleCall_2_0_1_0_0());
                              							
                            }
                            pushFollow(FOLLOW_14);
                            lv_params_3_0=ruleVariable();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getMethodRule());
                              								}
                              								add(
                              									current,
                              									"params",
                              									lv_params_3_0,
                              									"com.arsene.workflow.Workflow.Variable");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }

                            // InternalWorkflow.g:454:6: (otherlv_4= ',' ( (lv_params_5_0= ruleVariable ) ) )*
                            loop5:
                            do {
                                int alt5=2;
                                int LA5_0 = input.LA(1);

                                if ( (LA5_0==20) ) {
                                    alt5=1;
                                }


                                switch (alt5) {
                            	case 1 :
                            	    // InternalWorkflow.g:455:7: otherlv_4= ',' ( (lv_params_5_0= ruleVariable ) )
                            	    {
                            	    otherlv_4=(Token)match(input,20,FOLLOW_15); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_4, grammarAccess.getMethodAccess().getCommaKeyword_2_0_1_1_0());
                            	      						
                            	    }
                            	    // InternalWorkflow.g:459:7: ( (lv_params_5_0= ruleVariable ) )
                            	    // InternalWorkflow.g:460:8: (lv_params_5_0= ruleVariable )
                            	    {
                            	    // InternalWorkflow.g:460:8: (lv_params_5_0= ruleVariable )
                            	    // InternalWorkflow.g:461:9: lv_params_5_0= ruleVariable
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getMethodAccess().getParamsVariableParserRuleCall_2_0_1_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_14);
                            	    lv_params_5_0=ruleVariable();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									if (current==null) {
                            	      										current = createModelElementForParent(grammarAccess.getMethodRule());
                            	      									}
                            	      									add(
                            	      										current,
                            	      										"params",
                            	      										lv_params_5_0,
                            	      										"com.arsene.workflow.Workflow.Variable");
                            	      									afterParserOrEnumRuleCall();
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop5;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,21,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_6, grammarAccess.getMethodAccess().getRightParenthesisKeyword_2_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:486:4: otherlv_7= '()'
                    {
                    otherlv_7=(Token)match(input,17,FOLLOW_7); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getMethodAccess().getLeftParenthesisRightParenthesisKeyword_2_1());
                      			
                    }

                    }
                    break;

            }

            // InternalWorkflow.g:491:3: ( (lv_body_8_0= ruleBlock ) )
            // InternalWorkflow.g:492:4: (lv_body_8_0= ruleBlock )
            {
            // InternalWorkflow.g:492:4: (lv_body_8_0= ruleBlock )
            // InternalWorkflow.g:493:5: lv_body_8_0= ruleBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMethodAccess().getBodyBlockParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_8_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMethodRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_8_0,
              						"com.arsene.workflow.Workflow.Block");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethod"


    // $ANTLR start "entryRuleBlock"
    // InternalWorkflow.g:514:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // InternalWorkflow.g:514:46: (iv_ruleBlock= ruleBlock EOF )
            // InternalWorkflow.g:515:2: iv_ruleBlock= ruleBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBlock=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlock; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // InternalWorkflow.g:521:1: ruleBlock returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* ( (lv_returnStatement_3_0= ruleReturn ) )? otherlv_4= '}' ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_statements_2_0 = null;

        EObject lv_returnStatement_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:527:2: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* ( (lv_returnStatement_3_0= ruleReturn ) )? otherlv_4= '}' ) )
            // InternalWorkflow.g:528:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* ( (lv_returnStatement_3_0= ruleReturn ) )? otherlv_4= '}' )
            {
            // InternalWorkflow.g:528:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* ( (lv_returnStatement_3_0= ruleReturn ) )? otherlv_4= '}' )
            // InternalWorkflow.g:529:3: () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* ( (lv_returnStatement_3_0= ruleReturn ) )? otherlv_4= '}'
            {
            // InternalWorkflow.g:529:3: ()
            // InternalWorkflow.g:530:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlockAccess().getBlockAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,13,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalWorkflow.g:540:3: ( (lv_statements_2_0= ruleStatement ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID||LA8_0==23||LA8_0==25||(LA8_0>=27 && LA8_0<=30)||LA8_0==32||(LA8_0>=36 && LA8_0<=39)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalWorkflow.g:541:4: (lv_statements_2_0= ruleStatement )
            	    {
            	    // InternalWorkflow.g:541:4: (lv_statements_2_0= ruleStatement )
            	    // InternalWorkflow.g:542:5: lv_statements_2_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_statements_2_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getBlockRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_2_0,
            	      						"com.arsene.workflow.Workflow.Statement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalWorkflow.g:559:3: ( (lv_returnStatement_3_0= ruleReturn ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalWorkflow.g:560:4: (lv_returnStatement_3_0= ruleReturn )
                    {
                    // InternalWorkflow.g:560:4: (lv_returnStatement_3_0= ruleReturn )
                    // InternalWorkflow.g:561:5: lv_returnStatement_3_0= ruleReturn
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getBlockAccess().getReturnStatementReturnParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_17);
                    lv_returnStatement_3_0=ruleReturn();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getBlockRule());
                      					}
                      					set(
                      						current,
                      						"returnStatement",
                      						lv_returnStatement_3_0,
                      						"com.arsene.workflow.Workflow.Return");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,14,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleReturn"
    // InternalWorkflow.g:586:1: entryRuleReturn returns [EObject current=null] : iv_ruleReturn= ruleReturn EOF ;
    public final EObject entryRuleReturn() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturn = null;


        try {
            // InternalWorkflow.g:586:47: (iv_ruleReturn= ruleReturn EOF )
            // InternalWorkflow.g:587:2: iv_ruleReturn= ruleReturn EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReturnRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleReturn=ruleReturn();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReturn; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReturn"


    // $ANTLR start "ruleReturn"
    // InternalWorkflow.g:593:1: ruleReturn returns [EObject current=null] : (otherlv_0= 'return' ( (lv_expression_1_0= ruleExpression ) ) ) ;
    public final EObject ruleReturn() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_expression_1_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:599:2: ( (otherlv_0= 'return' ( (lv_expression_1_0= ruleExpression ) ) ) )
            // InternalWorkflow.g:600:2: (otherlv_0= 'return' ( (lv_expression_1_0= ruleExpression ) ) )
            {
            // InternalWorkflow.g:600:2: (otherlv_0= 'return' ( (lv_expression_1_0= ruleExpression ) ) )
            // InternalWorkflow.g:601:3: otherlv_0= 'return' ( (lv_expression_1_0= ruleExpression ) )
            {
            otherlv_0=(Token)match(input,22,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getReturnAccess().getReturnKeyword_0());
              		
            }
            // InternalWorkflow.g:605:3: ( (lv_expression_1_0= ruleExpression ) )
            // InternalWorkflow.g:606:4: (lv_expression_1_0= ruleExpression )
            {
            // InternalWorkflow.g:606:4: (lv_expression_1_0= ruleExpression )
            // InternalWorkflow.g:607:5: lv_expression_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getReturnAccess().getExpressionExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getReturnRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_1_0,
              						"com.arsene.workflow.Workflow.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReturn"


    // $ANTLR start "entryRuleStatement"
    // InternalWorkflow.g:628:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalWorkflow.g:628:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalWorkflow.g:629:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalWorkflow.g:635:1: ruleStatement returns [EObject current=null] : ( ( (lv_variabl_0_0= ruleVariable ) ) | ( (lv_print_1_0= ruleDisplay ) ) | ( (lv_assignment_2_0= ruleAssignment ) ) | ( (lv_ifStatement_3_0= ruleIfStatement ) ) | ( (lv_loop_4_0= ruleLoopStatement ) ) | ( (lv_methodInvocation_5_0= ruleMethodInvocation ) ) ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject lv_variabl_0_0 = null;

        EObject lv_print_1_0 = null;

        EObject lv_assignment_2_0 = null;

        EObject lv_ifStatement_3_0 = null;

        EObject lv_loop_4_0 = null;

        EObject lv_methodInvocation_5_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:641:2: ( ( ( (lv_variabl_0_0= ruleVariable ) ) | ( (lv_print_1_0= ruleDisplay ) ) | ( (lv_assignment_2_0= ruleAssignment ) ) | ( (lv_ifStatement_3_0= ruleIfStatement ) ) | ( (lv_loop_4_0= ruleLoopStatement ) ) | ( (lv_methodInvocation_5_0= ruleMethodInvocation ) ) ) )
            // InternalWorkflow.g:642:2: ( ( (lv_variabl_0_0= ruleVariable ) ) | ( (lv_print_1_0= ruleDisplay ) ) | ( (lv_assignment_2_0= ruleAssignment ) ) | ( (lv_ifStatement_3_0= ruleIfStatement ) ) | ( (lv_loop_4_0= ruleLoopStatement ) ) | ( (lv_methodInvocation_5_0= ruleMethodInvocation ) ) )
            {
            // InternalWorkflow.g:642:2: ( ( (lv_variabl_0_0= ruleVariable ) ) | ( (lv_print_1_0= ruleDisplay ) ) | ( (lv_assignment_2_0= ruleAssignment ) ) | ( (lv_ifStatement_3_0= ruleIfStatement ) ) | ( (lv_loop_4_0= ruleLoopStatement ) ) | ( (lv_methodInvocation_5_0= ruleMethodInvocation ) ) )
            int alt10=6;
            switch ( input.LA(1) ) {
            case 28:
            case 29:
            case 30:
            case 32:
            case 36:
            case 37:
            case 38:
                {
                alt10=1;
                }
                break;
            case 39:
                {
                alt10=2;
                }
                break;
            case RULE_ID:
                {
                alt10=3;
                }
                break;
            case 25:
                {
                alt10=4;
                }
                break;
            case 27:
                {
                alt10=5;
                }
                break;
            case 23:
                {
                alt10=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalWorkflow.g:643:3: ( (lv_variabl_0_0= ruleVariable ) )
                    {
                    // InternalWorkflow.g:643:3: ( (lv_variabl_0_0= ruleVariable ) )
                    // InternalWorkflow.g:644:4: (lv_variabl_0_0= ruleVariable )
                    {
                    // InternalWorkflow.g:644:4: (lv_variabl_0_0= ruleVariable )
                    // InternalWorkflow.g:645:5: lv_variabl_0_0= ruleVariable
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStatementAccess().getVariablVariableParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_variabl_0_0=ruleVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStatementRule());
                      					}
                      					set(
                      						current,
                      						"variabl",
                      						lv_variabl_0_0,
                      						"com.arsene.workflow.Workflow.Variable");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:663:3: ( (lv_print_1_0= ruleDisplay ) )
                    {
                    // InternalWorkflow.g:663:3: ( (lv_print_1_0= ruleDisplay ) )
                    // InternalWorkflow.g:664:4: (lv_print_1_0= ruleDisplay )
                    {
                    // InternalWorkflow.g:664:4: (lv_print_1_0= ruleDisplay )
                    // InternalWorkflow.g:665:5: lv_print_1_0= ruleDisplay
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStatementAccess().getPrintDisplayParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_print_1_0=ruleDisplay();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStatementRule());
                      					}
                      					set(
                      						current,
                      						"print",
                      						lv_print_1_0,
                      						"com.arsene.workflow.Workflow.Display");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:683:3: ( (lv_assignment_2_0= ruleAssignment ) )
                    {
                    // InternalWorkflow.g:683:3: ( (lv_assignment_2_0= ruleAssignment ) )
                    // InternalWorkflow.g:684:4: (lv_assignment_2_0= ruleAssignment )
                    {
                    // InternalWorkflow.g:684:4: (lv_assignment_2_0= ruleAssignment )
                    // InternalWorkflow.g:685:5: lv_assignment_2_0= ruleAssignment
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStatementAccess().getAssignmentAssignmentParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_assignment_2_0=ruleAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStatementRule());
                      					}
                      					set(
                      						current,
                      						"assignment",
                      						lv_assignment_2_0,
                      						"com.arsene.workflow.Workflow.Assignment");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:703:3: ( (lv_ifStatement_3_0= ruleIfStatement ) )
                    {
                    // InternalWorkflow.g:703:3: ( (lv_ifStatement_3_0= ruleIfStatement ) )
                    // InternalWorkflow.g:704:4: (lv_ifStatement_3_0= ruleIfStatement )
                    {
                    // InternalWorkflow.g:704:4: (lv_ifStatement_3_0= ruleIfStatement )
                    // InternalWorkflow.g:705:5: lv_ifStatement_3_0= ruleIfStatement
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStatementAccess().getIfStatementIfStatementParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_ifStatement_3_0=ruleIfStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStatementRule());
                      					}
                      					set(
                      						current,
                      						"ifStatement",
                      						lv_ifStatement_3_0,
                      						"com.arsene.workflow.Workflow.IfStatement");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalWorkflow.g:723:3: ( (lv_loop_4_0= ruleLoopStatement ) )
                    {
                    // InternalWorkflow.g:723:3: ( (lv_loop_4_0= ruleLoopStatement ) )
                    // InternalWorkflow.g:724:4: (lv_loop_4_0= ruleLoopStatement )
                    {
                    // InternalWorkflow.g:724:4: (lv_loop_4_0= ruleLoopStatement )
                    // InternalWorkflow.g:725:5: lv_loop_4_0= ruleLoopStatement
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStatementAccess().getLoopLoopStatementParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_loop_4_0=ruleLoopStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStatementRule());
                      					}
                      					set(
                      						current,
                      						"loop",
                      						lv_loop_4_0,
                      						"com.arsene.workflow.Workflow.LoopStatement");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalWorkflow.g:743:3: ( (lv_methodInvocation_5_0= ruleMethodInvocation ) )
                    {
                    // InternalWorkflow.g:743:3: ( (lv_methodInvocation_5_0= ruleMethodInvocation ) )
                    // InternalWorkflow.g:744:4: (lv_methodInvocation_5_0= ruleMethodInvocation )
                    {
                    // InternalWorkflow.g:744:4: (lv_methodInvocation_5_0= ruleMethodInvocation )
                    // InternalWorkflow.g:745:5: lv_methodInvocation_5_0= ruleMethodInvocation
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStatementAccess().getMethodInvocationMethodInvocationParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_methodInvocation_5_0=ruleMethodInvocation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStatementRule());
                      					}
                      					set(
                      						current,
                      						"methodInvocation",
                      						lv_methodInvocation_5_0,
                      						"com.arsene.workflow.Workflow.MethodInvocation");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleMethodInvocation"
    // InternalWorkflow.g:766:1: entryRuleMethodInvocation returns [EObject current=null] : iv_ruleMethodInvocation= ruleMethodInvocation EOF ;
    public final EObject entryRuleMethodInvocation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodInvocation = null;


        try {
            // InternalWorkflow.g:766:57: (iv_ruleMethodInvocation= ruleMethodInvocation EOF )
            // InternalWorkflow.g:767:2: iv_ruleMethodInvocation= ruleMethodInvocation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMethodInvocationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMethodInvocation=ruleMethodInvocation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMethodInvocation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMethodInvocation"


    // $ANTLR start "ruleMethodInvocation"
    // InternalWorkflow.g:773:1: ruleMethodInvocation returns [EObject current=null] : ( () otherlv_1= 'call' ( ( (otherlv_2= RULE_ID ) ) | ( (lv_service_3_0= ruleService ) ) ) ( (otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' ) | otherlv_9= '()' ) ) ;
    public final EObject ruleMethodInvocation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_service_3_0 = null;

        EObject lv_args_5_0 = null;

        EObject lv_args_7_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:779:2: ( ( () otherlv_1= 'call' ( ( (otherlv_2= RULE_ID ) ) | ( (lv_service_3_0= ruleService ) ) ) ( (otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' ) | otherlv_9= '()' ) ) )
            // InternalWorkflow.g:780:2: ( () otherlv_1= 'call' ( ( (otherlv_2= RULE_ID ) ) | ( (lv_service_3_0= ruleService ) ) ) ( (otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' ) | otherlv_9= '()' ) )
            {
            // InternalWorkflow.g:780:2: ( () otherlv_1= 'call' ( ( (otherlv_2= RULE_ID ) ) | ( (lv_service_3_0= ruleService ) ) ) ( (otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' ) | otherlv_9= '()' ) )
            // InternalWorkflow.g:781:3: () otherlv_1= 'call' ( ( (otherlv_2= RULE_ID ) ) | ( (lv_service_3_0= ruleService ) ) ) ( (otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' ) | otherlv_9= '()' )
            {
            // InternalWorkflow.g:781:3: ()
            // InternalWorkflow.g:782:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMethodInvocationAccess().getMethodInvocationAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,23,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getMethodInvocationAccess().getCallKeyword_1());
              		
            }
            // InternalWorkflow.g:792:3: ( ( (otherlv_2= RULE_ID ) ) | ( (lv_service_3_0= ruleService ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                alt11=1;
            }
            else if ( (LA11_0==24) ) {
                alt11=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalWorkflow.g:793:4: ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalWorkflow.g:793:4: ( (otherlv_2= RULE_ID ) )
                    // InternalWorkflow.g:794:5: (otherlv_2= RULE_ID )
                    {
                    // InternalWorkflow.g:794:5: (otherlv_2= RULE_ID )
                    // InternalWorkflow.g:795:6: otherlv_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getMethodInvocationRule());
                      						}
                      					
                    }
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_2, grammarAccess.getMethodInvocationAccess().getInvokedMethodMethodCrossReference_2_0_0());
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:807:4: ( (lv_service_3_0= ruleService ) )
                    {
                    // InternalWorkflow.g:807:4: ( (lv_service_3_0= ruleService ) )
                    // InternalWorkflow.g:808:5: (lv_service_3_0= ruleService )
                    {
                    // InternalWorkflow.g:808:5: (lv_service_3_0= ruleService )
                    // InternalWorkflow.g:809:6: lv_service_3_0= ruleService
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getMethodInvocationAccess().getServiceServiceParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_12);
                    lv_service_3_0=ruleService();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getMethodInvocationRule());
                      						}
                      						set(
                      							current,
                      							"service",
                      							lv_service_3_0,
                      							"com.arsene.workflow.Workflow.Service");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:827:3: ( (otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' ) | otherlv_9= '()' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==19) ) {
                alt14=1;
            }
            else if ( (LA14_0==17) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalWorkflow.g:828:4: (otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )
                    {
                    // InternalWorkflow.g:828:4: (otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')' )
                    // InternalWorkflow.g:829:5: otherlv_4= '(' ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )? otherlv_8= ')'
                    {
                    otherlv_4=(Token)match(input,19,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getMethodInvocationAccess().getLeftParenthesisKeyword_3_0_0());
                      				
                    }
                    // InternalWorkflow.g:833:5: ( ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )* )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( ((LA13_0>=RULE_ID && LA13_0<=RULE_INT)||LA13_0==19||LA13_0==49||(LA13_0>=54 && LA13_0<=56)) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // InternalWorkflow.g:834:6: ( (lv_args_5_0= ruleExpression ) ) (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )*
                            {
                            // InternalWorkflow.g:834:6: ( (lv_args_5_0= ruleExpression ) )
                            // InternalWorkflow.g:835:7: (lv_args_5_0= ruleExpression )
                            {
                            // InternalWorkflow.g:835:7: (lv_args_5_0= ruleExpression )
                            // InternalWorkflow.g:836:8: lv_args_5_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getMethodInvocationAccess().getArgsExpressionParserRuleCall_3_0_1_0_0());
                              							
                            }
                            pushFollow(FOLLOW_14);
                            lv_args_5_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getMethodInvocationRule());
                              								}
                              								add(
                              									current,
                              									"args",
                              									lv_args_5_0,
                              									"com.arsene.workflow.Workflow.Expression");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }

                            // InternalWorkflow.g:853:6: (otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) ) )*
                            loop12:
                            do {
                                int alt12=2;
                                int LA12_0 = input.LA(1);

                                if ( (LA12_0==20) ) {
                                    alt12=1;
                                }


                                switch (alt12) {
                            	case 1 :
                            	    // InternalWorkflow.g:854:7: otherlv_6= ',' ( (lv_args_7_0= ruleExpression ) )
                            	    {
                            	    otherlv_6=(Token)match(input,20,FOLLOW_18); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_6, grammarAccess.getMethodInvocationAccess().getCommaKeyword_3_0_1_1_0());
                            	      						
                            	    }
                            	    // InternalWorkflow.g:858:7: ( (lv_args_7_0= ruleExpression ) )
                            	    // InternalWorkflow.g:859:8: (lv_args_7_0= ruleExpression )
                            	    {
                            	    // InternalWorkflow.g:859:8: (lv_args_7_0= ruleExpression )
                            	    // InternalWorkflow.g:860:9: lv_args_7_0= ruleExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getMethodInvocationAccess().getArgsExpressionParserRuleCall_3_0_1_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_14);
                            	    lv_args_7_0=ruleExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									if (current==null) {
                            	      										current = createModelElementForParent(grammarAccess.getMethodInvocationRule());
                            	      									}
                            	      									add(
                            	      										current,
                            	      										"args",
                            	      										lv_args_7_0,
                            	      										"com.arsene.workflow.Workflow.Expression");
                            	      									afterParserOrEnumRuleCall();
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop12;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_8=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_8, grammarAccess.getMethodInvocationAccess().getRightParenthesisKeyword_3_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:885:4: otherlv_9= '()'
                    {
                    otherlv_9=(Token)match(input,17,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getMethodInvocationAccess().getLeftParenthesisRightParenthesisKeyword_3_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethodInvocation"


    // $ANTLR start "entryRuleService"
    // InternalWorkflow.g:894:1: entryRuleService returns [EObject current=null] : iv_ruleService= ruleService EOF ;
    public final EObject entryRuleService() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleService = null;


        try {
            // InternalWorkflow.g:894:48: (iv_ruleService= ruleService EOF )
            // InternalWorkflow.g:895:2: iv_ruleService= ruleService EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getServiceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleService=ruleService();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleService; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleService"


    // $ANTLR start "ruleService"
    // InternalWorkflow.g:901:1: ruleService returns [EObject current=null] : (otherlv_0= 'service' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleService() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalWorkflow.g:907:2: ( (otherlv_0= 'service' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalWorkflow.g:908:2: (otherlv_0= 'service' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalWorkflow.g:908:2: (otherlv_0= 'service' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalWorkflow.g:909:3: otherlv_0= 'service' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,24,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getServiceAccess().getServiceKeyword_0());
              		
            }
            // InternalWorkflow.g:913:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalWorkflow.g:914:4: (lv_name_1_0= RULE_ID )
            {
            // InternalWorkflow.g:914:4: (lv_name_1_0= RULE_ID )
            // InternalWorkflow.g:915:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getServiceAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getServiceRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleService"


    // $ANTLR start "entryRuleIfStatement"
    // InternalWorkflow.g:935:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // InternalWorkflow.g:935:52: (iv_ruleIfStatement= ruleIfStatement EOF )
            // InternalWorkflow.g:936:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfStatement=ruleIfStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfStatement"


    // $ANTLR start "ruleIfStatement"
    // InternalWorkflow.g:942:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_thenBlock_4_0= ruleIfBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleIfBlock ) ) )? ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_expression_2_0 = null;

        EObject lv_thenBlock_4_0 = null;

        EObject lv_elseBlock_6_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:948:2: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_thenBlock_4_0= ruleIfBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleIfBlock ) ) )? ) )
            // InternalWorkflow.g:949:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_thenBlock_4_0= ruleIfBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleIfBlock ) ) )? )
            {
            // InternalWorkflow.g:949:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_thenBlock_4_0= ruleIfBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleIfBlock ) ) )? )
            // InternalWorkflow.g:950:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_thenBlock_4_0= ruleIfBlock ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleIfBlock ) ) )?
            {
            otherlv_0=(Token)match(input,25,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,19,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIfStatementAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalWorkflow.g:958:3: ( (lv_expression_2_0= ruleExpression ) )
            // InternalWorkflow.g:959:4: (lv_expression_2_0= ruleExpression )
            {
            // InternalWorkflow.g:959:4: (lv_expression_2_0= ruleExpression )
            // InternalWorkflow.g:960:5: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfStatementAccess().getExpressionExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfStatementRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_2_0,
              						"com.arsene.workflow.Workflow.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getIfStatementAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalWorkflow.g:981:3: ( (lv_thenBlock_4_0= ruleIfBlock ) )
            // InternalWorkflow.g:982:4: (lv_thenBlock_4_0= ruleIfBlock )
            {
            // InternalWorkflow.g:982:4: (lv_thenBlock_4_0= ruleIfBlock )
            // InternalWorkflow.g:983:5: lv_thenBlock_4_0= ruleIfBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfStatementAccess().getThenBlockIfBlockParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_24);
            lv_thenBlock_4_0=ruleIfBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfStatementRule());
              					}
              					set(
              						current,
              						"thenBlock",
              						lv_thenBlock_4_0,
              						"com.arsene.workflow.Workflow.IfBlock");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalWorkflow.g:1000:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleIfBlock ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==26) ) {
                int LA15_1 = input.LA(2);

                if ( (synpred1_InternalWorkflow()) ) {
                    alt15=1;
                }
            }
            switch (alt15) {
                case 1 :
                    // InternalWorkflow.g:1001:4: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleIfBlock ) )
                    {
                    // InternalWorkflow.g:1001:4: ( ( 'else' )=>otherlv_5= 'else' )
                    // InternalWorkflow.g:1002:5: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,26,FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getIfStatementAccess().getElseKeyword_5_0());
                      				
                    }

                    }

                    // InternalWorkflow.g:1008:4: ( (lv_elseBlock_6_0= ruleIfBlock ) )
                    // InternalWorkflow.g:1009:5: (lv_elseBlock_6_0= ruleIfBlock )
                    {
                    // InternalWorkflow.g:1009:5: (lv_elseBlock_6_0= ruleIfBlock )
                    // InternalWorkflow.g:1010:6: lv_elseBlock_6_0= ruleIfBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIfStatementAccess().getElseBlockIfBlockParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_elseBlock_6_0=ruleIfBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIfStatementRule());
                      						}
                      						set(
                      							current,
                      							"elseBlock",
                      							lv_elseBlock_6_0,
                      							"com.arsene.workflow.Workflow.IfBlock");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfStatement"


    // $ANTLR start "entryRuleIfBlock"
    // InternalWorkflow.g:1032:1: entryRuleIfBlock returns [EObject current=null] : iv_ruleIfBlock= ruleIfBlock EOF ;
    public final EObject entryRuleIfBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfBlock = null;


        try {
            // InternalWorkflow.g:1032:48: (iv_ruleIfBlock= ruleIfBlock EOF )
            // InternalWorkflow.g:1033:2: iv_ruleIfBlock= ruleIfBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfBlock=ruleIfBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfBlock; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfBlock"


    // $ANTLR start "ruleIfBlock"
    // InternalWorkflow.g:1039:1: ruleIfBlock returns [EObject current=null] : ( ( (lv_statements_0_0= ruleStatement ) ) | this_Block_1= ruleBlock ) ;
    public final EObject ruleIfBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_0_0 = null;

        EObject this_Block_1 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1045:2: ( ( ( (lv_statements_0_0= ruleStatement ) ) | this_Block_1= ruleBlock ) )
            // InternalWorkflow.g:1046:2: ( ( (lv_statements_0_0= ruleStatement ) ) | this_Block_1= ruleBlock )
            {
            // InternalWorkflow.g:1046:2: ( ( (lv_statements_0_0= ruleStatement ) ) | this_Block_1= ruleBlock )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID||LA16_0==23||LA16_0==25||(LA16_0>=27 && LA16_0<=30)||LA16_0==32||(LA16_0>=36 && LA16_0<=39)) ) {
                alt16=1;
            }
            else if ( (LA16_0==13) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalWorkflow.g:1047:3: ( (lv_statements_0_0= ruleStatement ) )
                    {
                    // InternalWorkflow.g:1047:3: ( (lv_statements_0_0= ruleStatement ) )
                    // InternalWorkflow.g:1048:4: (lv_statements_0_0= ruleStatement )
                    {
                    // InternalWorkflow.g:1048:4: (lv_statements_0_0= ruleStatement )
                    // InternalWorkflow.g:1049:5: lv_statements_0_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getIfBlockAccess().getStatementsStatementParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_statements_0_0=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getIfBlockRule());
                      					}
                      					add(
                      						current,
                      						"statements",
                      						lv_statements_0_0,
                      						"com.arsene.workflow.Workflow.Statement");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:1067:3: this_Block_1= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getIfBlockAccess().getBlockParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Block_1=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Block_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfBlock"


    // $ANTLR start "entryRuleLoopStatement"
    // InternalWorkflow.g:1079:1: entryRuleLoopStatement returns [EObject current=null] : iv_ruleLoopStatement= ruleLoopStatement EOF ;
    public final EObject entryRuleLoopStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopStatement = null;


        try {
            // InternalWorkflow.g:1079:54: (iv_ruleLoopStatement= ruleLoopStatement EOF )
            // InternalWorkflow.g:1080:2: iv_ruleLoopStatement= ruleLoopStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLoopStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLoopStatement=ruleLoopStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLoopStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoopStatement"


    // $ANTLR start "ruleLoopStatement"
    // InternalWorkflow.g:1086:1: ruleLoopStatement returns [EObject current=null] : (otherlv_0= 'loop:' otherlv_1= 'if' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' ( (lv_thenBlock_5_0= ruleIfBlock ) ) ) ;
    public final EObject ruleLoopStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expression_3_0 = null;

        EObject lv_thenBlock_5_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1092:2: ( (otherlv_0= 'loop:' otherlv_1= 'if' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' ( (lv_thenBlock_5_0= ruleIfBlock ) ) ) )
            // InternalWorkflow.g:1093:2: (otherlv_0= 'loop:' otherlv_1= 'if' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' ( (lv_thenBlock_5_0= ruleIfBlock ) ) )
            {
            // InternalWorkflow.g:1093:2: (otherlv_0= 'loop:' otherlv_1= 'if' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' ( (lv_thenBlock_5_0= ruleIfBlock ) ) )
            // InternalWorkflow.g:1094:3: otherlv_0= 'loop:' otherlv_1= 'if' otherlv_2= '(' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= ')' ( (lv_thenBlock_5_0= ruleIfBlock ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLoopStatementAccess().getLoopKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,25,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLoopStatementAccess().getIfKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,19,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getLoopStatementAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalWorkflow.g:1106:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalWorkflow.g:1107:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalWorkflow.g:1107:4: (lv_expression_3_0= ruleExpression )
            // InternalWorkflow.g:1108:5: lv_expression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLoopStatementAccess().getExpressionExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_expression_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLoopStatementRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_3_0,
              						"com.arsene.workflow.Workflow.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,21,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getLoopStatementAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalWorkflow.g:1129:3: ( (lv_thenBlock_5_0= ruleIfBlock ) )
            // InternalWorkflow.g:1130:4: (lv_thenBlock_5_0= ruleIfBlock )
            {
            // InternalWorkflow.g:1130:4: (lv_thenBlock_5_0= ruleIfBlock )
            // InternalWorkflow.g:1131:5: lv_thenBlock_5_0= ruleIfBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLoopStatementAccess().getThenBlockIfBlockParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_thenBlock_5_0=ruleIfBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLoopStatementRule());
              					}
              					set(
              						current,
              						"thenBlock",
              						lv_thenBlock_5_0,
              						"com.arsene.workflow.Workflow.IfBlock");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoopStatement"


    // $ANTLR start "entryRuleVariable"
    // InternalWorkflow.g:1152:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalWorkflow.g:1152:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalWorkflow.g:1153:2: iv_ruleVariable= ruleVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalWorkflow.g:1159:1: ruleVariable returns [EObject current=null] : ( ( ( ( ( (lv_typeName_0_1= 'boolean' | lv_typeName_0_2= 'number' | lv_typeName_0_3= 'string' ) ) ) otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) ) | ( (otherlv_3= 'Define' )? ruleVariableType ( (lv_name_5_0= RULE_ID ) ) ( ( (lv_array_6_0= '[' ) ) ( (lv_length_7_0= RULE_INT ) )? otherlv_8= ']' )? ) ) (otherlv_9= '=' ( ( (lv_expression_10_0= ruleExpression ) ) | ( (lv_methodInvocation_11_0= ruleMethodInvocation ) ) ) )? ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token lv_typeName_0_1=null;
        Token lv_typeName_0_2=null;
        Token lv_typeName_0_3=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token lv_name_5_0=null;
        Token lv_array_6_0=null;
        Token lv_length_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_expression_10_0 = null;

        EObject lv_methodInvocation_11_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1165:2: ( ( ( ( ( ( (lv_typeName_0_1= 'boolean' | lv_typeName_0_2= 'number' | lv_typeName_0_3= 'string' ) ) ) otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) ) | ( (otherlv_3= 'Define' )? ruleVariableType ( (lv_name_5_0= RULE_ID ) ) ( ( (lv_array_6_0= '[' ) ) ( (lv_length_7_0= RULE_INT ) )? otherlv_8= ']' )? ) ) (otherlv_9= '=' ( ( (lv_expression_10_0= ruleExpression ) ) | ( (lv_methodInvocation_11_0= ruleMethodInvocation ) ) ) )? ) )
            // InternalWorkflow.g:1166:2: ( ( ( ( ( (lv_typeName_0_1= 'boolean' | lv_typeName_0_2= 'number' | lv_typeName_0_3= 'string' ) ) ) otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) ) | ( (otherlv_3= 'Define' )? ruleVariableType ( (lv_name_5_0= RULE_ID ) ) ( ( (lv_array_6_0= '[' ) ) ( (lv_length_7_0= RULE_INT ) )? otherlv_8= ']' )? ) ) (otherlv_9= '=' ( ( (lv_expression_10_0= ruleExpression ) ) | ( (lv_methodInvocation_11_0= ruleMethodInvocation ) ) ) )? )
            {
            // InternalWorkflow.g:1166:2: ( ( ( ( ( (lv_typeName_0_1= 'boolean' | lv_typeName_0_2= 'number' | lv_typeName_0_3= 'string' ) ) ) otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) ) | ( (otherlv_3= 'Define' )? ruleVariableType ( (lv_name_5_0= RULE_ID ) ) ( ( (lv_array_6_0= '[' ) ) ( (lv_length_7_0= RULE_INT ) )? otherlv_8= ']' )? ) ) (otherlv_9= '=' ( ( (lv_expression_10_0= ruleExpression ) ) | ( (lv_methodInvocation_11_0= ruleMethodInvocation ) ) ) )? )
            // InternalWorkflow.g:1167:3: ( ( ( ( (lv_typeName_0_1= 'boolean' | lv_typeName_0_2= 'number' | lv_typeName_0_3= 'string' ) ) ) otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) ) | ( (otherlv_3= 'Define' )? ruleVariableType ( (lv_name_5_0= RULE_ID ) ) ( ( (lv_array_6_0= '[' ) ) ( (lv_length_7_0= RULE_INT ) )? otherlv_8= ']' )? ) ) (otherlv_9= '=' ( ( (lv_expression_10_0= ruleExpression ) ) | ( (lv_methodInvocation_11_0= ruleMethodInvocation ) ) ) )?
            {
            // InternalWorkflow.g:1167:3: ( ( ( ( (lv_typeName_0_1= 'boolean' | lv_typeName_0_2= 'number' | lv_typeName_0_3= 'string' ) ) ) otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) ) | ( (otherlv_3= 'Define' )? ruleVariableType ( (lv_name_5_0= RULE_ID ) ) ( ( (lv_array_6_0= '[' ) ) ( (lv_length_7_0= RULE_INT ) )? otherlv_8= ']' )? ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=28 && LA21_0<=30)) ) {
                alt21=1;
            }
            else if ( (LA21_0==32||(LA21_0>=36 && LA21_0<=38)) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalWorkflow.g:1168:4: ( ( ( (lv_typeName_0_1= 'boolean' | lv_typeName_0_2= 'number' | lv_typeName_0_3= 'string' ) ) ) otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) )
                    {
                    // InternalWorkflow.g:1168:4: ( ( ( (lv_typeName_0_1= 'boolean' | lv_typeName_0_2= 'number' | lv_typeName_0_3= 'string' ) ) ) otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) ) )
                    // InternalWorkflow.g:1169:5: ( ( (lv_typeName_0_1= 'boolean' | lv_typeName_0_2= 'number' | lv_typeName_0_3= 'string' ) ) ) otherlv_1= ':' ( (lv_name_2_0= RULE_ID ) )
                    {
                    // InternalWorkflow.g:1169:5: ( ( (lv_typeName_0_1= 'boolean' | lv_typeName_0_2= 'number' | lv_typeName_0_3= 'string' ) ) )
                    // InternalWorkflow.g:1170:6: ( (lv_typeName_0_1= 'boolean' | lv_typeName_0_2= 'number' | lv_typeName_0_3= 'string' ) )
                    {
                    // InternalWorkflow.g:1170:6: ( (lv_typeName_0_1= 'boolean' | lv_typeName_0_2= 'number' | lv_typeName_0_3= 'string' ) )
                    // InternalWorkflow.g:1171:7: (lv_typeName_0_1= 'boolean' | lv_typeName_0_2= 'number' | lv_typeName_0_3= 'string' )
                    {
                    // InternalWorkflow.g:1171:7: (lv_typeName_0_1= 'boolean' | lv_typeName_0_2= 'number' | lv_typeName_0_3= 'string' )
                    int alt17=3;
                    switch ( input.LA(1) ) {
                    case 28:
                        {
                        alt17=1;
                        }
                        break;
                    case 29:
                        {
                        alt17=2;
                        }
                        break;
                    case 30:
                        {
                        alt17=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }

                    switch (alt17) {
                        case 1 :
                            // InternalWorkflow.g:1172:8: lv_typeName_0_1= 'boolean'
                            {
                            lv_typeName_0_1=(Token)match(input,28,FOLLOW_26); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_typeName_0_1, grammarAccess.getVariableAccess().getTypeNameBooleanKeyword_0_0_0_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getVariableRule());
                              								}
                              								setWithLastConsumed(current, "typeName", lv_typeName_0_1, null);
                              							
                            }

                            }
                            break;
                        case 2 :
                            // InternalWorkflow.g:1183:8: lv_typeName_0_2= 'number'
                            {
                            lv_typeName_0_2=(Token)match(input,29,FOLLOW_26); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_typeName_0_2, grammarAccess.getVariableAccess().getTypeNameNumberKeyword_0_0_0_0_1());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getVariableRule());
                              								}
                              								setWithLastConsumed(current, "typeName", lv_typeName_0_2, null);
                              							
                            }

                            }
                            break;
                        case 3 :
                            // InternalWorkflow.g:1194:8: lv_typeName_0_3= 'string'
                            {
                            lv_typeName_0_3=(Token)match(input,30,FOLLOW_26); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_typeName_0_3, grammarAccess.getVariableAccess().getTypeNameStringKeyword_0_0_0_0_2());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getVariableRule());
                              								}
                              								setWithLastConsumed(current, "typeName", lv_typeName_0_3, null);
                              							
                            }

                            }
                            break;

                    }


                    }


                    }

                    otherlv_1=(Token)match(input,31,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getVariableAccess().getColonKeyword_0_0_1());
                      				
                    }
                    // InternalWorkflow.g:1211:5: ( (lv_name_2_0= RULE_ID ) )
                    // InternalWorkflow.g:1212:6: (lv_name_2_0= RULE_ID )
                    {
                    // InternalWorkflow.g:1212:6: (lv_name_2_0= RULE_ID )
                    // InternalWorkflow.g:1213:7: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_name_2_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_0_0_2_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getVariableRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"name",
                      								lv_name_2_0,
                      								"org.eclipse.xtext.common.Terminals.ID");
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:1231:4: ( (otherlv_3= 'Define' )? ruleVariableType ( (lv_name_5_0= RULE_ID ) ) ( ( (lv_array_6_0= '[' ) ) ( (lv_length_7_0= RULE_INT ) )? otherlv_8= ']' )? )
                    {
                    // InternalWorkflow.g:1231:4: ( (otherlv_3= 'Define' )? ruleVariableType ( (lv_name_5_0= RULE_ID ) ) ( ( (lv_array_6_0= '[' ) ) ( (lv_length_7_0= RULE_INT ) )? otherlv_8= ']' )? )
                    // InternalWorkflow.g:1232:5: (otherlv_3= 'Define' )? ruleVariableType ( (lv_name_5_0= RULE_ID ) ) ( ( (lv_array_6_0= '[' ) ) ( (lv_length_7_0= RULE_INT ) )? otherlv_8= ']' )?
                    {
                    // InternalWorkflow.g:1232:5: (otherlv_3= 'Define' )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==32) ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // InternalWorkflow.g:1233:6: otherlv_3= 'Define'
                            {
                            otherlv_3=(Token)match(input,32,FOLLOW_15); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_3, grammarAccess.getVariableAccess().getDefineKeyword_0_1_0());
                              					
                            }

                            }
                            break;

                    }

                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getVariableAccess().getVariableTypeParserRuleCall_0_1_1());
                      				
                    }
                    pushFollow(FOLLOW_4);
                    ruleVariableType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }
                    // InternalWorkflow.g:1245:5: ( (lv_name_5_0= RULE_ID ) )
                    // InternalWorkflow.g:1246:6: (lv_name_5_0= RULE_ID )
                    {
                    // InternalWorkflow.g:1246:6: (lv_name_5_0= RULE_ID )
                    // InternalWorkflow.g:1247:7: lv_name_5_0= RULE_ID
                    {
                    lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_name_5_0, grammarAccess.getVariableAccess().getNameIDTerminalRuleCall_0_1_2_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getVariableRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"name",
                      								lv_name_5_0,
                      								"org.eclipse.xtext.common.Terminals.ID");
                      						
                    }

                    }


                    }

                    // InternalWorkflow.g:1263:5: ( ( (lv_array_6_0= '[' ) ) ( (lv_length_7_0= RULE_INT ) )? otherlv_8= ']' )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==33) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // InternalWorkflow.g:1264:6: ( (lv_array_6_0= '[' ) ) ( (lv_length_7_0= RULE_INT ) )? otherlv_8= ']'
                            {
                            // InternalWorkflow.g:1264:6: ( (lv_array_6_0= '[' ) )
                            // InternalWorkflow.g:1265:7: (lv_array_6_0= '[' )
                            {
                            // InternalWorkflow.g:1265:7: (lv_array_6_0= '[' )
                            // InternalWorkflow.g:1266:8: lv_array_6_0= '['
                            {
                            lv_array_6_0=(Token)match(input,33,FOLLOW_29); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								newLeafNode(lv_array_6_0, grammarAccess.getVariableAccess().getArrayLeftSquareBracketKeyword_0_1_3_0_0());
                              							
                            }
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElement(grammarAccess.getVariableRule());
                              								}
                              								setWithLastConsumed(current, "array", lv_array_6_0 != null, "[");
                              							
                            }

                            }


                            }

                            // InternalWorkflow.g:1278:6: ( (lv_length_7_0= RULE_INT ) )?
                            int alt19=2;
                            int LA19_0 = input.LA(1);

                            if ( (LA19_0==RULE_INT) ) {
                                alt19=1;
                            }
                            switch (alt19) {
                                case 1 :
                                    // InternalWorkflow.g:1279:7: (lv_length_7_0= RULE_INT )
                                    {
                                    // InternalWorkflow.g:1279:7: (lv_length_7_0= RULE_INT )
                                    // InternalWorkflow.g:1280:8: lv_length_7_0= RULE_INT
                                    {
                                    lv_length_7_0=(Token)match(input,RULE_INT,FOLLOW_30); if (state.failed) return current;
                                    if ( state.backtracking==0 ) {

                                      								newLeafNode(lv_length_7_0, grammarAccess.getVariableAccess().getLengthINTTerminalRuleCall_0_1_3_1_0());
                                      							
                                    }
                                    if ( state.backtracking==0 ) {

                                      								if (current==null) {
                                      									current = createModelElement(grammarAccess.getVariableRule());
                                      								}
                                      								setWithLastConsumed(
                                      									current,
                                      									"length",
                                      									lv_length_7_0,
                                      									"org.eclipse.xtext.common.Terminals.INT");
                                      							
                                    }

                                    }


                                    }
                                    break;

                            }

                            otherlv_8=(Token)match(input,34,FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_8, grammarAccess.getVariableAccess().getRightSquareBracketKeyword_0_1_3_2());
                              					
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalWorkflow.g:1303:3: (otherlv_9= '=' ( ( (lv_expression_10_0= ruleExpression ) ) | ( (lv_methodInvocation_11_0= ruleMethodInvocation ) ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==35) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalWorkflow.g:1304:4: otherlv_9= '=' ( ( (lv_expression_10_0= ruleExpression ) ) | ( (lv_methodInvocation_11_0= ruleMethodInvocation ) ) )
                    {
                    otherlv_9=(Token)match(input,35,FOLLOW_31); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getVariableAccess().getEqualsSignKeyword_1_0());
                      			
                    }
                    // InternalWorkflow.g:1308:4: ( ( (lv_expression_10_0= ruleExpression ) ) | ( (lv_methodInvocation_11_0= ruleMethodInvocation ) ) )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( ((LA22_0>=RULE_ID && LA22_0<=RULE_INT)||LA22_0==19||LA22_0==49||(LA22_0>=54 && LA22_0<=56)) ) {
                        alt22=1;
                    }
                    else if ( (LA22_0==23) ) {
                        alt22=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalWorkflow.g:1309:5: ( (lv_expression_10_0= ruleExpression ) )
                            {
                            // InternalWorkflow.g:1309:5: ( (lv_expression_10_0= ruleExpression ) )
                            // InternalWorkflow.g:1310:6: (lv_expression_10_0= ruleExpression )
                            {
                            // InternalWorkflow.g:1310:6: (lv_expression_10_0= ruleExpression )
                            // InternalWorkflow.g:1311:7: lv_expression_10_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getVariableAccess().getExpressionExpressionParserRuleCall_1_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_expression_10_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getVariableRule());
                              							}
                              							set(
                              								current,
                              								"expression",
                              								lv_expression_10_0,
                              								"com.arsene.workflow.Workflow.Expression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalWorkflow.g:1329:5: ( (lv_methodInvocation_11_0= ruleMethodInvocation ) )
                            {
                            // InternalWorkflow.g:1329:5: ( (lv_methodInvocation_11_0= ruleMethodInvocation ) )
                            // InternalWorkflow.g:1330:6: (lv_methodInvocation_11_0= ruleMethodInvocation )
                            {
                            // InternalWorkflow.g:1330:6: (lv_methodInvocation_11_0= ruleMethodInvocation )
                            // InternalWorkflow.g:1331:7: lv_methodInvocation_11_0= ruleMethodInvocation
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getVariableAccess().getMethodInvocationMethodInvocationParserRuleCall_1_1_1_0());
                              						
                            }
                            pushFollow(FOLLOW_2);
                            lv_methodInvocation_11_0=ruleMethodInvocation();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getVariableRule());
                              							}
                              							set(
                              								current,
                              								"methodInvocation",
                              								lv_methodInvocation_11_0,
                              								"com.arsene.workflow.Workflow.MethodInvocation");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleVariableType"
    // InternalWorkflow.g:1354:1: entryRuleVariableType returns [String current=null] : iv_ruleVariableType= ruleVariableType EOF ;
    public final String entryRuleVariableType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVariableType = null;


        try {
            // InternalWorkflow.g:1354:52: (iv_ruleVariableType= ruleVariableType EOF )
            // InternalWorkflow.g:1355:2: iv_ruleVariableType= ruleVariableType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariableType=ruleVariableType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableType.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableType"


    // $ANTLR start "ruleVariableType"
    // InternalWorkflow.g:1361:1: ruleVariableType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'var' | kw= 'Artifact' | kw= 'Event' ) ;
    public final AntlrDatatypeRuleToken ruleVariableType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalWorkflow.g:1367:2: ( (kw= 'var' | kw= 'Artifact' | kw= 'Event' ) )
            // InternalWorkflow.g:1368:2: (kw= 'var' | kw= 'Artifact' | kw= 'Event' )
            {
            // InternalWorkflow.g:1368:2: (kw= 'var' | kw= 'Artifact' | kw= 'Event' )
            int alt24=3;
            switch ( input.LA(1) ) {
            case 36:
                {
                alt24=1;
                }
                break;
            case 37:
                {
                alt24=2;
                }
                break;
            case 38:
                {
                alt24=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalWorkflow.g:1369:3: kw= 'var'
                    {
                    kw=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getVariableTypeAccess().getVarKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:1375:3: kw= 'Artifact'
                    {
                    kw=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getVariableTypeAccess().getArtifactKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:1381:3: kw= 'Event'
                    {
                    kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getVariableTypeAccess().getEventKeyword_2());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableType"


    // $ANTLR start "entryRuleDisplay"
    // InternalWorkflow.g:1390:1: entryRuleDisplay returns [EObject current=null] : iv_ruleDisplay= ruleDisplay EOF ;
    public final EObject entryRuleDisplay() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDisplay = null;


        try {
            // InternalWorkflow.g:1390:48: (iv_ruleDisplay= ruleDisplay EOF )
            // InternalWorkflow.g:1391:2: iv_ruleDisplay= ruleDisplay EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDisplayRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDisplay=ruleDisplay();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDisplay; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDisplay"


    // $ANTLR start "ruleDisplay"
    // InternalWorkflow.g:1397:1: ruleDisplay returns [EObject current=null] : (otherlv_0= 'print' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleDisplay() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1403:2: ( (otherlv_0= 'print' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            // InternalWorkflow.g:1404:2: (otherlv_0= 'print' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' )
            {
            // InternalWorkflow.g:1404:2: (otherlv_0= 'print' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' )
            // InternalWorkflow.g:1405:3: otherlv_0= 'print' otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDisplayAccess().getPrintKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,19,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDisplayAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalWorkflow.g:1413:3: ( (lv_expression_2_0= ruleExpression ) )
            // InternalWorkflow.g:1414:4: (lv_expression_2_0= ruleExpression )
            {
            // InternalWorkflow.g:1414:4: (lv_expression_2_0= ruleExpression )
            // InternalWorkflow.g:1415:5: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDisplayAccess().getExpressionExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_22);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDisplayRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_2_0,
              						"com.arsene.workflow.Workflow.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getDisplayAccess().getRightParenthesisKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDisplay"


    // $ANTLR start "entryRuleAssignment"
    // InternalWorkflow.g:1440:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // InternalWorkflow.g:1440:51: (iv_ruleAssignment= ruleAssignment EOF )
            // InternalWorkflow.g:1441:2: iv_ruleAssignment= ruleAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignment; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalWorkflow.g:1447:1: ruleAssignment returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_expression_2_0= ruleExpression ) ) | ( (lv_methodInvocation_3_0= ruleMethodInvocation ) ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;

        EObject lv_methodInvocation_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1453:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_expression_2_0= ruleExpression ) ) | ( (lv_methodInvocation_3_0= ruleMethodInvocation ) ) ) ) )
            // InternalWorkflow.g:1454:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_expression_2_0= ruleExpression ) ) | ( (lv_methodInvocation_3_0= ruleMethodInvocation ) ) ) )
            {
            // InternalWorkflow.g:1454:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_expression_2_0= ruleExpression ) ) | ( (lv_methodInvocation_3_0= ruleMethodInvocation ) ) ) )
            // InternalWorkflow.g:1455:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( ( (lv_expression_2_0= ruleExpression ) ) | ( (lv_methodInvocation_3_0= ruleMethodInvocation ) ) )
            {
            // InternalWorkflow.g:1455:3: ( (otherlv_0= RULE_ID ) )
            // InternalWorkflow.g:1456:4: (otherlv_0= RULE_ID )
            {
            // InternalWorkflow.g:1456:4: (otherlv_0= RULE_ID )
            // InternalWorkflow.g:1457:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAssignmentRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getAssignmentAccess().getVariableVariableCrossReference_0_0());
              				
            }

            }


            }

            otherlv_1=(Token)match(input,35,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalWorkflow.g:1472:3: ( ( (lv_expression_2_0= ruleExpression ) ) | ( (lv_methodInvocation_3_0= ruleMethodInvocation ) ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_ID && LA25_0<=RULE_INT)||LA25_0==19||LA25_0==49||(LA25_0>=54 && LA25_0<=56)) ) {
                alt25=1;
            }
            else if ( (LA25_0==23) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalWorkflow.g:1473:4: ( (lv_expression_2_0= ruleExpression ) )
                    {
                    // InternalWorkflow.g:1473:4: ( (lv_expression_2_0= ruleExpression ) )
                    // InternalWorkflow.g:1474:5: (lv_expression_2_0= ruleExpression )
                    {
                    // InternalWorkflow.g:1474:5: (lv_expression_2_0= ruleExpression )
                    // InternalWorkflow.g:1475:6: lv_expression_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentAccess().getExpressionExpressionParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_2_0,
                      							"com.arsene.workflow.Workflow.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:1493:4: ( (lv_methodInvocation_3_0= ruleMethodInvocation ) )
                    {
                    // InternalWorkflow.g:1493:4: ( (lv_methodInvocation_3_0= ruleMethodInvocation ) )
                    // InternalWorkflow.g:1494:5: (lv_methodInvocation_3_0= ruleMethodInvocation )
                    {
                    // InternalWorkflow.g:1494:5: (lv_methodInvocation_3_0= ruleMethodInvocation )
                    // InternalWorkflow.g:1495:6: lv_methodInvocation_3_0= ruleMethodInvocation
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentAccess().getMethodInvocationMethodInvocationParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_methodInvocation_3_0=ruleMethodInvocation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentRule());
                      						}
                      						set(
                      							current,
                      							"methodInvocation",
                      							lv_methodInvocation_3_0,
                      							"com.arsene.workflow.Workflow.MethodInvocation");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleExpression"
    // InternalWorkflow.g:1517:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalWorkflow.g:1517:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalWorkflow.g:1518:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalWorkflow.g:1524:1: ruleExpression returns [EObject current=null] : this_Or_0= ruleOr ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Or_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1530:2: (this_Or_0= ruleOr )
            // InternalWorkflow.g:1531:2: this_Or_0= ruleOr
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getExpressionAccess().getOrParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_Or_0=ruleOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_Or_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleOr"
    // InternalWorkflow.g:1542:1: entryRuleOr returns [EObject current=null] : iv_ruleOr= ruleOr EOF ;
    public final EObject entryRuleOr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOr = null;


        try {
            // InternalWorkflow.g:1542:43: (iv_ruleOr= ruleOr EOF )
            // InternalWorkflow.g:1543:2: iv_ruleOr= ruleOr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOr=ruleOr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOr; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOr"


    // $ANTLR start "ruleOr"
    // InternalWorkflow.g:1549:1: ruleOr returns [EObject current=null] : (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) ;
    public final EObject ruleOr() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_And_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1555:2: ( (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* ) )
            // InternalWorkflow.g:1556:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            {
            // InternalWorkflow.g:1556:2: (this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )* )
            // InternalWorkflow.g:1557:3: this_And_0= ruleAnd ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOrAccess().getAndParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_33);
            this_And_0=ruleAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_And_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalWorkflow.g:1565:3: ( () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==40) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalWorkflow.g:1566:4: () otherlv_2= 'or' ( (lv_right_3_0= ruleAnd ) )
            	    {
            	    // InternalWorkflow.g:1566:4: ()
            	    // InternalWorkflow.g:1567:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getOrAccess().getOrLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,40,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getOrAccess().getOrKeyword_1_1());
            	      			
            	    }
            	    // InternalWorkflow.g:1577:4: ( (lv_right_3_0= ruleAnd ) )
            	    // InternalWorkflow.g:1578:5: (lv_right_3_0= ruleAnd )
            	    {
            	    // InternalWorkflow.g:1578:5: (lv_right_3_0= ruleAnd )
            	    // InternalWorkflow.g:1579:6: lv_right_3_0= ruleAnd
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrAccess().getRightAndParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_33);
            	    lv_right_3_0=ruleAnd();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getOrRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.arsene.workflow.Workflow.And");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOr"


    // $ANTLR start "entryRuleAnd"
    // InternalWorkflow.g:1601:1: entryRuleAnd returns [EObject current=null] : iv_ruleAnd= ruleAnd EOF ;
    public final EObject entryRuleAnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnd = null;


        try {
            // InternalWorkflow.g:1601:44: (iv_ruleAnd= ruleAnd EOF )
            // InternalWorkflow.g:1602:2: iv_ruleAnd= ruleAnd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAnd=ruleAnd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnd; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnd"


    // $ANTLR start "ruleAnd"
    // InternalWorkflow.g:1608:1: ruleAnd returns [EObject current=null] : (this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )* ) ;
    public final EObject ruleAnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Equality_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1614:2: ( (this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )* ) )
            // InternalWorkflow.g:1615:2: (this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )* )
            {
            // InternalWorkflow.g:1615:2: (this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )* )
            // InternalWorkflow.g:1616:3: this_Equality_0= ruleEquality ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndAccess().getEqualityParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_34);
            this_Equality_0=ruleEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Equality_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalWorkflow.g:1624:3: ( () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==41) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalWorkflow.g:1625:4: () otherlv_2= 'and' ( (lv_right_3_0= ruleEquality ) )
            	    {
            	    // InternalWorkflow.g:1625:4: ()
            	    // InternalWorkflow.g:1626:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAndAccess().getAndLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,41,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getAndAccess().getAndKeyword_1_1());
            	      			
            	    }
            	    // InternalWorkflow.g:1636:4: ( (lv_right_3_0= ruleEquality ) )
            	    // InternalWorkflow.g:1637:5: (lv_right_3_0= ruleEquality )
            	    {
            	    // InternalWorkflow.g:1637:5: (lv_right_3_0= ruleEquality )
            	    // InternalWorkflow.g:1638:6: lv_right_3_0= ruleEquality
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndAccess().getRightEqualityParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_right_3_0=ruleEquality();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAndRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.arsene.workflow.Workflow.Equality");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnd"


    // $ANTLR start "entryRuleEquality"
    // InternalWorkflow.g:1660:1: entryRuleEquality returns [EObject current=null] : iv_ruleEquality= ruleEquality EOF ;
    public final EObject entryRuleEquality() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEquality = null;


        try {
            // InternalWorkflow.g:1660:49: (iv_ruleEquality= ruleEquality EOF )
            // InternalWorkflow.g:1661:2: iv_ruleEquality= ruleEquality EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEquality=ruleEquality();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEquality; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEquality"


    // $ANTLR start "ruleEquality"
    // InternalWorkflow.g:1667:1: ruleEquality returns [EObject current=null] : (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) ;
    public final EObject ruleEquality() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Comparison_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1673:2: ( (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* ) )
            // InternalWorkflow.g:1674:2: (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            {
            // InternalWorkflow.g:1674:2: (this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )* )
            // InternalWorkflow.g:1675:3: this_Comparison_0= ruleComparison ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityAccess().getComparisonParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_35);
            this_Comparison_0=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Comparison_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalWorkflow.g:1683:3: ( () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=42 && LA29_0<=43)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalWorkflow.g:1684:4: () ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) ) ( (lv_right_3_0= ruleComparison ) )
            	    {
            	    // InternalWorkflow.g:1684:4: ()
            	    // InternalWorkflow.g:1685:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEqualityAccess().getEqualityLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalWorkflow.g:1691:4: ( ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) ) )
            	    // InternalWorkflow.g:1692:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    {
            	    // InternalWorkflow.g:1692:5: ( (lv_op_2_1= '==' | lv_op_2_2= '!=' ) )
            	    // InternalWorkflow.g:1693:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    {
            	    // InternalWorkflow.g:1693:6: (lv_op_2_1= '==' | lv_op_2_2= '!=' )
            	    int alt28=2;
            	    int LA28_0 = input.LA(1);

            	    if ( (LA28_0==42) ) {
            	        alt28=1;
            	    }
            	    else if ( (LA28_0==43) ) {
            	        alt28=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 28, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt28) {
            	        case 1 :
            	            // InternalWorkflow.g:1694:7: lv_op_2_1= '=='
            	            {
            	            lv_op_2_1=(Token)match(input,42,FOLLOW_18); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getEqualityAccess().getOpEqualsSignEqualsSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getEqualityRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalWorkflow.g:1705:7: lv_op_2_2= '!='
            	            {
            	            lv_op_2_2=(Token)match(input,43,FOLLOW_18); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getEqualityAccess().getOpExclamationMarkEqualsSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getEqualityRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalWorkflow.g:1718:4: ( (lv_right_3_0= ruleComparison ) )
            	    // InternalWorkflow.g:1719:5: (lv_right_3_0= ruleComparison )
            	    {
            	    // InternalWorkflow.g:1719:5: (lv_right_3_0= ruleComparison )
            	    // InternalWorkflow.g:1720:6: lv_right_3_0= ruleComparison
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityAccess().getRightComparisonParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_35);
            	    lv_right_3_0=ruleComparison();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEqualityRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.arsene.workflow.Workflow.Comparison");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEquality"


    // $ANTLR start "entryRuleComparison"
    // InternalWorkflow.g:1742:1: entryRuleComparison returns [EObject current=null] : iv_ruleComparison= ruleComparison EOF ;
    public final EObject entryRuleComparison() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparison = null;


        try {
            // InternalWorkflow.g:1742:51: (iv_ruleComparison= ruleComparison EOF )
            // InternalWorkflow.g:1743:2: iv_ruleComparison= ruleComparison EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComparisonRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComparison=ruleComparison();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComparison; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComparison"


    // $ANTLR start "ruleComparison"
    // InternalWorkflow.g:1749:1: ruleComparison returns [EObject current=null] : (this_PlusOrMinus_0= rulePlusOrMinus ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) ) )* ) ;
    public final EObject ruleComparison() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_PlusOrMinus_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1755:2: ( (this_PlusOrMinus_0= rulePlusOrMinus ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) ) )* ) )
            // InternalWorkflow.g:1756:2: (this_PlusOrMinus_0= rulePlusOrMinus ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) ) )* )
            {
            // InternalWorkflow.g:1756:2: (this_PlusOrMinus_0= rulePlusOrMinus ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) ) )* )
            // InternalWorkflow.g:1757:3: this_PlusOrMinus_0= rulePlusOrMinus ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getComparisonAccess().getPlusOrMinusParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_36);
            this_PlusOrMinus_0=rulePlusOrMinus();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PlusOrMinus_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalWorkflow.g:1765:3: ( () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=44 && LA31_0<=47)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalWorkflow.g:1766:4: () ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) ) ( (lv_right_3_0= rulePlusOrMinus ) )
            	    {
            	    // InternalWorkflow.g:1766:4: ()
            	    // InternalWorkflow.g:1767:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getComparisonAccess().getComparisonLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalWorkflow.g:1773:4: ( ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) ) )
            	    // InternalWorkflow.g:1774:5: ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) )
            	    {
            	    // InternalWorkflow.g:1774:5: ( (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' ) )
            	    // InternalWorkflow.g:1775:6: (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' )
            	    {
            	    // InternalWorkflow.g:1775:6: (lv_op_2_1= '>=' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '<' )
            	    int alt30=4;
            	    switch ( input.LA(1) ) {
            	    case 44:
            	        {
            	        alt30=1;
            	        }
            	        break;
            	    case 45:
            	        {
            	        alt30=2;
            	        }
            	        break;
            	    case 46:
            	        {
            	        alt30=3;
            	        }
            	        break;
            	    case 47:
            	        {
            	        alt30=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 30, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt30) {
            	        case 1 :
            	            // InternalWorkflow.g:1776:7: lv_op_2_1= '>='
            	            {
            	            lv_op_2_1=(Token)match(input,44,FOLLOW_18); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getComparisonAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalWorkflow.g:1787:7: lv_op_2_2= '<='
            	            {
            	            lv_op_2_2=(Token)match(input,45,FOLLOW_18); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getComparisonAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalWorkflow.g:1798:7: lv_op_2_3= '>'
            	            {
            	            lv_op_2_3=(Token)match(input,46,FOLLOW_18); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_3, grammarAccess.getComparisonAccess().getOpGreaterThanSignKeyword_1_1_0_2());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_3, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // InternalWorkflow.g:1809:7: lv_op_2_4= '<'
            	            {
            	            lv_op_2_4=(Token)match(input,47,FOLLOW_18); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_4, grammarAccess.getComparisonAccess().getOpLessThanSignKeyword_1_1_0_3());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_4, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalWorkflow.g:1822:4: ( (lv_right_3_0= rulePlusOrMinus ) )
            	    // InternalWorkflow.g:1823:5: (lv_right_3_0= rulePlusOrMinus )
            	    {
            	    // InternalWorkflow.g:1823:5: (lv_right_3_0= rulePlusOrMinus )
            	    // InternalWorkflow.g:1824:6: lv_right_3_0= rulePlusOrMinus
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getComparisonAccess().getRightPlusOrMinusParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_right_3_0=rulePlusOrMinus();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getComparisonRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.arsene.workflow.Workflow.PlusOrMinus");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparison"


    // $ANTLR start "entryRulePlusOrMinus"
    // InternalWorkflow.g:1846:1: entryRulePlusOrMinus returns [EObject current=null] : iv_rulePlusOrMinus= rulePlusOrMinus EOF ;
    public final EObject entryRulePlusOrMinus() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlusOrMinus = null;


        try {
            // InternalWorkflow.g:1846:52: (iv_rulePlusOrMinus= rulePlusOrMinus EOF )
            // InternalWorkflow.g:1847:2: iv_rulePlusOrMinus= rulePlusOrMinus EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPlusOrMinusRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePlusOrMinus=rulePlusOrMinus();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePlusOrMinus; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePlusOrMinus"


    // $ANTLR start "rulePlusOrMinus"
    // InternalWorkflow.g:1853:1: rulePlusOrMinus returns [EObject current=null] : (this_Mod_0= ruleMod ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMod ) ) )* ) ;
    public final EObject rulePlusOrMinus() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_Mod_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1859:2: ( (this_Mod_0= ruleMod ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMod ) ) )* ) )
            // InternalWorkflow.g:1860:2: (this_Mod_0= ruleMod ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMod ) ) )* )
            {
            // InternalWorkflow.g:1860:2: (this_Mod_0= ruleMod ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMod ) ) )* )
            // InternalWorkflow.g:1861:3: this_Mod_0= ruleMod ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMod ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPlusOrMinusAccess().getModParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_37);
            this_Mod_0=ruleMod();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Mod_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalWorkflow.g:1869:3: ( ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMod ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=48 && LA33_0<=49)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalWorkflow.g:1870:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) ) ( (lv_right_5_0= ruleMod ) )
            	    {
            	    // InternalWorkflow.g:1870:4: ( ( () otherlv_2= '+' ) | ( () otherlv_4= '-' ) )
            	    int alt32=2;
            	    int LA32_0 = input.LA(1);

            	    if ( (LA32_0==48) ) {
            	        alt32=1;
            	    }
            	    else if ( (LA32_0==49) ) {
            	        alt32=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 32, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt32) {
            	        case 1 :
            	            // InternalWorkflow.g:1871:5: ( () otherlv_2= '+' )
            	            {
            	            // InternalWorkflow.g:1871:5: ( () otherlv_2= '+' )
            	            // InternalWorkflow.g:1872:6: () otherlv_2= '+'
            	            {
            	            // InternalWorkflow.g:1872:6: ()
            	            // InternalWorkflow.g:1873:7: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              							current = forceCreateModelElementAndSet(
            	              								grammarAccess.getPlusOrMinusAccess().getPlusLeftAction_1_0_0_0(),
            	              								current);
            	              						
            	            }

            	            }

            	            otherlv_2=(Token)match(input,48,FOLLOW_18); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_2, grammarAccess.getPlusOrMinusAccess().getPlusSignKeyword_1_0_0_1());
            	              					
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalWorkflow.g:1885:5: ( () otherlv_4= '-' )
            	            {
            	            // InternalWorkflow.g:1885:5: ( () otherlv_4= '-' )
            	            // InternalWorkflow.g:1886:6: () otherlv_4= '-'
            	            {
            	            // InternalWorkflow.g:1886:6: ()
            	            // InternalWorkflow.g:1887:7: 
            	            {
            	            if ( state.backtracking==0 ) {

            	              							current = forceCreateModelElementAndSet(
            	              								grammarAccess.getPlusOrMinusAccess().getMinusLeftAction_1_0_1_0(),
            	              								current);
            	              						
            	            }

            	            }

            	            otherlv_4=(Token)match(input,49,FOLLOW_18); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_4, grammarAccess.getPlusOrMinusAccess().getHyphenMinusKeyword_1_0_1_1());
            	              					
            	            }

            	            }


            	            }
            	            break;

            	    }

            	    // InternalWorkflow.g:1899:4: ( (lv_right_5_0= ruleMod ) )
            	    // InternalWorkflow.g:1900:5: (lv_right_5_0= ruleMod )
            	    {
            	    // InternalWorkflow.g:1900:5: (lv_right_5_0= ruleMod )
            	    // InternalWorkflow.g:1901:6: lv_right_5_0= ruleMod
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPlusOrMinusAccess().getRightModParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_37);
            	    lv_right_5_0=ruleMod();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPlusOrMinusRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_5_0,
            	      							"com.arsene.workflow.Workflow.Mod");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePlusOrMinus"


    // $ANTLR start "entryRuleMod"
    // InternalWorkflow.g:1923:1: entryRuleMod returns [EObject current=null] : iv_ruleMod= ruleMod EOF ;
    public final EObject entryRuleMod() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMod = null;


        try {
            // InternalWorkflow.g:1923:44: (iv_ruleMod= ruleMod EOF )
            // InternalWorkflow.g:1924:2: iv_ruleMod= ruleMod EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMod=ruleMod();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMod; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMod"


    // $ANTLR start "ruleMod"
    // InternalWorkflow.g:1930:1: ruleMod returns [EObject current=null] : (this_MulOrDiv_0= ruleMulOrDiv ( ( () ( (lv_op_2_0= '%' ) ) ) ( (lv_right_3_0= ruleMulOrDiv ) ) )* ) ;
    public final EObject ruleMod() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_MulOrDiv_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:1936:2: ( (this_MulOrDiv_0= ruleMulOrDiv ( ( () ( (lv_op_2_0= '%' ) ) ) ( (lv_right_3_0= ruleMulOrDiv ) ) )* ) )
            // InternalWorkflow.g:1937:2: (this_MulOrDiv_0= ruleMulOrDiv ( ( () ( (lv_op_2_0= '%' ) ) ) ( (lv_right_3_0= ruleMulOrDiv ) ) )* )
            {
            // InternalWorkflow.g:1937:2: (this_MulOrDiv_0= ruleMulOrDiv ( ( () ( (lv_op_2_0= '%' ) ) ) ( (lv_right_3_0= ruleMulOrDiv ) ) )* )
            // InternalWorkflow.g:1938:3: this_MulOrDiv_0= ruleMulOrDiv ( ( () ( (lv_op_2_0= '%' ) ) ) ( (lv_right_3_0= ruleMulOrDiv ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getModAccess().getMulOrDivParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_38);
            this_MulOrDiv_0=ruleMulOrDiv();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MulOrDiv_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalWorkflow.g:1946:3: ( ( () ( (lv_op_2_0= '%' ) ) ) ( (lv_right_3_0= ruleMulOrDiv ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==50) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalWorkflow.g:1947:4: ( () ( (lv_op_2_0= '%' ) ) ) ( (lv_right_3_0= ruleMulOrDiv ) )
            	    {
            	    // InternalWorkflow.g:1947:4: ( () ( (lv_op_2_0= '%' ) ) )
            	    // InternalWorkflow.g:1948:5: () ( (lv_op_2_0= '%' ) )
            	    {
            	    // InternalWorkflow.g:1948:5: ()
            	    // InternalWorkflow.g:1949:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getModAccess().getModLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalWorkflow.g:1955:5: ( (lv_op_2_0= '%' ) )
            	    // InternalWorkflow.g:1956:6: (lv_op_2_0= '%' )
            	    {
            	    // InternalWorkflow.g:1956:6: (lv_op_2_0= '%' )
            	    // InternalWorkflow.g:1957:7: lv_op_2_0= '%'
            	    {
            	    lv_op_2_0=(Token)match(input,50,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							newLeafNode(lv_op_2_0, grammarAccess.getModAccess().getOpPercentSignKeyword_1_0_1_0());
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getModRule());
            	      							}
            	      							setWithLastConsumed(current, "op", lv_op_2_0, "%");
            	      						
            	    }

            	    }


            	    }


            	    }

            	    // InternalWorkflow.g:1970:4: ( (lv_right_3_0= ruleMulOrDiv ) )
            	    // InternalWorkflow.g:1971:5: (lv_right_3_0= ruleMulOrDiv )
            	    {
            	    // InternalWorkflow.g:1971:5: (lv_right_3_0= ruleMulOrDiv )
            	    // InternalWorkflow.g:1972:6: lv_right_3_0= ruleMulOrDiv
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getModAccess().getRightMulOrDivParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_right_3_0=ruleMulOrDiv();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getModRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.arsene.workflow.Workflow.MulOrDiv");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMod"


    // $ANTLR start "entryRuleMulOrDiv"
    // InternalWorkflow.g:1994:1: entryRuleMulOrDiv returns [EObject current=null] : iv_ruleMulOrDiv= ruleMulOrDiv EOF ;
    public final EObject entryRuleMulOrDiv() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMulOrDiv = null;


        try {
            // InternalWorkflow.g:1994:49: (iv_ruleMulOrDiv= ruleMulOrDiv EOF )
            // InternalWorkflow.g:1995:2: iv_ruleMulOrDiv= ruleMulOrDiv EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMulOrDivRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMulOrDiv=ruleMulOrDiv();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMulOrDiv; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMulOrDiv"


    // $ANTLR start "ruleMulOrDiv"
    // InternalWorkflow.g:2001:1: ruleMulOrDiv returns [EObject current=null] : (this_Expo_0= ruleExpo ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExpo ) ) )* ) ;
    public final EObject ruleMulOrDiv() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_Expo_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:2007:2: ( (this_Expo_0= ruleExpo ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExpo ) ) )* ) )
            // InternalWorkflow.g:2008:2: (this_Expo_0= ruleExpo ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExpo ) ) )* )
            {
            // InternalWorkflow.g:2008:2: (this_Expo_0= ruleExpo ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExpo ) ) )* )
            // InternalWorkflow.g:2009:3: this_Expo_0= ruleExpo ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExpo ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMulOrDivAccess().getExpoParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_39);
            this_Expo_0=ruleExpo();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Expo_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalWorkflow.g:2017:3: ( ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExpo ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=51 && LA36_0<=52)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalWorkflow.g:2018:4: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) ) ( (lv_right_3_0= ruleExpo ) )
            	    {
            	    // InternalWorkflow.g:2018:4: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) ) )
            	    // InternalWorkflow.g:2019:5: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
            	    {
            	    // InternalWorkflow.g:2019:5: ()
            	    // InternalWorkflow.g:2020:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getMulOrDivAccess().getMulOrDivLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalWorkflow.g:2026:5: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) ) )
            	    // InternalWorkflow.g:2027:6: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    {
            	    // InternalWorkflow.g:2027:6: ( (lv_op_2_1= '*' | lv_op_2_2= '/' ) )
            	    // InternalWorkflow.g:2028:7: (lv_op_2_1= '*' | lv_op_2_2= '/' )
            	    {
            	    // InternalWorkflow.g:2028:7: (lv_op_2_1= '*' | lv_op_2_2= '/' )
            	    int alt35=2;
            	    int LA35_0 = input.LA(1);

            	    if ( (LA35_0==51) ) {
            	        alt35=1;
            	    }
            	    else if ( (LA35_0==52) ) {
            	        alt35=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 35, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt35) {
            	        case 1 :
            	            // InternalWorkflow.g:2029:8: lv_op_2_1= '*'
            	            {
            	            lv_op_2_1=(Token)match(input,51,FOLLOW_18); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_1, grammarAccess.getMulOrDivAccess().getOpAsteriskKeyword_1_0_1_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getMulOrDivRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              							
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalWorkflow.g:2040:8: lv_op_2_2= '/'
            	            {
            	            lv_op_2_2=(Token)match(input,52,FOLLOW_18); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_op_2_2, grammarAccess.getMulOrDivAccess().getOpSolidusKeyword_1_0_1_0_1());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getMulOrDivRule());
            	              								}
            	              								setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              							
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }

            	    // InternalWorkflow.g:2054:4: ( (lv_right_3_0= ruleExpo ) )
            	    // InternalWorkflow.g:2055:5: (lv_right_3_0= ruleExpo )
            	    {
            	    // InternalWorkflow.g:2055:5: (lv_right_3_0= ruleExpo )
            	    // InternalWorkflow.g:2056:6: lv_right_3_0= ruleExpo
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMulOrDivAccess().getRightExpoParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_39);
            	    lv_right_3_0=ruleExpo();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMulOrDivRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.arsene.workflow.Workflow.Expo");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMulOrDiv"


    // $ANTLR start "entryRuleExpo"
    // InternalWorkflow.g:2078:1: entryRuleExpo returns [EObject current=null] : iv_ruleExpo= ruleExpo EOF ;
    public final EObject entryRuleExpo() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpo = null;


        try {
            // InternalWorkflow.g:2078:45: (iv_ruleExpo= ruleExpo EOF )
            // InternalWorkflow.g:2079:2: iv_ruleExpo= ruleExpo EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpoRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpo=ruleExpo();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpo; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpo"


    // $ANTLR start "ruleExpo"
    // InternalWorkflow.g:2085:1: ruleExpo returns [EObject current=null] : (this_Primary_0= rulePrimary ( ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleExpo() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:2091:2: ( (this_Primary_0= rulePrimary ( ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // InternalWorkflow.g:2092:2: (this_Primary_0= rulePrimary ( ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // InternalWorkflow.g:2092:2: (this_Primary_0= rulePrimary ( ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= rulePrimary ) ) )* )
            // InternalWorkflow.g:2093:3: this_Primary_0= rulePrimary ( ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= rulePrimary ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getExpoAccess().getPrimaryParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_40);
            this_Primary_0=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Primary_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalWorkflow.g:2101:3: ( ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= rulePrimary ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==53) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalWorkflow.g:2102:4: ( () ( (lv_op_2_0= '^' ) ) ) ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // InternalWorkflow.g:2102:4: ( () ( (lv_op_2_0= '^' ) ) )
            	    // InternalWorkflow.g:2103:5: () ( (lv_op_2_0= '^' ) )
            	    {
            	    // InternalWorkflow.g:2103:5: ()
            	    // InternalWorkflow.g:2104:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getExpoAccess().getExpoLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalWorkflow.g:2110:5: ( (lv_op_2_0= '^' ) )
            	    // InternalWorkflow.g:2111:6: (lv_op_2_0= '^' )
            	    {
            	    // InternalWorkflow.g:2111:6: (lv_op_2_0= '^' )
            	    // InternalWorkflow.g:2112:7: lv_op_2_0= '^'
            	    {
            	    lv_op_2_0=(Token)match(input,53,FOLLOW_18); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							newLeafNode(lv_op_2_0, grammarAccess.getExpoAccess().getOpCircumflexAccentKeyword_1_0_1_0());
            	      						
            	    }
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getExpoRule());
            	      							}
            	      							setWithLastConsumed(current, "op", lv_op_2_0, "^");
            	      						
            	    }

            	    }


            	    }


            	    }

            	    // InternalWorkflow.g:2125:4: ( (lv_right_3_0= rulePrimary ) )
            	    // InternalWorkflow.g:2126:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // InternalWorkflow.g:2126:5: (lv_right_3_0= rulePrimary )
            	    // InternalWorkflow.g:2127:6: lv_right_3_0= rulePrimary
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getExpoAccess().getRightPrimaryParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_40);
            	    lv_right_3_0=rulePrimary();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getExpoRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.arsene.workflow.Workflow.Primary");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpo"


    // $ANTLR start "entryRulePrimary"
    // InternalWorkflow.g:2149:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalWorkflow.g:2149:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalWorkflow.g:2150:2: iv_rulePrimary= rulePrimary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimary=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimary; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalWorkflow.g:2156:1: rulePrimary returns [EObject current=null] : ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () otherlv_4= '!' ( (lv_expression_5_0= rulePrimary ) ) ) | ( () otherlv_7= '-' ( (lv_expression_8_0= rulePrimary ) ) ) | this_Atomic_9= ruleAtomic ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject this_Expression_1 = null;

        EObject lv_expression_5_0 = null;

        EObject lv_expression_8_0 = null;

        EObject this_Atomic_9 = null;



        	enterRule();

        try {
            // InternalWorkflow.g:2162:2: ( ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () otherlv_4= '!' ( (lv_expression_5_0= rulePrimary ) ) ) | ( () otherlv_7= '-' ( (lv_expression_8_0= rulePrimary ) ) ) | this_Atomic_9= ruleAtomic ) )
            // InternalWorkflow.g:2163:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () otherlv_4= '!' ( (lv_expression_5_0= rulePrimary ) ) ) | ( () otherlv_7= '-' ( (lv_expression_8_0= rulePrimary ) ) ) | this_Atomic_9= ruleAtomic )
            {
            // InternalWorkflow.g:2163:2: ( (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' ) | ( () otherlv_4= '!' ( (lv_expression_5_0= rulePrimary ) ) ) | ( () otherlv_7= '-' ( (lv_expression_8_0= rulePrimary ) ) ) | this_Atomic_9= ruleAtomic )
            int alt38=4;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt38=1;
                }
                break;
            case 54:
                {
                alt38=2;
                }
                break;
            case 49:
                {
                alt38=3;
                }
                break;
            case RULE_ID:
            case RULE_STRING:
            case RULE_INT:
            case 55:
            case 56:
                {
                alt38=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalWorkflow.g:2164:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    {
                    // InternalWorkflow.g:2164:3: (otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')' )
                    // InternalWorkflow.g:2165:4: otherlv_0= '(' this_Expression_1= ruleExpression otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,19,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_0_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrimaryAccess().getExpressionParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_22);
                    this_Expression_1=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Expression_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_2=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getPrimaryAccess().getRightParenthesisKeyword_0_2());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:2183:3: ( () otherlv_4= '!' ( (lv_expression_5_0= rulePrimary ) ) )
                    {
                    // InternalWorkflow.g:2183:3: ( () otherlv_4= '!' ( (lv_expression_5_0= rulePrimary ) ) )
                    // InternalWorkflow.g:2184:4: () otherlv_4= '!' ( (lv_expression_5_0= rulePrimary ) )
                    {
                    // InternalWorkflow.g:2184:4: ()
                    // InternalWorkflow.g:2185:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryAccess().getNotAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_4=(Token)match(input,54,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getPrimaryAccess().getExclamationMarkKeyword_1_1());
                      			
                    }
                    // InternalWorkflow.g:2195:4: ( (lv_expression_5_0= rulePrimary ) )
                    // InternalWorkflow.g:2196:5: (lv_expression_5_0= rulePrimary )
                    {
                    // InternalWorkflow.g:2196:5: (lv_expression_5_0= rulePrimary )
                    // InternalWorkflow.g:2197:6: lv_expression_5_0= rulePrimary
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrimaryAccess().getExpressionPrimaryParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_5_0=rulePrimary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_5_0,
                      							"com.arsene.workflow.Workflow.Primary");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:2216:3: ( () otherlv_7= '-' ( (lv_expression_8_0= rulePrimary ) ) )
                    {
                    // InternalWorkflow.g:2216:3: ( () otherlv_7= '-' ( (lv_expression_8_0= rulePrimary ) ) )
                    // InternalWorkflow.g:2217:4: () otherlv_7= '-' ( (lv_expression_8_0= rulePrimary ) )
                    {
                    // InternalWorkflow.g:2217:4: ()
                    // InternalWorkflow.g:2218:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryAccess().getArithmeticSignedAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_7=(Token)match(input,49,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getPrimaryAccess().getHyphenMinusKeyword_2_1());
                      			
                    }
                    // InternalWorkflow.g:2228:4: ( (lv_expression_8_0= rulePrimary ) )
                    // InternalWorkflow.g:2229:5: (lv_expression_8_0= rulePrimary )
                    {
                    // InternalWorkflow.g:2229:5: (lv_expression_8_0= rulePrimary )
                    // InternalWorkflow.g:2230:6: lv_expression_8_0= rulePrimary
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrimaryAccess().getExpressionPrimaryParserRuleCall_2_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_8_0=rulePrimary();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrimaryRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_8_0,
                      							"com.arsene.workflow.Workflow.Primary");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:2249:3: this_Atomic_9= ruleAtomic
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryAccess().getAtomicParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Atomic_9=ruleAtomic();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Atomic_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleAtomic"
    // InternalWorkflow.g:2261:1: entryRuleAtomic returns [EObject current=null] : iv_ruleAtomic= ruleAtomic EOF ;
    public final EObject entryRuleAtomic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomic = null;


        try {
            // InternalWorkflow.g:2261:47: (iv_ruleAtomic= ruleAtomic EOF )
            // InternalWorkflow.g:2262:2: iv_ruleAtomic= ruleAtomic EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAtomic=ruleAtomic();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomic; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomic"


    // $ANTLR start "ruleAtomic"
    // InternalWorkflow.g:2268:1: ruleAtomic returns [EObject current=null] : ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) ) ;
    public final EObject ruleAtomic() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;
        Token lv_value_3_0=null;
        Token lv_value_5_1=null;
        Token lv_value_5_2=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalWorkflow.g:2274:2: ( ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) ) )
            // InternalWorkflow.g:2275:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) )
            {
            // InternalWorkflow.g:2275:2: ( ( () ( (lv_value_1_0= RULE_INT ) ) ) | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) ) | ( () ( (otherlv_7= RULE_ID ) ) ) )
            int alt40=4;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt40=1;
                }
                break;
            case RULE_STRING:
                {
                alt40=2;
                }
                break;
            case 55:
            case 56:
                {
                alt40=3;
                }
                break;
            case RULE_ID:
                {
                alt40=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalWorkflow.g:2276:3: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    {
                    // InternalWorkflow.g:2276:3: ( () ( (lv_value_1_0= RULE_INT ) ) )
                    // InternalWorkflow.g:2277:4: () ( (lv_value_1_0= RULE_INT ) )
                    {
                    // InternalWorkflow.g:2277:4: ()
                    // InternalWorkflow.g:2278:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getIntConstantAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalWorkflow.g:2284:4: ( (lv_value_1_0= RULE_INT ) )
                    // InternalWorkflow.g:2285:5: (lv_value_1_0= RULE_INT )
                    {
                    // InternalWorkflow.g:2285:5: (lv_value_1_0= RULE_INT )
                    // InternalWorkflow.g:2286:6: lv_value_1_0= RULE_INT
                    {
                    lv_value_1_0=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_1_0, grammarAccess.getAtomicAccess().getValueINTTerminalRuleCall_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAtomicRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_1_0,
                      							"org.eclipse.xtext.common.Terminals.INT");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:2304:3: ( () ( (lv_value_3_0= RULE_STRING ) ) )
                    {
                    // InternalWorkflow.g:2304:3: ( () ( (lv_value_3_0= RULE_STRING ) ) )
                    // InternalWorkflow.g:2305:4: () ( (lv_value_3_0= RULE_STRING ) )
                    {
                    // InternalWorkflow.g:2305:4: ()
                    // InternalWorkflow.g:2306:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getStringConstantAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalWorkflow.g:2312:4: ( (lv_value_3_0= RULE_STRING ) )
                    // InternalWorkflow.g:2313:5: (lv_value_3_0= RULE_STRING )
                    {
                    // InternalWorkflow.g:2313:5: (lv_value_3_0= RULE_STRING )
                    // InternalWorkflow.g:2314:6: lv_value_3_0= RULE_STRING
                    {
                    lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_3_0, grammarAccess.getAtomicAccess().getValueSTRINGTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAtomicRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_3_0,
                      							"org.eclipse.xtext.common.Terminals.STRING");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalWorkflow.g:2332:3: ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) )
                    {
                    // InternalWorkflow.g:2332:3: ( () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) ) )
                    // InternalWorkflow.g:2333:4: () ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) )
                    {
                    // InternalWorkflow.g:2333:4: ()
                    // InternalWorkflow.g:2334:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getBoolConstantAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalWorkflow.g:2340:4: ( ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) ) )
                    // InternalWorkflow.g:2341:5: ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) )
                    {
                    // InternalWorkflow.g:2341:5: ( (lv_value_5_1= 'true' | lv_value_5_2= 'false' ) )
                    // InternalWorkflow.g:2342:6: (lv_value_5_1= 'true' | lv_value_5_2= 'false' )
                    {
                    // InternalWorkflow.g:2342:6: (lv_value_5_1= 'true' | lv_value_5_2= 'false' )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==55) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==56) ) {
                        alt39=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 0, input);

                        throw nvae;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalWorkflow.g:2343:7: lv_value_5_1= 'true'
                            {
                            lv_value_5_1=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_value_5_1, grammarAccess.getAtomicAccess().getValueTrueKeyword_2_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAtomicRule());
                              							}
                              							setWithLastConsumed(current, "value", lv_value_5_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalWorkflow.g:2354:7: lv_value_5_2= 'false'
                            {
                            lv_value_5_2=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_value_5_2, grammarAccess.getAtomicAccess().getValueFalseKeyword_2_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAtomicRule());
                              							}
                              							setWithLastConsumed(current, "value", lv_value_5_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalWorkflow.g:2369:3: ( () ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalWorkflow.g:2369:3: ( () ( (otherlv_7= RULE_ID ) ) )
                    // InternalWorkflow.g:2370:4: () ( (otherlv_7= RULE_ID ) )
                    {
                    // InternalWorkflow.g:2370:4: ()
                    // InternalWorkflow.g:2371:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicAccess().getVariableRefAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalWorkflow.g:2377:4: ( (otherlv_7= RULE_ID ) )
                    // InternalWorkflow.g:2378:5: (otherlv_7= RULE_ID )
                    {
                    // InternalWorkflow.g:2378:5: (otherlv_7= RULE_ID )
                    // InternalWorkflow.g:2379:6: otherlv_7= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAtomicRule());
                      						}
                      					
                    }
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_7, grammarAccess.getAtomicAccess().getVariableVariableCrossReference_3_1_0());
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomic"


    // $ANTLR start "ruleWorkflowType"
    // InternalWorkflow.g:2395:1: ruleWorkflowType returns [Enumerator current=null] : ( (enumLiteral_0= 'sequence' ) | (enumLiteral_1= 'parallel' ) ) ;
    public final Enumerator ruleWorkflowType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalWorkflow.g:2401:2: ( ( (enumLiteral_0= 'sequence' ) | (enumLiteral_1= 'parallel' ) ) )
            // InternalWorkflow.g:2402:2: ( (enumLiteral_0= 'sequence' ) | (enumLiteral_1= 'parallel' ) )
            {
            // InternalWorkflow.g:2402:2: ( (enumLiteral_0= 'sequence' ) | (enumLiteral_1= 'parallel' ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==57) ) {
                alt41=1;
            }
            else if ( (LA41_0==58) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalWorkflow.g:2403:3: (enumLiteral_0= 'sequence' )
                    {
                    // InternalWorkflow.g:2403:3: (enumLiteral_0= 'sequence' )
                    // InternalWorkflow.g:2404:4: enumLiteral_0= 'sequence'
                    {
                    enumLiteral_0=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getWorkflowTypeAccess().getSequenceEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getWorkflowTypeAccess().getSequenceEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalWorkflow.g:2411:3: (enumLiteral_1= 'parallel' )
                    {
                    // InternalWorkflow.g:2411:3: (enumLiteral_1= 'parallel' )
                    // InternalWorkflow.g:2412:4: enumLiteral_1= 'parallel'
                    {
                    enumLiteral_1=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getWorkflowTypeAccess().getParallelEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getWorkflowTypeAccess().getParallelEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWorkflowType"

    // $ANTLR start synpred1_InternalWorkflow
    public final void synpred1_InternalWorkflow_fragment() throws RecognitionException {   
        // InternalWorkflow.g:1002:5: ( 'else' )
        // InternalWorkflow.g:1002:6: 'else'
        {
        match(input,26,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalWorkflow

    // Delegated rules

    public final boolean synpred1_InternalWorkflow() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalWorkflow_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000F17A840812L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0600000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x00000000000A0000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000007170200000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000007170000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000F17AC04010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x01C2000000080070L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x01C2000000280070L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000000F17A802010L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000A00000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000400000040L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x01C200F17A880070L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x00000C0000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000F00000000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0018000000000002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0020000000000002L});

}