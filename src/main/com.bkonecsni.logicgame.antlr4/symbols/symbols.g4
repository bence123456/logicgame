grammar symbols;

symbols: symbol+ ;

symbol: SYMBOL COL PATH ;
PATH: [A-Za-z // \\ //_ /.]+ ;

NUMBER: [0-9] | ([1-9] [0-9]*) ;
SYMBOL: 'S' NUMBER ;

COL: ':' ;

WS : [ \t\r\n]+ -> skip ;