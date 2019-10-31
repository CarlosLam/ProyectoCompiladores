package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
%column
%line
L=[a-zA-Z]
G=[_]
D=[0-9]
P=[.]
S=[+-]
espacio=[ \t\r\n]

%{
    public String lexeme;
    public int col;
    public int lin;
%}
%%


/* DML with out subquerys*/
"SELECT" {lexeme=yytext(); row = yyline; col = yycolumn; return select;} 
"INSERT" {lexeme=yytext(); row = yyline; col = yycolumn; return insert;} 
"UPDATE" {lexeme=yytext(); row = yyline; col = yycolumn; return update;} 
"DELETE" {lexeme=yytext(); row = yyline; col = yycolumn; return delete;} 

/* DDL */
"CREATE" {lexeme=yytext(); row = yyline; col = yycolumn; return create;} 
"ALTER" {lexeme=yytext(); row = yyline; col = yycolumn; return alter;} 
"DROP" {lexeme=yytext(); row = yyline; col = yycolumn; return drop;} 
"TRUNCATE" {lexeme=yytext(); row = yyline; col = yycolumn; return truncate;} 

/* TCL */
"BEGIN" {lexeme=yytext(); row = yyline; C1 = yycolumn; return begin;} 
"TRANSACTION" {lexeme=yytext(); row = yyline; C1 = yycolumn; return transaction;} 
"COMMIT" {lexeme=yytext(); row = yyline; C1 = yycolumn; return commit;}     
"ROLLBACK" {lexeme=yytext(); row = yyline; C1 = yycolumn; return rollback;} 
"SAVE" {lexeme=yytext(); row = yyline; C1 = yycolumn; return save;} 
"POINT" {lexeme=yytext(); row = yyline; C1 = yycolumn; return point;} 
"END" {lexeme=yytext(); row = yyline; C1 = yycolumn; return end;} 
"FUNCTION" {lexeme=yytext(); row = yyline; C1 = yycolumn; return function;} 
"CURSOR" {lexeme=yytext(); row = yyline; C1 = yycolumn; return cursor;} 
"PROCEDURE" {lexeme=yytext(); row = yyline; C1 = yycolumn; return procedure;} 
/* Reservadas */
"JOIN" {lexeme=yytext(); row = yyline; C1 = yycolumn; return join;} 
"INNER" {lexeme=yytext(); row = yyline; C1 = yycolumn; return inner;} 
"LEFT" {lexeme=yytext(); row = yyline; C1 = yycolumn; return left;} 
"RIGHT" {lexeme=yytext(); row = yyline; C1 = yycolumn; return right;}
"OUTER" {lexeme=yytext(); row = yyline; C1 = yycolumn; return outer;} 
"VIEW" {lexeme=yytext(); row = yyline; C1 = yycolumn; return view;}     
"IF" {lexeme=yytext(); row = yyline; C1 = yycolumn; return iflit;} 
"ELSE" {lexeme=yytext(); row = yyline; C1 = yycolumn; return elselit;} 
"FROM" {lexeme=yytext(); row = yyline; C1 = yycolumn; return from;} 
"BETWEEN" {lexeme=yytext(); row = yyline; C1 = yycolumn; return between;} 
"GRANT" {lexeme=yytext(); row = yyline; C1 = yycolumn; return grant;} 
"REVOKE" {lexeme=yytext(); row = yyline; C1 = yycolumn; return revoke;} 
"GROUP" {lexeme=yytext(); row = yyline; C1 = yycolumn; return group;} 
"BY" {lexeme=yytext(); row = yyline; C1 = yycolumn; return by;} 
"RESTORE" {lexeme=yytext(); row = yyline; C1 = yycolumn; return restore;} 
"TABLE" {lexeme=yytext(); row = yyline; C1 = yycolumn; return table;} 
"VARCHAR" {lexeme=yytext(); row = yyline; C1 = yycolumn; return varchar;} 
"INT" {lexeme=yytext(); row = yyline; C1 = yycolumn; return intlit;} 
"BIT" {lexeme=yytext(); row = yyline; C1 = yycolumn; return bitlit;} 
"IDENTITY" {lexeme=yytext(); row = yyline; C1 = yycolumn; return identity;} 
"NOT" {lexeme=yytext(); row = yyline; C1 = yycolumn; return notlit;} 
"NULL" {lexeme=yytext(); row = yyline; C1 = yycolumn; return nulllit;} 
"CONSTRAIN" {lexeme=yytext(); row = yyline; C1 = yycolumn; return constrain;} 
"PRIMARY" {lexeme=yytext(); row = yyline; C1 = yycolumn; return primary;} 
"ASC" {lexeme=yytext(); row = yyline; C1 = yycolumn; return asc;} 
"ASCENDENT" {lexeme=yytext(); row = yyline; C1 = yycolumn; return ascfull;} 
"DESCENDENT" {lexeme=yytext(); row = yyline; C1 = yycolumn; return descfull;} 
"USER" {lexeme=yytext(); row = yyline; C1 = yycolumn; return user;} 
"DESC" {lexeme=yytext(); row = yyline; C1 = yycolumn; return desc;} 
"INDEX" {lexeme=yytext(); row = yyline; C1 = yycolumn; return index;} 
"DATABASE" {lexeme=yytext(); row = yyline; C1 = yycolumn; return db;}
"STORED" {lexeme=yytext(); row = yyline; C1 = yycolumn; return stored;} 
"VALUE" {lexeme=yytext(); row = yyline; C1 = yycolumn; return value;} 
"SET" {lexeme=yytext(); row = yyline; C1 = yycolumn; return set;} 
"SUM" {lexeme=yytext(); row = yyline; C1 = yycolumn; return sum;} 
"COUNT" {lexeme=yytext(); row = yyline; C1 = yycolumn; return count;}
"GO" {lexeme=yytext(); row = yyline; C1 = yycolumn; return go;} 
"AVG" {lexeme=yytext(); row = yyline; C1 = yycolumn; return avg;} 
"FLOAT" {lexeme=yytext(); row = yyline; C1 = yycolumn; return floatlit;} 
"WHERE" {lexeme=yytext(); row = yyline; C1 = yycolumn; return wherelit;} 
"OR" {lexeme=yytext(); row = yyline; C1 = yycolumn; return orlit;} 
"OF" {lexeme=yytext(); row = yyline; C1 = yycolumn; return oflit;}
"WHEN" {lexeme=yytext(); row = yyline; C1 = yycolumn ; return whenlit;} 
"WITH" {lexeme=yytext(); row = yyline; C1 = yycolumn; return withlit;} 
"EXIT" {lexeme=yytext(); row = yyline; C1 = yycolumn; return exit;} 
"TOP" {lexeme=yytext(); row = yyline; C1 = yycolumn; return top;} 
"CHAR" {lexeme=yytext(); row = yyline; C1 = yycolumn; return charlit;} 
"INTEGER" {lexeme=yytext(); row = yyline; C1 = yycolumn; return integerlit;} 
"MIN" {lexeme=yytext(); row = yyline; C1 = yycolumn; return min;} 
"MAX" {lexeme=yytext(); row = yyline; C1 = yycolumn; return max;} 
"USE" {lexeme=yytext(); row = yyline; C1 = yycolumn; return use;} 
"IN" {lexeme=yytext(); row = yyline; C1 = yycolumn; return use;} 
"IS"  {lexeme=yytext(); row = yyline; C1 = yycolumn; return is;} 
"ON"  {lexeme=yytext(); row = yyline; C1 = yycolumn; return on;} 

/* Datos */
({digit})+ {lexeme = yytext();row = yyline; C1 = yycolumn;return Entero;}
\'{SChar}*\' {lexeme=yytext(); row=yyline;  C1=yycolumn;return Cadena;}
{Float} {lexeme=yytext(); row=yyline; C1=yycolumn; return Float;}
{Ident}{31,100} {lexeme=yytext(); row = yyline; C1 = yycolumn; return IdentificadorExcedido;}
{Ident} {lexeme=yytext(); row = yyline; C1 = yycolumn; return Identificador;}
{Id} {lexeme=yytext(); row = yyline; C1 = yycolumn; return Id;}
/* Operands & characters   */
{empty} {/*Ignore*/}
"=" {lexeme=yytext();row=yyline; C1=yycolumn;return igual;} 
"+" {lexeme=yytext();row=yyline; C1=yycolumn;return suma;}
"-" {lexeme=yytext();row=yyline; C1=yycolumn;return resta;}
"*" {lexeme=yytext();row=yyline; C1=yycolumn;return multiplicacion;}
"/" {lexeme=yytext();row=yyline; C1=yycolumn;return division;}
(,) {lexeme=yytext();row = yyline; C1 = yycolumn;  return coma;}
"." {lexeme=yytext();row = yyline; C1 = yycolumn;  return punto;}
"<" {lexeme=yytext();row = yyline; C1 = yycolumn;  return menor;}
"<=" {lexeme=yytext();row = yyline; C1 = yycolumn;  return menorigual;}
">" {lexeme=yytext();row = yyline; C1 = yycolumn;  return mayor;} 
">=" {lexeme=yytext();row = yyline; C1 = yycolumn;  return mayorigual;}
"=" {lexeme=yytext();row = yyline; C1 = yycolumn;  return assign;} 
"==" {lexeme=yytext();row = yyline; C1 = yycolumn;  return comparation;}
"<>" {lexeme=yytext();row = yyline; C1 = yycolumn;  return different;}
"&&" {lexeme=yytext();row = yyline; C1 = yycolumn;  return and;}
"||" {lexeme=yytext();row = yyline; C1 = yycolumn;  return or;} 
"!" {lexeme=yytext();row = yyline; C1 = yycolumn;  return exclamation;} 
";" {lexeme=yytext();row = yyline; C1 = yycolumn;  return semicolon;}
"[" {lexeme=yytext();row = yyline; C1 = yycolumn;  return corcheteO;}
"]" {lexeme=yytext();row = yyline; C1 = yycolumn;  return corcheteC;}
"(" {lexeme=yytext();row = yyline; C1 = yycolumn;  return parentesisO;}
")" {lexeme=yytext();row = yyline; C1 = yycolumn;  return parentesisC;}
"{" {lexeme=yytext();row = yyline; C1 = yycolumn;  return llaveO;}
"}" {lexeme=yytext();row = yyline; C1 = yycolumn;  return llaveC;}
"[]" {lexeme=yytext();row = yyline; C1 = yycolumn;  return corchetes;}
"()" {lexeme=yytext();row = yyline; C1 = yycolumn;  return parentesis;}
"{}" {lexeme=yytext();row = yyline; C1 = yycolumn;  return llaves;}
"@" {lexeme=yytext();row = yyline; C1 = yycolumn;  return at;}
"#" {lexeme=yytext();row = yyline; C1 = yycolumn;  return numeral;}
"##" {lexeme=yytext();row = yyline; C1 = yycolumn;  return dnumeral;}

{espacio} |
"--".* | 
"/*" ~"*/" | 
"/*" "*"+ "/" {/*Ignore*/}

"/*" .*|
"*/" .* {lin=yyline; return ErrorMultilinea;}


"'" ~"'" {lexeme=yytext(); col=yycolumn; lin=yyline; return Cadena;}
("'"([^'\r\n]*)) {lexeme=yytext(); lin=yyline; return ErrorApertura;}
{L}({L}|{D}){31,100} {lexeme=yytext(); lin=yyline; col=yycolumn; return IdentificadorOver;}
{L}({L}|{D}|{G})* {lexeme=yytext(); lin=yyline; col=yycolumn; return Identificador;}

{D}+ {lexeme=yytext(); lin=yyline; col=yycolumn; return Entero;}

{D}+{P}{D}* {lexeme=yytext(); lin=yyline; col=yycolumn; return Decimal;}

{D}+{P}{D}*("E"|"e"){S}?{D}* {lexeme=yytext(); lin=yyline; col=yycolumn; return Float;}

 . {lexeme=yytext(); lin=yyline; col=yycolumn; return ERROR;}