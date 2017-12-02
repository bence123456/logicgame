grammar validation;

validation: WIN win+ LOOSE? loose* ;

win: func ISEQ BOOL ;
loose: func ISEQ BOOL ;
BOOL: TRUE | FALSE ;

func: funcname LP params? RP ;
funcname: ID ;
params: (item COMMA)* item ;

parens_nr: LP NUMBER RP ;
item: NUMBER | CHAR | COLOR | SYMBOL | AREA_DEF ;
AREA_DEF: 'COLOR' | 'RECT' ;

ID: [a-z] [A-Za-z]* ;
NUMBER: [0-9] | ([1-9] [0-9]*) ;
CHAR:   [A-Z] ;
COLOR:  '#' ((HDN HDN HDN HDN HDN HDN) | (HDN HDN HDN)) ;
HDN: [A-F] | [a-f] | [0-9] ;
SYMBOL: 'S' NUMBER ;

WIN: 'win' COL ;
LOOSE: 'loose' COL ;

ISEQ: '==' ;
TRUE: 'true' ;
FALSE: 'false' ;
EMPTY: 'empty' ;

LP:  '(' ;
RP:  ')' ;
COMMA: ',' ;
COL: ':' ;

WS : [ \t\r\n]+ -> skip ;