grammar types;

import statementList;

types: typedecl+ ;

typedecl: typehead typedef? ;
typedef: loop | typestatement+ | statementList ;
typehead: T NUMBER COL ;
loop: ITEMS parens_nr COL LOOP LP typeparams RP;
typeparams: (typeitem COMMA)* typeitem ;

typestatement: condition (COMMA condition)* ARR updatestatement (COMMA updatestatement)* ;

condition: ITEMS parens_nr ISEQ typeitem ;
updatestatement: ITEMS parens_nr EQ typeitem ;

parens_nr: LP NUMBER RP ;
typeitem: NUMBER | CHAR | COLOR | SYMBOL | EMPTY_STRING ;
EMPTY_STRING: EMPTY ;

ITEMS: 'items' ;
T: 'Type' ;
EMPTY: 'empty' ;
LOOP: 'Loop' ;

ISEQ: '==' ;
EQ: '=' ;
ARR: '->' ;
COL: ':' ;

WS : [ \t\r\n]+ -> skip ;