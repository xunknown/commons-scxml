/*
 *    
 *   Copyright 2004 The Apache Software Foundation.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.apache.taglibs.rdc.scxml;

/**
 * An interface for reporting SCXML errors to the host environment,
 * containing the definition of commonly occuring errors while executing
 * SCXML documents.
 * 
 * @author Jaroslav Gergic
 * @author Rahul Akolkar
 */
public interface ErrorReporter {

    /**
     * @param errCode
     *            one of the ErrorReporter's constants
     * @param errDetail
     *            human readable description
     * @param errCtx
     *            typically an SCXML element which caused an error, 
     *            may be accompanied by additional information
     */
    public void onError(String errCode, String errDetail, Object errCtx);

    /**
     * Missing initial state for a composite state or for the smxml root.
     * 
     * @see org.apache.taglibs.rdc.scxml.model.SCXML#getInitialState()
     * @see org.apache.taglibs.rdc.scxml.model.State#getInitial()
     */
    public static final String NO_INITIAL = "NO_INITIAL";
    
    /**
     * An initial state for a composite state whose Transition does not
     * Map to a descendant of the composite state.
     * 
     */
    public static final String ILLEGAL_INITIAL = "ILLEGAL_INITIAL";

    /**
     * Unknown action - unsupported executable content. List of supported
     * actions: assign, cancel, elseif, else, if, log, send, var
     */
    public static final String UNKNOWN_ACTION = "UNKNOWN_ACTION";
    
    /**
     * Illegal state machine configuration.
     * Either a parallel exists which does not have all its AND sub-states 
     * active or there are multiple enabled OR states on the same level.  
     */
    public static final String ILLEGAL_CONFIG = "ILLEGAL_CONFIG";
    
    /**
     * Non-deterministic situation has occured - there are more than
     * one enabled transitions in conflict.
     */
    public static final String NON_DETERMINISTIC = "NON_DETERMINISTIC";
    
    /**
     * A variable reffered to by assign@name is undefined.
     */
    public static final String UNDEFINED_VARIABLE = "UNDEFINED_VARIABLE";
    
    /**
     * An expression language error. 
     */
    public static final String EXPRESSION_ERROR = "EXPRESSION_ERROR";
    
}
