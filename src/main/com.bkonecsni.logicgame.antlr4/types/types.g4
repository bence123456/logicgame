grammar types;

types: typedecl+ ;

typedecl: typehead typedef ;
typedef: loop | typestatement+ ;
typehead: T NUMBER COL ;
loop: ITEMS parens_nr COL LOOP LP params RP;
params: (item COMMA)* item ;

typestatement: condition (COMMA condition)* ARR updatestatement (COMMA updatestatement)* ;

condition: ITEMS parens_nr ISEQ item ;
updatestatement: ITEMS parens_nr EQ item ;

parens_nr: LP NUMBER RP ;
item: NUMBER | CHAR | COLOR | SYMBOL | EMPTY_STRING ;
EMPTY_STRING: EMPTY ;

NUMBER: [0-9] | ([1-9] [0-9]*) ;
CHAR:   [A-Z] ;
COLOR:  '#' ((HDN HDN HDN HDN HDN HDN) | (HDN HDN HDN)) ;
HDN: [A-F] | [a-f] | [0-9] ;
SYMBOL: 'S' NUMBER ;

ITEMS: 'items' ;
T: 'Type' ;
EMPTY: 'empty' ;
LOOP: 'Loop' ;

ISEQ: '==' ;
EQ: '=' ;

LP:  '(' ;
RP:  ')' ;
COMMA: ',' ;
ARR: '->' ;
COL: ':' ;

WS : [ \t\r\n]+ -> skip ;