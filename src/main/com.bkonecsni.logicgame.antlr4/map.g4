grammar map;

map: tile* ;

tile: TILE type AT position size? COMMA  itemList ;

itemList: ITEMS LCBR color? item* RCBR;

type: T NUMBER ;
position: LP NUMBER COMMA NUMBER RP ;
size: COMMA LBR NUMBER COMMA NUMBER RBR ;

color: LBR COLOR RBR ;
item: LBR (NUMBER | CHAR | SYMBOL) RBR;

NUMBER: [0-9]+ | ([1-9] [0-9]*) ;
CHAR:   [A-E] ;
COLOR:  '#' ((HDN HDN HDN HDN HDN HDN) | (HDN HDN HDN)) ;
HDN: [A-F] | [a-f] | [0-9] ;
SYMBOL: 'S' NUMBER ;

TILE: 'tile:' ;
ITEMS: 'items:' ;
T: 'Type' ;

LP:  '(' ;
RP:  ')' ;
COMMA: ',' ;
AT: '@' ;
LBR: '[' ;
RBR: ']' ;
LCBR: '{' ;
RCBR: '}' ;

WS : [ \t\r\n]+ -> skip ;
