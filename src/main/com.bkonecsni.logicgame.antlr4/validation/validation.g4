grammar validation;

validation:  statementList ;

statementList :	statement+ ;

statement :	variableDeclaration
	|	ifStatement
	|	block
	|	assignmentStatement ;

variableDeclaration : typeName varName ('=' expression)? ';' ;

typeName :	ID ;

varName :	ID ;

ifStatement : 	'if' '(' expression ')' block ;

block :	'{' statementList '}' ;

assignmentStatement : varName '=' expression ';' ;

expression
	: varName
	| NUMBER
	| STRING
	| BOOL
	| NULL
	;

ID: [a-zA-Z0-9][a-zA-Z0-9_]* ;

NUMBER: [0-9] | ([1-9] [0-9]*) ;
STRING : '"' (~[\r\n"])* '"' ;
BOOL: 'true' | 'false' ;
NULL : 'null';

WS : [ \t\r\n]+ -> skip ;