grammar simple_validation;

validation: win+ ;

win: func ISEQ BOOL ;
BOOL: TRUE | FALSE ;

func: funcname LP params? RP ;
funcname: ID ;
params: param (COMMA param)* ;

param: item | NUMBER  ;
item: '[' (NUMBER | CHAR | COLOR | SYMBOL) ']' ;

ID: [a-z] [A-Za-z]* ;
NUMBER: [0-9] | ([1-9] [0-9]*) ;
CHAR:   [A-Z] ;
COLOR:  '#' ((HDN HDN HDN HDN HDN HDN) | (HDN HDN HDN)) ;
HDN: [A-F] | [a-f] | [0-9] ;
SYMBOL: 'S' NUMBER ;

ISEQ: '==' ;
TRUE: 'true' ;
FALSE: 'false' ;

LP:  '(' ;
RP:  ')' ;
COMMA: ',' ;

WS : [ \t\r\n]+ -> skip ;