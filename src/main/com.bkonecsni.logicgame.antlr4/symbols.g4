grammar symbols;

symbols: symbol* ;

symbol: SYMBOL_ID ':' NAME ;
NAME: [A-Za-z]+ ;

NUMBER: [0-9] | ([1-9] [0-9]*) ;
SYMBOL_ID: 'S' NUMBER ;

COL: ':' ;

WS : [ \t\r\n]+ -> skip ;